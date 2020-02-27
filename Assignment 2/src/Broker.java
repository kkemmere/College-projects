import java.util.Scanner;

public class Broker {
	
	CustomerAccount[] CA = new CustomerAccount[10];
	
	Stock[] STK = new Stock[10];
	
	MutualFund[] MF = new MutualFund[10];
	
	Bond[] BD = new Bond[10];
	
	public Broker()
	{
		Scanner BDfile = new Scanner("BD.dat");
		
		int count = 0;
		
		while(BDfile.hasNext())
		{
			BD[count] = new Bond(BDfile.next(), BDfile.next(), BDfile.next());
			count++;
		}
		
		
		
	}

}
