package com.github.view;
import com.github.model.SaleObserver;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/* Source for TotalIncomeFileOutput() inspiration:
 Lindbäck, L. (2023). A First Course in Object Oriented Development. Creative Commons
 Attribution 4.0 International License.
*/

/**
 * Used to print the total income to a file.
 */
public class TotalRevenueFileOutput implements SaleObserver  
{
    private double totalRevenue;
    private PrintWriter OutputFile;

    /**
     * Creates a new file .
     */
    public TotalRevenueFileOutput() 
    {
        try
        {
            OutputFile = new PrintWriter (new FileWriter("totalIncome.txt"), true); 
        }
        catch (IOException IOe)
        {
           System.out.println("Failed to make file");
           IOe.printStackTrace();
        }
    }

    /**
     * prints total revenue
     * @param totalPrice added to total revenue
     */
    @Override       //subclass method should override superclass method
    public void priceOfSale (double totalPrice)
    {
        totalRevenue += totalPrice;
        OutputFile.println("Date: " + java.time.LocalDate.now() + " Total revenue: " + totalRevenue + "\n");
    }
}
