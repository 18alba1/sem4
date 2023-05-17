package com.github.model;

/**
 * The SaleObserver interface used for classes that observe new sales.
 */
public interface SaleObserver
{
    /**
     * Total price of sale that is going to be used for other classes in viewv
     * @param totalPrice Total price of sale
     */
    public void priceOfSale (double totalPrice);
}
