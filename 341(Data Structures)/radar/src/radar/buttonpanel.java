package radar;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class buttonpanel extends JPanel {
	
	Listener list;
	
	JButton horizontal = new JButton("Horizontal Radar");
	JButton vertical = new JButton("Vertical Radar");
	JButton circular = new JButton("Circular Radar");
	JButton stop = new JButton("Stop Radar");
	
	
	public buttonpanel()
	{
		this.setPreferredSize(new Dimension(100,100));
		Dimension d = new Dimension(10,10);
		
		horizontal.setSize(d);
		vertical.setSize(d);
		circular.setSize(d);
		stop.setSize(d);
		
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		this.add(horizontal);
		this.add(vertical);
		this.add(circular);
		this.add(stop);
		
		
	
	}
	
	public void setlistener(Listener mylistener) {
		// TODO Auto-generated method stub
		
		list = mylistener;
		
		horizontal.addActionListener(list);
		vertical.addActionListener(list);
		circular.addActionListener(list);
		stop.addActionListener(list);
	}
}
