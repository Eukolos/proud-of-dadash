package com.eukolos.restaurant.repository;

import com.eukolos.restaurant.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository  extends JpaRepository<Product, String> {
}
