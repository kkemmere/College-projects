/*
 * Vanessa Hinrichs 
 * CS 250 
 * Assignment 3
 */


import java.io.Serializable;
import java.util.Date;

public abstract class Item implements Serializable {

	public static String itemName;
	
	public static double itemPrice;
	
	public String toString()
	{
		return "Name: " + itemName + "Price: " + itemPrice;
	}
	
	public static String getName()
	{
		return itemName;
	}
	
	public void setName(String n)
	{
		itemName = n;
	}
	
	public static double getPrice()
	{
		return itemPrice;
	}
	
}
