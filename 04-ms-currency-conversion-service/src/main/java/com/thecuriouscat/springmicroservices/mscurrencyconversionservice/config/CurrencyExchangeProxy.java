package com.thecuriouscat.springmicroservices.mscurrencyconversionservice.config;

import com.thecuriouscat.springmicroservices.mscurrencyconversionservice.entity.CurrencyConversion;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Description:
 * @Author: theresa
 * @Date: 11/7/22
 */
@FeignClient(name="currency-exchange", url="localhost:8000") //TODO: the url is hardcoded; will change later since the url may change as the instances change due to load balanceing
// the name need to match with that stated in application.properties
public interface CurrencyExchangeProxy {

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyConversion retrieveExchangeValue(@PathVariable String from,
                                                    @PathVariable String to);


}
