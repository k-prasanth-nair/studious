package com.apptus;

/**
 * Created by prasanth on 31/3/16.
 */
public interface IProduct {
    boolean isStockAvailable();
    void replenishStock(int qty);
    int getPrice();
    int getProductCode();
    int getQuantity();
}
