package com.miaca.cli;

import com.miaca.Task;
import java.util.Locale;

public class AreaCli extends Task {

    @Override
    public void execute() {
        boolean exit = false;
        while (!exit) {
            System.out.println("\n===== GEOMETRIC FIGURES MENU =====");
            System.out.println("1. Area of a Rhombus");
            System.out.println("2. Area of a Pentagon");
            System.out.println("3. Area of a Trapezoid");
            System.out.println("4. Area of a Cylinder (Total Surface Area)");
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
                    calculateRhombusArea();
                    break;
                case 2:
                    calculatePentagonArea();
                    break;
                case 3:
                    calculateTrapezoidArea();
                    break;
                case 4:
                    calculateCylinderArea();
                    break;
                case 0:
                    exit = true;
                    continue;
                default:
                    System.out.println("Invalid option selected.");
            }

            if (!exit && !continueExecution(false, "Do you want to perform another calculation?")) {
                exit = true;
            }
        }
    }

    private void calculateRhombusArea() {
        System.out.println("Enter diagonal 1 of the rhombus: ");
        double d1 = readDoubleInput();
        System.out.println("Enter diagonal 2 of the rhombus: ");
        double d2 = readDoubleInput();
        double area = (d1 * d2) / 2.0;
        System.out.println(String.format(Locale.US, "Area of the Rhombus = %.2f", area));
    }

    private void calculatePentagonArea() {
        System.out.println("Enter the side length of the regular pentagon: ");
        double side = readDoubleInput();
        double area = (5 * side * side) / (4 * Math.tan(Math.PI / 5));
        System.out.println(String.format(Locale.US, "Area of the Pentagon = %.2f", area));
    }

    private void calculateTrapezoidArea() {
        System.out.println("Enter the length of the first base: ");
        double base1 = readDoubleInput();
        System.out.println("Enter the length of the second base: ");
        double base2 = readDoubleInput();
        System.out.println("Enter the height of the trapezoid: ");
        double height = readDoubleInput();
        double area = ((base1 + base2) / 2.0) * height;
        System.out.println(String.format(Locale.US, "Area of the Trapezoid = %.2f", area));
    }

    private void calculateCylinderArea() {
        System.out.println("Enter the radius of the cylinder: ");
        double radius = readDoubleInput();
        System.out.println("Enter the height of the cylinder: ");
        double height = readDoubleInput();
        double area = 2 * Math.PI * radius * (radius + height);
        System.out.println(String.format(Locale.US, "Total Surface Area of the Cylinder = %.2f", area));
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