import tennisgame3.TennisScore;

import java.util.Objects;

import static tennisgame3.TennisScore.*;

public class TennisGame3 implements TennisGame {

    public static final int FORTY = 4;
    private int player1score;
    private int player2score;
    private String player1name;
    private String player2name;
    private TennisScore[] tennisScores = new TennisScore[]{Love, Fifteen, Thirty, Forty};

    public TennisGame3(String player1name, String player2name) {
        this.player1name = player1name;
        this.player2name = player2name;
    }

    public String getScore() {
        if (bothPlayerAreUnderForty()) {
            String player1tennisScore = pointToTennisScore(player1score);
            String player2tennisScore = pointToTennisScore(player2score);
            return thereIsADraw() ? (player1tennisScore + "-All") : (player1tennisScore + "-" + player2tennisScore);
        } else {
            if (thereIsADraw()) {
                return "Deuce";
            }
            String playerWithHighestScore;
            playerWithHighestScore = player1score > player2score ? player1name : player2name;
            return scoreDifferenceIsOne() ? "Advantage " + playerWithHighestScore : "Win for " + playerWithHighestScore;
        }
    }

    private boolean scoreDifferenceIsOne() {
        return Math.abs(player1score - player2score) == 1;
    }

    private boolean thereIsADraw() {
        return player1score == player2score;
    }

    private String pointToTennisScore(int playerScore) {
        return tennisScores[playerScore].name();
    }

    private boolean bothPlayerAreUnderForty() {
        return player1score < FORTY && player2score < FORTY;
    }

    public void wonPoint(String playerName) {
        if (Objects.equals(playerName, player1name))
            this.player1score += 1;
        else
            this.player2score += 1;

    }

}