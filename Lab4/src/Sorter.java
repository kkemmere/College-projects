/*
 * Kevin Kemmerer, Iyengar 250, Sorting 
 * 
 * 
 */
public class Sorter {
	
	// Selection Sort
	
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

	// Bubble Sort
	
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
	
	// Insertion Sort 
	
	public static int[] insertionsort(int[] data) {
		
		// move or insert the item at position 1 in the list which is the data at position 0
		
		int countcomparisons = 0;
		int countswaps = 0;
		
		int[] result = new int[2];
		
		for (int i = 1; i < data.length; i++)
		{
			for (int pos = i; pos < 0; pos--)
			{
				countcomparisons++;
				if (data[pos] < data[pos -1])
				{
					// swap
					int temp = data[pos];
					data[pos] = data[pos-1];
					data[pos-1] = temp;
					countswaps++;
				}
				else
				{
					break;
				}
			}
		}
		
		result[0] = countcomparisons;
		result[1] = countswaps;
		return result;
	}
	
	// Linear Search
	
	public static int linearsearch(int[] data, int y) //  search and return if it is in the array
	{
		boolean result = false;
		int location = -1;
		for (int i = 0; i < data.length; i++)
		{
			if (y == data[i])
			{
				result = true;
				location = i;
			}
		}
		
		
		
		return location;
	}
	
	// Binary Search

	public static int binarysearch(int[] data, int y) // search and return position of y found else return -1
	{
		int result = -1;
		
		int l = 0, r = data.length -1;
		
		while (l <= r)
		{
			int mid = (l+r)/2;
			
			if (data[mid] == y)
			{
				result = mid;
			}
			else if (data[mid] < y)
			{
				r = mid - 1;
			}
			else 
			{
				l = mid + 1;
			}
		}
		
		return result;
	}
}
