import java.util.Scanner;
import java.util.ArrayList;

public class HuvudProgram {

	ArrayList<Person> alla = new ArrayList<Person>();
	// Variabeln i ArrayList = alla
	Scanner keyboard = new Scanner(System.in);

	int readInt(String fråga) {
		for (;;) {
			try {
				System.out.println(fråga);
				int x = Integer.parseInt(keyboard.nextLine());
				return x;
			} catch (NumberFormatException e) {
				System.out.println("Fel - skall vara numerisk värde");
			}
		}
	}

	String readString(String fråga) {
		System.out.println(fråga);
		String str = keyboard.nextLine();
		return str;
	}

	boolean compareStrings(String compare, String input) {
		if (compare.equalsIgnoreCase(input))
			return true;
		else
			return false;
	}

	Person getPerson(String namn) {
		for (Person p : alla)
			if (p.getpersonNamn().equalsIgnoreCase(namn))
				return p;
		return null;
	}

	void skapaPerson() {
		String namn = readString("Nya personens namn: ");
		Person p = getPerson(namn);
		if (p != null)
			System.out.println("Den personen finns redan");
		else {
			Person ny = new Person(namn);
			alla.add(ny);
			System.out.println(namn + " har lagts till i registret!");

		}
	}

	void skapaPryl() {

		String namn = readString("Vilken person äger prylen?: ");

		for (int x = 0; x < alla.size(); x++) {
			if (alla.get(x).getpersonNamn().equals(namn)) {

				int svar = readInt("Välj ett av nedanstående alternativ \n1: Smycke \n2: Aktie \n3: Apparat");
				if (svar == 1) {

					String typSmycke = readString("Vilken sorts smycke?:");
					boolean bol = compareStrings(
							readString("Är smycket av guld? (ja/nej)"), "ja");
					int antalÄdelstenar = readInt("Antal ädelstenar: ");
					Smycke ny = new Smycke(typSmycke, bol, antalÄdelstenar);
					alla.get(x).addPryl(ny);
				}

				if (svar == 2) {
					String typAktie = readString("Vad heter aktien?:");
					int antal = readInt("Antal aktier:");
					int pris = readInt("Pris:");

					Aktie ny = new Aktie(typAktie, antal, pris);
					alla.get(x).addPryl(ny);
				}

				if (svar == 3) {
					String typApparat = readString("Vilken typ av apparat?: ");
					int inköpspris = readInt("Vad är inköpspriset?: ");
					int slitage = readInt("Vad är slitaget? (0-10)");
					Apparat ny = new Apparat(typApparat, inköpspris, slitage);
					alla.get(x).addPryl(ny);
				}

			}
		}

	}

	void visaAlla() {
		if (alla.isEmpty())
			System.out.println("Finns inga personer i registret!");
		else {
			System.out.println("I registret finns:");
			for (int x = 0; x < alla.size(); x++)
				System.out.println(alla.get(x).getpersonNamn() + "\t"
						+ alla.get(x).getTotalVärde());
		}

	}

	void visaRikaste() {
		if (alla.isEmpty())
			System.out.println("Finns inga personer i registret!");
		else {
			Person rikaste = null;
			int rikasteSumma = 0;
			for (int x = 0; x < alla.size(); x++) {
				if (alla.get(x).getTotalVärde() > rikasteSumma) {
					rikasteSumma = alla.get(x).getTotalVärde();
					rikaste = alla.get(x);
					System.out.println(rikasteSumma);
				}
			}
			System.out.println(rikaste.getpersonNamn()
					+ " är rikaste och har en förmögenhet på "
					+ rikaste.getTotalVärde() + "\n" + rikaste.listPryl());
		}

	}

	void visaVissPerson() {
		if (alla.isEmpty())
			System.out.println("Finns inga personer i registret!");
		else {
			Person person = null;
			do {
				String namn = readString("Namn på personen:");
				person = getPerson(namn);
				if (person == null)
					System.out.println("Personen finns inte i registret!");
				else
					System.out.println(person.getpersonNamn() + " äger: \n"
							+ person.listPryl());
			} while (person == null);
		}

	}

	void börskrasch() {
		for (Person p : alla) {
			p.börsKrasch();
		}

	}

	public static void main(String[] args) {
		HuvudProgram hp = new HuvudProgram();
		System.out.println("Hej och välkommen till Prylprogrammet!");
		for (;;) {

			System.out.println("1.Skapa person");
			System.out.println("2.Skapa pryl");
			System.out.println("3.Visa alla");
			System.out.println("4.Visa rikaste");
			System.out.println("5.Visa viss person");
			System.out.println("6.Börskrasch");
			System.out.println("7.Avsluta");
			int val = hp.readInt("Välj ett av ovanstående alternativ:");
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
				hp.börskrasch();
				break;
			case 7:
				System.out.println("Tack och hej då!");
				System.exit(0);
			default:
				System.out.println("Fel kommando");
			}
		}
	}
}
