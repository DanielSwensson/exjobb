import java.util.Scanner;
import java.util.ArrayList;

public class Register {

	ArrayList<Person> allaPersoner = new ArrayList<Person>();

	Scanner scan = new Scanner(System.in);

	int readInt(String fråga) {
		for (;;) {
			try {
				System.out.println(fråga);
				int x = Integer.parseInt(scan.nextLine());
				return x;
			} catch (NumberFormatException e) {
				System.out.println("Fel - skall vara numerisk värde");
			}
		}
	}

	String readString(String fråga) {
		System.out.println(fråga);
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
		String namn = readString("Ange namnet på den nya personen: ");
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

		String namn = readString("Vilken person äger prylen?: ");

		for (int x = 0; x < allaPersoner.size(); x++) {
			if (allaPersoner.get(x).getpersonNamn().equals(namn)) {

				int svar = readInt("Välj ett av nedanstŒende kommando \n1: Smycke \n2: Aktie \n3: Apparat");
				if (svar == 1) {

					String typSmycke = readString("Vilken sorts smycke?:");
					boolean bol = compareStrings(
							readString("Är smycket av guld? (ja/nej)"), "ja");
					int antalÄdelstenar = readInt("Antal Ädelstenar: ");
					Smycke ny = new Smycke(typSmycke, bol, antalÄdelstenar);
					allaPersoner.get(x).addPryl(ny);
				}

				if (svar == 2) {
					String typAktie = readString("Ange namn på aktien:");
					int antal = readInt("Antal aktier:");
					int pris = readInt("Pris:");

					Aktie ny = new Aktie(typAktie, antal, pris);
					allaPersoner.get(x).addPryl(ny);
				}

				if (svar == 3) {
					String typApparat = readString("Typ av apparat?: ");
					int inköpspris = readInt("Vad är inköpspriset?: ");
					int slitage = readInt("Ange slitaget? (0-10)");
					Apparat ny = new Apparat(typApparat, inköpspris, slitage);
					allaPersoner.get(x).addPryl(ny);
				}

			}
		}

	}

	void visaAlla() {
		if (allaPersoner.isEmpty())
			System.out.println("Registret är tomt!");
		else {
			System.out.println("I registret finns följande:");
			for (int x = 0; x < allaPersoner.size(); x++)
				System.out.println(allaPersoner.get(x).getpersonNamn() + "\t"
						+ allaPersoner.get(x).getTotalVärde());
		}

	}

	void visaRikaste() {
		if (allaPersoner.isEmpty())
			System.out.println("Registret är tomt!");
		else {
			Person rikaste = null;
			int rikasteSumma = 0;
			for (int x = 0; x < allaPersoner.size(); x++) {
				if (allaPersoner.get(x).getTotalVärde() > rikasteSumma) {
					rikasteSumma = allaPersoner.get(x).getTotalVärde();
					rikaste = allaPersoner.get(x);
					System.out.println(rikasteSumma);
				}
			}
			System.out.println(rikaste.getpersonNamn()
					+ " är rikaste och har en förmögenhet på "
					+ rikaste.getTotalVärde() + "\n" + rikaste.listPryl());
		}

	}

	void visaVissPerson() {
		if (allaPersoner.isEmpty())
			System.out.println("Registret är tomt!");
		else {
			Person person = null;
			do {
				String namn = readString("Vilken person sökes?:");
				person = getPerson(namn);
				if (person == null)
					System.out.println("Finns ingen person i registret med det angivna namnet");
				else
					System.out.println(person.getpersonNamn() + " äger: \n"
							+ person.listPryl());
			} while (person == null);
		}

	}

	void börskrasch() {
		for (Person p : allaPersoner) {
			p.börsKrasch();
		}

	}

	public static void main(String[] args) {
		Register re = new Register();
		System.out.println("Hej och välkommen");
		for (;;) {

			System.out.println("1.Skapa person");
			System.out.println("2.Skapa pryl");
			System.out.println("3.Visa alla");
			System.out.println("4.Visa rikaste");
			System.out.println("5.Visa viss person");
			System.out.println("6.Börskrasch");
			System.out.println("7.Avsluta");
			int val = re.readInt("Välj ett komando:");
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
				re.börskrasch();
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