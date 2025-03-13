package com.miaca.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.miaca.dto.ResponseRatesDto;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Set;

public class RatesService {
    private Map<String, Double> rates;
    public RatesService() {
        this.rates = fetchRates();
    }

    public Map<String, Double> getRates() {
        if (this.rates == null) {
            this.rates = fetchRates();
        }
        return this.rates;

    }

    public Set<String> getAvailableCurrencies() {
        return this.rates.keySet();
    }

    public Double getConversionRate(String currency) {
        return this.rates.get(currency);
    }

    public double convert(String currency, double amount) {
        Double rate = getConversionRate(currency);
        if (rate == null || rate == 0.0) {
            throw new IllegalArgumentException("Currency not found: " + currency);
        }
        return amount * rate;
    }

    private Map<String, Double> fetchRates() {
        String localFilePath = "src/main/resources/rates.json";
        try {
            String json = Files.readString(Paths.get(localFilePath));
            ObjectMapper mapper = new ObjectMapper();
            ResponseRatesDto responseRates = mapper.readValue(json, ResponseRatesDto.class);
            return responseRates.getConversionRates();
        } catch (Exception e) {
            throw new RuntimeException("Failed to read rates from " + localFilePath, e);
        }
    }
}
