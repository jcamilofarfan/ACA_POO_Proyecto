package com.miaca.cli;

import com.miaca.Task;
import com.miaca.services.RatesService;
import com.miaca.tasks.ConversionRates;

import java.util.Locale;
import java.util.Set;

public class ConversionCli extends Task {
    private String currency;
    private double amount;
    ConversionRates conversionRates = new ConversionRates(new RatesService());

    @Override
    public void execute() {
        boolean exit = false;
        while (!exit) {
            if (currency == null || currency.trim().isEmpty()) {
                System.out.println("Enter target currency: ");
                printAvailableCurrencies(conversionRates.getAvailableCurrencies());
                currency = scanner.nextLine();
                if (!conversionRates.getAvailableCurrencies().contains(currency.toUpperCase())) {
                    currency = null;
                    amount = 0.0;
                    if (continueExecution(true, "Invalid currency entered. Do you want to try again?")) {
                        exit = true;
                    }
                    continue;
                }
            } else {
                System.out.println("Target currency: " + currency.toUpperCase());
                if (continueExecution(false, "Is this the correct currency, or do you want to change it?")) {
                    currency = null;
                    amount = 0.0;
                    continue;
                }
            }
            if (amount == 0.0) {
                System.out.println("Enter amount in COP: ");
                try {
                    amount = Double.parseDouble(scanner.nextLine());
                } catch (NumberFormatException e) {
                    currency = null;
                    amount = 0.0;
                    if (continueExecution(true, "Invalid amount entered. Do you want to try again?")) {
                        exit = true;
                    }
                    continue;
                }
            }

                double result = conversionRates.convert(currency.toUpperCase(), amount);
                System.out.println("Result: " + String.format(Locale.US, "%.2f", result) + " " + currency.toUpperCase());

            if (continueExecution(false, "Do you want to convert another amount?")) {
                currency = null;
                amount = 0.0;
            } else {
                exit = true;
            }
        }
    }

    private void printAvailableCurrencies(Set<String> availableCurrencies) {
        int count = 0;
        for (String cur : availableCurrencies) {
            System.out.printf("%-6s", cur);
            count++;
            if (count % 10 == 0) {
                System.out.println();
            }
        }
        if (count % 10 != 0) {
            System.out.println();
        }
    }
}