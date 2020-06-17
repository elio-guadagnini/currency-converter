package com.github.eliog.currencyconverter.controller;

import com.github.eliog.currencyconverter.CurrencyConverterApplication;
import com.github.eliog.currencyconverter.entity.IncomingCurrencyValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CallRestService {

    private static final Logger log = LoggerFactory.getLogger(CurrencyConverterApplication.class);

    @Scheduled(fixedRate = 10000)
    private static void callRestService() {
        String url = "https://min-api.cryptocompare.com/data/price?fsym=BTC&tsyms=BTC,USD,EUR&api_key=aea23d02ccc29f1fbffb4d7ab65d41f8e32fc88bc3fa0fbecb35a4afc280a251";

        RestTemplate restTemplate = new RestTemplate();
        IncomingCurrencyValue incomingCurrencyValue = restTemplate.getForObject(url, IncomingCurrencyValue.class);
        log.info("second attempt: " + incomingCurrencyValue.toString());
    }
}
