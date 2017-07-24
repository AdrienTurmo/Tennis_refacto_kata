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

    public String tennisScore() {
        switch (point) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            case 3:
                return "Forty";
        }
        return "";
    }
}