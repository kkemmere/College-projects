/*
 * Kevin Kemmerer, Iyengar 250, Util class
 * 
 * DecToBin, binsearch, GCD, Power, and Quick Sort
 */

public class Util {
	
	public static String decToBin(int n)
	{
		if (n == 0)
			return "0";
		else if (n == 1)
			return "1";
		else
		{
			return decToBin(n/2) + Integer.toString(n%2);
		/*  int remainder = n % 2;
			
			String temp = decToBin(n/2);
			
			if (remainder == 0)
			{
				return temp + "0";
			}
			else
				return temp + "1";
		*/
		}
		
		
	}
	
	public static String power(int x, int y)
	{
		if (x == 0)
			return "0";
		else if (x == 1)
			return "1";
		else if (y == 1)
			return "" + x;
		else
		{
			int remainder = y % 2;
			
			if (remainder == 0)
			{
				return "" + (double) Math.pow(x, y/2) * (double) Math.pow(x, y/2);
			}
			
			return "" + x * (double) Math.pow(x, y-1);
			
		
		}
		
	}
	
	public static int binarysearch(int[] data, int v) // return location of item found
	{	
		int l = 0, r = data.length -1, mid;
		
		while (l <= r)
		{
			mid = (l + r)/2;
			
			if (data[mid] == v)
			{
				return mid; // found at mid
			}
			else if (data[mid] > v)
			{
				r = mid - 1;
			}
			else 
			{
				l = mid + 1;
			}
		}
		return -1; // not found
	}
	
	public static int recbinarysearch(int[] data, int v, int l, int r)
	{
		if (l <= r)
		{
			int mid = (l + r)/2;
			
			if (data[mid] == v)
				return mid;
			else if (data[mid] > v)
				return recbinarysearch(data, v, l, mid-1);
				else return recbinarysearch(data, v, mid+1, r);
		}
		else
			return -1;
	}
	

}
