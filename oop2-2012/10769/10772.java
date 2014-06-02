
import java.util.*;

class Main{
// array f�r alla personer
	ArrayList <Person> allapersoner = new ArrayList<Person>();

	Scanner scan = new Scanner(System.in);// f�r att l�sa in data fr�n tangebord

	public static void main (String[]args){
		Main m = new Main();
System.out.println("V�lkommen till registret");
	int val;
		for(;;){
			// kommandostyrd dialog
			m.println("\n1. Skapa en person\n2. Skapa en pryl\n3. Visa alla personer \n4. Visa de rikaste personen\n5. Visa person med givna namn\n6. B�rskrasch\n7. Avsluta program");

			val = m.readInt("\nAnge kommando mellan 1-7: ");

			switch (val){

			case 1: m.createPerson();break;

			case 2: m.createPryl();break;

			case 3: m.visaAlla();break;

			case 4: m.visaRikast();break;

			case 5: m.visaVissPerson();break;

			case 6: m.b�rskrash();break;

			case 7: System.exit(0);

			default:m.println("Felaktigt kommando, f�rs�k igen");
			}
		}
	}

		void print(String text){
			System.out.print(text);
		}

		void print(Object o){
			System.out.print(o);
		}

		void println(String text){
			System.out.println(text);
		}

		void println(Object o){
			System.out.println(o);
		}

	int readInt(String fr�ga){
		for(;;){
			try{
			print(fr�ga);
				int x=Integer.parseInt(scan.nextLine());
				return x;
	}
		catch (NumberFormatException e){
			println("Felaktigt kommando, ange ett tal");
			}
		}
	}


	String readString(String fr�ga){
		print(fr�ga);
		String str=scan.nextLine();
		return str;
		}


		Person getPerson(String namn){
		for (Person p : allapersoner)
			if (j�mf�ra(p.getNamn(), namn))
				return p;
				return null;
		}


		boolean j�mf�ra(String text, String compare){
		if (text.equalsIgnoreCase(compare))
			return true;
			return false;
		}

		void pause(){
		readString("\nTryck Enter");
		}

		void createPerson(){
		String namn= readString("Ange namn: ");
		for (;;){
			if (getPerson(namn) != null){
				namn = readString("Personen finns redan i registret \n Ange ett nytt namn: ");
			}
			else{
			Person per = new Person(namn);
			allapersoner.add(per);
			return;
			}
		}
	}
// n�r en pryl skapas
		void createPryl(){

		String namn=readString("Ange �garens namn: ");
		Person p=getPerson(namn);
		if (p==null){
			println("Person med namnet "+namn+" finns inte.");
			return;
		}
// dialog n�r Smycke skapas
		String prylTyp=readString("Vilken sort V�rdesak?- Apparat, Aktie eller Smycke: ");
		if (j�mf�ra(prylTyp, "Smycke")){
			String smyckeNamn = readString("Vilket sort smycke?: ");
			int �delstenar=readInt("Antal �delstenar?: ");
			boolean guld=j�mf�ra(readString("�r Smycken av guld (Ja/Nej)?: "), "Ja");
			Smycke smy = new Smycke(smyckeNamn, �delstenar, guld);
			p.addV�rdesak(smy);
		}
// dialog n�r Aktie skapas
		else if (j�mf�ra(prylTyp,"Aktie")){
			String aktieNamn=readString("Namn p� aktie: ");
			int antal = readInt("Antalet aktier: ");
			int v�rde = readInt("Priset p� en aktie?: ");
			Aktie akt = new Aktie (aktieNamn, antal, v�rde);
			p.addV�rdesak(akt);
		}
// dialog n�r Apparat skapas
		else if (j�mf�ra(prylTyp, "Apparat")){
		String apparatNamn=readString("Apparattyp: ");
			int ink�pspris = readInt("Ink�pspris: ");
			int slitage;
			do {
				slitage=readInt("Slitage (1-10): ");
			} while (slitage<1 || slitage>10);
			Apparat app=new Apparat(apparatNamn, ink�pspris, slitage);
			p.addV�rdesak(app);
		}
	}
// kommando 3 - visa alla personer		
		void visaAlla(){
		boolean print = false;
		for (Person p:allapersoner){
			if (!print){
				println("I registret finns: ");
				print=true;
			}
			println(p);
		}
		if (!print)
			println("Registret �r tomt....");
		pause();
	}
// visa rikaste		
		void visaRikast(){
		int biggestSumma = 0;
		Person rik = null;
		for (Person p: allapersoner){
			if (p.getTotalV�rde()>biggestSumma){
				biggestSumma=p.getTotalV�rde();
				rik=p;
		}
	}
		if (rik==null){
			println("Inga prylar finns registrerat, f�rs�k igen");
			pause();
			return;
		}
		println("Rikaste personen �r "+rik.getNamn()+" som sammanlagt �ger "+biggestSumma+"\n");
		print(rik.listV�rdesak());
		pause();
	}
// kommando 5
		void visaVissPerson(){
		String person=readString("Namn p� person: ");
		Person p = getPerson(person);
		if (p==null){
			print("Personen "+person+" hittades inte");
			return;
		}
		println(p.getNamn()+" har prylar v�rda "+p.getTotalV�rde()+"\n");
		println(p.listV�rdesak());
		pause();
	}
// kommando 6
		void b�rskrash(){
		boolean krash = j�mf�ra(readString("Konfirmera b�rskrash\n(Ja/Nej) "), "Ja");
		if (!krash)
			return;
		for (Person p: allapersoner){
			p.setAktiepris(0);
			}
		}

	}



