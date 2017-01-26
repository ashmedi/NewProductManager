
package com.mycompany.newproductmanager.mb;

import com.mycompany.newproductmanager.ejb.ProductEjb;
import com.mycompany.newproductmanager.entity.Product;
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
@ManagedBean(name = "products", eager = true)
@SessionScoped
public class ProductsBean {
    
    @EJB
    private ProductEjb productEjb;    
    
    public DataModel getAllProducts() {
        List<Product> rows = productEjb.getAllProducts();
        return new ListDataModel(rows);
    }
}
