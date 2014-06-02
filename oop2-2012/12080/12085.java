import java.util.Scanner;
import java.util.ArrayList;

public class Register {
	public static ArrayList<Person> personer = new ArrayList<Person>();

	static Scanner scan = new Scanner(System.in);

	public static void skapaPerson() {
		String personNamn = läsaString("Vad heter personen?");
		boolean hittad = false;
		Person p = new Person(personNamn);
		for (Person nuvarande : personer) {
			if (nuvarande.hämtaNamn().equalsIgnoreCase(personNamn)) {
				System.out.println("Personen " + personNamn + " finns redan");
				hittad = true;
			}
		}
		if (!hittad) {
			personer.add(p);
			System.out.println("Personen " + personNamn + " är skapad.");
		}
	}

	public static void läggaTillSmycke(String ägare) {
		Person hittad = finnsPersonen(ägare);
		String guld = null;
		if (hittad != null) {
			String namn = läsaString("Vilket smycke? ");
			int antalStenar = läsaInt("Hur många ädelstenar? ");
			for (;;) {
				guld = läsaString("Är det guld? ");
				if (guld.equalsIgnoreCase("ja") || guld.equalsIgnoreCase("nej")) {
					break;
				} else {
					System.out.println("Du måste svara ja eller nej.");
				}
			}
			Smycke s = new Smycke(namn, antalStenar, guld);
			hittad.läggTillPryl(s);
		}
	}

	public static void läggaTillApparat(String ägare) {
		Person hittad = finnsPersonen(ägare);
		int slitage = 0;
		if (hittad != null) {
			String namn = läsaString("Vilken apparat? ");
			for (;;) {
				slitage = läsaInt("Hur mycket är slitaget? Skala 1-10 där 10 betyder helt ny: ");
				if (slitage > 10 || slitage == 0) {
					System.out.println("Slitaget måste vara mellan 1-10");
				} else {
					break;
				}
			}
			int inköpspris = läsaInt("Vad är inköpspriset? ");
			Apparat ap = new Apparat(namn, slitage, inköpspris);
			hittad.läggTillPryl(ap);
		}
	}

	public static void läggaTillAktie(String ägare) {
		Person hittad = finnsPersonen(ägare);
		if (hittad != null) {
			String namn = läsaString("Vilken aktie? ");
			int antal = läsaInt("Ange antal: ");
			int pris = läsaInt("Ange priset: ");
			Aktie ak = new Aktie(namn, antal, pris);
			hittad.läggTillPryl(ak);
		}
	}

	public static int läsaInt(String fråga) {
		for (;;) {
			try {
				System.out.print(fråga);
				int x = Integer.parseInt(scan.nextLine());
				return x;
			} catch (NumberFormatException e) {
				System.out.println("Fel - skriv in ett heltal");
			}
		}
	}

	public static String läsaString(String fråga) {
		System.out.print(fråga);
		String z = scan.nextLine();
		return z;
	}

	public static Person finnsPersonen(String ägare) {
		boolean hittaPerson = false;
		for (Person nuvarande : personer) {
			if (nuvarande.hämtaNamn().equalsIgnoreCase(ägare)) {
				hittaPerson = true;
				return nuvarande;
			}
		}

		if (hittaPerson == false) {
			System.out.println("Personen finns inte");
		}
		return null;
	}

	public static void läggTillPryl() {

		String ägare = läsaString("Vad heter ägaren? ");
		Person person = finnsPersonen(ägare);
		if (person == null) {
			return;
		}
		boolean tillagd = false;
		do {
			int sort = läsaInt("Vilket alternativ? 1: Smycke, 2: Apparat, 3: Aktie ");
			switch (sort) {
			case 1:
				läggaTillSmycke(ägare);
				tillagd = true;
				break;
			case 2:
				läggaTillApparat(ägare);
				tillagd = true;
				break;
			case 3:
				läggaTillAktie(ägare);
				tillagd = true;
				break;
			default:
				System.out.print("Ange en siffra mellan 1-3 ");
			}

		} while (tillagd == false);

	}

	public static void visaRikaste() {
		int rikast = 0;
		Person rikastPerson = null;
		try {
			for (Person nuvarande : personer) {

				if (nuvarande.hämtaTotaltVärde() >= rikast) {
					rikast = nuvarande.hämtaTotaltVärde();
					rikastPerson = nuvarande;
				}
				System.out.println("Rikast är " + rikastPerson.hämtaNamn()
						+ " som sammanlagt äger "
						+ rikastPerson.hämtaTotaltVärde());
				rikastPerson.skrivUtPryl();
			}
		} catch (NullPointerException n) {
			System.out.println("Inga personer registrerade.");
		}
	}

	public static void visaAlla() {
		System.out.println("I registret finns: ");
		for (Person nuvarande : personer) {
			System.out.println(nuvarande.hämtaNamn() + "		"
					+ nuvarande.hämtaTotaltVärde());
		}
		return;
	}

	public static void visaVissPerson() {
		String vissPerson = läsaString("Vilken person söker du? ");
		boolean hittad = false;
		for (Person nuvarande : personer) {
			if (nuvarande.hämtaNamn().equalsIgnoreCase(vissPerson)) {
				System.out.println("Personen du söker är "
						+ nuvarande.hämtaNamn() + " som sammanlagt äger "
						+ nuvarande.hämtaTotaltVärde());
				nuvarande.skrivUtPryl();
				hittad = true;
			}
		}
		if (hittad == false) {
			System.out.println("Personen finns inte!");
		}

	}

	public static void börskrash() {
		for (Person nuvarande : personer) {
			nuvarande.nollaAktier();
		}
		System.out.println("Börskrash utförd!");
	}

	public static void taBortPerson() {
		String taBort = läsaString("Vilken person vill du ta bort?");
		boolean hittad = false;
		for (int n = 0; n < personer.size(); n++) {
			if (personer.get(n).hämtaNamn().equalsIgnoreCase(taBort)) {
				personer.remove(n);
				System.out.println("Personen " + taBort + " är borttagen");
				hittad = true;
				break;
			}
			if (hittad == false) {
				System.out.print("Personen finns inte!");
			}
		}
	}

	public static void main(String[] args) {
		do {
			System.out
					.println("1: Lägg till person | 2: Lägg till pryl "
							+ "| 3: Visa alla personer | 4: Visa rikaste | 5: Visa viss person "
							+ "| 6: Börskrash | 7: Ta bort person | 8: Avsluta");
			int val = läsaInt("");
			switch (val) {
			case 1:
				skapaPerson();
				break;
			case 2:
				läggTillPryl();
				break;
			case 3:
				visaAlla();
				break;
			case 4:
				visaRikaste();
				break;
			case 5:
				visaVissPerson();
				break;
			case 6:
				börskrash();
				break;
			case 7:
				taBortPerson();
				break;
			case 8:
				System.exit(0);
				break;
			case 9:
				String str = "Alg";
				int tal1 = 3,
				tal2 = 4;
				if (tal1 < tal2)
					str += tal1++;
				else
					str += tal2--;
				System.out.println(str + tal2);
				if (tal1 < tal2)
					str += tal1++;
				else
					str += tal2--;
				System.out.println(str + tal2);
			default:
				System.out.print("Kommandot finns inte!");
			}
		} while (true);

	}

}
