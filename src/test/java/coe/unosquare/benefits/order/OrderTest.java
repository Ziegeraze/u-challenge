/*
 *  OrderTest
 *  1.0
 *  11/8/22, 8:28 PM
 *  Copyright (c) 2022 Unosquare
 *  Any illegal reproduction of this content will result in immediate legal action.
 */

package coe.unosquare.benefits.order;

import coe.unosquare.benefits.ShoppingCart.ShoppingCart;
import coe.unosquare.benefits.util.ShoppingCartGenerator;
import org.junit.jupiter.api.Test;
import static coe.unosquare.benefits.util.PayOrderSimulator.payOrder;
import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderTest {
    @Test
    void orderWithVisaMoreThan10ProductsDiscountTest() {
        ShoppingCart shoppingCart = ShoppingCartGenerator.generate(15);
        assertEquals(0.15, payOrder(shoppingCart, "Visa"));
    }

    @Test
    void orderWithVisa10ProductsDiscountTest() {
        ShoppingCart shoppingCart = ShoppingCartGenerator.generate(10);
        assertEquals(0.15, payOrder(shoppingCart, "Visa"));
    }

    @Test
    void orderWithVisa7ProductsDiscountTest() {
        ShoppingCart shoppingCart = ShoppingCartGenerator.generate(7);
        assertEquals(0.10, payOrder(shoppingCart, "Visa"));
    }

    @Test
    void orderWithVisaLessThan7ProductsDiscountTest() {
        ShoppingCart shoppingCart = ShoppingCartGenerator.generate(5);
        assertEquals(0.05, payOrder(shoppingCart, "Visa"));
    }
}
