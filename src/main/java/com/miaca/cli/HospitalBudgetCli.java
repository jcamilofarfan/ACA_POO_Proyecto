package com.miaca.cli;

import com.miaca.Task;

import java.util.Locale;

public class HospitalBudgetCli extends Task {
    @Override
    public void execute() {
        boolean exit = false;
        while (!exit) {
            System.out.println("\n===== HOSPITAL BUDGET CALCULATION =====");
            System.out.print("Enter the annual hospital budget (in COP): ");
            double budget = readDoubleInput();

            if (budget <= 0) {
                System.out.println("Budget must be greater than 0.");
                continue;
            }

            double ginecologia = budget * 0.40;
            double traumatologia = budget * 0.15;
            double pediatria = budget * 0.15;
            double urgencias = budget * 0.30;

            System.out.println("\nBudget Distribution:");
            System.out.println(String.format(Locale.US, "Ginecología (40%%): %.2f", ginecologia));
            System.out.println(String.format(Locale.US, "Traumatología (15%%): %.2f", traumatologia));
            System.out.println(String.format(Locale.US, "Pediatría (15%%): %.2f", pediatria));
            System.out.println(String.format(Locale.US, "Urgencias (30%%): %.2f", urgencias));

            if (!continueExecution(false, "Do you want to calculate another hospital budget?")) {
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
                System.out.print("Invalid number, please enter a valid numeric value: ");
            }
        }
    }
}
