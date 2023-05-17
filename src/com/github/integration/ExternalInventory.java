package com.github.integration;

import java.util.ArrayList;

import com.github.dtos.ItemDTO;

/*
 * The external inventory of the program
 */
public class ExternalInventory 
{
    /*
     * The external inventory
     */
    public ExternalInventory() {}

    /*
     * Returns an ItemDTO object with the specified barcode 
     * 
     * @param barcode, the unique barcode identifier of the item
     * @return an ItemDTO object with the specified barcode and other values for all other parameters
     */
    public static ItemDTO getItem(int barcode)      
    {
        //Exampel code for test
        ItemDTO item;
        if(barcode == 1)
        {
            item = new ItemDTO(barcode, "Tomat",10 , "Röd", 1, 25); 
        } 
        else if (barcode == 2)
        {
            item = new ItemDTO(barcode, "Potatis",5 , "God", 1, 25);
        }
        else if (barcode == 3) 
        {
            item = new ItemDTO(barcode, "Gurka",15 , "Grön", 1, 25); 
        } 
        else 
        {
            item = new ItemDTO(0, "NOTFound",0 , "", 0, 0);
        }
        return item;
    }

    /*
     * Updates inventory
     * 
     * @param items, an Array list of all items
     */
    public static void updateInventory(ArrayList<ItemDTO> items)    
    {
        // Behöver ej koda
    }
}
