package tennisgame1;

public enum Score {
    LOVE("Love"),
    FIFTEEN("Fifteen"),
    THIRTY("Thirty"),
    FORTY("Forty"){
        @Override
        public Score scored(Score scoreEnum) {
            if (scoreEnum.ordinal()<3){
                return WIN;
            };
            return DEUCE;
        }

        @Override
        public Score oppositePlayerScored() {
            return DEUCE;
        }
    },
    DEUCE("Deuce"),
    ADVANTAGE("Advantage") {
        @Override
        public Score oppositePlayerScored() {
            return DEUCE;
        }
    },
    WIN("Win") {
        @Override
        public Score scored(Score scoreEnum) {
            return WIN;
        }
    };

    private String name;

    Score(String name) {
        this.name = name;
    }

    public Score oppositePlayerScored() {
        return this;
    }

    public Score scored(Score scoreEnum) {
        return Score.values()[this.ordinal() + 1];
    }

    public String toString() {
        return name;
    }
}
