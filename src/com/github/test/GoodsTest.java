package com.github.test;

import org.junit.After;
import org.junit.Test;

import com.github.dtos.ItemDTO;
import com.github.model.Goods;

import static org.junit.jupiter.api.Assertions.*;


public class GoodsTest 
{
    private Goods goods;
    
    public GoodsTest() 
    {
        goods = new Goods();
    }

    @After
    public void reset() 
    {
        goods = null;
    }

    @Test
    public void testAddProduct()
    {
        ItemDTO product = goods.addProduct(2);
        
        assertTrue(((goods.getItems().contains(product)
                    && product.getItemNumber() != 0) || (!goods.getItems().contains(product)
                     && product.getItemNumber() == 0)), "Product was not added to sale");
        
    }
}
