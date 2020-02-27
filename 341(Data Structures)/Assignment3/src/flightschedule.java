import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


/*
 * Flightschedule class, Kevin Kemmerer, Iyengar 341
 * 
 * This class is designed to find a flight path from the designated start
 * and destination cities.
 */

public class flightschedule extends JFrame {
	
	public flightschedule() {

        getContentPane().setBackground(new Color(238, 232, 170));
        getContentPane().setLayout(null);
        setTitle("Your Desination Awaits");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setSize(450, 300);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width / 2 - this.getWidth() / 2, dim.height / 2 - this.getHeight() / 2);
	}
	public JPanel panel()
	{
		JPanel panel = new JPanel();
        panel.setBounds(0, 0, 444, 271);
        panel.setBackground(new Color(176, 224, 230));
        getContentPane().add(panel);
        panel.setLayout(null);
        
        JLabel lblIcon = new JLabel("");
        lblIcon.setBounds(30, 30, 200, 200);
        lblIcon.setIcon(new ImageIcon("Assignment3/src/planes.png"));
        panel.add(lblIcon);
        
        JLabel lblText2 = new JLabel("You have arrived!");
        lblText2.setVerticalAlignment(SwingConstants.TOP);
        lblText2.setFont(new Font("Tahoma", Font.ITALIC, 14));
        lblText2.setHorizontalAlignment(SwingConstants.CENTER);
        lblText2.setBounds(240, 130, 175, 100);
        panel.add(lblText2);

        JLabel lblText1 = new JLabel("Enjoy your fleights");
        lblText1.setHorizontalAlignment(SwingConstants.CENTER);
        lblText1.setFont(new Font("Tahoma", Font.ITALIC, 14));
        lblText1.setBounds(240, 30, 175, 100);
        panel.add(lblText1);
        
        return panel;
	}

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner inp = new Scanner(new File("Rights.dat"));

		node[] nodes = new node[20];
		int count = 0;
		int temp = 0;
		int i = 0;
		
		Map<int[][], String> map = new HashMap<int[][], String>();
		int[][] matrix = new int[0][0];
		
		while (inp.hasNext())
		{
			String s = inp.next();
			
			String d = inp.next();
			
			boolean f = false;
			
			i = 0;
			while (i < count)
			{
				if ((nodes[i].name).equals(s))
				{
					f = true;
					break;
				}
				else
					i++;
			}
			
			if (!f)
			{
				nodes[count] = new node();
				nodes[count].name = s;
				count++;
			}
			else
			{
				nodes[i].connections++;
			}
		
			
			f = false;
		    i = 0;
			while (i < count)
			{
				if ((nodes[i].name).equals(d))
				{
					f = true;
					break;
				}
				else
					i++;
			}
			
			if (!f)
			{
				nodes[count] = new node();
				nodes[count].name = d;
				count++;
			}
			else
			{
				nodes[i].connections++;
			}
			
			
		}
		

		for (int j = 0; j < count; j++)
		{
			System.out.println(nodes[j].name + " " + nodes[j].connections);
		}

		temp = 0;
		String tempnode = "";
		for (int j = 0; j < count; j++)
		{
			if (nodes[j].connections > temp)
			{
				temp = nodes[j].connections;
				tempnode = nodes[j].name;
			}
			
		}
	
		
			System.out.println("The node with the most number of connections is " + tempnode + " which has " + temp + " connections ");
				
				Scanner airportsinp = new Scanner(new File("Airports.dat"));

				
				count = 0;
				temp = 0;
				
				String airportname = "";
				int connectingtime, runwaytime, xcoor, ycoor;
				int row = 0;
				int col = 0;
				
				while (airportsinp.hasNext())
				{
					airportname = airportsinp.next();
					
					connectingtime = airportsinp.nextInt();
					
					runwaytime = airportsinp.nextInt();
					
					xcoor = airportsinp.nextInt();
					
					ycoor = airportsinp.nextInt();
					count++;
					
					
					 col = count;
					 row = count;
					 
					matrix = new int[row][col];
					
					for (row = 0; row < matrix.length; row++)
					{
			            for (col = 0; col < matrix[row].length; col++)
			            {
			            	matrix[row][col] = 0;
			            }
					}
				
				}
					
					// print matrix
					for (int j = 0; j < 1; j++)
					{
						for (int l = 0; l < matrix.length; l++) {
				            System.out.println(l + " = " + Arrays.toString(matrix[l]));
				        }
			
					}
					
				// load matrix with rights *(doesn't work right)*
				i = 0;
				for (row = 0; row < matrix.length; row++)
					{
						for (col = 0; col < matrix[row].length; col++)
						{
							if (nodes[i].name == map.get(matrix))
							{
								matrix[row][col] = 1;
							}
								
						}
					}
				
				System.out.println();
				
				// print matrix
				for (int j = 0; j < 1; j++)
				{
					for (int l = 0; l < matrix.length; l++) {
			            System.out.println(l + " = " + Arrays.toString(matrix[l]));
			        }
		
				}
				
				// assigning node names to values in matrix using hashmap *(doesn't work right)*
		/*		for (int j = 0; j < count; j++)
					{
						map.put(matrix, nodes[j].name + " ");
					}
			*/	
				System.out.println();
				System.out.println(count);
				
				for (int j = 0; j < 1; j++)
				{
					for (int l = 0; l < matrix.length; l++) {
			            System.out.println(l + " = " + map.get(matrix));
			        }
		
				}
				
				flightschedule cdframe = new flightschedule();
		        ImageIcon icon = new ImageIcon("Assignment3/src/mountains.png");
		        String[] options = new String[count];
		        
		        
		        for (int j = 0; j < count; j++)
		        {
		        	options[j] = nodes[i].name;
		        }
		        
		        int x = JOptionPane.showOptionDialog(cdframe, "Please pick your starting destination",
		                "The start", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options);

		        if (x == 3) {
		            cdframe.getContentPane().add(cdframe.panel());
		            cdframe.repaint();
		            cdframe.revalidate();
		        } else {
		            cdframe.dispose();
		            JOptionPane.showMessageDialog(null, "Sorry there is no connection to that airport");
		        }
		
			}
}
