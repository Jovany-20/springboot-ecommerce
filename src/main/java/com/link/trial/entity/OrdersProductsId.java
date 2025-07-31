package com.link.trial.entity;


import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class OrdersProductsId  {
    @Column(name = "oid", length = 4, columnDefinition = "CHAR(4)")
    private String oid;

    @Column(name = "pid", length = 4, columnDefinition = "CHAR(4)")
    private String pid;

    
    // Override equals() and hashCode() for composite key comparison
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        OrdersProductsId that = (OrdersProductsId) o;
        
        if (!oid.equals(that.oid)) return false;
        return pid.equals(that.pid);
    }

    @Override
    public int hashCode() {
        int result = oid.hashCode();
        result = 31 * result + pid.hashCode();
        return result;
    }
}