package com.github.eliog.currencyconverter.dao;

import com.github.eliog.currencyconverter.entity.ExchangeRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, Long> {

    @Override
    List<ExchangeRate> findAll();
}
