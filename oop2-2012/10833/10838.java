import java.util.ArrayList;
import java.util.Scanner;

public class Register {
	ArrayList<Person> alla = new ArrayList<Person>();
	static Scanner scanner = new Scanner(System.in); // har lagt till static f�r
														// annars funkade det
														// inte att anv�nda
														// scannern vid kommando

	/*
	 * denna klass f�r bli den som ska ha all inmatning och all anv�ndardialog
	 * dvs arraylist med personer och scannerobjekt + hj�lpmetoder f�r inl�sning
	 * + metod f�r varje kommando + mainmetoden som ska st� l�ngre ner.
	 * mainmetoden ska ha en loop med kommandon
	 */

	// i denna klass ska finnas hj�lpmetoder.
	// ska finnas en hj�lpmetod f�r att hitta en viss person
	//

	public static int readInt(String fr�ga) {
		for (;;) {

			try {
				System.out.print(fr�ga);
				int x = Integer.parseInt(scanner.nextLine());
				return x;
			} catch (NumberFormatException e) {
				System.out
						.println("Fel - ska vara ett numeriskt v�rde, f�rs�k igen: ");
			}
		}
	}

	String readString(String fr�ga) {

		System.out.println(fr�ga);
		String str = scanner.nextLine();
		return str;
	}

	/*
	 * 
	 * Person getPerson (metod) loopar igenom alla personerna och kollar om det
	 * namnet finns. om det g�r det s� returnerar den det namnet. om namnet inte
	 * finns s� returneras null, allts� att personen inte fanns.
	 */

	Person getPerson(String namn) {
		for (Person p : alla)
			if (p.getNamn().equalsIgnoreCase(namn))
				return p;
		return null;
	}

	// void skapaPerson �r en hj�lpmetod som g�r att switchsatsen blir kortare.

	void skapaPerson() {
		String namn = readString("Nya personens namn: ");
		Person p = getPerson(namn);
		if (p != null)
			System.out.println("Den personen finns redan");
		else {
			Person ny = new Person(namn);
			alla.add(ny);
		}
	}

	void skapaPryl() {
		String namnP�Person = readString("Personen som �ger prylen: ");
		Person person = getPerson(namnP�Person);

		if (person == null)
			System.out.println("Person finns ej i registret");
		else {

			String sort = readString("Vilken sorts pryl: ");
			if (sort.equalsIgnoreCase("Smycke")) {
				String sortSmycke = readString("Vilken sorts smycke: ");
				int typAvMaterial = readInt("F�r guld tryck siffran 1, f�r silver tryck siffran 2: ");
				int antalStenar = readInt("Antal �delstenar: ");

				Smycke ny = new Smycke(sortSmycke, antalStenar, typAvMaterial);
				person.addPryl(ny);
			}

			else if (sort.equalsIgnoreCase("Aktie")) {
				String namnP�Aktie = readString("Namn p� aktie: ");
				int antalAktier = readInt("Antal aktier: ");
				int aktiePris = readInt("Pris p� aktien: ");

				Aktie ny = new Aktie(namnP�Aktie, antalAktier, aktiePris);
				person.addPryl(ny);
			}

			else if (sort.equalsIgnoreCase("Apparat")) {
				String namnP�Apparat = readString("Namn p� apparat: ");
				int pris = readInt("Ink�pspris: ");
				int slit = readInt("Slitage, v�lj p� skalan 1-10 d�r 10 �r ny apparat: ");

				Apparat ny = new Apparat(namnP�Apparat, pris, slit);
				person.addPryl(ny);
			}
		}
	}

	void visaAlla() {
		System.out.println("I registret finns: ");
		System.out.println();

		for (Person p : alla) {
			System.out.println(p);
		}

	}

	void visaRikaste() {
		Person rikaste = alla.get(0);

		for (int i = 1; i < alla.size(); i++) { // i f�r index som st�r f�r
												// platsen som personen ligger

			if (alla.get(i).summaV�rde() > rikaste.summaV�rde()) {
				rikaste = alla.get(i);

			}

		}
		System.out.println("Rikast �r " + rikaste);
		System.out.println(rikaste.sakLista());
	}

	void b�rskrasch() {
		for (Person p : alla) {
			for (Pryl pry : p.getPryllista()) {
				if (pry instanceof Aktie) {
					((Aktie) pry).setPris(0);
				}
			}

		}

	}

	void visaVissPerson() {
		String namn = readString("Namn p� person: ");
		boolean hittad = false;
		for (Person p : alla) {
			if (p.getNamn().equalsIgnoreCase(namn)) {
				System.out.println(p);
				System.out.println(p.sakLista());
				hittad = true;
				break;
			}

		}
		
		if (hittad == false) {
			System.out.println("Person med angivet namn finns inte");
		}
	
	}

	public static void main(String[] args) {

		Register reg = new Register();
		System.out.println("Hej och v�lkommen till prylprogrammet");
		for (;;) {

			System.out.println();
			System.out.print("1-Skapa Person " + "2-Skapa Pryl "
					+ "3-Visa Alla " + "4-Visa Rikaste "
					+ "5-Visa Viss Person " + "6-B�rskrasch "
					+ "7-Avsluta\nAnge Kommando: ");
			int kom = readInt("");

			switch (kom) {
			case 1:
				reg.skapaPerson();
				break;
			case 2:
				reg.skapaPryl();
				break;
			case 3:
				reg.visaAlla();
				break;
			case 4:
				reg.visaRikaste();
				break;
			case 5:
				reg.visaVissPerson();
				break;
			case 6:
				reg.b�rskrasch();
				break;
			case 7:
				System.out.println("Tack och hejd�");
				System.exit(0);
			default:
				System.out.println("Felaktigt kommando");

			}

		}

	}

}
