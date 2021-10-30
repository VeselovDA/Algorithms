package org.example;

import org.example.sorting.SortingUtils;
import java.util.Arrays;

public class Application {
    static final int[] arrayForSort={5,3,7,2,6,9,8,1};
    public static void main(String[] args) {
        System.out.println("Hello word!");
        //сортировка выбором
        int[] forSortingByChoice=arrayForSort;
        SortingUtils.sortingByChoice(forSortingByChoice);
        System.out.println(Arrays.toString(forSortingByChoice));
        //быстрая сортировка
        forSortingByChoice=arrayForSort;
        SortingUtils.quickSort(forSortingByChoice,0,forSortingByChoice.length-1);
        System.out.println(Arrays.toString(forSortingByChoice));

    }
}
