package myApp;


import java.io.IOException;
import java.io.Serializable;
import java.util.StringTokenizer;


public class ClassSched implements Serializable {
	
	String className;
	double starttime, period;
	
	public ClassSched(String s)
	{
		StringTokenizer stk = new StringTokenizer(s);
		
		className = stk.nextToken();
		starttime = Double.parseDouble(stk.nextToken());
		period = Double.parseDouble(stk.nextToken());
	}

	public String toString()
	{
		return "The class " + className + " starts at " + starttime + " and goes for " + period + " hours";
	}
	
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		
		GUI myguib = new GUI();
		
		Listener mylistener = new Listener();
		
		myguib.setlistener(mylistener);
		mylistener.getgui(myguib);
		
	}
}
