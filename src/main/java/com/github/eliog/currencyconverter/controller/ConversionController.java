package com.github.eliog.currencyconverter.controller;

import com.github.eliog.currencyconverter.conversion.ConversionRates;
import com.github.eliog.currencyconverter.conversion.ConvertedValue;
import com.github.eliog.currencyconverter.dao.ExchangeRateRepository;
import com.github.eliog.currencyconverter.entity.*;
import com.github.eliog.currencyconverter.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ConversionController {

    @Autowired
    private ExchangeRateRepository rateRepository;

    @GetMapping("/conversion")
    public String conversionForm(Model model) {
        model.addAttribute("conversion", new Conversion());
        return "conversion";
    }

    @PostMapping("/conversion")
    public ResponseEntity<ConvertedValue> conversionSubmit(@ModelAttribute Conversion conversion) {
        ExchangeRate currency = rateRepository.findById((long) 11)
                .orElseThrow(() -> new ResourceNotFoundException("Rate not found with this id: " + 11));
        ConversionRates conversionRates = new ConversionRates(currency.getBtc(), currency.getUsd(), currency.getEur());

        ConvertedValue conversionValue = new ConvertedValue();
        switch (conversion.getFirstCurrency().toLowerCase()+conversion.getSecondCurrency().toLowerCase()) {
            case "btcusd":
                conversionValue.calculateConversion(conversion.getAmount(), conversionRates.getBtcToUsd());
                break;
            case "usdbtc":
                conversionValue.calculateConversion(conversion.getAmount(), conversionRates.getUsdToBtc());
                break;
            case "btceur":
                conversionValue.calculateConversion(conversion.getAmount(), conversionRates.getBtcToEur());
                break;
            case "eurbtc":
                conversionValue.calculateConversion(conversion.getAmount(), conversionRates.getEurToBtc());
                break;
            case "usdeur":
                conversionValue.calculateConversion(conversion.getAmount(), conversionRates.getUsdToEur());
                break;
            case "eurusd":
                conversionValue.calculateConversion(conversion.getAmount(), conversionRates.getEurToUsd());
                break;
            default:
                System.out.println("None of the provided operations was selected for: "
                        +conversion.getFirstCurrency()+" "+conversion.getSecondCurrency());
                break;
        }
        return ResponseEntity.ok().body(conversionValue);
    }
}
