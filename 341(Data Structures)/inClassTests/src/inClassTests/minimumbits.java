package inClassTests;

public class minimumbits {

	// math.log take the ceiling of log base 2 of n using math.ceiling function
	public static int minbits(int n)
	{

        if (n <= 0)
            return 0;
        else
        	return (n % 2 == 0 ? 0 : 1) + minbits(n / 2);
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("The minimum bits needed to represent your input is " + minimumbits.minbits(1423));
		

	}

}
