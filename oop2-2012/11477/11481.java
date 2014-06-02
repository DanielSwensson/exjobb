import java.util.*;

public class Huvudprogram {

	ArrayList<Person> allaPersoner = new ArrayList<Person>();
	Scanner keyboard = new Scanner(System.in);

	double readDouble(String fr�ga) {

		System.out.print(fr�ga);
		double d = keyboard.nextDouble();
		keyboard.nextLine();
		return d;

	}

	int readInt(String fr�ga) {
		for (;;) {
			try {
				System.out.print(fr�ga);
				int x = Integer.parseInt(keyboard.nextLine());
				return x;

			}

			catch (NumberFormatException e) {
				System.out.println("Fel! Det ska vara numeriskt v�rde.");

			}
		}
	}

	String readString(String fr�ga) {
		System.out.print(fr�ga);
		String str = keyboard.nextLine();
		return str;

	}

	void visaAlla() {

		String namnet = null;

		double f�rm = 0.0;

		for (Person p : allaPersoner) {

			namnet = p.getNamn();
			f�rm = p.f�rm�genhet();

			System.out.println(namnet + " " + f�rm);

		}

	}

	Person getPerson(String namn) {
		for (Person p : allaPersoner)
			if (p.getNamn().equalsIgnoreCase(namn))
				return p;
		return null;

	}

	public void b�rscrasch() {
		for (Person den : allaPersoner) {
			den.crascha();

		}

	}

	public void visaRikaste() {

		double summa = 0.0;

		Person x = null;

		for (Person p : allaPersoner) {

			if (p.f�rm�genhet() > summa) {
				summa = p.f�rm�genhet();

				x = p;

			}
		}

		if (x != null) {
			System.out.print("Rikast �r ");
			x.toString();
		}
	}

	public void visaViss() {
		String angiven = readString("Ange namn p� personen du vill visa:");
		Person p = getPerson(angiven);

		if (p != null) {
			p.toString();

		} else {
			System.out.println("Personen hittades inte!");

		}

	}

	void skapaPerson() {
		String namn = readString("Ange personens namn:");
		Person p = getPerson(namn);
		if (p != null) {
			System.out.println("Den angivna personen finns redan i registret.");
		} else {
			Person ny = new Person(namn);
			allaPersoner.add(ny);

			System.out.println("Personen har registrerats");

		}
	}

	void skapaApparat(Person p) {
		String namn = readString("Ange typ f�r apparaten(tv, stereo,etc.):");
		int ink�pspris = readInt("Ange apparatens ink�pspris:");
		int slitage = readInt("Ange apparatens slitage p� en tiogradigskala d�r 10 = helt ny:");

		Pryl app = new Apparat(namn, ink�pspris, slitage);

		p.tillPrylSamling(app);

		System.out.println("Apparaten har registrerats");

	}

	void skapaAktiepost(Person p) {
		String namn = readString("Ange aktiepostens namn:");
		int antal = readInt("Ange antal aktier:");
		int pris = readInt("Ange aktiens styckpris:");

		Aktiepost akt = new Aktiepost(namn, pris, antal);

		p.tillPrylSamling(akt);

		System.out.println("Aktieposten har registrerats");

	}

	void skapaSmycke(Person p) {
		String namn = readString("Ange vad det �r f�r sorts smycke:");
		String metall = readString("Ange vad det �r f�r material, guld eller silver:");
		int antalStenar = readInt("Ange antal �delstenar:");

		Smycke s = new Smycke(namn, metall, antalStenar);

		p.tillPrylSamling(s);

		System.out.println("Smycket �r registrerad");

	}

	void skapaPryl() {

		String �gare = readString("Ange �garens namn:");
		Person p = getPerson(�gare);

		if (p != null) {

			System.out.println("1-smycke\n2-aktiepost\n"
					+ "3-apparat\n4-avbryt");

			int typ = readInt("Ange typ av pryl du vill registrera:");

			switch (typ) {

			case 1:
				skapaSmycke(p);
				break;

			case 2:
				skapaAktiepost(p);
				break;

			case 3:
				skapaApparat(p);
				break;

			case 4:
				break;

			default:
				System.out.println("Fel kommando!Prova igen.");

			}

		}

		else {
			System.out.println("Den angivna personen hittades inte.");
		}

	}

	public static void main(String[] args) {
		Huvudprogram hp = new Huvudprogram();
		System.out.println("Hej och v�lkommen till Prylprogrammet!");

		for (;;) {
			System.out.print("1-Skapa person\n2-Skapa pryl\n"
					+ "3-Visa alla\n4-Visa rikaste\n"
					+ "5-Visa viss\n6-B�rskrasch\n" + "7-Avsluta\n");
			int kom = hp.readInt("Ange kommando 1-7:");

			switch (kom) {
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
				hp.b�rscrasch();

				break;

			case 7:
				System.out.println(" Tack och hej!");

				System.exit(0);
			default:
				System.out.println("Felaktigt kommando.");

			}
		}

	}
}
