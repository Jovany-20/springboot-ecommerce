package com.link.trial.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.link.trial.DTO.OrdersProductsDTO;
import com.link.trial.entity.OrdersProductsId;
import com.link.trial.entity.OrdersProducts;
import com.link.trial.entity.Product;
import com.link.trial.entity.orders;
import com.link.trial.repository.OrdersRepository;
import com.link.trial.repository.OrdersProductsRepository;
import com.link.trial.repository.ProductRepository;

@Service
public class OrderProductService {

    private final OrdersProductsRepository OPRepo;
    private final OrdersRepository ordersRepository;
    private final ProductRepository productRepository;

    @Autowired
    public OrderProductService(
            OrdersProductsRepository OPRepo,
            OrdersRepository ordersRepository,
            ProductRepository productRepository) {
        this.OPRepo = OPRepo;
        this.ordersRepository = ordersRepository;
        this.productRepository = productRepository;
    }

    public String addOrder(String orderId, String productId, int quantity) {
        Optional<orders> orderOpt = ordersRepository.findById(orderId);
        Optional<Product> productOpt = productRepository.findById(productId);
        if (!orderOpt.isPresent() || !productOpt.isPresent()) {
            return "Order or Product is not available";
        }

        OrdersProductsId id = new OrdersProductsId(orderId, productId);
        OrdersProducts orderProduct = new OrdersProducts(id, quantity, orderOpt.get(), productOpt.get());

        OPRepo.save(orderProduct);
        return "Added successfully.";
    }

    public List<OrdersProductsDTO> getAllOrdersProducts() {
        return OPRepo.findAll().stream()
                .map(op -> new OrdersProductsDTO(
                        op.getOrder().getOid(),
                        op.getProduct().getPid(),
                        op.getQuantity()))
                .collect(Collectors.toList());
    }

    public String deleteOrder_Product(String orderId, String productId) {
        OrdersProductsId id = new OrdersProductsId(orderId, productId);
        if (!OPRepo.existsById(id)) {
            return "Order_Product not found.";
        }

        OPRepo.deleteById(id);
        return "Order_Product deleted successfully.";
    }
}
