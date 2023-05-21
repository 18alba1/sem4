package com.github.integration;

import java.util.ArrayList;
import com.github.dtos.ItemDTO;

/**
 * Handles discount
 */
public class DiscountService 
{
    private double totalDiscount;
    private DiscountStrategy discountS;

    /**
     * calculates total discount
     * @param items list of items
     */
    public void processDiscount (ArrayList<ItemDTO> items)
    {
        for (int i = 0; i < items.size(); i++)
        {
            this.totalDiscount += discountS.discountRate(items.get(i));
        }
    }

    /**
     * set discount
     * @param newDiscount the new disocunt
     */
    public void setDiscount (DiscountStrategy newDiscount)
    {
        this.discountS = newDiscount;
    }
    
    /**
     * get total discount
     * @return total discount
     */
    public double getTotalDiscount ()
    {
        return this.totalDiscount;
    }

    /**
     * sets totalDiscount
     * @param newDiscount
     */
    public void setTotalDiscount (double newDiscount)
    {
        this.totalDiscount = newDiscount;
    }
}
