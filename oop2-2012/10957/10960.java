import java.util.ArrayList;
import java.util.Scanner;

public class Huvudprogram {
	ArrayList<Person> allaPersoner = new ArrayList<Person>();

	static Scanner scan = new Scanner(System.in);

	public void skapaPerson() {
		System.out.println("Ange personens namn:");

		String namn = scan.nextLine();
		boolean personNamn = false;

		for (int x = 0; x < allaPersoner.size(); x++) {
			if (allaPersoner.get(x).getPersonNamn().equalsIgnoreCase(namn)) {
				personNamn = true;
				System.out.println("Den personen finns redan ");
			}

		}
		if (personNamn == false) {
			Person ny = new Person(namn);
			allaPersoner.add(ny);
		}
	}

	public static int lŠsSiffra() {
		try {
			return Integer.parseInt(scan.nextLine());
		} catch (NumberFormatException exception) {
			System.out.println("Fel kommando");
			return -1;
		}
	}

	void skapaPryl() {
		boolean found = false;

		if (allaPersoner.size() == 0) {
			System.out
					.println("Det finns inga personer registrerade. Skapa person fšr att kunna skapa en ny pryl");

		} else {

			while (found == false) {
				System.out.println("Vad heter Šgaren?");
				Person person = null;

				String personNamn = scan.nextLine();

				for (int x = 0; x < allaPersoner.size(); x++) {
					if (allaPersoner.get(x).getPersonNamn()
							.equalsIgnoreCase(personNamn)) {
						found = true;
						person = allaPersoner.get(x);
					}
				}

				if (found == false) {
					System.out.println("Personen finns inte");

				} else {
					int kom = -1;
					System.out.println("Vilken sorts pryl vill du registrera? "
							+ " 1-Smycke" + " 2-Aktiepost  " + " 3-Apparat ");
					try {
						kom = Integer.parseInt(scan.nextLine());
					} catch (NumberFormatException exception) {
						System.out.println("Fel kommando");
						return;
					}
					if (kom != 1 && kom != 2 && kom != 3) {
						System.out.println("Fel kommando");
					} else {
						String namn = "";
						Prylar ny = null;
						switch (kom) {
						case 1:

							System.out.println("Namn pŒ smycket?");
							namn = scan.nextLine();

							System.out
									.println("Hur mŒnga Šdelstenar finns pŒ smycket?");
							int antalStenar = lŠsSiffra();
							if (antalStenar == -1) {
								return;
							}

							System.out
									.println("€r smycket i guld eller silver?");
							String metallSort = scan.nextLine();
							if (metallSort.equalsIgnoreCase("guld") == false
									&& metallSort.equalsIgnoreCase("Silver") == false) {
								System.out.println("Fel metallsort");
								return;
							}

							ny = new Smycke(namn, antalStenar, metallSort);
							person.lŠggTill(ny);
							break;
						case 2:

							System.out.println("Vad heter aktien?");
							namn = scan.nextLine();

							System.out.println("Hur mŒnga aktier?");
							int antalAktier = lŠsSiffra();
							if (antalAktier == -1) {
								return;
							}

							System.out.println("Pris per aktie?");
							int prisAktiepost = lŠsSiffra();
							if (prisAktiepost == -1) {
								return;
							}

							ny = new Aktiepost(namn, antalAktier, prisAktiepost);
							person.lŠggTill(ny);

							break;
						case 3:
							System.out.println("Namn pŒ apparaten?");
							namn = scan.nextLine();

							System.out.println("Inkšpspris?");
							int inkšpspris = lŠsSiffra();
							if (inkšpspris == -1) {
								return;
							}

							System.out
									.println("Hur sliten Šr apparaten pŒ en skala frŒn 10-1 dŒ 10 Šr minst?");
							int slitage = lŠsSiffra();
							if (slitage == -1) {
								return;
							}

							ny = new Apparat(namn, inkšpspris, slitage);
							person.lŠggTill(ny);

							break;

						}
					}
				}
			}
		}
	}

	void visaAlla() {
		for (int x = 0; x < allaPersoner.size(); x++)

			System.out.println(allaPersoner.get(x).toString());
		System.out.println("Dessa personer finns i registret");

	}

	void visaRikaste() {

		int rikaste = 0;
		for (int x = 1; x < allaPersoner.size(); x++)
			if (allaPersoner.get(x).getTotalFšrmšgenhet() > allaPersoner.get(
					rikaste).getTotalFšrmšgenhet()) {
				rikaste = x;
			}

		System.out.println(allaPersoner.get(rikaste).toString());
		System.out.println(allaPersoner.get(rikaste).getAllaGrejer());

	}

	void visaViss() {

		System.out.println("Ange personens namn:");

		String namn = scan.nextLine();
		boolean personNamn = false;

		for (int x = 0; x < allaPersoner.size(); x++) {
			if (allaPersoner.get(x).getPersonNamn().equalsIgnoreCase(namn)) {
				personNamn = true;
				System.out.println(allaPersoner.get(x).toString());
				System.out.println(allaPersoner.get(x).getAllaGrejer());
			}

		}
		if (personNamn == false) {
			System.out.println("Personen finns inte");
		}
	}

	void bšrsKrasch() {

		for (int x = 0; x < allaPersoner.size(); x++) {
			Person p = allaPersoner.get(x);
			p.setNollstŠllAktier();
		}
		System.out.println("Alla aktieposter har nu vŠrdet 0 kr");
	}

	public static void main(String[] args) {
		Huvudprogram hp = new Huvudprogram();
		System.out.println("Hej och vŠlkommen till Prylprogrammet");
		for (;;) {
			int val = -1;

			System.out.println("Ange kommando 1-7 " + " 1-Skapa person"
					+ " 2-Skapa pryl  " + " 3-Visa alla " + " 4-Visa rikaste "
					+ " 5-Visa viss person " + " 6-bšrsKrasch " + " 7-Avsluta");
			try {
				val = Integer.parseInt(scan.nextLine());
			} catch (NumberFormatException exception) {
				System.out.println("Fel kommando");

			}
			if (val != 1 && val != 2 && val != 3 && val != 4 && val != 5
					&& val != 6 && val != 7) {
				System.out.println("Fel kommando");

			} else {

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
					hp.visaViss();
					break;
				case 6:
					hp.bšrsKrasch();
					break;
				case 7:
					System.out.println("Programmet stŠngs nu av");
					System.exit(0);
				default:
					System.out.println("Fel kommando");
				}

			}
		}
	}
}