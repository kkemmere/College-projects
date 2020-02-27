import java.util.Random;

/* Kevin Kemmerer, Iyengar 250 sec 02, 8/21
*  Lab0 - Files, Arrays, Loops
*  Part1 of Lab0
a) Creates an integer array of size 50.
b) Store random numbers in the range -250 to 250.
c) Outputs the values neatly formatted in 5 columns.
d) Outputs the average of the values in the array.
e) Selects, and prints out, the largest number.
f) Outputs the reverse of the largest: Ex. If the largest is 125, it prints 521
*
*
*/

public class Part1 {

	public static void main(String[] args) {
		
		int data[]; // declares array of integers
		
		data = new int[50]; // crate an integer array of size 50 and set it to data
		
		Random mygenerator; // mygenerator is a random number generator
		
		mygenerator = new Random(); // created random number generator 
		
		for (int i = 0; i < 50; i++)
		{
			data[i] = mygenerator.nextInt(500) - 250;
		}
		
		
		double avg;
		int sum = 0; 
		int count = 0;
		for (int i = 0; i < 50; i++)
		{
			if (i % 5 == 0)
				System.out.println(); 
			
			System.out.format("  $  %4d  |  ", data[i]);
			
			count++;
			sum += data[i];
		}
		
		avg = ((double)sum)/count;
		System.out.format("\n The average of the array is " + avg);
		
		int largest = -500;
		
		for (int i = 0; i < 50; i++)
		{
			if (data[i] >  largest)
				largest = data[i];
		}
		
		System.out.println("\n The largest number in the array is " + largest);
		
		String rev = String.valueOf(largest);
		String reverse = new StringBuffer(rev).reverse().toString();
	
		System.out.println("\n The reverse of the largest number in the array is " + reverse);
	

		
		

	}

}
