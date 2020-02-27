package newAnimation;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
/*
 * 
 * a panel that will be used to display buttons
 * 
 */

import animationpackage.listener;



public class buttonpanel extends JPanel {
	
	JButton draw = new JButton("Draw");
	JButton clear = new JButton("Clear");
	JButton stretch = new JButton("Stretch");
	JButton grow = new JButton("Grow");
	JButton stop = new JButton("Stop");
	JButton start = new JButton("Start");
	
	listener list;
		
	public buttonpanel()
	{
		this.setPreferredSize(new Dimension(100,100));
		
		Dimension d = new Dimension(50,50);
		
		draw.setSize(d);
		clear.setSize(d);
		stretch.setSize(d);
		grow.setSize(d);
		stop.setSize(d);
		start.setSize(d);
		
		this.setBorder(BorderFactory.createLineBorder(Color.red));
		
		this.add(draw);
		this.add(clear);
		this.add(stretch);
		this.add(grow);
		this.add(stop);
		this.add(start);
		
	}
	

	public void setlistener(listener mylistener) {
		// TODO Auto-generated method stub
		
		list = mylistener;
		
		draw.addActionListener(list);
		clear.addActionListener(list);
		stretch.addActionListener(list);
		grow.addActionListener(list);
		stop.addActionListener(list);
		start.addActionListener(list);
		
	}

}
