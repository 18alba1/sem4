package com.github.integration;

/**
 * This exception is thrown to indicate that a products specifik
 * itemIdentifier (itemNumber) does not exist in the inventory catalog
 */
public class ItemNumberDoesNotExistException extends Exception
{
    public ItemNumberDoesNotExistException (int wrongItemNumber)
    {
        super ("Could not find the enterd itemIdenifier: " + wrongItemNumber + "in the inventory catalog.");
    }
}