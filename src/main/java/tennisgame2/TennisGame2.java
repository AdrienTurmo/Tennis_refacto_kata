package tennisgame2;

import tennisgame2.Player;

import java.util.Objects;

public class TennisGame2 implements TennisGame {
    private Player player1;
    private Player player2;

    TennisGame2(String player1Name, String player2Name) {
        this.player1 = new Player(player1Name);
        this.player2 = new Player(player2Name);
    }

    public String getScore() {
        int scoreDifference = player1.scoreDifferenceWith(player2);

        if (bothPlayerAreUnderForty()) {
            return player1.tennisScore() + "-" + (scoreDifference == 0 ? "All" : player2.tennisScore());
        }

        if (scoreDifference == 0) {
            return "Deuce";
        }

        String score;
        if (Math.abs(scoreDifference) == 1) {
            score = "Advantage ";
        } else {
            score = "Win for ";
        }

        if (scoreDifference > 0) {
            score += player1.getName();
        } else {
            score += player2.getName();
        }

        return score;
    }

    private boolean bothPlayerAreUnderForty() {
        return player1.hasLessThanForty() && player2.hasLessThanForty();
    }

    public void wonPoint(String player) {
        if (Objects.equals(player, player1.getName()))
            player1.scored();
        else
            player2.scored();
    }
}