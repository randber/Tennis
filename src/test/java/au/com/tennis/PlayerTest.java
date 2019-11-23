package au.com.tennis;

import org.junit.Test;
import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void testAddPlayerName(){

        Player player = new Player("Alan");

        assertEquals("Name is Alan", "Alan", player.getPlayerName());
        assertEquals("GameScore is zero", 0, player.getGameScore());
        assertEquals("Games won is zero", 0 ,player.getGamesWon());

        assertEquals("toString function containe name and zero scores",
                "Player{playerName='Alan', gameScore=0, gamesWon=0}",
                player.toString());

    }

    @Test
    public void testScoreGamePoint(){

        Player player = new Player("Alan");

        player.scoreGamePoint();
        assertEquals("Game score is 1", 1 ,player.getGameScore());

    }

    @Test
    public void testStartNextMatch(){

        Player player = new Player("Alan");

        player.scoreGamePoint();

        assertEquals("Game score is 1 ", 1 ,player.getGameScore());

        player.startNextMatch();

        assertEquals("Game score is zero", 0 ,player.getGameScore());

    }

    @Test
    public void testWinGame(){

        Player player = new Player("Alan");

        player.winGame();

        assertEquals("Number of games won is 1", 1 ,player.getGamesWon());


    }

    @Test
    public void testToStringMethod(){

        Player player = new Player("Alan");

        player.winGame();
        player.scoreGamePoint();

        assertEquals("toString function containe name and gameScore = 1 and gamsWon = 1",
                "Player{playerName='Alan', gameScore=1, gamesWon=1}",
                player.toString());


    }



}
