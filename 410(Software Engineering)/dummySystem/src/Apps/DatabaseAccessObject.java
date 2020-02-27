package Apps;
import Products.*;
import java.io.*;
import java.util.*;

public class DatabaseAccessObject {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

	Items itms;
		
	Scanner input = new Scanner(new File("inp.dat"));
	
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

			/*
			case 'S' : shoe = new Shoes(s);
						out.writeObject(shoe);
					break;

			case 'T' : tv = new TVS(s);
						out.writeObject(tv);
			break;

			case 'P' : ph = new Pharmacy(s);
						out.writeObject(ph);
						break;
			
			case 'R' : toy = new Toys(s);
						out.writeObject(toy);
						break;
			case 'C' : cereal = new Cereal(s);
						out.writeObject(cereal);
						break;
			case 'L' : speaker = new Speakers(s);
						out.writeObject(speaker);
						break;	
		*/
		}
		
	}
	
	
	
	}

}
