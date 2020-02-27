package Lab3B;

import java.io.FileNotFoundException;

import Lab3B.StoreGUI;
import Lab3B.StoreListener;

public class StoreApp {

	public static void main(String[] args) throws FileNotFoundException {
		
		StoreGUI mygui = new StoreGUI();
		
		StoreListener mylistener = new StoreListener();
		
		mygui.setlistener(mylistener);
		mylistener.getgui(mygui);

	}

}
