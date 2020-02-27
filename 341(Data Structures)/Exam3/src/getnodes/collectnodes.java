package getnodes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class collectnodes {
	
	public static void main(String[] arg) throws FileNotFoundException
	{
		Scanner inp = new Scanner(new File("edges.dat"));

		node[] nodes = new node[20];
		int count = 0;
		int temp = 0;
		
		while (inp.hasNext())
		{
			String s = inp.next();
			
			String d = inp.next();
			
			int v = inp.nextInt();
			
			boolean f = false;
			
			int i = 0;
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
				nodes[count].connect = 1;
				nodes[count].totw = v;
				nodes[count].average = 0;
				count++;
			}
			else
			{
				nodes[i].connect++;
				nodes[i].totw += v;
				nodes[i].average = (nodes[i].totw / nodes[i].connect);
				
				
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
				nodes[count].connect = 1;
				nodes[count].totw = v;
				nodes[count].average = 0;
				count++;
			}
			else
			{
				nodes[i].connect++;
				nodes[i].totw += v;
				nodes[i].average = (nodes[i].totw / nodes[i].connect);
			}
			
			
		}
		

		for (int j = 0; j < count; j++)
		{
			System.out.println(nodes[j].name + " " + nodes[j].connect + " " + nodes[j].totw + " " + nodes[j].average);
		}
		
		temp = 0;
		String tempnode = "";
		for (int j = 0; j < count; j++)
		{
			if (nodes[j].connect > temp)
			{
				temp = nodes[j].connect;
				tempnode = nodes[j].name;
			}
			
		}
		
		System.out.println("The node with the most number of connections is " + tempnode + " which has " + temp + " connections ");
		
		int avgtemp = 0;
		int totaltemp = 0;
		int tempedges = 0;
		
		for (int j = 0; j < count; j++)
		{
			if (nodes[j].average > avgtemp)
			{
				avgtemp = nodes[j].average;
				tempnode = nodes[j].name;
				tempedges = nodes[j].connect;
				totaltemp = nodes[j].totw;
			}
				
		}
		
		System.out.println("The node with the highest average weight is " + tempnode + " with average weight of " + avgtemp + " this node also has a total weight of " + totaltemp + " and has " + tempedges + " edges");
		
		temp = 1000000;
		tempnode = "";
		
		for (int i = 0; i < count; i++)
		{
			if (nodes[i].connect < temp)
			{
				temp = nodes[i].connect;
				tempnode = nodes[i].name;
			}
		}
	
		String tempnodes = "";
		for (int i = 0; i < count; i++)
		{
			if (nodes[i].connect == temp)
			{
				tempnodes = nodes[i].name;
			}

		}
		
		tempnodes = "";
		
		for (int i = 0; i < count; i++)
		{
			for (int j = 0; j < count; j++)
			{
				tempnodes = nodes[i].name;
			}
			
		}
		
		System.out.println("The node with the least number of connections is " + tempnode + " which has " + temp + " connections to " + tempnodes);
	}
	

}


