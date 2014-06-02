
import java.util.*;

class Main{
// array för alla personer
	ArrayList <Person> allapersoner = new ArrayList<Person>();

	Scanner scan = new Scanner(System.in);// för att läsa in data från tangebord

	public static void main (String[]args){
		Main m = new Main();
System.out.println("Välkommen till registret");
	int val;
		for(;;){
			// kommandostyrd dialog
			m.println("\n1. Skapa en person\n2. Skapa en pryl\n3. Visa alla personer \n4. Visa de rikaste personen\n5. Visa person med givna namn\n6. Börskrasch\n7. Avsluta program");

			val = m.readInt("\nAnge kommando mellan 1-7: ");

			switch (val){

			case 1: m.createPerson();break;

			case 2: m.createPryl();break;

			case 3: m.visaAlla();break;

			case 4: m.visaRikast();break;

			case 5: m.visaVissPerson();break;

			case 6: m.börskrash();break;

			case 7: System.exit(0);

			default:m.println("Felaktigt kommando, försök igen");
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

	int readInt(String fråga){
		for(;;){
			try{
			print(fråga);
				int x=Integer.parseInt(scan.nextLine());
				return x;
	}
		catch (NumberFormatException e){
			println("Felaktigt kommando, ange ett tal");
			}
		}
	}


	String readString(String fråga){
		print(fråga);
		String str=scan.nextLine();
		return str;
		}


		Person getPerson(String namn){
		for (Person p : allapersoner)
			if (jämföra(p.getNamn(), namn))
				return p;
				return null;
		}


		boolean jämföra(String text, String compare){
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
// när en pryl skapas
		void createPryl(){

		String namn=readString("Ange ägarens namn: ");
		Person p=getPerson(namn);
		if (p==null){
			println("Person med namnet "+namn+" finns inte.");
			return;
		}
// dialog när Smycke skapas
		String prylTyp=readString("Vilken sort Värdesak?- Apparat, Aktie eller Smycke: ");
		if (jämföra(prylTyp, "Smycke")){
			String smyckeNamn = readString("Vilket sort smycke?: ");
			int ädelstenar=readInt("Antal ädelstenar?: ");
			boolean guld=jämföra(readString("Är Smycken av guld (Ja/Nej)?: "), "Ja");
			Smycke smy = new Smycke(smyckeNamn, ädelstenar, guld);
			p.addVärdesak(smy);
		}
// dialog när Aktie skapas
		else if (jämföra(prylTyp,"Aktie")){
			String aktieNamn=readString("Namn på aktie: ");
			int antal = readInt("Antalet aktier: ");
			int värde = readInt("Priset på en aktie?: ");
			Aktie akt = new Aktie (aktieNamn, antal, värde);
			p.addVärdesak(akt);
		}
// dialog när Apparat skapas
		else if (jämföra(prylTyp, "Apparat")){
		String apparatNamn=readString("Apparattyp: ");
			int inköpspris = readInt("Inköpspris: ");
			int slitage;
			do {
				slitage=readInt("Slitage (1-10): ");
			} while (slitage<1 || slitage>10);
			Apparat app=new Apparat(apparatNamn, inköpspris, slitage);
			p.addVärdesak(app);
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
			println("Registret är tomt....");
		pause();
	}
// visa rikaste		
		void visaRikast(){
		int biggestSumma = 0;
		Person rik = null;
		for (Person p: allapersoner){
			if (p.getTotalVärde()>biggestSumma){
				biggestSumma=p.getTotalVärde();
				rik=p;
		}
	}
		if (rik==null){
			println("Inga prylar finns registrerat, försök igen");
			pause();
			return;
		}
		println("Rikaste personen är "+rik.getNamn()+" som sammanlagt äger "+biggestSumma+"\n");
		print(rik.listVärdesak());
		pause();
	}
// kommando 5
		void visaVissPerson(){
		String person=readString("Namn på person: ");
		Person p = getPerson(person);
		if (p==null){
			print("Personen "+person+" hittades inte");
			return;
		}
		println(p.getNamn()+" har prylar värda "+p.getTotalVärde()+"\n");
		println(p.listVärdesak());
		pause();
	}
// kommando 6
		void börskrash(){
		boolean krash = jämföra(readString("Konfirmera börskrash\n(Ja/Nej) "), "Ja");
		if (!krash)
			return;
		for (Person p: allapersoner){
			p.setAktiepris(0);
			}
		}

	}



