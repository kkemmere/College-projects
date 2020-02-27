

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.StringTokenizer;


public abstract class Item implements Serializable {
	
	
	String itemName;
	double price;
	int inventory;
	
	public String getName()
	{
		return itemName;
	}
	
	public String toString()
	{
		return "Name: " + itemName + ", Code: " + price;
	}
	

	public double getPrice()
	{
		return price;
	}
	public int getInventory()
	{
		return inventory;
	}
	
	public void setInventory(int i) // sets the inventory to the new value
	{
		inventory = i;
		
	}


}
