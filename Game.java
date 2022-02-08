import java.util.Random;
import java.util.Scanner;

public class Game {

    private Player player1;
    private Player player2;
    private Player activePlayer;
    private boolean finished; // initial value is false; we don't need to include it in constructor
    private int currPlayer;

    // Constructor for Game
    public Game() {
        player1 = new Player();
        player2 = new Player();
    }

    public void play() {
        // Adds the pieces to play Nim
        Board.populate();
        // Sets the maximum guess a player can make
        Board.setMaxGuess();

        // Choose first player using randomizer
        Random random = new Random();
        currPlayer = random.nextInt(2) + 1;

        // Sets current player based on results of randomizer
        if (currPlayer == 1) {
            activePlayer = player1;
            System.out.println(player1.getName() + " was chosen to go first!");
        } else {
            activePlayer = player2;
            System.out.println(player2.getName() + " was chosen to go first!");
        }

        // Loops until there is one piece left
        while (Board.getPieces() > 1) {
            int pieces = Board.getPieces();
            int maxGuess = Board.getMaxGuess();
            // initialize new scanner that listens to system input
            Scanner sc = new Scanner(System.in);

            System.out.println("It is " + activePlayer.getName() + "'s turn.");
            System.out.println("There are " + pieces + " pieces remaining.");

            // If else statements for grammatically correct responses
            if (maxGuess == 1) {
                System.out.println("You can remove only " + maxGuess + " piece.");
            } else {
                System.out.println("You can remove up to " + maxGuess + " pieces.");
            }
            // Prompt user for guess
            System.out.println("How many pieces would you like to remove?");

            // Store guess in variable
            int guess = sc.nextInt();

            // If the guess is valid
            if (isValid(guess)) {
                // Remove pieces, set max guess, and advance turn
                Board.removePieces(guess);
                Board.setMaxGuess();
                advanceTurn();
            } else {
                // While the guess is invalid, reprompt user for response
                while (!isValid(guess)) {
                    System.out.println("Sorry, that isn't a valid value.");
                    System.out.println(
                            "Please type a guess up to " + Board.getMaxGuess() + " pieces.");
                    guess = sc.nextInt();
                }
                // Remove pieces, set max guess, and advance turn
                Board.removePieces(guess);
                Board.setMaxGuess();
                advanceTurn();
            }
        }

        // If the current player is even, player1 wins the round. Otherwise, player2 wins the round
        if (currPlayer % 2 == 0) {
            player1.incrScore();
            System.out.println(player1.getName() + " won the round!");
        } else {
            player2.incrScore();
            System.out.println(player2.getName() + " won the round!");
        }

        // Prompts user to play again
        finished = isFinished();
        // If they want to play again, run Game.play() again
        if (finished == false) {
            play();
        } else {
            // Print out scores
            System.out.println(player1.getName() + ": " + player1.getScore());
            System.out.println(player2.getName() + ": " + player2.getScore());

            // Compare scores and print out the corresponding winner. Otherwise, print that it's a
            // tie
            if (player1.getScore() > player2.getScore()) {
                System.out.println(player1.getName() + " won the game!");
            } else if (player2.getScore() > player1.getScore()) {
                System.out.println(player2.getName() + " won the game!");
            } else {
                System.out.println("It's a tie!");
            }
        }
    }

    private boolean isFinished() {
        // Ask user if they want to play again
        System.out.println("Would you like to play again? (Y/N)");

        // Initialize scanner
        Scanner sc = new Scanner(System.in);

        // Read next line for response
        String userInput = sc.nextLine();

        // While the input is different from the provided responses, reprompt to play
        // again
        while (!(userInput.trim().toUpperCase().equals("Y")
                || userInput.trim().toUpperCase().equals("N"))) {
            System.out.println("Input was incorrect.\n\nWould you like to play again? (Y/N)");
            userInput = sc.nextLine();
        }

        // If they do, return true
        if (userInput.trim().toUpperCase().equals("Y")) {
            System.out.println("Response: Yes");
            return false;
        }

        // If they don't, return false
        if (userInput.trim().toUpperCase().equals("N")) {
            System.out.println("Response: No");
            return true;
        }

        // If none of this code works it defaults to true
        System.out.println("Code didn't work lol");
        return true;
    }

    private void advanceTurn() {
        // Increase currPlayer
        currPlayer++;
        // If currPlayer is odd, the active player is player1, otherwise the active player is
        // player2
        if (currPlayer % 2 == 1) {
            activePlayer = player1;
        } else {
            activePlayer = player2;
        }
    }

    private boolean isValid(int num) {
        // If the number is more than the max amount of guesses, return true. Otherwise, return
        // false
        if (num <= Board.getMaxGuess()) {
            return true;
        } else {
            return false;
        }
    }
}
