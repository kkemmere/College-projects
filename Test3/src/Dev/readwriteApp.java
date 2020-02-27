package Dev;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Scanner;

import myApp.ClassSched;

public class readwriteApp {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Scanner infile = new Scanner(new File("inp.dat"));
		
		int size = infile.nextInt();
		infile.nextLine();
		
		ClassSched[] data = new ClassSched[size];
		
		for (int i = 0; i < size; i++)
		{
			data[i] = new ClassSched(infile.nextLine());
		}
		
		ObjectOutputStream outdat = new ObjectOutputStream(new FileOutputStream("schedule.dat"));
		
		outdat.writeObject(data);  // writing an entire array. similarly you can read an entire array as an object
	}

}
