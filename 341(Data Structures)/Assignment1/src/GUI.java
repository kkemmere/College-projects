import java.awt.Color;
import java.awt.Dimension;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class GUI extends JFrame {
		
		Listener l;
		
		JPanel panel;
		JButton displayn;
		JButton ascending;
		JButton descending;
		JButton mean;
		JButton median;
		JButton exit;
		
	public GUI() throws FileNotFoundException
	{
		
		this.setSize(500,500);
		panel = new JPanel();
		panel.setSize(300,300);
		
		panel.setPreferredSize(new Dimension(300,300));
			
		panel.setBackground(Color.CYAN);

		displayn = new JButton("All Numbers");
		panel.add(displayn);
		
		ascending = new JButton("Ascending");
		panel.add(ascending);
		
		descending = new JButton("Descending");
		panel.add(descending);
		
		mean = new JButton("Mean");
		panel.add(mean);
		
		median = new JButton("Median");
		panel.add(median);
			
		exit = new JButton("EXIT");
		panel.add(exit);
			
		this.getContentPane().add(panel);
			
		this.pack();
		this.setVisible(true);
				
			
	}
		
	public void setlistener(Listener mylistener) {
			
		l = mylistener;
			
		displayn.addActionListener(l);
		ascending.addActionListener(l);
		descending.addActionListener(l);
		mean.addActionListener(l);
		median.addActionListener(l);
		exit.addActionListener(l);
			
	}
	
}
