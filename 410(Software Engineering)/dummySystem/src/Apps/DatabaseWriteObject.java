package Apps;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;


import Products.Items;

import java.io.*;
import java.util.*;

public class DatabaseWriteObject {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Items itms;
		
		Object o = null;
		
		try
		{
		ObjectInputStream input = new ObjectInputStream(new FileInputStream("Storage.dat"));
		
		boolean done = false;
		
		System.out.println(" opened file");
		
		while (!done)
		{
			o = input.readObject();

			if (o instanceof Items)
			{
				itms = (Items) o;
				
				System.out.println(" The item object: " + itms.toString());
				
				System.out.println(" the inventory is " + itms.getInventory());

				itms.setInventory(45);  // inventory can be changed in the object this way
				
				System.out.println(" The inventory is changed");  // change is not on the file, need to write to the object file
			}
			
		/*
			if (o instanceof TVS)
			{
				tv = (TVS) o;
				
				System.out.println(" The TV object: " + tv.toString());
				
			}
			if (o instanceof Shoes)
			{
				shoe = (Shoes) o;
				
				System.out.println(" The Shoe object: " + shoe.toString());
				
			}
			if (o instanceof Fruit)
			{
				fruit = (Fruit) o;
				
				System.out.println(" The Fruit object: " + fruit.toString());
				
			}
			if (o instanceof Cereal)
			{
				cereal = (Cereal) o;
				
				System.out.println(" The Cereal object: " + cereal.toString());
				
			}
			if (o instanceof Toys)
			{
				toy = (Toys) o;
				
				System.out.println(" The Toy object: " + toy.toString());
				
			}
			if (o instanceof Speakers)
			{
				speaker = (Speakers) o;
				
				System.out.println(" The Speaker object: " + speaker.toString());
				
			}
			*/
			
		}
		}
		catch (Exception e)
		{
	//		System.out.println(e.toString());
			if (e instanceof EOFException)
				System.out.println("Exception occurred - ending - no more objects to read");
		}
	}

}
