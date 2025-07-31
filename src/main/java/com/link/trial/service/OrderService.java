package com.link.trial.service;

import com.link.trial.DTO.OrderDTO;
import com.link.trial.entity.customers;
import com.link.trial.entity.orders;
import com.link.trial.repository.CustomersRepository;
import com.link.trial.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final OrdersRepository ordersRepository;
    private final CustomersRepository customersRepository;

    @Autowired
    public OrderService(OrdersRepository ordersRepository, CustomersRepository customersRepository) {
        this.ordersRepository = ordersRepository;
        this.customersRepository = customersRepository;
    }

    public String addOrder(String orderId, String payment_method, String nid) {
        Optional<customers> customerOpt = customersRepository.findById(nid);
        if (!customerOpt.isPresent()) {
            return "Customer with NID " + nid + " does not exist.";
        }

        orders order = new orders();
        order.setOid(orderId);
        order.setPayment_method(payment_method);
        order.setCustomer(customerOpt.get());

        ordersRepository.save(order);
        return "Order added successfully.";
    }

    public List<OrderDTO> getAllOrders() {
        return ordersRepository.findAll().stream()
            .map(order -> new OrderDTO(
                order.getOid(), 
                order.getPayment_method(), 
                order.getCustomer().getNid()))
            .collect(Collectors.toList());
    }

    public String deleteOrder(String orderId) {
        if (!ordersRepository.existsById(orderId)) {
            return "Order ID " + orderId + " not found.";
        }

        ordersRepository.deleteById(orderId);
        return "Order deleted successfully.";
    }
}
