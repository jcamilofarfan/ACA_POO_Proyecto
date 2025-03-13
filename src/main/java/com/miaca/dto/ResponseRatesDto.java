package com.miaca.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class ResponseRatesDto {
    @JsonProperty("conversion_rates")
    private Map<String, Double> conversionRates;

    public Map<String, Double> getConversionRates() {
        return conversionRates;
    }
}
