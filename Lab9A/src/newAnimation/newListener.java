package newAnimation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.Timer;
/*
 * 
 * responds to events as programmed/expected - manipulates the drawing on the drawingpanel
 * 
 * 
 */


public class newListener implements ActionListener {
	
	drawingPanel panel;
	
	Timer t;
	
	public newListener()
	{
		t = new Timer(1000, this);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		if (arg0.getSource() instanceof JButton)
		{
			JButton clicked = (JButton) arg0.getSource();
				
			String txt = clicked.getText();
				
			if (txt.equals("Draw"))
			{
				panel.clear = false;
			}
			else if (txt.equals("Clear"))
			{
				panel.clear = true;
				panel.reset();
			}
			else if (txt.equals("Stretch"))
			{
				panel.stretch();
				panel.clear = false;
			}
			else if (txt.equals("Grow"))
			{
				t.start();
				panel.grow();
			}
			else if (txt.equals("Stop"))
			{
				t.stop();
				panel.notgrow();
			}
			else if (txt.equals("Start"))
			{
				t.start();
				panel.update();
			}
			
			panel.repaint();
		}
		else if (arg0.getSource() instanceof Timer)
		{
			System.out.println("Event coming from Timer");
			panel.repaint();
		}
	}

	public void setdpanel(drawingPanel dpanel) {
		// TODO Auto-generated method stub
		
		panel = dpanel;
	}

}
