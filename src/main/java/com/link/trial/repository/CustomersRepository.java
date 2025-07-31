package com.link.trial.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.link.trial.entity.customers;

public interface CustomersRepository extends JpaRepository<customers, String> {
}
