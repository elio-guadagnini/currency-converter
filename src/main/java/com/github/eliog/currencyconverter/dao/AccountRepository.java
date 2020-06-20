package com.github.eliog.currencyconverter.dao;

import com.github.eliog.currencyconverter.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Account findByUsername(String username);

    @Override
    List<Account> findAll();
}
