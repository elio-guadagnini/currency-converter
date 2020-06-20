package com.github.eliog.currencyconverter.controller;

import com.github.eliog.currencyconverter.entity.AccountPrincipal;
import com.github.eliog.currencyconverter.dao.AccountRepository;
import com.github.eliog.currencyconverter.entity.Account;
import com.github.eliog.currencyconverter.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        Account acc = accountRepository.findByUsername(username);

        // if I increase here, it gets much longer
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(6);
        acc.setPassword(encoder.encode(acc.getPassword()));

        if (acc == null) {
            throw new ResourceNotFoundException("Username not found: "+username);
        }
        return new AccountPrincipal(acc);
    }
}