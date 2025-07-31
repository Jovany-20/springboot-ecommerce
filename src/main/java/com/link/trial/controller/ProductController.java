package com.link.trial.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.link.trial.entity.Product;
import com.link.trial.repository.ProductRepository;
import com.link.trial.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

   
	private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }



	@PostMapping
    public String addProduct(
            @RequestParam String pid,
            @RequestParam String name,
            @RequestParam double price) {
		return productService.addProduct(pid, name, price);
    }
    


    @DeleteMapping("/{pid}")
    public String deleteProduct(@RequestParam String pid) {
    	return productService.deleteProduct(pid);
    }

    @GetMapping
    public List<Product> getAllProducts() {
    	 return productService.getAllProducts();
    }
}