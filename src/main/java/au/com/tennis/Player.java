package au.com.tennis;

public class Player {

    private String playerName;
    private int gameScore;
    private int gamesWon;

    public Player(String playerName) {
        this.playerName = playerName;
        this.gameScore = 0;
        this.gamesWon = 0;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getGameScore() {
        return gameScore;
    }

    public int getGamesWon() {
        return gamesWon;
    }


    public void scoreGamePoint() {
        gameScore++;
    }

    public void winGame() {
        gamesWon++;
    }

    public void startNextMatch() {
        this.gameScore = 0;
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerName='" + playerName + '\'' +
                ", gameScore=" + gameScore +
                ", gamesWon=" + gamesWon +
                '}';
    }
}
