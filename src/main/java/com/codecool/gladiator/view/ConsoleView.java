package com.codecool.gladiator.view;

import java.util.Scanner;

/**
 * Basic console view implementation
 */
public class ConsoleView implements Viewable {

    @Override
    public void display(String text) {
        System.out.println(text);
    }

    @Override
    public int getNumberBetween(int min, int max) {
        Scanner scanner = new Scanner(System.in);
        int number = 0;
        while (!(number >= min && number <= max)) {
            String input = scanner.next();
            try {
                number = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Enter correct format: ");
            }
        }
        return number;
    }
}
