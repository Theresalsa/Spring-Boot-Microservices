package com.thecuriouscat.springmicroservices.limitsservice.controller;

import com.thecuriouscat.springmicroservices.limitsservice.entity.Limits;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: theresa
 * @Date: 11/6/22
 */
@RestController
public class LimitsController {

    @GetMapping("/limits")
    public Limits retrieveLimits(){
        return new Limits(1, 1000); //hardcode for now as placeholder
    }
}
