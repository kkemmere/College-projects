package radar;

public class Node {

	private point data;
	
	private Node next;
	
	public Node(point p)
	{
		data = p;
	}
	
	public void setNext(Node n)
	{
		next = n;
	}
	
	public void setpoint(point p)
	{
		data = p;
	}
	
	public String toString()
	{
		return "The point is " + data.toString();
	}
	// getters and setters

	public point getPoint()
	{
		return data;
	}
	
	public String getPoints() {
		String back = data.getX() + " " + data.getY();
		return back;
	}
	public Node getNext() {

		return next;
	}
}
