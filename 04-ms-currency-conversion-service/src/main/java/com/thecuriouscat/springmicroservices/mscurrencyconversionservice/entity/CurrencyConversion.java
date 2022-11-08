package com.thecuriouscat.springmicroservices.mscurrencyconversionservice.entity;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @Description:
 * @Author: theresa
 * @Date: 11/7/22
 */
@Getter
@Setter
public class CurrencyConversion {

    private Long id;
    private String from;
    private String to;
    private BigDecimal quantity;
    private BigDecimal conversionMultiple;
    private BigDecimal totalCalculatedAmount;
    private  String environment;

    public CurrencyConversion() {
    }

    public CurrencyConversion(Long id, String from, String to, BigDecimal quantity, BigDecimal conversionMultiple, BigDecimal totalCalculatedAmount, String environment) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.conversionMultiple = conversionMultiple;
        this.quantity = quantity;
        this.totalCalculatedAmount = totalCalculatedAmount;
        this.environment = environment;
    }

    @Override
    public String toString() {
        return "CurrencyConversion{" +
                "id=" + id +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", conversionMultiple=" + conversionMultiple +
                ", quantity=" + quantity +
                ", totalCalculatedAmount=" + totalCalculatedAmount +
                ", environment='" + environment + '\'' +
                '}';
    }
}
