package com.co4gsl.service;

import com.co4gsl.enums.Item;
import com.co4gsl.rules.SpecialOffer;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by rpayal on 25/01/2017.
 */
public class CheckoutService {
    private final SpecialOffer specialOffer;

    public CheckoutService(SpecialOffer specialOffer) {
        this.specialOffer = specialOffer;
    }

    public BigDecimal checkout(List<String> items) {
        BigDecimal total = BigDecimal.ZERO;

        Map<String, Integer> itemQuantity = new HashMap<String, Integer>();

        for (String itemToCount : items) {
            itemQuantity.putIfAbsent(itemToCount, 0);
            itemQuantity.put(itemToCount, itemQuantity.get(itemToCount) + 1);
        }

        for (String itemToPrice: itemQuantity.keySet()) {
            total = total.add( getTotalPriceForMultipleBuy(itemToPrice, itemQuantity.get(itemToPrice)) );
        }

        return total;
    }

    private BigDecimal getTotalPriceForMultipleBuy(String itemName, Integer totalItemQty) {
        Item item = null;

        try {
            item = Item.valueOf(itemName);
        } catch (IllegalArgumentException e) {
            // Throws IllegalItemException
            throw new IllegalArgumentException("No price for \'"+item+"\'");
        }

        return item.price().multiply(BigDecimal.valueOf(specialOffer.qtyAfterOffer(item.offer(), totalItemQty)));
    }
}
