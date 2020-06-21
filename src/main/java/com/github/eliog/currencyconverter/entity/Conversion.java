package com.github.eliog.currencyconverter.entity;

import lombok.Data;

@Data
public class Conversion {

    private String firstCurrency;
    private String secondCurrency;
    private double amount;

    public Conversion() {
    }
}
