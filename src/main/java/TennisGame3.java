import java.util.Objects;

public class TennisGame3 implements TennisGame {

    public static final int FORTY = 4;
    private int player1score;
    private int player2score;
    private String player1name;
    private String player2name;

    public TennisGame3(String player1name, String player2name) {
        this.player1name = player1name;
        this.player2name = player2name;
    }

    public String getScore() {
        String tennisScore;
        if (bothPlayerAreUnderForty()) {
            String[] tennisScores = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
            tennisScore = tennisScores[player1score];
            return (player1score == player2score) ? tennisScore + "-All" : tennisScore + "-" + tennisScores[player2score];
        } else {
            if (player1score == player2score)
                return "Deuce";
            String playerWithHighestScore;
            playerWithHighestScore = player1score > player2score ? player1name : player2name;
            return ((player1score - player2score)*(player1score - player2score) == 1) ? "Advantage " + playerWithHighestScore : "Win for " + playerWithHighestScore;
        }
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