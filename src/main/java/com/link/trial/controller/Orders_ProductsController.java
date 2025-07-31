package com.link.trial.controller;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.link.trial.DTO.OrdersProductsDTO;
import com.link.trial.entity.OrdersProductsId;
import com.link.trial.entity.Orders_Products;
import com.link.trial.entity.Product;
import com.link.trial.entity.orders;
import com.link.trial.repository.OrdersRepository;
import com.link.trial.repository.Orders_ProductsRepository;
import com.link.trial.repository.ProductRepository;
import com.link.trial.service.Order_Product_Service;

//@RestController
//@RequestMapping("/orders_products")
public class Orders_ProductsController {
	private final Order_Product_Service orderProductService;

    @Autowired
    public Orders_ProductsController(Order_Product_Service orderProductService) {
        this.orderProductService = orderProductService;
    }
    
    //@PostMapping("/add")
    public String addOrder(@RequestParam String orderId,
                           @RequestParam String productId,
                           @RequestParam int quantity) {
    	 return orderProductService.addOrder(orderId, productId, quantity);
    }

   // @GetMapping("/all")
    public List<OrdersProductsDTO> getAllOrdersProducts() {
    	return orderProductService.getAllOrdersProducts();
    }
    
    
    
    //@DeleteMapping("/delete")
    public String deleteOrder_Product(@RequestParam String orderId,@RequestParam String productId) {
    	return orderProductService.deleteOrder_Product(orderId, productId);
    }
}
