package com.miaca;

import java.util.Scanner;

public abstract class Task {
    public Scanner scanner = new Scanner(System.in);

    public abstract void execute();

    public boolean continueExecution(boolean error, String message) {
        if (error) {
            System.out.print(message);
            System.out.print("(y/n): ");
            String answer = scanner.nextLine();
            return !answer.equalsIgnoreCase("y");
        } else {
            System.out.print(message);
            System.out.print("(y/n): ");
            String answer = scanner.nextLine();
            return answer.equalsIgnoreCase("y");
        }
    }
}
