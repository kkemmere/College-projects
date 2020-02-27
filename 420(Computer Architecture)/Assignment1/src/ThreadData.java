
public class ThreadData extends Thread {
	
	String name;
	int counter = 0;
	
	// NewThread constructor.
	
	ThreadData(ThreadData data, String tname) 
	{
		name = tname;
	}
	
	public void Increment()
	{
		counter++;
	
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		Increment();
		
		if (counter == 40000)
		{
			System.out.println("The test has been completed!");
		}
		else
		{
			System.out.println("The test has failed");
		
		}
	}	
	
}

