import tennisgame3.Player;
import tennisgame3.TennisScore;

import java.util.Objects;

public class TennisGame3 implements TennisGame {

    private static final int FORTY = 4;
    private Player player2;
    private Player player1;

    public TennisGame3(String player1name, String player2name) {
        player1 = new Player(player1name);
        player2 = new Player(player2name);
    }

    public String getScore() {
        if (bothPlayerAreUnderForty()) {
            String player1tennisScore = pointToTennisScore(player1.getPoints());
            String player2tennisScore = pointToTennisScore(player2.getPoints());
            return thereIsADraw() ? (player1tennisScore + "-All") : (player1tennisScore + "-" + player2tennisScore);
        } else {
            if (thereIsADraw()) {
                return "Deuce";
            }
            String playerWithHighestScore;
            playerWithHighestScore = player1.getPoints() > player2.getPoints() ? player1.getName() : player2.getName();
            return scoreDifferenceIsOne() ? "Advantage " + playerWithHighestScore : "Win for " + playerWithHighestScore;
        }
    }

    public void wonPoint(String playerName) {
        if (Objects.equals(playerName, player1.getName())) {
            player1.scored();
        }
        else {
            player2.scored();
        }
    }

    private boolean scoreDifferenceIsOne() {
        return Math.abs(player1.getPoints() - player2.getPoints()) == 1;
    }

    private boolean thereIsADraw() {
        return player1.getPoints() == player2.getPoints();
    }

    private String pointToTennisScore(int playerScore) {
        return TennisScore.tennisScoreOf(playerScore);
    }
    private boolean bothPlayerAreUnderForty() {
        return player1.getPoints() < FORTY && player2.getPoints() < FORTY;
    }


}