package com.github.integration;

/**
 * This exception is thrown to indicate that a products specifik
 * itemIdentifier (itemNumber) does not exist in the inventory catalog
 */
public class ItemNumberDoesNotExistException extends Exception
{
    /**
     * Thrown when item not found in item inventory
     * @param wrongItemNumber the item identifier of the product
     */
    public ItemNumberDoesNotExistException (int barcode)
    {
        super ("ERROR: Could not find product with itemIdenifier: " + barcode + " in the inventory catalog.");
    }
}