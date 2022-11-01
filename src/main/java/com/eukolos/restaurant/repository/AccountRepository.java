package com.eukolos.restaurant.repository;

import com.eukolos.restaurant.model.Account;
import com.eukolos.restaurant.model.AccountStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface AccountRepository extends JpaRepository<Account, String> {
    List<Account> findByIsActive(boolean isTrue);
    List<Account> findByTableNumber(int tableRequest);
    Optional<Account> findById(String accountId);

    List<Account> findByStatus(AccountStatus status);

    Optional<Account> findByIdAndIsActive(String id, Boolean isActive);
}

