
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Rentals {
	
	
	String rentalrecords,renter_name;
	String rented_title;
	String video_rental_number;
	ArrayList<String> rented_video_list = new ArrayList<String>();
	public String customer_rental_number;
	
	public Rentals(String records) 
	{
		rentalrecords = records;
		 StringTokenizer stk = new StringTokenizer(rentalrecords); //Just to get the number of customer and video...Maybe we could do it above..
			String customer_rental_number = stk.nextToken();
	}

	public boolean match(String custno) {
		// TODO Auto-generated method stub
		
		StringTokenizer stk = new StringTokenizer(rentalrecords);
		
		if(custno.equals(stk.nextToken())){
			
			return true;
		}

		return false;
	}

	public ArrayList<String> total_rental(String custno) {
		// TODO Auto-generated method stub
		
		StringTokenizer stk = new StringTokenizer(rentalrecords);
		String customer_rental_number = stk.nextToken();
		String video_rental_number ;
		if(custno.equals(customer_rental_number)){
			
			while (stk.hasMoreTokens()) {
				
				rented_video_list.add(stk.nextToken()); //Here it should store the title of video as a list/array?
			}
			
		}
		return rented_video_list; //return an array list object
	}

	public int count_rented( String v_id) { //a method that track how many times a video with id v_id is in Rented list
		// TODO Auto-generated method stub
		int count = 0;
		for(int i=0;i<rented_video_list.size();i++) { //size method of array_list to loop over all the possible video
			video_rental_number = rented_video_list.get(i); //getting and setting each index video rental_number to compare later on
		if (v_id.equals(video_rental_number)){
			count++;
		}
		
	}
		return count;
}

	public String get_rental_number() {
		// TODO Auto-generated method stub
		
		return video_rental_number;
	}

	public String getrecord() {
		// TODO Auto-generated method stub
		return rentalrecords;
	}}