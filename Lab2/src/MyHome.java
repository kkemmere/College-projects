import java.awt.*;
import java.applet.*;

public class MyHome extends Applet
{     
    public void paint(Graphics g)
    {         
	    Font f = new Font("Helvetica", Font.BOLD,20);
	    g.setFont(f);
	    g.drawString("My Home!", 50, 30);
	    g.drawLine(30, 100, 30, 220);
	    g.drawLine(30, 100, 150, 30);
	    g.drawLine(150, 30, 250, 100);
	    g.drawLine(250, 100, 250, 220);
	    g.drawLine(250, 220, 30, 220);
	  //  g.drawLine(, y1, x2, y2);
	  //  g.fillOval(90, 120, 50, 20);
	   // g.fillOval(190, 120, 50, 20);
	   // g.drawLine(165, 125, 165, 175);
	   // g.drawArc(110, 180, 95, 95, 0, 180);
    }
}