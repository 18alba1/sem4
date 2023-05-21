package com.github.integration;

import com.github.dtos.ItemDTO;

/**
 * interface to handle discount
 */
public interface DiscountStrategy 
{
    double discountRate (ItemDTO item);
}
