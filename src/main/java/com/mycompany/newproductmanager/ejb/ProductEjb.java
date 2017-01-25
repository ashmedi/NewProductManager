package com.mycompany.newproductmanager.ejb;

import com.mycompany.newproductmanager.entity.Product;
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
public class ProductEjb {
    
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public List<Product> getAllProducts() {
        Query query = em.createNamedQuery("GetAllProducts");
        List<Product> all = query.getResultList();
        return all;
        
    }
}
