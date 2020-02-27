import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JButton;

public class Listener implements ActionListener {
	
	GUI myguib;
	Number myNum;
	static int[] numbers = new int[50];

	int numberofintegers;
	
	public Listener() throws FileNotFoundException
	{
		Scanner infile = new Scanner(new File("input.dat"));
		
		int count = 0;
		
		while(infile.hasNext())
		{
			numbers[count] = infile.nextInt();
			count++;
		}
		
	
		numberofintegers = count;
		infile.close();
		
	}
	
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		JButton clicked = (JButton) e.getSource();
		
		String text = clicked.getText();
		
		if (text.equals("EXIT"))
		{
			System.exit(0);
		}
		if (text.equals("All Numbers"))
		{
			System.out.println("All Numbers:");
			
			for (int i = 0; i < numberofintegers; i++)
			{
				System.out.println(numbers[i]);

			}

	    }
		
		if (text.equals("Ascending"))
		{
		/*	int[] nums = new int[100];
			
			for (int i = 0; i < numbers.length; i++)
			{
				nums[i] = numbers[i];
			}
		*/
			// Listener.bubblesort(nums);
			
			for (int i = 0; i < numbers.length; i++)
			{
				System.out.println(Listener.bubblesort(numbers));
			}
		}
		
		if (text.equals("Descending"))
		{
			
		}
		if (text.equals("Mean")) // Average
		{
			
			int sum = 0;
			double avg;
			
			for (int i = 0; i < numberofintegers; i++)
			{
				sum += numbers[i];
			}
			
			avg = sum / 2;
			
			System.out.println("The mean of the integers is " + avg);

			
		}
		if (text.equals("Median")) // Middle
		{
			
		}
	} 
	
public static int[] bubblesort(int[] data) {
		
		// write a loop to bubble the largest to the top of the array
		
		int countcomparisons = 0; 
		int countswaps = 0;
		
		int[] result = new int[2];
		
		for (int i = 0; i < data.length -1; i++)
		{
			countcomparisons++;
			if (data[i] > data[i+1])
			{
				countswaps++;
				// swap values
				int temp = data[i];
				data[i] = data[i-1];
				data[i-1] = temp;
				
			}
			
		}
		
		result[0] = countcomparisons;
		result[1] = countswaps;
		return result;

	}

public static int[] selectionsort(int[] data)
{
	int smallloc, smallest;
	int countswaps = 0;
	int countcomparisons = 0;
	
	int[] result = new int[2];
	
	for (int loc = 0; loc < data.length; loc++)
	{
		smallest = 648580;
		smallloc = -10;
		
		for (int i = loc; i <data.length; i++)
		{
			countcomparisons++;
			if (data[i] < smallest)
			{
				smallest = data[i];
				smallloc = i;
			}
			
			
			data[smallloc] = data[loc];
			data[loc] = smallest;
		}
		countswaps++;
	}
	result[0] = countcomparisons;
	result[1] = countswaps;
	return result;
}
	
	
	
	public void getgui(GUI myguib) { 
		
		this.myguib = myguib;
	}

}
