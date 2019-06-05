package com.rowlands.primenumber.primenumbergenerator.feature.generate.v1.endpoint;

import com.google.gson.Gson;
import com.rowlands.primenumber.primenumbergenerator.feature.generate.v1.api.PrimeNumberResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)
@WebMvcTest(PrimeNumberGeneratorController.class)
public class PrimeNumberGeneratorControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private PrimeNumberGeneratorController primeNumberGeneratorController;

    private Gson gson;

    @Before
    public void setUp() {
        gson = new Gson();

    }

    @After
    public void tearDown() {
        gson = null;
    }


    @Test
    public void testGetPrimesFor0() throws Exception {
        String getPrimeFor0 = "0";

        PrimeNumberResponse primeNumberResponse = new PrimeNumberResponse("default", "0 does not have any prime numbers");

        given(primeNumberGeneratorController.getPrimesLessThanOrEqualTo(Integer.valueOf(getPrimeFor0), Optional.empty())).willReturn(primeNumberResponse);

        mvc.perform(get("/primegenerator/" + getPrimeFor0)
                    .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("algorithm", is(primeNumberResponse.getAlgorithm())))
                    .andExpect(jsonPath("primes", is(primeNumberResponse.getPrimes())));
    }

    @Test
    public void testGetPrimesFor2() throws Exception {
        String getPrimeFor2 = "2";

        PrimeNumberResponse primeNumberResponse = new PrimeNumberResponse("default", "2");

        given(primeNumberGeneratorController.getPrimesLessThanOrEqualTo(Integer.valueOf(getPrimeFor2), Optional.empty())).willReturn(primeNumberResponse);

        mvc.perform(get("/primegenerator/" + getPrimeFor2)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("algorithm", is(primeNumberResponse.getAlgorithm())))
                .andExpect(jsonPath("primes", is(primeNumberResponse.getPrimes())));
    }

    @Test
    public void testGetPrimesFor5() throws Exception {
        String getPrimeFor5 = "5";

        PrimeNumberResponse primeNumberResponse = new PrimeNumberResponse("default", "2, 3, 5");

        given(primeNumberGeneratorController.getPrimesLessThanOrEqualTo(Integer.valueOf(getPrimeFor5), Optional.empty())).willReturn(primeNumberResponse);

        mvc.perform(get("/primegenerator/" + getPrimeFor5)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("algorithm", is(primeNumberResponse.getAlgorithm())))
                .andExpect(jsonPath("primes", is(primeNumberResponse.getPrimes())));
    }

    @Test
    public void testGetPrimesFor5WithSieveOfEratosthenes() throws Exception {
        String getPrimeFor5 = "5";
        String algorithm = "sieve_of_eratosthenes";

        PrimeNumberResponse primeNumberResponse = new PrimeNumberResponse("sieve_of_eratosthenes", "2, 3, 5");

        given(primeNumberGeneratorController.getPrimesLessThanOrEqualTo(Integer.valueOf(getPrimeFor5), Optional.of(algorithm))).willReturn(primeNumberResponse);

        mvc.perform(get("/primegenerator/" + getPrimeFor5 + "?algorithm_name=sieve_of_eratosthenes")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("algorithm", is(primeNumberResponse.getAlgorithm())))
                .andExpect(jsonPath("primes", is(primeNumberResponse.getPrimes())));
    }

    @Test
    public void testGetPrimesFor5WithDefault() throws Exception {
        String getPrimeFor5 = "5";
        String algorithm = "default";

        PrimeNumberResponse primeNumberResponse = new PrimeNumberResponse("default", "2, 3, 5");

        given(primeNumberGeneratorController.getPrimesLessThanOrEqualTo(Integer.valueOf(getPrimeFor5), Optional.of(algorithm))).willReturn(primeNumberResponse);

        mvc.perform(get("/primegenerator/" + getPrimeFor5 + "?algorithm_name=default")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("algorithm", is(primeNumberResponse.getAlgorithm())))
                .andExpect(jsonPath("primes", is(primeNumberResponse.getPrimes())));
    }

    @Test
    public void testGetPrimesForNonNumberExpectBadRequest() throws Exception {
        String getPrimeForTest = "test";

        mvc.perform(get("/primegenerator/" + getPrimeForTest)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testGetPrimesWithoutValueExpectNotFound() throws Exception {

        mvc.perform(get("/primegenerator/")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
}