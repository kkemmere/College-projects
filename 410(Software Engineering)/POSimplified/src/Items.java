import java.util.StringTokenizer;

public class Items extends Item {
	
	String itemName;
	double price;
	
	public Items(String s) {
		StringTokenizer stk = new StringTokenizer(s);
		
		stk.nextToken(); // C classification
		
		this.itemName = stk.nextToken();
		this.price = Double.parseDouble(stk.nextToken());
		// this.Expiration_Date = stk.nextToken();
		// this.brand = stk.nextToken();
		// this.inventory = Integer.parseInt(stk.nextToken());
		
	}
	
	public String toString()
	{
		return super.toString();
	}

}
