package com.miaca.cli;

import com.miaca.Task;

public class SumOfDigitsCli extends Task {
    @Override
    public void execute() {
        boolean exit = false;
        while (!exit) {
            System.out.println("\n===== DIGIT SUMMATION =====");
            System.out.print("Enter an integer: ");
            int number = readIntInput();

            int sum = sumDigits(number);
            System.out.println("The sum of the digits of " + number + " is: " + sum);

            if (!continueExecution(false, "Do you want to sum the digits of another number?")) {
                exit = true;
            }
        }
    }

    private int sumDigits(int number) {
        int sum = 0;
        int temp = Math.abs(number);
        while (temp != 0) {
            sum += temp % 10;
            temp /= 10;
        }
        return sum;
    }

    private int readIntInput() {
        while (true) {
            try {
                String input = scanner.nextLine();
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.print("Invalid number, please enter a valid integer: ");
            }
        }
    }
}