package com.mycompany.newproductmanager.ejb;

import com.mycompany.newproductmanager.entity.Product;
import com.mycompany.newproductmanager.entity.UserOrder;
import com.mycompany.newproductmanager.entity.UserOrderItem;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

/**
 *
 * @author jl186052
 */
@Stateless
public class UserOrderEjb {
    
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void addOrder() {
        Query query = em.createNamedQuery("GetAllProducts");
        List<Product> products = query.getResultList();
        
        
        UserOrder uo = new UserOrder();
        uo.setUsername("wiesiek@czesiek.pl");
        List<UserOrderItem> items = new ArrayList<>();
        UserOrderItem item = new UserOrderItem();
        item.setQuantity(666);
        item.setUserOrder(uo);
        item.setProduct(products.get(0));
        items.add(item);
        uo.setItems(items);
        em.persist(uo);
    }
    
    @Transactional
    public void saveOrder(UserOrder order) {
        Query query = em.createNamedQuery("GetAllProducts");
        List<Product> products = query.getResultList();
        
        
        List<UserOrderItem> items = new ArrayList<>();
        UserOrderItem item = new UserOrderItem();
        item.setQuantity(666);
        item.setUserOrder(order);
        item.setProduct(products.get(0));
        items.add(item);
        order.setItems(items);
        em.persist(order);
    }
    
    @Transactional
    public List<UserOrder> getAllOrders() {        
        Query query = em.createNamedQuery("GetAllOrders");
        List<UserOrder> all = query.getResultList();
        return all;
        
    }
}
