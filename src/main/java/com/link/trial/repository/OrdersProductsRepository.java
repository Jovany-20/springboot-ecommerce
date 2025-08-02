package com.link.trial.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.link.trial.entity.OrdersProducts;
import com.link.trial.entity.OrdersProductsId;
import com.link.trial.entity.OrdersProducts;

public interface OrdersProductsRepository extends JpaRepository<OrdersProducts, OrdersProductsId> {

}
