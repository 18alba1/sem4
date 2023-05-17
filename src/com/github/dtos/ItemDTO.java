package com.github.dtos;

public class ItemDTO 
{
    private int itemNumber;
    private String name;
    private double price;
    private String description;
    private int quantity;
    private double vat;

    /*
     * Constructs ItemDTO with the given parameters
     * 
     * @param itemNumber the unique identification number of the item
     * @param name, name of the item
     * @param price, price of the item
     * @param description, the description of the item
     * @param quantity, quantity of the item
     * @param vat, the VAT-rate for the item
     */
    public ItemDTO(int itemNumber, String name, double price, String description, int quantity, double vat)
    {
        this.itemNumber = itemNumber;
        this.name = name;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
        this.vat = vat;
    }

    /*
     * Makes a String representing the object
     * 
     * @return String containing information about the object
     */
    @Override
    public String toString()
    {
        return quantity + "x " + name + " | " + price + " kr\n";
    }

    /*
     * Gets price
     * 
     * @return price of item
     */
    public double getPrice()
    {
        return price;
    }

    /*
     * sets price
     * 
     * @param newPrice, the new price that is going to be set
     */
    public void setPrice(double newPrice)
    {
        price = newPrice;
    }

    /*
     * Gets item number
     * 
     * @return the unique identification number of the item
     */

    public int getItemNumber()
    {
        return itemNumber;
    }

    /*
     * sets item number
     * 
     * @param newItemNumber, the new item number that is going to be set
     */
    public void setItemNumber(int newItemNumber)
    {
        itemNumber = newItemNumber;
    }

    /*
     * Gets item name
     * 
     * @return the name of the item
     */
    public String getName()
    {
        return name;
    }

    /*
     * sets item name
     * 
     * @param newName, the new item name that is going to be set
     */
    public void setName(String newName)
    {
        name = newName;
    }

     /*
     * Gets item description
     * 
     * @return the description of the item
     */
    public String getDescription()
    {
        return description;
    }

     /*
     * sets item description
     * 
     * @param newDescription, the new item description that is going to be set
     */
    public void setDescription(String newDescription)
    {
        description = newDescription;
    }

     /*
     * Gets item quantity
     * 
     * @return the quantity of the item
     */
    public int getQuantity()
    {
        return quantity;
    }

     /*
     * sets item quantity
     * 
     * @param quantity, the new item quantity that is going to be set
     */
    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }

    /*
     * Gets item VAT
     * 
     * @return the VAT of the item
     */
    public double getVAT()
    {
        return vat;
    }

     /*
     * sets item VAT
     * 
     * @param newVAT, the new item VAT that is going to be set
     */
    public void setVAT(int newVAT)
    {
        vat = newVAT;
    }
}
