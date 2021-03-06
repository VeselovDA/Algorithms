package org.example.sorting;

import java.util.Arrays;

public class SortingUtils {

    public static void sortingByChoice(int[] array) {

        for (int leftIndex = 0; leftIndex < array.length; leftIndex++) {
            int minIndex = leftIndex;
            for (int currentInd = leftIndex; currentInd < array.length; currentInd++) {
                if (array[currentInd] < array[minIndex]) {
                    minIndex = currentInd;
                }
            }
            swapInArray(array, leftIndex, minIndex);
        }
    }

    public static void quickSort(int[] source, int leftBorder, int rightBorder) {
        int leftMarker = leftBorder;
        int rightPointer = rightBorder;
        int centerElement = source[(leftMarker + rightPointer) / 2];
        do {
            while (source[leftMarker] < centerElement) {
                leftMarker++;
            }
            while (source[rightPointer] > centerElement) {
                rightPointer--;
            }

            if (leftMarker <= rightPointer) {
                if (leftMarker < rightPointer) {
                    swapInArray(source,leftMarker,rightPointer);
                }
                // сдвиг границ после выполненной операции
                leftMarker++;
                rightPointer--;
            }
        } while (leftMarker <= rightPointer);

        if (leftMarker < rightBorder) {
            quickSort(source, leftMarker, rightBorder);
        }
        if (leftBorder < rightPointer) {
            quickSort(source, leftBorder, rightPointer);
        }
    }

    public static int[] qSort(int[] array){
        if(array.length<2){
            return array;
        } else {
            int pivot=array[0];
            int lessLength=0;
            int greaterLength=0;
            int[] less=new int[lessLength];
            int[] greater=new int[greaterLength];

            for(int i=1;i<array.length;i++) {
                if(array[i]<=pivot){
                    less=Arrays.copyOf(less,++lessLength);
                    less[lessLength-1]=array[i];
                } else {
                    greater=Arrays.copyOf(greater,++greaterLength);
                    greater[greaterLength-1]=array[i];
                }
            }
            less=qSort(less);
            greater=qSort(greater);
            int [] result=new int[array.length];
            for(int i=0;i<array.length;i++) {
                if(i<lessLength)
                    result[i]=less[i];
                if(i>lessLength)
                    result[i]=greater[i-lessLength-1];
            }
            result[lessLength]=pivot;
            return  result;
        }
    }

    private  static void swapInArray(int[] array ,int index, int nextIndex){
//      a= a xor b; b= b xor a; a= a xor b
//      нельзя, если придут одинаковые значения, будут 0
        int tmp = array[index];
        array[index] = array[nextIndex];
        array[nextIndex] = tmp;
    }
}
