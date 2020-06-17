package com.github.eliog.currencyconverter.dao;

import com.github.eliog.currencyconverter.entity.ExportingCurrencyValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExportingCurrencyValueRepository extends JpaRepository<ExportingCurrencyValue, Long> {

    @Override
    List<ExportingCurrencyValue> findAll();
}
