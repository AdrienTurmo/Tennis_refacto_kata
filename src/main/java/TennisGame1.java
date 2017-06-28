public class TennisGame1 implements TennisGame {

    private Player player1;
    private Player player2;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1 = new Player(player1Name);
        this.player2 = new Player(player2Name);
    }

    public void wonPoint(String playerName) {
        if (player1.compareToString(playerName)) {
            player1.updateScore();
        } else {
            player2.updateScore();
        }
    }

    public String getScore() {
        if (player1.isAtEqualityWith(player2)) {
            return equalityScore();
        } else if (player1.hasMoreThan(4) || player2.hasMoreThan(4)) {
            return highScoreToString();
        } else {
            return lowScoreToString();
        }
    }

    private String highScoreToString() {
        String score;
        int minusResult = player1.compareScoreTo(player2);
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
        switch (player1.getScore()) {
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
        return pointToScore(player1.getScore()) + "-" + pointToScore(player2.getScore());
    }

    private String pointToScore(int score) {
        String result = "";
        switch (score) {
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
