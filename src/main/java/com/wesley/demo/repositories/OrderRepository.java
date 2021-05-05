package com.wesley.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wesley.demo.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
