// Av Emil Isaksson & Oscar Larsson DSK:1 OOP HT12                    

import java.util.ArrayList;
import java.util.Scanner;

public class HuvudProgram {
	ArrayList<Person> alla = new ArrayList<Person>();
	Scanner keyboard = new Scanner(System.in);

	int readInt(String fr�ga) {
		for (;;) {
			try {
				System.out.println(fr�ga);
				int x = Integer.parseInt(keyboard.nextLine());
				return x;
			} catch (NumberFormatException e) {
				System.out.println("Fel - skall vara numeriskt v�rde");
			}
		}
	}

	String readString(String fr�ga) {
		System.out.println(fr�ga);
		String str = keyboard.nextLine();
		return str;

	}

	Person getPerson(String namn) {
		for (Person p : alla)
			if (p.getPersonNamn().equalsIgnoreCase(namn))
				return p;
		return null;
	}

	void skapaPerson() {
		String namn = readString("Nya personens namn: ");
		Person p = getPerson(namn);
		if (p != null)
			System.out.println("Den personen finns redan");
		else {
			Person nyPerson = new Person(namn);
			alla.add(nyPerson);
			System.out.println(namn + " har registreats.");// har lagts till
		}
	}

	void skapaPryl() {
		String vilken�gare = readString("�gare: ");
		boolean hittad = false;
		Person p = null;

		for (int i = 0; i < alla.size(); i++) {
			if (alla.get(i).getPersonNamn().equalsIgnoreCase(vilken�gare)) {
				hittad = true;
				p = alla.get(i);
			}
		}

		if (hittad == false) {
			System.out.println(vilken�gare
					+ " finns inte registrerad i systemet!");
		}

		if (hittad != false) {

			String prylTyp = readString("Vilken sorts pryl: Aktie, apparat eller smycke?");

			if (prylTyp.equalsIgnoreCase("aktie")) {
				String prylNamn = readString("Aktienamn: ");
				int aktiePris = readInt("Pris: ");
				int aktieAntal = readInt("Antal: ");
				Aktie nyAktie = new Aktie(prylNamn, aktieAntal, aktiePris);
				p.addAllaPrylar(nyAktie);
				System.out.println("Aktie " + prylNamn + " har registrerats!");
			} else if (prylTyp.equalsIgnoreCase("apparat")) {
				String prylNamn = readString("Vilken typ av apparat: ");
				int ink�pspris = readInt("Ink�pspris: ");
				int slitage = readInt("Slitage(Skala 1-10)");
				Apparat nyApparat = new Apparat(prylNamn, ink�pspris, slitage);
				p.addAllaPrylar(nyApparat);
				System.out.println("Apparaten " + prylNamn
						+ " har registrerats!");
			} else if (prylTyp.equalsIgnoreCase("smycke")) {
				String prylNamn = readString("Vilken sorts smycke: ");
				String guldSant = null;
				boolean guld = false;
				do {
					guldSant = readString("�r smycket av guld?(Ja eller Nej)");

					if (guldSant.equalsIgnoreCase("ja")) {
						guld = true;
					}

				} while (!guldSant.equalsIgnoreCase("ja")
						&& !guldSant.equalsIgnoreCase("nej"));

				int antal�delstenar = readInt("Antal �delstenar: ");
				Smycke nyttSmycke = new Smycke(prylNamn, antal�delstenar, guld);
				p.addAllaPrylar(nyttSmycke);
				System.out
				.println("Smycket " + prylNamn + " har registrerats!");
			} else {
				System.out.println("Denna typ av pryl finns inte!");
			}
		}
	}

	void visaAlla() {
		for (int i = 0; i < alla.size(); i++) {
			System.out.println(alla.get(i).getPersonNamn() + " "
					+ alla.get(i).getV�rde());
		}
	}

	void visaRikaste() {
		Person rikast = null;
		if (!alla.isEmpty()) {
			rikast = alla.get(0);
		}
		for (int i = 0; i < alla.size(); i++) {
			alla.get(i).getV�rde();
			if (alla.get(i).getV�rde() > rikast.getV�rde())
				rikast = alla.get(i);
		}

		if (alla.isEmpty()) {
			System.out.println("Finns inga listade personer! ");
		} else {
			System.out.print(rikast.getPersonNamn() + " �r rikast och �ger: \n"
					+ rikast.listaAllaPrylar());
		}
	}

	void visaViss() {
		String hittaPerson = readString("Vem vill du visa? ");
		boolean found = false;
		for (int x = 0; x < alla.size(); x++)

			if (alla.get(x).getPersonNamn().equalsIgnoreCase(hittaPerson)) {
				found = true;
				System.out.println(alla.get(x).getPersonNamn() + "\n "
						+ alla.get(x).listaAllaPrylar() + "\n");
			}
		if (found == false) {
			System.out.println(hittaPerson + " finns inte");

		}
	}

	void b�rskrasch() {
		for (int i = 0; i < alla.size(); i++) {
			alla.get(i).getB�rskrasch();
		}
		System.out.println("B�rsen har kraschat! ");
	}

	public static void main(String[] args) {
		HuvudProgram hp = new HuvudProgram();
		System.out.println("Hej och v�lkommen till Prylprogrammet.");
		for (;;) {
			int val = hp
					.readInt("Ange kommando: \n1. Skapa person\n2. Skapa pryl\n3. Visa alla \n4. Visa rikaste \n5. Visa viss person \n6. B�rskrasch\n7. Avsluta");
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