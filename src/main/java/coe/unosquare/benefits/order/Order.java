/*
 *  Order
 *  1.0
 *  11/8/22, 8:28 PM
 *  Copyright (c) 2022 Unosquare
 *  Any illegal reproduction of this content will result in immediate legal action.
 */

package coe.unosquare.benefits.order;

import coe.unosquare.benefits.ShoppingCart.ShoppingCart;

/**
 * The type Order.
 */
public class Order {
    /** Store the final list of products and quantity for each product. **/
    private final ShoppingCart shoppingCart;
    private double discount;

    /**
     * Instantiates a new Order.
     *
     * @param shoppingCart the list of products added to the order
     */
    public Order(final ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    /**
     * Pay double.
     *
     * @param paymentType the payment type
     * @return the double
     */
    public Double pay(final String paymentType) {
        if (paymentType.equals("Visa")) {
            setVisaDiscount();
        } else if (paymentType.equals("Mastercard")) {
            setMastercardDiscount();
        }

        double subtotal = shoppingCart.getTotalPrice();
        return subtotal - subtotal * discount;
    }

    private void setVisaDiscount() {
        if (shoppingCart.getTotalProductCount() >= 10) {
            discount = 0.15;
        } else if (shoppingCart.getTotalProductCount() >= 7) {
            discount = 0.10;
        } else {
            discount = 0.05;
        }
    }

    private void setMastercardDiscount() {
        if (shoppingCart.getTotalPrice() >= 100) {
            discount = 0.17;
        } else if (shoppingCart.getTotalPrice() >= 75) {
            discount = 0.12;
        } else {
            discount = 0.08;
        }
    }

    /**
     * Print.
     */
    public void print() {
        shoppingCart.getProducts().forEach((product, quantity) ->
                System.out.println("Product:{" + product.getName() + ","
                        + product.getPrice() + ","
                        + product.getType()
                        + "},Quantity:" + quantity
                        + ",Total:" + product.getPrice() * quantity));
        System.out.println("Total product quantity: " + shoppingCart.getTotalProductCount());
        System.out.println("Total price: " + shoppingCart.getTotalPrice());
    }
}
