package tennisgame1;

public enum Score {
    LOVE("Love"),
    FIFTEEN("Fifteen"),
    THIRTY("Thirty"),
    FORTY("Forty"){
        @Override
        public Score update() {
            return FORTY;
        }
    };

    private String name;

    Score(String name) {
        this.name = name;
    }

    public Score update(){
        return Score.values()[this.ordinal()+1];
    }

    public String toString() {
        return name;
    }
}
