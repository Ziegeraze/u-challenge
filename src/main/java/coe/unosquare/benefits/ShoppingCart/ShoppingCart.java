/*
 *  Product
 *  1.0
 *  11/8/22, 8:30 PM
 *  Copyright (c) 2022 Unosquare
 *  Any illegal reproduction of this content will result in immediate legal action.
 */

package coe.unosquare.benefits.ShoppingCart;

import coe.unosquare.benefits.product.Product;

import java.util.Map;

/**
 * The Shopping Cart.
 */
public class ShoppingCart {
    /** Store the final list of products and quantity for each product. **/
    private final Map<Product, Integer> products;

    /** The Total Product Count in the Shopping Cart. **/
    private final int totalProductCount;

    /**  The Total Product Count in the Shopping Cart. **/
    private final Double totalPrice;


    /**
     * Instantiates a new Product.
     *
     * @param products  the products
     * @param totalProductCount the total product count
     * @param totalPrice  the total price
     */
    public ShoppingCart(Map<Product, Integer> products, int totalProductCount, Double totalPrice) {
        this.products = products;
        this.totalProductCount = totalProductCount;
        this.totalPrice = totalPrice;
    }

    /**
     * Gets products.
     *
     * @return the products
     */
    public Map<Product, Integer> getProducts() {
        return products;
    }

    /**
     * Gets total product count.
     *
     * @return the total product count
     */
    public int getTotalProductCount() {
        return totalProductCount;
    }

    /**
     * Gets total price.
     *
     * @return the total price
     */
    public Double getTotalPrice() {
        return totalPrice;
    }
}
