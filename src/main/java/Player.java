public class Player {
    private String playerName;
    private int score;

    public Player(String playerName) {
        this.playerName = playerName;
        this.score = 0;
    }


    public boolean compareToString(String playerName) {
        return this.playerName == playerName;
    }

    public void updateScore() {
        score++;
    }

    public boolean isAtEqualityWith(Player oppositePlayer) {
        return score == oppositePlayer.score;
    }

    public boolean hasMoreThan(int score) {
        return this.score >= score;
    }

    public int compareScoreTo(Player oppositePlayer) {
        return this.score - oppositePlayer.score;
    }

    public int getScore() {
        return score;
    }
}
