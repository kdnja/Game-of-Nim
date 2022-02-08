import java.lang.Math;

public class Board {
    private static int pieces;
    private static int maxGuess;

    public static void populate() {
        pieces = (int) ((Math.random() * (51 - 10)) + 10);
        System.out.println("Number of pieces: " + pieces);
    }

    public static int getPieces() {
        return pieces;
    }

    public static int getMaxGuess() {
        return maxGuess;
    }

    public static void removePieces(int n) {
        pieces -= n;
    }

    public static void setMaxGuess() {
        maxGuess = (int) (pieces / 2);
        if (pieces == 1) {
            maxGuess = 1;
        }
    }
}
