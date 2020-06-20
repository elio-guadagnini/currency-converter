package com.github.eliog.currencyconverter.training;

import com.github.eliog.currencyconverter.dao.AccountRepository;
import com.github.eliog.currencyconverter.entity.Account;
import com.github.eliog.currencyconverter.entity.ExchangeRate;
import com.github.eliog.currencyconverter.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    @GetMapping("/accounts")
    public List<Account> findValues() {
        return accountRepository.findAll();
    }

    @GetMapping("/accounts/{id}")
    public ResponseEntity<Account> findValueById(@PathVariable(value = "id") Long accountId) throws ResourceNotFoundException {
        Account acc = accountRepository.findById(accountId)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found with this id: " + accountId));
        return ResponseEntity.ok().body(acc);
    }

}
