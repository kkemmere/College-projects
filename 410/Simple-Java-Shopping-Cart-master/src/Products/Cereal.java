package Products;

import java.util.StringTokenizer;

public class Cereal extends Food {
	String brand;
	
	public Cereal(String s) {
		StringTokenizer stk = new StringTokenizer(s);
		
		stk.nextToken(); // C classification
		
		this.Item_name = stk.nextToken();
		this.Item_code = stk.nextToken();
		this.price = Double.parseDouble(stk.nextToken());
		this.Expiration_Date = stk.nextToken();
		this.brand = stk.nextToken();
		this.inventory = Integer.parseInt(stk.nextToken());
		
	}
	
	public String toString() {
		return super.toString() + ", Brand: " + brand;
	}
}
