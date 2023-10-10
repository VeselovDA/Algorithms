import org.example.interview.IslandFinder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IslandFinderTest {

    @Test
    void islandFinderTest() {
        boolean[][] mapIsland = {
                {true,false,false},
                {false,true,true},
                {true,true,true}
        };
        Assertions.assertEquals(2, IslandFinder.getIslandCounter(mapIsland));

        boolean[][] mapIsland1 = {
                {true,true,true},
                {false,true,false},
                {false,false,false},
                {true,false,true}
        };
        Assertions.assertEquals(3, IslandFinder.getIslandCounter(mapIsland1));

        boolean[][] mapIsland2 = {
                {true,true,false},
                {false,true,false},
                {false,true,true},
                {false,false,true}
        };
        Assertions.assertEquals(1, IslandFinder.getIslandCounter(mapIsland2));
    }
}
