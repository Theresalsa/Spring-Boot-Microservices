package com.thecuriouscat.springmicroservices.mscurrencyconversionservice.controller;

import com.thecuriouscat.springmicroservices.mscurrencyconversionservice.config.CurrencyExchangeProxy;
import com.thecuriouscat.springmicroservices.mscurrencyconversionservice.entity.CurrencyConversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;

/**
 * @Description:
 * @Author: theresa
 * @Date: 11/7/22
 */
@RestController
public class CurrencyConversionController {

    /**
     *@description: For service invocation by RestTemplate
     * @param from
     * @param to
     * @param quantity
     *@author: theresa
     *@date: 11/7/22
     */

    @GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion calculateCurrencyConversion(@PathVariable String from,
                                                          @PathVariable String to,
                                                          @PathVariable BigDecimal quantity){

        HashMap<String, String> uriVariables = new HashMap<>();//map for carrying values of the from and to from the uri above
        uriVariables.put("from", from);
        uriVariables.put("to", to);

        ResponseEntity<CurrencyConversion> responseEntity = new RestTemplate().getForEntity(
                "http://localhost:8000/currency-exchange/from/{from}/to/{to}",
                CurrencyConversion.class, uriVariables);//(url, returnTypeClass)

        CurrencyConversion currencyConversion = responseEntity.getBody();
        //public CurrencyConversion(Long id, String from, String to, BigDecimal quantity, BigDecimal conversionMultiple, BigDecimal totalCalculatedAmount, String environment)
        return new CurrencyConversion(currencyConversion.getId(),
                from, to, quantity,
                currencyConversion.getConversionMultiple(),
                quantity.multiply(currencyConversion.getConversionMultiple()),
                currencyConversion.getEnvironment()
                );
    }

    /**
     *@description: For service invocation by Feign (simplified from the RestTemplate way above,
     * * especially for more microservices exists at the same time)
     * @param from
     * @param to
     * @param quantity
     *@author: theresa
     *@date: 11/7/22
     */

    @Autowired
    private CurrencyExchangeProxy currencyExchangeProxy;

    @GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion calculateCurrencyConversionFeign(@PathVariable String from,
                                                          @PathVariable String to,
                                                          @PathVariable BigDecimal quantity){

        CurrencyConversion currencyConversion = currencyExchangeProxy.retrieveExchangeValue(from, to);

        return new CurrencyConversion(currencyConversion.getId(),
                from, to, quantity,
                currencyConversion.getConversionMultiple(),
                quantity.multiply(currencyConversion.getConversionMultiple()),
                currencyConversion.getEnvironment()
        );
    }
}
