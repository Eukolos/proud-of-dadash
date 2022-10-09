package com.eukolos.restaurant.repository;

import com.eukolos.restaurant.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository  extends JpaRepository<Product, String> {
    Optional<Product> findById(String id);
}
