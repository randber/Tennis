package au.com.tennis;

import org.junit.Test;
import static org.junit.Assert.*;

import au.com.tennis.TennisMatch;

public class TennisMatchTest {

    @Test
    public void testStraightWinGame(){

        TennisMatch match = new TennisMatch("Boris", "Rafa");

        match.pointWonBy("Boris");

        assertEquals("Boris is leading by 15 points", "0 - 0 , 15 - 0", match.score());

        match.pointWonBy("Boris");

        assertEquals("Boris is leading by 30 points", "0 - 0 , 30 - 0", match.score());

        match.pointWonBy("Boris");

        assertEquals("Boris is leading by 40 points", "0 - 0 , 40 - 0", match.score());

        match.pointWonBy("Boris");

        assertEquals("Boris wins first game and next match score is back to zero", "1 - 0 , 0 - 0", match.score());


    }

    @Test
    public void testBothPlayersScoreButNoDeuceORAdavantageGame(){

        TennisMatch match = new TennisMatch("Boris", "Rafa");

        match.pointWonBy("Boris");
        match.pointWonBy("Boris");
        match.pointWonBy("Boris");
        match.pointWonBy("Rafa");
        match.pointWonBy("Rafa");

        assertEquals("Boris has 40 points and Rafa has 30 points", "0 - 0 , 40 - 30", match.score());

        match.pointWonBy("Boris");

        assertEquals("Boris wins first game and next match score is back to zero", "1 - 0 , 0 - 0", match.score());

    }

    @Test
    public void testDeuceCondituonGame(){

        TennisMatch match = new TennisMatch("Boris", "Rafa");

        match.pointWonBy("Boris");
        match.pointWonBy("Boris");
        match.pointWonBy("Boris");
        match.pointWonBy("Rafa");
        match.pointWonBy("Rafa");
        match.pointWonBy("Rafa");

        assertEquals("Both players are Deuce", "0 - 0 , Deuce", match.score());

        match.pointWonBy("Boris");
        match.pointWonBy("Rafa");

        assertEquals("Both players are Deuce", "0 - 0 , Deuce", match.score());

        match.pointWonBy("Boris");
        match.pointWonBy("Boris");


        assertEquals("Boris wins first game and next match score is back to zero", "1 - 0 , 0 - 0", match.score());

    }

    @Test
    public void testAdvantageConditinGame(){

        TennisMatch match = new TennisMatch("Boris", "Rafa");

        match.pointWonBy("Boris");
        match.pointWonBy("Boris");
        match.pointWonBy("Boris");
        match.pointWonBy("Rafa");
        match.pointWonBy("Rafa");
        match.pointWonBy("Rafa");
        match.pointWonBy("Boris");

        assertEquals("Boris has advantage", "0 - 0 , Boris has advantage", match.score());

        match.pointWonBy("Rafa");
        match.pointWonBy("Rafa");

        assertEquals("Rafa has advantage", "0 - 0 , Rafa has advantage", match.score());

        match.pointWonBy("Rafa");

        assertEquals("Rafa wins first game and next match score is back to zero", "0 - 1 , 0 - 0", match.score());


    }

    @Test
    public void testStraightSetMatch(){

        TennisMatch match = new TennisMatch("Boris", "Rafa");

        for (int i = 0; i < 24; i++){
            match.pointWonBy("Boris");
        }

        assertEquals("Boris wins match", "6 - 0 , Boris has won the match", match.score());
    }

    @Test
    public void testNormalSetVicotry(){

        TennisMatch match = new TennisMatch("Boris", "Rafa");

        for (int i = 0; i < 16; i++){
            match.pointWonBy("Boris");
        }

        for (int i = 0; i < 16; i++){
            match.pointWonBy("Rafa");
        }

        assertEquals("Both players are level at 4 games each", "4 - 4 , 0 - 0", match.score());

        for (int i = 0; i < 8; i++){
            match.pointWonBy("Rafa");
        }


        assertEquals("Rafa wins the set at 6 games to 4", "4 - 6 , Rafa has won the match", match.score());

    }

    @Test
    public void testTwoGameVictorySet(){

        TennisMatch match = new TennisMatch("Boris", "Rafa");

        for (int i = 0; i < 20; i++){
            match.pointWonBy("Boris");
        }


        for (int i = 0; i < 20; i++){
            match.pointWonBy("Rafa");
        }

        assertEquals("Both players have won 5 games each", "5 - 5 , 0 - 0", match.score());

        for (int i = 0; i < 8; i++){
            match.pointWonBy("Boris");
        }

        assertEquals("Boris wins match by 7 games to 5", "7 - 5 , Boris has won the match", match.score());


    }


}
