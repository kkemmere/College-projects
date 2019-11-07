

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.io.FileNotFoundException;
import java.io.IOException;

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
		
			if (choice.equals("BUY")) {
				int checkout = JOptionPane.showOptionDialog(null, "Thank you for shopping with us, your total cost is $" 
						+ Item.getPrice() + ". Please make arrangements for payment.", "Checkout", 
						JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
						new String[] {"COMPLETE","Cancel"}, "default");
				if (checkout==0) { // payment confirmed
					JOptionPane.showMessageDialog(null, "These items will be delivered to you. Thanks again, have a nice day!",
							"Payment Confirmed", 1);
					JOptionPane.showMessageDialog(null, "Low inventory exported to \"OrderList.txt\"", "Attention", 1);
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
	}
}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
