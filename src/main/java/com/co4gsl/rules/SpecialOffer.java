package com.co4gsl.rules;

/**
 * Created by rpayal on 26/01/2017.
 */
public class SpecialOffer {
    public static final String BUY_1_GET_1 = "buy1get1";
    public static final String BUY_3_FOR_2 = "3for2";

    public int qtyAfterOffer(String offer, int totalQty) {
        int qtyAfterOffer = 0;
        if (offer.equals(BUY_1_GET_1)) {
            qtyAfterOffer = (totalQty - (totalQty / 2));
        } else if (offer.equals(BUY_3_FOR_2)) {
            qtyAfterOffer = (totalQty - (totalQty / 3));
        }
        return qtyAfterOffer;
    }
}
