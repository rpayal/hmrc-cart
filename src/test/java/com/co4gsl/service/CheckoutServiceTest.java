package com.co4gsl.service;

import com.co4gsl.rules.SpecialOffer;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Created by rpayal on 31/10/2016.
 */
public class CheckoutServiceTest {
    private CheckoutService target;

    @Before
    public void setup() {
        target = new CheckoutService(new SpecialOffer());
    }

    @Test
    public void testCheckoutOneApple() {
        BigDecimal cost = target.checkout(Arrays.asList("Apple"));
        assertEquals("Wrong cost", BigDecimal.valueOf(60, 2), cost);
    }

    @Test
    public void testCheckoutOneOrange() {
        BigDecimal cost = target.checkout(Arrays.asList("Orange"));
        assertEquals("Wrong cost", BigDecimal.valueOf(25, 2), cost);
    }

    @Test
    public void testCheckoutMultipleItems() {
        BigDecimal cost = target.checkout(Arrays.asList("Apple", "Apple", "Orange", "Apple"));
        assertEquals("Wrong cost", BigDecimal.valueOf(145, 2), cost);
    }


    @Test
    public void testCheckoutMultipleAppleOffer() {
        BigDecimal cost = target.checkout(Arrays.asList("Apple", "Apple"));
        assertEquals("Wrong cost", BigDecimal.valueOf(60, 2), cost);
    }

    @Test
    public void testCheckoutMultipleOrangeOffer() {
        BigDecimal cost = target.checkout(Arrays.asList("Orange","Orange","Orange"));
        assertEquals("Wrong cost", BigDecimal.valueOf(50, 2), cost);
    }

    @Test
    public void testCheckoutWhenNoItems() {
        BigDecimal cost = target.checkout(Arrays.asList());
        assertEquals("Wrong cost", BigDecimal.valueOf(0), cost);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testCheckoutWhenUnknownItem() {
        BigDecimal cost = target.checkout(Arrays.asList("xyz"));
    }
}