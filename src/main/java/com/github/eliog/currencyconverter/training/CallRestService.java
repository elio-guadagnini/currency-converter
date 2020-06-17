package com.github.eliog.currencyconverter.training;

import com.github.eliog.currencyconverter.CurrencyConverterApplication;
import com.github.eliog.currencyconverter.entity.IncomingCurrencyValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CallRestService implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(CurrencyConverterApplication.class);

    private static void callRestService() {
        try {
            String url = "https://min-api.cryptocompare.com/data/price?fsym=BTC&tsyms=BTC,USD,EUR&api_key=aea23d02ccc29f1fbffb4d7ab65d41f8e32fc88bc3fa0fbecb35a4afc280a251";

            RestTemplate restTemplate = new RestTemplate();
            IncomingCurrencyValue incomingCurrencyValue = restTemplate.getForObject(url, IncomingCurrencyValue.class);
            log.info(incomingCurrencyValue.toString());
        } catch(NullPointerException e) {
            log.info("Unexpected Error consuming the RESTful service");
        }
    }

    // @Scheduled(fixedRate = 10000) // it returns error, i guess i cannot overrride and schedule a task together
    // or it doesn't make any sense.
    @Override
    public void run(String... args) throws Exception {
        try {
            callRestService();
        } catch(Exception e) {
            throw new Exception();
        }
    }
}
