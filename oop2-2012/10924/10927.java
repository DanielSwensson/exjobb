import java.util.*;

public class HuvudProgram {
	static HuvudProgram hp = new HuvudProgram();
	ArrayList<Person> allaPersoner = new ArrayList<Person>();
	static Scanner keyboard = new Scanner(System.in);

	int läsInt(String fråga) {
		while (true) {
			System.out.println(fråga);
			try {
				int svar = keyboard.nextInt();
				keyboard.nextLine();
				return svar;
			} catch (InputMismatchException e) {
				System.out.println("Ska vara ett numeriskt värde");
			}
			keyboard.nextLine();
		}
	}

	double läsDouble(String fråga) {
		while (true) {
			System.out.println(fråga);
			try {
				double svar = keyboard.nextDouble();
				keyboard.nextLine();
				return svar;
			} catch (InputMismatchException e) {
				System.out.println("Ska vara ett numeriskt värde");
				keyboard.nextLine();
			}
		}

	}

	String läsString(String fråga) {
		System.out.print(fråga);
		String svar = keyboard.nextLine();
		return svar;
	}

	Person hämtaPerson(String namn) {
		for (Person p : allaPersoner)
			if (p.hämtaNamn().equals(namn))
				return p;
		return null;
	}

	void skapaPerson() {
		String namn = läsString("Namn:");
		Person p = hämtaPerson(namn);
		if (p != null)
			System.out.print("Den personen är redan registrerad\n");
		else {
			Person ny = new Person(namn);
			allaPersoner.add(ny);
		}
	}

	void skapaPryl() {
		int svar = 0;
		while (svar != 1 && svar != 2 && svar != 3)
			svar = läsInt("Ange kommando 1-3 för vilken typ av pryl du vill skapa\n1.Aktie\n2.Smycke\n3.Apparat");
		if (svar == 1) {
			String namn = läsString("Namn på aktie:");
			double pris = -1;
			while (pris < 0)
				pris = läsDouble("Pris:");
			int antal = -1;
			while (antal < 0)
				antal = läsInt("Antal:");
			Aktie ak = new Aktie(namn, pris, antal);
			String ägare = läsString("Ägare:");
			Person p = hämtaPerson(ägare);
			if (p != null) {
				p.läggTillPryl(ak);

			} else {
				System.out.println("Ägaren du försöker nå är inte registrerad");
				ak = null;

			}
		} else if (svar == 2) {
			int typ = 0;
			String namn = läsString("Namn på smycke:");
			while (typ != 1 && typ != 2)
				typ = läsInt("Typ\n1.Guld\n2.Silver");
			int antalÄdelstenar = -1;
			while (antalÄdelstenar < 0)
				antalÄdelstenar = läsInt("Antal ädelstenar:");
			Smycke sm = new Smycke(namn, typ, antalÄdelstenar);
			String ägare = läsString("Ägare:");
			Person p = hämtaPerson(ägare);
			if (p != null) {
				p.läggTillPryl(sm);

			} else {
				System.out.println("Ägaren du försöker nå är inte registrerad");
				sm = null;

			}
		}

		else if (svar == 3) {
			int slitageNummer = 0;
			String namn = läsString("Namn på Apparat:");
			int inköpsPris = -1;
			while (inköpsPris < 0)
				inköpsPris = läsInt("InköpsPris:");
			while (slitageNummer <= 0 || slitageNummer >= 11)
				slitageNummer = läsInt("Skriv in ett slitagenummer 1-10");
			Apparat ap = new Apparat(namn, slitageNummer, inköpsPris);
			String ägare = läsString("Ägare:");
			Person p = hämtaPerson(ägare);
			if (p != null) {
				p.läggTillPryl(ap);

			} else {
				System.out.println("Ägaren du försöker nå är inte registrerad");
				ap = null;
			}
		}

		else
			System.out.println("Felaktigt kommando");
	}

	void visaAlla() {
		System.out.println("I registret finns:");
		for (Person p : allaPersoner)
			System.out.println(p.hämtaNamn() + '\t' + p.hämtaTotaltVärde()
					+ "kr");

	}

	void visaRikaste() {
		int högstaVärde = allaPersoner.get(0).hämtaTotaltVärde();
		int högstaIndex = 0;
		for (int x = 0; x < allaPersoner.size(); x++) {
			int värde = allaPersoner.get(x).hämtaTotaltVärde();
			if (värde > högstaVärde) {
				högstaVärde = värde;
				högstaIndex = x;
			}
		}
		System.out.println("Den rikaste personen är "
				+ allaPersoner.get(högstaIndex).hämtaNamn() + " som har "
				+ allaPersoner.get(högstaIndex).hämtaTotaltVärde() + "kr");

	}

	void visaVissPerson() {
		String namn = läsString("Skriv in namnet på personen som du vill visa:");
		Person p = hämtaPerson(namn);
		if (p != null)
			System.out.print(p.hämtaPrylLista());
		else
			System.out.println("Personen du söker finns inte registrerad");

	}

	void börsKrasch() {
		for (int x = 0; x < allaPersoner.size(); x++)
			allaPersoner.get(x).börsKrasch();
		System.out.println("Alla aktievärden har satts till 0");
	}

	public static void main(String[] args) {

		while (true) {
			int val = hp.läsInt("Ange kommando 1-7\n" + "1.Skapa person\n"
					+ "2.Skapa pryl\n" + "3.Visa alla\n" + "4.Visa rikaste\n"
					+ "5.Visa viss person\n" + "6.Börskrasch\n"
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
				hp.börsKrasch();
				break;
			case 7:
				System.exit(0);
			default:
				System.out.println("Fel kommando");
			}
		}

	}
}
