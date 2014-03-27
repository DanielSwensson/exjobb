import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.util.List;
import java.util.*;
import java.io.*;
import graphs.*;
import javax.swing.filechooser.*;

class Main extends JFrame{
	Karta plan = null;
	static graphs.ListGraph<String> foo = new graphs.ListGraph<String>();
	MusLyss musen = new MusLyss();
	boolean musAct=false;
				
	JFileChooser jc = new JFileChooser(".");

	Map<String,Nod> nodRef = new HashMap<String,Nod>();
	
	DefaultListModel<String> nodlist;
	JList<String> jlist;
	
	Nod n1,n2;
	
	boolean badFix=true;
	
	Main(){
		super("PathFinder");
		setResizable(false);
		FileNameExtensionFilter fnef = new FileNameExtensionFilter("Bilder","jpeg","jpg","gif","png","bmp");
		jc.addChoosableFileFilter(fnef);
		nodlist = new DefaultListModel<String>();
		
		jlist = new JList<String>(nodlist);
		jlist.setVisibleRowCount(18);
		jlist.setLayoutOrientation(JList.VERTICAL);
		jlist.setFixedCellWidth(100);
		jlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jlist.addListSelectionListener(new ListLyss());
		JPanel vpanel = new JPanel();
		vpanel.add(new JScrollPane(jlist));
		add(vpanel, BorderLayout.WEST);
		
		JMenuBar mbar = new JMenuBar();
		setJMenuBar(mbar);
		
		JMenu ark = new JMenu("Arkiv");
		mbar.add(ark);
		JMenuItem open = new JMenuItem("Ny (Karta)");
		open.addActionListener(new OpLyss());
		ark.add(open);
		JMenuItem quit = new JMenuItem("Avsluta");
		quit.addActionListener(new QuitLyss());
		ark.add(quit);
		
		JMenu oper = new JMenu("Operationer");
		JMenuItem menhV = new JMenuItem("Hitta v�g");
		JMenuItem menvF = new JMenuItem("Visa f�rbindelse");
		JMenuItem mennF = new JMenuItem("Ny f�rbindelse");
		JMenuItem mennP = new JMenuItem("Ny plats");
		JMenuItem menaF = new JMenuItem("�ndra f�rbindelse");
		oper.add(menhV);
		menhV.addActionListener(new HittaLyss());
		oper.add(menvF);
		menvF.addActionListener(new VisaLyss());
		oper.add(mennF);
		mennF.addActionListener(new NyForbLyss());
		oper.add(mennP);
		mennP.addActionListener(new NyLyss());
		oper.add(menaF);
		mbar.add(oper);
		menaF.addActionListener(new AndraLyss());
			
		JPanel knappar = new JPanel();
		knappar.setLayout(new BoxLayout(knappar,BoxLayout.X_AXIS));
		JButton hV = new JButton("Hitta v�g");
		hV.addActionListener(new HittaLyss());
		JButton vF = new JButton("Visa F�rbindelse");
		vF.addActionListener(new VisaLyss());
		JButton nP = new JButton("Ny Plats");
		nP.addActionListener(new NyLyss());
		JButton nF = new JButton("Ny F�rbindelse");
		nF.addActionListener(new NyForbLyss());
		JButton aF = new JButton("�ndra F�rbindelse");
		aF.addActionListener(new AndraLyss());
		knappar.add(nP); knappar.add(nF); knappar.add(aF);
		knappar.add(vF); knappar.add(hV);
		add(knappar,BorderLayout.NORTH);
		
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}


	class HittaLyss implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			if (checkN1N2() && plan != null){
				if (!foo.met.pathExists(foo,n1.getRef(),n2.getRef())){
					JOptionPane.showMessageDialog(null,"Det finns ingen koppling mellan dessa platser!");
					return;
				}
				List<Edge<String>> faf = foo.met.shortestPath(foo,n1.getRef(),n2.getRef());
				
				int v1 = 0;
				
