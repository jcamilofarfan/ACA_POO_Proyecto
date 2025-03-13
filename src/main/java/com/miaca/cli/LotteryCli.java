package com.miaca.cli;

import com.miaca.Task;
import java.util.Arrays;

public class LotteryCli extends Task {

    @Override
    public void execute() {
        do {
            System.out.println("\n===== LOTTERY =====");

            int[] numbers = { generateRandomNumber(), generateRandomNumber(), generateRandomNumber() };
            System.out.printf("Generated numbers: %d, %d, %d%n", numbers[0], numbers[1], numbers[2]);

            if (isWinningCombination(numbers)) {
                System.out.println("GANO Felicidades");
            } else {
                System.out.println("PERDISTE, sigue intentando");
            }
        } while (continueExecution(false, "Do you want to try the lottery again?"));
    }

    private boolean isWinningCombination(int[] numbers) {
        return contains(numbers, 9) && contains(numbers, 7) && contains(numbers, 5);
    }

    private boolean contains(int[] numbers, int value) {
        return Arrays.stream(numbers).anyMatch(n -> n == value);
    }

    private int generateRandomNumber() {
        return (int) (Math.random() * 10);
    }
}