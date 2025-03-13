package com.miaca.cli;

import com.miaca.Task;
import java.util.Locale;

public class GradeAverageCli extends Task {

    @Override
    public void execute() {
        boolean exit = false;
        while (!exit) {
            System.out.println("\n===== STUDENT GRADES =====");
            System.out.println("Enter five grades for the student (values between 1.0 and 5.0):");

            double sum = 0.0;
            int count = 5;
            for (int i = 1; i <= count; i++) {
                System.out.print("Enter grade " + i + ": ");
                double grade = readDoubleInput();
                if (grade < 1.0 || grade > 5.0) {
                    System.out.println("Invalid grade. Please enter a value between 1.0 and 5.0.");
                    i--;
                    continue;
                }
                sum += grade;
            }

            double average = sum / count;
            System.out.println(String.format(Locale.US, "Average grade: %.2f", average));

            String performance;
            if (average >= 1.0 && average <= 2.0) {
                performance = "Deficiente";
            } else if (average > 2.0 && average <= 2.9) {
                performance = "Insuficiente";
            } else if (average >= 3.0 && average <= 3.9) {
                performance = "Aceptable";
            } else if (average >= 4.0 && average <= 4.9) {
                performance = "Sobresaliente";
            } else if (average == 5.0) {
                performance = "Excelente";
            } else {
                performance = "Unknown";
            }

            System.out.println("Performance: " + performance);

            if (!continueExecution(false, "Do you want to enter another set of grades?")) {
                exit = true;
            }
        }
    }

    private double readDoubleInput() {
        while (true) {
            try {
                String input = scanner.nextLine();
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Please enter a valid numeric value: ");
            }
        }
    }
}