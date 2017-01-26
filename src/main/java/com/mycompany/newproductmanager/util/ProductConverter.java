package com.mycompany.newproductmanager.util;

import com.mycompany.newproductmanager.ejb.ProductEjb;
import com.mycompany.newproductmanager.entity.Product;
import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author jl186052
 */
@Stateless
@FacesConverter("productConverter")
public class ProductConverter implements Converter {

    @EJB
    private ProductEjb productEjb;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null && value.trim().length() > 0) {
            return productEjb.getById(Long.valueOf(value));
        } else {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null && !value.equals("")) {
            Product product = (Product) value;
            if (product.getId() != null) {
                return product.getId().toString();
            } else {
                return null;
            }
        } else {
            return null;
        }
    }
}
