import java.util.Scanner;
import java.util.ArrayList;

public class Register {
	public static ArrayList<Person> personer = new ArrayList<Person>();

	static Scanner scan = new Scanner(System.in);

	public static void skapaPerson() {
		String personNamn = l�saString("Vad heter personen?");
		boolean hittad = false;
		Person p = new Person(personNamn);
		for (Person nuvarande : personer) {
			if (nuvarande.h�mtaNamn().equalsIgnoreCase(personNamn)) {
				System.out.println("Personen " + personNamn + " finns redan");
				hittad = true;
			}
		}
		if (!hittad) {
			personer.add(p);
			System.out.println("Personen " + personNamn + " �r skapad.");
		}
	}

	public static void l�ggaTillSmycke(String �gare) {
		Person hittad = finnsPersonen(�gare);
		String guld = null;
		if (hittad != null) {
			String namn = l�saString("Vilket smycke? ");
			int antalStenar = l�saInt("Hur m�nga �delstenar? ");
			for (;;) {
				guld = l�saString("�r det guld? ");
				if (guld.equalsIgnoreCase("ja") || guld.equalsIgnoreCase("nej")) {
					break;
				} else {
					System.out.println("Du m�ste svara ja eller nej.");
				}
			}
			Smycke s = new Smycke(namn, antalStenar, guld);
			hittad.l�ggTillPryl(s);
		}
	}

	public static void l�ggaTillApparat(String �gare) {
		Person hittad = finnsPersonen(�gare);
		int slitage = 0;
		if (hittad != null) {
			String namn = l�saString("Vilken apparat? ");
			for (;;) {
				slitage = l�saInt("Hur mycket �r slitaget? Skala 1-10 d�r 10 betyder helt ny: ");
				if (slitage > 10 || slitage == 0) {
					System.out.println("Slitaget m�ste vara mellan 1-10");
				} else {
					break;
				}
			}
			int ink�pspris = l�saInt("Vad �r ink�pspriset? ");
			Apparat ap = new Apparat(namn, slitage, ink�pspris);
			hittad.l�ggTillPryl(ap);
		}
	}

	public static void l�ggaTillAktie(String �gare) {
		Person hittad = finnsPersonen(�gare);
		if (hittad != null) {
			String namn = l�saString("Vilken aktie? ");
			int antal = l�saInt("Ange antal: ");
			int pris = l�saInt("Ange priset: ");
			Aktie ak = new Aktie(namn, antal, pris);
			hittad.l�ggTillPryl(ak);
		}
	}

	public static int l�saInt(String fr�ga) {
		for (;;) {
			try {
				System.out.print(fr�ga);
				int x = Integer.parseInt(scan.nextLine());
				return x;
			} catch (NumberFormatException e) {
				System.out.println("Fel - skriv in ett heltal");
			}
		}
	}

	public static String l�saString(String fr�ga) {
		System.out.print(fr�ga);
		String z = scan.nextLine();
		return z;
	}

	public static Person finnsPersonen(String �gare) {
		boolean hittaPerson = false;
		for (Person nuvarande : personer) {
			if (nuvarande.h�mtaNamn().equalsIgnoreCase(�gare)) {
				hittaPerson = true;
				return nuvarande;
			}
		}

		if (hittaPerson == false) {
			System.out.println("Personen finns inte");
		}
		return null;
	}

	public static void l�ggTillPryl() {

		String �gare = l�saString("Vad heter �garen? ");
		Person person = finnsPersonen(�gare);
		if (person == null) {
			return;
		}
		boolean tillagd = false;
		do {
			int sort = l�saInt("Vilket alternativ? 1: Smycke, 2: Apparat, 3: Aktie ");
			switch (sort) {
			case 1:
				l�ggaTillSmycke(�gare);
				tillagd = true;
				break;
			case 2:
				l�ggaTillApparat(�gare);
				tillagd = true;
				break;
			case 3:
				l�ggaTillAktie(�gare);
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

				if (nuvarande.h�mtaTotaltV�rde() >= rikast) {
					rikast = nuvarande.h�mtaTotaltV�rde();
					rikastPerson = nuvarande;
				}
				System.out.println("Rikast �r " + rikastPerson.h�mtaNamn()
						+ " som sammanlagt �ger "
						+ rikastPerson.h�mtaTotaltV�rde());
				rikastPerson.skrivUtPryl();
			}
		} catch (NullPointerException n) {
			System.out.println("Inga personer registrerade.");
		}
	}

	public static void visaAlla() {
		System.out.println("I registret finns: ");
		for (Person nuvarande : personer) {
			System.out.println(nuvarande.h�mtaNamn() + "		"
					+ nuvarande.h�mtaTotaltV�rde());
		}
		return;
	}

	public static void visaVissPerson() {
		String vissPerson = l�saString("Vilken person s�ker du? ");
		boolean hittad = false;
		for (Person nuvarande : personer) {
			if (nuvarande.h�mtaNamn().equalsIgnoreCase(vissPerson)) {
				System.out.println("Personen du s�ker �r "
						+ nuvarande.h�mtaNamn() + " som sammanlagt �ger "
						+ nuvarande.h�mtaTotaltV�rde());
				nuvarande.skrivUtPryl();
				hittad = true;
			}
		}
		if (hittad == false) {
			System.out.println("Personen finns inte!");
		}

	}

	public static void b�rskrash() {
		for (Person nuvarande : personer) {
			nuvarande.nollaAktier();
		}
		System.out.println("B�rskrash utf�rd!");
	}

	public static void taBortPerson() {
		String taBort = l�saString("Vilken person vill du ta bort?");
		boolean hittad = false;
		for (int n = 0; n < personer.size(); n++) {
			if (personer.get(n).h�mtaNamn().equalsIgnoreCase(taBort)) {
				personer.remove(n);
				System.out.println("Personen " + taBort + " �r borttagen");
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
					.println("1: L�gg till person | 2: L�gg till pryl "
							+ "| 3: Visa alla personer | 4: Visa rikaste | 5: Visa viss person "
							+ "| 6: B�rskrash | 7: Ta bort person | 8: Avsluta");
			int val = l�saInt("");
			switch (val) {
			case 1:
				skapaPerson();
				break;
			case 2:
				l�ggTillPryl();
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
				b�rskrash();
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
