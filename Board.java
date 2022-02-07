import java.lang.Math;

public class Board {
    private static int pieces;

    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public static void populate() {
        pieces = getRandomNumber(10, 50);
        System.out.println("Number of pieces: " + pieces);
    }

    public static int getNumPieces() {
        return pieces;
    }

    public static void removePieces(int n) {
        pieces -= n;
    }
}