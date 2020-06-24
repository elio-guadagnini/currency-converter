package com.github.eliog.currencyconverter.conversion;

import lombok.Data;

@Data
public class ConvertedValue {

    private double convertedAmount;

    public ConvertedValue(){
        this.convertedAmount = 0;
    }

    public ConvertedValue(double amountToConvert, double conversionRate){
        convertedAmount = amountToConvert * conversionRate;
    }
}
