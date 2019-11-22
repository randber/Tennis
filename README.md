# Description

A simple tennis scoreboard to keep track of a single set of tennis


##Installation

Use the Maven Lifecycle phases 'clean validate compile test package' to generate artificat

##Usage

```java
import au.com.tennis.TennisMatch
    
TennisMatch match = new TennisMatch("Player1", "Player2"); //Starts new game
    
match.pointWonBy("Player1"); //Player 1 score a point
    
match.score(); //Returns scoreboard
 
```
