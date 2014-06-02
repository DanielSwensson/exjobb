import java.util.*;

public class HuvudProgram {
	static HuvudProgram hp = new HuvudProgram();
	ArrayList<Person> allaPersoner = new ArrayList<Person>();
	static Scanner keyboard = new Scanner(System.in);

	int l�sInt(String fr�ga) {
		while (true) {
			System.out.println(fr�ga);
			try {
				int svar = keyboard.nextInt();
				keyboard.nextLine();
				return svar;
			} catch (InputMismatchException e) {
				System.out.println("Ska vara ett numeriskt v�rde");
			}
			keyboard.nextLine();
		}
	}

	double l�sDouble(String fr�ga) {
		while (true) {
			System.out.println(fr�ga);
			try {
				double svar = keyboard.nextDouble();
				keyboard.nextLine();
				return svar;
			} catch (InputMismatchException e) {
				System.out.println("Ska vara ett numeriskt v�rde");
				keyboard.nextLine();
			}
		}

	}

	String l�sString(String fr�ga) {
		System.out.print(fr�ga);
		String svar = keyboard.nextLine();
		return svar;
	}

	Person h�mtaPerson(String namn) {
		for (Person p : allaPersoner)
			if (p.h�mtaNamn().equals(namn))
				return p;
		return null;
	}

	void skapaPerson() {
		String namn = l�sString("Namn:");
		Person p = h�mtaPerson(namn);
		if (p != null)
			System.out.print("Den personen �r redan registrerad\n");
		else {
			Person ny = new Person(namn);
			allaPersoner.add(ny);
		}
	}

	void skapaPryl() {
		int svar = 0;
		while (svar != 1 && svar != 2 && svar != 3)
			svar = l�sInt("Ange kommando 1-3 f�r vilken typ av pryl du vill skapa\n1.Aktie\n2.Smycke\n3.Apparat");
		if (svar == 1) {
			String namn = l�sString("Namn p� aktie:");
			double pris = -1;
			while (pris < 0)
				pris = l�sDouble("Pris:");
			int antal = -1;
			while (antal < 0)
				antal = l�sInt("Antal:");
			Aktie ak = new Aktie(namn, pris, antal);
			String �gare = l�sString("�gare:");
			Person p = h�mtaPerson(�gare);
			if (p != null) {
				p.l�ggTillPryl(ak);

			} else {
				System.out.println("�garen du f�rs�ker n� �r inte registrerad");
				ak = null;

			}
		} else if (svar == 2) {
			int typ = 0;
			String namn = l�sString("Namn p� smycke:");
			while (typ != 1 && typ != 2)
				typ = l�sInt("Typ\n1.Guld\n2.Silver");
			int antal�delstenar = -1;
			while (antal�delstenar < 0)
				antal�delstenar = l�sInt("Antal �delstenar:");
			Smycke sm = new Smycke(namn, typ, antal�delstenar);
			String �gare = l�sString("�gare:");
			Person p = h�mtaPerson(�gare);
			if (p != null) {
				p.l�ggTillPryl(sm);

			} else {
				System.out.println("�garen du f�rs�ker n� �r inte registrerad");
				sm = null;

			}
		}

		else if (svar == 3) {
			int slitageNummer = 0;
			String namn = l�sString("Namn p� Apparat:");
			int ink�psPris = -1;
			while (ink�psPris < 0)
				ink�psPris = l�sInt("Ink�psPris:");
			while (slitageNummer <= 0 || slitageNummer >= 11)
				slitageNummer = l�sInt("Skriv in ett slitagenummer 1-10");
			Apparat ap = new Apparat(namn, slitageNummer, ink�psPris);
			String �gare = l�sString("�gare:");
			Person p = h�mtaPerson(�gare);
			if (p != null) {
				p.l�ggTillPryl(ap);

			} else {
				System.out.println("�garen du f�rs�ker n� �r inte registrerad");
				ap = null;
			}
		}

		else
			System.out.println("Felaktigt kommando");
	}

	void visaAlla() {
		System.out.println("I registret finns:");
		for (Person p : allaPersoner)
			System.out.println(p.h�mtaNamn() + '\t' + p.h�mtaTotaltV�rde()
					+ "kr");

	}

	void visaRikaste() {
		int h�gstaV�rde = allaPersoner.get(0).h�mtaTotaltV�rde();
		int h�gstaIndex = 0;
		for (int x = 0; x < allaPersoner.size(); x++) {
			int v�rde = allaPersoner.get(x).h�mtaTotaltV�rde();
			if (v�rde > h�gstaV�rde) {
				h�gstaV�rde = v�rde;
				h�gstaIndex = x;
			}
		}
		System.out.println("Den rikaste personen �r "
				+ allaPersoner.get(h�gstaIndex).h�mtaNamn() + " som har "
				+ allaPersoner.get(h�gstaIndex).h�mtaTotaltV�rde() + "kr");

	}

	void visaVissPerson() {
		String namn = l�sString("Skriv in namnet p� personen som du vill visa:");
		Person p = h�mtaPerson(namn);
		if (p != null)
			System.out.print(p.h�mtaPrylLista());
		else
			System.out.println("Personen du s�ker finns inte registrerad");

	}

	void b�rsKrasch() {
		for (int x = 0; x < allaPersoner.size(); x++)
			allaPersoner.get(x).b�rsKrasch();
		System.out.println("Alla aktiev�rden har satts till 0");
	}

	public static void main(String[] args) {

		while (true) {
			int val = hp.l�sInt("Ange kommando 1-7\n" + "1.Skapa person\n"
					+ "2.Skapa pryl\n" + "3.Visa alla\n" + "4.Visa rikaste\n"
					+ "5.Visa viss person\n" + "6.B�rskrasch\n"
					+ "7.Avsluta programmet");
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
				hp.b�rsKrasch();
				break;
			case 7:
				System.exit(0);
			default:
				System.out.println("Fel kommando");
			}
		}

	}
}
