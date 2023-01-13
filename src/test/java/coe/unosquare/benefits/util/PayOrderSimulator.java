/*
 *  PayOrderSimulator
 *  1.0
 *  11/8/22, 8:29 PM
 *  Copyright (c) 2022 Unosquare
 *  Any illegal reproduction of this content will result in immediate legal action.
 */

package coe.unosquare.benefits.util;

import coe.unosquare.benefits.ShoppingCart.ShoppingCart;
import coe.unosquare.benefits.order.Order;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * The type Pay order simulator.
 */
public final class PayOrderSimulator {
    /**
     * Hide constructor to avoid instances of this utility class.
     */
    private PayOrderSimulator() { }

    /**
     * Method to simulate the process of an order being paid.
     *
     * @param shoppingCart    the products
     * @param paymentType the payment type
     * @return the double
     */
    public static Double payOrder(final ShoppingCart shoppingCart,
                                  final String paymentType) {
        Order order = new Order(shoppingCart);
        Double subtotal = shoppingCart.getTotalPrice();
        return new BigDecimal((subtotal - order.pay(paymentType)) / subtotal)
                .setScale(2, RoundingMode.HALF_EVEN)
                .doubleValue();
    }
}

