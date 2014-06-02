import java.util.ArrayList;
import java.util.Scanner;

public class HuvudProgram {
	ArrayList<Person> allaPersoner = new ArrayList<Person>();

	Scanner keyboard = new Scanner(System.in);

	int readInt(String fr�ga) {
		for (;;) {
			try {
				System.out.print(fr�ga);
				int x = Integer.parseInt(keyboard.nextLine());
				return x;
			} catch (NumberFormatException e) {
				System.out.println("Fel,ska vara ett numeriskt v�rde!");
			}
		}
	}

	String readString(String fr�ga) {
		System.out.print(fr�ga);
		String str = keyboard.nextLine();
		return str;
	}

	Person getPerson(String namn) {
		for (Person p : allaPersoner)
			if (p.getNamn().equalsIgnoreCase(namn))
				return p;
		return null;
	}

	void skapaPerson() {
		String namn = readString("Personens namn: ");
		Person p = getPerson(namn);
		if (p != null)
			System.out.println("Den personen finns redan");
		else {
			Person ny = new Person(namn);
			allaPersoner.add(ny);
		}
	}

	void skapaPryl() {
		System.out.print("Vem �ger prylen: ");
		String vem = keyboard.nextLine();
		boolean hittad = false;
		Person person = null;

		for (int x = 0; x < allaPersoner.size(); x++) {
			if (allaPersoner.get(x).getNamn().equals(vem)) {
				System.out.print("");
				hittad = true;
				person = allaPersoner.get(x);
				break;
			}
		}
		if (hittad == true) {
			String sort = readString("Vilken sorts pryl �ger personen (1. Smycken, 2.Aktier, 3. Apparater)"
					+ ": ");
			Pryl ny = null;

			if (sort.equals("1")) {
				String sort1 = readString("Vilket sorts smycke: ");
				String typ = readString("�r smycket av guld eller silver? ");
				int antal�delstenar = readInt("Antal �delstenar: ");
				ny = new Smycken(sort1, antal�delstenar, typ);

			}

			else if (sort.equals("2")) {
				String sort1 = readString("Vilken sorts aktie: ");
				int antal = readInt("Hur m�nga aktier �ger personen: ");
				int pris = readInt("Vad kostar en aktie: ");
				ny = new Aktier(sort1, antal, pris);

			}

			else if (sort.equals("3")) {
				String sort1 = readString("Vilken sorts apparat: ");
				int pris = readInt("Vad kostar en apparat: ");
				int slitage = readInt("Hur sliten �r apparaten? (ange ett tal mellan 1 och 10,d�r 10=ny och 1=mycket sliten) ");
				ny = new Apparater(sort1, pris, slitage);

			}

			person.AddPryl(ny);

		}

		if (hittad == false) {
			System.out.println("Finns inte!");

		}

	}

	void visaAlla() {
		System.out.println("I registret finns:");
		for (Person p : allaPersoner)
			System.out.println(p.getNamn() + "  " + p.summaV�rde());

	}

	void visaRikaste() {
		if (allaPersoner.isEmpty()) {
			System.out.println("Listan �r tom!");
			return;
		}
		Person rikast = allaPersoner.get(0);
		
		for (Person p : allaPersoner) {
			if (p.summaV�rde() > rikast.summaV�rde())
				rikast = p;

		}
		System.out.println("Rikast �r " + rikast.getNamn() + " som sammanlagt �ger " + rikast.summaV�rde());
		System.out.print(rikast.allaPrylar());

	}

	void visaVissPerson() {
		String namn = readString("Personens namn: ");
		boolean hittad = false;
		for (Person p : allaPersoner) {
			if (p.getNamn().equals(namn)) {
				System.out.println(namn + " som sammanlagt �ger " + p.summaV�rde());
				System.out.print(p.allaPrylar());

				hittad = true;
				break;
			}

		}

		if (hittad == false) {
			System.out.println("Finns inte!");

		}
	}

	void b�rskrasch() {
		for (Person p : allaPersoner)
			p.nollst�llaAktier();
		
			

	}

	public static void main(String[] args) {
		HuvudProgram hp = new HuvudProgram();
		System.out.println("Hej och v�lkommen till prylprogrammet!");
		for (;;) {
			System.out.println("1. Skapa person");
			System.out.println("2. Skapa pryl");
			System.out.println("3. Visa alla");
			System.out.println("4. Visa rikaste");
			System.out.println("5. Visa viss person");
			System.out.println("6. B�rskrasch");
			System.out.println("7. Avsluta");
			int val = hp.readInt("V�lj ett nummer: ");
			switch (val) {
			case 1:
				hp.skapaPerson();
				break;
			case 2:
				hp.skapaPryl();
				break;
			case 3:
				hp.visaAlla();
				break;
			case 4:
				hp.visaRikaste();
				break;
			case 5:
				hp.visaVissPerson();
				break;
			case 6:
				hp.b�rskrasch();
				break;
			case 7:
				System.out.print("Tack och v�lkommen �ter!");
				System.exit(0);
			default:
				System.out
						.print("Felaktigt nummer! Det ska vara mellan 1 och 7!");

			}
		}
	}
}
