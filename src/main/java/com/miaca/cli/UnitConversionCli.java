package com.miaca.cli;

import com.miaca.Task;
import java.util.Locale;

public class UnitConversionCli extends Task {

    @Override
    public void execute() {
        boolean exit = false;
        while (!exit) {
            System.out.println("\n===== UNITS CONVERSION MENU =====");
            System.out.println("1. Miles to Kilometers");
            System.out.println("2. Pounds to Kilograms");
            System.out.println("3. Fahrenheit to Celsius");
            System.out.println("0. Exit");
            System.out.print("Select an option: ");

            String optionStr = scanner.nextLine();
            int option = 0;
            try {
                option = Integer.parseInt(optionStr);
            } catch (NumberFormatException e) {
                System.out.println("Invalid option. Please enter a valid number.");
                continue;
            }

            switch (option) {
                case 1:
                    convertMilesToKilometers();
                    break;
                case 2:
                    convertPoundsToKilograms();
                    break;
                case 3:
                    convertFahrenheitToCelsius();
                    break;
                case 0:
                    exit = true;
                    continue;
                default:
                    System.out.println("Invalid option selected.");
            }

            if (!exit && !continueExecution(false, "Do you want to perform another conversion?")) {
                exit = true;
            }
        }
    }

    private void convertMilesToKilometers() {
        System.out.println("Enter miles: ");
        double miles = readDoubleInput();
        double kilometers = miles * 1.60934; // Factor de conversión
        System.out.println(String.format(Locale.US, "%.2f miles = %.2f kilometers", miles, kilometers));
    }

    private void convertPoundsToKilograms() {
        System.out.println("Enter pounds: ");
        double pounds = readDoubleInput();
        double kilograms = pounds * 0.453592; // Factor de conversión
        System.out.println(String.format(Locale.US, "%.2f pounds = %.2f kilograms", pounds, kilograms));
    }

    private void convertFahrenheitToCelsius() {
        System.out.println("Enter Fahrenheit: ");
        double fahrenheit = readDoubleInput();
        double celsius = (fahrenheit - 32) * 5.0 / 9.0; // Fórmula de conversión
        System.out.println(String.format(Locale.US, "%.2f°F = %.2f°C", fahrenheit, celsius));
    }

    private double readDoubleInput() {
        while (true) {
            try {
                String input = scanner.nextLine();
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid number, please enter a valid numeric value: ");
            }
        }
    }
}