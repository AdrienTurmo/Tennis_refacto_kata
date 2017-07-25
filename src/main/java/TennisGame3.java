import tennisgame3.Player;
import tennisgame3.TennisScore;

import java.util.Objects;

public class TennisGame3 implements TennisGame {

    private static final int FORTY = 4;
    private Player player1;

    private int player1points;
    private String player1name;
    private int player2points;
    private String player2name;

    public TennisGame3(String player1name, String player2name) {
        player1 = new Player(player1name);

        this.player1name = player1name;
        this.player2name = player2name;
    }

    public String getScore() {
        if (bothPlayerAreUnderForty()) {
            String player1tennisScore = pointToTennisScore(player1points);
            String player2tennisScore = pointToTennisScore(player2points);
            return thereIsADraw() ? (player1tennisScore + "-All") : (player1tennisScore + "-" + player2tennisScore);
        } else {
            if (thereIsADraw()) {
                return "Deuce";
            }
            String playerWithHighestScore;
            playerWithHighestScore = player1points > player2points ? player1name : player2name;
            return scoreDifferenceIsOne() ? "Advantage " + playerWithHighestScore : "Win for " + playerWithHighestScore;
        }
    }

    public void wonPoint(String playerName) {
        if (Objects.equals(playerName, player1.getName())) {
            player1.scored();
            this.player1points += 1;
        }
        else {
            this.player2points += 1;
        }
    }

    private boolean scoreDifferenceIsOne() {
        return Math.abs(player1points - player2points) == 1;
    }

    private boolean thereIsADraw() {
        return player1points == player2points;
    }

    private String pointToTennisScore(int playerScore) {
        return TennisScore.tennisScoreOf(playerScore);
    }
    private boolean bothPlayerAreUnderForty() {
        return player1points < FORTY && player2points < FORTY;
    }


}