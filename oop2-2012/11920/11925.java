package prylregister;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.*;
import java.util.ArrayList;
import javax.swing.*;





public class PrylRegister extends JFrame implements  ActionListener,ItemListener {
     public void buildConstraints(GridBagConstraints gbc, int gx, int gy,
	        int gw, int gh, int wx, int wy) {

	        gbc.gridx = gx; //Positionering på x-axeln
	        gbc.gridy = gy; //Positionering på y-axeln
	        gbc.gridwidth = gw; //Antal kollumner som komponenten tar upp i sidled
	        gbc.gridheight = gh; //Antal kollumner som komponenten tar upp i höjdled
	        gbc.weightx = wx;   //Anger procent av den totala ytan av rutnätet som rutan tar upp på bredden
	        gbc.weighty = wy;   //Anger procent av den totala ytan av rutnätet som rutan tar upp på höjden
    }


         private JPanel panel1MenuAndButtons = new JPanel ();
         private JPanel panel2 = new JPanel();
         private JPanel printPersonPanel = new JPanel();
         private JPanel createPersonPanel = new JPanel();
         private JPanel jewelPanelFirstRow = new JPanel();
         private JPanel devicePanelFirstRow = new JPanel();
         private JPanel stockPanelFirstRow = new JPanel();
         private JPanel jewelPanelSecondRow = new JPanel();
         private JPanel devicePanelSecondRow = new JPanel();
         private JPanel stockPanelSecondRow = new JPanel();
         private JPanel jewelPanelThirdRow = new JPanel();
         private JPanel devicePanelThirdRow = new JPanel();
         private JPanel stockPanelThirdRow = new JPanel();
         private JPanel emptyPanelFirstRow = new JPanel();
         private JPanel emptyPanelSecondRow = new JPanel();
         private JPanel emptyPanelThirdRow = new JPanel();
         private JPanel addItemPanel = new JPanel();
         private JPanel addItemDevicePanel = new JPanel();
         private JPanel addItemJewelsPanel = new JPanel();
         private JPanel addItemStocksPanel = new JPanel();
         private JPanel addItemEmptyPanel = new JPanel();
         private JButton button1StockmarketCrash = new JButton ("Stockmarket crash") ;
         private JButton button2ShowCertainPerson = new JButton ("Show certian person") ;
         private JButton button3ShowRichestPerson = new JButton ("Show richest person") ;
         private JButton button4ShowEveryone = new JButton ("Show everyone") ;
         private JButton button5Save = new JButton ("Save") ;
         private JButton button7SaveItem = new JButton ("Save") ;
         private JButton button6OK = new JButton("Ok");
         private JLabel label1FullName = new JLabel ("Full name : ");
         private JLabel label2SelectItemFirstRow = new JLabel ("Select item :    ");
         private JLabel label3SelectItemSecondRow = new JLabel ("Select item :    ");
         private JLabel label4SelectItemThirdRow = new JLabel ("Select item :    ");
         private JLabel label6AddItemSelect = new JLabel ("Select item :    ");
         private JLabel label5SpecificPerson = new JLabel ("Full name : ");
         private JLabel label7AddItemToPerson = new JLabel ("Full name : ");
         private JMenuBar menuBar = new JMenuBar();
         private JMenu File = new JMenu("File");
         private JMenu Edit = new JMenu("Edit");
         private JMenu person = new JMenu("Person");
         private JMenu Help = new JMenu("Help");
         private JMenu editPerson = new JMenu("Edit Person");
         private JMenuItem newPerson = new JMenuItem("New Person");
         private JMenuItem addItem = new JMenuItem("Add Item");
         private JMenuItem Exit = new JMenuItem("Exit");
         private JMenuItem userManual = new JMenuItem("User Manual");
         private JMenuItem About = new JMenuItem("About");
         private String[] thing = {"Select Item","Device", "Jewlery", "Stock"};
         private String[] thing2 = {"Select Type","Bracelet","Brooch","Earring","Necklace","Piercing","Ring","Other"};
         private String[] thing3 = {"Select Material","Gold","Silver"};
         private String[] thing4 = {"Select Type","Electrical","Nonelectrical"};
         private String[] thing5Worn = {"Select Condition","1","2","3","4","5","6","7","8","9","10"};
         private JComboBox JCB1 = new JComboBox(thing);
         private JComboBox JCB2 = new JComboBox(thing);
         private JComboBox JCB3 = new JComboBox(thing);
         private JComboBox JCB4JewelType = new JComboBox(thing2);
         private JComboBox JCB5JewelMaterial = new JComboBox(thing3);
         private JComboBox JCB11JewelMaterial = new JComboBox(thing3); 
         private JComboBox JCB12JewelMaterial = new JComboBox(thing3);
         private JComboBox JCB6ElectricOrNot = new JComboBox(thing4);
         private JComboBox JCB7ElectricOrNot = new JComboBox(thing4);
         private JComboBox JCB8ElectricOrNot = new JComboBox(thing4);
         private JComboBox JCB9JewelType = new JComboBox(thing2);
         private JComboBox JCB10JewelType = new JComboBox(thing2);
         private JComboBox JCB13Worn = new JComboBox(thing5Worn);
         private JComboBox JCB14Worn = new JComboBox(thing5Worn);
         private JComboBox JCB15Worn = new JComboBox(thing5Worn);
         private JComboBox JCB16 = new JComboBox(thing);
         private JComboBox JCB18AddJewelMaterial = new JComboBox(thing3);
         private JComboBox JCB19JewelType = new JComboBox(thing2);
         private JComboBox JCB20ElectricOrNot = new JComboBox(thing4);
         private JComboBox JCB21Worn = new JComboBox(thing5Worn);
         private JTextField Name = new JTextField(40);
         private JTextField addItemName = new JTextField(40);
         private JTextField typeOfObjectJewels = new JTextField(10);
         private JTextField typeOfObjectDevice = new JTextField(10);
         private JTextField typeOfObjectStocks = new JTextField(10);
         private JTextField typeOfObject2Device = new JTextField(10);
         private JTextField typeOfObject2Jewels = new JTextField(10);
         private JTextField typeOfObject2Stocks = new JTextField(10);
         private JTextField typeOfObject3Device = new JTextField(10);
         private JTextField typeOfObject3Jewels = new JTextField(10);
         private JTextField typeOfObject3Stocks = new JTextField(10);
         private JTextField typeOfObject4Device = new JTextField(10);
         private JTextField typeOfObject4Jewels = new JTextField(10);
         private JTextField typeOfObject4Stocks = new JTextField(10);
         private JTextField numberOfJewels1 = new JTextField(5);
         private JTextField numberOfJewels2 = new JTextField(5);
         private JTextField numberOfJewels3 = new JTextField(5);
         private JTextField numberOfJewels4 = new JTextField(5);
         private JTextField priceOfDevice = new JTextField(10);
         private JTextField priceOfDevice2 = new JTextField(10);
         private JTextField priceOfDevice3 = new JTextField(10);
         private JTextField priceOfDevice4 = new JTextField(10);
         private JTextField valueOfStocks1 = new JTextField(10);
         private JTextField valueOfStocks2 = new JTextField(10);
         private JTextField valueOfStocks3 = new JTextField(10);
         private JTextField valueOfStocks4 = new JTextField(10);
         private JTextField amountOfStocks1 = new JTextField(10);
         private JTextField amountOfStocks2 = new JTextField(10);
         private JTextField amountOfStocks3 = new JTextField(10);
         private JTextField amountOfStocks4 = new JTextField(10);
         private JTextField specificPersonName = new JTextField(39);
         private JTextArea userManualScreen = new JTextArea("USER MANUAL\n\nHow to...\n\n...add a New person to the register."
                 +"\n\nGo to \"Edit>New Person\" in the menubar at the top of the screen and follow the instructions. "
                 +"When creating a person you must type a unique name, and you can give them between 0-3 items\nat the point of creation."
                 + " Even if you fail to add the desired items at the point of adding a new person, go to"
                 + " \"Edit>Edit Person> Add Item\" to add more items to any of the existing entrys in the register. \n\n"
                 + "...write the correct format for input\n\nWhen defining an item all decimals (as an example you might want to"
                 + " write 156,5 as the value of a certain stock) the correct way type type the number is \"156.5\".\nBasically you use a dot"
                 + " instead of a comma when writing decimals.\n\n",8,50);
         private JTextArea aboutScreen = new JTextArea("ABOUT THE PROGRAM\n\nThis is a program designed in 2013 to keep track of the "
                 + "contents and the value of personal objects.\n\n\nABOUT THE CREATORS OF THE PROGRAM\n\nThere are three creators to this program. "
                 + "If you have any questions or complaints please e-mail one of the creators below:\n\nKarolina Peters,\nkarolina_peters@hotmail.com\n\n"
                 + "Peter Johannesson,\naxpeter92@hotmail.com\n\nEric Englund,\nherka93@gmail.com",8,35);
         private JTextArea welcomeScreen = new JTextArea("Welcome to PrylRegistret",1,1);
         private JTextArea printSpecificPersonScreen = new JTextArea("The data on the specific person is as follows:\n\n",6,50);
         private JTextArea printRichestScreen = new JTextArea(8,50);
         private JTextArea printAllScreen = new JTextArea(8,50);
         private JScrollPane scroll = new JScrollPane(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
	 ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
         private JScrollPane createPersonScroll = new JScrollPane(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER,
	 ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
         private JScrollPane createPersonScroll2 = new JScrollPane(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER,
	 ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
         private JScrollPane createPersonScroll3 = new JScrollPane(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER,
	 ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
         private JScrollPane addItemScroll = new JScrollPane(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER,
	 ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
         private JScrollPane printSpecificPersonScroll = new JScrollPane(printSpecificPersonScreen,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
	 ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
         Color grey = new Color(237,239,242);
         private static String checkTypeOfObjectChosen[] = {"Select Item","Select Item","Select Item", "Select Item"};
         private static String getDataOfDeviceFirstRow[] = {"Select Type","Select Condition"};
         private static String getDataOfDeviceSecondRow[] = {"Select Type","Select Condition"};
         private static String getDataOfDeviceThirdRow[] = {"Select Type","Select Condition"};
         private static String getDataOfDeviceAddItem[] = {"Select Type","Select Condition"};
         private static String getDataOfJewelsFirstRow[] = {"Select Type","Select Material"};
         private static String getDataOfJewelsSecondRow[] = {"Select Type","Select Material"};
         private static String getDataOfJewelsThirdRow[] = {"Select Type","Select Material"};
         private static String getDataOfJewelsAddItem[] = {"Select Type","Select Material"};
         private static String getDataOfStockFirstRow[] = {null,null,null};
         private static String getDataOfStockSecondRow[] = {null,null,null};
         private static String getDataOfStockThirdRow[] = {null,null,null};
         private static String getDataOfStockAddItem[] = {null,null,null};
         private ArrayList<Person> personList = new ArrayList<>();
         private GridBagLayout gridbag = new GridBagLayout();
         private GridBagConstraints c = new GridBagConstraints();
         JFileChooser fileChooser = new JFileChooser();
         Font font = new Font("Verdana", Font.BOLD, 76);
         
//Konstruktor för klassen
  public PrylRegister() {
         super("Prylregister");
         setSize(1100,160);
         setResizable(false);
         welcomeScreen.setFont(font);
         setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE) ;
         panel1MenuAndButtons.setLayout(gridbag);
         panel2.setLayout(gridbag);
         createPersonPanel.setLayout(gridbag);
         jewelPanelFirstRow.setLayout(gridbag);
         devicePanelFirstRow.setLayout(gridbag);
         stockPanelFirstRow.setLayout(gridbag);
         devicePanelSecondRow.setLayout(gridbag);
         jewelPanelSecondRow.setLayout(gridbag);
         stockPanelSecondRow.setLayout(gridbag);
         devicePanelThirdRow.setLayout(gridbag);
         jewelPanelThirdRow.setLayout(gridbag);
         stockPanelThirdRow.setLayout(gridbag);
         printPersonPanel.setLayout(gridbag);
         addItemPanel.setLayout(gridbag);
         addItemJewelsPanel.setLayout(gridbag);
         addItemStocksPanel.setLayout(gridbag);
         addItemDevicePanel.setLayout(gridbag);
         panel2.setPreferredSize (new Dimension (1100,160));
         createPersonPanel.setSize (new Dimension (1100,160));
         printPersonPanel.setSize (new Dimension (1100,160));
         addItemPanel.setSize(new Dimension(1100,121));
         jewelPanelFirstRow.setSize(new Dimension(100,10));
         devicePanelFirstRow.setSize(new Dimension(100,10));
         stockPanelFirstRow.setSize(new Dimension(100,10));
         jewelPanelSecondRow.setSize(new Dimension(100,10));
         devicePanelSecondRow.setSize(new Dimension(100,10));
         stockPanelFirstRow.setSize(new Dimension(100,10));
         devicePanelThirdRow.setSize(new Dimension(100,10));
         jewelPanelThirdRow.setSize(new Dimension(100,10));
         stockPanelThirdRow.setSize(new Dimension(100,10));

         
         
//Menu Starts here        
              
//Lägger till menyn menuBar på platsen "c" i panelen panel1MenuAndButtons
         buildConstraints(c, 0, 0, 2, 1, 100, 1);
         c.fill = GridBagConstraints.HORIZONTAL;
	 c.anchor = GridBagConstraints.FIRST_LINE_START;
         gridbag.setConstraints(menuBar, c);
         panel1MenuAndButtons.add(menuBar, c);
// Lägger  till knapp1 buttonStockmarketCrash i panelen panel1MenuAndButtons och rutnätet för att kunna nollställa allas ägda aktier
         buildConstraints(c, 0, 1, 1, 1, 25, 1);
         c.fill = GridBagConstraints.HORIZONTAL;
	 c.anchor = GridBagConstraints.WEST;
         gridbag.setConstraints(button1StockmarketCrash, c);
         panel1MenuAndButtons.add(button1StockmarketCrash, c);
// Lägger till knapp2 button2ShowCertainPerson i panelen panel1MenuAndButtons och rutnätet för att skriva ut en enda specifik person från listan
         buildConstraints(c, 1, 1, 1, 1, 25, 1);
         c.fill = GridBagConstraints.HORIZONTAL;
	 c.anchor = GridBagConstraints.WEST;
         gridbag.setConstraints(button2ShowCertainPerson, c);
         panel1MenuAndButtons.add(button2ShowCertainPerson, c);
// Lägger  till knapp3 button3ShowRichestPerson i panelen panel1MenuAndButtons och rutnätet för att visa rikaste personen i listan
         buildConstraints(c, 0, 2, 1, 1, 50, 1);
         c.fill = GridBagConstraints.HORIZONTAL;
	 c.anchor = GridBagConstraints.WEST;
         gridbag.setConstraints(button3ShowRichestPerson, c);
         panel1MenuAndButtons.add(button3ShowRichestPerson, c);
// Lägger till knapp4 button4ShowEveryone i panelen panel1MenuAndButtons och rutnätet för att skriva ut alla personer i listan
         buildConstraints(c, 1, 2, 1, 1, 50, 1);
         c.fill = GridBagConstraints.HORIZONTAL;
	 c.anchor = GridBagConstraints.WEST;
         gridbag.setConstraints(button4ShowEveryone, c);
         panel1MenuAndButtons.add(button4ShowEveryone, c);         
//Lägger till den inre Panelen "panel2" till panel1MenuAndButtons-panelen och rutnätet
         buildConstraints(c, 0, 3, 2, 1, 100, 95);
         c.fill = GridBagConstraints.HORIZONTAL;
	 c.anchor = GridBagConstraints.WEST;
         gridbag.setConstraints(panel2, c);
         panel1MenuAndButtons.add(panel2);
//Lägger till en JScrollPane "scroll" för uppvisning av varierande komponenter i "panel2" och rutnätet
         buildConstraints(c, 0, 0, 5, 5, 100, 100);
         c.fill = GridBagConstraints.BOTH;
	 c.anchor = GridBagConstraints.FIRST_LINE_START;
         gridbag.setConstraints(scroll, c);
         panel2.add(scroll, c);  
   
//FirstRow Starts here          
            
//Lägger till JComboBoxen JCB4JewelType i panelen jewelPanelFirstRow och i rutnätet för att kunna välja vilken typ smycket är
         buildConstraints(c, 0, 0, 1, 1, 25, 10);
         c.fill = GridBagConstraints.HORIZONTAL;
	 c.anchor = GridBagConstraints.WEST;
         gridbag.setConstraints(JCB4JewelType, c);
         jewelPanelFirstRow.add(JCB4JewelType, c);  
//Lägger till JComboBoxen JCB5JewelMaterial i panelen jewelPanelFirstRow och i rutnätet för att kunna välja vilket material smycket är gjort av
         buildConstraints(c, 1, 0, 1, 1, 25, 10);
         c.fill = GridBagConstraints.HORIZONTAL;
	 c.anchor = GridBagConstraints.WEST;
         gridbag.setConstraints(JCB5JewelMaterial, c);
         jewelPanelFirstRow.add(JCB5JewelMaterial, c); 
//Lägger till JTextField numberOfJewels1 i panelen jewelPanelFirstRow och rutnätet för att kunna lägga till antalet ädelstenar
         buildConstraints(c, 2, 0, 1, 1, 50, 10);
         c.fill = GridBagConstraints.BOTH;
	 c.anchor = GridBagConstraints.WEST;
         gridbag.setConstraints(numberOfJewels1, c);
         jewelPanelFirstRow.add(numberOfJewels1, c);
//Lägger till JTextField typeOfObjectJewels i panelen jewelPanelFirstRow och rutnätet för att kunna vara mer specifik i smyckestypen
         buildConstraints(c, 3, 0, 1, 1, 50, 10);
         c.fill = GridBagConstraints.BOTH;
	 c.anchor = GridBagConstraints.WEST;
         gridbag.setConstraints(typeOfObjectJewels, c);
         jewelPanelFirstRow.add(typeOfObjectJewels, c);
//Lägger till JComboBoxen JCB6ElectricOrNot i panelen devicePanelFirstRow och rutnätet för att kunna ange om apparaten är elektrisk eller inte         
         buildConstraints(c, 0, 0, 1, 1, 10, 10);
         c.fill = GridBagConstraints.HORIZONTAL;
	 c.anchor = GridBagConstraints.WEST;
         gridbag.setConstraints(JCB6ElectricOrNot, c);
         devicePanelFirstRow.add(JCB6ElectricOrNot, c); 
//Lägger till JComboBox13Worn i panelen devicePanelFirstRow och rutnätet för att kunna ange slitage på apparaten         
         buildConstraints(c, 2, 0, 1, 1, 25, 10);
         c.fill = GridBagConstraints.BOTH;
	 c.anchor = GridBagConstraints.WEST;
         gridbag.setConstraints(JCB13Worn, c);
         devicePanelFirstRow.add(JCB13Worn, c);
//Lägger till JTextField priceOfDevice i panelen devicePanelFirstRow och rutnätet för att kunna ange orginalpriset på apparaten
         buildConstraints(c, 3, 0, 1, 1, 25, 10);
         c.fill = GridBagConstraints.BOTH;
	 c.anchor = GridBagConstraints.WEST;
         gridbag.setConstraints(priceOfDevice, c);
         devicePanelFirstRow.add(priceOfDevice, c);
//Lägger till textfield typeOfObjectDevice i panelen och rutnätet för att man ska kunna ange precis vilken apparat det är
         buildConstraints(c, 4, 0, 1, 1, 25, 10);
         c.fill = GridBagConstraints.BOTH;
	 c.anchor = GridBagConstraints.WEST;
         gridbag.setConstraints(typeOfObjectDevice, c);
         devicePanelFirstRow.add(typeOfObjectDevice, c);
//Lägger till JTextfield typeOfObjectStocks i panelen och rutnätet för att vilket företag som man har aktier i
         buildConstraints(c, 0, 0, 1, 1, 100, 100);
         c.fill = GridBagConstraints.BOTH;
	 c.anchor = GridBagConstraints.WEST;
         gridbag.setConstraints(typeOfObjectStocks, c);
         stockPanelFirstRow.add(typeOfObjectStocks, c);
//Lägger till JTextfield typeOfObjectStocks i panelen och rutnätet för att vilket företag som man har aktier i
         buildConstraints(c, 1, 0, 1, 1, 100, 100);
         c.fill = GridBagConstraints.BOTH;
	 c.anchor = GridBagConstraints.WEST;
         gridbag.setConstraints(valueOfStocks1, c);
         stockPanelFirstRow.add(valueOfStocks1, c);  
//Lägger till JTextfield amountOfStocks1 i panelen och rutnätet för att ange den mängd aktier man innehar
         buildConstraints(c, 2, 0, 1, 1, 100, 100);
         c.fill = GridBagConstraints.BOTH;
	 c.anchor = GridBagConstraints.WEST;
         gridbag.setConstraints(amountOfStocks1, c);
         stockPanelFirstRow.add(amountOfStocks1, c);     
              
//SecondRow Starts here           
           
//Lägg till JComboBoxen JCB7 i panelen devicePanelSecondRow och rutnätet för att ange om apparaten är elektrisk eller inte
         buildConstraints(c, 0, 0, 1, 1, 10, 10);
         c.fill = GridBagConstraints.HORIZONTAL;
	 c.anchor = GridBagConstraints.WEST;
         gridbag.setConstraints(JCB7ElectricOrNot, c);
         devicePanelSecondRow.add(JCB7ElectricOrNot, c);
//Lägger till JComboBox JCB14Worn till panelen devicePanelSecondRow för att ange slitage på apparaten
         buildConstraints(c, 2, 0, 1, 1, 25, 10);
         c.fill = GridBagConstraints.BOTH;
	 c.anchor = GridBagConstraints.WEST;
         gridbag.setConstraints(JCB14Worn, c);
         devicePanelSecondRow.add(JCB14Worn, c);
//Lägger till JTextField priceOfDevice2 till panelen devicePanelSecondRow för att ange orginalpriset på apparaten
         buildConstraints(c, 3, 0, 1, 1, 25, 10);
         c.fill = GridBagConstraints.BOTH;
	 c.anchor = GridBagConstraints.WEST;
         typeOfObjectStocks.setMaximumSize(new Dimension(15, 30));
         typeOfObjectStocks.setMinimumSize(new Dimension( 15, 30));
         gridbag.setConstraints(priceOfDevice2, c);
         devicePanelSecondRow.add(priceOfDevice2, c);
//Lägger till JTextField typeOfObject2Device i panelen devicePanelSecondRow för att kunna ange precis vilken apparat det är
         buildConstraints(c, 4, 0, 1, 1, 25, 10);
         c.fill = GridBagConstraints.BOTH;
	 c.anchor = GridBagConstraints.WEST;
         typeOfObjectDevice.setMaximumSize(new Dimension(15, 30));
         typeOfObjectDevice.setMinimumSize(new Dimension( 15, 30));
         gridbag.setConstraints(typeOfObject2Device, c);
         devicePanelSecondRow.add(typeOfObject2Device, c);      
//Lägger till JComboBoxen JCB9JewelType i panelen jewelPanelSecondRow för att ange vilken typ av smycke det är
          buildConstraints(c, 0, 0, 1, 1, 25, 10);
         c.fill = GridBagConstraints.HORIZONTAL;
	 c.anchor = GridBagConstraints.WEST;
         gridbag.setConstraints(JCB9JewelType, c);
         jewelPanelSecondRow.add(JCB9JewelType, c);  
//Lägger till JComboBoxen JCB11JewelMaterial i panelen jewelPanelSecondRow för att kunna ange vilket material smycket är gjort av
         buildConstraints(c, 1, 0, 1, 1, 25, 10);
         c.fill = GridBagConstraints.HORIZONTAL;
	 c.anchor = GridBagConstraints.WEST;
         gridbag.setConstraints(JCB11JewelMaterial, c);
         jewelPanelSecondRow.add(JCB11JewelMaterial, c); 
//Lägger till JTextField numberOfJewels2 i panelen jewelPanelFirstRow och rutnätet för att kunna lägga till antalet ädelstenar
         buildConstraints(c, 2, 0, 1, 1, 50, 10);
         c.fill = GridBagConstraints.BOTH;
	 c.anchor = GridBagConstraints.WEST;
         gridbag.setConstraints(numberOfJewels2, c);
         jewelPanelSecondRow.add(numberOfJewels2, c);
//Lägger till JTextField typeOfObject2Jewels till panelen jewelPanelSecondRow för att kunna ange en specifik typ av smycke       
         buildConstraints(c, 3, 0, 1, 1, 50, 10);
         c.fill = GridBagConstraints.BOTH;
	 c.anchor = GridBagConstraints.WEST;
         typeOfObjectStocks.setMaximumSize(new Dimension(15, 30));
         typeOfObjectStocks.setMinimumSize(new Dimension( 15, 30));
         gridbag.setConstraints(typeOfObject2Jewels, c);
         jewelPanelSecondRow.add(typeOfObject2Jewels, c);
//Lägger till JTextField typeOfObject2Stocks i panelen stockPanelSecondRow för att kunna ange vilket företag som man har aktier i
         buildConstraints(c, 0, 0, 1, 1, 100, 100);
         c.fill = GridBagConstraints.BOTH;
	 c.anchor = GridBagConstraints.WEST;
         typeOfObjectStocks.setMaximumSize(new Dimension(15, 30));
         typeOfObjectStocks.setMinimumSize(new Dimension( 15, 30));
         gridbag.setConstraints(typeOfObject2Stocks, c);
         stockPanelSecondRow.add(typeOfObject2Stocks, c);
//Lägger till JTextfield typeOfObjectStocks i panelen och rutnätet för att vilket företag som man har aktier i
         buildConstraints(c, 1, 0, 1, 1, 100, 100);
         c.fill = GridBagConstraints.BOTH;
	 c.anchor = GridBagConstraints.WEST;
         gridbag.setConstraints(valueOfStocks2, c);
         stockPanelSecondRow.add(valueOfStocks2, c);    
//Lägger till JTextfield amountOfStocks2 i panelen och rutnätet för att ange den mängd aktier man innehar
         buildConstraints(c, 2, 0, 1, 1, 100, 100);
         c.fill = GridBagConstraints.BOTH;
	 c.anchor = GridBagConstraints.WEST;
         gridbag.setConstraints(amountOfStocks2, c);
         stockPanelSecondRow.add(amountOfStocks2, c);  
         
//PersonPanel Starts here      
         
//Lägger till den första labeln i panelen och rutnätet
         buildConstraints(c, 0, 0, 1, 1, 25, 50);
         c.fill = GridBagConstraints.HORIZONTAL;
	 c.anchor = GridBagConstraints.WEST;
         gridbag.setConstraints(label1FullName, c);
         createPersonPanel.add(label1FullName, c);
//Lägger till textarean Name i panelen och rutnätet
         buildConstraints(c, 2, 0, 4, 1, 75, 50);
         c.fill = GridBagConstraints.HORIZONTAL;
	 c.anchor = GridBagConstraints.WEST;
         gridbag.setConstraints(Name, c);
         createPersonPanel.add(Name, c);
//Lägger till första labeln till panelen och rutnätet
         buildConstraints(c, 0, 3, 1, 1, 10, 10);
         c.fill = GridBagConstraints.HORIZONTAL;
	 c.anchor = GridBagConstraints.WEST;
         gridbag.setConstraints(label2SelectItemFirstRow, c);
         createPersonPanel.add(label2SelectItemFirstRow, c);
// Lägger till multivalkomponenten JComboBox JCB1 till panelen och rutnätet
         buildConstraints(c, 2, 3, 1, 1, 10, 10);
         c.fill = GridBagConstraints.HORIZONTAL;
	 c.anchor = GridBagConstraints.WEST;
         gridbag.setConstraints(JCB1, c);
         createPersonPanel.add(JCB1, c);
// Lägger till JScrollPane createPersonScroll till panelen createPersonPanel och rutnätet 
         buildConstraints(c, 3, 3, 3, 1, 20, 10);
         c.fill = GridBagConstraints.HORIZONTAL;
	 c.anchor = GridBagConstraints.WEST;
         gridbag.setConstraints(createPersonScroll, c);
         createPersonPanel.add(createPersonScroll, c);
         
// Lägger till JScrollPane createPersonScroll2 till panelen createPersonPanel och rutnätet 
         buildConstraints(c, 3, 4, 3, 1, 20, 10);
         c.fill = GridBagConstraints.HORIZONTAL;
	 c.anchor = GridBagConstraints.WEST;
         gridbag.setConstraints(createPersonScroll2, c);
         createPersonPanel.add(createPersonScroll2, c);
         
 // Lägger till JScrollPane createPersonScroll3 till panelen createPersonPanel och rutnätet 
         buildConstraints(c, 3, 5, 3, 1, 20, 10);
         c.fill = GridBagConstraints.HORIZONTAL;
	 c.anchor = GridBagConstraints.WEST;
         gridbag.setConstraints(createPersonScroll3, c);
         createPersonPanel.add(createPersonScroll3, c);
         
//Lägger till labeln label3 i panelen och rutnätet
         buildConstraints(c, 0, 4, 1, 1, 10, 10);
         c.fill = GridBagConstraints.HORIZONTAL;
	 c.anchor = GridBagConstraints.WEST;
         gridbag.setConstraints(label3SelectItemSecondRow, c);
         createPersonPanel.add(label3SelectItemSecondRow, c);
//Lägger till JComboBoxen JCB2 i panelen och rutnätet
         buildConstraints(c, 2, 4, 1, 1, 10, 10);
         c.fill = GridBagConstraints.HORIZONTAL;
	 c.anchor = GridBagConstraints.WEST;
         gridbag.setConstraints(JCB2, c);
         createPersonPanel.add(JCB2, c);

//Lägger till labeln label4 i panelen och rutnätet
         buildConstraints(c, 0, 5, 1, 1, 10, 10);
         c.fill = GridBagConstraints.HORIZONTAL;
	 c.anchor = GridBagConstraints.WEST;
         gridbag.setConstraints(label4SelectItemThirdRow, c);
         createPersonPanel.add(label4SelectItemThirdRow, c);
//Lägger till JComboBoxen JCB3 i panelen och rutnätet 
         buildConstraints(c, 2, 5, 1, 1, 10, 10);
         c.fill = GridBagConstraints.HORIZONTAL;
	 c.anchor = GridBagConstraints.WEST;
         gridbag.setConstraints(JCB3, c);
         createPersonPanel.add(JCB3, c);
//Lägger till textFielden  typeOfObject3 i panelen och rutnätet 
         buildConstraints(c, 5, 5, 2, 1, 80, 10);
         c.fill = GridBagConstraints.HORIZONTAL;
	 c.anchor = GridBagConstraints.WEST;
         gridbag.setConstraints(typeOfObject3Device, c);
         createPersonPanel.add(typeOfObject3Device, c);
//Lägger till knappen button5Save i panelen createPersonPanel för att kunna spara den önskade personen
         buildConstraints(c, 5, 6, 1, 1, 80, 10);
         c.fill = GridBagConstraints.NONE;
	 c.anchor = GridBagConstraints.LINE_END;
         button5Save.setMaximumSize(new Dimension(5, 30));
         gridbag.setConstraints(button5Save, c);
         createPersonPanel.add(button5Save, c);


         
//ThirdRow Starts here         
         
         
//Lägger till JComboBoxen JCB4JewelType i panelen jewelPanelThirdRow och i rutnätet för att kunna välja vilken typ smycket är
         buildConstraints(c, 0, 0, 1, 1, 25, 10);
         c.fill = GridBagConstraints.HORIZONTAL;
	 c.anchor = GridBagConstraints.WEST;
         gridbag.setConstraints(JCB10JewelType, c);
         jewelPanelThirdRow.add(JCB10JewelType, c);  
//Lägger till JComboBoxen JCB5JewelMaterial i panelen jewelPanelThirdRow och i rutnätet för att kunna välja vilket material smycket är gjort av
         buildConstraints(c, 1, 0, 1, 1, 25, 10);
         c.fill = GridBagConstraints.HORIZONTAL;
	 c.anchor = GridBagConstraints.WEST;
         gridbag.setConstraints(JCB12JewelMaterial, c);
         jewelPanelThirdRow.add(JCB12JewelMaterial, c); 
//Lägger till JTextField numberOfJewels3 i panelen jewelPanelFirstRow och rutnätet för att kunna lägga till antalet ädelstenar
         buildConstraints(c, 2, 0, 1, 1, 50, 10);
         c.fill = GridBagConstraints.BOTH;
	 c.anchor = GridBagConstraints.WEST;
         gridbag.setConstraints(numberOfJewels3, c);
         jewelPanelThirdRow.add(numberOfJewels3, c);
//Lägger till JTextField typeOfObjectJewels i panelen jewelPanelThirdRow och rutnätet för att kunna vara mer specifik i smyckestypen
         buildConstraints(c, 3, 0, 1, 1, 50, 10);
         c.fill = GridBagConstraints.BOTH;
	 c.anchor = GridBagConstraints.WEST;
         gridbag.setConstraints(typeOfObject3Jewels, c);
         jewelPanelThirdRow.add(typeOfObject3Jewels, c);
//Lägger till JComboBoxen JCB6ElectricOrNot i panelen devicePanelThirdRow och rutnätet för att kunna ange om apparaten är elektrisk eller inte         
         buildConstraints(c, 0, 0, 1, 1, 10, 10);
         c.fill = GridBagConstraints.HORIZONTAL;
	 c.anchor = GridBagConstraints.WEST;
         gridbag.setConstraints(JCB8ElectricOrNot, c);
         devicePanelThirdRow.add(JCB8ElectricOrNot, c);
//Lägger till JCmoboBox JCB15Worn i panelen devicePanelThirdRow och rutnätet för att kunna ange slitage på apparaten        
         buildConstraints(c, 2, 0, 1, 1, 25, 10);
         c.fill = GridBagConstraints.BOTH;
	 c.anchor = GridBagConstraints.WEST;
         gridbag.setConstraints(JCB15Worn, c);
         devicePanelThirdRow.add(JCB15Worn, c);
         
//Lägger till JTextField priceOfDevice i panelen devicePanelThirdRow och rutnätet för att kunna ange orginalpriset på apparaten
         buildConstraints(c, 3, 0, 1, 1, 25, 10);
         c.fill = GridBagConstraints.BOTH;
	 c.anchor = GridBagConstraints.WEST;
         gridbag.setConstraints(priceOfDevice3, c);
         devicePanelThirdRow.add(priceOfDevice3, c);
//Lägger till textfield typeOfObjectDevice i panelen devicePanelThirdRow och rutnätet för att man ska kunna ange precis vilken apparat det är
         buildConstraints(c, 4, 0, 1, 1, 25, 10);
         c.fill = GridBagConstraints.BOTH;
	 c.anchor = GridBagConstraints.WEST;
         gridbag.setConstraints(typeOfObject3Device, c);
         devicePanelThirdRow.add(typeOfObject3Device, c);
//Lägger till JTextfield typeOfObjectStocks i panelen stockPanelThirdRow och rutnätet för att vilket företag som man har aktier i
         buildConstraints(c, 0, 0, 1, 1, 100, 100);
         c.fill = GridBagConstraints.BOTH;
	 c.anchor = GridBagConstraints.WEST;
         gridbag.setConstraints(typeOfObject3Stocks, c);
         stockPanelThirdRow.add(typeOfObject3Stocks, c);
//Lägger till JTextfield typeOfObjectStocks i panelen och rutnätet för att vilket företag som man har aktier i
         buildConstraints(c, 1, 0, 1, 1, 100, 100);
         c.fill = GridBagConstraints.BOTH;
	 c.anchor = GridBagConstraints.WEST;
         gridbag.setConstraints(valueOfStocks3, c);
         stockPanelThirdRow.add(valueOfStocks3, c);     
//Lägger till JTextfield amountOfStocks3 i panelen och rutnätet för att ange den mängd aktier man innehar
         buildConstraints(c, 2, 0, 1, 1, 100, 100);
         c.fill = GridBagConstraints.BOTH;
	 c.anchor = GridBagConstraints.WEST;
         gridbag.setConstraints(amountOfStocks3, c);
         stockPanelThirdRow.add(amountOfStocks3, c);  
         
//Lägger till en JLabel label5SpecificPerson i panelen printPersonPanel och rutätet
         buildConstraints(c, 0, 0, 1, 1, 10, 10);
         c.fill = GridBagConstraints.HORIZONTAL;
	 c.anchor = GridBagConstraints.WEST;
         gridbag.setConstraints(label5SpecificPerson, c);
         printPersonPanel.add(label5SpecificPerson , c);  
//Lägger till JTextfield specificPersonName i panelen och rutnätet för att ange namnet på den enskilda person man vill skriva ut
         buildConstraints(c, 1, 0, 1, 1, 90, 10);
         c.fill = GridBagConstraints.HORIZONTAL;
	 c.anchor = GridBagConstraints.WEST;
         gridbag.setConstraints(specificPersonName, c);
         printPersonPanel.add(specificPersonName, c);
//Lägger till en knapp
         buildConstraints(c, 0, 1, 2, 1, 100, 10);
         c.fill = GridBagConstraints.NONE;
	 c.anchor = GridBagConstraints.CENTER;
         button6OK.setMaximumSize(new Dimension(5, 30));
         gridbag.setConstraints(button6OK , c);
         printPersonPanel.add(button6OK , c);
//Lägger till en textArea
         buildConstraints(c, 0, 2, 2, 1, 100, 70);
         c.fill = GridBagConstraints.HORIZONTAL;
	 c.anchor = GridBagConstraints.CENTER;
         gridbag.setConstraints(printSpecificPersonScroll , c);
         printPersonPanel.add(printSpecificPersonScroll , c);
         
// Add Item skapas här
         
         
         buildConstraints(c, 0, 0, 1, 1, 25, 10);
         c.fill = GridBagConstraints.HORIZONTAL;
	 c.anchor = GridBagConstraints.WEST;
         gridbag.setConstraints(label7AddItemToPerson, c);
         addItemPanel.add(label7AddItemToPerson, c);
//Lägger till textarean Name i panelen och rutnätet
         buildConstraints(c, 2, 0, 4, 1, 75, 10);
         c.fill = GridBagConstraints.HORIZONTAL;
	 c.anchor = GridBagConstraints.WEST;
         gridbag.setConstraints(addItemName, c);
         addItemPanel.add(addItemName, c);
//Lägger till första labeln till panelen och rutnätet
         buildConstraints(c, 0, 1, 1, 1, 10, 10);
         c.fill = GridBagConstraints.HORIZONTAL;
	 c.anchor = GridBagConstraints.WEST;
         gridbag.setConstraints(label6AddItemSelect, c);
         addItemPanel.add(label6AddItemSelect, c);
// Lägger till multivalkomponenten JComboBox JCB1 till panelen och rutnätet
         buildConstraints(c, 2, 1, 1, 1, 10, 10);
         c.fill = GridBagConstraints.HORIZONTAL;
	 c.anchor = GridBagConstraints.WEST;
         gridbag.setConstraints(JCB16, c);
         addItemPanel.add(JCB16, c);
// Lägger till JScrollPane createPersonScroll till panelen createPersonPanel och rutnätet 
         buildConstraints(c, 3, 1, 3, 1, 80, 10);
         c.fill = GridBagConstraints.HORIZONTAL;
	 c.anchor = GridBagConstraints.WEST;
         gridbag.setConstraints(addItemScroll, c);
         addItemPanel.add(addItemScroll, c);
         buildConstraints(c, 5, 2, 1, 1, 80, 10);
         c.fill = GridBagConstraints.NONE;
	 c.anchor = GridBagConstraints.LINE_END;
         button5Save.setMaximumSize(new Dimension(5, 30));
         gridbag.setConstraints(button7SaveItem, c);
         addItemPanel.add(button7SaveItem, c);
         
      
// Add Item grejjorna görs här
                 
            
//Lägger till JComboBoxen JCB19JewelType i panelen addItemsJewelsPanel och i rutnätet för att kunna välja vilken typ smycket är
         buildConstraints(c, 0, 0, 1, 1, 25, 10);
         c.fill = GridBagConstraints.HORIZONTAL;
	 c.anchor = GridBagConstraints.WEST;
         gridbag.setConstraints(JCB19JewelType, c);
         addItemJewelsPanel.add(JCB19JewelType, c);  
//Lägger till JComboBoxen JCB18JewelMaterial i panelen addItemJewelsPanel och i rutnätet för att kunna välja vilket material smycket är gjort av
         buildConstraints(c, 1, 0, 1, 1, 25, 10);
         c.fill = GridBagConstraints.HORIZONTAL;
	 c.anchor = GridBagConstraints.WEST;
         gridbag.setConstraints(JCB18AddJewelMaterial, c);
         addItemJewelsPanel.add(JCB18AddJewelMaterial, c); 
//Lägger till JTextField numberOfJewels4 i panelen addItemJewelsPanel och rutnätet för att kunna lägga till antalet ädelstenar
         buildConstraints(c, 2, 0, 1, 1, 50, 10);
         c.fill = GridBagConstraints.BOTH;
	 c.anchor = GridBagConstraints.WEST;
         gridbag.setConstraints(numberOfJewels4, c);
         addItemJewelsPanel.add(numberOfJewels4, c);
//Lägger till JTextField typeOfObject4Jewels i panelen addItemJewelsPanel och rutnätet för att kunna vara mer specifik i smyckestypen
         buildConstraints(c, 3, 0, 1, 1, 50, 10);
         c.fill = GridBagConstraints.BOTH;
	 c.anchor = GridBagConstraints.WEST;
         gridbag.setConstraints(typeOfObject4Jewels, c);
         addItemJewelsPanel.add(typeOfObject4Jewels, c);
//Lägger till JComboBoxen JCB6ElectricOrNot i panelen devicePanelFirstRow och rutnätet för att kunna ange om apparaten är elektrisk eller inte         
         buildConstraints(c, 0, 0, 1, 1, 10, 10);
         c.fill = GridBagConstraints.HORIZONTAL;
	 c.anchor = GridBagConstraints.WEST;
         gridbag.setConstraints(JCB20ElectricOrNot, c);
         addItemDevicePanel.add(JCB20ElectricOrNot, c); 
//Lägger till JComboBox13Worn i panelen devicePanelFirstRow och rutnätet för att kunna ange slitage på apparaten         
         buildConstraints(c, 2, 0, 1, 1, 25, 10);
         c.fill = GridBagConstraints.BOTH;
	 c.anchor = GridBagConstraints.WEST;
         gridbag.setConstraints(JCB21Worn, c);
         addItemDevicePanel.add(JCB21Worn, c);
//Lägger till JTextField priceOfDevice i panelen devicePanelFirstRow och rutnätet för att kunna ange orginalpriset på apparaten
         buildConstraints(c, 3, 0, 1, 1, 25, 10);
         c.fill = GridBagConstraints.BOTH;
	 c.anchor = GridBagConstraints.WEST;
         gridbag.setConstraints(priceOfDevice4, c);
         addItemDevicePanel.add(priceOfDevice4, c);
//Lägger till textfield typeOfObjectDevice i panelen och rutnätet för att man ska kunna ange precis vilken apparat det är
         buildConstraints(c, 4, 0, 1, 1, 25, 10);
         c.fill = GridBagConstraints.BOTH;
	 c.anchor = GridBagConstraints.WEST;
         gridbag.setConstraints(typeOfObject4Device, c);
         addItemDevicePanel.add(typeOfObject4Device, c);
//Lägger till JTextfield typeOfObjectStocks i panelen och rutnätet för att vilket företag som man har aktier i
         buildConstraints(c, 0, 0, 1, 1, 100, 100);
         c.fill = GridBagConstraints.BOTH;
	 c.anchor = GridBagConstraints.WEST;
         gridbag.setConstraints(typeOfObject4Stocks, c);
         addItemStocksPanel.add(typeOfObject4Stocks, c);
//Lägger till JTextfield typeOfObjectStocks i panelen och rutnätet för att vilket företag som man har aktier i
         buildConstraints(c, 1, 0, 1, 1, 100, 100);
         c.fill = GridBagConstraints.BOTH;
	 c.anchor = GridBagConstraints.WEST;
         gridbag.setConstraints(valueOfStocks4, c);
         addItemStocksPanel.add(valueOfStocks4, c);  
//Lägger till JTextfield amountOfStocks1 i panelen och rutnätet för att ange den mängd aktier man innehar
         buildConstraints(c, 2, 0, 1, 1, 100, 100);
         c.fill = GridBagConstraints.BOTH;
	 c.anchor = GridBagConstraints.WEST;
         gridbag.setConstraints(amountOfStocks4, c);
         addItemStocksPanel.add(amountOfStocks4, c);  
         
         
         
         
         
      
       
//Lägger till resterande komponenter          

         File.add (Exit) ;
         Edit.add(person);
         person.add(newPerson);
         person.add(editPerson);
         editPerson.add(addItem);
         Help.add (userManual) ;
         Help.add(About);
         menuBar.add (File) ;                 
         menuBar.add(Edit);                     
         menuBar.add (Help) ;                   
                
//Lägger till ActionListeners till komponenterna i programmet
         button1StockmarketCrash.addActionListener(this);
         button2ShowCertainPerson.addActionListener(this);
         button3ShowRichestPerson.addActionListener(this);
         button4ShowEveryone.addActionListener(this);
         button5Save.addActionListener(this);
         button6OK.addActionListener(this);
         button7SaveItem.addActionListener(this);
         Exit.addActionListener(this);
         newPerson.addActionListener(this);
         addItem.addActionListener(this);
         About.addActionListener(this);
         userManual.addActionListener(this);
         JCB1.addItemListener(this);
         JCB2.addItemListener(this);
         JCB3.addItemListener(this);
         JCB4JewelType.addItemListener(this);
         JCB9JewelType.addItemListener(this);
         JCB10JewelType.addItemListener(this);
         JCB5JewelMaterial.addItemListener(this);
         JCB11JewelMaterial.addItemListener(this);
         JCB12JewelMaterial.addItemListener(this);
         JCB6ElectricOrNot.addItemListener(this);
         JCB7ElectricOrNot.addItemListener(this);
         JCB8ElectricOrNot.addItemListener(this);
         JCB13Worn.addItemListener(this);
         JCB14Worn.addItemListener(this);
         JCB15Worn.addItemListener(this);
         JCB16.addItemListener(this);
         JCB18AddJewelMaterial.addItemListener(this);
         JCB19JewelType.addItemListener(this);
         JCB20ElectricOrNot.addItemListener(this);
         JCB21Worn.addItemListener(this); 
         
         
         

//Ändrar storlek och vad som visas i JScrollPaneln "scroll"         
         scroll.setMinimumSize(new Dimension(1000,160));
         scroll.setPreferredSize(new Dimension(1000,160));
         createPersonScroll.setMinimumSize(new Dimension(1,1));
         createPersonScroll.setPreferredSize(new Dimension(100,25));
         createPersonScroll2.setMinimumSize(new Dimension(1,1));
         createPersonScroll2.setPreferredSize(new Dimension(100,25));
         createPersonScroll3.setMinimumSize(new Dimension(1,1));
         createPersonScroll3.setPreferredSize(new Dimension(100,25));
         addItemScroll.setMinimumSize(new Dimension(1,1));
         addItemScroll.setPreferredSize(new Dimension(100,25));
         welcomeScreen.setEditable(false);
         printSpecificPersonScreen.setEditable(false);
         userManualScreen.setEditable(false);
         printAllScreen.setEditable(false);
         printRichestScreen.setEditable(false);
         
         scroll.setViewportView(welcomeScreen);
// Kod för att göra sig av med kanten runt JScrollPane skapas en empty border
         scroll.setBorder(BorderFactory.createEmptyBorder());
         createPersonScroll.setBorder(BorderFactory.createEmptyBorder());
         createPersonScroll2.setBorder(BorderFactory.createEmptyBorder());
         createPersonScroll3.setBorder(BorderFactory.createEmptyBorder());
         addItemScroll.setBorder(BorderFactory.createEmptyBorder());
//Startar programmet i mitten på skärmen
         setLocationRelativeTo(null);
// Lägger till panelen och innehåll i JFrame "frame" och gör den synlig        
         getContentPane().add(panel1MenuAndButtons);     
         pack() ;
         setVisible(true);                
         
//Sätter färg på välkomstskärmen welcomeScreen
         welcomeScreen.setBackground(grey);
       
  }  
    
  
    public static void main(String[] args) {
        PrylRegister pr = new PrylRegister();
        
    }
    
    
//Överskuggning av metoden actionPerformed
    public void actionPerformed(ActionEvent evt) {
       Object source = evt.getSource(); //Hämtar objectet som var triggern
//Om man klickar på knapp 1 (button1) utförs nedanstående kommandon
            if(source == button1StockmarketCrash){
//Skapar en börskrasch genom en for-loop och ett anrop till metoden setStockToZero();
                //Om ArrayListen är tom får man ett felmeddelande
                if(personList.isEmpty()){
                    JOptionPane.showMessageDialog(null,
                    "Command Failed.\nThere are no persons available in the register.",
                    "Error Message",
                    JOptionPane.WARNING_MESSAGE);
                }
                else{
                    // Finns det personer i ArrayListen sätter man alla dessa personers aktier till 0
                    for(int i=0; personList.size()> i; i++){
                       personList.get(i).setStockToZero();
                    } 
                } 
            }
//Om man klickar på knapp 2 (button2) utförs nedanstående kommandon
            if(source == button2ShowCertainPerson){

                printSpecificPersonScreen.setText("The data on the specific person is as follows:\n\n");
                scroll.setMinimumSize(new Dimension(1000,160));
                scroll.setPreferredSize(new Dimension(1000,160));
                scroll.setViewportView(printPersonPanel);
                 
             }
            // När man skrivit in ett namn i textsträngen och tryckt på button6OK
            if(source == button6OK){
            
                if(!personList.isEmpty()){      
                    String text = specificPersonName.getText(); // Hämtar texten i "specificPersonName" och stoppar den i en string
                    for(int i= 0; personList.size()>i; i++){ // Loopar igenom hela ArrayListen en i taget
                        if(text.equalsIgnoreCase(personList.get(i).getName())){
                            printSpecificPersonScreen.append("NAME: " + personList.get(i).getName()+ "\n\n");
                            for(int index = 0;personList.get(i).getPrylIndex()>index;index++){
                                printSpecificPersonScreen.append(personList.get(i).getAllPersonalObjects(index).getText());
                            }
                            printSpecificPersonScreen.append("Total number of items:  " + personList.get(i).getPrylIndex() + "\n\n");    
                        }
                    }
                 } 
                 else{JOptionPane.showMessageDialog(null,
                    "Command Failed.\nThe person is not in the register.",
                    "Error Message",
                    JOptionPane.WARNING_MESSAGE);
                 }
            
            
            }
//Om man klickar på knapp 3 (button3) utförs nedanstående kommandon
            if(source == button3ShowRichestPerson){
//Skriver ut den som är rikast. Om två personer har samma totala värde på sina ägodelar skrivs den första i listan av de två ut
                double richest = 0;
                int personAtIndex=0;
                if(personList.isEmpty()){
                   // Kod för att hantera vad som händer om man inte har någon peron i arraylisten förslag: JOptionPane warning?
                    JOptionPane.showMessageDialog(null,
                    "Command Failed.\nThere are no persons available in the register.",
                    "Error Message",
                    JOptionPane.WARNING_MESSAGE);

                }
                else{
                    for(int i=0;personList.size()> i;i++){
                        double theValueOfAllItems = personList.get(i).getValueOfAllPersonalItems();
                        if(richest < theValueOfAllItems){
                        richest = theValueOfAllItems;
                        personAtIndex=i;
                        }
                        
                    }
                scroll.setMinimumSize(new Dimension(1000,160));
                scroll.setPreferredSize(new Dimension(1000,160));
                scroll.setViewportView(printRichestScreen);
                printRichestScreen.append("The richest person is " + personList.get(personAtIndex).getName() 
                        + " who has a owns items with the total worth of "
                        + richest + "\nList of these items below: \n\n");
              for(int index = 0;personList.get(personAtIndex).getPrylIndex()>index;index++){
                            printRichestScreen.append(personList.get(personAtIndex).getAllPersonalObjects(index).getText());
              }
              }  
            }
            
//Om man klickar på knappen "Show Everyone" för att visa alla            
            if (source == button4ShowEveryone){
                printAllScreen.setText("");
                if(personList.isEmpty()){
                    JOptionPane.showMessageDialog(null,
                    "Command Failed.\nThere are no persons available in the register.",
                    "Error Message",
                    JOptionPane.WARNING_MESSAGE);
                }
                else{
                    scroll.setMinimumSize(new Dimension(1000,160));
                    scroll.setPreferredSize(new Dimension(1000,160));
                    scroll.setViewportView(printAllScreen);
                    printAllScreen.append("The register contains the following persons: \n");
                    for(int i= 0; personList.size()>i; i++){
                        printAllScreen.append("\n" + personList.get(i).getName() + "       " + personList.get(i).getValueOfAllPersonalItems());
                    
                    
                    }
                
                }
                
            
            
            
            }
            if (source == button5Save){  
//Kod för att spara en person och lägga i arraylisten            
                Object[] options = {"Yes",
		                    "No"};
		int n = JOptionPane.showOptionDialog(null,
		    "Are your sure you want to save this person and these items?\n"+
		    "Press No to return to the program and alter entry",
		    "Save Person",
		    JOptionPane.YES_NO_OPTION,
		    JOptionPane.WARNING_MESSAGE,
		    null,
		    options,
                    options[0]);
//Om man väljer Yes i dialogrutan och vill spara                
                if(n==0){
                    boolean check= false;
                    String nameOfPerson = Name.getText();
                    Name.setText("");
                    
                    if(personList.isEmpty()){
                        check = true;
                    }
                    else{
                    
                        for(int i =0;personList.size()>i;i++){
                       
                            if(nameOfPerson.equalsIgnoreCase(personList.get(i).getName())){
                                JOptionPane.showMessageDialog(null,
                                "Command Failed.\nThere are already a person named " + nameOfPerson + " in the register.",
                                "Error Message",
                                JOptionPane.WARNING_MESSAGE);
                                check = false;
                                break;
                            }
                            else{
                                check = true;
                            }
                        }
                    
                    
                    }


                    
                    if(check==true){
                        
                    Person p = new Person (nameOfPerson, new ArrayList<Pryl>());
                    
                    personList.add(p);
                    if(checkTypeOfObjectChosen[0].equals("Select Item")){
// Om första raden är Select Item i första diaglogrutan skall ingenting läggas till, och därmed görs ingenting                  
                    }
                    if(checkTypeOfObjectChosen[0].equals("Device")){
// Om första raden är Device i första diaglogrutan skall ett Device-object läggas till personen vi skapat
                        if(getDataOfDeviceFirstRow[0].equals("Select Type")|| getDataOfDeviceFirstRow[1].equals("Select Condition")){
                            JOptionPane.showMessageDialog(null, 
                                    "You must select both what type of device and the condition of the device! "
                                    + "\nItem will not be added to person!",
                                    "InputError",JOptionPane.WARNING_MESSAGE);
                        }
                        else{
                            boolean ok;
                            double d2 = 0.0;
                            do{
                                ok=true;
                                try{
                                    d2 = Double.parseDouble(priceOfDevice.getText());
                                }
                                catch (NumberFormatException ex){
                                    String str = JOptionPane.showInputDialog(null,  "The Price of the Device must be a number! ",
                                    "InputError",JOptionPane.WARNING_MESSAGE);
                                    priceOfDevice.setText(str);
                                    ok=false;
                                }
                        
                        
                            }while(!ok);
                        
                        double d = Double.parseDouble(getDataOfDeviceFirstRow[1]);
                        Apparater app = new Apparater(getDataOfDeviceFirstRow[0], d, d2, typeOfObjectDevice.getText());
                        p.addThing(app);  
                        }
                          
                    }
                    if(checkTypeOfObjectChosen[0].equals("Jewlery")){
// Om första raden är Jewlery i första diaglogrutan skall ett Smycken-object läggas till
                          if(getDataOfJewelsFirstRow[0].equals("Select Type")|| getDataOfJewelsFirstRow[1].equals("Select Material")){
                            JOptionPane.showMessageDialog(null, 
                                    "You must select both what type of jewlery and the type material! "
                                    + "\nItem will not be added to person!",
                                    "InputError",JOptionPane.WARNING_MESSAGE);
                        }
                        
                        
                          else{
                                boolean ok;
                                int d = 0;
                                do{
                                    ok=true;
                                    try{
                                        d = Integer.parseInt(numberOfJewels1.getText());
                                    }
                                    catch (NumberFormatException ex){
                                        String str = JOptionPane.showInputDialog(null,  "The number of gems must be a number! ",
                                        "InputError",JOptionPane.WARNING_MESSAGE);
                                        numberOfJewels1.setText(str);
                                        ok=false;
                                    }
                        
                        
                                }while(!ok);
                        

                        Smycken smy = new Smycken(getDataOfJewelsFirstRow[0], getDataOfJewelsFirstRow[1], d, typeOfObjectJewels.getText());
                        p.addThing(smy);
                          
                          
                          }
                       
                    }
                    if(checkTypeOfObjectChosen[0].equals("Stock")){
// Om första raden är Stock i första diaglogrutan skall ett Aktier-objekt läggas till 
                        boolean ok;
                        double d = 0.0;
                        do{
                            ok=true;
                            try{
                            d = Double.parseDouble(valueOfStocks1.getText());
                            }
                            catch (NumberFormatException ex){
                            String str = JOptionPane.showInputDialog(null,  "The price of the Stock must be a number! ",
                                    "InputError",JOptionPane.WARNING_MESSAGE);
                            valueOfStocks1.setText(str);
                            ok=false;
                            }
                        
                        
                        }while(!ok);
                        int in = 0;
                        do{
                            ok=true;
                            try{
                                in = Integer.parseInt(amountOfStocks1.getText());
                            }
                            catch (NumberFormatException ex){
                                String str = JOptionPane.showInputDialog(null,  "The number of Stocks must be a number! ",
                                    "InputError",JOptionPane.WARNING_MESSAGE);
                                amountOfStocks1.setText(str);
                                ok=false;
                            }
                        
                        
                        }while(!ok);

                        Aktier akt = new Aktier(typeOfObjectStocks.getText(), d , in);
                        p.addThing(akt);

                        
                    }

                    if(checkTypeOfObjectChosen[1].equals("Select Item")){
// Om andra raden är Select Item i första diaglogrutan skall ingenting läggas till, och därmed görs ingenting                  
                    }
                    if(checkTypeOfObjectChosen[1].equals("Device")){
// Om andra raden är Device i första diaglogrutan skall ett Apparater-object läggas till
                        if(getDataOfDeviceSecondRow[0].equals("Select Type")|| getDataOfDeviceSecondRow[1].equals("Select Condition")){
                            JOptionPane.showMessageDialog(null, 
                                    "You must select both what type of device and the condition of the device! "
                                    + "\nItem will not be added to person!",
                                    "InputError",JOptionPane.WARNING_MESSAGE);
                        }
                        else{boolean ok;
                            double d2 = 0.0;
                            do{
                                ok=true;
                                try{
                                    d2 = Double.parseDouble(priceOfDevice2.getText());
                                }
                                catch (NumberFormatException ex){
                                    String str = JOptionPane.showInputDialog(null,  "The Price of the Device must be a number! ",
                                    "InputError",JOptionPane.WARNING_MESSAGE);
                                    priceOfDevice2.setText(str);
                                    ok=false;
                                }
                        
                        
                            }while(!ok);
                        double d = Double.parseDouble(getDataOfDeviceSecondRow[1]);
                        Apparater app = new Apparater(getDataOfDeviceSecondRow[0], d, d2, typeOfObject2Device.getText());
                        p.addThing(app);}
                        
                    }
                    if(checkTypeOfObjectChosen[1].equals("Jewlery")){
// Om andra raden är Jewlery i första diaglogrutan skall ett Smycken-objekt läggas till 
                          if(getDataOfJewelsSecondRow[0].equals("Select Type")|| getDataOfJewelsSecondRow[1].equals("Select Material")){
                            JOptionPane.showMessageDialog(null, 
                                    "You must select both what type of jewlery and the type material! "
                                    + "\nItem will not be added to person!",
                                    "InputError",JOptionPane.WARNING_MESSAGE);
                        }
                        
                        
                          else{
                                boolean ok;
                                int d = 0;
                                do{
                                    ok=true;
                                    try{
                                        d = Integer.parseInt(numberOfJewels2.getText());
                                    }
                                    catch (NumberFormatException ex){
                                        String str = JOptionPane.showInputDialog(null,  "The number of gems must be a number! ",
                                        "InputError",JOptionPane.WARNING_MESSAGE);
                                        numberOfJewels2.setText(str);
                                        ok=false;
                                    }
                        
                        
                                }while(!ok);
                        

                        Smycken smy = new Smycken(getDataOfJewelsSecondRow[0], getDataOfJewelsSecondRow[1], d, typeOfObject2Jewels.getText());
                        p.addThing(smy);
                          
                          
                        }
                   }
                          
                    
                    if(checkTypeOfObjectChosen[1].equals("Stock")){
                        
// Om andra raden är Stock i första diaglogrutan skall ett Stock-objekt läggas till
                        
                        boolean ok;
                        double d = 0.0;
                        do{
                            ok=true;
                            try{
                                d = Double.parseDouble(valueOfStocks2.getText());
                            }
                            catch (NumberFormatException ex){
                                String str = JOptionPane.showInputDialog(null,  "The price of the Stock must be a number! ",
                                    "InputError",JOptionPane.WARNING_MESSAGE);
                                valueOfStocks2.setText(str);
                                ok=false;
                            }
                        
                        
                        }while(!ok);
                        int in = 0;
                        do{
                            ok=true;
                            try{
                                in = Integer.parseInt(amountOfStocks2.getText());
                            }
                            catch (NumberFormatException ex){
                                String str = JOptionPane.showInputDialog(null,  "The number of Stocks must be a number! ",
                                    "InputError",JOptionPane.WARNING_MESSAGE);
                                amountOfStocks2.setText(str);
                                ok=false;
                            }
                        
                        
                        }while(!ok);

                        Aktier akt = new Aktier(typeOfObject2Stocks.getText(), d , in);
                        p.addThing(akt);
                        
                        

                    }
                    if(checkTypeOfObjectChosen[2].equals("Select Item")){
// Om tredje raden är Select Item i första diaglogrutan skall ingenting läggas till, och därmed görs ingenting                  
                    }
                    if(checkTypeOfObjectChosen[2].equals("Device")){
// Om tredje raden är Device i första diaglogrutan skall ett Apparater-objekt läggas till
                        if(getDataOfDeviceThirdRow[0].equals("Select Type")|| getDataOfDeviceThirdRow[1].equals("Select Condition")){
                            JOptionPane.showMessageDialog(null, 
                                    "You must select both what type of device and the condition of the device! "
                                    + "\nItem will not be added to person!",
                                    "InputError",JOptionPane.WARNING_MESSAGE);
                        }
                        else{
                            boolean ok;
                            double d2 = 0.0;
                            do{
                                ok=true;
                                try{
                                 d2 = Double.parseDouble(priceOfDevice3.getText());
                                }
                                catch (NumberFormatException ex){
                                    String str = JOptionPane.showInputDialog(null,  "The Price of the Device must be a number! ",
                                    "InputError",JOptionPane.WARNING_MESSAGE);
                                    priceOfDevice3.setText(str);
                                    ok=false;
                            }
                        
                        
                        }while(!ok);
                        double d = Double.parseDouble(getDataOfDeviceThirdRow[1]);
                        Apparater app = new Apparater(getDataOfDeviceThirdRow[0], d, d2, typeOfObject3Device.getText());
                        p.addThing(app);
                        }
                        
                    }
                    if(checkTypeOfObjectChosen[2].equals("Jewlery")){
// Om tredje raden är Jewlery i första diaglogrutan skall ett Smycken-objekt läggas till 
                        if(getDataOfJewelsFirstRow[0].equals("Select Type")|| getDataOfJewelsFirstRow[1].equals("Select Material")){
                            JOptionPane.showMessageDialog(null, 
                                    "You must select both what type of jewlery and the type material! "
                                    + "\nItem will not be added to person!",
                                    "InputError",JOptionPane.WARNING_MESSAGE);
                        }
                        
                        
                          else{
                                boolean ok;
                                int d = 0;
                                do{
                                    ok=true;
                                    try{
                                        d = Integer.parseInt(numberOfJewels3.getText());
                                    }
                                    catch (NumberFormatException ex){
                                        String str = JOptionPane.showInputDialog(null,  "The number of gems must be a number! ",
                                        "InputError",JOptionPane.WARNING_MESSAGE);
                                        numberOfJewels3.setText(str);
                                        ok=false;
                                    }
                        
                        
                                }while(!ok);
                        

                        Smycken smy = new Smycken(getDataOfJewelsThirdRow[0], getDataOfJewelsThirdRow[1], d, typeOfObject3Jewels.getText());
                        p.addThing(smy);

                          }
                          
                    }
                    if(checkTypeOfObjectChosen[2].equals("Stock")){
                        
// Om tredje raden är Stock i första diaglogrutan skall ett Aktier-objekt läggas till
                        
                        boolean ok;
                        double d = 0.0;
                        do{
                            ok=true;
                            try{
                                d = Double.parseDouble(valueOfStocks3.getText());
                            }
                            catch (NumberFormatException ex){
                                    String str = JOptionPane.showInputDialog(null,  "The price of the Stock must be a number! ",
                                    "InputError",JOptionPane.WARNING_MESSAGE);
                                    valueOfStocks3.setText(str);
                                    ok=false;
                            }
                        
                        
                        }while(!ok);
                            int in = 0;
                            do{
                                ok=true;
                                try{
                                    in = Integer.parseInt(amountOfStocks3.getText());
                                }
                                catch (NumberFormatException ex){
                                    String str = JOptionPane.showInputDialog(null,  "The number of Stocks must be a number! ",
                                    "InputError",JOptionPane.WARNING_MESSAGE);
                                    amountOfStocks3.setText(str);
                                    ok=false;
                                }
                        
                        
                            }while(!ok);

                        Aktier akt = new Aktier(typeOfObject3Stocks.getText(), d , in);
                        p.addThing(akt);


                    }

                }
                    
                }
                else{
//Gör ingenting om man väljer No i dialogrutan, så att man kan ändra den data man har
                }
            }
          
//Om man väljer Exit i menyn               
            if (source == Exit){ 
		Object[] options = {"Yes",
		                    "No"};
//Skapar en dialogruta med "special"-knappar och varningssymbol
		int n = JOptionPane.showOptionDialog(null,
		    "Are your sure you want to exit?\n"+
		    "Press No to return to the program",
		    "Exit Prylregister",
		    JOptionPane.YES_NO_OPTION,
		    JOptionPane.WARNING_MESSAGE,
		    null,
		    options,
                    options[0]);
// Om svaret i dialogrutan är "Yes"                
		    if (n==0){

			System.exit(0);
                    }
// Om svaret i dialogrutan är "No"                    
		    if (n==1){
		    /*Gör ingenting*/}
             }
// Om man klickar på New Person i menyn
            if(source==newPerson){

                scroll.setMinimumSize(new Dimension(557,121));
                scroll.setPreferredSize(new Dimension(557,121));
                scroll.setViewportView(createPersonPanel);

                show();
            }
// Om man klickar på About i menyn
            if(source==About){
                scroll.setMinimumSize(new Dimension(557,150));
                scroll.setPreferredSize(new Dimension(557,150));
                aboutScreen.setEditable(false);
                scroll.setViewportView(aboutScreen);
                show();
            } 
// Om man klickar på User Manual i menyn
            if(source==userManual){
                scroll.setPreferredSize(new Dimension(557,150));
                scroll.setMinimumSize(new Dimension(557,150));
                scroll.setViewportView(userManualScreen);
                show();
            } 
            if(source==addItem){
                scroll.setPreferredSize(new Dimension(557,150));
                scroll.setMinimumSize(new Dimension(557,150));
                scroll.setViewportView(addItemPanel);
                show();
            } 
            if(source==button7SaveItem){
                 
                 Object[] options = {"Yes",
		                    "No"};
		int n = JOptionPane.showOptionDialog(null,
		    "Are your sure you want to save this item to this person?\n"+
		    "Press No to return to the program and alter entry",
		    "Add Item",
		    JOptionPane.YES_NO_OPTION,
		    JOptionPane.WARNING_MESSAGE,
		    null,
		    options,
                    options[0]);
//Om man väljer Yes i dialogrutan och vill spara  
                  if(n==0){
                    int indexOfPerson = 0;
                    boolean check= false;
                    String nameOfPerson = addItemName.getText();
                    addItemName.setText("");
                    
                    if(personList.isEmpty()){
                        JOptionPane.showMessageDialog(null,
                                "Command Failed.\nYou do not have any persons in your register.",
                                "Error Message",
                                JOptionPane.WARNING_MESSAGE);
                                check = false;
                    }
                    else{
                    
                        for(int i =0;personList.size()>i;i++){
                       
                            if(nameOfPerson.equalsIgnoreCase(personList.get(i).getName())){
                                indexOfPerson=i;
                                check=true;
                                break;
                               
                            }
                            else{
                                
                            check = false;
                            
                            }
                        }
                    
                    
                    }


                    if(check==false){JOptionPane.showMessageDialog(null,
                                "Command Failed.\nThe name you wrote do not match any of the names in the register.",
                                "Error Message",
                                JOptionPane.WARNING_MESSAGE);
                    }
                    if(check==true){
                        if(checkTypeOfObjectChosen[3].equals("Select Item")){
// Om första raden är Select Item i första diaglogrutan skall ingenting läggas till, och därmed görs ingenting
                            JOptionPane.showMessageDialog(null,
                                "Command Failed.\nYou have not selected an item to add.",
                                "Error Message",
                                JOptionPane.WARNING_MESSAGE);
                        }
                        if(checkTypeOfObjectChosen[3].equals("Device")){
// Om första raden är Device i första diaglogrutan skall ett Device-object läggas till personen vi skapat
                            if(getDataOfDeviceAddItem[0].equals("Select Type")|| getDataOfDeviceAddItem[1].equals("Select Condition")){
                                JOptionPane.showMessageDialog(null, 
                                    "You must select both what type of device and the condition of the device! ",
                                    "InputError",JOptionPane.WARNING_MESSAGE);
                        }
                        else{
                            boolean ok;
                            double d2 = 0.0;
                            do{
                                ok=true;
                                try{
                                    d2 = Double.parseDouble(priceOfDevice4.getText());
                                }
                                catch (NumberFormatException ex){
                                    String str = JOptionPane.showInputDialog(null,  "The Price of the Device must be a number! ",
                                    "InputError",JOptionPane.WARNING_MESSAGE);
                                    priceOfDevice4.setText(str);
                                    ok=false;
                            }
                        
                        
                            }while(!ok);
                        
                        double d = Double.parseDouble(getDataOfDeviceAddItem[1]);
                        Apparater app = new Apparater(getDataOfDeviceAddItem[0], d, d2, typeOfObject4Device.getText());
                        personList.get(indexOfPerson).addThing(app);
                        }
          
                    }
                    if(checkTypeOfObjectChosen[3].equals("Jewlery")){

                        if(getDataOfDeviceAddItem[0].equals("Select Type")|| getDataOfDeviceAddItem[1].equals("Select Material")){
                            JOptionPane.showMessageDialog(null, 
                                    "You must select both what type of jewlery and the type material! ",
                                    "InputError",JOptionPane.WARNING_MESSAGE);
                        }

                        else{
                                boolean ok;
                                int d = 0;
                                do{
                                    ok=true;
                                    try{
                                        d = Integer.parseInt(numberOfJewels4.getText());
                                    }
                                    catch (NumberFormatException ex){
                                        String str = JOptionPane.showInputDialog(null,  "The number of gems must be a number! ",
                                        "InputError",JOptionPane.WARNING_MESSAGE);
                                        numberOfJewels4.setText(str);
                                        ok=false;
                                    }
                        
                        
                                }while(!ok);
// Om första raden är Jewlery i första diaglogrutan skall ett Smycken-object läggas till
                        Smycken smy = new Smycken(getDataOfJewelsAddItem[0], getDataOfJewelsAddItem[1], d, typeOfObject4Jewels.getText());
                        personList.get(indexOfPerson).addThing(smy);

                        }

                    }
                    if(checkTypeOfObjectChosen[3].equals("Stock")){
                        boolean ok;
                        double d = 0.0;
                        do{
                            ok=true;
                            try{
                                d = Double.parseDouble(valueOfStocks4.getText());
                            }
                            catch (NumberFormatException ex){
                                String str = JOptionPane.showInputDialog(null,  "The price of the Stock must be a number! ",
                                    "InputError",JOptionPane.WARNING_MESSAGE);
                                valueOfStocks4.setText(str);
                                ok=false;
                            }
                        
                        
                        }while(!ok);
                        int in = 0;
                        do{
                            ok=true;
                            try{
                                in = Integer.parseInt(amountOfStocks4.getText());
                            }
                            catch (NumberFormatException ex){
                                String str = JOptionPane.showInputDialog(null,  "The number of Stocks must be a number! ",
                                    "InputError",JOptionPane.WARNING_MESSAGE);
                                amountOfStocks4.setText(str);
                                ok=false;
                            }
                        
                        
                        }while(!ok);
// Om första raden är Stock i första diaglogrutan skall ett Aktier-objekt läggas till 
                        Aktier akt = new Aktier(typeOfObject4Stocks.getText(), d , in);
                        personList.get(indexOfPerson).addThing(akt);
                    }
                    
                    
                    
                }
                    
                }
                else{
//Gör ingenting om man väljer No i dialogrutan, så att man kan ändra den data man har
                }              
                
                
                
                
            }
      }  
        
//Överskuggning av metoden itemStateChanged



     public void itemStateChanged(ItemEvent evt) {
        Object source = evt.getSource();
        
        if(source ==JCB1){
//Om något i JComboboxen JCB1 är valt
            if (evt.getStateChange() == ItemEvent.SELECTED) {            
                String item = (String)JCB1.getSelectedItem();
                if(item.equals("Select Item")){
                    createPersonScroll.setMinimumSize(new Dimension(100,10));
                    createPersonScroll.setPreferredSize(new Dimension(100,25));
                    createPersonScroll.setViewportView(emptyPanelFirstRow);
                    checkTypeOfObjectChosen[0] = (String)JCB1.getSelectedItem();
                }
                if(item.equals("Device")){
                    createPersonScroll.setMinimumSize(new Dimension(100,10));
                    createPersonScroll.setPreferredSize(new Dimension(100,25));
                    createPersonScroll.setViewportView(devicePanelFirstRow);
                    priceOfDevice.setText("Write original price of device here");
                    typeOfObjectDevice.setText("Write specific device here");
                    checkTypeOfObjectChosen[0] = (String)JCB1.getSelectedItem();


                }
                if (item.equals("Jewlery")){
                    createPersonScroll.setMinimumSize(new Dimension(100,10));
                    createPersonScroll.setPreferredSize(new Dimension(100,25));
                    createPersonScroll.setViewportView(jewelPanelFirstRow);
                    typeOfObjectJewels.setText("Write specific jewel here");
                    numberOfJewels1.setText("Write number of gems here");
                    checkTypeOfObjectChosen[0] = (String)JCB1.getSelectedItem();

                }
                if (item.equals("Stock")){
                    createPersonScroll.setMinimumSize(new Dimension(100,10));
                    createPersonScroll.setPreferredSize(new Dimension(100,25));
                    createPersonScroll.setViewportView(stockPanelFirstRow);
                    valueOfStocks1.setText("Write value of stocks here");
                    typeOfObjectStocks.setText("Write company name here");
                    amountOfStocks1.setText("Write number of stocks here");
                    checkTypeOfObjectChosen[0] = (String)JCB1.getSelectedItem();
                }
            }
        }
        if(source ==JCB2){
//Om något i JComboboxen JCB2 är valt
            if (evt.getStateChange() == ItemEvent.SELECTED) {            
                String item =(String) JCB2.getSelectedItem();
                
                 if(item.equals("Select Item")){
                    createPersonScroll2.setMinimumSize(new Dimension(100,10));
                    createPersonScroll2.setPreferredSize(new Dimension(100,25));
                    createPersonScroll2.setViewportView(emptyPanelSecondRow);
                    checkTypeOfObjectChosen[1] = (String)JCB2.getSelectedItem();

                }
                if(item.equals("Device")){
                    createPersonScroll2.setMinimumSize(new Dimension(100,10));
                    createPersonScroll2.setPreferredSize(new Dimension(100,25));
                    createPersonScroll2.setViewportView(devicePanelSecondRow);
                    priceOfDevice2.setText("Write original price of device here");
                    typeOfObject2Device.setText("Write specific device here"); 
                    checkTypeOfObjectChosen[1] = (String)JCB2.getSelectedItem();
            
                }
                if (item.equals("Jewlery")){
                    createPersonScroll2.setMinimumSize(new Dimension(100,10));
                    createPersonScroll2.setPreferredSize(new Dimension(100,25));
                    createPersonScroll2.setViewportView(jewelPanelSecondRow);
                    typeOfObject2Jewels.setText("Write specific jewel here");
                    numberOfJewels2.setText("Write number of gems here");
                    checkTypeOfObjectChosen[1] = (String)JCB2.getSelectedItem();
            
                }
                if (item.equals("Stock")){
                    createPersonScroll2.setMinimumSize(new Dimension(100,10));
                    createPersonScroll2.setPreferredSize(new Dimension(100,25));
                    createPersonScroll2.setViewportView(stockPanelSecondRow);
                    valueOfStocks2.setText("Write value of stocks here");
                    typeOfObject2Stocks.setText("Write company name here");
                    amountOfStocks2.setText("Write number of stocks here");
                    checkTypeOfObjectChosen[1] = (String)JCB2.getSelectedItem();
                }
            }
        }
        if(source ==JCB3){
//Om något i JComboboxen JCB2 är valt
            if (evt.getStateChange() == ItemEvent.SELECTED) {            
                String item = (String)JCB3.getSelectedItem();
                
                 if(item.equals("Select Item")){
                    createPersonScroll3.setMinimumSize(new Dimension(100,10));
                    createPersonScroll3.setPreferredSize(new Dimension(100,25));
                    createPersonScroll3.setViewportView(emptyPanelThirdRow);
                    checkTypeOfObjectChosen[2] = (String)JCB3.getSelectedItem();

                }
                if(item.equals("Device")){
                    createPersonScroll3.setMinimumSize(new Dimension(100,10));
                    createPersonScroll3.setPreferredSize(new Dimension(100,25));
                    createPersonScroll3.setViewportView(devicePanelThirdRow);
                    priceOfDevice3.setText("Write original price of device here");
                    typeOfObject3Device.setText("Write specific device here");
                    checkTypeOfObjectChosen[2] = (String)JCB3.getSelectedItem();
            
                }
                if (item.equals("Jewlery")){
                    createPersonScroll3.setMinimumSize(new Dimension(100,10));
                    createPersonScroll3.setPreferredSize(new Dimension(100,25));
                    createPersonScroll3.setViewportView(jewelPanelThirdRow);
                    typeOfObject3Jewels.setText("Write specific jewels here");
                    numberOfJewels3.setText("Write number of gems here");
                    checkTypeOfObjectChosen[2] = (String)JCB3.getSelectedItem();
            
                }
                if (item.equals("Stock")){
                    createPersonScroll3.setMinimumSize(new Dimension(100,10));
                    createPersonScroll3.setPreferredSize(new Dimension(100,25));
                    createPersonScroll3.setViewportView(stockPanelThirdRow);
                    valueOfStocks3.setText("Write value of stocks here");
                    typeOfObject3Stocks.setText("Write company name here");
                    amountOfStocks3.setText("Write number of stocks here");
                    checkTypeOfObjectChosen[2] = (String)JCB3.getSelectedItem();
                }
            }
        }
        
// Om utlösaren är JCB4JewelType        
        if(source ==JCB4JewelType){
           if (evt.getStateChange() == ItemEvent.SELECTED) {            
           getDataOfJewelsFirstRow[0] = (String)JCB4JewelType.getSelectedItem();
           
           }
        }
//Om utlösaren är JCB9JewelType
        if(source ==JCB9JewelType){
           if (evt.getStateChange() == ItemEvent.SELECTED) {            
           getDataOfJewelsSecondRow[0]= (String)JCB9JewelType.getSelectedItem();
           }        
        } 
//Om utlösaren är JCB10JewelType
        if(source ==JCB10JewelType){
           if (evt.getStateChange() == ItemEvent.SELECTED) {            
           getDataOfJewelsThirdRow[0]=(String)JCB10JewelType.getSelectedItem();
           
           }
        } 
        if(source ==JCB5JewelMaterial){
           if (evt.getStateChange() == ItemEvent.SELECTED) {            
           getDataOfJewelsFirstRow[1] = (String)JCB5JewelMaterial.getSelectedItem();
           }
        } 
        if(source ==JCB11JewelMaterial){
           if (evt.getStateChange() == ItemEvent.SELECTED) {            
            getDataOfJewelsSecondRow[1]=(String)JCB11JewelMaterial.getSelectedItem();
           
           }
        } 
        if(source ==JCB12JewelMaterial){
           if (evt.getStateChange() == ItemEvent.SELECTED) {            
            getDataOfJewelsThirdRow[1] = (String)JCB12JewelMaterial.getSelectedItem();
           
           }
        } 
        if(source ==JCB6ElectricOrNot){
           if (evt.getStateChange() == ItemEvent.SELECTED) { 
             getDataOfDeviceFirstRow[0]=(String)JCB6ElectricOrNot.getSelectedItem();
           
           }
        }  
        if(source ==JCB7ElectricOrNot){
           if (evt.getStateChange() == ItemEvent.SELECTED) {            
            getDataOfDeviceSecondRow[0]= (String)JCB7ElectricOrNot.getSelectedItem();
           }
        }  
        if(source ==JCB8ElectricOrNot){
           if (evt.getStateChange() == ItemEvent.SELECTED) {            
           getDataOfDeviceThirdRow[0] = (String)JCB8ElectricOrNot.getSelectedItem();
    
           }
        }  
        if(source ==JCB13Worn){
           if (evt.getStateChange() == ItemEvent.SELECTED) {  
             getDataOfDeviceFirstRow[1]=(String)JCB13Worn.getSelectedItem();
          
           }
        }  
        if(source ==JCB14Worn){
           if (evt.getStateChange() == ItemEvent.SELECTED) {            
           getDataOfDeviceSecondRow[1] = (String)JCB14Worn.getSelectedItem();
          
           
           }
        }  
        if(source ==JCB15Worn){
           if (evt.getStateChange() == ItemEvent.SELECTED) {            
           getDataOfDeviceThirdRow[1]= (String)JCB15Worn.getSelectedItem();
           
           }
        } 
         if(source ==JCB16){
          if (evt.getStateChange() == ItemEvent.SELECTED) {            
                String item = (String)JCB16.getSelectedItem();
                
                 if(item.equals("Select Item")){
                    addItemScroll.setMinimumSize(new Dimension(100,10));
                    addItemScroll.setPreferredSize(new Dimension(100,25));
                    addItemScroll.setViewportView(addItemEmptyPanel);
                    checkTypeOfObjectChosen[3] = (String)JCB16.getSelectedItem();

                }
                if(item.equals("Device")){
                    addItemScroll.setMinimumSize(new Dimension(100,10));
                    addItemScroll.setPreferredSize(new Dimension(100,25));
                    addItemScroll.setViewportView(addItemDevicePanel);
                    priceOfDevice4.setText("Write original price of device here");
                    typeOfObject4Device.setText("Write specific device here");
                    checkTypeOfObjectChosen[3] = (String)JCB16.getSelectedItem();
            
                }
                if (item.equals("Jewlery")){
                    addItemScroll.setMinimumSize(new Dimension(100,10));
                    addItemScroll.setPreferredSize(new Dimension(100,25));
                    addItemScroll.setViewportView(addItemJewelsPanel);
                    typeOfObject4Jewels.setText("Write specific jewels here");
                    numberOfJewels4.setText("Write number of gems here");
                    checkTypeOfObjectChosen[3] = (String)JCB16.getSelectedItem();
            
                }
                if (item.equals("Stock")){
                    addItemScroll.setMinimumSize(new Dimension(100,10));
                    addItemScroll.setPreferredSize(new Dimension(100,25));
                    addItemScroll.setViewportView(addItemStocksPanel);
                    valueOfStocks4.setText("Write value of stocks here");
                    typeOfObject4Stocks.setText("Write company name here");
                    amountOfStocks4.setText("Write number of stocks here");
                    checkTypeOfObjectChosen[3] = (String)JCB16.getSelectedItem();
                }
            }
         }  
         
          if(source ==JCB19JewelType){
             if (evt.getStateChange() == ItemEvent.SELECTED) {            
                    getDataOfJewelsAddItem[0]=(String)JCB19JewelType.getSelectedItem();
           
             }
         
         }
         
         if(source ==JCB18AddJewelMaterial){
              if (evt.getStateChange() == ItemEvent.SELECTED) {            
                   getDataOfJewelsAddItem[1] = (String)JCB18AddJewelMaterial.getSelectedItem();
           
           }

         }

         if(source ==JCB20ElectricOrNot){
                if (evt.getStateChange() == ItemEvent.SELECTED) {            
                    getDataOfDeviceAddItem[0]= (String)JCB20ElectricOrNot.getSelectedItem();
           
                }
         
         }
         if(source ==JCB21Worn){
                if (evt.getStateChange() == ItemEvent.SELECTED) {            
                    getDataOfDeviceAddItem[1]= (String)JCB21Worn.getSelectedItem();
           
                }
         
         
         }

    }
    
    
    
    
}







