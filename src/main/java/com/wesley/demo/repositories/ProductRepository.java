package com.wesley.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wesley.demo.entities.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {


}
