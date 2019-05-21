package com.rowlands.primenumber.primenumbergenerator.feature.generate.v1.service;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PrimeNumberGeneratorSieveOfEratosthenesImplTest {

    PrimeNumberGeneratorSieveOfEratosthenesImpl primeNumberGeneratorSieveOfEratosthenes;

    @Before
    public void setup() {
        primeNumberGeneratorSieveOfEratosthenes = new PrimeNumberGeneratorSieveOfEratosthenesImpl();
    }

    @Test
    public void generatePrimeNumbersSieveOfEratosthenes0() {
        assertEquals("0 does not have any prime numbers",primeNumberGeneratorSieveOfEratosthenes.generatePrimeNumbers(0));
    }

    @Test
    public void generatePrimeNumbersSieveOfEratosthenes1AndBelow() {
        assertEquals("1 does not have any prime numbers",primeNumberGeneratorSieveOfEratosthenes.generatePrimeNumbers(1));
    }

    @Test
    public void generatePrimeNumbersSieveOfEratosthenes2AndBelow() {
        assertEquals("[2]",primeNumberGeneratorSieveOfEratosthenes.generatePrimeNumbers(2));
    }

    @Test
    public void generatePrimeNumbersSieveOfEratosthenes3AndBelow() {
        assertEquals("[2, 3]",primeNumberGeneratorSieveOfEratosthenes.generatePrimeNumbers(3));
    }

    @Test
    public void generatePrimeNumbersSieveOfEratosthenes4AndBelow() {
        assertEquals("[2, 3]",primeNumberGeneratorSieveOfEratosthenes.generatePrimeNumbers(4));
    }

    @Test
    public void generatePrimeNumbersSieveOfEratosthenes5AndBelow() {
        assertEquals("[2, 3, 5]",primeNumberGeneratorSieveOfEratosthenes.generatePrimeNumbers(5));
    }

    @Test
    public void generatePrimeNumbersSieveOfEratosthenes50AndBelow() {
        assertEquals("[2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47]",primeNumberGeneratorSieveOfEratosthenes.generatePrimeNumbers(50));
    }

}