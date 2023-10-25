import org.example.search.BreadthFirstNode;
import org.example.search.SearchUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SearchTest {
    private static final int[] sortedArray = {1, 2, 3, 5, 6, 7, 8, 9};

    @Test
    @DisplayName("Бинарный поиск")
    void binarySearchTest() {
        Assertions.assertEquals(-1, SearchUtils.binarySearch(sortedArray, 4));
        int expectedIndex = 1;
        Assertions.assertEquals(expectedIndex, SearchUtils.binarySearch(sortedArray, 2));
    }

    @Test
    @DisplayName("Алгоритм Дейкстры")
    void findShortestWayTest() {
        Integer[][] matrix = {
                {null, 2, 6, null, null},
                {null, null, null, 1, null},
                {null, null, null, 1, 1},
                {null, null, null, null, 5},
                {null, null, null, null, null}
        };
        Assertions.assertEquals(7, SearchUtils.findShortestWay(matrix, 0, 4));
        Assertions.assertEquals(6, SearchUtils.findShortestWay(matrix, 0, 2));
        Assertions.assertEquals(3, SearchUtils.findShortestWay(matrix, 0, 3));
        Assertions.assertEquals(1, SearchUtils.findShortestWay(matrix, 2, 4));
        Assertions.assertEquals(5, SearchUtils.findShortestWay(matrix, 3, 4));
    }

    @Test
    @DisplayName("Поиск в ширину")
    void breadthFirstSearchTest() {
        Integer[][] matrix = {
                {null, 2, 3, 4, 5},
                {3, null, 4, 1, 4},
                {6, null, null, 5, 1},
                {null, null, null, null, 5},
                {null, 6, null, 8, null}
        };
        Assertions.assertEquals(new BreadthFirstNode(4,0,3), SearchUtils.breadthFirstSearch(matrix, 0, integer -> integer > 3));
        Assertions.assertEquals(new BreadthFirstNode(6,2,0), SearchUtils.breadthFirstSearch(matrix, 0, integer -> integer > 5));
    }

    @Test
    @DisplayName("Наибольший общий делитель")
    void findGreatestCommonDivisorTest() {
        Assertions.assertEquals(1,SearchUtils.findGreatestCommonDivisor(3,7));
        Assertions.assertEquals(3,SearchUtils.findGreatestCommonDivisor(3,6));
        Assertions.assertEquals(3,SearchUtils.findGreatestCommonDivisor(6,3));
        Assertions.assertEquals(6,SearchUtils.findGreatestCommonDivisor(48,42));
    }

}
