package tennisgame3;

import tennisgame3.Player;

import java.util.Objects;

public class TennisGame3 implements TennisGame {

    private Player player1;
    private Player player2;

    public TennisGame3(String player1name, String player2name) {
        player1 = new Player(player1name);
        player2 = new Player(player2name);
    }

    public String getScore() {
        if (bothPlayerAreUnderForty()) {
            String player1tennisScore = player1.tennisScore();
            String player2tennisScore = player2.tennisScore();
            return isThereADraw() ? (player1tennisScore + "-All") : (player1tennisScore + "-" + player2tennisScore);
        } else {
            if (isThereADraw()) {
                return "Deuce";
            }
            String playerWithHighestScore = player1.scoreDifferenceWith(player2) > 0 ? player1.getName() : player2.getName();
            return (scoreDifferenceIsOne() ? "Advantage " : "Win for ") + playerWithHighestScore;
        }
    }

    public void wonPoint(String playerName) {
        if (Objects.equals(playerName, player1.getName())) {
            player1.scored();
        } else {
            player2.scored();
        }
    }

    private boolean scoreDifferenceIsOne() {
        return Math.abs(player1.scoreDifferenceWith(player2)) == 1;
    }

    private boolean isThereADraw() {
        return player1.scoreDifferenceWith(player2) == 0;
    }

    private boolean bothPlayerAreUnderForty() {
        return player1.hasLessThanForty() && player2.hasLessThanForty();
    }


}