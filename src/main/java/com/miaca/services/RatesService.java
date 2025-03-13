package com.miaca.services;

import com.miaca.dto.ResponseRatesDto;

import java.util.Map;

public class RatesService {
    private Map<String, Double> rates;

    public Map<String, Double> getRates() {
        if (this.rates == null) {
            this.rates = fetchRates();
        }
        return this.rates;

    }

    private Map<String, Double> fetchRates() {
        String url = "https://v6.exchangerate-api.com/v6/3d2fc153a5025255dc77d815/latest/COP";
        try {
            return HttpService.get(url, ResponseRatesDto.class).getConversionRates();
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch rates from " + url);
        }
    }
}
