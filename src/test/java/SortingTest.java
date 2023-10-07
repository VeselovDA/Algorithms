import org.example.sorting.SortingUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class SortingTest {
    private static final int[] arrayForSort = {5, 3, 7, 2, 6, 9, 8, 1};
    private static final int[] expectedArray = {1, 2, 3, 5, 6, 7, 8, 9};

    @Test
    @DisplayName("Сортировка выбором")
    void sortingByChoiceTest() {
        int[] forSortingByChoice = Arrays.copyOf(arrayForSort, arrayForSort.length);
        SortingUtils.sortingByChoice(forSortingByChoice);
        Assertions.assertArrayEquals(expectedArray, forSortingByChoice);
    }

    @Test
    @DisplayName("Быстрая сортировка")
    void quickSortingTest() {
        int[] forSortingByChoice = Arrays.copyOf(arrayForSort, arrayForSort.length);
        SortingUtils.quickSort(forSortingByChoice);
        Assertions.assertArrayEquals(expectedArray, forSortingByChoice);
    }

    @Test
    @DisplayName("Быстрая сортировка другим способом")
    void quickSortingTestOtherMethod() {
        int[] forSortingByChoice = Arrays.copyOf(arrayForSort, arrayForSort.length);
        SortingUtils.qSort(forSortingByChoice);
        Assertions.assertArrayEquals(expectedArray, forSortingByChoice);
    }

    @Test
    @DisplayName("Сортировка пузырьком")
    void bubbleSortingTest() {
        int[] forSortingByChoice = Arrays.copyOf(arrayForSort, arrayForSort.length);
        SortingUtils.bubbleSorting(forSortingByChoice);
        Assertions.assertArrayEquals(expectedArray, forSortingByChoice);
    }

}
