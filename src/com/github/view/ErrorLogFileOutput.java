package com.github.view;
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
public class ErrorLogFileOutput
{
    private PrintWriter OutputFile;

    /**
     * Creates a new file .
     */
    public ErrorLogFileOutput() 
    {
        try
        {
           OutputFile = new PrintWriter (new FileWriter("DeveloperErrorLog.txt"), true); 
        }
        catch (IOException IOe)
        {
           System.out.println("Failed to make file");
           IOe.printStackTrace();
        }
    }
}
