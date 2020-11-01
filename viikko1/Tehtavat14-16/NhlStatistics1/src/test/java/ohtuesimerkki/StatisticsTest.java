package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class StatisticsTest {
 
    Reader readerStub = new Reader() {
 
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();
 
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
 
            return players;
        }
    };
 
    Statistics stats;

    @Before
    public void setUp(){
        // luodaan Statistics-olio joka k‰ytt‰‰ "stubia"
        stats = new Statistics(readerStub);
    }
    
    @Test
    public void playersCanBeSearched() {
        Player testPlayer = stats.search("Kurri");
        assertEquals("Kurri", testPlayer.getName());
    }
    
    @Test
    public void searchReturnsNullForNoResults() {
        Player testPlayer = stats.search("Kekkonen");
        assertEquals(null, testPlayer);
    }
    
    @Test
    public void playersOfTeamCanBeListed() {
        List<Player> testPlayer = stats.team("EDM");
        assertEquals(3, testPlayer.size());
    }
    
    @Test
    public void topScorersCanBeListed() {
        List<Player> topScorers = stats.topScorers(1);
        assertEquals(2, topScorers.size());
        assertEquals(124, topScorers.get(0).getPoints());
        assertEquals(99, topScorers.get(1).getPoints());
    }
}
