import tennisgame1.Player;

public class TennisGame1 implements TennisGame {

    private Player player1;
    private Player player2;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1 = new Player(player1Name);
        this.player2 = new Player(player2Name);
    }

    public void wonPoint(String playerName) {
        if (player1.compareToString(playerName)) {
            player1.scored(player2);
            player2.oppositePlayerScored(player1);
        } else {
            player2.scored(player1);
            player1.oppositePlayerScored(player2);
        }
    }

    public String getScore() {
        if (player1.isAtEqualityWith(player2)) {
            return player1.equalityScore();
        } else if (player1.hasMoreThanForty() || player2.hasMoreThanForty()) {
            return player1.compareScoreToString(player2);
        } else {
            return player1.pointToScore() + "-" + player2.pointToScore();
        }
    }

}
