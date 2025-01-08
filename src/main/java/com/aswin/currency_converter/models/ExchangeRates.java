package com.aswin.currency_converter.models;

import java.util.HashMap;
import java.util.Map;

public class ExchangeRates implements CommonFunctions {
    private String base;
    private Map<String, Double> rates;

    public ExchangeRates(String base) {
        this.base = base;
    }

    public String getBase() {
        return base;
    }

    public Map<String, Double> getRates() {
        return rates;
    }

    public void setRates(Map<String, Double> rates) {
        this.rates = rates;
    }

    public void setBase(String base) {
        this.base = base;
    }

    @Override
    public void setRequestData(String from, String to, double amount) {
        this.base = from;
    }

    @Override
    public Map<String, Object> getResponseData() {
        Map<String, Object> response = new HashMap<>();
        response.put("base", this.base);
        response.put("rates", this.rates);
        return response;
    }
}
