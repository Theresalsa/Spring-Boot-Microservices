package com.thecuriouscat.springmicroservices.mscurrencyexchangeservice.dao;

import com.thecuriouscat.springmicroservices.mscurrencyexchangeservice.entity.CurrencyExchange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Description:
 * @Author: theresa
 * @Date: 11/7/22
 */

@Repository
public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {

    CurrencyExchange findCurrencyExchangeByFromAndTo(String from, String to);
}
