package Products;

import java.util.StringTokenizer;

public class Toys extends Item {
	String origin;
	
	public Toys(String s) {
		StringTokenizer stk = new StringTokenizer(s);
		
		stk.nextToken(); // R classification
		
		this.Item_name = stk.nextToken();
		this.Item_code = stk.nextToken();
		this.price = Double.parseDouble(stk.nextToken());
		this.origin = stk.nextToken();
		this.inventory = Integer.parseInt(stk.nextToken());
		
	}
	
	public String toString() {
		return super.toString() + ", Origin: " + origin;
	}
}
