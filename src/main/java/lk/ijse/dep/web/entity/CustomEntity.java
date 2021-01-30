package lk.ijse.dep.web.entity;

import java.math.BigDecimal;
import java.util.Date;

public class CustomEntity implements SuperEntity{

    private String customerId;
    private String customerName;
    private String orderId;
    private Date orderDate;
    private BigDecimal orderTotal;

    public CustomEntity() {
    }

    public CustomEntity(String customerId, String customerName, String orderId, Date orderDate, BigDecimal orderTotal) {
        this.setCustomerId(customerId);
        this.setCustomerName(customerName);
        this.setOrderId(orderId);
        this.setOrderDate(orderDate);
        this.setOrderTotal(orderTotal);
    }


    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public BigDecimal getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(BigDecimal orderTotal) {
        this.orderTotal = orderTotal;
    }
}
