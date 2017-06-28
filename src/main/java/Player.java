import java.util.Objects;

public class Player {
    private String playerName;
    private int score;

    public Player(String playerName) {
        this.playerName = playerName;
        this.score = 0;
    }


    public boolean compareToString(String playerName) {
        return Objects.equals(this.playerName, playerName);
    }

    public void Scored() {
        score++;
    }

    public boolean isAtEqualityWith(Player oppositePlayer) {
        return score == oppositePlayer.score;
    }

    public boolean hasMoreThanForty() {
        return this.score >= 4;
    }

    String pointToScore() {
        String result = "";
        switch (score) {
            case 0:
                result = "Love";
                break;
            case 1:
                result = "Fifteen";
                break;
            case 2:
                result = "Thirty";
                break;
            case 3:
                result = "Forty";
                break;
        }
        return result;
    }

    public String compareScoreToString(Player oppositePlayer) {
        int minusResult = this.score-oppositePlayer.score;
        if (minusResult == 1) {
            return "Advantage " + this.playerName;
        } else if (minusResult == -1) {
            return "Advantage " + oppositePlayer.playerName;
        } else if (minusResult >= 2) {
            return "Win for " + this.playerName;
        } else {
            return "Win for " + oppositePlayer.playerName;
        }
    }
}
