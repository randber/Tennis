package au.com.tennis;

/**
 * @author Alan Clarke
 *
 * Single set of Tennis score tracker
 * Assume client will perform input validation and handle the start of new matches
 *
 */


public class TennisMatch implements Game {

    private Player player1;
    private Player player2;

    public TennisMatch(String player1, String player2) {
        this.player1 = new Player(player1);
        this.player2 = new Player(player2);
    }

    public void pointWonBy(String player) {
        if (player1.getPlayerName().equals(player)) {
            player1.scoreGamePoint();
        } else {
            player2.scoreGamePoint();
        }
        checkGameScore();
    }

    public String score() {
        String[] score_word = {"0", "15", "30", "40"};
        String gameScore = player1.getGamesWon() + " - " + player2.getGamesWon();
        String matchScore = "";

        if (hasMatchBeenWon()) {
            matchScore = matchWinner().getPlayerName() + " has won the match";
        } else if (deuce()) {
            matchScore = "Deuce";
        } else if (advantage()) {
            matchScore = gameLeader().getPlayerName() + " has advantage";
        } else {
            matchScore = score_word[player1.getGameScore()] + " - " + score_word[player2.getGameScore()];
        }

        return gameScore + " , " + matchScore;

    }

    private void checkGameScore() {
        if (hasGameBeenWon() && !hasMatchBeenWon()) {
            gameLeader().winGame();
            player1.startNextMatch();
            player2.startNextMatch();
        }
    }

    private Player gameLeader() {
        if (player1.getGameScore() > player2.getGameScore()) {
            return player1;
        }
        return player2;
    }

    private Player matchWinner() {
        if (player1.getGamesWon() > player2.getGamesWon()) {
            return player1;
        }
        return player2;
    }

    private boolean greaterThan3Points() {
        return (player1.getGameScore() >= 4 || player2.getGameScore() >= 4);
    }

    private boolean score3Points() {
        return (player1.getGameScore() >= 3 && player2.getGameScore() >= 3);
    }

    private boolean deuce() {
        return ((score3Points() && (player1.getGameScore() == player2.getGameScore())));
    }

    private boolean advantage() {
        return ((score3Points() && (player1.getGameScore() != player2.getGameScore())));
    }

    private boolean matchScoreDifference() {
        int diff = Math.abs(player1.getGameScore() - player2.getGameScore());
        return (diff >= 2);
    }

    private boolean played6Games() {
        return (player1.getGamesWon() >= 6 || player2.getGamesWon() >= 6);
    }

    private boolean getSetScoreDiffernce() {
        int diff = Math.abs(player1.getGamesWon() - player2.getGamesWon());
        return (diff >= 2);
    }

    private boolean hasGameBeenWon() {
        return (greaterThan3Points() && matchScoreDifference());
    }

    private boolean hasMatchBeenWon() {
        return ((played6Games()) && getSetScoreDiffernce());
    }

}
