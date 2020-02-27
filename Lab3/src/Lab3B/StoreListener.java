package Lab3B;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.swing.JButton;

public class StoreListener implements ActionListener {

	Customer[] mycustomers = new Customer[50];
	Video[] videos = new Video[50];
	Rental[] rentals = new Rental[50];
	
	int numberofcustomers = 0;
	int numberofvideos = 0;
	int numberofrentals = 0;
	StoreGUI mygui;
	
	
	public StoreListener() throws FileNotFoundException
	{
		Scanner cfile = new Scanner(new File("cfile.dat"));
		
		int count = 0;
		
		while(cfile.hasNext())
		{
			mycustomers[count] = new Customer(cfile.next(), cfile.next());
			count++;
		}
	
		numberofcustomers = count;
		cfile.close();
		
		Scanner vfile = new Scanner(new File("vfile.dat"));
		
		count = 0;
		
		while(vfile.hasNext())
		{
			videos[count] = new Video(vfile.next(), vfile.next());
			count++;
		}
		
		numberofvideos = count;
		vfile.close();
		
		Scanner rfile = new Scanner(new File("rfile.dat"));
		
		count = 0;
		
		while (rfile.hasNext())
		{
			rentals[count] = new Rental(rfile.nextLine());
			count++;
		}
		
		numberofrentals = count;
		rfile.close();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		JButton clicked = (JButton) e.getSource();
		
		String txt = clicked.getText();
		
		if( txt.equals("Customers"))
		{
			String outputString = "Names of customers:\n";
			
			for (int i = 0; i < numberofcustomers; i++)
			{
				outputString += mycustomers[i].c_name + "\n";
			}
			
			mygui.outputarea.setText(outputString);
		}
		
		if(txt.equals("Videos"))
		{
			String outputString = "Names of videos: \n";
			
			for (int i = 0; i < numberofvideos; i++)
			{
				outputString += videos[i].v_name + "\n";

			}
			
			mygui.outputarea.setText(outputString);
		}
		
		if(txt.equals("Rentals"))
		{
			String custno = mygui.infield.getText();
			boolean found = false;
			
			for (int i = 0; i < numberofrentals; i++)
			{
				if (rentals[i].match(custno))
				{
					found = true;
					mygui.outputarea.setText("The customer rental record is: ");
					
					
					String rentalrecords = rentals[i].getRecord();
					
					StringTokenizer stk = new StringTokenizer(rentalrecords);
					
					// get the first word from stk
					
					String custid = stk.nextToken();
					
					String Custname = "";
					
					// using that find the customer name and add to outputarea
					
					// String outputString = "Name and customer ID: \n";
					
					for (int n = 0; n < numberofcustomers; n++)
					{
						if(mycustomers[n].c_id.equals(custid))
						{
							Custname = mycustomers[i].c_name;
						}
					}
					
					mygui.outputarea.setText("The customer name is " + Custname + "\n");
					
					// get the next word which is the video ID
					
					String videoid = stk.nextToken();
					
					String Videoname = "";
					
					// find the name of the video and add to outputarea
					
					for (int j = 0; j < numberofvideos; j++)
					{
						if (videos[j].v_id.equals(videoid))
						{
							Videoname = videos[i].v_name;
						}
					}
					
					mygui.outputarea.setText("The customers name is: " + Custname + " and the video they rented was: "+ Videoname + "\n");
					
					
				}
			
			}
			
			if (! found)
			{
				mygui.outputarea.setText("Sorry, that's not a correct customer ID ");
			}
			
		}
		
	}

	public void getgui(StoreGUI mygui) {
		
		this.mygui = mygui;
		
	}

}
