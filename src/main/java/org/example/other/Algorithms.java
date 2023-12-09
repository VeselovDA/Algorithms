package org.example.other;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

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

    // алгорит проверки числа на простото на основе малой теоремы Ферма
    public static boolean checkPrimeNumber(int number) {
        return checkPrimeNumber(number, number - 1);
    }

    public static boolean checkPrimeNumber(int number, int countTests) {
        if (countTests >= number) {
            throw new RuntimeException("Недопустимое значение количества проверок");
        }
        var random = new Random();
        var processedWitness = new HashSet<Integer>();
        for (int i = 0; i < countTests; i++) {
            var randomWitness = random.nextInt(number);
            while (processedWitness.contains(randomWitness) || randomWitness == 0) {
                randomWitness = random.nextInt(number);
            }
            processedWitness.add(randomWitness);
            if (checkWitnessByFerm(randomWitness, number)) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkWitnessByFerm(int witness, int number) {
        return bigIntPow(witness, number - 1)
                .mod(new BigInteger(String.valueOf(number))).intValue() != 1;
    }

    private static BigInteger bigIntPow(int value, int powValue) {
        BigInteger a = new BigInteger(String.valueOf(value));
        return a.pow(powValue);
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
