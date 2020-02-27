
import java.io.FileNotFoundException;

/*
 * 
 * The setup for lab3B
 * 
 */
public class App {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		Store_GUI g = new Store_GUI ();
		Listener l = new Listener();
		
		g.setListener(l); // gui needs to know about listener 
		l.setGui(g); // listener needs to know about gui

	}

}