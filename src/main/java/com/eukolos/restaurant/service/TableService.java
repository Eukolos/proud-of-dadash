package com.eukolos.restaurant.service;

import com.eukolos.restaurant.dto.TableDto;
import com.eukolos.restaurant.model.Table;
import com.eukolos.restaurant.repository.TableRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TableService {
    private final TableRepository repository;

    public TableService(TableRepository repository) {
        this.repository = repository;
    }

    public ResponseEntity<Table> tableNumber(int tableNumber) {
        Optional<Table> table = repository.findByNumber(tableNumber);
        if (table.isPresent()) {
            return ResponseEntity.ok(table.get());
        }
        return null;
    }
}
