package com.co4gsl.rules;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by rpayal on 26/01/2017.
 */
public class SpecialOfferTest {
    SpecialOffer target;

    @Before
    public void setup() {
        target = new SpecialOffer();
    }

    @Test
    public void testQtyAfterOfferForBuy1Get1() throws Exception {
        assertEquals(target.qtyAfterOffer(SpecialOffer.BUY_1_GET_1, 2), 1);
    }

    @Test
    public void testQtyAfterOfferForBuy3For2() throws Exception {
        assertEquals(target.qtyAfterOffer(SpecialOffer.BUY_3_FOR_2, 3), 2);
    }
}