import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class Graphics extends JFrame{

	Graphics() {
		final JButton startProgram = new JButton("Start the program");	
		final JButton addPerson = new JButton("Add Person");
		addPerson.setVisible(false);
		final JButton showPersons = new JButton("Show All Persons");
		showPersons.setVisible(false);
		final JButton stockCrach = new JButton("Stock Market Crach");
		stockCrach.setVisible(false);
		final JButton changeStockPrice = new JButton("Change price of stock");
		changeStockPrice.setVisible(false);
		final JButton addItem = new JButton("Add Item To Person");
		addItem.setVisible(false);
		final JButton removeItem = new JButton("Remove Item");
		removeItem.setVisible(false);	
		final JButton showRichesPerson = new JButton("Show The Riches Person");
		showRichesPerson.setVisible(false);
		final JButton saveExit = new JButton("Save and Exit");
		saveExit.setVisible(false);
		final JButton emptyExit = new JButton("Empty registry and exit");
		emptyExit.setVisible(false);	
		final JFrame frame = new JFrame("Persons and Items");
		frame.getContentPane().setLayout(new FlowLayout());

		String[] personTableColumns = {"ID", " Name"," Total Value"};
		final DefaultTableModel personModel = new DefaultTableModel(personTableColumns, 0);
		final JTable personTable = new JTable(personModel) {
			public boolean isCellEditable(int rowIndex, int colIndex) {
				showPersons.doClick();
				return false;
			}
		};	
		personTable.setPreferredScrollableViewportSize(new Dimension(400, 200));
        personTable.setFillsViewportHeight(true); 
		final JScrollPane personPane = new JScrollPane(personTable);	
		personPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		personPane.setVisible(false);
		personTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		String[] itemTableColumns = {"Item ID", "Item Name","Item Type", "Calculated Value"};
		final DefaultTableModel itemModel = new DefaultTableModel(itemTableColumns, 0);
		final JTable itemTable = new JTable(itemModel) {
			public boolean isCellEditable(int rowIndex, int colIndex) {
				return false;
			}
		};	
		
		itemTable.setPreferredScrollableViewportSize(new Dimension(400, 200));
        itemTable.setFillsViewportHeight(true); 
		final JScrollPane itemPane = new JScrollPane(itemTable);	
		itemPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		itemPane.setVisible(false);
		itemTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		frame.add(startProgram);
		
		frame.add(addPerson);
		frame.add(showRichesPerson);
		frame.add(stockCrach);
		frame.add(personPane);
		
		frame.add(removeItem);
		frame.add(addItem);
		frame.add(changeStockPrice);	
		frame.add(itemPane);
		
		frame.add(saveExit);
		frame.add(emptyExit);
		
		frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		frame.setPreferredSize(new Dimension(500, 600));
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		startProgram.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stockCrach.setVisible(true);
				addPerson.setVisible(true);
				showRichesPerson.setVisible(true);
				saveExit.setVisible(true);
				emptyExit.setVisible(true);
				startProgram.setVisible(false);
				showPersons.doClick();
	      }
	    });
		
		addPerson.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addPerson();
				showPersons.doClick();
				int rows = personTable.getRowCount();
				personTable.setRowSelectionInterval(rows - 1, rows - 1);

	      }
	    });
		
		stockCrach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				for(int x=0; x < Inlupp2.itemList.size(); x++) {
					if(Inlupp2.itemList.get(x) instanceof Share) {
						((Share) Inlupp2.itemList.get(x)).changePrice(0.0);
					}
				}
				message("Stock market CRACH! The value of all shares has been set to 0kr");
	      }
	    });
		
		showPersons.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				personModel.getDataVector().removeAllElements();
				for(int x=0; x < Inlupp2.personList.size(); x++) {
					Person p = Inlupp2.personList.get(x);
				     Object[] row = new Object[3];
				     row[0] = p.getIdNr();
				     row[1] = p.getName();
				     row[2] = p.getItemsValue();
				     personModel.addRow(row);
				}
				itemPane.setVisible(true);
				personPane.setVisible(true);
				addItem.setVisible(true);
				removeItem.setVisible(true);
				frame.getContentPane().validate();
				frame.repaint();
	      }
	    });
		
		addItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	          	final int SelectedRow = personTable.getSelectedRow();
	          	try {
	          		addItem(((String) personTable.getValueAt(SelectedRow, 1)));
	          	}
	          	catch (ArrayIndexOutOfBoundsException selectError) {
	          		message("Please select a person from the table");
	          	}
				showPersons.doClick();
	      }
	    });
		
		removeItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	          	final int SelectedRow = itemTable.getSelectedRow();
	          	try {
	          		for (int x=0; x < Inlupp2.itemList.size(); x++) {
	          			if (Inlupp2.itemList.get(x).getIdNr() == Integer.parseInt((String) itemTable.getValueAt(SelectedRow, 0))) {
	          				Inlupp2.itemList.remove(x);
	          	
	          			}
	          		}
	          		itemModel.removeRow(SelectedRow);
	          	}
	          	catch (ArrayIndexOutOfBoundsException selectError) {
	          		message("Please select a item to remove");
	          	}		
	      }
	    });
		
		changeStockPrice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	          	try {
	          		final int SelectedRow = itemTable.getSelectedRow();
	          		int selectedId =  Integer.parseInt((String) itemTable.getValueAt(SelectedRow, 0));
	          		double newPrice = dialogDouble("Input new price of share");
	          		for(Item it : Inlupp2.itemList) {
		          		if (it.getIdNr() == selectedId) {
		          			((Share) it).changePrice(newPrice);
		          		}
		          	} 
	          	}
	          	catch (NullPointerException inputError) {
	          		message("Price (value) was not changed");
	          	}
	          	catch (ArrayIndexOutOfBoundsException selectError) {
	          		message("Please select a row representing a stock share in the items table");
	          	}
			}
		});
	
		showRichesPerson.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showPersons.doClick();
				itemModel.getDataVector().removeAllElements();
				String richesPerson = Person.findRichesPerson();
				int rows = personTable.getRowCount();
				int foundRow = 0;
				for(int x = 0; x < rows; x++) {
					String rowPerson = (String) personTable.getValueAt(x, 1);
					if (rowPerson.equalsIgnoreCase(richesPerson)) {
						foundRow = x;
					}
				}
				personTable.setRowSelectionInterval(foundRow, foundRow);

				String[][] personsItems = Person.personsItem(richesPerson);
				for (int x=0; x < personsItems.length; x++) {
					Object[] row = new Object[4];
					row[0] = personsItems[x][0];
					row[1] = personsItems[x][1];
					row[2] = personsItems[x][2];
					row[3] = personsItems[x][3];
					itemModel.addRow(row);
				}

				itemPane.setVisible(true);
				addItem.setVisible(true);
				frame.getContentPane().validate();
				frame.repaint();
			}
	    });
		
		saveExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {					
					FileOutputStream itemFile = new FileOutputStream("Items.obj");
					ObjectOutputStream itemOut = new ObjectOutputStream(itemFile);
					itemOut.writeObject(Inlupp2.itemList);
				}
				catch(IOException saveError) {
					message("Save was unsuccessfull... Exiting anyway");
				}
				System.exit(0);				
			}
	    });
		
		emptyExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File f = new File("Items.obj");
				boolean successDelete = f.delete();
				if (!successDelete)
					message("Failed to delete registry - exit aborted");
				else {
					message("Deleted the registry - exiting program");
					System.exit(0);
				}
			}
		});
		
		personTable.addMouseListener(new MouseAdapter() {
	      public void mouseClicked(final MouseEvent e) {
	        if (e.getClickCount() == 1)
	        {
	        	try {
		        	addItem.setVisible(true);
		        	final JTable target = (JTable)e.getSource();
		          	final int SelectedRow = target.getSelectedRow();
		          	itemModel.getDataVector().removeAllElements();
					String[][] personsItems = Person.personsItem((String) target.getValueAt(SelectedRow, 1));
					for (int x=0; x < personsItems.length; x++) {
						Object[] row = new Object[4];
						row[0] = personsItems[x][0];
						row[1] = personsItems[x][1];
						row[2] = personsItems[x][2];
						row[3] = personsItems[x][3];
						itemModel.addRow(row);
					}
					itemPane.setVisible(true);
					frame.getContentPane().validate();
					frame.repaint();
	        	}
	        	catch (ArrayIndexOutOfBoundsException personSelectionError) {
	        		// Do nothing really - the user most likely clicked empty space in the table
	        	}
	          }
	        }
	    });
		
		itemTable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(final MouseEvent e) {
				if (e.getClickCount() == 1) {
					try {
						final JTable target = (JTable)e.getSource();
			          	final int SelectedRow = target.getSelectedRow();
			          	if (target.getValueAt(SelectedRow, 2).equals("Share")) {
			          		changeStockPrice.setVisible(true);
			          	}
			          	else {
			          		changeStockPrice.setVisible(false);
			          	}
					}
		          	catch (ArrayIndexOutOfBoundsException personSelectionError) {
		        		// Do nothing really - the user most likely clicked empty space in the table
		        	}
				}
			}
	    });
	}
	
	static void message(String str) {
		JOptionPane.showMessageDialog(null, str);	
	}
	private static String dialogStr(String str) {
		String reStr = JOptionPane.showInputDialog(str);
		return reStr;
	}
	private static int dialogInt(String str) {
		while (true) {
			try {
				int reInt = Integer.parseInt(JOptionPane.showInputDialog(str));	
				return reInt;
			}
			catch (NumberFormatException e) {
				message("Wrong input data type - must be integer!");
			}
		}
	}
	private static double dialogDouble(String str) {
		while (true) {
			try {
				double reDouble = Double.parseDouble(JOptionPane.showInputDialog(str));
				return reDouble;
			}
			catch (NumberFormatException e) {
				message("Wrong input data type - must be double");
			}
		}
	}
	
	public static void addPerson() {
		boolean correct = false; 
		while (!correct) {
			try {
				String str = dialogStr("Input name of person");
				if (str.length() < 2) {
					message("Input a name - longer than two characters");
				}
				else {
					Inlupp2.personList.add(new Person(str));
					message("Person has been added!");
					correct = true;
				}
			}
			catch (NullPointerException e) {
				message("No person was added - method aborted");
				correct = true;
			}	
		}
	}
	
	public static void addItem(String person) {
		boolean correctItemType = false;
		boolean correctName = false;
		Object personObj = null;
		String itemName = null;
		String itemType = null;

			try {
				personObj = Person.findPerson(person);
				while (!correctName) {
					itemName = dialogStr("Input name for this item (if stock share, input company name)");
					if (itemName.length() >= 1) correctName = true;
					else message("Please input a name for this item - at least one character");
				}	
				while (!correctItemType) {
					itemType = dialogStr("Input type of item. Can be: Jewelery (j), Share (s) or Appliance (a)");
					if (
						itemType.equalsIgnoreCase("jewelery") ||
						itemType.equalsIgnoreCase("j") ||
						itemType.equalsIgnoreCase("share") ||
						itemType.equalsIgnoreCase("s") ||
						itemType.equalsIgnoreCase("appliance") ||
						itemType.equalsIgnoreCase("a")
					) {
						correctItemType = true;
					}
					else message("Wrong item type - try again");
				}				
				if (itemType.equalsIgnoreCase("jewelery") || itemType.equalsIgnoreCase("j")) {
					boolean correctMaterial = false;
					String material = null;
					int stones;
					while (!correctMaterial) {
						material = dialogStr("What material is it made of (gold or silver):");
						if (material.equalsIgnoreCase("gold") || material.equalsIgnoreCase("silver")) correctMaterial = true;
					}
					stones = dialogInt("Number of stones on it (integer):");
					
					Inlupp2.itemList.add(new Jewelery(personObj, itemName, material, stones));
					message("The jewelery item has been added!");
				}
				else if (itemType.equalsIgnoreCase("share") || itemType.equalsIgnoreCase("s")) {
					int number = dialogInt("Input a number of shares");
					double price = dialogDouble("Input a price per share");
					Inlupp2.itemList.add(new Share(personObj, itemName, number, price));
					message("The share has been added");
				}
				else if (itemType.equalsIgnoreCase("appliance") || itemType.equalsIgnoreCase("a")) {
					double purchasePrice = dialogDouble("Input the purchase price");
					int wear = dialogInt("Input the wear of this appliance (1-10). 10 is brand new, 1 is very old.");
					Inlupp2.itemList.add(new Appliance(personObj, itemName, purchasePrice, wear));
					message("The appliance has been added");
				}
			}
			catch (NullPointerException e) {
				message("No item was added.");
			}		
	}
}
