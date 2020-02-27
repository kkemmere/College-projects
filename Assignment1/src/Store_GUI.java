
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Store_GUI extends JFrame{ // The myGui object is a window (JFrame)
	
	Listener mylistener; // listener who will do the needful when action occurs on me
	
	JButton CustomerButton = new JButton("Customer Info");
	JButton VTitle = new JButton("Video Info");
	JButton customers = new JButton("Customers");;
	JButton videos = new JButton("Videos");
	JButton rentVideo = new JButton("Rent Video");
	JButton returnVideo = new JButton("Return Video");
	JTextArea outputArea = new JTextArea();
	
	JPanel panel = new JPanel();
	
	public JTextField infield = new JTextField(5);
	
	public Store_GUI() 
	{
		Container canvas = this.getContentPane();
		
		this.setTitle("My Video Store App"); // adding a title for the gui
		this.setPreferredSize(new Dimension(600,600));
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		outputArea.setText("This is the output area");
		outputArea.setBackground(Color.cyan);
		outputArea.setSize(new Dimension(300,300));

		panel.add(CustomerButton); // this is how we add a button
		panel.add(VTitle);
		panel.add(customers);
		panel.add(videos);
		panel.add(outputArea);
		panel.add(infield);
		panel.add(rentVideo);
		canvas.add(panel);
		
		this.pack();
		this.setVisible(true); // needs to set visible as true make the gui visible 
	}

	public void setListener(Listener l) {
		// TODO Auto-generated method stub
		
		mylistener = l;
		CustomerButton.addActionListener(l); 
		customers.addActionListener(l);
		videos.addActionListener(l);
		VTitle.addActionListener(l);
		rentVideo.addActionListener(l);
	}

	public void setoutput(String s) {
		outputArea.setText(s);
	}
	
}
