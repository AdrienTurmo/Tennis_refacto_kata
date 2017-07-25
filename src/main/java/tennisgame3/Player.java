package tennisgame3;

public class Player {

    private String name;
    private int score = 0;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void scored() {
        score++;
    }
}
