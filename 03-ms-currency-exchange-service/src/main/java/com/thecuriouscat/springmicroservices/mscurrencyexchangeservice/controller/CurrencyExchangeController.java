package com.thecuriouscat.springmicroservices.mscurrencyexchangeservice.controller;

import com.thecuriouscat.springmicroservices.mscurrencyexchangeservice.dao.CurrencyExchangeRepository;
import com.thecuriouscat.springmicroservices.mscurrencyexchangeservice.entity.CurrencyExchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @Description:
 * @Author: theresa
 * @Date: 11/7/22
 */
@RestController
public class CurrencyExchangeController {

    private Logger logger = LoggerFactory.getLogger(CurrencyExchangeController.class);

    @Autowired
    private Environment environment;

    @Autowired
    private CurrencyExchangeRepository currencyExchangeRepository;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retrieveExchangeValue(@PathVariable String from,
                                                  @PathVariable String to) throws Exception{

        logger.info("retrieveExchangeValue called with {} to {}", from, to);

        CurrencyExchange currencyExchange = currencyExchangeRepository.findCurrencyExchangeByFromAndTo(from, to);
        if(currencyExchange == null) throw new RuntimeException("Unable to find data for" + from + "to" + to);

        //currencyExchange.setEnvironment("8080");//to know which instance handles it; first tried with hardcoded
        String port = environment.getProperty("local.server.port");
        currencyExchange.setEnvironment(port);

        return currencyExchange;
    }
}
