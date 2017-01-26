package com.co4gsl.service;

import com.co4gsl.enums.Items;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by rpayal on 25/01/2017.
 */
public class CheckoutService {
    public BigDecimal checkout(List<String> items) {
        BigDecimal total = BigDecimal.ZERO;

        for (String itemToPrice : items) {
            total = total.add(BigDecimal.ONE.multiply(Items.valueOf(itemToPrice).price()));
        }

        return total;
    }
}
