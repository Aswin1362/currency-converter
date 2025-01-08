package com.aswin.currency_converter.models;

import java.util.HashMap;
import java.util.Map;

public class CurrencyConverter implements CommonFunctions {
    private String from;
    private String to;
    private double amount;
    private double convertedAmount;

    public CurrencyConverter(String from, String to, double amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public double getAmount() {
        return amount;
    }

    public double getConvertedAmount() {
        return convertedAmount;
    }

    public void setConvertedAmount(double convertedAmount) {
        this.convertedAmount = convertedAmount;
    }

    @Override
    public void setRequestData(String from, String to, double amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    @Override
    public Map<String, Object> getResponseData() {
        Map<String, Object> response = new HashMap<>();
        response.put("from", this.from);
        response.put("to", this.to);
        response.put("amount", this.amount);
        response.put("convertedAmount", this.convertedAmount);
        return response;
    }
}
