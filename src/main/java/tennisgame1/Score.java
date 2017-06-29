package tennisgame1;

public enum Score {
    LOVE("Love"),
    FIFTEEN("Fifteen"),
    THIRTY("Thirty"),
    FORTY("Forty"){
        @Override
        public Score scored(Score oppositePlayerScore) {
            if (oppositePlayerScore.ordinal()<3){
                return WIN;
            }
            if (oppositePlayerScore == FORTY) {
                return ADVANTAGE;
            }
            return DEUCE;
        }
    },
    DEUCE("Deuce"){
        @Override
        public Score scored(Score oppositePlayerScore) {
            return ADVANTAGE;
        }

        @Override
        public Score oppositePlayerScored(Score oppositePlayerScore) {
            return FORTY;
        }
    },
    ADVANTAGE("Advantage ") {
        @Override
        public Score oppositePlayerScored(Score oppositePlayerScore) {
            return DEUCE;
        }
    },
    WIN("Win for ") {
        @Override
        public Score scored(Score oppositePlayerScore) {
            return WIN;
        }
    };

    private String name;

    Score(String name) {
        this.name = name;
    }

    public Score oppositePlayerScored(Score oppositePlayerScore) {
        return this;
    }

    public Score scored(Score oppositePlayerScore) {
        return Score.values()[this.ordinal() + 1];
    }

    public String toString() {
        return name;
    }
}
