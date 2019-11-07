import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Scanner;


public class Manager {
	

	protected static Item[] data = new Item[25];
	protected static int[] cart = new int[25];
	protected static int size;
	
	GUI panel;
	int currentIndex;
	
	
	
	public Manager() throws FileNotFoundException
	{
		
		Object o = null;

		Item itm;
		
		try
		{
			ObjectInputStream input = new ObjectInputStream(new FileInputStream("itemList.txt"));
			
			boolean done = false;
			
			System.out.println(" Opened file");
			
			while (!done)
			{
				o = input.readObject();
	
				
				itm = (Item) o;
				
				System.out.println(" The item is: " + itm.getName());
					
				System.out.println(" the Price is " + itm.getPrice());
	
				
			}
		}
		catch (Exception e)
		{
	//		System.out.println(e.toString());
			if (e instanceof EOFException)
				System.out.println("Exception occurred - ending - no more objects to read");
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
	
	public static double getPrice(int pos) {
		return data[pos].getPrice();
	}
	
	public static String getType(int pos) {
		Object o = data[pos];
		if (o instanceof Item) {
			return "Item";
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
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Items itms;
		
		Scanner input = new Scanner(new File("itemList.txt"));
		
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Storage.dat"));
		
		String s;
		
		while (input.hasNext())
		{
			s = input.nextLine();
			
			switch (s.charAt(0))
			{
				case 'I' : itms = new Items(s);
							out.writeObject(itms);
				break;
			}
		}

	}
}