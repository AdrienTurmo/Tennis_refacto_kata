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
        String p1res = "";
        String p2res = "";

        String score = "";
        if (player1.getPoint() == player2.getPoint() && player1.getPoint() < 4) {
            if (player1.getPoint() == 0)
                score = "Love";
            if (player1.getPoint() == 1)
                score = "Fifteen";
            if (player1.getPoint() == 2)
                score = "Thirty";
            if (player1.getPoint() == 3)
                score = "Forty";
            score += "-All";
        }
        if (player1.getPoint() == player2.getPoint() && player1.getPoint() > 3)
            score = "Deuce";

        if (player1.getPoint() > 0 && player2.getPoint() == 0) {
            if (player1.getPoint() == 1)
                p1res = "Fifteen";
            if (player1.getPoint() == 2)
                p1res = "Thirty";
            if (player1.getPoint() == 3)
                p1res = "Forty";

            p2res = "Love";
            score = p1res + "-" + p2res;
        }
        if (player2.getPoint() > 0 && player1.getPoint() == 0) {
            if (player2.getPoint() == 1)
                p2res = "Fifteen";
            if (player2.getPoint() == 2)
                p2res = "Thirty";
            if (player2.getPoint() == 3)
                p2res = "Forty";

            p1res = "Love";
            score = p1res + "-" + p2res;
        }

        if (player1.getPoint() > player2.getPoint() && player1.getPoint() < 4) {
            if (player1.getPoint() == 2)
                p1res = "Thirty";
            if (player1.getPoint() == 3)
                p1res = "Forty";
            if (player2.getPoint() == 1)
                p2res = "Fifteen";
            if (player2.getPoint() == 2)
                p2res = "Thirty";
            score = p1res + "-" + p2res;
        }
        if (player2.getPoint() > player1.getPoint() && player2.getPoint() < 4) {
            if (player2.getPoint() == 2)
                p2res = "Thirty";
            if (player2.getPoint() == 3)
                p2res = "Forty";
            if (player1.getPoint() == 1)
                p1res = "Fifteen";
            if (player1.getPoint() == 2)
                p1res = "Thirty";
            score = p1res + "-" + p2res;
        }

        if (player1.getPoint() > player2.getPoint() && player2.getPoint() >= 3) {
            score = "Advantage "+ player1.getName();
        }

        if (player2.getPoint() > player1.getPoint() && player1.getPoint() >= 3) {
            score = "Advantage " + player2.getName();
        }

        if (player1.getPoint() >= 4 && player2.getPoint() >= 0 && (player1.getPoint() - player2.getPoint()) >= 2) {
            score = "Win for "+ player1.getName();
        }
        if (player2.getPoint() >= 4 && player1.getPoint() >= 0 && (player2.getPoint() - player1.getPoint()) >= 2) {
            score = "Win for "+ player2.getName();
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