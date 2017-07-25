package tennisgame3;

public class Player {

    private String name;
    private int points = 0;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void scored() {
        points++;
    }

    public boolean hasLessThanForty() {
        return points<=TennisScore.Forty.getScore();
    }

    public String tennisScore() {
        return TennisScore.tennisScoreOf(points);
    }

    public int scoreDifferenceWith(Player oppositePlayer) {
        return this.points - oppositePlayer.points;
    }
}
