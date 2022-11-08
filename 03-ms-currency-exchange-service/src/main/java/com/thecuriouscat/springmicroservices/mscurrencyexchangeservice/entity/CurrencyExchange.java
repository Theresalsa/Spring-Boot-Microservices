package com.thecuriouscat.springmicroservices.mscurrencyexchangeservice.entity;

import lombok.Data;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @Description:
 * @Author: theresa
 * @Date: 11/7/22
 */
@Data
@Entity
public class CurrencyExchange {

    @Id
    private Long id;
    @Column(name = "currency_from") //cannot use from and to directly since they are SQL keywords
    private String from;
    @Column(name = "currency_to")//cannot use from and to directly since they are SQL keywords
    private String to;
    private BigDecimal conversionMultiple;

    private String environment;

    public CurrencyExchange() {
    }

    public CurrencyExchange(Long id, String from, String to, BigDecimal conversionMultiple) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.conversionMultiple = conversionMultiple;
    }


}
