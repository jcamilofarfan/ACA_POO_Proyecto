package com.miaca.tasks;

import com.miaca.Task;
import com.miaca.services.RatesService;

import java.util.Map;
import java.util.Set;

public class ConversionRates {
    private final Map<String, Double> rates;

    public ConversionRates(RatesService ratesService) {
        this.rates = ratesService.getRates();
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
}
