package com.co4gsl.enums;

import java.math.BigDecimal;

/**
 * Created by rpayal on 25/01/2017.
 */
public enum Items {
    Apple(BigDecimal.valueOf(60, 2)),
    Orange(BigDecimal.valueOf(25, 2));

    private BigDecimal price;

    Items(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal price() {
        return this.price;
    }
}
