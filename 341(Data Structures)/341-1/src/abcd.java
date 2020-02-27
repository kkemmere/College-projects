
public class abcd {

	static int n;
	static StringBuffer[] curr = new StringBuffer[4];
	static StringBuffer[] newarray = null;
	static StringBuffer[] temparray;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 n = 4; // assume you got this from user
		
		
		initialize(curr);
		
		System.out.println(curr[0]);
		System.out.println(curr[1]);
		System.out.println(curr[2]);
		System.out.println(curr[3]);
	
		
		
		for (int i = 1; i < n; i++)
		{
			// System.out.println("on to next iteration");
			extendandfill(curr, i);
			
			// this function will create a new array of double the size and make sure the position i
			// in the strings in the array is properly set

		//	System.out.println("the new length is" + curr.length);

			for (int k = 0; k < curr.length; k++)
			{
				System.out.println(curr[k]);
			}
			
		}
		
		
		
	}
	
	
	public static void extendandfill(StringBuffer[] current, int index)
	{
		
		temparray = new StringBuffer [current.length * 2];
		
//		System.out.println(temparray.length);
		int pos = 0;
		for (int i = 0; i < curr.length; i++)
		{
			// do two things - add the item curr[i] to temparray, and the item curr[i] with '1' at
			// index to temparray
			
			StringBuffer t = new StringBuffer(curr[i].toString());
			t.setCharAt(index-1, 'd');
			
			temparray[pos] = curr[i];
//			System.out.println(temparray[pos]);
			pos++;
			
			temparray[pos] = t;
//			System.out.println(temparray[pos]);
			pos++;
			
		}
		
		
		 curr = temparray;
//		System.out.println(curr.length);

	}

	public static void initialize(StringBuffer[] arr)
	{
		

		String temp = ""; // O(1) complexity
		
		
		for (int i = 0; i < n; i++)
		{
			temp += "a";
			
		}
		
		arr[0] = new StringBuffer(temp);
		
		
		String newtemp = "";
		
		
		for (int i = 0; i < n-1; i++)
		{
			newtemp += "a";
			
		}
		newtemp+= "b";
		arr[1] = new StringBuffer(newtemp);
		
		String temp2 = "";
		
		for (int i = 0; i < n-1; i++)
		{
			temp2 += "a";
		}
		temp2 += "c";
		arr[2] = new StringBuffer(temp2);
		
		String temp3 = "";
		
		
		for (int i = 0; i < n-1; i++)
		{
			temp3 += "a";
			
		}
		temp3 += "d";
		arr[3] = new StringBuffer(temp3);
		
		
		// When counting strings, initialize method creates 2 strings. Complexity is O(1)
	}


}
