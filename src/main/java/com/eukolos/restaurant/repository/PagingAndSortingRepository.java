package com.eukolos.restaurant.repository;

import com.eukolos.restaurant.model.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface PagingAndSortingRepository < T, ID > extends CrudRepository< T, ID > {

    Slice<Account> findAll(Pageable pageable);
}