package com.rowlands.primenumber.primenumbergenerator.feature.generate.v1.service;

import com.rowlands.primenumber.primenumbergenerator.feature.generate.v1.api.PrimeNumberResponse;
import org.springframework.stereotype.Service;

@Service
public class PrimeNumberGeneratorService {

    public PrimeNumberResponse getPrimesFor(int number, String algorithmName) {

        String primeResult;

        if(algorithmName.equals("sieve_of_eratosthenes")) {
            primeResult = new PrimeNumberGeneratorSieveOfEratosthenesImpl().generatePrimeNumbers(number);
        }
        else {
            primeResult =  new PrimeNumberGeneratorImpl().generatePrimeNumbers(number);
        }

        return new PrimeNumberResponse(algorithmName, primeResult);
    }
}
