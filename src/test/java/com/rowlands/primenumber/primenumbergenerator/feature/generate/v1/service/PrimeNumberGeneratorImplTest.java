package com.rowlands.primenumber.primenumbergenerator.feature.generate.v1.service;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PrimeNumberGeneratorImplTest {

    PrimeNumberGeneratorImpl primeNumberGeneratorImpl;

    @Before
    public void setup() {
        primeNumberGeneratorImpl = new PrimeNumberGeneratorImpl();
    }

    @Test
    public void generatePrimeNumbers0() {
        assertEquals("0 does not have any prime numbers",primeNumberGeneratorImpl.generatePrimeNumbers(0));
    }

    @Test
    public void generatePrimeNumbers1AndBelow() {
        assertEquals("1 does not have any prime numbers",primeNumberGeneratorImpl.generatePrimeNumbers(1));
    }

    @Test
    public void generatePrimeNumbers2AndBelow() {
        assertEquals("[2]",primeNumberGeneratorImpl.generatePrimeNumbers(2));
    }

    @Test
    public void generatePrimeNumbers3AndBelow() {
        assertEquals("[2, 3]",primeNumberGeneratorImpl.generatePrimeNumbers(3));
    }

    @Test
    public void generatePrimeNumbers4AndBelow() {
        assertEquals("[2, 3]",primeNumberGeneratorImpl.generatePrimeNumbers(4));
    }

    @Test
    public void generatePrimeNumbers5AndBelow() {
        assertEquals("[2, 3, 5]",primeNumberGeneratorImpl.generatePrimeNumbers(5));
    }

    @Test
    public void generatePrimeNumbers50AndBelow() {
        assertEquals("[2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47]",primeNumberGeneratorImpl.generatePrimeNumbers(50));
    }


}