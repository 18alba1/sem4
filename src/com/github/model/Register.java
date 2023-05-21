package com.github.model;

import java.util.ArrayList;
import java.util.List;
import com.github.dtos.*;
import com.github.integration.*;

/*
 * The register of the program
 */
public class Register 
{
    private DiscountService discountS = new DiscountService();
    private double totalPrice;
    private double totalVAT; 
    private double change;
    private List<SaleObserver> sObs = new ArrayList<SaleObserver>();

    /*
     * The register
     */
    public Register() {}

    /*
     * Updates the total price of the sale with the price of the given item.
     * @param item The item to add to the sale total.
     */
    public void updateTotal(ItemDTO item)
    {
        totalPrice += item.getPrice();
        totalVAT += item.getPrice() * (item.getVAT() / 100);
    }

    /*
     * Calculates the change owed to the customer after they pay the given amount.
     * @param paidAmount The amount paid by the customer.
     * @return The change owed to the customer.
     */
    public double payment(double paidAmount, ArrayList<ItemDTO> items) 
    {
        discountS.setDiscount(new DiscountProduct());
        discountS.processDiscount(items);

        discountS.setDiscount(new DiscountQuantity());
        discountS.processDiscount(items);
        totalPrice -= discountS.getTotalDiscount();

        change = paidAmount - totalPrice;

        return change;
    }

    /*
     * Creates a new receipt for the given list of items.
     * @param items The list of items to include in the receipt.
     * @return The newly created receipt.
     */
    public ReceiptDTO createReceipt(ArrayList<ItemDTO> items)
    {
        ReceiptDTO receipt = new ReceiptDTO(totalPrice, totalVAT, change, items, discountS.getTotalDiscount());
        notifyObservers();
        AccountingSystem.updateAccountingInfo(receipt);
        SaleLog.addSale(receipt);
        totalPrice = 0;
        change = 0;
        totalVAT = 0;
        discountS.setTotalDiscount(0);
        return receipt;
    }
    
    /*
     * Returns the total price of the sale.
     * @return The total price of the sale.
     */
    public double getTotalPrice()
    {
        return this.totalPrice;
    }

    /*
     * Gets the total VAT of the sale.
     * @return The total VAT of the sale.
     */
    public double getTotalVAT()
    {
        return this.totalVAT;
    }

    /*
     * Gets the change owed to the customer.
     * @return The change owed to the customer.
     */
    public double getChange()
    {
        return this.change;
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

    /**
     * Calls SaleObservers
     */
    public void notifyObservers()
    {
        for (int i = 0; i < sObs.size(); i++) 
        {
            sObs.get(i).priceOfSale(this.totalPrice);
        }
    }
}
