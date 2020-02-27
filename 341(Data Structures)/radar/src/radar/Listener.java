package radar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.Timer;

	public class Listener implements ActionListener {

		drawingpanel panel;
		
		String pointlist;
		
		Nodelist nl;

		Timer t;
		
	public Listener()
	{
		t = new Timer(70, this);
	}
		
	public void actionPerformed(ActionEvent arg0) {

		
		if (arg0.getSource() instanceof JButton)
		{
			JButton clicked = (JButton) arg0.getSource();
				
			String txt = clicked.getText();
			
			if (txt.equals("Stop Radar"))
			{
				t.stop();
			}
			
			else if (txt.equals("Horizontal Radar"))
			{
				t.start();
				panel.horizontal();
			
			}
			
			else if (txt.equals("Vertical Radar"))
			{
				t.start();
				panel.vertical();
			}
			
			else if (txt.equals("Circular Radar"))
			{
				t.start();
				panel.circular();
			}
			
			panel.repaint();
		}
		else if (arg0.getSource() instanceof Timer)
		{
			System.out.println("Event coming from Timer");
			panel.repaint();
		}
	}

	public void setPoints(String points)
	{
		pointlist = points;
	}
	
	public void setdpanel(drawingpanel dpanel) {
		// TODO Auto-generated method stub
		
		panel = dpanel;
	}

	public void setNodeList(Nodelist nodel) {
		// TODO Auto-generated method stub
		nl = nodel;
	}
}