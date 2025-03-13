package com.miaca.cli;

import com.miaca.Task;

public class MacDonaldsCli extends Task {
    private int age = 0;
    @Override
    public void execute() {
        boolean exit = false;
        while (!exit) {
            if (age <= 0) {
                System.out.println("Enter child's age: ");
                try {
                    age = Integer.parseInt(scanner.nextLine());
                    if (age <= 0) {
                        System.out.println("Age must be greater than 0.");
                        age = 0;
                        continue;
                    }
                } catch (NumberFormatException e) {
                    age = 0;
                    if (continueExecution(true, "Invalid age entered. Do you want to try again?")) {
                        exit = true;
                    }
                    continue;
                }
            } else {
                System.out.println("Child's age: " + age);
                if (continueExecution(false, "Is this the correct age, or do you want to change it?")) {
                    age = 0;
                    continue;
                }
            }

            // Age validation for 18 or above
            if (age >= 18) {
                System.out.println("No contamos planes para esas edad.");
                if (continueExecution(false, "Do you want to process another child?")) {
                    age = 0;
                    continue;
                } else {
                    exit = true;
                    continue;
                }
            }

            String plan;
            if (age < 4) {
                plan = "Títeres, ponqué y cajitas felices";
            } else if (age <= 10) {
                plan = "Payasos, ponqué y cajita feliz";
            } else {
                plan = "Cuentearía, ponqué y cajita felices";
            }

            System.out.println("\n===== MACDONALD'S ANIMATION PLAN =====");
            System.out.println("Child's Age: " + age);
            System.out.println("Plan: " + plan);
            System.out.println("=========================================\n");

            if (continueExecution(false, "Do you want to process another child?")) {
                age = 0;
            } else {
                exit = true;
            }
        }
    }
}
