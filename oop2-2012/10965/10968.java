import java.util.Scanner;
import java.util.ArrayList;
public class Huvudprogram {

	Scanner keyboard = new Scanner(System.in);
	ArrayList<Person> alla = new ArrayList <Person>();
	ArrayList<Pryl> prylar = new ArrayList <Pryl> ();
	public static void main(String[] args) {
		Huvudprogram hp = new Huvudprogram ();
		System.out.println("V�lkommen till v�rderegistret!");
		while(true){
			int val = hp.readInt("\n1. Skapa en person \n2. Skapa en ny pryl \n3. Visa alla personer i registret \n4. Visa den rikaste personen \n5. Visa vald person \n6. B�rskrasch! \n7. St�ng programmet \n V�lj mellan 1-7 ");
			switch (val){
			case 1: hp.skapaPerson () ; break;
			case 2: hp.skapaNyPryl (); break;
			case 3: hp.visaAlla (); break;
			case 4: hp.visaRikaste (); break;
			case 5: hp.visaSpecifik (); break;
			case 6: hp.b�rskrash (); break;
			case 7: System.out.println("Hej d�!");
					System.exit(0);
			default: System.out.println("Fel kommando");
		
			}
		}
	}
	public void visaAlla (){
		for(Person p : alla){
			for(Pryl t : prylar){
				if(p.getNamn().equals(t.get�gare())){
					int total = p.getTotal();
					total+=t.getV�rde();
					p.setTotal(total);
				}

			}
			System.out.println(p);
			p.setTotal(0);
		}
	}
	public void visaRikaste (){
		String rikaste = null;
		int max = 0;
		for(Person p : alla){
			for(Pryl t : prylar){
				if(p.getNamn().equals(t.get�gare())){
					int total = p.getTotal();
					total+=t.getV�rde();
					p.setTotal(total);
				}
			}
			if(p.getTotal()> max){
				max = p.getTotal();
				rikaste = p.getNamn();
			}
		}
		System.out.println(rikaste +"	" + max);
		for(Pryl t: prylar){
			if(rikaste.equals(t.get�gare())){
				System.out.println(t);
			}
			for(Person p : alla){
				p.setTotal(0);
			}
		}
	}
	public void visaSpecifik (){
		String namn = readString ("Vem vill du visa? ");
		Person p = getPerson(namn);
		if(p!=null){
			for(Pryl t: prylar){
				if(namn.equalsIgnoreCase(t.get�gare())){
					int total = p.getTotal();
					total+=t.getV�rde();
					p.setTotal(total);
				}
			}
		System.out.println(p);
		for(Pryl t: prylar){
			if(namn.equals(t.get�gare())){
				System.out.println(t);
			}
		}
		p.setTotal(0);
		} else {
			System.out.println("Personen finns inte i registret.");	
		}
	}
	public void b�rskrash (){
		for(Pryl t : prylar){
			if(t instanceof Aktier){
				((Aktier)t).setV�rde(0);
				
			}
		}
		System.out.println("B�rsen har krashat");
	}
	public void skapaNyPryl (){
		String typ = null;
		String �gare = readString("Vem �ger prylen?");
		Person p = getPerson(�gare);
		if(p!= null){
		typ = readString("Vilken typ av pryl �r det? Ett smycke, en aktiepost eller en apparat");
			if(typ.equalsIgnoreCase("smycke")){
				skapaNyttSmycke(�gare);
			} else if (typ.equalsIgnoreCase("aktiepost")){
				skapaNyAktiepost(�gare);
			} else if (typ.equalsIgnoreCase("apparat")){
				skapaNyApparat(�gare);
			} else{
				System.out.println("Prylen h�r inte hemma i registret. Du kanske stavade fel?");
			}
		} else {
			System.out.println("Personen finns inte i registret.");
		}

	}
	public void skapaNyttSmycke(String �gare){
		String namn = readString("Namnge smycket");
		String guld = readString("�r smycket av guld? Ja/Nej");
		int antalAdelstenar = readInt("Hur m�nga �delstenar har smycket? ");
		Smycke s = new Smycke(�gare, namn, guld, antalAdelstenar);
		prylar.add(s);
	}
	public void skapaNyAktiepost(String �gare){
		String namn = readString("Namnge aktieposten");
		int antal = readInt("Hur m�nga aktier finns i aktieposten?");
		int pris = readInt("Hur mycket �r en aktie v�rd? (Heltal)");
		Aktier a = new Aktier (�gare, namn, antal, pris);
		prylar.add(a);
	}
	public void skapaNyApparat(String �gare){
		String namn = readString("Namnge Apparaten");
		int ink�pspris = readInt("Hur mycket k�ptes "+namn+" f�r?");
		int slitage = readInt("Ange slitage 1-10 d�r tio �r minst slitet");
		Apparater a = new Apparater (�gare, namn, ink�pspris, slitage);
		prylar.add(a);
	}
	public int readInt(String fr�ga){
		while (true){
			try {
				System.out.println(fr�ga);
				int x = Integer.parseInt(keyboard.nextLine());
				return x;
			}
			catch(NumberFormatException e){
				System.out.println("Fel - ska vara en siffra");
			}
		}
	}
	public String readString(String fr�ga){
		System.out.print(fr�ga);
		String rad = keyboard.nextLine();
		return rad;
	}
	public void skapaPerson (){
		String namn = readString("Vad heter den nya personen?:");
		Person p = getPerson(namn);
		if(p!=null){
			System.out.println("Den personen finns redan");
		}
		else{
			Person ny = new Person(namn);
			alla.add(ny);
		}
	}
	public Person getPerson (String namn){
		for(Person p : alla)
			if (p.getNamn().equals(namn))
				return p;
		return null;
	}
}