

/* Node class, Kevin Kemmerer, Iyengar 341
*	 
* Sets data and parameters for a simple node
* to be used with the gtree class
*/
	
public class Node {
	
	// Data
	public String data;
	public Node left, middle, right;
	
	// Node constructor setting original values 
	public Node(String val)
	{
		this.data = val;
		right = null;
		left = null;
		middle = null;
	}
	


}
