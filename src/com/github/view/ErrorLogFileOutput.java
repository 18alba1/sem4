package com.github.view;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import com.github.integration.*;
import com.github.integration.ItemNumberDoesNotExistException;

/* Source for TotalIncomeFileOutput() inspiration:
 Lindbäck, L. (2023). A First Course in Object Oriented Development. Creative Commons
 Attribution 4.0 International License.
*/

/**
 * Used to print the total income to a file.
 */
public class ErrorLogFileOutput
{
    private static PrintWriter OutputFile;

    /**
     * Creates a new file .
     */
    public ErrorLogFileOutput() 
    {
        try
        {
           OutputFile = new PrintWriter (new FileWriter("DeveloperErrorLog.txt", true ), true); 
        }
        catch (IOException IOe)
        {
           System.out.println("Failed to make file");
           IOe.printStackTrace();
        }
    }

    public static void errorMessage (Exception exception)
    {
        /**
         * Prints error masager to user
         * @param exception the exception
         */
        OutputFile.println ("Date: " + java.time.LocalDate.now() + " Developer errorlog: " + exception + "\n");
        System.out.println("Date: " + java.time.LocalDate.now() + " " + exception.getMessage() + " Contact customer service." + "\n");
    }
}
