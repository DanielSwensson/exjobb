import java.util.Scanner;
import java.util.ArrayList;

public class HuvudProgram {

	ArrayList<Person> alla = new ArrayList<Person>();
	// Variabeln i ArrayList = alla
	Scanner keyboard = new Scanner(System.in);

	int readInt(String fr�ga) {
		for (;;) {
			try {
				System.out.println(fr�ga);
				int x = Integer.parseInt(keyboard.nextLine());
				return x;
			} catch (NumberFormatException e) {
				System.out.println("Fel - skall vara numerisk v�rde");
			}
		}
	}

	String readString(String fr�ga) {
		System.out.println(fr�ga);
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

		String namn = readString("Vilken person �ger prylen?: ");

		for (int x = 0; x < alla.size(); x++) {
			if (alla.get(x).getpersonNamn().equals(namn)) {

				int svar = readInt("V�lj ett av nedanst�ende alternativ \n1: Smycke \n2: Aktie \n3: Apparat");
				if (svar == 1) {

					String typSmycke = readString("Vilken sorts smycke?:");
					boolean bol = compareStrings(
							readString("�r smycket av guld? (ja/nej)"), "ja");
					int antal�delstenar = readInt("Antal �delstenar: ");
					Smycke ny = new Smycke(typSmycke, bol, antal�delstenar);
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
					int ink�pspris = readInt("Vad �r ink�pspriset?: ");
					int slitage = readInt("Vad �r slitaget? (0-10)");
					Apparat ny = new Apparat(typApparat, ink�pspris, slitage);
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
						+ alla.get(x).getTotalV�rde());
		}

	}

	void visaRikaste() {
		if (alla.isEmpty())
			System.out.println("Finns inga personer i registret!");
		else {
			Person rikaste = null;
			int rikasteSumma = 0;
			for (int x = 0; x < alla.size(); x++) {
				if (alla.get(x).getTotalV�rde() > rikasteSumma) {
					rikasteSumma = alla.get(x).getTotalV�rde();
					rikaste = alla.get(x);
					System.out.println(rikasteSumma);
				}
			}
			System.out.println(rikaste.getpersonNamn()
					+ " �r rikaste och har en f�rm�genhet p� "
					+ rikaste.getTotalV�rde() + "\n" + rikaste.listPryl());
		}

	}

	void visaVissPerson() {
		if (alla.isEmpty())
			System.out.println("Finns inga personer i registret!");
		else {
			Person person = null;
			do {
				String namn = readString("Namn p� personen:");
				person = getPerson(namn);
				if (person == null)
					System.out.println("Personen finns inte i registret!");
				else
					System.out.println(person.getpersonNamn() + " �ger: \n"
							+ person.listPryl());
			} while (person == null);
		}

	}

	void b�rskrasch() {
		for (Person p : alla) {
			p.b�rsKrasch();
		}

	}

	public static void main(String[] args) {
		HuvudProgram hp = new HuvudProgram();
		System.out.println("Hej och v�lkommen till Prylprogrammet!");
		for (;;) {

			System.out.println("1.Skapa person");
			System.out.println("2.Skapa pryl");
			System.out.println("3.Visa alla");
			System.out.println("4.Visa rikaste");
			System.out.println("5.Visa viss person");
			System.out.println("6.B�rskrasch");
			System.out.println("7.Avsluta");
			int val = hp.readInt("V�lj ett av ovanst�ende alternativ:");
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
				System.out.println("Tack och hej d�!");
				System.exit(0);
			default:
				System.out.println("Fel kommando");
			}
		}
	}
}
