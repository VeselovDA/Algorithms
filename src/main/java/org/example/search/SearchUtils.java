package org.example.search;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class SearchUtils {

    public static int binarySearch(int[]array,int desired){
        int lowMarker=0;
        int highMarker=array.length-1;
        int currentIndex;
        while(lowMarker<=highMarker){
            currentIndex=(highMarker+lowMarker)/2;
            if(desired==array[currentIndex]){
                return currentIndex;
            }
            if (desired<array[currentIndex]){
                highMarker=currentIndex-1;
            } else {
                lowMarker=currentIndex+1;
            }
        }
        return -1;//не найден элемент
    }

    public static MyObjForWidthSearch widthSearch(MyObjForWidthSearch myObjForWidthSearch){
        HashSet<MyObjForWidthSearch> searched=new HashSet<>();
        Deque<MyObjForWidthSearch> deque = new LinkedList<>();
        deque.add(myObjForWidthSearch);
        while (!deque.isEmpty()){
            MyObjForWidthSearch checked=deque.removeFirst();
            if(!searched.contains(checked)) {
                if (checked.isStatus()) return checked;
                else {
                    searched.add(checked);
                    deque.addAll(List.of(checked.getSubArray()));
                }
            }
        }
        return null;
    }


}
