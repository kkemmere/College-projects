import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class heap {

	
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		Scanner infile = new Scanner(new File("Heap.dat"));
		
		String row1 = infile.nextLine();
		
		StringTokenizer stkr1 = new StringTokenizer(row1);
		int r1size = stkr1.countTokens() + 1;
		int[] arow1 = new int[r1size];
		
		for (int i = 1; i < r1size; i++)
		{
			arow1[i] = Integer.parseInt(stkr1.nextToken());
		}
		
		for (int i = 0; i < r1size; i++)
		{
			System.out.print(" " +arow1[i]);
		}
		
		
		if (chk(arow1, 1, -1))
		{
			System.out.print(" " + "yes heap");
		}
		else
		{
			System.out.print(" " + "no heap");
		}
		
		System.out.println("");
		
		String row2 = infile.nextLine();
		
		StringTokenizer stkr2 = new StringTokenizer(row2);
		int r2size = stkr2.countTokens();
		int[] arow2 = new int[r2size];
		
		for (int i = 0; i < r2size; i++)
		{
			arow2[i] = Integer.parseInt(stkr2.nextToken());
		}
		
		for (int i = 0; i < r2size; i++)
		{
			System.out.print(" " +arow2[i]);
		}
		
		if (chk(arow2, 1, -1))
		{
			System.out.println(" " + "yes heap");
		}
		else 
		{
			System.out.println(" " + "no heap");
		}
		
		System.out.print("");
		
		String row3 = infile.nextLine();
		
		StringTokenizer stkr3 = new StringTokenizer(row3);
		int r3size = stkr3.countTokens();
		int[] arow3 = new int[r3size];
		
		for (int i = 0; i < r3size; i++)
		{
			arow3[i] = Integer.parseInt(stkr3.nextToken());
		}
		
		for (int i = 0; i < r3size; i++)
		{
			System.out.print(" " +arow3[i]);
		}
		
		if (chk(arow3, 1, -1))
		{
			System.out.println(" " + "yes heap");
		}
		else 
		{
			System.out.println(" " + "no heap");
		}
		
		System.out.print("");
		
		String row4 = infile.nextLine();
		
		StringTokenizer stkr4 = new StringTokenizer(row4);
		int r4size = stkr4.countTokens();
		int[] arow4 = new int[r4size];
		
		for (int i = 0; i < r4size; i++)
		{
			arow4[i] = Integer.parseInt(stkr4.nextToken());
		}
		
		for (int i = 0; i < r4size; i++)
		{
			System.out.print(" " +arow4[i]);
		}
		
		if (chk(arow4, 1, -1))
		{
			System.out.println(" " + "yes heap");
		}
		else 
		{
			System.out.println(" " + "no heap");
		}
		
		
		
	}
	
	public static boolean chk(int[] d, int i, int v)
	{
		if (i >= d.length)
			return true;
		else return (v < d[i]) && chk(d, i*2, d[i]) && chk(d, i*2+1, d[i]);
	}
	
}
