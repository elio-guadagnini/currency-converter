package com.github.eliog.currencyconverter.controller;

import com.github.eliog.currencyconverter.dao.ExportingCurrencyValueRepository;
import com.github.eliog.currencyconverter.entity.ExportingCurrencyValue;
import com.github.eliog.currencyconverter.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExportingCurrencyValueController {

    @Autowired
    private ExportingCurrencyValueRepository valueRepository;

    @GetMapping("/showValues")
    public List<ExportingCurrencyValue> findValues() {
        try {
            return (List<ExportingCurrencyValue>) valueRepository.findAll();
        } catch (Exception e) {
            throw new ResourceNotFoundException("Error in retrieving data from db");
        }
    }
}
