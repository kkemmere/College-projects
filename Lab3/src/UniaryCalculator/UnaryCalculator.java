package UniaryCalculator;

/*
 * 	Kevin Kemmerer, Lab 3 unary calculator using GUI
 * 
 * 
 */

public class UnaryCalculator {

	public static void main(String[] args) {
	
		UnaryGUI mygui = new UnaryGUI();
		
		Listener mylistener = new Listener();
		
		mygui.setlistener(mylistener);
		mylistener.setgui(mygui);

	}

}
