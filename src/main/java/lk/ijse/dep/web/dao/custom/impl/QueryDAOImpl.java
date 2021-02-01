package lk.ijse.dep.web.dao.custom.impl;

import lk.ijse.dep.web.dao.custom.QueryDAO;
import lk.ijse.dep.web.entity.CustomEntity;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class QueryDAOImpl implements QueryDAO {


    @Override
    public void setEntityManager(EntityManager entityManager) throws Exception {

    }

    @Override
    public List<CustomEntity> getOrderInfo(String customerId) throws Exception {
        return null;
    }
}
