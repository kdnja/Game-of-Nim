/**
 * Project 2.5.11
 *
 * GameRunner Class for the Game of Nim 
*/
public class GameRunner {
    public static void main(String[] args) {
        System.out.println("Welcome to the Game of Nim!");

        Board.populate();

        Game nim = new Game();
        nim.play();
    }
}