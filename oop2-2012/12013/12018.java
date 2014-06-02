import java.util.*;

public class Register {

	Scanner keyboard = new Scanner(System.in);

	ArrayList<Person> allaPersoner = new ArrayList<Person>();

	int antal = 0;

	int readInt(String fråga) {

		for (;;) { // oändlig loop//

			try {

				System.out.print(fråga);

				int x = Integer.parseInt(keyboard.nextLine());

				return x;

			}

			catch (NumberFormatException e) {

				System.out.println("Fel - skall vara ett numeriskt värde");

			}

		}

	}

	String readString(String fråga) {

		System.out.print(fråga);

		String str = keyboard.nextLine();

		return str;

	}

	Person getPerson(String namn) {

		for (Person p : allaPersoner)

			if (p.getNamn().equalsIgnoreCase(namn))

				return p;

		return null;

	}

	// case 1 (skapa person) //////////
	void skapaPerson() {

		String namn = readString("Ange personens namn: ");

		Person p = getPerson(namn);

		if (p != null)

			System.out.println("Den personen finns redan");

		else {

			Person ny = new Person(namn);

			allaPersoner.add(ny);

			antal++;

			System.out.println();

			System.out.println("Totalt antal personer: " + antal);


		}

	}

	// case 2 (skapa en pryl) //////////
	void skapaPryl() {
		String ägare = readString("Vad heter personen? ");

		boolean personfinns = false;
		Person rätt = null;
		for (Person p : allaPersoner) {
			if (p.getNamn().equalsIgnoreCase(ägare)) {

				rätt = p;
				personfinns = true;

				System.out.println("Skriv vilken typ av pryl?");
				System.out.println("1. Smycke");
				System.out.println("2. Apparat");
				System.out.println("3. Aktie");
				String Pryl = keyboard.nextLine();

				if (Pryl.equalsIgnoreCase("1")) {
					String prylnamn = readString("Vad är det för smycke?");
					String material = readString("Är smycket av guld eller silver?");
					int stenar = readInt("Hur många ädelstenar har smycket?");

					Smycke sm = new Smycke(prylnamn, material, stenar);

					p.addPryl(sm);
					System.out.println(sm);

				} else if (Pryl.equalsIgnoreCase("2")) {
					String prylnamn = readString("Vad är det för apparat?");
					int slitage = readInt("Hur stort är slitaget på apparaten (1-10)?");
					int inkopspris = readInt("Hur mycket köptes appareten för?");

					Apparat ap = new Apparat(prylnamn, slitage, inkopspris);

					p.addPryl(ap);
					System.out.println(ap);

				} else if (Pryl.equalsIgnoreCase("3")) {
					String prylnamn = readString("Vad är det för aktie?");
					int antal = readInt("Hur många aktier?");
					int pris = readInt("Vilket pris köptes dem för?");

					Aktie ak = new Aktie(prylnamn, antal, pris);

					p.addPryl(ak);
					System.out.println(ak);
				}
			}
		}
		if (!personfinns)
			System.out.println("Person finns inte");
	}

	// case 3 (lista alla personer) //////////
	void listaAlla() {

		System.out.println("I registret finns: ");
		for (int x = 0; x < allaPersoner.size(); x++) {

			System.out.println(allaPersoner.get(x).toStringtotal());
		}
	}

	// case 4 (lista rikaste) //////////
	void visaRikaste() {

		if (allaPersoner.isEmpty()) {
			System.out.println("Det finns inga personer i listan");

		} else {

			int max = -1;
			Person rikastePerson = null;

			for (Person p : allaPersoner) {
				if (p.getTotalVärde() > max) {
					max = p.getTotalVärde();
					rikastePerson = p;
				}

			}

			System.out.println(rikastePerson.visaRikast());
		}

	}

	// case 5 (visa en viss person) //////////
	void visaVissPerson() {
		System.out.print("Namn på person: ");
		String person = keyboard.nextLine();
		if (allaPersoner.isEmpty()) {
			System.out.println("Inga ägare registrerade");
		}

		for (Person p : allaPersoner) {
			if (p.getNamn().equalsIgnoreCase(person))
				System.out.println(p.visaVissPerson());
		}
	}

	// case 6 (börskrasch) //////////
	void börskrasch() {
		for (Person p : allaPersoner) {
			p.krasch();
		}
		System.out.println("Börskrasch utförd");
	}

	public static void main(String[] args) {

		Register vr = new Register();

		System.out.println("Välkommen!");

		for (;;) {

			// Startmeny

			System.out.println();

			System.out.println("1. Skapa en person");

			System.out.println("2. Skapa en pryl");

			System.out.println("3. Lista alla personer");

			System.out.println("4. Lista rikaste ");

			System.out.println("5. Lista en viss person");

			System.out.println("6. Börskrasch");

			System.out.println("7. Avsluta programmet");

			int val = vr.readInt("> ");

			switch (val) {

			case 1:
				vr.skapaPerson();
				break; // lägg till en ny person

			case 2:
				vr.skapaPryl();
				break; // skapa pryl

			case 3:
				vr.listaAlla();
				break; // lista alla i listan

			case 4:
				vr.visaRikaste();
				break; // visa rikaste i listan

			case 5:
				vr.visaVissPerson();
				break; // visa en viss person

			case 6:
				vr.börskrasch();
				break; // börskrasch

			case 7: // avsluta programmet

				System.out.print("Programmet avslutat");

				System.exit(0);
				break;

			default:

				System.out.print("Ogiltigt val, välj ett tal mellan 1-7.");

				System.out.println();

			}

		}

	}

}