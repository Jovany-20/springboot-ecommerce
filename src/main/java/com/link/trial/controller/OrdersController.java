package com.link.trial.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.link.trial.DTO.OrderDTO;
import com.link.trial.entity.customers;
import com.link.trial.entity.orders;
import com.link.trial.repository.CustomersRepository;
import com.link.trial.repository.OrdersRepository;
import com.link.trial.service.CustomerService;
import com.link.trial.service.OrderService;
import com.link.trial.service.Order_Product_Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/orders")
public class OrdersController {

	private final OrderService orderService;
	private final CustomerService customersService;
	private final Order_Product_Service orderProductService;
    @Autowired
    public OrdersController(OrderService orderService, CustomerService customersService, Order_Product_Service orderProductService) {
        this.orderService = orderService;
		this.customersService = customersService;
		this.orderProductService = orderProductService;
    }


  
//    @PostMapping
//    public String addOrder(@RequestParam String orderId,
//                           @RequestParam String payment_method,
//                           @RequestParam String nid) {
//    	return orderService.addOrder(orderId, payment_method, nid);
//    }

   
    @GetMapping
    public List<OrderDTO> getAllOrders() {
    	return orderService.getAllOrders();
    }
    
    
    
    @DeleteMapping("/{orderId}")
    public String deleteOrder(@RequestParam String orderId) {
    	return orderService.deleteOrder(orderId);
    }
    
    @PostMapping()
    public String placeOrder(@RequestParam String nid,
                             @RequestParam String orderId,
                             @RequestParam String paymentMethod,
                             @RequestParam List<String> products) {
    	
    	
    	
        if ( !customersService.customerExists(nid)) {
            return "Failed to place order: Customer with NID " + nid + " does not exist.";
        }
        Map<String, Integer> productMap = new HashMap<>();
        try {
            for (String entry : products) {
                String[] parts = entry.split(":");
                if (parts.length != 2) return "Invalid product format: " + entry;
                String productId = parts[0].trim();
                int quantity = Integer.parseInt(parts[1].trim());
                productMap.put(productId, quantity);
            }
        } catch (Exception e) {
            return "Failed to parse products.";
        }
        
        
        String orderResult = orderService.addOrder(orderId, paymentMethod, nid);
        if (orderResult.contains("not found") || orderResult.contains("Failed")) {
            return "Failed to place order: " + orderResult;
        }
        
        
        for (Map.Entry<String, Integer> entry : productMap.entrySet()) {
            String check = orderProductService.addOrder(orderId, entry.getKey(), entry.getValue());
            if (check.contains("Product") || check.contains("Order")) {
            	orderService.deleteOrder(orderId);
                return "Failed to place order: " + check;
            }
        }

        

        
        StringBuilder result = new StringBuilder(orderResult + "\n");
        for (Map.Entry<String, Integer> entry : productMap.entrySet()) {
            String res = orderProductService.addOrder(orderId, entry.getKey(), entry.getValue());
            result.append(res).append("\n");
        }

        return result.toString();
    }

    
}