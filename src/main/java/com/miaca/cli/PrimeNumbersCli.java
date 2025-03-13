package com.miaca.cli;

import com.miaca.Task;

public class PrimeNumbersCli extends Task {

    @Override
    public void execute() {
        boolean exit = false;
        while (!exit) {
            System.out.println("\n===== PRIME NUMBERS CALCULATION =====");
            System.out.print("Enter a positive integer: ");
            int number = readIntInput();

            if (number < 2) {
                System.out.println("There are no prime numbers less than 2.");
            } else {
                System.out.println("Prime numbers up to " + number + ":");
                for (int i = 2; i <= number; i++) {
                    if (isPrime(i)) {
                        System.out.print(i + " ");
                    }
                }
                System.out.println();
            }

            if (!continueExecution(false, "Do you want to calculate prime numbers for another number?")) {
                exit = true;
            }
        }
    }

    private boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    private int readIntInput() {
        while (true) {
            try {
                String input = scanner.nextLine();
                int value = Integer.parseInt(input);
                if (value < 0) {
                    System.out.print("Please enter a positive integer: ");
                    continue;
                }
                return value;
            } catch (NumberFormatException e) {
                System.out.print("Invalid number, please enter a valid integer: ");
            }
        }
    }
}