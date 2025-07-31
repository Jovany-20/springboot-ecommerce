package com.link.trial.service;

import com.link.trial.entity.customers;
import com.link.trial.repository.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomersRepository customersRepo;

    @Autowired
    public CustomerService(CustomersRepository customersRepo) {
        this.customersRepo = customersRepo;
    }

    public String addCustomer(String nid, String address, String fullName) {
        customers customer = new customers();
        customer.setNid(nid);
        customer.setAddress(address);
        customer.setFull_Name(fullName);
        customersRepo.save(customer);
        return "Added successfully.";
    }

    public String deleteCustomer(String nid) {
        if (customersRepo.existsById(nid)) {
            customersRepo.deleteById(nid);
            return "Customer with NID " + nid + " deleted successfully.";
        } else {
            return "Customer with NID " + nid + " not found.";
        }
    }

    public List<customers> getAllCustomers() {
        return customersRepo.findAll();
    }
    
    public boolean customerExists(String nid) {
        return customersRepo.existsById(nid);
    }
}