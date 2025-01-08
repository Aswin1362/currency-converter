package com.aswin.currency_converter.models;

import java.util.Map;

public interface CommonFunctions {
    public void setRequestData(String from, String to, double amount);

    Map<String, Object> getResponseData();
}
