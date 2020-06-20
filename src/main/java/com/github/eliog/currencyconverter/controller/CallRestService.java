package com.github.eliog.currencyconverter.controller;

import com.github.eliog.currencyconverter.CurrencyConverterApplication;
import com.github.eliog.currencyconverter.jsonentity.ExchangeRates;
import com.github.eliog.currencyconverter.exception.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component // or @Service
public class CallRestService {

    private static final Logger log = LoggerFactory.getLogger(CurrencyConverterApplication.class);

    @Autowired
    private ExchangeRateController firstService;

    @Scheduled(fixedRate = 10000)
    private void callRestService() {
        String url = "https://min-api.cryptocompare.com/data/price?fsym=BTC&tsyms=BTC,USD,EUR&api_key=aea23d02ccc29f1fbffb4d7ab65d41f8e32fc88bc3fa0fbecb35a4afc280a251";

        RestTemplate restTemplate = new RestTemplate();
        ExchangeRates incomingCurrencyValue = restTemplate.getForObject(url, ExchangeRates.class);
//        log.info("second attempt: " + incomingCurrencyValue.toString());

        try {
            firstService.updateCurrencyRate((long) 11, incomingCurrencyValue);
        } catch(ResourceNotFoundException e) {
            firstService.addCurrencyRate((long) 11, incomingCurrencyValue);
        }
    }
}
