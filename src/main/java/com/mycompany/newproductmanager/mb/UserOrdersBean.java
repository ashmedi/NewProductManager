package com.mycompany.newproductmanager.mb;

import com.mycompany.newproductmanager.ejb.ProductEjb;
import com.mycompany.newproductmanager.ejb.UserOrderEjb;
import com.mycompany.newproductmanager.entity.Product;
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
    @EJB
    private ProductEjb productEjb;
    private UserOrder order = new UserOrder();
    private UserOrderItem orderItem = new UserOrderItem();
    private Product product = new Product();
    
    public UserOrder getOrder() {
        return order;
    }
    
    public UserOrderItem getOrderItem() {
        return orderItem;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    
    public DataModel getCurrentOrderItems() {
        return new CollectionDataModel(order.getItems());
    }
    
    public void addOrderItem() {
        if (order.getItems() == null) {
            order.setItems(new ArrayList<>());
        }
        orderItem.setProduct(product);
        addItemsToOrder();        
        orderItem.setUserOrder(order);
        orderItem = new UserOrderItem();
        product = new Product();
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
    
    public UserOrder getOrder(Long id) {
        return userOrderEjb.getById(id);
    }
    
    public List<Product> getProducts() {
        List<Product> rows = productEjb.getAllProducts();
        return rows;
    }

    private void addItemsToOrder() {
        boolean itemOfGivenTypeExists = false;
        for (UserOrderItem item : order.getItems()) {
            if (item.getProduct().getId().equals(orderItem.getProduct().getId())) {
                item.setQuantity(item.getQuantity() + orderItem.getQuantity());
                itemOfGivenTypeExists = true;
            }
        }
        if (!itemOfGivenTypeExists) {
            order.getItems().add(orderItem);
        }
    }
}
