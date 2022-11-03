package com.eukolos.restaurant.repository;

import com.eukolos.restaurant.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository  extends JpaRepository<Product, String> {
    List<Product> findAllByUniquee(boolean uniquee);
}
