
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JTextField;

/*
 * 
 * Kapil & Kevin
 * 
 */

public class Listener implements ActionListener
{
	
	Customer[] mycustomers = new Customer[50];
	VideoTitle[] Videos = new VideoTitle[50];
	Rentals[] rentals = new Rentals[50];
	
	int numberofcustomers = 0;
	int numberofvideos = 0;
	int numberofrentals = 0;
	Store_GUI  gui;
	
	
	public Listener() throws FileNotFoundException // videoStore Listener
	{
		// open using  a scanner c_file.dat and read and create customer object in an array
		Scanner cfile = new Scanner(new File("Customer.dat"));
		int count = 0;
		while(cfile.hasNext())
		{
			mycustomers[count] = new Customer(cfile.next(),cfile.next()); //customer name and customer_number
			count++;
		}
		numberofcustomers = count;
		cfile.close();
		
		// open using  a scanner v_file.dat and read and create video object in an array
		Scanner vfile = new Scanner(new File("videos.dat"));
		count = 0;
		while(vfile.hasNext())
		{
			Videos[count] = new VideoTitle(vfile.next(),vfile.next()); //video_number,video_title
			count++;
		}
		numberofvideos = count;
		vfile.close();
	
		
		// read the rentals file 
		Scanner rfile = new Scanner(new File("rentals.dat"));
		count = 0;
		while(rfile.hasNext())
		{
			rentals[count] = new Rentals(rfile.next()); //each line has customer number followed by list of videos
			count++;
		}
		numberofrentals = count;
		rfile.close();
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		JButton clicked = (JButton) arg0.getSource();
		
		String txt = clicked.getText();
		
		String custno;
		System.out.println("Some button was clicked");
			
		if(txt.equals("Customers"))
		{
			String outputString = "Names of customers:\n";
			
			for (int i = 0; i < numberofcustomers; i++)
			{
				outputString += mycustomers[i].c_name + "\n";
			}
			
			gui.outputArea.setText(outputString);
		}
		
		if(txt.equals("Videos"))
		{
			String outputString = "Names of videos:\n";
			
			for (int i = 0; i < numberofvideos; i++)
			{
				outputString += Videos[i].v_name + "\n";
			}
			
			gui.outputArea.setText(outputString);
		}
		
		if(txt.equals("Customer Info")) 
		{ 
			//this should give customer information for the id input not total number of customers in file
			//giving customer information
		   custno = gui.infield.getText(); 
		   String outputString = "";
		   
			for (int i = 0; i < numberofcustomers; i++) 
			{
				if (mycustomers[i].c_id.equals(custno))
				{
					gui.outputArea.setText("The Customer info" +"\n" + mycustomers[i].c_name);
				}
					//gui.outputArea.setText("The video by this customer" +"\n" + rentals[i].get_title());
				if (rentals[i].match(custno)) 
				{
					gui.outputArea.setText("The video by this customer" +"\n" + rentals[i].rented_video_list.size());
				}
					//there is no title in rentals.dat
					//so might need to get number and get it from video titles
			}
			
			gui.outputArea.setText(outputString); 
			
		}
		
	  if(txt.equals("Video Info"))
	  {
			String video_number = gui.infield.getText();
			String outputString = "";
			
		for(int i = 0; i< numberofvideos; i++)			
			{
				if (Videos[i].v_id.equals(video_number)) 
				{
					outputString += Videos[i].v_name + "\n";
					outputString += "total numer of rented times" + rentals[i].count_rented(Videos[i].v_id); //method that tracks every video how many time rented
				}
				//we need a method to return yes or not 
				if(rentals[i].count_rented(Videos[i].v_id) > 0) 
				{
					outputString += "rented: Yes";
					outputString += "rented to:" + rentals[i].renter_name; //returns name of the Customer
				}
			}
		gui.outputArea.setText(outputString);	
	 }
			
		
	//Rent a Video and Return a Video
		if(txt.equals("Rent Video")) 
		{
			String outputString = "";
			
			for(int i = 0; i< numberofrentals; i++)
			{
			String video_number = gui.infield.getText();  // Video number to be rented
			//rent it to a customer_number
			if (rentals[i].count_rented(video_number) > 0)
			{
				outputString += "can't be rented";
			}
			else
			{
				rentals[51] = new Rentals(video_number);
				 // Add the new object of rented video
				outputString += "rented";
			}
			
		}}
		
		
		if(txt.equals("Return Video")) {
			String outputString = "";
			String [] available_videos = new String[50]; //available videos
			for(int i = 0; i < numberofrentals; i++) {
			String video_number = gui.infield.getText();  // Video number to be rented
			//rent it to a customer_number
			if (rentals[i].count_rented(video_number)<1)
			{
				outputString += "can't be returned";
			}
			else
			{
				available_videos[i] = video_number; //Lets make a availalble array and add it to that.?
				 // Add the new object of rented video
				outputString += "returned video:title"; //Just gives a video number not a title had to work on it later
			}
			
		}}
	
			boolean found = false; // we here use boolean to determine if the customer id is found or not found
			
			for(int i = 0; i < numberofrentals; i++) {
				
				String custno1 = gui.infield.getText();
				
				if(rentals[i].match(custno1)){  // customer id is equal to the customer number 
					gui.outputArea.setText("The Customer rental record found" +"\n"); // if the customer id and number matches outputs the customers name
					found = true;
					
					String rentalrecords = rentals[i].getrecord();
					
					StringTokenizer stk = new StringTokenizer(rentalrecords);
					
					// get the first word from stk
					String custid = stk.nextToken();
					String Custname = "";
					for(int j = 0; j < numberofcustomers; j++)
					{
						{
							if (mycustomers[i].c_id.equals(custid))
							{
								Custname = mycustomers[i].c_name;
							}
						}
					}
					
					// using that find the customer name and add to outputArea
					gui.outputArea.setText("The Customer name is " + Custname +"\n");
					
					
					// get the next word which is the video id
					
					
					for(int j = 0; stk.hasMoreTokens(); j++)
					{
						custid = stk.nextToken();
						String Videoname = "";
						for (int k=0; k<numberofvideos; k++)
						{
						{
							if (Videos[k].v_id.equals(custid))
							{
								
								Videoname = Videos[k].v_name;
							}
						}
						
					}
						gui.outputArea.setText("The Video rented is " + Videoname +"\n");
					}
					// find the name of the video and add to outputArea
				}
			}
			
			if (! found) {
				gui.outputArea.setText("Wrong Customer ID");
			}
			
		}
	
	public void setGui(Store_GUI g) { //set Gui method
		// TODO Auto-generated method stub
		this.gui = g;
	}
}


	