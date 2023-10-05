package org.example;

import org.example.search.MyObjForWidthSearch;
import org.example.search.SearchUtils;
import org.example.sorting.SortingUtils;
import java.util.Arrays;

public class Application {
    static final int[] arrayForSort={5,3,7,2,6,9,8,1};
    public static void main(String[] args) {
        System.out.println("Hello word!");
        //сортировка выбором
        int[] forSortingByChoice=Arrays.copyOf(arrayForSort,arrayForSort.length);
        SortingUtils.sortingByChoice(forSortingByChoice);
        System.out.println(Arrays.toString(forSortingByChoice));
        //быстрая сортировка
        forSortingByChoice=Arrays.copyOf(arrayForSort,arrayForSort.length);
        SortingUtils.quickSort(forSortingByChoice);
        System.out.println(Arrays.toString(forSortingByChoice));

        forSortingByChoice=Arrays.copyOf(arrayForSort,arrayForSort.length);
        SortingUtils.qSort(forSortingByChoice);
        System.out.println(Arrays.toString(forSortingByChoice));
        //бинарный поиск
        System.out.println(SearchUtils.binarySearch(forSortingByChoice,4));
        //поиск в ширину
        MyObjForWidthSearch found=SearchUtils.widthSearch(createTestDataForWidthSearch());
        System.out.println(found==null?"не найден":found.getName());
    }
    //создание тестового экземпляра для поиска
    private static MyObjForWidthSearch createTestDataForWidthSearch(){
        MyObjForWidthSearch myObjForWidthSearch=new MyObjForWidthSearch("Dmitriy",false,
                new MyObjForWidthSearch[]{
                        new MyObjForWidthSearch("Petya", false, new MyObjForWidthSearch[]{}),
                        new MyObjForWidthSearch("Vasya", false, new  MyObjForWidthSearch[]{
                                new MyObjForWidthSearch("Natasha", true,  new MyObjForWidthSearch[]{})})
                });
        myObjForWidthSearch.getSubArray()[0]
                .setSubArray(
                        new MyObjForWidthSearch[]{myObjForWidthSearch});//для проверки зацикленности поиска в ширину
        return myObjForWidthSearch;
    }
}
