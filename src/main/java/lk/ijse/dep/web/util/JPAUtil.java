package lk.ijse.dep.web.util;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.cfg.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

public class JPAUtil {

    static Logger logger = LoggerFactory.getLogger(JPAUtil.class);

private static EntityManagerFactory entityManagerFactory= buildEntityManagerFactory();

    private static EntityManagerFactory buildEntityManagerFactory()  {
        Properties properties= new Properties();

        try {
            properties.load(JPAUtil.class.getResourceAsStream("/application.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        properties.put(Environment.DATASOURCE,getDataSource());
        entityManagerFactory= Persistence.createEntityManagerFactory("dep-6",properties);
        return entityManagerFactory;

    }

    public static EntityManagerFactory getEntityManagerFactory(){
        return entityManagerFactory;
    }

    private static DataSource getDataSource(){
        BasicDataSource bds=null;

        Properties properties = new Properties();
        try {
            properties.load(JPAUtil.class.getResourceAsStream("/application.properties"));
            bds.setUsername("dbcp.connection.username");
            bds.setPassword("dbcp.connection.password");
            bds.setUrl("dbcp.connection.url");
            bds.setDriverClassName("dbcp.connection.driver_class");
            bds.setInitialSize(5);
            bds.setMaxTotal(10);
            return  bds;

        } catch (IOException e) {
            e.printStackTrace();
            logger.error("Error occured in connection settings");
        throw new RuntimeException(e);
        }


    }

}
