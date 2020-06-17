package com.github.eliog.currencyconverter.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IncomingCurrencyValue {

    private double btc;
    private double usd;
    private double eur;

    public IncomingCurrencyValue() {
    }

    @JsonProperty("BTC")
    public double getBtcExchange() { return this.btc; }

    @JsonProperty("BTC")
    public void setBtcExchange(double btc) {
        this.btc = btc;
    }

    @JsonProperty("USD")
    public double getUsdExchange() {
        return this.usd;
    }

    @JsonProperty("USD")
    public void setUsdExchange(double usd) {
        this.usd = usd;
    }

    @JsonProperty("EUR")
    public double getEurExchange() {
        return this.eur;
    }

    @JsonProperty("EUR")
    public void setEurExchange(double eur) {
        this.eur = eur;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "id=" + "btc" +
                ", quote='" + btc + '\'' +
                ", id=" + "usd" +
                ", quote='" + usd + '\'' +
                ", id=" + "eur" +
                ", quote='" + eur + '\'' +
                '}';
    }
}
