package com.thecuriouscat.springmicroservices.limitsservice.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: theresa
 * @Date: 11/7/22
 */
@Component
@ConfigurationProperties("limits-service") //mapped from application.properties file
@Getter
@Setter
public class CommonConfig {

    private int minimum;
    private int maximum;

    public CommonConfig() {
    }

    public CommonConfig(int minimum, int maximum) {
        this.minimum = minimum;
        this.maximum = maximum;
    }
}
