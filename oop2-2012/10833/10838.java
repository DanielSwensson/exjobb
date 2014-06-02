import java.util.ArrayList;
import java.util.Scanner;

public class Register {
	ArrayList<Person> alla = new ArrayList<Person>();
	static Scanner scanner = new Scanner(System.in); // har lagt till static för
														// annars funkade det
														// inte att använda
														// scannern vid kommando

	/*
	 * denna klass får bli den som ska ha all inmatning och all användardialog
	 * dvs arraylist med personer och scannerobjekt + hjälpmetoder för inläsning
	 * + metod för varje kommando + mainmetoden som ska stå längre ner.
	 * mainmetoden ska ha en loop med kommandon
	 */

	// i denna klass ska finnas hjälpmetoder.
	// ska finnas en hjälpmetod för att hitta en viss person
	//

	public static int readInt(String fråga) {
		for (;;) {

			try {
				System.out.print(fråga);
				int x = Integer.parseInt(scanner.nextLine());
				return x;
			} catch (NumberFormatException e) {
				System.out
						.println("Fel - ska vara ett numeriskt värde, försök igen: ");
			}
		}
	}

	String readString(String fråga) {

		System.out.println(fråga);
		String str = scanner.nextLine();
		return str;
	}

	/*
	 * 
	 * Person getPerson (metod) loopar igenom alla personerna och kollar om det
	 * namnet finns. om det gör det så returnerar den det namnet. om namnet inte
	 * finns så returneras null, alltså att personen inte fanns.
	 */

	Person getPerson(String namn) {
		for (Person p : alla)
			if (p.getNamn().equalsIgnoreCase(namn))
				return p;
		return null;
	}

	// void skapaPerson är en hjälpmetod som gör att switchsatsen blir kortare.

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
		String namnPåPerson = readString("Personen som äger prylen: ");
		Person person = getPerson(namnPåPerson);

		if (person == null)
			System.out.println("Person finns ej i registret");
		else {

			String sort = readString("Vilken sorts pryl: ");
			if (sort.equalsIgnoreCase("Smycke")) {
				String sortSmycke = readString("Vilken sorts smycke: ");
				int typAvMaterial = readInt("För guld tryck siffran 1, för silver tryck siffran 2: ");
				int antalStenar = readInt("Antal ädelstenar: ");

				Smycke ny = new Smycke(sortSmycke, antalStenar, typAvMaterial);
				person.addPryl(ny);
			}

			else if (sort.equalsIgnoreCase("Aktie")) {
				String namnPåAktie = readString("Namn på aktie: ");
				int antalAktier = readInt("Antal aktier: ");
				int aktiePris = readInt("Pris på aktien: ");

				Aktie ny = new Aktie(namnPåAktie, antalAktier, aktiePris);
				person.addPryl(ny);
			}

			else if (sort.equalsIgnoreCase("Apparat")) {
				String namnPåApparat = readString("Namn på apparat: ");
				int pris = readInt("Inköpspris: ");
				int slit = readInt("Slitage, välj på skalan 1-10 där 10 är ny apparat: ");

				Apparat ny = new Apparat(namnPåApparat, pris, slit);
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

		for (int i = 1; i < alla.size(); i++) { // i för index som står för
												// platsen som personen ligger

			if (alla.get(i).summaVärde() > rikaste.summaVärde()) {
				rikaste = alla.get(i);

			}

		}
		System.out.println("Rikast är " + rikaste);
		System.out.println(rikaste.sakLista());
	}

	void börskrasch() {
		for (Person p : alla) {
			for (Pryl pry : p.getPryllista()) {
				if (pry instanceof Aktie) {
					((Aktie) pry).setPris(0);
				}
			}

		}

	}

	void visaVissPerson() {
		String namn = readString("Namn på person: ");
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
		System.out.println("Hej och välkommen till prylprogrammet");
		for (;;) {

			System.out.println();
			System.out.print("1-Skapa Person " + "2-Skapa Pryl "
					+ "3-Visa Alla " + "4-Visa Rikaste "
					+ "5-Visa Viss Person " + "6-Börskrasch "
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
				reg.börskrasch();
				break;
			case 7:
				System.out.println("Tack och hejdå");
				System.exit(0);
			default:
				System.out.println("Felaktigt kommando");

			}

		}

	}

}
