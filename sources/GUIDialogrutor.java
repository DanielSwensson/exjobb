

import java.io.File;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import Graph.*;

public class GUIDialogrutor {

	final static int radius = 15;
	private static String från = null, till = null;
	
	static void HittaMarkerade(){
		int antal = 0;
		for (GUINod n : GUI.platslista) {
			if (n.GetMarkerad() == true && antal == 0) {
				från = n.GetPlats();
				antal += 1;
			} else if (n.GetMarkerad() == true && antal == 1) {
				till = n.GetPlats();
				antal += 1;
			} else if (antal == 2)
				break;	
		}
	}

	static void Nyplats(int x, int y) {
		JPanel rad1;
		JPanel nyform;
		JTextField plats;

		nyform = new JPanel();
		nyform.setLayout(new BoxLayout(nyform, BoxLayout.Y_AXIS));

		rad1 = new JPanel();
		plats = new JTextField(10);
		rad1.add(new JLabel("Platsens namn: "));
		rad1.add(plats);
		nyform.add(rad1);

		for (;;) {

			int svar = JOptionPane.showConfirmDialog(null, nyform, "Ny plats",
					JOptionPane.OK_CANCEL_OPTION);
			try {
				String p = plats.getText();
				if (svar == 2 || svar == 1 || svar == -1) {
					break;
				}

				if (svar == JOptionPane.YES_OPTION) {
					if (p.equals("")) {
						fel("Mata in plats");
					}
					else if(Pathfinder.l.NodeExists(p) == true){
						fel("Platsnamnet är upptaget!");	
					}

					else {
						{
							Pathfinder.l.add(p);
							GUINod n = new GUINod(x - (radius / 2), y
									- (radius / 2), p);
							GUI.kartbild.add(n);
							GUI.platslista.add(n);
							GUI.kartbild.repaint();
						}
						
						break;
					}

				}

			}

			catch (NumberFormatException e) {
				fel("Mata in giltiga värden!");

			}

		}

	}

	static void nytt() {
		

		
		String wd = System.getProperty("user.dir");
		JFileChooser fc = new JFileChooser(wd);
		fc.setCurrentDirectory(new File(wd + "/kartor"));
		int rc = fc.showDialog(null, "Öppna");
		if (rc == JFileChooser.APPROVE_OPTION) {

			File file = fc.getSelectedFile();
			String filename = file.getAbsolutePath();
			ImageIcon karta = new ImageIcon(filename);
			GUI.platslista.clear();
			GUI.kartbild.removeAll();
			GUINod.antalmarkerade = 0;

			Pathfinder.l.EraseAll();
			GUI.kartbild.setIcon(karta);
			GUI.kartafinns = true;
			
		} 
		return;

	}

	static void fel(String f) {
		JOptionPane fel = new JOptionPane();
		JOptionPane.showMessageDialog(fel, f);
	}

	static void Nyforbindelse() {
		JPanel rad1, rad2, rad3;
		JPanel nyform;
		JTextField namn, tid;
		
		HittaMarkerade();
		nyform = new JPanel();
		nyform.setLayout(new BoxLayout(nyform, BoxLayout.Y_AXIS));

		rad1 = new JPanel();
		rad1.add(new JLabel("Förbindelse mellan " + från + " och " + till));

		nyform.add(rad1);

		rad2 = new JPanel();
		namn = new JTextField(10);
		rad2.add(new JLabel("Namn: "));
		rad2.add(namn);
		nyform.add(rad2);

		rad3 = new JPanel();
		tid = new JTextField(5);
		rad3.add(new JLabel("Tid: "));
		rad3.add(tid);
		nyform.add(rad3);

		for (;;) {

			int svar = JOptionPane.showConfirmDialog(null, nyform,
					"Ny förbindelse", JOptionPane.OK_CANCEL_OPTION);

			if (svar == 2 || svar == 1 || svar == -1) {
				break;
			}
			try {
				String n = namn.getText();
				int t = Integer.parseInt(tid.getText());
				if (svar == JOptionPane.YES_OPTION) {
					if (n.equals("")) {
						fel("Mata in en förbindelse");
					}

					else {
						
						Pathfinder.l.connect(från,till,n,t);
						
				
						break;
					}

				}

			}

			catch (NumberFormatException e) {
				fel("Mata in giltiga värden!");

			}
			catch(java.util.NoSuchElementException e){
				fel("Kan inte hitta noderna!");
			}
			catch(IllegalArgumentException e){
				fel("Tiden måste vara positiv!");
			}

		}

	}

