package tennisgame1;

import java.util.Objects;

import static tennisgame1.Score.*;

public class Player {
    private String playerName;
    private Score scoreEnum = LOVE;

    public Player(String playerName) {
        this.playerName = playerName;
    }

    public boolean compareToString(String playerName) {
        return Objects.equals(this.playerName, playerName);
    }

    public void scored(Player oppositePlayer) {
        scoreEnum = scoreEnum.scored(oppositePlayer.scoreEnum);
    }

    public void oppositePlayerScored() {
        scoreEnum = scoreEnum.oppositePlayerScored();
    }

    public boolean isAtEqualityWith(Player oppositePlayer) {
        return scoreEnum == oppositePlayer.scoreEnum;
    }

    public boolean hasMoreThanForty() {
        return this.scoreEnum.ordinal() > FORTY.ordinal();
    }

    public String pointToScore() {
        return this.scoreEnum.toString();
    }

    public String compareScoreToString(Player oppositePlayer) {
        if (this.scoreEnum.ordinal()>oppositePlayer.scoreEnum.ordinal()) {
            return scoreEnum.toString() + this.playerName;
        }
            return oppositePlayer.scoreEnum.toString() + oppositePlayer.playerName;
    }

    public String equalityScore() {
        if (hasMoreThanForty()) {
            return "Deuce";
        }
        return pointToScore() + "-All";
    }

}
