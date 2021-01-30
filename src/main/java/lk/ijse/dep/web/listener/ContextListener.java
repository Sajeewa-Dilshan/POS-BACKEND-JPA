package lk.ijse.dep.web.listener;

import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.*;

@WebListener
public class ContextListener implements ServletContextListener {

    org.slf4j.Logger logger = LoggerFactory.getLogger(ContextListener.class);

    public ContextListener() {

    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        Properties prop = new Properties();
        System.out.println("Connection pool is being initialized...!");
        try {
            prop.load(this.getClass().getResourceAsStream("/application.properties"));
            BasicDataSource bds = new BasicDataSource();
            bds.setUsername(prop.getProperty("dbcp.connection.username"));
            bds.setPassword(prop.getProperty("dbcp.connection.password"));
            bds.setUrl(prop.getProperty("dbcp.connection.url"));
            bds.setDriverClassName(prop.getProperty("dbcp.connection.driver_class"));
            bds.setInitialSize(5);
            prop.put("hibernate.connection.datasource",bds);
            sce.getServletContext()
                    .setAttribute("emf",
                            Persistence.createEntityManagerFactory("dep-6", prop));


            String logFilePath;
            if (prop.getProperty("app.log_dir")!= null){
                logFilePath = prop.getProperty("app.log_dir") + "/back-end.log";
            }else{
                logFilePath = System.getProperty("catalina.home") + "/logs/back-end.log";
            }
            FileHandler fileHandler = new FileHandler(logFilePath, true);
            fileHandler.setFormatter(new SimpleFormatter());
            fileHandler.setLevel(Level.INFO);
            Logger.getLogger("").addHandler(fileHandler);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        EntityManagerFactory emf = (EntityManagerFactory) sce.getServletContext().getAttribute("emf");
        emf.close();
    }
}
