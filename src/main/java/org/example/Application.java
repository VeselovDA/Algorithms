package org.example;

import org.example.sorting.SortingUtils;
import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        System.out.println("Hello word!");
        int[] arrayForSort={5,3,7,2,6,9,8,1};
        SortingUtils.sortingByChoice(arrayForSort);
        System.out.println(Arrays.toString(arrayForSort));

    }
}
