package org.example.sorting;

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

    private  static void swapInArray(int[] array ,int index, int nextIndex){
//      a= a xor b; b= b xor a; a= a xor b
//      нельзя, если придут одинаковые значения, будут 0
        int tmp = array[index];
        array[index] = array[nextIndex];
        array[nextIndex] = tmp;
    }
}
