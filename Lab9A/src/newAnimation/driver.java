package newAnimation;

import animationpackage.gui;
import animationpackage.listener;

public class driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	/*	gui g = new gui();
		listener l = new listener();
		g.setlistener(l);
		l.setgui(g);
*/

		newGui g = new newGui();
		newListener l = new newListener();
		g.setlistener(l);
		l.setdpanel(g.dpanel);
		
	}

}
