package com.github.integration;

import java.util.ArrayList;
import com.github.dtos.ItemDTO;
import com.github.integration.ItemNumberDoesNotExistException;
import com.github.integration.DatabaseFailureException;

/*
 * The external inventory of the program
 */
public class ExternalInventory 
{
    private ItemDTO[] itemList = new ItemDTO[3];
    private static ExternalInventory instance = null;

    /*
     * The external inventory
     */
    private ExternalInventory()
    { 

    }

    /**
     * Gets instance of object
     * @return returns instance
     */
    public static ExternalInventory getInstance()
    {
        if (instance == null)
            instance = new ExternalInventory();

        return instance;
    }

    /**
     * Item inventory with all items
     */
    private void itemInventory ()
    {
        itemList[0] = new ItemDTO(1, "Tomat",10 , "Röd", 1, 25);
		itemList[1] = new  ItemDTO(2, "Potatis",5 , "God", 1, 25);
		itemList[2] = new ItemDTO(3, "Gurka",15 , "Grön", 1, 25);
    }

    /*
     * Returns an ItemDTO object with the specified barcode 
     * 
     * @param barcode, the unique barcode identifier of the item
     * @return an ItemDTO object with the specified barcode and other values for all other parameters
     */
    /* 
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

    */

    /**
     * Searches fo intem in the item inventory. 
     * @param barcode   The barcode of the product
     * @return          if the barcode is valid, the item will be returned
     * @throws ItemNumberDoesNotExistException   ItemNumberDoesNotExistException if the barcode is not within the range 1-3.   
     * @throws DatabaseFailureException DatabaseFailureException if the barcode is 0, indicating a database failure.
     */
    public ItemDTO searchItemInventory(int barcode) throws ItemNumberDoesNotExistException, DatabaseFailureException 
    {
        itemInventory();
        if (barcode == 0)
			throw new DatabaseFailureException();
		for (int i = 0; i < itemList.length; i++) 
        {
            ItemDTO foundItem = itemList[i];
			if (this.itemList[i].getItemNumber() == barcode)
                return foundItem;
		}
        if (barcode > itemList.length - 1)
		    throw new ItemNumberDoesNotExistException(barcode);
        return null;
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
