package newAnimation;

import java.awt.*;

import javax.swing.*;

public class newGui extends JFrame {
	
	
	buttonpanel bpanel = new buttonpanel();
	drawingPanel dpanel = new drawingPanel();
	
	public newGui()
	{
		this.setSize(1000,500);
		
		Container canvas = this.getContentPane();
		
		bpanel.setPreferredSize(new Dimension(300,200));
		dpanel.setPreferredSize(new Dimension(700,600));
		
		
		canvas.add(bpanel, BorderLayout.WEST);
		canvas.add(dpanel, BorderLayout.EAST);
		
		
		this.setVisible(true);
		
	}
	
	newListener l;
	
	public void setlistener(newListener list)
	{
		l = list;
		bpanel.draw.addActionListener(l);
		bpanel.clear.addActionListener(l);
		bpanel.stretch.addActionListener(l);
		bpanel.grow.addActionListener(l);
		bpanel.stop.addActionListener(l);
		bpanel.start.addActionListener(l);
	}




}
