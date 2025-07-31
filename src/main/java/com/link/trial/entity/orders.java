package com.link.trial.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class orders {

    @Id
    
    @Column(name = "OID" ,length = 4, columnDefinition = "CHAR(4)")
    private String oid;
    

    @Column(name = "payment_method", length =30)
    private String payment_method;
    
    
    @ManyToOne
    @JoinColumn(name = "nid", referencedColumnName = "nid")
    @JsonBackReference
    private customers customer;
    
    
	

   
}