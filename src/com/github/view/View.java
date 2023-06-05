package com.github.view;

import com.github.controller.Controller;
import com.github.dtos.*;
import com.github.integration.ItemNumberDoesNotExistException;
import com.github.integration.DatabaseFailureException;
import com.github.view.TotalRevenueFileOutput;

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
        contr.addsObs(new TotalRevenueView());
        contr.addsObs(new TotalRevenueFileOutput());
        contr.addsObsToRegister();
        testRun(contr);
        testRun(contr);
        testRun(contr);
    }



    
    private void testRun(Controller contr)
    {
        contr.startSale();

        try
        {
            ItemDTO item1 = contr.scanProduct(0);
            System.out.println("Scanned Item: " + item1.getName());
      
        }
        catch (ItemNumberDoesNotExistException exception)
        {
            ErrorLogFileOutput.errorMessage(exception);
        }
        catch (DatabaseFailureException exception)
        {
            ErrorLogFileOutput.errorMessage(exception);
        }

        try
        {
            ItemDTO item2 = contr.scanProduct(4);
            System.out.println("Scanned Item: " + item2.getName());
        }
        catch (ItemNumberDoesNotExistException exception)
        {
            ErrorLogFileOutput.errorMessage(exception);
        }
        catch (DatabaseFailureException exception)
        {
            ErrorLogFileOutput.errorMessage(exception);
        }

        try
        {
            ItemDTO item3 = contr.scanProduct(2);
            System.out.println("Scanned Item: " + item3.getName());
        }
        catch (ItemNumberDoesNotExistException exception)
        {
            ErrorLogFileOutput.errorMessage(exception);
        }
        catch (DatabaseFailureException exception)
        {
            ErrorLogFileOutput.errorMessage(exception);
        }

        try
        {
            ItemDTO item4 = contr.scanProduct(3);
            System.out.println("Scanned Item: " + item4.getName());    
        }
        catch (ItemNumberDoesNotExistException exception)
        {
            ErrorLogFileOutput.errorMessage(exception);
        }
        catch (DatabaseFailureException exception)
        {
            ErrorLogFileOutput.errorMessage(exception);
        }

        double change = contr.pay(500);
        System.out.println("change back: " + change + "\n");

        ReceiptDTO receipt = contr.endTransaction();
        System.out.println(receipt.toString());
    }
}