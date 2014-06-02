import java.util.Scanner;
import java.util.ArrayList;
public class Huvudprogram {

	Scanner keyboard = new Scanner(System.in);
	ArrayList<Person> alla = new ArrayList <Person>();
	ArrayList<Pryl> prylar = new ArrayList <Pryl> ();
	public static void main(String[] args) {
		Huvudprogram hp = new Huvudprogram ();
		System.out.println("Välkommen till värderegistret!");
		while(true){
			int val = hp.readInt("\n1. Skapa en person \n2. Skapa en ny pryl \n3. Visa alla personer i registret \n4. Visa den rikaste personen \n5. Visa vald person \n6. Börskrasch! \n7. Stäng programmet \n Välj mellan 1-7 ");
			switch (val){
			case 1: hp.skapaPerson () ; break;
			case 2: hp.skapaNyPryl (); break;
			case 3: hp.visaAlla (); break;
			case 4: hp.visaRikaste (); break;
			case 5: hp.visaSpecifik (); break;
			case 6: hp.börskrash (); break;
			case 7: System.out.println("Hej då!");
					System.exit(0);
			default: System.out.println("Fel kommando");
		
			}
		}
	}
	public void visaAlla (){
		for(Person p : alla){
			for(Pryl t : prylar){
				if(p.getNamn().equals(t.getÄgare())){
					int total = p.getTotal();
					total+=t.getVärde();
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
				if(p.getNamn().equals(t.getÄgare())){
					int total = p.getTotal();
					total+=t.getVärde();
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
			if(rikaste.equals(t.getÄgare())){
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
				if(namn.equalsIgnoreCase(t.getÄgare())){
					int total = p.getTotal();
					total+=t.getVärde();
					p.setTotal(total);
				}
			}
		System.out.println(p);
		for(Pryl t: prylar){
			if(namn.equals(t.getÄgare())){
				System.out.println(t);
			}
		}
		p.setTotal(0);
		} else {
			System.out.println("Personen finns inte i registret.");	
		}
	}
	public void börskrash (){
		for(Pryl t : prylar){
			if(t instanceof Aktier){
				((Aktier)t).setVärde(0);
				
			}
		}
		System.out.println("Börsen har krashat");
	}
	public void skapaNyPryl (){
		String typ = null;
		String ägare = readString("Vem äger prylen?");
		Person p = getPerson(ägare);
		if(p!= null){
		typ = readString("Vilken typ av pryl är det? Ett smycke, en aktiepost eller en apparat");
			if(typ.equalsIgnoreCase("smycke")){
				skapaNyttSmycke(ägare);
			} else if (typ.equalsIgnoreCase("aktiepost")){
				skapaNyAktiepost(ägare);
			} else if (typ.equalsIgnoreCase("apparat")){
				skapaNyApparat(ägare);
			} else{
				System.out.println("Prylen hör inte hemma i registret. Du kanske stavade fel?");
			}
		} else {
			System.out.println("Personen finns inte i registret.");
		}

	}
	public void skapaNyttSmycke(String ägare){
		String namn = readString("Namnge smycket");
		String guld = readString("Är smycket av guld? Ja/Nej");
		int antalAdelstenar = readInt("Hur många ädelstenar har smycket? ");
		Smycke s = new Smycke(ägare, namn, guld, antalAdelstenar);
		prylar.add(s);
	}
	public void skapaNyAktiepost(String ägare){
		String namn = readString("Namnge aktieposten");
		int antal = readInt("Hur många aktier finns i aktieposten?");
		int pris = readInt("Hur mycket är en aktie värd? (Heltal)");
		Aktier a = new Aktier (ägare, namn, antal, pris);
		prylar.add(a);
	}
	public void skapaNyApparat(String ägare){
		String namn = readString("Namnge Apparaten");
		int inköpspris = readInt("Hur mycket köptes "+namn+" för?");
		int slitage = readInt("Ange slitage 1-10 där tio är minst slitet");
		Apparater a = new Apparater (ägare, namn, inköpspris, slitage);
		prylar.add(a);
	}
	public int readInt(String fråga){
		while (true){
			try {
				System.out.println(fråga);
				int x = Integer.parseInt(keyboard.nextLine());
				return x;
			}
			catch(NumberFormatException e){
				System.out.println("Fel - ska vara en siffra");
			}
		}
	}
	public String readString(String fråga){
		System.out.print(fråga);
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