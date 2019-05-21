package com.rowlands.primenumber.primenumbergenerator.feature.generate.v1.endpoint;

import com.rowlands.primenumber.primenumbergenerator.feature.generate.v1.api.PrimeNumberResponse;
import com.rowlands.primenumber.primenumbergenerator.feature.generate.v1.service.PrimeNumberGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.constraints.NotBlank;
import java.util.Optional;


@Controller
public class PrimeNumberGeneratorController {

    @Autowired
    PrimeNumberGeneratorService primeNumberGeneratorService;

    @RequestMapping(value = "primegenerator/{number}", method = RequestMethod.GET)
    @ResponseBody
    public PrimeNumberResponse handleUpdate(@PathVariable int number,
                                            @RequestParam("algorithm_name") Optional<String> algorithm_name) {

        return algorithm_name.map(
                s -> new PrimeNumberResponse(primeNumberGeneratorService.getPrimesFor(number, s))).orElseGet(
                    () -> new PrimeNumberResponse(primeNumberGeneratorService.getPrimesFor(number, "default")
                )
        );

    }
}
