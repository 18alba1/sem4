package com.github.controller;

import java.util.ArrayList;
import java.util.List;
import com.github.dtos.*;
import com.github.model.*;
import com.github.view.ErrorLogFileOutput;
import com.github.integration.*;

/*
 * The controller class which contains all logic
 */
public class Controller 
{
    private Goods goods;
    private Register register;
    private List<SaleObserver> sObs = new ArrayList<SaleObserver>();
    private ExternalInventory extInvSys = ExternalInventory.getInstance();

    /* 
     * Creates the Register
    */
    public Controller()
    {
        this.register = new Register();
    }
    
    /*
     * Starts the sale, creates goods and adds the Saleobservers
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
     * @throws ItemNumberDoesNotExistException If the itemNumber does not exist in the itemInventory.
	 * @throws DatabaseFailureException If there is an issue with the database.
     */
    public ItemDTO scanProduct(int barcode) throws ItemNumberDoesNotExistException, DatabaseFailureException
    {
        try
        {
            ItemDTO item = extInvSys.searchItemInventory(barcode);
            goods.addProduct(item);
            register.updateTotal(item);
    
            return item;
        }
        catch (ItemNumberDoesNotExistException exception)    
        {
            throw new ItemNumberDoesNotExistException(barcode);
        }
        catch (DatabaseFailureException exception)
        {
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
        double change = register.payment(paidAmount, goods.getItems());
        
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

     /**
     * Source: page 213-214
     * Adds observer to the observer list (sObs)
     * @param SO the observer that is added to the list
     */
    public void addsObs (SaleObserver SO)
    {
        sObs.add(SO);
    }

    public void addsObsToRegister()
    {
        for(SaleObserver SO : sObs)
            register.addsObs(SO);
    }
}
