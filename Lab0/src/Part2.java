import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JOptionPane;

/* Kevin Kemmerer, Iyengar 250 sec 02, 8/21
 * 
*  Lab0 - Files, Arrays, Loops
*  
*	Part 2 of Lab0
*
a) The first line has an integer – indicating the number of data lines to follow.
b) Each data line has information to be stored in an object – an instance of the class W_Info. This object is used to store weather information. The values stored in the object are H_temperature, and L_temperature.
c) Create a file with pair of values – each pair representing the high and low temperature for a day.
d) Create a 1-dimensional array of objects to store all the items.
 
Your application should – then
 
e) Create and display a menu so user can do the following:
1. Prints out the temperatures of a chosen day
2. Select, and prints out the day with the lowest temperature
3. Selects and prints out the day with the highest temperature
4. Selects and prints out the average high and average low     
*
*
*/



public class Part2 {

	public static void main(String[] args) throws FileNotFoundException {
		
		W_Info[] datavalues; // Declaring an array of objects of type W_Info
		
		int size;
		
		Scanner datafile = new Scanner(new File("Weather_Info.dat"));
		
		size = datafile.nextInt(); // Reads an integer from the file that is the size of data to follow
		
		datavalues = new W_Info[size]; // creates an array of objects of size from the file
		
		for (int i = 0; i < size; i++)
		{
			datavalues[i] = new W_Info(datafile.nextDouble(), datafile.nextDouble()); // Created objects from the data file
		}
		
		String menu = "Please choose your option: \n";
		menu = menu + "1. For printing the temperatues of a day\n";
		menu = menu + "2. For printing the day with lowest temperature\n";
		menu = menu + "3. For printing the day with highest temperature\n";
		menu = menu + "4. For printing the average high and average low\n";
		
		int choice = Integer.parseInt(JOptionPane.showInputDialog(menu));
		
		switch(choice)
		{
		
		case 1:
			// Ask the user to choose a day - from 1 to size
			// if the day is valid
			// Then output the high and low temp for the day from this array
			
			// else output an error  message
		
			int day = Integer.parseInt(JOptionPane.showInputDialog("type in a value between 1 and " + size + " for the day of your choice"));
			
			if (day >= 1 & day <= size)
			{
				JOptionPane.showMessageDialog(null, "The high temperature of the day was " + datavalues[day-1].get_Htemp() +
													"\n The low tempearture of the day was " + datavalues[day-1].get_Ltemp());
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Wrong day chosen");
			}
			break;
			
		case 2: 
			
			double ltemp = 0;
			
			int ltempday = 1;
			
			ltemp = datavalues[1].get_Ltemp();
			
			for (int i = 1; i < size; i++)
			{
				if (ltemp > datavalues[i].get_Ltemp())
				{ 
					ltempday = i+1;
					ltemp = datavalues[i].get_Ltemp();
					
				}
			}
			
			JOptionPane.showMessageDialog(null, "The day with the lowest temperature was day: " + ltempday + " and the temperature was, " + ltemp);
			
			break;
			
		case 3:
			
			double htemp = 0;
			
			int htempday = 1;
			
			htemp = datavalues[1].get_Htemp();
			
			for (int i = 1; i < size; i++)
			{
				if (htemp < datavalues[i].get_Htemp())
				{
					htemp = datavalues[i].get_Htemp();
					htempday = i+1;
				}
			}
			
			JOptionPane.showMessageDialog(null, "The day with the highest temp was day: " + htempday + " and the temperature was, " + htemp);
			
			break;
			
		case 4:
			
			
			
			break;
			
		default: JOptionPane.showMessageDialog(null, "Option Not Valid");
		}
		
		
		
		
		
		
		
		
		
		

	}

}
