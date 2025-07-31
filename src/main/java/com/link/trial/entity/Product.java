package com.link.trial.entity;



import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {

    @Id
    
    @Column(name = "PID" ,length = 4, columnDefinition = "CHAR(4)")
    private String pid;

    @Column(name = "P_Name", length = 30)
    private String name;
    @Column(name = "price")
    private double price;

    

    

   
}

