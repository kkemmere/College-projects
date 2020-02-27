
public class duplicate {
	
	static int n;
	static StringBuffer[] s = new StringBuffer[2];
	static StringBuffer[] newarray = null;
	static StringBuffer[] temparray;
	
	public static void initialize(StringBuffer[] arr)
	{

		String temp = "";
		
		
		for (int i = 0; i < n; i++)
		{
			temp += "0";
			
		}
		
		arr[0] = new StringBuffer(temp);
		
		
		String newtemp = "";
		
		
		for (int i = 0; i < n-1; i++)
		{
			newtemp += "0";
			
		}
		newtemp+="1";
		arr[1] = new StringBuffer(newtemp);
		
		
		
	}
	

	
	public static void expandandfill(StringBuffer[] current, int index)
	{
		temparray = new StringBuffer[current.length*2];
		int pos = 0;
		
		for (int i = 0; i < s.length; i++)
		{ 
			StringBuffer t = new StringBuffer(s[i].toString());
			t.setCharAt(index-1, '1');
			
			temparray[pos] = s[i];
			pos++;
			
			temparray[pos] = t;
			pos++;
			// add the item from s[i] to temparray, and the item s[i] with "1" at
			// index to temparray. pos++
		}
		
		s = temparray;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		n = 3; // assuming the input value
					
		initialize(s);
		
		System.out.println(s[0]);
		System.out.println(s[1]);
		
		for (int i = 1; i < n; i++)
		{
			System.out.println("New iteration");
			expandandfill(s, i);
			
			System.out.println("the new length is " + s.length);
			
			for (int j = 0; j < s.length; j++)
			{
				System.out.println(s[j]);
			}
			// this function will create a new array of double the size and make sure the position i
			// in the strings in the array is properly set
			
		}
		

	}
	
	

}
