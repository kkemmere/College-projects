package radar;

public class point {
	
	private int x, y;
	
	public point(int a, int b)
	{
		x = a;
		y = b;
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public void setx(int i )
	{
		x = i;
	}
	
	public void sety(int i)
	{
		y = i;
	}
	
	public String toString()
	{
		return "(" + x + ", " + y + ")";
	}
	// getters and setters


}
