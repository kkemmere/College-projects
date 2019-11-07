package Products;

import java.util.StringTokenizer;

public class Speakers extends Electronics {
	int impedance;
	
	public Speakers(String s) {
		StringTokenizer stk = new StringTokenizer(s);
		
		stk.nextToken(); // L classification
		
		this.Item_name = stk.nextToken();
		this.Item_code = stk.nextToken();
		this.price = Double.parseDouble(stk.nextToken());
		this.type = stk.nextToken();
		this.impedance = Integer.parseInt(stk.nextToken());
		this.inventory = Integer.parseInt(stk.nextToken());
		
	}
	
	public String toString() {
		return super.toString() + ", Impedance: " + impedance;
	}
	
}
