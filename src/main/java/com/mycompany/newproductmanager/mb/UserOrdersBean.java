package com.mycompany.newproductmanager.mb;

import com.mycompany.newproductmanager.ejb.UserOrderEjb;
import com.mycompany.newproductmanager.entity.UserOrder;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
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
    
    public void addOrder() {
        userOrderEjb.addOrder();        
    }
    
    public UserOrder getOrder() {
        return order;
    }
    
    public String saveOrder() {
        userOrderEjb.saveOrder(order);
        order = new UserOrder();
        return "index?faces-redirect=true";
    }
    
    public DataModel getAllOrders() {
        List<UserOrder> rows = userOrderEjb.getAllOrders();
        System.out.println(rows.size());
        rows.stream().forEach(o -> System.out.println(o));
        return new ListDataModel(rows);
    }
}
