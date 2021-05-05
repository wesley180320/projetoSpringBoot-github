package com.wesley.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wesley.demo.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

}
