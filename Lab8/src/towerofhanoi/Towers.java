package towerofhanoi;

public class Towers {
	
	private int totaldisks;
	
	public Towers(int d)
	{
		totaldisks = d;
	}
	
	public void solve()
	{
		movetower(totaldisks, 1,3,2);
	}

	private void movetower(int numdisks, int start, int end, int temp)
	{
		if (numdisks == 1)
		{
			moveonedisk(start, end);
		}
		else
		{
			movetower(numdisks -1, start, temp, end);
			System.out.println(" moved " + (numdisks - 1) + " from " + start + " to " + temp);
			moveonedisk(start, end);
			System.out.println("moved one from " + start + " to " + end);
			movetower(numdisks -1, temp, end, start);
			System.out.println(" moved " + (numdisks - 1) + " from " + temp + " to " + end);
		}
	}
	private void moveonedisk(int start, int end)
	{
		System.out.println("Move one disk from " + start + " to " + end);
	}
	
}
