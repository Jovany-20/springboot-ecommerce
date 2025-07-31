package com.link.trial.entity;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "orders_products")
public class Orders_Products {
	@EmbeddedId
    private OrdersProductsId id;

	
	@Column (name = "quantity")
	int quantity;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @MapsId("oid")
    @JoinColumn(name = "oid", referencedColumnName = "oid", insertable = false, updatable = false)
    @JsonBackReference
    private orders order;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("pid")
    @JoinColumn(name = "pid", referencedColumnName = "pid", insertable = false, updatable = false)
    @JsonBackReference
    private Product product;

	
	
	
	
}
