package Lab3B;

import java.util.StringTokenizer;

public class Rental {

	String rentalrecord;
	
	public Rental( String record)
	{
		rentalrecord = record;
	}

	public boolean match(String custno) {
	
		StringTokenizer stk = new StringTokenizer(rentalrecord);
		
		if (custno.equals(stk.nextToken()))
			return true;
		
		
		return false;
	}

	public String getRecord() {
		
		return rentalrecord;
	}

	

}
