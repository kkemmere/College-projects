package MVC;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.text.DecimalFormat;

import Apps.ProductDatabaseRead;
import Products.Cereal;
import Products.Fruit;
import Products.Item;
import Products.Pharmacy;
import Products.Shoes;
import Products.Speakers;
import Products.TVS;
import Products.Toys;

public class InventoryManager {
	protected static Item[] data = new Item[25];
	protected static int[] cart = new int[25];
	protected static int size;
	
	public InventoryManager() {
		Pharmacy ph;
		TVS tv;
		Shoes shoe;
		Fruit fruit;
		Cereal cereal;
		Toys toy;
		Speakers speaker;
		
		Object o = null;
		int i = 0;
		
		try {
			ObjectInputStream input = new ObjectInputStream(new FileInputStream("Storage.dat"));
			boolean done = false;
			System.out.println("-Opened file-");
			
			while (!done) {
				o = input.readObject();
				
				if (o instanceof Pharmacy) {
					ph = (Pharmacy) o;
					data[i] = ph;
					i++;
				}
				if (o instanceof TVS) {
					tv = (TVS) o;
					data[i] = tv;
					i++;
				}
				if (o instanceof Shoes) {
					shoe = (Shoes) o;
					data[i] = shoe;
					i++;
				}
				if (o instanceof Fruit) {
					fruit = (Fruit) o;
					data[i] = fruit;
					i++;
				}
				if (o instanceof Cereal) {
					cereal = (Cereal) o;
					data[i] = cereal;
					i++;
				}
				if (o instanceof Toys) {
					toy = (Toys) o;
					data[i] = toy;
					i++;
				}
				if (o instanceof Speakers) {
					speaker = (Speakers) o;
					data[i] = speaker;
					i++;
				}
				
			}
			
		}
		catch (Exception e) {
			if (e instanceof EOFException) {
				System.out.println("Exception occured - no more items to read.");
				size = i;
				for (int i1=0; i1<size; i1++) {
					cart[i1] = 0;
				}
			}
		}
		
	}
	
	public static Boolean addItem(int pos, int qty) {
		int storage = data[pos].getInventory();
		System.out.println(data[pos].getInventory());
		if (data[pos].getInventory()>0 && data[pos].getInventory()>=qty) {
			data[pos].setInventory(storage - qty);
			cart[pos] += qty;
			System.out.println("Added " + cart[pos] + " " + data[pos].getName());
			return true;
		}
		else {
			System.out.println("Not enough inventory in storage!");
			return false;
		}
	}
	
	public static int getCartInventory(int pos) {
		return cart[pos];
	}
	
	public static String getCartCost() {
		DecimalFormat df = new DecimalFormat("#.00");
		double result = 0;
		for (int i=0; i<size; i++) {
			if (cart[i]!=0) {
				result += data[i].getPrice()*cart[i];
			}
		}
		return df.format(result);
	}
	
	public static Item[] getData() {
		return data;
	}

	public static int getSize() {
		return size;
	}
	
	public static String getName(int pos) {
		return data[pos].getName();
	}
	
	public static String toString(int pos) {
		return data[pos].toString();
	}
	
	public static int getInventory(int pos) {
		return data[pos].getInventory();
	}
	
	public static String getCode(int pos) {
		return data[pos].getCode();
	}
	
	public static double getPrice(int pos) {
		return data[pos].getPrice();
	}
	
	public static String getType(int pos) {
		Object o = data[pos];
		if (o instanceof Pharmacy) {
			return "Pharmacy";
		}
		if (o instanceof TVS) {
			return "TVS";
		}
		if (o instanceof Shoes) {
			return "Shoes";
		}
		if (o instanceof Fruit) {
			return "Fruit";
		}
		if (o instanceof Toys) {
			return "Toys";
		}
		if (o instanceof Cereal) {
			return "Cereal";
		}
		if (o instanceof Speakers) {
			return "Speakers";
		}
		return "All";
	}
	
	public static void orderList() throws FileNotFoundException {
		PrintWriter output = new PrintWriter(new File("OrderList.txt"));
		for (int i=0; i<size; i++) {
			if (data[i].getInventory()<10) {
				output.println(data[i].getName() + ", current inventory: " + data[i].getInventory());
			}
		}
		System.out.println("Low inventory exported to \"OrderList.txt\"");
		output.close();
	}
}
