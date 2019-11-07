package MVC;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionListener;

public class GUI extends JFrame {
	Controller listener;
	
	DefaultListModel listModel = new DefaultListModel();
	
	JButton exitButton = new JButton("Exit");
	JButton exitShop = new JButton("Exit");
	
	JPanel shopTab = new JPanel(); // Main shop panel
	JLabel shopLabel = new JLabel("Welcome to the Steam Store!");
	JLabel confirmAdd = new JLabel("Please choose an item to add");
	JLabel itemInfo = new JLabel("");
	JLabel quantityLabel = new JLabel("Quantity: ");
	JList inventoryList;
	JButton addItem = new JButton("Add to cart");
	JTextField itemQuantity = new JTextField(5);
	JLabel itemIcon = new JLabel();
	
	BufferedImage image = null;
	Image simg;
	
	JRadioButton all = new JRadioButton("All"); // the filer buttons
	JRadioButton pharmacy = new JRadioButton("Pharmacy");
	JRadioButton tvs = new JRadioButton("TVS");
	JRadioButton shoes = new JRadioButton("Shoes");
	JRadioButton fruit = new JRadioButton("Fruit");
	JRadioButton cereal = new JRadioButton("Cereal"); // new classifications start here
	JRadioButton toys = new JRadioButton("Toys");
	JRadioButton speakers = new JRadioButton("Speakers");
	
	JPanel cartTab = new JPanel(); // Cart panel
	JLabel cartLabel = new JLabel("Your current shopping cart:");
	JLabel cartList = new JLabel("You currently have no item in your cart.");
	JButton buy = new JButton("BUY");
	
	public void setListener(Controller l) {
		listener = l;
		addItem.addActionListener(listener);
		buy.addActionListener(listener);
		exitButton.addActionListener(listener);
		exitShop.addActionListener(listener);
		inventoryList.getSelectionModel().addListSelectionListener((ListSelectionListener) listener);
		
		all.addActionListener(listener);
		pharmacy.addActionListener(listener);
		tvs.addActionListener(listener);
		shoes.addActionListener(listener);
		fruit.addActionListener(listener);
		cereal.addActionListener(listener); // new classifications start here
		toys.addActionListener(listener);
		speakers.addActionListener(listener);
	}
	
	public GUI() {
		super("༼ つ ◕_◕ ༽つ Steam Store ༼ つ ◕_◕ ༽つ");
		setPreferredSize(new Dimension(500, 370));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Working on the JList
		for (int i=0; i<InventoryManager.getSize(); i++) {
			listModel.addElement(InventoryManager.getName(i));
		}
		
		inventoryList = new JList(listModel);
		inventoryList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		inventoryList.setLayoutOrientation(JList.VERTICAL);
		inventoryList.setVisibleRowCount(10);
		
		// SHOPPING TAB
		shopTab.setLayout(new BorderLayout(40,10)); // Border layout for the shopping list
		shopLabel.setHorizontalAlignment(SwingConstants.CENTER); // Make the welcome text in the center
		JPanel subPanel = new JPanel();
		subPanel.setLayout(new GridLayout(4,1));
		subPanel.add(exitShop);
		
		JPanel filterPanel = new JPanel(); // RADIO BUTTON FILTERS
		filterPanel.setLayout(new GridLayout(1,2));
		ButtonGroup bg = new ButtonGroup();
		bg.add(pharmacy); bg.add(tvs); bg.add(shoes); bg.add(fruit); bg.add(all);
		bg.add(cereal); bg.add(toys); bg.add(speakers);
		JPanel radios = new JPanel();
		radios.setLayout(new GridLayout(8,1));
		radios.add(all); radios.add(pharmacy); radios.add(tvs); radios.add(speakers);
		radios.add(shoes); radios.add(fruit); radios.add(cereal); radios.add(toys);
		
		filterPanel.add(radios); filterPanel.add(inventoryList);
		
		JPanel infoPanel = new JPanel(); // item information when the user highlights an item
		infoPanel.setLayout(new GridLayout(2,1));
		itemIcon.setBounds(0, 0, 75, 75);
		
		infoPanel.add(itemInfo); infoPanel.add(itemIcon);
		
		// Finalizing all the panels in the shop tab
		shopTab.add(shopLabel, BorderLayout.PAGE_START);
		
		quantityLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		subPanel.add(quantityLabel); subPanel.add(itemQuantity); subPanel.add(addItem);
		shopTab.add(filterPanel, BorderLayout.LINE_START); shopTab.add(subPanel, BorderLayout.LINE_END); //last changes
		shopTab.add(infoPanel, BorderLayout.CENTER); // changes to info panel
		confirmAdd.setHorizontalAlignment(SwingConstants.CENTER);
		shopTab.add(confirmAdd, BorderLayout.PAGE_END);
		
		// CART TAB
		cartTab.setLayout(new BorderLayout(40, 10));
		cartLabel.setHorizontalAlignment(SwingConstants.CENTER);
		cartList.setHorizontalAlignment(SwingConstants.CENTER);
		cartList.setVerticalAlignment(SwingConstants.BOTTOM);
		JPanel buySection = new JPanel();
		buySection.setLayout(new GridLayout(4,1));
		buySection.add(exitButton);
		
		JLabel placeHolder = new JLabel("<html><br></html>"); buySection.add(placeHolder);
		buySection.add(buy);
		cartTab.add(cartLabel, BorderLayout.PAGE_START);
		cartTab.add(cartList, BorderLayout.CENTER);
		cartTab.add(buySection, BorderLayout.LINE_END);
		
		// Create the tabs and add them
		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.addTab("Shop", null, shopTab);
		tabbedPane.addTab("Cart", null, cartTab);
		
		add(tabbedPane);
	}
	
	public int getQuantity() {
		return Integer.parseInt(itemQuantity.getText());
	}
	
	public void clearText() {
		itemQuantity.setText("");
	}
	
	public void filterItems(String type) {
		listModel.clear();
		if (type.equals("All")) {
			for (int i=0; i<InventoryManager.getSize(); i++) 
				listModel.addElement(InventoryManager.getName(i));
		}
		else {
			for (int i=0; i<InventoryManager.getSize(); i++) {
				if (type.equals(InventoryManager.getType(i)))
					listModel.addElement(InventoryManager.getName(i));
			}
		}
	}
	
	public void setImage(String fileName) throws IOException {
		image = ImageIO.read(new File(fileName));
		simg = image.getScaledInstance(itemIcon.getWidth(), itemIcon.getHeight(), Image.SCALE_SMOOTH);
		itemIcon.setIcon(new ImageIcon(simg));
	}
	
	public String currentSelectionName(int pos) {
		Object o = listModel.get(pos);
		//System.out.println(o.toString());
		return o.toString();
	}
	
}
