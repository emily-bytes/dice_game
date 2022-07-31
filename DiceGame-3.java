package lee_lab2;

import java.util.Scanner;

/**
 * This program simulates the rolling of a loaded dice.
 *
 * @author Emily Lee
 * @version 1.0
 */
public class DiceGame {
    public static void main(String[] args) {
        final int COMP_LOADNUM = 6;         // Weighted side for computer
        final int USER_LOADNUM = 1;         // Weighted side for user
        final int MORE_TIMES = 30;          // More times per hundred
        final int MAX_ROLLS = 10;           // Number of times to roll
        String input;
        char ready;
        int compCount = 0, userCount = 0;
        String enterkey = "enter";

        // Create two instances of the Die class
        LoadedDie compDie = new LoadedDie(COMP_LOADNUM, MORE_TIMES);
        LoadedDie userDie = new LoadedDie(USER_LOADNUM, MORE_TIMES);

        // Welcome message
        welcome();

        // Create scanner object
        Scanner keyboard = new Scanner(System.in);

        do {
            compCount = 0;
            userCount = 0;

            // Play the rounds
            for (int i = 0; i < MAX_ROLLS; i++) {

                // Display number of rolls out of max number of rolls
                System.out.println("\nroll " + (i + 1) + " of " + MAX_ROLLS + ": ");

                // Computer's turn to roll dice
                compDie.loadedRoll();
                System.out.println("I rolled a " + compDie.getValue());

                // Ask user if they are ready to roll
                do {
                    System.out.print("Ready to roll? (Press ENTER when ready)");
                    enterkey = keyboard.nextLine();

                    // User's turn to roll dice
                }
                while (!enterkey.equals(""));
                userDie.loadedRoll();

                // Display user's roll after pressing "enter"
                System.out.println("You rolled a " + userDie.getValue());

                // Count winner rounds
                if (compDie.getValue() > userDie.getValue()) {
                    compCount++;
                } else if (userDie.getValue() > compDie.getValue()) {
                    userCount++;
                }
            }

            // Display number of rounds won
            displayRoundResults(compCount, userCount);

            // Display the winner
            displayWinner(compCount, userCount);

            // Ask user if they would like to play. Quit if no.
            System.out.print("\nReady to play? (no to quit) ");
            input = keyboard.nextLine();
            ready = input.charAt(0);

        } while (ready == 'y' || ready == 'y');

        // Goodbye message
        goodbye();
    }

    /**
     * This function displays the welcome message
     */
    public static void welcome() {
        System.out.println("\nThis is a game of you versus the computer. We will each\n" +
                "have one die. We roll our own die and the higher number\n" +
                "wins. We roll ten times and the one with the higher number\n" +
                "of wins is the grand winner.");
    }

    /**
     * This function displays the goodbye message
     */
    public static void goodbye() {
        System.out.println("\nThanks for playing!");
    }

    /**
     * This function displays number of rounds won
     *
     * @param compCount Number of rounds computer wins
     * @param userCount Number of rounds user wins
     */
    public static void displayRoundResults(int compCount, int userCount) {
        System.out.println("I won " + compCount + " times.");
        System.out.print("You won " + userCount + " times.\n");
    }

    /**
     * This function displays the winner
     *
     * @param compCount Number of rounds computer wins
     * @param userCount Number of rounds user wins
     */
    public static void displayWinner(int compCount, int userCount) {
        if (compCount > userCount)
            System.out.println("Grand winner is me!");
        else
            System.out.println("Grand winner is you!");
    }
}
