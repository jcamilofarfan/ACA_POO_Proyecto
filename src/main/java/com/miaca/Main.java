package com.miaca;

import java.util.Scanner;

import com.miaca.cli.*;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            System.out.println("\n===== Task Hub CLI =====");
            System.out.println("1. Convert Currency");
            System.out.println("2. Generate Invoice");
            System.out.println("3. McDonald's Animation Plan");
            System.out.println("4. Convert Units");
            System.out.println("5. Area of figures");
            System.out.println("6. Grade Average");
            System.out.println("7. Hospital Budget");
            System.out.println("8. Print Prime Numbers");
            System.out.println("9. Sum of Digits");
            System.out.println("10. Lottery");
            System.out.println("0. Exit");
            System.out.print("Select an option: ");

            try {
                int option = Integer.parseInt(scanner.nextLine());
                switch (option) {
                    case 1 -> new ConversionCli().execute();
                    case 2 -> new InvoiceCli().execute();
                    case 3 -> new MacDonaldsCli().execute();
                    case 4 -> new UnitConversionCli().execute();
                    case 5 -> new AreaCli().execute();
                    case 6 -> new GradeAverageCli().execute();
                    case 7 -> new HospitalBudgetCli().execute();
                    case 8 -> new PrimeNumbersCli().execute();
                    case 9 -> new SumOfDigitsCli().execute();
                    case 10 -> new LotteryCli().execute();
                    case 0 -> {
                        System.out.println("Do you want to exit? (y/n)");
                        exit = scanner.nextLine().toLowerCase().startsWith("y");
                    }
                    default -> System.out.println("Invalid option. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
        scanner.close();
    }
}
