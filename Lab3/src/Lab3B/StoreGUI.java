package Lab3B;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class StoreGUI extends JFrame {
	
	StoreListener l;
	
	
	JTextArea outputarea = new JTextArea();
	JButton customers = new JButton("Customers");;
	JButton videos = new JButton("Videos");
	JButton videor = new JButton("Rentals");
	
	public JTextField infield = new JTextField(5);
	
	JPanel panel = new JPanel();
	
public StoreGUI() 
 { 
	Container canvas = this.getContentPane();
	
	this.setTitle("Video Store");
	
	this.setPreferredSize(new Dimension(500,500));
	
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	canvas.setBackground(Color.LIGHT_GRAY);
	
	outputarea.setBackground(Color.cyan);
	outputarea.setSize(new Dimension(300,300));
	
	panel.add(customers);
	panel.add(videos);
	panel.add(outputarea);
	panel.add(videor);
	panel.add(infield);
	
	
	canvas.add(panel);
	
	this.pack();
	this.setVisible(true);
		
	}

	public void setlistener(StoreListener mylistener) {

		l = mylistener;
		
		customers.addActionListener(mylistener);
		videos.addActionListener(mylistener);
		videor.addActionListener(mylistener);
	}

	public void setoutput(String s)
	{
		outputarea.setText(s);
	}

}
