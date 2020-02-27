package Products;


import java.util.StringTokenizer;

import Apps.Item;

public class Items implements Item {
	
	
	static String Item_name = "";
	static String Item_code = "";
	static double price = 0.0;
	static int inventory = 0; 
	
	public Items(String s) {
		
		
		StringTokenizer stk = new StringTokenizer(s);
		
		stk.nextToken(); // L classification
		
		Item_name =	stk.nextToken();
		Item_code = stk.nextToken();
		price = Double.parseDouble(stk.nextToken());
		// this.type = stk.nextToken();
	// 	this.impedance = Integer.parseInt(stk.nextToken());
		inventory = Integer.parseInt(stk.nextToken());
		
	}
	
	public String toString()
	{
		return "Name: " + Item_name + ", Code: " + Item_code + ", Price: " + price + ", Inventory: " + inventory;
	}


	public String Name() {
		// TODO Auto-generated method stub
		return Item_name;
	}


	public String Code() {
		// TODO Auto-generated method stub
		return Item_code;
	}

	public double getPrice()
	{
		return price;
	}

	public void setPrice(double price) // getting the price and setting the new price with discount
	{
		return; // Here is where you would compute the discount on an item
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
