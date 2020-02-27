package BinaryCalculator;

import java.awt.Color;
import java.awt.Dimension;
import java.lang.reflect.Field;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import UniaryCalculator.Listener;

public class BinaryGUI extends JFrame {
	
	BinaryListener l;
	
	JPanel panel;
	JLabel outputlabel;
	JLabel inputlabel;
	JLabel input2label;
	JTextField inputbox;
	JTextField inputbox2;
	JButton add;
	JButton subtract;
	JButton multiply;
	JButton divide;
	
	public BinaryGUI()
	{
		this.setSize(500,500);
		panel = new JPanel();
		panel.setSize(300,300);
	
		panel.setPreferredSize(new Dimension(200,300));
		
		panel.setBackground(Color.CYAN);
		
		inputlabel = new JLabel("     Input 1: ");
		panel.add(inputlabel);
		inputbox = new JTextField(10);
		panel.add(inputbox);
		
		input2label = new JLabel("     Input 2: ");
		panel.add(input2label);
		inputbox2 = new JTextField(10);
		panel.add(inputbox2);

		add = new JButton("+");
		panel.add(add);
		
		subtract = new JButton("-");
		panel.add(subtract);
		
		multiply = new JButton("*");
		panel.add(multiply);
		
		divide = new JButton("/");
		panel.add(divide);
		
		outputlabel = new JLabel();
		panel.add(outputlabel);
	
		
		this.getContentPane().add(panel);
		
		this.pack();
		this.setVisible(true);
			
		
	}
	
	
	
	public void setlistener(BinaryListener mylistener) {
		
		
		l = mylistener;
		
		add.addActionListener(l);
		subtract.addActionListener(l);
		multiply.addActionListener(l);
		divide.addActionListener(l);
		
	}
	
	public void setoutput(String s)
	{
		outputlabel.setText(s);
	}


	
	
}
