package com.github.eliog.currencyconverter.conversion;

public class ConvertedValue {

    private double convertedAmount;

    public ConvertedValue(){
        this.convertedAmount = 0;
    }

    // the name of this function is linked with the final JSON variable name
    public double getConvertedAmount() {
        return convertedAmount;
    }

    public void setConvertedAmount(double convertedAmount) {
        this.convertedAmount = convertedAmount;
    }

    public void calculateConversion(double amountToConvert, double conversionRate) {
        convertedAmount = amountToConvert * conversionRate;
    }
}
