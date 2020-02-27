import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Driver {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner inf = new Scanner(new File("infile.dat"));
		
		String line = inf.nextLine();
		
		StringTokenizer stk = new StringTokenizer(line);
		int size = stk.countTokens();
		int[] data = new int[size];
		
		for (int i = 0; i < size; i++)
		{
			data[i] = Integer.parseInt(stk.nextToken());
		}
		
		int[] countcompss;
		int[] countcompbs;
		int[] countcompis;
		int countcompbinarys;
		int countcomplinears;
		countcompss = Sorter.selectionsort(data);
		countcompbs = Sorter.bubblesort(data);
		countcompis = Sorter.insertionsort(data);
		countcompbinarys = Sorter.binarysearch(data, 15);
		countcomplinears = Sorter.linearsearch(data, 15);
		
		System.out.println("Program ended: The number of comparisons done in selection sort is " + countcompss[0] + " and the number of swaps is " + countcompss[1]);
		System.out.println("Program ended: The number of comparisons done in bubble sort is " + countcompbs[0] + " and the number of swaps is " + countcompbs[1]);
		
		System.out.println(countcompbinarys);
		System.out.println(countcomplinears);
		//System.out.println("Program ended: The number of comparisons done in insertion sort is " + countcompis[0] + " and the number of swaps is " + countcompis[1]);
		

	}

}
