package com.github.eliog.currencyconverter.conversion;

import java.util.HashMap;

public class ConversionRates {

    private final HashMap<String, Double> conversionRates = new HashMap<>();

    public ConversionRates(double btc, double usd, double eur) {
        conversionRates.put("btcusd", usd);
        conversionRates.put("usdbtc", 1/usd);
        conversionRates.put("btceur", eur);
        conversionRates.put("eurbtc", 1/eur);
        conversionRates.put("usdeur", eur/usd);
        conversionRates.put("eurusd", usd/eur);
    }

    public void add(String key, Double value) {
        conversionRates.put(key, value);
    }

    public Double get(String key) {
        if(conversionRates.containsKey(key))
            return conversionRates.get(key);
        return 0.0;
    }
}
