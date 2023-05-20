package com.github.view;

import com.github.model.SaleObserver;

/**
 * Used to show the total income on the user interface
 */
public class TotalRevenueView implements SaleObserver
{
    private double totalRevenue;

    /**
     * prints total revenue
     * @param totalPrice added to total revenue
     */
    @Override       //subclass method should override superclass method
    public void priceOfSale (double totalPrice)
    {
        totalRevenue += totalPrice;
        System.out.println("Date: " + java.time.LocalDate.now() + " Total revenue: " + totalRevenue + "\n");
    }
}
