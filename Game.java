import java.util.Random;
import java.util.Scanner;

public class Game {

    private Player player1;
    private Player player2;
    private boolean finished; // initial value is false; we don't need to include it in constructor
    private int firstPlayer;

    public Game() {
        player1 = new Player();
        player2 = new Player();
    }

    public void play() {

        Player activePlayer;

        // Choose first player using randomizer
        Random random = new Random();
        firstPlayer = random.nextInt(2) + 1;

        if (firstPlayer == 1) {
            activePlayer = player1;
            System.out.println(player1.getName() + " was chosen to go first!");
        } else {
            activePlayer = player2;
            System.out.println(player2.getName() + " was chosen to go first!");
        }

        // Game logic
        int pieces = Board.getNumPieces();
        System.out.println("There are " + pieces + " left.");

        // End of code
        finished = isFinished();
        if (finished == false) {
            play();
        } else {
            // TODO: Announce winners & scores
        }
    }

    private boolean isFinished() {
        // Ask user if they want to play again
        System.out.println("Would you like to play again? (Y/N)");

        // Initialize scanner
        Scanner sc = new Scanner(System.in);

        // Read next line for response
        String userInput = sc.nextLine();

        // While the input is different from the provided responses, reprompt to play again
        while (!(userInput.trim().toUpperCase().equals("Y") || userInput.trim().toUpperCase().equals("N"))) {
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
}
