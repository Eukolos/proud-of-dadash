package com.eukolos.restaurant.repository;

import com.eukolos.restaurant.model.Table;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TableRepository extends JpaRepository<Table, String> {
    Optional<Table> findByNumber(int s);
}
