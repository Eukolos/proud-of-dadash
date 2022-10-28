package com.eukolos.restaurant.repository;

import com.eukolos.restaurant.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, String> {
    List<Account> findByIsActive(boolean isTrue);
    List<Account> findByTableNumber(int tableRequest);
    Optional<Account> findById(String accountId);
}

