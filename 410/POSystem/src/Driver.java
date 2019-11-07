

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GUI frame = new GUI();
		Controller listener = new Controller();
		
		frame.setListener(listener);
		listener.setPanel(frame);
		
		frame.pack();
		frame.setVisible(true);
	}
}
