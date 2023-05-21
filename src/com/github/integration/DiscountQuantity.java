package com.github.integration;

import com.github.dtos.ItemDTO;

/**
 * Discount depending on quantity of items bought
 */
public class DiscountQuantity implements DiscountStrategy
{
    /**
     * returns fixed discount if 2 or more of same item has been bought.
     * You will also get product discount.
     * @param item the item
     * @return discount amount
     */
    @Override
    public double discountRate(ItemDTO item) 
    {
        if (item.getQuantity() >= 2)
            return 4;
        else
            return 0;
    }
}
