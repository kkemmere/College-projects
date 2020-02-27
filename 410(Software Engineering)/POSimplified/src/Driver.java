
import java.io.FileNotFoundException;

public class Driver {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		GUI frame = new GUI();
		Controller listener = new Controller();
		
		frame.setListener(listener);
		listener.setPanel(frame);
		
		frame.pack();
		frame.setVisible(true);
	}
}
