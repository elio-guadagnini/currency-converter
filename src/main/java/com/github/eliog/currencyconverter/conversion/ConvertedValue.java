package com.github.eliog.currencyconverter.conversion;

import lombok.Data;

@Data
public class ConvertedValue {

    private double convertedAmount;

    public ConvertedValue(){
        this.convertedAmount = 0;
    }

    // the name of get function is linked with the final JSON variable name

    public void calculateConversion(double amountToConvert, double conversionRate) {
        convertedAmount = amountToConvert * conversionRate;
    }
}
