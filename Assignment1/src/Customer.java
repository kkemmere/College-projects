import java.util.StringTokenizer;

public class Customer {
	
	// data members
	String c_id, c_name;
	
	public Customer(String id, String name)
	{
		c_id = id;
		c_name = name;
	}
	public boolean match(String custno) {
		// TODO Auto-generated method stub
		if(custno.equals(c_id)){
			return true;
		}

		return false;
	}

}
