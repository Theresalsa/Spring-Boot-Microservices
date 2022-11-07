package com.thecuriouscat.springmicroservices.limitsservice.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @Description:
 * @Author: theresa
 * @Date: 11/6/22
 */
@Getter
@Setter
public class Limits {

    private int minimum;
    private int maximum;

    public Limits() {
    }

    public Limits(int minimum, int maximum) {
        this.minimum = minimum;
        this.maximum = maximum;
    }

    @Override
    public String toString() {
        return "Limits{" +
                "minimum=" + minimum +
                ", maximum=" + maximum +
                '}';
    }
}
