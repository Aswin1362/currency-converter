package com.aswin.currency_converter.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.aswin.currency_converter.models.CurrencyConverter;
import com.aswin.currency_converter.models.ExchangeRates;

@Service
public class CurrencyService {

    @Value("${exchange.api.url}")
    private String publicAPI;

    @Value("${exchange.api.accessKey}")
    private String accessKey;

    private final RestTemplate restTemplate;

    @Autowired
    public CurrencyService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Map<String, Object> getExchangeRates(String baseCurrency) {
        try {
            ExchangeRates exchangeRates = new ExchangeRates(baseCurrency);
            String url = publicAPI + "?access_key=" + this.accessKey + "&base=" + exchangeRates.getBase();
            ExchangeRates response = restTemplate.getForObject(url, ExchangeRates.class);
            if (response != null) {
                exchangeRates.setRates(response.getRates());
            }
            return exchangeRates.getResponseData();
        } catch (Exception e) {
            throw new RuntimeException("External API is unavailable: " + e.getMessage());
        }
    }

    public Map<String, Object> currencyConverter(String from, String to, Double amount) {
        CurrencyConverter converter = new CurrencyConverter(from, to, amount);
        converter.setRequestData(converter.getFrom(), converter.getTo(), converter.getAmount());

        Map<String, Object> exchangeRates = getExchangeRates(from);
        Map<String, Double> rates = (Map<String, Double>) exchangeRates.get("rates");

        if (rates.containsKey(to)) {
            double rate = rates.get(to);
            double convertedAmount = amount * rate;
            converter.setConvertedAmount(convertedAmount);
        } else {
            throw new IllegalArgumentException("Target currency not available");
        }

        return converter.getResponseData();
    }
}
