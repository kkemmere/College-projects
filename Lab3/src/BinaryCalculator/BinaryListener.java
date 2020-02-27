package BinaryCalculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import UniaryCalculator.UnaryGUI;

/*
 * Kevin Kemmerer, Lab 3 Part 2, BinaryListener
 * 
 */

public class BinaryListener implements ActionListener {

	BinaryGUI myguib;
	@Override
	public void actionPerformed(ActionEvent e) {
		
		JButton clicked = (JButton) e.getSource();
		
		String text = clicked.getText();
		
		if (text.equals("+"))
		{

			String input = myguib.inputbox.getText();
			String input2 = myguib.inputbox2.getText();
			
			int number0 = Integer.parseInt(input, 2);
			int number1 = Integer.parseInt(input2, 2);

			int sum = number0 + number1;
			
			myguib.setoutput("The sum in binary is : " + Integer.toBinaryString(sum));

	    }
		if (text.equals("*"))
		{

			String input = myguib.inputbox.getText();
			String input2 = myguib.inputbox2.getText();
			
			int number0 = Integer.parseInt(input, 2);
			int number1 = Integer.parseInt(input2, 2);

			int sum = number0 * number1;
			
			myguib.setoutput("The sum in binary is : " + Integer.toBinaryString(sum));

	    }
		if (text.equals("/"))
		{

			String input = myguib.inputbox.getText();
			String input2 = myguib.inputbox2.getText();
			
			int number0 = Integer.parseInt(input, 2);
			int number1 = Integer.parseInt(input2, 2);

			int sum = number0 / number1;
			
			myguib.setoutput("The sum in binary is : " + Integer.toBinaryString(sum));

	    }
		if (text.equals("-"))
		{

			String input = myguib.inputbox.getText();
			String input2 = myguib.inputbox2.getText();
			
			int number0 = Integer.parseInt(input, 2);
			int number1 = Integer.parseInt(input2, 2);

			int sum = number0 - number1;
			
			myguib.setoutput("The sum in binary is : " + Integer.toBinaryString(sum));

	    }
	

		
		
}
	
public void getgui(BinaryGUI myguib) { // now i know the gui i am working with
		
		this.myguib = myguib;
	}

}
