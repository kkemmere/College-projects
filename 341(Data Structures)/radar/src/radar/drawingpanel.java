package radar;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Timer;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class drawingpanel extends JPanel  {

	int hx1, hy1, hx2, hy2;
	int vx1, vy1, vx2, vy2;
	int cx1, cy1, cx2, cy2;
	
	int x1 = 0;
	double angle = 0;
	int px1, py1;
	
	String plist;
	
	public drawingpanel()
	{
		hx1 = 1;
		hy1 = 1;
		hx2 = 1;
		hy2 = 500;
		
		vx1 = 500;
		vy1 = 1;
		vx2 = 1;
		vy2 = 1;
		
		cx1 = 1;
		cy1 = 1;
		cx2 = 500;
		cy2 = 1;
		

		this.setBorder(BorderFactory.createLineBorder(Color.black));
		this.setPreferredSize(new Dimension(200,200));
	}


	
	public void paintComponent(Graphics g)
	{

		super.paintComponent(g);
			
		if (horizontal)
		{
			Graphics2D g2d = (Graphics2D) g;
			
			g2d.setColor(Color.GREEN);
				
			g2d.setStroke(new BasicStroke(2));
				
			g2d.drawLine(hx1, hy1, hx2, hy2);
			
			
			try {
				
				Scanner scan = new Scanner(new File("points.dat"));
				
				while (scan.hasNext())
				{
				px1 = scan.nextInt();
				py1 = scan.nextInt();
						
				if (px1 == hx1)
				{
				g2d.setColor(Color.RED);
				g2d.drawOval(px1, py1, 9, 9);
				g2d.fillOval(px1, py1, 9, 9);
	
				}	
						
	        	}
		
				horizontal();
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					

		}
		if (vertical)
		{
			Graphics2D g2d = (Graphics2D) g;
			
			g2d.setColor(Color.GREEN);
				
			g2d.setStroke(new BasicStroke(2));
				
			g2d.drawLine(vx1, vy1, vx2, vy2);
			
			try {
				Scanner scan2 = new Scanner(new File("points.dat"));
				
				while (scan2.hasNext())
				{
				px1 = scan2.nextInt();
				py1 = scan2.nextInt();
						
				if (py1 == vy1)
				{
					
				g2d.setColor(Color.RED);
				g2d.drawOval(px1, py1, 9, 9);
				g2d.fillOval(px1, py1, 9, 9);
	
				}	
						
	        	}		
				vertical();
			}
		 catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
			
		
		}
		
		if (circular)
		{
			Graphics2D g2d = (Graphics2D) g;
			
			g2d.setColor(Color.GREEN);
				
			g2d.setStroke(new BasicStroke(2));
				
			g2d.drawLine(cx1, cy1, cx2, cy2);
			
			try {
				Scanner scan3 = new Scanner(new File("points.dat"));
				
				while (scan3.hasNext())
				{
					int tempx = scan3.nextInt();
					int tempy = scan3.nextInt();
					
					double distanceAB = Math.hypot(cx1-cx2, cy1-cy2);
					double distanceBC = Math.hypot(cx2-tempx, cy2-tempy);
					double distanceAC = Math.hypot(cx1-tempx, cy1-tempy);
					
					double total = distanceBC + distanceAC;
					
					if(distanceAB - total <= x1 && (distanceAB - total) >= -.1)
					{
						px1 = tempx;
						py1 = tempy;
						
						
					}
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
			
		}

	}
	boolean horizontal = false;
	
	public void horizontal() {
		horizontal = true;
		vertical = false;

		hx1 += 1;
		hx2 += 1;
		
		if (hx1 == 300 && hx2 == 300)
		{
			hx1 = 1;
			hx2 = 1;
		}
	
	}
	
	boolean vertical = false;
	
	public void vertical() {
		vertical = true;
		horizontal = false;
		
		vy1 += 1;
		vy2 += 1;
		
		if (vy1 == 220 && vy2 == 220)
		{
			vy1 = 1;
			vy2 = 1;
		} 
	}
	
	boolean circular = false;
	
	public void circular()
	{
		circular = true;
	}
	
	public void setPointsList(String pointlist) 
	{
		plist = pointlist;
	}
}