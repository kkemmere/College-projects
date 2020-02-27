package myApp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

	public class GUI extends JFrame {
	
	Listener l;
	
	JPanel panel;
	JButton classesat;
	JTextField inputfield;
	JTextArea outputlabel;
	JButton allclasses;
	JButton exit;
	
	public GUI()
	{
		this.setSize(500,500);
		panel = new JPanel();
		panel.setSize(250,250);
		panel.setBackground(Color.CYAN);
		panel.setPreferredSize(new Dimension(400,400));
		
		classesat = new JButton("Classes At");
		classesat.setPreferredSize(new Dimension(100,80));
		panel.add(classesat);
		
		allclasses = new JButton("All Classes");
		allclasses.setPreferredSize(new Dimension(100,80));
		panel.add(allclasses);
		
		inputfield = new JTextField("Start Time");
		inputfield.setPreferredSize(new Dimension(100,100));
		panel.add(inputfield);
		
		outputlabel = new JTextArea("Output label");
		panel.add(outputlabel);
		outputlabel.setBackground(Color.pink);
		outputlabel.setPreferredSize(new Dimension(100,150));
		this.getContentPane().add(panel);

		exit = new JButton("EXIT");
		exit.setPreferredSize(new Dimension(100,80));
		panel.add(exit);
		
		this.getContentPane();
		
		this.pack();
		this.setVisible(true);
			
	}

	public void setlistener(Listener mylistener) {
	
		l = mylistener;
		
		classesat.addActionListener(l);
		exit.addActionListener(l);
		allclasses.addActionListener(l);
	
		
	}
	
	public void setoutput(String cnames) {
		// TODO Auto-generated method stub
		
		outputlabel.setText(cnames);
		
	}

}
