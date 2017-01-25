package com.mycompany.newproductmanager.mb;

import com.mycompany.newproductmanager.ejb.UserOrderEjb;
import com.mycompany.newproductmanager.entity.UserOrder;
import com.mycompany.newproductmanager.entity.UserOrderItem;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.CollectionDataModel;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author jl186052
 */
@ManagedBean(name = "orders", eager = true)
@SessionScoped
public class UserOrdersBean {
    
    @EJB
    private UserOrderEjb userOrderEjb;    
    private UserOrder order = new UserOrder();
    private UserOrderItem orderItem = new UserOrderItem();
    
    public void addOrder() {
        userOrderEjb.addOrder();        
    }
    
    public UserOrder getOrder() {
        return order;
    }
    
    public UserOrderItem getOrderItem() {
        return orderItem;
    }
    
    public DataModel getCurrentOrderItems() {
        return new CollectionDataModel(order.getItems());
    }
    
    public void addOrderItem() {
        if (order.getItems() == null) {
            order.setItems(new ArrayList<>());
        }
        order.getItems().add(orderItem);
        orderItem.setUserOrder(order);
        orderItem = new UserOrderItem();
    }
    
    public String saveOrder() {
        userOrderEjb.saveOrder(order);
        order = new UserOrder();
        orderItem = new UserOrderItem();
        return "index?faces-redirect=true";
    }
    
    public DataModel getAllOrders() {
        List<UserOrder> rows = userOrderEjb.getAllOrders();
        return new ListDataModel(rows);
    }
}
