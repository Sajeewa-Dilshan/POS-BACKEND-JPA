package lk.ijse.dep.web.business;

import org.hibernate.Session;

import javax.persistence.EntityManager;

public interface SuperBO {

    public void setEntityManager(EntityManager entityManager) throws Exception;

}
