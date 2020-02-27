import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JOptionPane;

/*	Kevin Kemmerer, Iyengar 250 sec 02, 8/21
 * 
 * Lab1 - Design a class and use Arrays
 * 
 * Application for LongNumber class
 * 
 */

public class LongNumberApp {

	public static void main(String[] args) throws FileNotFoundException {
	
		LongNumber[] numbers;
		
		int size;
		
		Scanner datafile = new Scanner(new File("LongNumbers.dat"));
		
		size = Integer.parseInt(datafile.nextLine()); // Reads an integer from the file that is the size of data to follow
		
		numbers = new LongNumber[size]; // creates an array of objects of size from the file
		
		for (int i = 0; i < size; i++)
		{
			numbers[i] = new LongNumber(datafile.nextLine()); // Created objects from the data file
		}
		
		for (int i = 0; i < size; i++)
		{
			System.out.println(numbers[i].toString());
		}
		
		String optionsMenu;
		
		// Create a menu to display numbers to the user
		
		optionsMenu = "Please choose your option: \n";
		optionsMenu = optionsMenu + "1. Print out the number, number of digits in that number and the sum\n";
		optionsMenu = optionsMenu + "2. Add two numbers\n";
		optionsMenu = optionsMenu + "3. Subtract two numbers\n";
		optionsMenu = optionsMenu + "4. Multiply two numbers\n";
		
		
		
		String numbersMenu = "Choose a number that you want to work with \n";
		
		for (int i = 0; i < size; i++)
		{
			numbersMenu = numbersMenu + " " + (i+1) + String.format("%30s\n", numbers[i].getNumber());
		}
		
		System.out.println(numbersMenu);
		
		int option = Integer.parseInt(JOptionPane.showInputDialog(optionsMenu));
		
		int numchoice = Integer.parseInt(JOptionPane.showInputDialog(numbersMenu));
		
		switch (option)
		{
		case 1: // number, digits in that number and the sum of those digits
			
			JOptionPane.showMessageDialog(null, "The number is " + numbers[numchoice-1].getNumber());
			
			JOptionPane.showMessageDialog(null, "The number of digits in the number is " + numbers[numchoice-1].getSize());
			
			// how to show the sum of the digits in the number
			
			JOptionPane.showMessageDialog(null, "The sum of digits is " + numbers[numchoice-1].getSumofDigits());
		
			break;
			
		case 2: // add two numbers
			
			// show the numbers menu to pick a choice of number
		
			int num1index  = Integer.parseInt(JOptionPane.showInputDialog(numbersMenu));
			
			// show the numbers menu to pick the second choice of number
			
			int num2index  = Integer.parseInt(JOptionPane.showInputDialog(numbersMenu));
			
			// get a LongNumber - which is the sum of those two numbers chosen
			
			LongNumber sum = LongNumber.add(numbers[num1index].getNumber(), numbers[num2index-1].getNumber());
			
			// output the numbers and the sum as expected by user
			
			// Returns a result that is shown in Lab1 handout
			
			
			break;
			
		case 3: // subtract two numbers
			
			// show the numbers menu to pick a choice of number
			
			int subnum1index  = Integer.parseInt(JOptionPane.showInputDialog(numbersMenu));
			
			// show the numbers menu to pick the second choice of number
			
			int subnum2index  = Integer.parseInt(JOptionPane.showInputDialog(numbersMenu));
			
			// get a LongNumber - which is the sum of those two numbers chosen
			
			LongNumber subsum = LongNumber.subtract(numbers[subnum1index].getNumber(), numbers[subnum2index-1].getNumber());
						
			
			
			break;
			
		case 4: // multiply the numbers
			
			// show the numbers menu to pick a choice of number
			
			int multnum1index = Integer.parseInt(JOptionPane.showInputDialog(numbersMenu));
			
			// show the numbers menu to pick the second choice of number
			
			int multnum2index = Integer.parseInt(JOptionPane.showInputDialog(numbersMenu));
			
			// get a LongNumer - which is the sum of those two numbers chosen
			
			LongNumber multsum = LongNumber.multiply(numbers[multnum1index].getNumber(), numbers[multnum2index-1].getNumber());
			
			break;
		}
		
		
	}

}
