package com.link.trial.service;

import com.link.trial.entity.Product;
import com.link.trial.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepo;

    @Autowired
    public ProductService(ProductRepository productRepo) {
        this.productRepo = productRepo;
    }

    public String addProduct(String pid, String name, double price) {
        Product product = new Product(pid, name, price);
        productRepo.save(product);
        return "Added successfully.";
    }

    public String deleteProduct(String pid) {
        if (productRepo.existsById(pid)) {
            productRepo.deleteById(pid);
            return "Product with PID " + pid + " deleted successfully.";
        } else {
            return "Product with PID " + pid + " not found.";
        }
    }

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }
}
