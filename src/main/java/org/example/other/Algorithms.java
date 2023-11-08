package org.example.other;

public class Algorithms {

    public static long pow(int base, int degree) {
        if (degree == 0) {
            return 1;
        }
        if (degree == 1) {
            return base;
        }
        var foundDegree = findDegreeNearestDegreeOfTwo(degree);
        var difference = degree - foundDegree;
        if (difference == 0) {
            return calculateDegreeNearestDegreeOfTwo(base, foundDegree);
        } else {
            return calculateDegreeNearestDegreeOfTwo(base, foundDegree) * pow(base, difference);
        }
    }

    private static int findDegreeNearestDegreeOfTwo(int degree) {
        int countDegree = 0;
        if (countDegree + 1 < degree) {
            countDegree = 1;
        } else {
            return countDegree;
        }
        while (countDegree + 1 <= degree) {
            countDegree *= 2;
        }
        return countDegree / 2;
    }

    private static long calculateDegreeNearestDegreeOfTwo(int base, int degree) {
        if (degree == 0) {
            return 1;
        }
        int countDegree = 1;
        long result = base;
        while (countDegree != degree) {
            result *= result;
            countDegree *= 2;
        }
        return result;
    }
}
