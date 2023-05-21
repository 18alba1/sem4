package com.github.test;

import org.junit.After;
import org.junit.Test;
import com.github.dtos.ItemDTO;
import com.github.integration.*;
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
    public void testAddProduct() throws ItemNumberDoesNotExistException, DatabaseFailureException
    {
        ItemDTO item = new ItemDTO(1, "Tomat",10 , "Röd", 1, 25);
        ItemDTO product = goods.addProduct(item);
        assertTrue(goods.getItems().contains(item), "Product was not added to sale");
        
    }
}
