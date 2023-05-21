package com.github.integration;

import com.github.dtos.ItemDTO;

/**
 * Store Discount for the products 
 */
public class DiscountProduct implements DiscountStrategy
{

    /**
     * Gives discount rate for product
     * @param item the item
     * @return discount amount
     */
    @Override
    public double discountRate(ItemDTO item) 
    {
        return 2;
    }
    
}
