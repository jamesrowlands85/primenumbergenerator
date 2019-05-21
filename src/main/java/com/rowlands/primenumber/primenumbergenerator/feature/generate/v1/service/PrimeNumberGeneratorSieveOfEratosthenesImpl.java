package com.rowlands.primenumber.primenumbergenerator.feature.generate.v1.service;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PrimeNumberGeneratorSieveOfEratosthenesImpl implements PrimeNumberGenerator{

    public String generatePrimeNumbers(int number) {
        List<Integer> primeNumbers = new LinkedList<>();

        boolean[] prime = new boolean[number + 1];
        Arrays.fill(prime, true);

        for(int p = 2; p * p <= number; p++) {
            // Update all multiples of p
            for(int i = p * p; i <= number; i += p)
                prime[i] = false;
        }

        for(int i = 2; i <= number; i++)
        {
            if(prime[i])
                primeNumbers.add(i);
        }

        if (primeNumbers.isEmpty()) {
            return String.format("%d does not have any prime numbers", number);
        }

        return primeNumbers.toString();
    }
}
