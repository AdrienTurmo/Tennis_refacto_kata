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
        String player1TennisScore = "";
        String player2TennisScore = "";

        String score = "";
        int player1Point = player1.getPoint();
        int player2Point = player2.getPoint();

        if (player1Point == player2Point && player1Point < 4) {
            score = pointToTennisScore(player1Point);
            score += "-All";
        }

        if (player1Point == player2Point && player1Point > 3) {
            score = "Deuce";
        }

        if (player1Point > player2Point && player1Point < 4) {
            player1TennisScore = pointToTennisScore(player1Point);
            player2TennisScore = pointToTennisScore(player2Point);
            score = player1TennisScore + "-" + player2TennisScore;
        }

        if (player2Point > player1Point && player2Point < 4) {
            player2TennisScore = pointToTennisScore(player2Point);
            player1TennisScore = pointToTennisScore(player1Point);
            score = player1TennisScore + "-" + player2TennisScore;
        }

        if (player1Point > player2Point && player2Point >= 3) {
            score = "Advantage " + player1.getName();
        }

        if (player2Point > player1Point && player1Point >= 3) {
            score = "Advantage " + player2.getName();
        }

        if (player1Point >= 4 && player2Point >= 0 && (player1Point - player2Point) >= 2) {
            score = "Win for " + player1.getName();
        }
        if (player2Point >= 4 && player1Point >= 0 && (player2Point - player1Point) >= 2) {
            score = "Win for " + player2.getName();
        }
        return score;
    }

    private String pointToTennisScore(int player1Point) {
        String player1TennisScore;
        player1TennisScore = "";
        if (player1Point == 0) {
            player1TennisScore = "Love";

        } else if (player1Point == 1) {
            player1TennisScore = "Fifteen";

        } else if (player1Point == 2) {
            player1TennisScore = "Thirty";

        } else if (player1Point == 3) {
            player1TennisScore = "Forty";
        }
        return player1TennisScore;
    }

    public void wonPoint(String player) {
        if (Objects.equals(player, player1.getName()))
            player1.scored();
        else
            player2.scored();
    }
}