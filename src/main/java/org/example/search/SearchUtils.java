package org.example.search;

import java.util.*;

public class SearchUtils {

    public static int binarySearch(int[] array, int desired) {
        int lowMarker = 0;
        int highMarker = array.length - 1;
        int currentIndex;
        while (lowMarker <= highMarker) {
            currentIndex = (highMarker + lowMarker) / 2;
            if (desired == array[currentIndex]) {
                return currentIndex;
            }
            if (desired < array[currentIndex]) {
                highMarker = currentIndex - 1;
            } else {
                lowMarker = currentIndex + 1;
            }
        }
        return -1;//не найден элемент
    }

    //этот алгоритм находит кратчайшее расстояние по количеству переходов между узлами
    public static MyObjForWidthSearch widthSearch(MyObjForWidthSearch myObjForWidthSearch) {
        HashSet<MyObjForWidthSearch> searched = new HashSet<>();
        Deque<MyObjForWidthSearch> deque = new LinkedList<>();
        deque.add(myObjForWidthSearch);
        while (!deque.isEmpty()) {
            MyObjForWidthSearch checked = deque.removeFirst();
            if (!searched.contains(checked)) {
                if (checked.isStatus()) return checked;
                else {
                    searched.add(checked);
                    deque.addAll(List.of(checked.getSubArray()));
                }
            }
        }
        return null;
    }

    //Алгоритм Дейкстры
    public static int findShortestWay(Integer[][] matrix, int start, int finish) {
        matrix = copyMatrix(matrix);
        checkValidInputMatrix(matrix);
        var resultMatrix = new Integer[matrix.length - 1][matrix.length];
        resultMatrix[0] = matrix[start];
        Integer minValue = 0;
        var indexOfMinValue = 0;
        var excludeIndexSet = new HashSet<Integer>();
        for (int i = 0; i < matrix.length - 1; i++) {
            if (i != 0) {
                resultMatrix[i] = matrix[indexOfMinValue];
                for (int j = 0; j < matrix.length; j++) {
                    resultMatrix[i][j] = addMinValue(resultMatrix[i][j], minValue);
                    for (int k = i; k > 0; k--) {
                        resultMatrix[i][j] = findMin(resultMatrix[i][j], resultMatrix[k - 1][j]);
                    }
                }
                resultMatrix[i][start] = null;
                for (var excludeIndexValue : excludeIndexSet) {
                    resultMatrix[i][excludeIndexValue] = null;
                }
            }
            minValue = Arrays.stream(resultMatrix[i])
                    .filter(Objects::nonNull)
                    .min(Integer::compareTo)
                    .orElse(null);
            if (Objects.isNull(minValue)) {
                break;
            }
            indexOfMinValue = Arrays.asList(resultMatrix[i]).indexOf(minValue);
            excludeIndexSet.add(indexOfMinValue);
        }

        printMatrix(resultMatrix);
        return getResult(resultMatrix, finish);
    }

    private static Integer getResult(Integer[][] resultMatrix, Integer finish) {
        var result = resultMatrix[0][finish];
        for (int i = 0; i < resultMatrix.length; i++) {
            result = findMin(result, resultMatrix[i][finish]);
        }
        return Objects.requireNonNull(result, "Нет пути до этой точки");
    }

    private static Integer[][] copyMatrix(Integer[][] matrix) {
        var copy = Arrays.copyOf(matrix, matrix.length);
        for (var row = 0; row < matrix.length; row++) {
            copy[row] = Arrays.copyOf(matrix[row], matrix[row].length);
        }
        return copy;
    }

    private static Integer addMinValue(Integer currentValue, Integer minValue) {
        if (Objects.isNull(currentValue)) {
            return null;
        }
        return currentValue + minValue;
    }

    private static void printMatrix(Integer[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static Integer findMin(Integer a, Integer b) {
        if (Objects.isNull(a) && Objects.isNull(b)) {
            return null;
        }
        if (Objects.isNull(a)) {
            return b;
        }
        if (Objects.isNull(b)) {
            return a;
        }
        return a < b ? a : b;
    }

    private static void checkValidInputMatrix(Integer[][] matrix) {
        if (matrix.length != matrix[0].length) {
            throw new RuntimeException("Входный массив не является квадратной матрицей");
        }
    }
}
