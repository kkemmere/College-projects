import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class GUI extends JFrame {
	
	Listener l;
	
	JTextArea outputarea = new JTextArea();
	JButton customers = new JButton("Customers");;
	JButton mfunds = new JButton("Mutual Funds");
	JButton bonds = new JButton("Bonds");
	JButton stock = new JButton("Stocks");
	JPanel panel = new JPanel();
	
	public GUI()
	{
		
		Container canvas = this.getContentPane();
		
		this.setTitle("Assignment Two");
		
		this.setPreferredSize(new Dimension(300,300));
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		canvas.setBackground(Color.LIGHT_GRAY);
		
		outputarea.setBackground(Color.cyan);
		outputarea.setSize(new Dimension(200,200));
		
		panel.add(customers);
		panel.add(bonds);
		panel.add(outputarea);
		panel.add(stock);
		panel.add(mfunds);
	
		
		
		canvas.add(panel);
		
		this.pack();
		this.setVisible(true);
		
		
		
	}

	public void setlistener(Listener mylistener) {

		l = mylistener;
		
		mfunds.addActionListener(l);
		bonds.addActionListener(l);
		stock.addActionListener(l);
		customers.addActionListener(l);
		
	
	}
}
