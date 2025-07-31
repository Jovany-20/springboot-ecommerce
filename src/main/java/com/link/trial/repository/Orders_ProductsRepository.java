package com.link.trial.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.link.trial.entity.OrdersProductsId;
import com.link.trial.entity.Orders_Products;

public interface Orders_ProductsRepository extends JpaRepository<Orders_Products, OrdersProductsId> {

}
