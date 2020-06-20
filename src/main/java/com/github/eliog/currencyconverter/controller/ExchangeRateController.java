package com.github.eliog.currencyconverter.controller;

import com.github.eliog.currencyconverter.jsonentity.ExchangeRates;
import com.github.eliog.currencyconverter.dao.ExchangeRateRepository;
import com.github.eliog.currencyconverter.entity.*;
import com.github.eliog.currencyconverter.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExchangeRateController {

    @Autowired
    private ExchangeRateRepository rateRepository;
    
    @GetMapping("/rates")
    public List<ExchangeRate> findValues() {
        return rateRepository.findAll();
    }

    @GetMapping("/rates/{id}")
    public ResponseEntity<ExchangeRate> findValueById(@PathVariable(value = "id") Long currencyId) throws ResourceNotFoundException {
        ExchangeRate currency = rateRepository.findById(currencyId)
                .orElseThrow(() -> new ResourceNotFoundException("Rate not found with this id: " + currencyId));
        return ResponseEntity.ok().body(currency);
    }

    @PutMapping("/rates/{id}") // not useful for my backend service, it makes the service available from the frontend
    public ExchangeRate updateCurrencyRate(@PathVariable(value = "id") Long currencyId,
                                           // @Valid, in order to validate the constraints of my class,
                                           // which are expressed through other annotations
                                           @RequestBody ExchangeRates currencyRateRequest) throws ResourceNotFoundException {
        return rateRepository.findById(currencyId)
                .map(currency -> {
                    currency.setBtc(currencyRateRequest.getBtcExchange());
                    currency.setUsd(currencyRateRequest.getUsdExchange());
                    currency.setEur(currencyRateRequest.getEurExchange());
                    return rateRepository.save(currency);
                }).orElseThrow(() -> new ResourceNotFoundException("Rate not found with id " + currencyId));
    }

    @PostMapping("/rates")
    public ExchangeRate addCurrencyRate(@PathVariable Long currencyId,
                                        // @Valid
                                        @RequestBody ExchangeRates newCurrencyRate) {
        ExchangeRate tempCurrency = new ExchangeRate(currencyId, newCurrencyRate.getBtcExchange(),
                newCurrencyRate.getUsdExchange(), newCurrencyRate.getEurExchange());
        return rateRepository.save(tempCurrency);
    }
}
