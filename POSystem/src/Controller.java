

import java.awt.event.ActionEvent;
import java.util.Scanner;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class Controller implements ActionListener, ListSelectionListener {

	GUI panel;
	int currentIndex;
	
	
	public void setPanel(GUI p) {
		panel = p;
	}

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getSource() instanceof JButton) {
			JButton clicked = (JButton) arg0.getSource();
			String choice = clicked.getText();
			String cartItems = "<html>";
			
			if (choice.equals("Add to cart")) { // In order: add qty of items to cart, clear text field, output to console
				int qty = panel.getQuantity();
				qty = Integer.parseInt(JOptionPane.showInputDialog("Confirm quantity: ", qty+""));
				Boolean isAdded = Manager.addItem(currentIndex, qty);
				if (isAdded) {
					panel.confirmAdd.setText(Manager.getName(currentIndex) + " added to cart");
				} else panel.confirmAdd.setText("Not enough inventory in storage!");
				panel.clearText();
				for (int i=0; i<Manager.getSize(); i++) {
					if (Manager.getCartInventory(i)>0) {
						cartItems += Manager.getName(i) + ", quantity: " + Manager.getCartInventory(i) + "<br>";
					}
				}
				cartItems += "<br>==============<br>"
						+ "TOTAL: $" + Manager.getCartCost()
						+ "</html>";
				panel.cartList.setText(cartItems); // Output current cart to cart tab
			}
			
			else if (choice.equals("BUY")) {
				int checkout = JOptionPane.showOptionDialog(null, "Thank you for shopping with us, your total cost is $" 
						+ Manager.getCartCost() + ". Please make arrangements for payment.", "Checkout", 
						JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
						new String[] {"COMPLETE","Cancel"}, "default");
				if (checkout==0) { // payment confirmed
					JOptionPane.showMessageDialog(null, "These items will be delivered to you. Thanks again, have a nice day!",
							"Payment Confirmed", 1);
					try {
						Manager.orderList();
						JOptionPane.showMessageDialog(null, "Low inventory exported to \"OrderList.txt\"", "Attention", 1);
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.exit(0);
				}
				else if (checkout==1) // payment declined
					JOptionPane.showMessageDialog(null, "You have canceled the transaction. Please try again",
							"Payment Declined", 0);
			}
			
			else if (choice.equals("Exit")) {
				System.exit(0);
			}
		}
	else if (arg0.getSource() instanceof JRadioButton) {
		JRadioButton clicked = (JRadioButton) arg0.getSource();
		String choice = clicked.getText();
		System.out.println("-filter- " + choice);
		panel.filterItems(choice);
	}
}

	public void valueChanged(ListSelectionEvent e) {
		ListSelectionModel lsm = (ListSelectionModel) e.getSource();
		
		if (lsm.isSelectionEmpty()) {
			// nothing here for now, reserved for console
		}
		else {
			int minIndex = lsm.getMinSelectionIndex();
			int maxIndex = lsm.getMaxSelectionIndex();
			for (int i=minIndex; i<= maxIndex; i++) {
				if (lsm.isSelectedIndex(i)) {
					for (int j=0; j<Manager.getSize(); j++) {
						if (panel.currentSelectionName(i).equals(Manager.getName(j))) {
							currentIndex = j;
							break;
						}
					}
					panel.itemInfo.setText("<html>Name: " + Manager.getName(currentIndex) +
							"<br>Price: " + Manager.getPrice(currentIndex) +
							"<br>Inventory: " + Manager.getInventory(currentIndex) + "</html>");
					
					/*
					try {
						panel.setImage(itm.getName(currentIndex) + ".jpg");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					*/
				}
			}
		}
	}

}
