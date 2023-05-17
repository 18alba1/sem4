package com.github.controller;

import java.util.ArrayList;

import com.github.dtos.*;
import com.github.model.*;
import com.github.integration.ExternalInventory;
import com.github.integration.ItemNumberDoesNotExistException;
import com.github.integration.DatabaseFailureException;

/*
 * The controller class which contains all logic
 */
public class Controller 
{
    private Goods goods;
    private Register register;
    private ExceptionLogger logger = new ExceptionLogger();

    /* 
     * Creates the Register
    */
    public Controller()
    {
        this.register = new Register();
    }
    
    /*
     * Starts the sale
     */
    public void startSale()
    {
        goods = new Goods();
    }

    /*
     * Scans the products barcod and adds prdouct to item list.
     * It also updates total in Register.
     * 
     * @param barcode The barcode of the product that is currently being scanned
     * @return ItemDTO which represents the scanned product
     */
    public ItemDTO scanProduct(int barcode) throws ItemNumberDoesNotExistException, DatabaseFailureException
    {
        try
        {
            ItemDTO item = goods.addProduct(barcode);
            register.updateTotal(item);
    
            return item;
        }
        catch (ItemNumberDoesNotExistException exception)    
        {
            logger.errorLog(exception);
            throw new ItemNumberDoesNotExistException(barcode, exception);
        }
        catch (DatabaseFailureException exception)
        {
            logger.errorLog(exception);
            throw new DatabaseFailureException();
        }
    }
    
    /*
     * Handles payment and calculates change
     * 
     * @param paidAmount The amount that the customer pays
     * @return The result of the change calculation
     */
    public double pay(double paidAmount)
    {
        double change = register.payment(paidAmount);
        
        return change; 
    }

    /*
     * Ends transacrion and gets all items which is needed to create the receipt
     * 
     * @return object representing the receipt for the items purchased
     */
    public ReceiptDTO endTransaction()
    {
        ArrayList<ItemDTO> itemList = goods.getItems();
        ReceiptDTO receipt = register.createReceipt(itemList);

        ExternalInventory.updateInventory(itemList);
        
        return receipt;
    }
}
