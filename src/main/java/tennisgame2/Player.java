package tennisgame2;

public class Player {
    private int point;
    private String name;

    public Player(String playerName) {
        this.name = playerName;
        point = 0;
    }

    public int getPoint() {
        return point;
    }

    public String getName() {
        return name;
    }

    public void scored() {
        point++;
    }
}