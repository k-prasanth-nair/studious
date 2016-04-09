package com.apptus;

import java.util.List;

/**
 * Created by prasanth on 31/3/16.
 */
public interface IVendingMachine {

    void listProducts();
    void addProduct(Product p);
    void replenishCoinChange(Coin c);
    void selectProduct(int code,int qty);
    void finalizeSelection();
    void provideCash(String coin);
    void processOrder();

}
