package com.link.trial.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.link.trial.entity.orders;
public interface OrdersRepository extends JpaRepository<orders, String> {

}
