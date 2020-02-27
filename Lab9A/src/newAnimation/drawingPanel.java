package newAnimation;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
/*
 * 
 * to display the drawing (or not) as expected by the application
 * 
 * 
 */

public class drawingPanel extends JPanel {

	int x1, y1, x2, y2;
	int mx1, my1, mx2, my2;
	int hx1, hy1, hx2, hy2;
	
	int angle = 0;
	int minangle = 0;
	int hourangle = 0;
	
	public drawingPanel()
	{
		x1 = 335;
		y1 = 100;
		x2 = 335;
		y2 = 180;
		
		mx1 = 335;
		my1 = 115;
		mx2 = 335;
	    my2 = 180;
		 
		hx1 = 335;
	    hy1 = 135;
		hx2 = 335;
		hy2 = 180;
		

		this.setBorder(BorderFactory.createLineBorder(Color.black));
		this.setPreferredSize(new Dimension(300,300));
	}
	
	public void stretch()
	{
		// x2 += 10;
		y2 += 10;
	}
	
	boolean update = false;

	public void update()
	{
		update = true;
		
		angle += 6;
		
		if (angle == 360)
		{
			angle = 0;
			
			minangle += 6;
			mx1 = (int) (325 + 75 * Math.sin(Math.toRadians(minangle)));
			my1 = (int) (180 - 75 * Math.cos(Math.toRadians(minangle)));
			
		}
		if (angle == 21600)
		{
			angle = 0;
			
			hourangle += 30;
			hx1 = (int) (325 + 50 * Math.sin(Math.toRadians(hourangle)));
			hy1 = (int) (180 - 50 * Math.cos(Math.toRadians(hourangle)));
		}
		x1 = (int) (325 + 100 * Math.sin(Math.toRadians(angle)));
		y1 = (int) (180 - 100 * Math.cos(Math.toRadians(angle)));
	}
	
	public void reset()
	{
		angle = 0;
		x1 = 325;
		y1 = 100;
		x2 = 325;
		y2 = 180;
		
		mx1 = 325;
		my1 = 115;
		mx2 = 325;
		my2 = 180;
		
		hx1 = 325;
		hy1 = 140;
		hx2 = 325;
		hy2 = 180;
		
	}

	
	boolean clear = false;

	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		if (!clear)
		{
			if (grow)
			{
				stretch();
			}
			if (update)
			{
				update();
			}
			
			Graphics2D g2d = (Graphics2D) g;
			
			g2d.setColor(Color.BLACK);
			
			g2d.fillOval(220, 70, 220, 220);
			
			g2d.setColor(Color.green);
			
			g2d.drawString("12", 327, 90);
			g2d.drawString("3", 430, 185);
			g2d.drawString("6", 332, 285);
			g2d.drawString("9", 225, 185);
			
			g2d.setColor(Color.RED);	
			
			g2d.setColor(Color.red);
			
			g2d.setStroke(new BasicStroke(2));
			
			g2d.drawLine(x1, y1, x2, y2);
			
			g2d.setColor(Color.blue);
			
			g2d.setStroke(new BasicStroke(2));
			
			g2d.drawLine(mx1, my1, mx2, my2);
			
			g2d.setColor(Color.ORANGE);
			
			g2d.setStroke(new BasicStroke(2));
			
			g2d.drawLine(hx1, hy1, hx2, hy2);
			
		}
	}

	boolean grow = false;
	
	public void grow() {
		// TODO Auto-generated method stub
		grow = true;
		
	}

	public void notgrow() {
		// TODO Auto-generated method stub
		grow = false;
	}


}
