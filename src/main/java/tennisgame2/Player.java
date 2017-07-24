package tennisgame2;

public class Player {
    private int points;
    private String name;

    public Player(String playerName) {
        this.name = playerName;
        points = 0;
    }

    public String getName() {
        return name;
    }

    public void scored() {
        points++;
    }

    public String tennisScore() {
        switch (points) {
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

    public boolean hasLessThanForty() {
        return this.points < 4;
    }

    public int scoreDifferenceWith(Player player) {
        return this.points - player.points;
    }
}