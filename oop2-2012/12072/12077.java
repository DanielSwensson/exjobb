import java.util.Scanner;
import java.util.ArrayList;

public class Register {

	ArrayList<Person> allaPersoner = new ArrayList<Person>();

	Scanner scan = new Scanner(System.in);

	int readInt(String fr�ga) {
		for (;;) {
			try {
				System.out.println(fr�ga);
				int x = Integer.parseInt(scan.nextLine());
				return x;
			} catch (NumberFormatException e) {
				System.out.println("Fel - skall vara numerisk v�rde");
			}
		}
	}

	String readString(String fr�ga) {
		System.out.println(fr�ga);
		String str = scan.nextLine();
		return str;
	}

	boolean compareStrings(String compare, String input) {
		if (compare.equalsIgnoreCase(input))
			return true;
		else
			return false;
	}

	Person getPerson(String namn) {
		for (Person p : allaPersoner)
			if (p.getpersonNamn().equalsIgnoreCase(namn))
				return p;
		return null;
	}

	void skapaPerson() {
		String namn = readString("Ange namnet p� den nya personen: ");
		Person p = getPerson(namn);
		if (p != null)
			System.out.println("Personen finns redan i registret");
		else {
			Person ny = new Person(namn);
			allaPersoner.add(ny);
			System.out.println(namn + " finns nu i registret!");

		}
	}

	void skapaPryl() {

		String namn = readString("Vilken person �ger prylen?: ");

		for (int x = 0; x < allaPersoner.size(); x++) {
			if (allaPersoner.get(x).getpersonNamn().equals(namn)) {

				int svar = readInt("V�lj ett av nedanst�ende kommando \n1: Smycke \n2: Aktie \n3: Apparat");
				if (svar == 1) {

					String typSmycke = readString("Vilken sorts smycke?:");
					boolean bol = compareStrings(
							readString("�r smycket av guld? (ja/nej)"), "ja");
					int antal�delstenar = readInt("Antal �delstenar: ");
					Smycke ny = new Smycke(typSmycke, bol, antal�delstenar);
					allaPersoner.get(x).addPryl(ny);
				}

				if (svar == 2) {
					String typAktie = readString("Ange namn p� aktien:");
					int antal = readInt("Antal aktier:");
					int pris = readInt("Pris:");

					Aktie ny = new Aktie(typAktie, antal, pris);
					allaPersoner.get(x).addPryl(ny);
				}

				if (svar == 3) {
					String typApparat = readString("Typ av apparat?: ");
					int ink�pspris = readInt("Vad �r ink�pspriset?: ");
					int slitage = readInt("Ange slitaget? (0-10)");
					Apparat ny = new Apparat(typApparat, ink�pspris, slitage);
					allaPersoner.get(x).addPryl(ny);
				}

			}
		}

	}

	void visaAlla() {
		if (allaPersoner.isEmpty())
			System.out.println("Registret �r tomt!");
		else {
			System.out.println("I registret finns f�ljande:");
			for (int x = 0; x < allaPersoner.size(); x++)
				System.out.println(allaPersoner.get(x).getpersonNamn() + "\t"
						+ allaPersoner.get(x).getTotalV�rde());
		}

	}

	void visaRikaste() {
		if (allaPersoner.isEmpty())
			System.out.println("Registret �r tomt!");
		else {
			Person rikaste = null;
			int rikasteSumma = 0;
			for (int x = 0; x < allaPersoner.size(); x++) {
				if (allaPersoner.get(x).getTotalV�rde() > rikasteSumma) {
					rikasteSumma = allaPersoner.get(x).getTotalV�rde();
					rikaste = allaPersoner.get(x);
					System.out.println(rikasteSumma);
				}
			}
			System.out.println(rikaste.getpersonNamn()
					+ " �r rikaste och har en f�rm�genhet p� "
					+ rikaste.getTotalV�rde() + "\n" + rikaste.listPryl());
		}

	}

	void visaVissPerson() {
		if (allaPersoner.isEmpty())
			System.out.println("Registret �r tomt!");
		else {
			Person person = null;
			do {
				String namn = readString("Vilken person s�kes?:");
				person = getPerson(namn);
				if (person == null)
					System.out.println("Finns ingen person i registret med det angivna namnet");
				else
					System.out.println(person.getpersonNamn() + " �ger: \n"
							+ person.listPryl());
			} while (person == null);
		}

	}

	void b�rskrasch() {
		for (Person p : allaPersoner) {
			p.b�rsKrasch();
		}

	}

	public static void main(String[] args) {
		Register re = new Register();
		System.out.println("Hej och v�lkommen");
		for (;;) {

			System.out.println("1.Skapa person");
			System.out.println("2.Skapa pryl");
			System.out.println("3.Visa alla");
			System.out.println("4.Visa rikaste");
			System.out.println("5.Visa viss person");
			System.out.println("6.B�rskrasch");
			System.out.println("7.Avsluta");
			int val = re.readInt("V�lj ett komando:");
			switch (val) {
			case 1:
				re.skapaPerson();
				break;
			case 2:
				re.skapaPryl();
				break;
			case 3:
				re.visaAlla();
				break;
			case 4:
				re.visaRikaste();
				break;
			case 5:
				re.visaVissPerson();
				break;
			case 6:
				re.b�rskrasch();
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