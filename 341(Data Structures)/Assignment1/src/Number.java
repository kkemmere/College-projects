import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Number implements Serializable{

	int numbers;
	GUI GUI;
	
	public Number(String s) {
		// TODO Auto-generated constructor stub
		
		StringTokenizer stk = new StringTokenizer(s);
		
		numbers = Integer.parseInt(stk.nextToken()); // s string

	}

	public static void main(String[] args)throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
		GUI myguib = new GUI();
		
		Listener mylistener = new Listener();
		
		myguib.setlistener(mylistener);
		mylistener.getgui(myguib);
		
		Scanner infile = new Scanner(new File("input.dat"));
		
		// read the size
		
		int size = infile.nextInt();
		infile.nextLine();
		
		// create an array 
		
		Number[] data = new Number[size];
		
		
		for (int i = 0; i < size; i++)
		{
			data[i] = new Number(infile.nextLine());
		}

		
		for (int i = 0; i < size; i++)
		{
			System.out.println(data[i]);
		}
		
		infile.close();

	}
	
	public void getgui(GUI mygui) { 
		
		this.GUI = GUI;
	}

}
