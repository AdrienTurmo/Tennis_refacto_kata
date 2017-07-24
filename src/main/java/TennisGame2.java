import tennisgame2.Player;

import java.util.Objects;

public class TennisGame2 implements TennisGame {
    public static final int FORTY = 4;
    private Player player1;
    private Player player2;

    TennisGame2(String player1Name, String player2Name) {
        this.player1 = new Player(player1Name);
        this.player2 = new Player(player2Name);
    }

    public String getScore() {
        String score = "";
        int player1Points = player1.getPoints();
        int player2Points = player2.getPoints();

        if (player1Points == player2Points) {
            if (player1.hasLessThan(FORTY)) {
                score = player1.tennisScore();
                score += "-All";
            } else {
                score = "Deuce";
            }
        }

        if (player1Points != player2Points && player1.hasLessThan(FORTY) && player2.hasLessThan(FORTY)) {
            score = player1.tennisScore() + "-" + player2.tennisScore();
        } else {
            int scoreDifference = player1.compareScoreTo(player2);

            if (scoreDifference >= 1) {
                score = "Advantage " + player1.getName();
            }
            if (scoreDifference <= -1) {
                score = "Advantage " + player2.getName();
            }
            if (scoreDifference >= 2) {
                score = "Win for " + player1.getName();
            }
            if (scoreDifference <= -2) {
                score = "Win for " + player2.getName();
            }
        }
        return score;
    }

    public void wonPoint(String player) {
        if (Objects.equals(player, player1.getName()))
            player1.scored();
        else
            player2.scored();
    }
}