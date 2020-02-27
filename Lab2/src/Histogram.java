/*
 * 
 * 
 * 
 * 
 * 
 */

import java.applet.Applet;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Histogram extends Applet {
		
		int[] data; // Instance variable
		
		int width = 500; 
		int height = 500;
		
		public Histogram() throws FileNotFoundException
		{
			Scanner inFile = new Scanner(new File("C:/Users/tj8200pw/workspace/CS250-2/Lab2/input1.dat"));
				
			data = new int[10];
			for(int n = 0; n < data.length; n++)
			{
				data[n] = inFile.nextInt();
			}
			
			inFile.close();
	    }

		public void paint(Graphics g)
		{
			//int width = this.getWidth();
		    //int height = this.getHeight();
		    
		    this.setSize(width, height);
		    
			int total = 0;
			
			double ratio = 360.0/total;
			
			for (int i = 0; i < data.length; i++)
	    	{
	    		total += data[i];
	    	}
		  
	    	Graphics2D g2D = (Graphics2D) g;
	    	
	    	g2D.setStroke(new BasicStroke (20));
	    	
	    	Font f = new Font("Helvetica", Font.BOLD,18);
	    	g.setFont(f);
	    	g.setColor(Color.blue);
	    	
	    	double lineratio = (height-20)/total;
	    	
	    	for(int i = 0; i < data.length; i++)
	    	{
	    		g.drawLine((i+1) * 30, height-30,((i+1) * 30),(int) (height-30 - data[i]*lineratio));
	    		g.drawString(data[i]+"", ((i+1)*30)-10, height);
	    	}
	    	
	    	
		}
}	
