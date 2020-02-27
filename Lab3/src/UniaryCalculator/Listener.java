package UniaryCalculator;

/*
 * Kevin Kemmerer, Lab 3 Listener for UnaryCalculator
 * 
 * 
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;

public class Listener implements ActionListener {
	
	
	UnaryGUI mygui;
	@Override
	public void actionPerformed(ActionEvent event) {
		
		JButton clicked = (JButton) event.getSource();
		
		String text = clicked.getText();
		
		if (text.equals("Log"))
		{
		
			// get input text - convert to value
			
			String input = mygui.inputbox.getText();
			
			double y = Double.parseDouble(input);
			
			// use math library to calculate
			
			double logvalue = Math.log(y);
			
			// set the outputlabel by composing appropriate message
			
			mygui.setoutput("          " + "The logarithm of " + y + " is " + String.format("%8.2f", logvalue) + "           ");
			
		}
			else if (text.equals("Log base 2")) // natural log / log(2)
			{
				String input = mygui.inputbox.getText();
			
				double y = Double.parseDouble(input);
			
				// use math library to calculate
			
				double log2value = Math.log(y) / Math.log(2);
			
				// set the outputlabel by composing appropriate message
			
				mygui.setoutput("The logarithm base 2 of " + y + " is " + String.format("%8.2f", log2value) + "         ");
			
			}
		
			else if (text.equals("Square Root"))
			{
			
				String input = mygui.inputbox.getText();
			
				double y = Double.parseDouble(input);
			
				// use math library to calculate
			
				double sqrtvalue = Math.sqrt(y);
			
				// set the outputlabel by composing appropriate message
			
				mygui.setoutput("               " + "The Sqare root of " + y + " is " + String.format("%8.2f", sqrtvalue) + "           ");
			
			}
			else if (text.equals("Square"))
			{
			
				String input = mygui.inputbox.getText();
			
				double y = Double.parseDouble(input);
			
				// use math library to calculate
			
				double sqrvalue = Math.pow(y, 2);
			
				// set the outputlabel by composing appropriate message
			
				mygui.setoutput("               " + "The Square of " + y + " is " + sqrvalue  + "              ");
			
			}
			else if (text.equals("Log base 10")) // natural log / log(10)
			{
				String input = mygui.inputbox.getText();
			
				double y = Double.parseDouble(input);
			
				// use math library to calculate
			
				double log10value = Math.log(y) / Math.log(10);
			
				// set the outputlabel by composing appropriate message
			
				mygui.setoutput("The logarithm base 10 of " + y + " is " + String.format("%8.2f", log10value)  + "         ");
			
			}
			else if (text.equals("Cube"))
			{
			
				String input = mygui.inputbox.getText();
			
				double y = Double.parseDouble(input);
			
				// use math library to calculate
			
				double cubevalue = Math.pow(y, 3);
			
				// set the outputlabel by composing appropriate message
			
				mygui.setoutput("                   " + "The Cube of " + y + " is " + cubevalue + "              ");
			}
			else if (text.equals("Cube Root"))
			{
			
				String input = mygui.inputbox.getText();
			
				double y = Double.parseDouble(input);
			
				// use math library to calculate
			
				double cuberootvalue = Math.pow(Math.sqrt(y), 3);
			
				// set the outputlabel by composing appropriate message
			
				mygui.setoutput("               " + "The Cube Root of " + y + " is " + String.format("%8.2f", cuberootvalue) + "          ");
			}
	
	

	}

	public void setgui(UnaryGUI mygui) { // now i know the gui i am working with
		
		this.mygui = mygui;
	}

}
