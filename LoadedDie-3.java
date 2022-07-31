package lee_lab2;

import java.util.Random;

/**
 * The LoadedDie class simulates a weighted six-sided die.
 *
 * @author Emily Lee
 * @version 1.0
 */
public class LoadedDie {
    private int value;                              // The die's value
    private int favoredFace;                        // The favored face
    private int percentage;                         // More times per hundred

    /**
     * The constructor performs an initial roll of the die.
     *
     * @param loadNumber          which number should come up more often
     * @param moreTimesPerHundred how many times per 100 rolls to come up with
     *                            the loaded number (instead of uniform random)
     */
    public LoadedDie(int loadNumber, int moreTimesPerHundred) {
        favoredFace = loadNumber;
        percentage = moreTimesPerHundred;
        loadedRoll();
    }

    /**
     * The roll method simulates the rolling of the die.
     * It will typically set this die's value to a random value
     * with uniform distribution between 1 and 6. Occasionally,
     * it will a priori return the favored value (with frequency
     * determined by the moreTimesPerHundred argument that was passed
     * to the constructor).
     */
    public int loadedRoll() {
        final int SIDES = 6;
        final int RANGE = 100;
        int randomNum, randomNum1;

        // Create a random object.
        Random rand = new Random();

        // Get a random value
        randomNum = rand.nextInt(RANGE) + 1;

        // If random number is less than 30, return the favored face. Else, roll the die the regular way
        if (randomNum < percentage)
            value = favoredFace;
        else
            value = rand.nextInt(SIDES) + 1;

        return value;
    }

    /**
     * getValue method
     *
     * @return The value of the die.
     */
    public int getValue() {
        return value;
    }

    /**
     * getFavoredFace method
     *
     * @return favoredFace The weighted side of dice
     */
    public int getLoadNumber() {
        return favoredFace;
    }

    /**
     * getPercentage method
     *
     * @return percentage
     */
    public int getMoreTimesPerHundred() {
        return percentage;
    }
}

