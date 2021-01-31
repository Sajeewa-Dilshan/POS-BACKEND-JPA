package lk.ijse.dep.web.util;

import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManagerFactory;
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

    }

    public static EntityManagerFactory getEntityManagerFactory(){
        return entityManagerFactory;
    }

    private static DataSource getDataSource(){
        BasicDataSource bds=null;

        Properties properties = new Properties();
        try {
            properties.load(JPAUtil.class.getResourceAsStream("/application.properties"));
            bds.setUsername();
            bds.setPassword();
            bds.setUrl();
            bds.setDriverClassName();
            bds.setInitialSize();
            bds.setMaxTotal();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
