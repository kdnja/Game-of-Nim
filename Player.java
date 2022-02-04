public class Player {
    private String name;
    private int score;

    public Player(String name) {
        this.name = name;
        score = 0;
    }

    public int takeTurn() {
        // TODO: program this
        return 0; // placeholder value for now
    }

    public String getName() {
        return this.name;
    }

    public int getScore() {
        return this.score;
    }

    public void incrScore() {
        this.score += 1;
    }
}
