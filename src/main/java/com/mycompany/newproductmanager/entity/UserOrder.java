package com.mycompany.newproductmanager.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author jl186052
 */
@Entity
@NamedQueries({
@NamedQuery(name="GetAllOrders",
    query="SELECT o FROM UserOrder o")          
})
public class UserOrder implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    @OneToMany(mappedBy = "userOrder", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Collection<UserOrderItem> items;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Collection<UserOrderItem> getItems() {
        return items;
    }

    public void setItems(Collection<UserOrderItem> items) {
        this.items = items;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.id);
        hash = 83 * hash + Objects.hashCode(this.username);
        hash = 83 * hash + Objects.hashCode(this.items);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UserOrder other = (UserOrder) obj;
        return true;
    }

    @Override
    public String toString() {
        return "UserOrder{" + "id=" + id + ", username=" + username + '}';
    }
        
}
