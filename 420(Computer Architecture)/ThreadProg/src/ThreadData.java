import java.util.concurrent.atomic.AtomicInteger;

public class ThreadData extends Thread {
	
	Thread t;
	int counter;
	String name;
	AtomicInteger AtCounter = new AtomicInteger(-1);
	
	
	
	ThreadData(String tname, int tCounter)
	{
		tname = name;
		tCounter = counter;
		t = new Thread(ThreadData + t)
		
		
	}

}
