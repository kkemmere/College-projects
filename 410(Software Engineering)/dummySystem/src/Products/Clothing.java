
package Products;


public abstract class Clothing {

	String type; // footwear, dress, accessories or jewellery
	
    public Clothing(){};
	
	public String toString()
	{
		return super.toString() + ", Type: " + type;
	}
}