				String text="Snabbaste v�gen fr�n "+n1.getRef()+" till "+n2.getRef()+" :\n";
				for (Edge<String> e : faf){
					v1+=e.getWeight();
					text+=e.toString()+"\n";
				}
				text+="Tids�tg�ng: "+v1+" minut(er)";
				JOptionPane.showMessageDialog(null,text,"Snabbaste V�gen",JOptionPane.PLAIN_MESSAGE);
			}
		}
	}

	class AndraLyss implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			if (checkN1N2() && plan!=null){
				
				DefaultListModel<String> templist1 = new DefaultListModel<String>();
				List<Edge<String>> edges = foo.getEdgesBetween(n1.getRef(),n2.getRef());
				if (edges.size()<1){
					JOptionPane.showMessageDialog(null,"Det finns inga registrerade f�rbindelser mellan dessa tv� platser!");
					return;
				}
				else if (edges.size()==1){
					�ndraForb(edges.get(0));
					return;
				}
				Map<String, Edge<String>> edgeref = new HashMap<String,Edge<String>>();
				for (Edge<String> e : edges){
					templist1.addElement(e.toString());
					edgeref.put(e.toString(),e);
				} 
				JList<String> templist2 = new JList<String>(templist1);
								
				JPanel p = new JPanel();
				p.setLayout (new BoxLayout(p,BoxLayout.Y_AXIS));
				p.add(new JLabel("F�rbindelser mellan "+n1.getRef()+" och "+n2.getRef()));
				templist2.setLayoutOrientation(JList.VERTICAL);
				templist2.setFixedCellWidth(200);
				templist2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				
				p.add(new JScrollPane(templist2));
				add(p);
				
				int svar = JOptionPane.showConfirmDialog(null, p,"�ndra f�rbindelse",JOptionPane.OK_CANCEL_OPTION);
				if (svar==JOptionPane.OK_OPTION){
					Edge<String> edge1 = edgeref.get(templist2.getSelectedValue());
					List<Edge<String>> edgesamling = foo.getEdgesFrom(edge1.getDest());

					�ndraForb(edge1);
					
				}
			}
		}
	}
	public boolean checkN1N2(){
		if (n1==null || n2==null){
			JOptionPane.showMessageDialog(null,"Du m�ste v�lja ut tv� platser innan du kan anv�nda den h�r operationen.","Platser ej valda!",JOptionPane.WARNING_MESSAGE);
			return false;
		}
		return true;
	}
	
	public void �ndraForb(Edge<String> e1){
		JPanel p = new JPanel();	
		p.setLayout(new BoxLayout(p,BoxLayout.Y_AXIS));
		JPanel b = new JPanel();
		JTextField ff�lt = new JTextField(8);
		ff�lt.setText(e1.getName());
		b.add(new JLabel("F�rbindelsetyp: "));
		b.add(ff�lt);
		JTextField vf�lt = new JTextField(6);
		JPanel c = new JPanel();
		c.add(new JLabel("Restid f�r f�rbindelse (i minuter): "));
		vf�lt.setText(""+e1.getWeight());
		c.add(vf�lt);
		p.add(b);p.add(c);
		add(p);
		
		int svar = JOptionPane.showConfirmDialog(null, p,"�ndra f�rbindelse",JOptionPane.OK_CANCEL_OPTION);
		if (svar == JOptionPane.OK_OPTION){				
			String forb = ff�lt.getText();
			String v =vf�lt.getText();
			if (okValues(forb,v)){
				int vikt = Integer.parseInt(v);
				e1.setWeight(vikt);
				e1.setName(forb);
				e1 = e1.getMirror();
				e1.setWeight(vikt);
				e1.setName(forb);
			}
		}
	}
	
	class VisaLyss implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			if (checkN1N2() && plan != null){
				List<Edge<String>> list1 = foo.getEdgesBetween(n1.getRef(),n2.getRef());
				String text = "F�rbindelser mellan "+n1.getRef()+" och "+n2.getRef()+":\n\n";
				if (list1.size()<1){
					JOptionPane.showMessageDialog(null,"Det finns inga registrerade f�rbindelser mellan dessa tv� platser!");
					return;
				}
				for (Edge<String> e : list1){
						text+=e.getName()+" : "+e.getWeight()+" minut(er)\n";
				}
				JOptionPane.showMessageDialog(null,text);
			}
		}
	}
	
	class NyForbLyss implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			if (checkN1N2() && plan != null){
				JPanel p = new JPanel();	
				p.setLayout(new BoxLayout(p,BoxLayout.Y_AXIS));
				JPanel a = new JPanel();
				a.add(new JLabel("Ny f�rbindelse mellan "+n1.getRef()+" och "+n2.getRef()+"."));
				JPanel b = new JPanel();
				JTextField ff�lt = new JTextField(8);
				b.add(new JLabel("F�rbindelsetyp: "));
				b.add(ff�lt);
				JTextField vf�lt = new JTextField(6);
				JPanel c = new JPanel();
				c.add(new JLabel("Restid f�r f�rbindelse (i minuter): "));
				c.add(vf�lt);
				p.add(a);p.add(b);p.add(c);
				add(p);
				
				int svar = JOptionPane.showConfirmDialog(null, p,"L�gg till ny f�rbindelse",JOptionPane.OK_CANCEL_OPTION);
				if (svar == JOptionPane.OK_OPTION){				
					String forb = ff�lt.getText();
					String v =vf�lt.getText();
					if (okValues(forb,v)){
						int vikt = Integer.parseInt(v);
						foo.connect(n1.getRef(),n2.getRef(),forb,vikt);
						return;
					}
				}
			}
		}
	}
	
	public boolean okValues(String str, String v){
		int vikt;
		try{
			vikt = Integer.parseInt(v);
			}
		catch (NumberFormatException foo){
			JOptionPane.showMessageDialog(null,"Tid felangiven!","Fel v�rde!",JOptionPane.ERROR_MESSAGE); 
			return false;
		}
		if (str.equals("")){
			JOptionPane.showMessageDialog(null,"Ange namn p� f�rbindelse!","Inget namn!",JOptionPane.ERROR_MESSAGE);
			return false;}
		else if (vikt<1){
			JOptionPane.showMessageDialog(null,"Tiden m�ste vara h�gre �n 0!","Fel v�rde!",JOptionPane.ERROR_MESSAGE);
			return false;}
		return true;
	}
	
	public void setN1N2(Nod n){
		if (badFix){
			if (n.isVald()){
				if (n==n1) n1=null;
				else n2=null;
				n.shiftVald();
			}
		else{
			if (n1 == null){ 
				n1 = n;
				n1.shiftVald();
			}
			else if (n2 == null && n != n1){
				n2 = n;
				n2.shiftVald();
			}
		}
		badFix=false;
		jlist.setSelectedValue(n.getRef(),true);
		badFix=true;
		repaint();
		validate();
		}
	}
	
	class SelLyss extends MouseAdapter{
		public void mouseClicked(MouseEvent me){
			Nod n = (Nod)me.getSource();
			setN1N2(n);
		}
	}
	
	
	class ListLyss implements ListSelectionListener{
		public void valueChanged(ListSelectionEvent lev){
			if (!lev.getValueIsAdjusting()){
				try{
					String vald = jlist.getSelectedValue();
					Nod n = nodRef.get(vald);
					setN1N2(n); 
				}
				catch (NullPointerException e){}
			}
		}
	}
	

	class MusLyss extends MouseAdapter{
		public void mouseClicked(MouseEvent me){
			int x = me.getX();
			int y = me.getY();
			JPanel form = new JPanel();	
			form.setLayout(new BoxLayout(form,BoxLayout.Y_AXIS));
			
			JPanel r1 = new JPanel();
			JTextField nf�lt = new JTextField(10);
			r1.add(new JLabel("Namn p� plats: "));
			r1.add(nf�lt);
			form.add(r1);
			int svar = JOptionPane.showConfirmDialog(null, form,"L�gg till ny plats",JOptionPane.OK_CANCEL_OPTION);
			if (svar == JOptionPane.OK_OPTION){
				String namn = nf�lt.getText();
				if (namn.equals("")){
					JOptionPane.showMessageDialog(null,"Ange namn p� plats!");
					return;}
				else if (nodRef.containsKey(namn)){
					JOptionPane.showMessageDialog(null,"Plats med angivet namn finns redan!");
					return;}
				foo.add(namn);
				Nod nyNod = new Nod(x-8,y-8,namn);
				plan.add(nyNod);
				
				JLabel platsNamn = new JLabel(namn);
				platsNamn.setForeground(Color.BLACK);
				platsNamn.setFont(new Font("Arial", Font.BOLD, 12));
				plan.add(platsNamn);
				//platsNamn.setLocation(x+bla,y+bleh); Texten syns inte
				platsNamn.setBounds(x-8,y-10,500,50);
				
				nodRef.put(namn,nyNod);
				nyNod.addMouseListener(new SelLyss());
				nodlist.addElement(namn);
				plan.validate();
				plan.repaint();
				plan.removeMouseListener(musen);
				musAct=false;
				plan.setCursor(Cursor.getDefaultCursor());
			}
			else return;		
		}
	}

	class QuitLyss implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			JPanel foo1 = new JPanel();
			foo1.add(new JLabel("�r du s�ker p� att du vill avsluta?"));
			int svar = JOptionPane.showConfirmDialog(null,foo1,"Avsluta?",JOptionPane.OK_CANCEL_OPTION);
			if (svar == JOptionPane.OK_OPTION){
				System.exit(0);
			}
		}
	}
	
	class NyLyss implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			if (plan!=null && !musAct){
				plan.addMouseListener(musen);
				musAct=true;
				plan.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
			}
		}
	}
	
	class OpLyss implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			int svar = jc.showOpenDialog(Main.this);
			if (svar == JFileChooser.APPROVE_OPTION){
			
				int j=nodlist.size();
				for (int i = 0;i<j;i++){
					nodlist.remove(0);
				}
				
				n1=null;n2=null;				
				foo = new graphs.ListGraph<String>();
				nodRef = new HashMap<String,Nod>();
				
				File fil = jc.getSelectedFile();
				String namn = fil.getAbsolutePath();
				
				if (plan!=null)
					remove(plan);
				
				plan = new Karta(namn);
				add(plan,BorderLayout.CENTER);
				validate();
				repaint();
				pack();
			}
		}
	}
	
	public static void main(String[] args){
		new Main();
	}
}