package com.miaca.cli;

import com.miaca.Task;

import java.util.Locale;

public class InvoiceCli extends Task {
    private String product;
    private double unitPrice;
    private int quantity;

    @Override
    public void execute() {
        boolean exit = false;
        while (!exit) {
            if (product == null || product.trim().isEmpty()) {
                System.out.println("Enter product name: ");
                product = scanner.nextLine();
                if (product == null || product.trim().isEmpty()) {
                    if (continueExecution(true, "Invalid product name entered. Do you want to try again?")) {
                        exit = true;
                    }
                    continue;
                }
            } else {
                System.out.println("Product name: " + product);
                if (continueExecution(false, "Is this the correct product name, or do you want to change it?")) {
                    product = null;
                    unitPrice = 0.0;
                    quantity = 0;
                    continue;
                }
            }

            if (unitPrice <= 0.0) {
                System.out.println("Enter unit price: ");
                try {
                    unitPrice = Double.parseDouble(scanner.nextLine());
                    if (unitPrice <= 0) {
                        System.out.println("Unit price must be greater than 0.");
                        unitPrice = 0.0;
                        continue;
                    }
                } catch (NumberFormatException e) {
                    unitPrice = 0.0;
                    if (continueExecution(true, "Invalid unit price entered. Do you want to try again?")) {
                        exit = true;
                    }
                    continue;
                }
            } else {
                System.out.println("Unit price: " + unitPrice);
                if (continueExecution(false, "Is this the correct unit price, or do you want to change it?")) {
                    unitPrice = 0.0;
                    quantity = 0;
                    continue;
                }
            }

            if (quantity <= 0) {
                System.out.println("Enter quantity: ");
                try {
                    quantity = Integer.parseInt(scanner.nextLine());
                    if (quantity <= 0) {
                        System.out.println("Quantity must be greater than 0.");
                        quantity = 0;
                        continue;
                    }
                } catch (NumberFormatException e) {
                    quantity = 0;
                    if (continueExecution(true, "Invalid quantity entered. Do you want to try again?")) {
                        exit = true;
                    }
                    continue;
                }
            } else {
                System.out.println("Quantity: " + quantity);
                if (continueExecution(false, "Is this the correct quantity, or do you want to change it?")) {
                    quantity = 0;
                    continue;
                }
            }

            double subtotal = unitPrice * quantity;
            double iva = subtotal * 0.19;
            double discount = (subtotal > 200000) ? subtotal * 0.10 : 0.0;
            double total = subtotal + iva - discount;

            System.out.println("\n===== INVOICE =====");
            System.out.println("Product: " + product);
            System.out.println("Unit Price: " + String.format(Locale.US, "%.2f", unitPrice));
            System.out.println("Quantity: " + quantity);
            System.out.println("Subtotal: " + String.format(Locale.US, "%.2f", subtotal));
            System.out.println("IVA (19%): " + String.format(Locale.US, "%.2f", iva));
            if (discount > 0) {
                System.out.println("Discount (10% if subtotal > 200,000): " + String.format(Locale.US, "%.2f", discount));
            }            System.out.println("Total: " + String.format(Locale.US, "%.2f", total));
            System.out.println("===================\n");

            if (continueExecution(false, "Do you want to generate another invoice?")) {
                product = null;
                unitPrice = 0.0;
                quantity = 0;
            } else {
                exit = true;
            }
        }
    }
}
