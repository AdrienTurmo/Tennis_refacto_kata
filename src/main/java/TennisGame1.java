import java.util.Objects;

public class TennisGame1 implements TennisGame {

    private int m_score1 = 0;
    private Player player1Name;
    private int m_score2 = 0;
    private Player player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = new Player(player1Name);
        this.player2Name = new Player(player2Name);
    }

    public void wonPoint(String playerName) {
        if (player1Name.compareToString(playerName))
            m_score1 += 1;
        else
            m_score2 += 1;
    }

    public String getScore() {
        String score;
        if (m_score1 == m_score2) {
            score = equalityScore();
        } else if (m_score1 >= 4 || m_score2 >= 4) {
            score = highScoreToString();
        } else {
            score = lowScoreToString();
        }
        return score;
    }

    private String highScoreToString() {
        String score;
        int minusResult = m_score1 - m_score2;
        if (minusResult == 1) {
            score = "Advantage player1";
        } else if (minusResult == -1) {
            score = "Advantage player2";
        } else if (minusResult >= 2) {
            score = "Win for player1";
        } else {
            score = "Win for player2";
        }
        return score;
    }

    private String equalityScore() {
        String score;
        switch (m_score1) {
            case 0:
                score = "Love-All";
                break;
            case 1:
                score = "Fifteen-All";
                break;
            case 2:
                score = "Thirty-All";
                break;
            case 3:
                score = "Forty-All";
                break;
            default:
                score = "Deuce";
                break;
        }
        return score;
    }

    private String lowScoreToString() {
        return pointToScore(m_score1) + "-" + pointToScore(m_score2);
    }

    private String pointToScore(int tempScore) {
        String result = "";
        switch (tempScore) {
            case 0:
                result = "Love";
                break;
            case 1:
                result = "Fifteen";
                break;
            case 2:
                result = "Thirty";
                break;
            case 3:
                result = "Forty";
                break;
        }
        return result;
    }
}
