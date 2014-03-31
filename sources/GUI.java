

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;


public class GUI extends JFrame {
	
	private static final long serialVersionUID = 1L;
	final String[] knappar = { "Hitta väg", "Visa förbindelse", "Ny plats",
			"Ny förbindelse", "Ändra förbindelse" };
	final String[] Arkiv = { "Nytt", "Avsluta" };
	public static JLabel kartbild;
	private  JPanel knapppan;
	static JPanel kartpan;
	public static ArrayList<GUINod> platslista = new ArrayList<GUINod>();
	public static boolean kartafinns = false;
	int x, y;

	 public GUI() {
		super("Pathfinder");
		setBackground(Color.BLACK);
		knapppan = new JPanel();
		kartpan = new JPanel();
		getContentPane().add(knapppan, BorderLayout.NORTH);
		getContentPane().add(kartpan, BorderLayout.CENTER);
		knapplyss kl = new knapplyss();
		for (String s : knappar) {
			JButton b = new JButton(s);
			b.addActionListener(kl);
			knapppan.add(b);
		}
		menylyss ml = new menylyss();
		JMenuBar meny = new JMenuBar();
		JMenu arkiv = new JMenu("Arkiv");
		for (String s : Arkiv) {
			JMenuItem m = new JMenuItem(s);
			m.addActionListener(ml);
			arkiv.add(m);
		}
		meny.add(arkiv);
		JMenu operationer = new JMenu("Operationer");
		meny.add(operationer);
		for (String s : knappar) {
			JMenuItem m = new JMenuItem(s);
			m.addActionListener(ml);
			operationer.add(m);
		}
		setJMenuBar(meny);
		kartbild = new JLabel();
		kartpan.add(kartbild);
		setLocation(300,0);
		pack();
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	class musclick extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {
			kartbild.setCursor(Cursor
					.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			kartbild.removeMouseListener(this);
			GUIDialogrutor.Nyplats(e.getX(), e.getY());
		
		}
	}

	class knapplyss implements ActionListener {
		public void actionPerformed(ActionEvent ave) {
			JButton b = (JButton) ave.getSource();
			String str = b.getText();
			if (str.equals("Hitta väg") && kartafinns == true) {
				if (GUINod.antalmarkerade == 2)
					GUIDialogrutor.Hittaväg();
				else
					GUIDialogrutor.fel("Markera 2 platser!");
			} else if (str.equals("Visa förbindelse") && kartafinns == true) {
				if (GUINod.antalmarkerade == 2)
					GUIDialogrutor.Visaforbindelse();
				else
					GUIDialogrutor.fel("Markera 2 platser!");
			} else if (str.equals("Ny plats") && kartafinns == true) {
				kartbild.addMouseListener(new musclick());
				kartbild.setCursor(Cursor
						.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
			} else if (str.equals("Ny förbindelse") && kartafinns == true) {
				if (GUINod.antalmarkerade == 2)
					GUIDialogrutor.Nyforbindelse();
				else
					GUIDialogrutor.fel("Markera 2 platser!");
			} else if (str.equals("Ändra förbindelse") && kartafinns == true) {
				if (GUINod.antalmarkerade == 2)
					GUIDialogrutor.Ändraförbindelse();
				else
					GUIDialogrutor.fel("Markera 2 platser!");
			} else if (kartafinns == false) {
				GUIDialogrutor.fel("Ladda in en karta!");
			}
		}
	}

	class menylyss implements ActionListener {
		public void actionPerformed(ActionEvent ave) {
			JMenuItem m = (JMenuItem) ave.getSource();
			String str = m.getText();

			if (str.equals("Nytt")) {
				GUIDialogrutor.nytt();
				pack();
			} else if (str.equals("Avsluta")) {
				System.exit(0);
			} else if (str.equals("Hitta väg") && kartafinns == true) {
				if (GUINod.antalmarkerade == 2)
					GUIDialogrutor.Hittaväg();
				else
					GUIDialogrutor.fel("Markera 2 platser!");

			} else if (str.equals("Visa förbindelse") && kartafinns == true) {
				if (GUINod.antalmarkerade == 2)
					GUIDialogrutor.Visaforbindelse();
				else
					GUIDialogrutor.fel("Markera 2 platser!");

			} else if (str.equals("Ny plats") && kartafinns == true) {
				kartbild.addMouseListener(new musclick());
				kartbild.setCursor(Cursor
						.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
			} else if (str.equals("Ny förbindelse")) {
				if (GUINod.antalmarkerade == 2)
					GUIDialogrutor.Nyforbindelse();
				else
					GUIDialogrutor.fel("Markera 2 platser!");
			} else if (str.equals("Ändra förbindelse") && kartafinns == true) {
				if (GUINod.antalmarkerade == 2)
					GUIDialogrutor.Ändraförbindelse();
				else
					GUIDialogrutor.fel("Markera 2 platser!");
			} else if (kartafinns == false) {
				GUIDialogrutor.fel("Ladda in en karta!");

			}

		}
	}

}
