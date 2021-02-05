package com.company;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Game {
    int userChoice;
    int attempts;

    public Game() {
        this.userChoice = 0;
        this.attempts = 0;
    }

    /**
     * Method to ask the player a number
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

    /**
     * Method to get a random number between 0 and 100
     * @return an int (0 - 100)
     */
    public int randomNumber() {
        Random rand = new Random();
        return rand.nextInt(100);
    }
}
