package radar;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class radarApp {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		gui myguib = new gui();
		Listener mylistener = new Listener();
		myguib.setlistener(mylistener);
		mylistener.setdpanel(myguib.dpanel);
		
		Scanner infile = new Scanner(new File("points.dat"));
		
		Nodelist NL = new Nodelist();
		
		while (infile.hasNext())
		{
			point newpoint = new point(infile.nextInt(), infile.nextInt());
			
			Node tempnode = new Node(newpoint);
			
			NL.insert(tempnode);
				
		}
		
		System.out.println(NL.toString());
		mylistener.setNodeList(NL);
		mylistener.setPoints(NL.getPoints());
		
	}

}
