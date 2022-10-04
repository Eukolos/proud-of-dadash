package com.eukolos.restaurant.repository;

import com.eukolos.restaurant.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, String> {
}
