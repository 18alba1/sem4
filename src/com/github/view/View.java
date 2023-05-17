package com.github.view;

import com.github.controller.Controller;
import com.github.dtos.*;

/*
 * The view which uses the controller to make method calls
 */
public class View 
{
    /*
     * Creates a new instance of this class that uses the Controller. This is needed to make calls in other layers
     * 
     * @param Represents the controller
     */
    public View(Controller contr)
    {
        contr.startSale();

        ItemDTO item1 = contr.scanProduct(1);
        System.out.println("Scanned Item: " + item1.getName());

        ItemDTO item2 = contr.scanProduct(2);
        System.out.println("Scanned Item: " + item2.getName());

        ItemDTO item3 = contr.scanProduct(2);
        System.out.println("Scanned Item: " + item3.getName());

        ItemDTO item4 = contr.scanProduct(3);
        System.out.println("Scanned Item: " + item4.getName());

        double change = contr.pay(500);
        System.out.println("change back: " + change + "\n");

        ReceiptDTO receipt = contr.endTransaction();
        System.out.println(receipt.toString());
    }
}