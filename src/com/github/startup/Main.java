package com.github.startup;

import com.github.controller.Controller;
import com.github.view.View;
import com.github.integration.*;

/*
 * The main class that starts the program
 */
public class Main 
{

    /*
     * The application's entry point
     * 
     * @param args an array of command-line arguments for the application
     */
    public static void main (String[] args)
    {
        Controller controller = new Controller();

        new View(controller);

        new AccountingSystem();
        new ExternalInventory();
        new SaleLog();
    }
}
