package org.example.search;

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
}
