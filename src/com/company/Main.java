package com.company;

import java.util.Random;

public class Main {
    // Store a random number (0 - 100)
    static int numberToGuess = randomNumber();

    public static void main(String[] args) {
        AbstractPlayerInput newGame;

        // Check args from Main then init the game
        if (args.length > 0 && args[0].equals("--ai")) {
            newGame = new IAPlayerInput();
        } else {
            newGame = new CommandLinePlayerInput();
        }

        // Launch the game
        newGame.guessNumber();

        // Ask the player a number while the random number is not found
        while(newGame.getUserChoice() != numberToGuess) {
                if (newGame.getUserChoice() > numberToGuess) {
                    System.out.println("The number to guess is lower than " + newGame.getUserChoice());
                    System.out.println("Write a number lower than " + newGame.getUserChoice() + "\n");
                    newGame.guessNumber();
                }
                if (newGame.getUserChoice() < numberToGuess) {
                    System.out.println("The number to guess is higher than " + newGame.getUserChoice());
                    System.out.println("Write a number higher than " + newGame.getUserChoice() + "\n");
                    newGame.guessNumber();
                }
            }

        // When the player found the random number, stop the game and display the number of attempts
        System.out.println("Congrats.. you found the number to guess (" + numberToGuess + ")" + " in " + newGame.getAttempts() + " attempts !");
    }
    /**
     * Method to get a random number between 0 and 100
     * @return an int (0 - 100)
     */
    public static int randomNumber() {
        Random rand = new Random();
        return rand.nextInt(100);
    }
}
