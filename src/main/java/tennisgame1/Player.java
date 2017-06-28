package tennisgame1;

import java.util.Objects;

import static tennisgame1.Score.*;

public class Player {
    private String playerName;
    private int score = 0;
    private Score scoreEnum = LOVE;

    public Player(String playerName) {
        this.playerName = playerName;
    }

    public boolean compareToString(String playerName) {
        return Objects.equals(this.playerName, playerName);
    }

    public void scored(Player oppositePlayer) {
        score++;
        scoreEnum = scoreEnum.scored(oppositePlayer.scoreEnum);
    }

    public void oppositePlayerScored() {
        scoreEnum.oppositePlayerScored();
    }

    public boolean isAtEqualityWith(Player oppositePlayer) {
        return score == oppositePlayer.score;
    }

    public boolean hasMoreThanForty() {
        return this.scoreEnum.ordinal() > FORTY.ordinal();
    }

    public String pointToScore() {
        return this.scoreEnum.toString();
    }

    public String compareScoreToString(Player oppositePlayer) {
        int minusResult = this.score - oppositePlayer.score;
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

    public String equalityScore() {
        if (hasMoreThanForty()) {
            return "Deuce";
        }
        return pointToScore() + "-All";
    }

}
