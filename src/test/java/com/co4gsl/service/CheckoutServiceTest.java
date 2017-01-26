package com.co4gsl.service;

import com.co4gsl.rules.SpecialOffer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Created by rpayal on 31/10/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class CheckoutServiceTest {
    private CheckoutService target;
    private SpecialOffer specialOffer;

    @Before
    public void setup() {
        specialOffer = Mockito.mock(SpecialOffer.class);
        target = new CheckoutService(specialOffer);
    }

    @Test
    public void testCheckoutOneApple() {
        Mockito.when(specialOffer.qtyAfterOffer(SpecialOffer.BUY_1_GET_1, 1))
                .thenReturn(1);

        BigDecimal cost = target.checkout(Arrays.asList("Apple"));
        assertEquals("Wrong cost", BigDecimal.valueOf(60, 2), cost);
    }

    @Test
    public void testCheckoutOneOrange() {
        Mockito.when(specialOffer.qtyAfterOffer(SpecialOffer.BUY_3_FOR_2, 1))
                .thenReturn(1);
        BigDecimal cost = target.checkout(Arrays.asList("Orange"));
        assertEquals("Wrong cost", BigDecimal.valueOf(25, 2), cost);
    }

    @Test
    public void testCheckoutMultipleItems() {
        Mockito.when(specialOffer.qtyAfterOffer(SpecialOffer.BUY_1_GET_1, 3))
                .thenReturn(2);
        Mockito.when(specialOffer.qtyAfterOffer(SpecialOffer.BUY_3_FOR_2, 1))
                .thenReturn(1);
        BigDecimal cost = target.checkout(Arrays.asList("Apple", "Apple", "Orange", "Apple"));
        assertEquals("Wrong cost", BigDecimal.valueOf(145, 2), cost);
    }


    @Test
    public void testCheckoutMultipleAppleOffer() {
        Mockito.when(specialOffer.qtyAfterOffer(SpecialOffer.BUY_1_GET_1, 2))
                .thenReturn(1);
        BigDecimal cost = target.checkout(Arrays.asList("Apple", "Apple"));
        assertEquals("Wrong cost", BigDecimal.valueOf(60, 2), cost);
    }

    @Test
    public void testCheckoutMultipleOrangeOffer() {
        Mockito.when(specialOffer.qtyAfterOffer(SpecialOffer.BUY_3_FOR_2, 3))
                .thenReturn(2);
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