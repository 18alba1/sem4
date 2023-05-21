package com.github.test;

import org.junit.After;
import org.junit.Test;
import com.github.controller.Controller;
import com.github.dtos.ReceiptDTO;
import com.github.integration.DatabaseFailureException;
import com.github.integration.ItemNumberDoesNotExistException;

import static org.junit.jupiter.api.Assertions.*;

public class ControllerTest
{
    private Controller contr;
    
    public ControllerTest() 
    {
        contr = new Controller();
        contr.startSale();
    }

    @After
    public void reset() 
    {
        contr = null;
    }

    @Test
    public void testScanProduct_AddProduct() throws ItemNumberDoesNotExistException, DatabaseFailureException
    {
        try
        {
            contr.scanProduct(4);
        }
        catch (ItemNumberDoesNotExistException exception)    
        {
            fail ("Could not find the exisiting product in the item inventory");
        }
        catch (DatabaseFailureException exception)
        {
            fail("Could not connoct to databse");
        }
        ReceiptDTO receipt = contr.endTransaction();
        assertEquals(1, receipt.getItems().size(), "Was not correctly added to the list");

    }

    @Test
    public void testScanProduct_Quantity() throws ItemNumberDoesNotExistException, DatabaseFailureException
    {
        try
        {
            contr.scanProduct(1);
            contr.scanProduct(1);
        }
        catch (ItemNumberDoesNotExistException exception)    
        {
            fail ("Could not find the exisiting product in the item inventory");
        }
        catch (DatabaseFailureException exception)
        {
            fail("Could not connoct to databse");
        }
        ReceiptDTO receipt = contr.endTransaction();
        assertEquals(2, receipt.getItems().get(0).getQuantity(), "false");
    }

    @Test
    public void testScanProduct_ItemNotFound() throws ItemNumberDoesNotExistException, DatabaseFailureException
    {
        int barcode = 20;
        try
        {
            contr.scanProduct(barcode);
            fail("Was able to find non-existing item");
        }
        catch (ItemNumberDoesNotExistException exception)    
        {
            ReceiptDTO receipt = contr.endTransaction();
            assertEquals(0, receipt.getItems().size(), "Added non-existing item");
        }
        catch (DatabaseFailureException exception)
        {
            fail("Could not connoct to databse");
        }
        
    }

    @Test
    public void pay_Change() throws ItemNumberDoesNotExistException, DatabaseFailureException 
    {
        try
        {
            contr.scanProduct(1);       //10kr
            contr.scanProduct(1);       //10kr
            contr.scanProduct(3);       //15kr
        }
        catch (ItemNumberDoesNotExistException exception)    
        {
            fail ("Could not find the exisiting product in the item inventory");
        }
        catch (DatabaseFailureException exception)
        {
            fail("Could not connoct to databse");
        }
        contr.pay(40);
        double change = 40 - 35;
        ReceiptDTO receipt = contr.endTransaction();
        assertEquals(change, receipt.getChange(), "Incorrect change");
    }

}