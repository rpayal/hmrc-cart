package com.co4gsl.enums;

import java.math.BigDecimal;

/**
 * Created by rpayal on 25/01/2017.
 */
public enum Item {
    Apple(BigDecimal.valueOf(60, 2), "buy1get1"),
    Orange(BigDecimal.valueOf(25, 2), "3for2");

    private BigDecimal price;
    private String offer;

    Item(BigDecimal price, String offer) {
        this.price = price;
        this.offer = offer;
    }

    public BigDecimal price() {
        return this.price;
    }

    public String offer() {
        return this.offer;
    }
}
