package com.mycompany.newproductmanager.ejb;

import com.mycompany.newproductmanager.entity.UserOrder;
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
    public void saveOrder(UserOrder order) {        
        em.persist(order);
    }

    @Transactional
    public List<UserOrder> getAllOrders() {
        Query query = em.createNamedQuery("GetAllOrders");
        List<UserOrder> all = query.getResultList();
        return all;

    }
}
