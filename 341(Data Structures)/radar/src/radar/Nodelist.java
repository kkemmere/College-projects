package radar;

public class Nodelist {
	
	private Node start, end;
	
	public Nodelist()
	{
		start = null;
		end = null;
	}
	
	// getters and setters
	
	public Node getNode()
	{
		Node temp = start;
		
		while (temp != null)
		{
			temp = temp.getNext();
		}
		
		return temp;
	}
	
	public String getPoints()
	{
		String back = "";
		
		Node temp = start;
		
		while (temp!= null)
		{
			back = back + temp.getPoints() + "\n";
			
			temp = temp.getNext();
		}
		
		return back;
	}
	
	public void setstart(Node n)
	{
		start = n;
	}
	
	public void setend(Node n) {
		end = n;
	}
	
	public Node getstart()
	{
		return start;
	}
	
	public Node getend()
	{
		return end;
	}
	
	public void insert(Node n)
	{
		if (start == null && end == null) // When the list is empty
		{
			start = n;
			end = n;
			
			n.setNext(null);
		}
		else
		{
			Node temp = end;
			start = n;
			end.setNext(temp);
			
		}
		
	}
	
	
	public String toString()
	{
		String result = "The points in the list are : \n";
		
		Node temp = start;
		
		while (temp != null)
		{
			result = result + temp.toString() + "\n";
			
			temp = temp.getNext();
			
		}
		
		return result;
	}
	

}
