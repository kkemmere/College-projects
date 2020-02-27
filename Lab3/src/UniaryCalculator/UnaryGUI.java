package UniaryCalculator;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;

/*
 * 	Kevin Kemmerer, Lab 4 UnaryGUI class for UnaryCalculator
 * 
 * 
 */

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UnaryGUI extends JFrame {
	
	Listener l;
	
	JPanel panel;
	JTextField inputbox;
	JButton logbutton;
	JButton log2button;
	JButton log10button;
	JButton sqrtbutton;
	JButton sqrbutton;
	JButton cubebutton;
	JButton cuberootbutton;
	JLabel outputlabel;

	
	public UnaryGUI()
	{
		this.setTitle("Unary Calculator");
		this.setSize(500, 500);
		panel = new JPanel();
		panel.setSize(300, 300);
	
		panel.setPreferredSize(new Dimension(290,260));
		
		panel.setBackground(Color.yellow);
		
		logbutton = new JButton("Log");
		log2button = new JButton("Log base 2");
		log10button = new JButton("Log base 10");
		sqrtbutton = new JButton("Square Root");
		sqrbutton = new JButton("Square");
		cubebutton = new JButton("Cube");
		cuberootbutton = new JButton("Cube Root");
		
		inputbox = new JTextField(20);
		
		panel.add(inputbox);
		
		outputlabel = new JLabel();
		
		panel.add(outputlabel);
		
		panel.add(logbutton);
		panel.add(log2button);
		panel.add(log10button);
		panel.add(sqrtbutton);
		panel.add(sqrbutton);
		panel.add(cubebutton);
		
		panel.add(cuberootbutton);
		
		
		this.getContentPane().add(panel);
		
		this.pack();
		this.setVisible(true);
		
		
		
	}

	public void setlistener(Listener mylistener) {
		
		
		l = mylistener;
		
		logbutton.addActionListener(l);
		log2button.addActionListener(l);
		log10button.addActionListener(l);
		sqrtbutton.addActionListener(l);
		sqrbutton.addActionListener(l);
		cubebutton.addActionListener(l);
		cuberootbutton.addActionListener(l);
	}
	
	public void setoutput(String s)
	{
		outputlabel.setText(s);
	}
	

}
