public class Player {
    private String playerName;

    public Player(String playerName) {
        this.playerName = playerName;
    }


    public boolean compareToString(String playerName) {
        return this.playerName.equals(playerName);
    }
}
