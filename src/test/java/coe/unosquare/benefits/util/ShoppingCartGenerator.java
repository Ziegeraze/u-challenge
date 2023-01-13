/*
 *  ProductGenerator
 *  1.0
 *  11/8/22, 8:30 PM
 *  Copyright (c) 2022 Unosquare
 *  Any illegal reproduction of this content will result in immediate legal action.
 */

package coe.unosquare.benefits.util;

import coe.unosquare.benefits.ShoppingCart.ShoppingCart;
import coe.unosquare.benefits.product.Product;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * The type Product generator.
 */
public final class ShoppingCartGenerator {

    /**
     * Hide constructor to avoid instances of this utility class.
     */
    private ShoppingCartGenerator() { }

    /**
     * Generate products map.
     *
     * @param expectedSize the expected size of the map which matches
     *                     the number of different products in the cart.
     * @return the map
     */
    public static ShoppingCart generate(final Integer expectedSize) {
        HashMap<Product, Integer> products = new HashMap<>();
        AtomicInteger totalProductCount = new AtomicInteger();
        final Double[] totalPrice = new Double[1];
        totalPrice[0] = 0.0;

        IntStream.rangeClosed(1, expectedSize).forEach(id -> {
            Double price = Double.parseDouble(new DecimalFormat("0.00")
                            .format(new Random().nextDouble() * 10.00));
            products.put(new Product("Product " + id, //product name
                            price, //price
                            new Random().nextInt(3) + 1), //type
                    1); //quantity
            totalPrice[0] = totalPrice[0] + price;
            totalProductCount.getAndIncrement();
        });

        return new ShoppingCart(products, totalProductCount.get(), totalPrice[0]);
    }

    /**
     * Generate products map.
     *
     * @param expectedTotal the expected total amount to pay for the order before discount
     * @return the map
     */
    public static ShoppingCart generate(final Double expectedTotal) {
        HashMap<Product, Integer> products = new HashMap<>();
        double totalPrice = 0.0;
        int id = 1;
        int totalProductCount = 0;
        while (totalPrice < expectedTotal) {
            double price = Double.parseDouble(new DecimalFormat("0.00")
                                                .format(new Random().nextDouble() * 10.00));
            int quantity = new Random().nextInt(5) + 1;
            products.put(new Product("Product " + id, //product name
                            price,
                            new Random().nextInt(3) + 1), //type
                    quantity); //quantity
            totalPrice = totalPrice + price * quantity;
            id++;
            totalProductCount = totalProductCount + quantity;
        }
        return new ShoppingCart(products, totalProductCount, totalPrice);
    }
}
