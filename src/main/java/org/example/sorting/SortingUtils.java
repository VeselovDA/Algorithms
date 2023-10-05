package org.example.sorting;

import java.util.Arrays;

public class SortingUtils {

    public static void sortingByChoice(int[] array) {

        for (int leftIndex = 0; leftIndex < array.length; leftIndex++) {
            int indexOfMinimumValue = leftIndex;
            for (int currentIndex = leftIndex; currentIndex < array.length; currentIndex++) {
                if (array[currentIndex] < array[indexOfMinimumValue]) {
                    indexOfMinimumValue = currentIndex;
                }
            }
            swapValueInArray(array, leftIndex, indexOfMinimumValue);
        }
    }

    private static void swapValueInArray(int[] array, int swappedValueIndex1, int swappedValueIndex2) {
//      a= a xor b; b= b xor a; a= a xor b
//      нельзя, если придут одинаковые значения, будут 0
        int tmp = array[swappedValueIndex1];
        array[swappedValueIndex1] = array[swappedValueIndex2];
        array[swappedValueIndex2] = tmp;
    }

    public static void quickSort(int[] source) {
        quickSort(source, 0, source.length - 1);
    }

    private static void quickSort(int[] source, int leftBorder, int rightBorder) {
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
                    swapValueInArray(source, leftMarker, rightPointer);
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

    public static void qSort(int[] array) {
        if (array.length > 1) {
            int baseValue = array[0];
            int leftSubArrayLength = 0;
            int rightSubArrayLength = 0;
            int[] leftSubArray = new int[leftSubArrayLength];
            int[] rightSubArray = new int[rightSubArrayLength];

            for (int i = 1; i < array.length; i++) {
                if (array[i] <= baseValue) {
                    leftSubArray = Arrays.copyOf(leftSubArray, ++leftSubArrayLength);
                    leftSubArray[leftSubArrayLength - 1] = array[i];
                } else {
                    rightSubArray = Arrays.copyOf(rightSubArray, ++rightSubArrayLength);
                    rightSubArray[rightSubArrayLength - 1] = array[i];
                }
            }
            qSort(leftSubArray);
            qSort(rightSubArray);
            for (int i = 0; i < array.length; i++) {
                if (i < leftSubArrayLength)
                    array[i] = leftSubArray[i];
                if (i > leftSubArrayLength)
                    array[i] = rightSubArray[i - leftSubArrayLength - 1];
            }
            array[leftSubArrayLength]=baseValue;
        }
    }
}
