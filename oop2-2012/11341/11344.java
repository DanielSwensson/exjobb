// Av Emil Isaksson & Oscar Larsson DSK:1 OOP HT12                    

import java.util.ArrayList;
import java.util.Scanner;

public class HuvudProgram {
	ArrayList<Person> alla = new ArrayList<Person>();
	Scanner keyboard = new Scanner(System.in);

	int readInt(String fråga) {
		for (;;) {
			try {
				System.out.println(fråga);
				int x = Integer.parseInt(keyboard.nextLine());
				return x;
			} catch (NumberFormatException e) {
				System.out.println("Fel - skall vara numeriskt värde");
			}
		}
	}

	String readString(String fråga) {
		System.out.println(fråga);
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
		String vilkenÄgare = readString("Ägare: ");
		boolean hittad = false;
		Person p = null;

		for (int i = 0; i < alla.size(); i++) {
			if (alla.get(i).getPersonNamn().equalsIgnoreCase(vilkenÄgare)) {
				hittad = true;
				p = alla.get(i);
			}
		}

		if (hittad == false) {
			System.out.println(vilkenÄgare
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
				int inköpspris = readInt("Inköpspris: ");
				int slitage = readInt("Slitage(Skala 1-10)");
				Apparat nyApparat = new Apparat(prylNamn, inköpspris, slitage);
				p.addAllaPrylar(nyApparat);
				System.out.println("Apparaten " + prylNamn
						+ " har registrerats!");
			} else if (prylTyp.equalsIgnoreCase("smycke")) {
				String prylNamn = readString("Vilken sorts smycke: ");
				String guldSant = null;
				boolean guld = false;
				do {
					guldSant = readString("Är smycket av guld?(Ja eller Nej)");

					if (guldSant.equalsIgnoreCase("ja")) {
						guld = true;
					}

				} while (!guldSant.equalsIgnoreCase("ja")
						&& !guldSant.equalsIgnoreCase("nej"));

				int antalÄdelstenar = readInt("Antal ädelstenar: ");
				Smycke nyttSmycke = new Smycke(prylNamn, antalÄdelstenar, guld);
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
					+ alla.get(i).getVärde());
		}
	}

	void visaRikaste() {
		Person rikast = null;
		if (!alla.isEmpty()) {
			rikast = alla.get(0);
		}
		for (int i = 0; i < alla.size(); i++) {
			alla.get(i).getVärde();
			if (alla.get(i).getVärde() > rikast.getVärde())
				rikast = alla.get(i);
		}

		if (alla.isEmpty()) {
			System.out.println("Finns inga listade personer! ");
		} else {
			System.out.print(rikast.getPersonNamn() + " är rikast och äger: \n"
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

	void börskrasch() {
		for (int i = 0; i < alla.size(); i++) {
			alla.get(i).getBörskrasch();
		}
		System.out.println("Börsen har kraschat! ");
	}

	public static void main(String[] args) {
		HuvudProgram hp = new HuvudProgram();
		System.out.println("Hej och välkommen till Prylprogrammet.");
		for (;;) {
			int val = hp
					.readInt("Ange kommando: \n1. Skapa person\n2. Skapa pryl\n3. Visa alla \n4. Visa rikaste \n5. Visa viss person \n6. Börskrasch\n7. Avsluta");
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