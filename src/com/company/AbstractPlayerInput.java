package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class AbstractPlayerInput {
    private int userChoice;
    private int attempts;

    public AbstractPlayerInput() {
        this.userChoice = 0;
        this.attempts = 0;
    }

    // Getters
    public int getUserChoice() {
        return this.userChoice;
    }
    public int getAttempts() {
        return this.attempts;
    }
    // Setters
    public void setUserChoice(int numberChosenByIA) {this.userChoice = numberChosenByIA;}
    public void setAttempts(int attempts){this.attempts = attempts;}

    /**
     * Method to ask a number
     */
    public void guessNumber() {
        boolean isValid = false;
        while(!isValid) {
            //Check if the input is valid (a number between 0 and 100)
            try {
                Scanner input = new Scanner(System.in);
                System.out.println("Choose a number between 0 and 100");
                this.userChoice = input.nextInt();
                isValid = true;
                this.attempts++;
            } catch (InputMismatchException exception) {
                System.out.println("Error.. please choose a valid number (0 - 100)");
            }
        }
    }
}
