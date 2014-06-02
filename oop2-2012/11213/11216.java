import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

public class Gui extends JFrame implements ActionListener {
	
	JButton b1, b2, b3, b4, b5, b6, b7;
	
	static JPanel panel = new JPanel();
	static JPanel buttonPanel = new JPanel();
	static JPanel textPanel = new JPanel();

	JFrame newPanel = new JFrame();
	
	JButton addNewPerson = new JButton("LÄGG TILL NY PERSON");
	JButton showSpecifikPerson = new JButton("VISA SPECIFIK PERSON");
	
	JRadioButton yesButton   = new JRadioButton("Ja"  , true);
	JRadioButton noButton    = new JRadioButton("Nej"   , false);
	
	static JTextArea textArea;

	public Gui() {
		
		this.setTitle("REGISTER");
		this.setSize(500,450);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel.setLayout(new GridLayout(2,0));
		
		createButtonPanel();
		createTextPanel();
		
		this.add(panel);
		this.setVisible(true);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		
	}

	private GridBagConstraints setCon(int xPos, int yPos, int width, int height) {
		
		GridBagConstraints con = new GridBagConstraints();
		
		con.gridx = xPos;
		con.gridy = yPos;
		con.gridwidth = width;
		con.gridheight = height;
		con.fill = GridBagConstraints.BOTH;
		con.insets = new Insets(5,5,5,5);
		
		return con;
	}
	
	public void createButtonPanel() {

		buttonPanel.setLayout(new GridBagLayout());
		GridBagConstraints con = new GridBagConstraints();
		
		b1 = new JButton("NY PERSON");
		b2 = new JButton("NY PRYL");
		b3 = new JButton("VISA SPECIFIK PERSON");
		b4 = new JButton("VISA ALLA PERSONER");
		b5 = new JButton("VISA RIKASTE");
		b6 = new JButton("BÖRSKRASCH");
		b7 = new JButton("AVSLUTA");
		
		
		con = setCon(0,0,1,1);
		buttonPanel.add(b1,con);
		
		con = setCon(1,0,1,1);
		buttonPanel.add(b2, con);
		
		con = setCon(0,1,1,1);
		buttonPanel.add(b3,con);
		
		con = setCon(1,1,1,1);
		buttonPanel.add(b4,con);
		
		con = setCon(0,2,1,1);
		buttonPanel.add(b5,con);
		
		con = setCon(1,2,1,1);
		buttonPanel.add(b6,con);
		
		con = setCon(0,3,2,1);
		buttonPanel.add(b7, con);
		
		panel.add(buttonPanel);	
	}
	
	public void createTextPanel() {
		
		textArea = new JTextArea(8, 30);
		
		textPanel.add(textArea);
		
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		textArea.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		
		JScrollPane scroll = new JScrollPane(textArea); 
		
		panel.add(scroll);	
	}
	
	public JLabel newLine() {
		JLabel n = new JLabel();
		n.setText("");
		return n;
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == b1) {  // LÄGG TILL PERSON
			Register.addPerson();
		}

		else if (e.getSource()== b2) {	//NY PRYL
			Register.newThing();	
		}
			
		else if (e.getSource() == b3) {	// VISA SPECIFIK PERSON
			textArea.setText("");
			Register.showSpecifikPerson();
		}

		else if (e.getSource() == b4) { // VISA ALLA PERSONER
			textArea.setText("");
			for (Person i : Register.allPersons)
				i.printTotalValue();
		}

		else if (e.getSource() == b5) { // VISA RIKASTE
				Register.showRichestPerson();
		}

		else if (e.getSource() == b6) { // BÖRSKRASCH
			Register.stockMarketCrash();
		}

		else if (e.getSource() == b7) { // EXIT
			System.exit(0);
		}		
	}
}

