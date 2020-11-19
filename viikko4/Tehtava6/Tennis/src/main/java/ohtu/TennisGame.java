package ohtu;

import java.util.HashMap;

public class TennisGame {

    private HashMap<String, Integer> players;
    private String player1Name;
    private String player2Name;

    public TennisGame(String player1Name, String player2Name) {
        this.players = new HashMap<>();
        this.players.put(player1Name, 0);
        this.players.put(player2Name, 0);
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        players.put(playerName, players.get(playerName) + 1);
    }

    private boolean playerWins(String name1, String name2) {
        return players.get(name1) - players.get(name2) > 1;
    }
    
    private boolean playerHasAdvantage(String name1, String name2) {
        return players.get(name1) - players.get(name2) == 1;
    }
    
    private String getPossiblyWinningScore() {
        
        if(playerWins(player1Name, player2Name)) {
            return "Win for " + player1Name;
        }
        
        if(playerWins(player2Name, player1Name)) {
            return "Win for " + player2Name;
        }
        
        if(playerHasAdvantage(player1Name, player2Name)) {
            return "Advantage " + player1Name;
        }
        
        if(playerHasAdvantage(player2Name, player1Name)) {
            return "Advantage " + player2Name;
        }
        
        return getInProgressScore();

    }
    
    private String getInProgressScore() {
        if(isEvenScore()) {
            return getEvenScoreName();
        }
        return getScoreName(players.get(player1Name)) + "-" + getScoreName(players.get(player2Name));
    }
    
    private String getEvenScoreName() {
        if(players.get(player1Name) == 4) {
            return "Deuce";
        }
        
        return getScoreName(players.get(player1Name)) + "-All";
    }
    
    private String getScoreName(int score) {
        switch(score)
            {
                case 0:
                    return "Love";
                case 1:
                    return "Fifteen";
                case 2:
                    return "Thirty";
                case 3:
                    return "Forty";
                default:
                    return "Deuce";
            }
    }
    
    private boolean isEvenScore() {
        return players.get(player1Name) == players.get(player2Name);
    }
    
    private boolean isPossiblyWinningScore() {
        return players.get(player1Name) >=4 || players.get(player2Name) >=4;
    }

    public String getScore() {
        if (isPossiblyWinningScore()) {
            return getPossiblyWinningScore();
        }
        
        return getInProgressScore();
    }
}