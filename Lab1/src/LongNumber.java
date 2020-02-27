/*	Kevin Kemmerer, Iyengar 250 sec 02, 8/21
 * 
 * Lab1 - Design a class and use Arrays
 * 
 * Write an application that uses a scanner and reads from a file input2.dat – 
 * that contains any number of long integers (one per line).
 * 
Users should be given a choice to choose operations as shown below:
 
a)     Display properties of a number
b)     Add numbers
c)     Subtract numbers
d)     Multiply numbers
e)     Exit
 
*/

public class LongNumber {
	
	private String theNumber;

	public LongNumber(String string) {
		theNumber = string;
	}

	public String toString()
	{
		return " This long number is: " + theNumber;
	}
	
	public String getNumber() {
		// TODO Auto-generated method stub
		return theNumber;
	}

	public int getSize() {
		// TODO Auto-generated method stub
		return theNumber.length();
	}

	public int getSumofDigits() {
		// TODO Auto-generated method stub
		int sumofdigits = 0;
		
		for (int i = 0; i < theNumber.length(); i++)
		{
			sumofdigits += theNumber.charAt(i) - '0';
		}
		
		return sumofdigits;
	}

	public static LongNumber add(String number, String number2) {
		// TODO Auto-generated method stub
		
		String resultString = "";
		
		LongNumber result = new LongNumber("");
		
		int sumofdigits, carry = 0, value;
		
		// add the corresponding digits and generate the value and carry starting at the last digits of the numbers 
		
		
		int v1 = 0, v2 = 0;
		
		int indexrange = number.length();
		
		if (number2.length() > number.length())
			indexrange = number2.length();
		else
			number.length();
		
		for (int i = 0; i < indexrange; i++)
		{
			if (number.length() - 1 - i >= 0)
				v1 = (number.charAt(number.length()-1-i) - '0');
			else
				v1 = 0;
			
			if (number2.length() - 1 - i >= 0)
				v2 = (number2.charAt(number2.length()-1-i) - '0');
				else
					v2 = 0;
				
			sumofdigits = v1 + v2 + carry;
		
			carry = sumofdigits / 10;
			value = sumofdigits % 10;
			
			resultString =  value + resultString;
		
			// just for testing output to console
		
		//	System.out.print(value);
		}
		
	//	System.out.print(carry);
		
		if (carry > 0)
			resultString = carry + resultString;
		
		System.out.println(resultString);
		
		return result;
	}
	
	private void setNumber(String resultString)
	{
		theNumber = resultString;
	}

	public static LongNumber subtract(String number, String number2) {
		// TODO Auto-generated method stub
		
		String resultString = "";
		
		LongNumber result = new LongNumber("");
		
		
		return result;
		
	}

	public static LongNumber multiply(String number, String number2) {
	
		String resultString = "";
		
		LongNumber result = new LongNumber("");
		
		
		int sumofdigits, carry = 0, value;
		
		int val1 = 0, val2 = 0;
		
		int indexrange = number.length();
		
		if (number2.length() > number.length())
			indexrange = number2.length();
		else
			number.length();
		
		for (int i = 0; i < indexrange; i++)
		{
			if (number.length() - 1 - i >= 0)
				val1 = (number.charAt(number.length()-1-i) - '0');
			else
				val1 = 0;
			
			if (number2.length() - 1 - i >= 0)
				val2 = (number2.charAt(number2.length()-1-i) - '0');
				else
					val2 = 0;
				
			sumofdigits = val1 * val2 + carry;
		
			carry = sumofdigits / 10;
			value = sumofdigits % 10;
			
			resultString =  value + resultString;
		
		}
		
		if (carry > 0)
			resultString = carry + resultString;
		
		System.out.println(resultString);
		
		return result;
	}
}
