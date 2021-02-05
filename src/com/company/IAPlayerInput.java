package com.company;

public class IAPlayerInput extends AbstractPlayerInput {
    int rangeLimitLower = 0;
    int rangeLimitHigher = 100;

    public IAPlayerInput() {
        super();
    }

    @Override
    public void guessNumber() {
        // In first loop, userChoic's value (IA) is equal to 0, so update it with the value equal to middle point (between rangeLimitLower & rangeLimitHigher)
        if (getUserChoice() == 0) {
            setUserChoice(midPoint(rangeLimitLower, rangeLimitHigher));
        }
        // If userChoice's value (IA) is greater than numberToGuess so update rangeLimitLower with the value of userChoice (IA)
        if (getUserChoice() > Main.numberToGuess) {
            rangeLimitHigher = getUserChoice();
            // Then let the IA choose an other number, the new middle point between rangeLimitLower & rangeLimitHigher
            setUserChoice(midPoint(rangeLimitLower, rangeLimitHigher));
        }
        // Else, userChoice's value (IA) is lower than numberToGuess so update rangeLimitHigher with the value of userChoice (IA)
        else {
                rangeLimitLower = getUserChoice();
            // Then let the IA choose an other number, the new middle point between rangeLimitLower & rangeLimitHigher
            setUserChoice(midPoint(rangeLimitLower, rangeLimitHigher));
        }
        // Increase number of attempts
        setAttempts(getAttempts()+1);
    }

    /**
     * Method to find the middle point between two numbers
     * @param limitLower The lower number
     * @param limitHigher The higher number
     * @return An int, the middle point between lower and higher number
     */
    public int midPoint(int limitLower, int limitHigher) {
        return (limitLower + limitHigher) / 2;
    }
}
