package myApp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.Timer;


public class Listener implements ActionListener {
	
	GUI myguib; 
	
	ClassSched mySched;
	
	ClassSched[] sched = new ClassSched[50];
	
	int numofclasses;
	
	public Listener() throws IOException, ClassNotFoundException, EOFException
	{
		 ObjectInputStream infile = new ObjectInputStream(new FileInputStream("schedule.dat"));
		 
		 int size = infile.readInt();
		 
		 ClassSched[] data = new ClassSched[size];
		 
		 System.out.println("This file contains " + size + " schedule in the form of objects");
		 
		 for (int i = 0; i < size; i++)
		 {
			 data[i] = (ClassSched) infile.readObject();
			 numofclasses++;
		 }
		 
		 for (int i = 0; i < size; i++)
		 {
				System.out.println(data[i]);
		 }
		
		infile.close();
		
	}
	

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
			JButton clicked = (JButton) arg0.getSource();
			
			String txt = clicked.getText();
			
			if (txt.equals("Classes At"))
			{
			
			}
			if (txt.equals("All Classes"))
			{
				String outputstring = "";
				
				for (int i = 0; i < numofclasses; i++)
				{
					outputstring += sched[i].className + "\n";

				}
				myguib.outputlabel.setText(outputstring);
			}
			if (txt.equals("EXIT"))
			{
				System.exit(0);
			}
			
	}
	
	public void getgui(GUI mygui) {
		// TODO Auto-generated method stub
		
		this.myguib = mygui;
	}
	
	public void getSched (ClassSched mySched) {
		this.mySched = mySched;
	}

}
