import java.util.Scanner;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

public class nwords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String input;
		
		Scanner sin = new Scanner(System.in);
		
		System.out.println("Please enter a sentence");
		input = sin.nextLine();
		
		
		StringTokenizer stk = new StringTokenizer(input);
		int size = stk.countTokens();
		int[] data = new int[size];

		System.out.println("The size of your string is: " + size);
		System.out.println(input);
		
	}

}
