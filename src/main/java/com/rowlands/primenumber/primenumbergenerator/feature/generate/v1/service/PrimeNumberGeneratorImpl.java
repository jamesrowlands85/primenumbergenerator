package com.rowlands.primenumber.primenumbergenerator.feature.generate.v1.service;

import java.util.LinkedList;
import java.util.List;

public class PrimeNumberGeneratorImpl implements PrimeNumberGenerator {

    public String generatePrimeNumbers(int number) {
        List<Integer> primeNumbers = new LinkedList<>();

        for (int i = 2; i <= number; i++) {
            if (isPrime(i)) {
                primeNumbers.add(i);
            }
        }

        if (primeNumbers.isEmpty()) {
            return String.format("%d does not have any prime numbers", number);
        }

        return primeNumbers.toString();
    }

    private boolean isPrime(int number) {

        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
