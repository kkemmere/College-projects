import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RentalManager {
	
	Customer[] mycustomers = new Customer[50];
	VideoTitle[] Vtitles = new VideoTitle[50];
	Rentals[] rentals = new Rentals[50];

	int numberofcustomers = 0;
	int numberofvideoTitle = 0;
	int numberofrentals = 0;

	Store_GUI  gui;

	private String lookup_Customer_name(String cID) {
		for (Customer C : mycustomers) {
			if (C.c_id.equals(cID)) {
				return C.c_name;
			}
		}
		return null;
	}

	private String lookUpVideoByNumber(String vID) {
		for (VideoTitle v : Vtitles) {
			if (vID ==null)
				return "Invalid Id";
				else if (v.v_id.equals(vID)) {
				return v.v_name;
			}
		}
		return null;
	}

	public String getVideoInfo(String vID) { //returns name of video, rented or not, and who has rented it, how many times the video has been rented
		String outputString = "";
		String vName = lookUpVideoByNumber(vID);
		if (vName == null)
			return "No video found";
		else {
			outputString += "Name: " + vName + "\n";
			for (Rentals r : rentals) {
				for (String v_id : r.total_rental(vName)) {
					if (v_id.equals(vID)) {
						String cName = lookup_Customer_name(r.customer_rental_number);
						return outputString + "Video is rented out to " + cName;
					}
				}
			}
		}
		return outputString + "not rented";
	}

	private boolean isNotRented(String vID) {
		String vName = lookUpVideoByNumber(vID);
		if (vName == null)
			return false;
		else {
			for (Rentals r : rentals) {
				if (r != null) {
					for (String v_id : r.total_rental(vID)) {
						if (v_id.equals(vID)) {
							return false;
						}
					}
				}
			}
		}
		return true;
	}

	public String listRentableVideos() {
		String output = "";
		for (VideoTitle v : Vtitles) {
			if (v != null) {
				if (isNotRented(v.v_id)) {
				
					output+= v.v_name + "\n";
				}
			}
		}
	return output;
	}
	public RentalManager() throws FileNotFoundException // videoStore Listener
	{
		// open using  a scanner c_file.dat and read and create customer object in an array
		Scanner cfile = new Scanner( new File("customer_name"));
		int count = 0;
		while(cfile.hasNext()){
			mycustomers[count] = new Customer(cfile.next(),cfile.next()); //customer name and customer_number
			count++;
		}
		numberofcustomers = count;

		// open using  a scanner v_file.dat and read and create video object in an array
		Scanner vfile = new Scanner( new File("videos.dat"));
		count = 0;
		while(vfile.hasNext()){
			Vtitles[count] = new VideoTitle(vfile.next(),vfile.next()); //video_number,video_title
			count++;
		}
		numberofvideoTitle = count;	

		// read the rentals file 
		Scanner rfile = new Scanner( new File("rentals.dat"));
		count = 0;
		while(rfile.hasNextLine()){
			rentals[count] = new Rentals(rfile.nextLine()); //each line has customer number followed by list of videos
			count++;
		}
		numberofrentals = count;	
	}

}
