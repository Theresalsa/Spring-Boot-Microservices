package com.thecuriouscat.springmicroservices.limitsservice.controller;

import com.thecuriouscat.springmicroservices.limitsservice.config.CommonConfig;
import com.thecuriouscat.springmicroservices.limitsservice.entity.Limits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: theresa
 * @Date: 11/6/22
 */

@RestController
public class LimitsController {

    @Autowired
    private CommonConfig configuration;

    /**
     *@description: handles the limits retrieval
     * @param
     *@author: theresa
     *@date: 11/7/22
     */

    @GetMapping("/limits")
    public Limits retrieveLimits(){
        return new Limits(configuration.getMinimum(), configuration.getMaximum());
        //return new Limits(1, 1000); //hardcode for now as placeholder
    }
}
