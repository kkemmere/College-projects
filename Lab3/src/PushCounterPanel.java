//********************************************************************
//  PushCounterPanel.java       Authors: Lewis/Loftus
//
//  Demonstrates a graphical user interface and an event listener.
//********************************************************************

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PushCounterPanel extends JPanel
{
   private int count;
 //  private JButton push;
   private JLabel label;

   private JButton up, down;
   
   //-----------------------------------------------------------------
   //  Constructor: Sets up the GUI.
   //-----------------------------------------------------------------
   public PushCounterPanel()
   {
      count = 0;

  //    push = new JButton("Push Me!");
  //    push.addActionListener(new ButtonListener());
      
      up = new JButton("Count UP");
      down = new JButton("Count DOWN");
      
      up.addActionListener(new ButtonListener());
      down.addActionListener(new ButtonListener());

      label = new JLabel("Pushes: " + count);

    //  add(push);
      add(up);
      add(down);
      add(label);

      setPreferredSize(new Dimension(300, 40));
      setBackground(Color.cyan);
   }

   //*****************************************************************
   //  Represents a listener for button push (action) events.
   //*****************************************************************
   private class ButtonListener implements ActionListener
   {
      //--------------------------------------------------------------
      //  Updates the counter and label when the button is pushed.
      //--------------------------------------------------------------
      public void actionPerformed(ActionEvent event)
      {
      //   count++;
      //   label.setText("Pushes: " + count);
         
         JButton clicked = (JButton) event.getSource();
         System.out.println(clicked.getText());
         
         if (clicked.getText().equals("Count UP"))
         {
        	 count++;
         }
         else if (clicked.getText().equals("Count DOWN"))
         {
        	 count--;
         }
         
         label.setText("Pushes: " + count);
        	 
      }
   }
}
