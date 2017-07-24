import java.util.Objects;

public class TennisGame2 implements TennisGame {
    private int P1point = 0;
    private int P2point = 0;

    private String player1Name;
    private String player2Name;

    TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore() {
        String p1res = "";
        String p2res = "";

        String score = "";
        if (P1point == P2point && P1point < 4) {
            if (P1point == 0)
                score = "Love";
            if (P1point == 1)
                score = "Fifteen";
            if (P1point == 2)
                score = "Thirty";
            if (P1point == 3)
                score = "Forty";
            score += "-All";
        }
        if (P1point == P2point && P1point > 3)
            score = "Deuce";

        if (P1point > 0 && P2point == 0) {
            if (P1point == 1)
                p1res = "Fifteen";
            if (P1point == 2)
                p1res = "Thirty";
            if (P1point == 3)
                p1res = "Forty";

            p2res = "Love";
            score = p1res + "-" + p2res;
        }
        if (P2point > 0 && P1point == 0) {
            if (P2point == 1)
                p2res = "Fifteen";
            if (P2point == 2)
                p2res = "Thirty";
            if (P2point == 3)
                p2res = "Forty";

            p1res = "Love";
            score = p1res + "-" + p2res;
        }

        if (P1point > P2point && P1point < 4) {
            if (P1point == 2)
                p1res = "Thirty";
            if (P1point == 3)
                p1res = "Forty";
            if (P2point == 1)
                p2res = "Fifteen";
            if (P2point == 2)
                p2res = "Thirty";
            score = p1res + "-" + p2res;
        }
        if (P2point > P1point && P2point < 4) {
            if (P2point == 2)
                p2res = "Thirty";
            if (P2point == 3)
                p2res = "Forty";
            if (P1point == 1)
                p1res = "Fifteen";
            if (P1point == 2)
                p1res = "Thirty";
            score = p1res + "-" + p2res;
        }

        if (P1point > P2point && P2point >= 3) {
            score = "Advantage "+player1Name;
        }

        if (P2point > P1point && P1point >= 3) {
            score = "Advantage " + player2Name;
        }

        if (P1point >= 4 && P2point >= 0 && (P1point - P2point) >= 2) {
            score = "Win for "+player1Name;
        }
        if (P2point >= 4 && P1point >= 0 && (P2point - P1point) >= 2) {
            score = "Win for "+player2Name;
        }
        return score;
    }

    public void wonPoint(String player) {
        if (Objects.equals(player, player1Name))
            P1point++;
        else
            P2point++;
    }
}