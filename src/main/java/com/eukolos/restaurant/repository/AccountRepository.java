package com.eukolos.restaurant.repository;

import com.eukolos.restaurant.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {
    Optional<Account> findByIsActive(Boolean isTrue);
}
