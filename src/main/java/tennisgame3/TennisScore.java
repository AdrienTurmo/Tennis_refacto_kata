package tennisgame3;

import java.util.Arrays;

public enum TennisScore {
    Love(0),
    Fifteen(1),
    Thirty(2),
    Forty(3);

    private int score;

    TennisScore(int score) {
        this.score = score;
    }

    public int getScore(){
        return score;
    }

    public static String tennisScoreOf(int playerScore) {
        return Arrays.stream(TennisScore.values())
                .filter(tennisScore -> tennisScore.score == playerScore)
                .findFirst()
                .get()
                .name();
    }
}
