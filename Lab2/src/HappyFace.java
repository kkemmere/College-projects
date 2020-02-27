/* 9/6  HappyFace/PieChart java Applet
 * 
 * Kevin Kemmerer, Iyengar
 * 
 * 
 * 
 */

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.applet.*;

public class HappyFace extends Applet
{     
	int width = 300, length = 300;
	
	int[] data;
	
	public HappyFace() throws FileNotFoundException
	{
		Scanner inFile = new Scanner(new File("C:/Users/tj8200pw/workspace/CS250-2/Lab2/input1.dat"));
			
		data = new int[10];
		for(int n = 0; n < data.length; n ++)
		{
			data[n] = inFile.nextInt();
		}
		
		inFile.close();
    }
	
    public void paint(Graphics g)
    {         
    	// width = this.getWidth();
    	// length = this.getHeight();
    	
    	this.setSize(width,length);
    	
	    Font f = new Font("Helvetica", Font.BOLD,20);
	    g.setFont(f);
	    g.drawString("My Pie Chart", 10, 300);
	    
	    int total = 360;
	    int startAngle = 90;
	   
	    g.setColor(Color.blue);
	    int arcAngle = (int) (360 *((float) data[1])/total);
	    
	    g.fillArc(100, 180, 95, 95, startAngle, arcAngle);
	    
	    startAngle += arcAngle;
	    g.setColor(Color.green);
	    arcAngle = (int) (360 *((float) data[2])/total);
	    
	    g.fillArc(100, 180, 95, 95, startAngle, arcAngle);
	    
	    startAngle += arcAngle;
	    g.setColor(Color.yellow);
	    arcAngle = (int) (360 *((float) data[3])/total);
	    
	    g.fillArc(100, 180, 95, 95, startAngle, arcAngle);
	    
	    startAngle += arcAngle;
	    g.setColor(Color.red);
	    arcAngle = (int) (360 *((float) data[4])/total);
	    
	    g.fillArc(100, 180, 95, 95, startAngle, arcAngle);

	    startAngle += arcAngle;
	    g.setColor(Color.ORANGE);
	    arcAngle = (int) (360 *((float) data[5])/total);
	    
	    g.fillArc(100, 180, 95, 95, startAngle, arcAngle);
	    
	    startAngle += arcAngle;
	    g.setColor(Color.black);
	    arcAngle = (int) (360 *((float) data[6])/total);
	    
	    g.fillArc(100, 180, 95, 95, startAngle, arcAngle);
	    
	    startAngle += arcAngle;
	    g.setColor(Color.CYAN);
	    arcAngle = (int) (360 *((float) data[7])/total);
	    
	    g.fillArc(100, 180, 95, 95, startAngle, arcAngle);
	    
	    startAngle += arcAngle;
	    g.setColor(Color.gray);
	    arcAngle = (int) (360 *((float) data[8])/total);
	    
	    g.fillArc(100, 180, 95, 95, startAngle, arcAngle);
	    
	    startAngle += arcAngle;
	    g.setColor(Color.magenta);
	    arcAngle = (int) (360 *((float) data[9])/total);
	    
	    g.fillArc(100, 180, 95, 95, startAngle, arcAngle);
	    
	    startAngle += arcAngle;
	    g.setColor(Color.pink);
	    arcAngle = (int) (360 *((float) data[10])/total);
	    
	    g.fillArc(100, 180, 95, 95, startAngle, arcAngle);
	    
	    
	   // g.drawOval(0, 0, width, length);
	   //  g.fillOval(90, 120, 50, 20);
	   //  g.fillOval(190, 120, 50, 20);
	   //  g.drawLine(width/2, 125, width/2, 175);
	    
	   // g.setColor(Color.red);
	   // g.fillArc(110, 180, 95, 95, 0, -180);
    }
}