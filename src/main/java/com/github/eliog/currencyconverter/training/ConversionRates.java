package com.github.eliog.currencyconverter.training;

import lombok.Data;

@Data
public class ConversionRates {

    private double btc;
    private double usd;
    private double eur;

    private double btcToUsd;
    private double usdToBtc;
    private double btcToEur;
    private double eurToBtc;
    private double usdToEur;
    private double eurToUsd;

    public ConversionRates(double btc, double usd, double eur) {
        this.btc = btc;
        this.usd = usd;
        this.eur = eur;

        btcToUsd = usd;
        usdToBtc = 1/usd;
        btcToEur = eur;
        eurToBtc = 1/eur;
        usdToEur = calculateUsdToEur();
        eurToUsd = calculateEurToUsd();
    }

    private double calculateUsdToEur() {
        return usdToBtc * btcToEur;
    }

    private double calculateEurToUsd() {
        return btcToUsd * eurToBtc;
    }
}
