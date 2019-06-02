package com.rowlands.primenumber.primenumbergenerator.feature.generate.v1.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PrimeNumberResponse {
    String algorithm;
    String primes;
}
