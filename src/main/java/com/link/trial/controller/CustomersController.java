package com.link.trial.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.link.trial.entity.customers;
import com.link.trial.repository.CustomersRepository;
import com.link.trial.service.CustomerService;
import com.link.trial.service.OrderService;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomersController {

	private final CustomerService customersService;
	private final OrderService orderService;
    

    @Autowired
    public CustomersController(CustomerService customersService, OrderService orderService) {
        this.customersService = customersService;
        this.orderService = orderService;
       
    }
	

    
    @PostMapping
    public String addCustomer(
            @RequestParam String nid,
            @RequestParam String address,
            @RequestParam String fullName) {
        
    	return customersService.addCustomer(nid, address, fullName);
    }
    
    
    @DeleteMapping("{nid}")
    public String deleteCustomer(@RequestParam String nid) {
    	return customersService.deleteCustomer(nid);
    }

    @GetMapping
    public List<customers> getAllCustomers() {
    	 return customersService.getAllCustomers();
    }
    
    
    
    
    
    
    
    
    

}