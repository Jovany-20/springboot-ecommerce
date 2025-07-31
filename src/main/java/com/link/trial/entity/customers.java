package com.link.trial.entity;

import java.util.List;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customers")
public class customers {

    @Id
    
    @Column(name = "NID" ,length = 10, columnDefinition = "CHAR(10)")
    private String nid;

    @Column(name = "Address", length = 30)
    private String Address;
    @Column(name = "Full_Name", length =30)
    private String Full_Name;

    

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    @JsonManagedReference
    
    private List<orders> orders;



//	public String getNid() {
//		return nid;
//	}
//
//
//
//	public void setNid(String nid) {
//		this.nid = nid;
//	}
//
//
//
//	public String getAddress() {
//		return Address;
//	}
//
//
//
//	public void setAddress(String address) {
//		Address = address;
//	}
//
//
//
//	public String getFull_Name() {
//		return Full_Name;
//	}
//
//
//
//	public void setFull_Name(String full_Name) {
//		Full_Name = full_Name;
//	}
//
//
//
//	public List<orders> getOrders() {
//		return orders;
//	}
//
//
//
//	public void setOrders(List<orders> orders) {
//		this.orders = orders;
//	}
//	
    
   
}
