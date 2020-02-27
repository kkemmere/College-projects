package BinaryCalculator;

import UniaryCalculator.Listener;
import UniaryCalculator.UnaryGUI;

/*
 * Kevin Kemmerer Lab 3 Part 2, Binary Calculator App
 * 
 * 
 */

public class BinaryCalculator {

	public static void main(String[] args) {
		
		BinaryGUI myguib = new BinaryGUI();
		
		BinaryListener mylistener = new BinaryListener();
		
		myguib.setlistener(mylistener);
		mylistener.getgui(myguib);

	}

}
