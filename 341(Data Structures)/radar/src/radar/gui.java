package radar;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

	public class gui extends JFrame {
	
	
		
		buttonpanel bpanel = new buttonpanel();
		drawingpanel dpanel = new drawingpanel();
		
	public gui() {
	
		this.setSize(300,355);
		
		Container canvas = this.getContentPane();	
		
		canvas.add(bpanel, BorderLayout.NORTH);
		canvas.add(dpanel, BorderLayout.SOUTH);
		
		
		this.setVisible(true);
		
	}

	Listener l;

	public void setlistener(Listener mylistener) {
	
		l = mylistener;
		
		bpanel.horizontal.addActionListener(l);
		bpanel.circular.addActionListener(l);
		bpanel.vertical.addActionListener(l);
		bpanel.stop.addActionListener(l);
		
	}
}