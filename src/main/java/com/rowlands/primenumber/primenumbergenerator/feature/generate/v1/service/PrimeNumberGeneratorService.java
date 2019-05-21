package com.rowlands.primenumber.primenumbergenerator.feature.generate.v1.service;

import org.springframework.stereotype.Service;

@Service
public class PrimeNumberGeneratorService {


    public String getPrimesFor(int number, String algorithm_name) {
        if(algorithm_name.equals("sieve_of_eratosthenes")) {
            return new PrimeNumberGeneratorSieveOfEratosthenesImpl().generatePrimeNumbers(number);
        }
        else {
            return new PrimeNumberGeneratorImpl().generatePrimeNumbers(number);
        }

    }
}