	static void Visaforbindelse() {

		JPanel rad1, rad2;
		JPanel nyform;
		JTextArea plats;
	
		HittaMarkerade();

		
		nyform = new JPanel();
		nyform.setLayout(new BoxLayout(nyform, BoxLayout.Y_AXIS));

		rad1 = new JPanel();

		rad1.add(new JLabel("Förbindelse från " + från + " till " + till));
		
		nyform.add(rad1);

		rad2 = new JPanel();

		plats = new JTextArea(15, 25);
		plats.setEditable(false);
		rad2.add(plats);
		String str = "";
		if( GraphMethods.pathExists(Pathfinder.l,från,till) == false){
			fel("Finns ingen förbindelse!");
			
			}
		else{
		try{
		for(Edge<String> e: Pathfinder.l.getEdgesBetween(från, till)){
			str+=e +"\n";
		}
		}
		catch(java.util.NoSuchElementException e){
			fel("Kan inte hitta noderna!");
		}
		plats.setText(str);
		
		
		nyform.add(rad2);
		JOptionPane.showConfirmDialog(null, nyform, "Visa förbindelse",
				JOptionPane.PLAIN_MESSAGE);
		}
	}

	static void Hittaväg() {
		
		JPanel rad;
		JPanel nyform;
		JTextArea plats;
		HittaMarkerade();
		
		nyform = new JPanel();
		nyform.setLayout(new BoxLayout(nyform, BoxLayout.Y_AXIS));

		rad = new JPanel();

		plats = new JTextArea(15, 25);
		
		plats.setEditable(false);
		
		rad.add(plats);
		nyform.add(rad);
		int totaltid=0;
		
		
		if( GraphMethods.pathExists(Pathfinder.l,från,till) == false){
			fel("Finns ingen förbindelse!");
			
			}
		else{
			String str = "Från " + från + " till " + till + "\n";
			for(Edge<String> n: GraphMethods.shortestPath(Pathfinder.l, från, till)){
				str+=n + "\n";
				totaltid +=n.GetVikt();
			}
			
			str+= "Totalt " + totaltid;
			
			plats.setText(str);
		JOptionPane.showConfirmDialog(null, nyform, "Snabbaste vägen",
				JOptionPane.PLAIN_MESSAGE);
		}
	}
	
	static void Ändraförbindelse(){
		JPanel rad1, rad2;
		JPanel nyform;
	
		HittaMarkerade();

		
		nyform = new JPanel();
		nyform.setLayout(new BoxLayout(nyform, BoxLayout.Y_AXIS));

		rad1 = new JPanel();

		rad1.add(new JLabel("Förbindelse(r) från " + från + " till " + till));
		nyform.add(rad1);

		rad2 = new JPanel();
		
		JList list = new JList(Pathfinder.l.getEdgesBetween(från, till).toArray());

		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		rad2.add(list);
		
		nyform.add(rad2);
		
		for(;;){
		if( GraphMethods.pathExists(Pathfinder.l,från,till) == false || GraphMethods.pathExists(Pathfinder.l,från,till) == false){
			fel("Finns ingen förbindelse!");
			break;
			}
		int svar = JOptionPane.showConfirmDialog(null, nyform, "Ändra förbindelse",
				JOptionPane.OK_CANCEL_OPTION);
		if (svar == 2 || svar == 1 || svar == -1) {
			break;
		}
		
		
		if (svar == JOptionPane.YES_OPTION) {
			
			String vald = list.getSelectedValue().toString();
			
			Ändraedge(vald);
			break;
			
		}		
		else
			fel("Markera en förbindelse!");
			
		
		}
		
	}
	static void Ändraedge(String vald){
		JPanel rad1, rad2, rad3;
		JPanel nyform;
		JTextField namn, tid;
		
		HittaMarkerade();

		nyform = new JPanel();
		nyform.setLayout(new BoxLayout(nyform, BoxLayout.Y_AXIS));

		rad1 = new JPanel();
		rad1.add(new JLabel("Ändra förbindelse mellan " + från + " och " + till));
		
		Edge<String> e = Pathfinder.l.GetEdge(från,vald);
		nyform.add(rad1);

		rad2 = new JPanel();
		namn = new JTextField(10);
		namn.setText(e.getNamn());
		namn.setEnabled(false);
		rad2.add(new JLabel("Namn: "));
		rad2.add(namn);
		nyform.add(rad2);

		rad3 = new JPanel();
		tid = new JTextField(5);
		tid.setText(""+e.GetVikt());

		rad3.add(new JLabel("Tid: "));
		rad3.add(tid);
		nyform.add(rad3);

		for (;;) {

			int svar = JOptionPane.showConfirmDialog(null, nyform,
					"Ändra tid", JOptionPane.OK_CANCEL_OPTION);
			
			
			try {
				int t = Integer.parseInt(tid.getText());
				if (svar == 2 || svar == 1 || svar == -1) {
					break;
				}
				
				else{
					e.SetVikt(t);
					break;
				}
				
			}catch(NumberFormatException ex) {
				fel("Mata in giltiga värden!");
				
			}
			catch(IllegalArgumentException ex){
				fel("Tid får inte vara negativt!");
			}
			
		}
		
	}

}
