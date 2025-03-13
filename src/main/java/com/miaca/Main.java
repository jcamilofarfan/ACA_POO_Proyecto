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
                    case 1 -> executeTask(new ConversionCli());
                    case 2 -> executeTask(new InvoiceCli());
                    case 3 -> executeTask(new MacDonaldsCli());
                    case 4 -> executeTask(new UnitConversionCli());
                    case 5 -> executeTask(new AreaCli());
                    case 6 -> executeTask(new GradeAverageCli());
                    case 7 -> executeTask(new HospitalBudgetCli());
                    case 8 -> executeTask(new PrimeNumbersCli());
                    case 9 -> executeTask(new SumOfDigitsCli());
                    case 10 -> executeTask(new LotteryCli());
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

    static void executeTask(Task task) {
        task.execute();
    }
}
