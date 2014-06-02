import java.util.*;

public class PrylRegisterHuvudprogram {
	Scanner keyboard = new Scanner(System.in);

	ArrayList<Person> allaPersoner = new ArrayList<Person>();

	Person getPerson(String namn) {
		for (Person p : allaPersoner)
			if (p.f�PersonNamn().equalsIgnoreCase(namn))
				return p;
		return null;
	}

	void visaVissPerson() {
		System.out.println("Vilken person �r det du s�ker?");
		String visaDenPersonen = keyboard.nextLine();
		boolean hittad = false;
		for (int s�kPerson = 0; s�kPerson < allaPersoner.size(); s�kPerson++) {
			if (visaDenPersonen.equals(allaPersoner.get(s�kPerson)
					.f�PersonNamn())) {
				hittad = true;
				System.out.println(visaDenPersonen + " har totalv�rdet:"
						+ allaPersoner.get(s�kPerson).totalSummaPerson());
				allaPersoner.get(s�kPerson).visaPrylar();
			}
		}
		if (!hittad) {
			System.out.println("Personen finns ej.");
		}
	}

	void visaRikaste() {
		Person rikaste = new Person("ingen");
		for (int dennaPerson = 0; dennaPerson < allaPersoner.size(); dennaPerson++) {
			if (allaPersoner.get(dennaPerson).totalSummaPerson() >= rikaste
					.totalSummaPerson()) {
				rikaste = allaPersoner.get(dennaPerson);
			}
		}
		System.out.println(rikaste + " och �r den riskaste personen.");
		(rikaste).visaPrylar();
	}

	void skapaPerson() {
		System.out.println("Ange personens namn: ");
		String namn = keyboard.nextLine();
		Person p = getPerson(namn);
		if (p != null) {
			System.out.println("Fel. Personen finns redan.");
		} else {
			Person ny = new Person(namn);
			allaPersoner.add(ny);
			System.out.println(namn + " har lagts till.");
		}
	}

	void skapaPryl() {

		System.out.println("Vilken person �ger prylen?");
		String pryl�gare = keyboard.nextLine();

		Person tmpPerson = null;

		for (int s�ka�gare = 0; s�ka�gare < allaPersoner.size(); s�ka�gare++) {
			if (allaPersoner.get(s�ka�gare).f�PersonNamn().equals(pryl�gare)) {
				tmpPerson = allaPersoner.get(s�ka�gare);
			}
		}
		if (tmpPerson != null) {
			System.out.println(pryl�gare + " har valts.");
		} else if (tmpPerson == null) {
			System.out.println("Person finns ej.");
			return;
		}

		try {
			System.out
					.println("�r prylen ett 1.smycke, 2.aktie eller 3.apparat?");
			int prylVal = Integer.parseInt(keyboard.nextLine());

			switch (prylVal) {
			case 1:

				System.out.println("Vilket sorts smycke �r det?");
				String smyckeNamn = keyboard.nextLine();
				System.out.println("�r smycket gjort av guld eller silver?");
				String smyckeTyp = keyboard.nextLine();
				if (((smyckeTyp.equals("guld")))
						|| ((smyckeTyp.equals("silver")))) {
				} else {
					System.out.println("Fel. Endast guld eller silver.");
					return;
				}
				System.out.println("Hur m�nga �delstenar har smycket?");
				try {
					int antalStenar = Integer.parseInt(keyboard.nextLine());
					Pryl nyttSmycke = new Smycke(smyckeNamn, antalStenar,
							smyckeTyp);
					tmpPerson.l�ggTillPryl(nyttSmycke);
					System.out.println("Smycket har lagts till.");
				} catch (java.lang.NumberFormatException error4) {
					System.out.println("Fel. M�ste vara ett nummer.");
				}
				break;

			case 2:

				System.out.println("Vad �r det f�r typ av aktie/aktier?");
				String aktieTyp = keyboard.nextLine();
				System.out.println("Hur m�nga aktier �r det?");
				try {
					int antalAktier = Integer.parseInt(keyboard.nextLine());
					System.out.println("Vad �r det totala priset?");
					double v�rdeAktier = Double
							.parseDouble(keyboard.nextLine());
					Pryl nyAktie = new Aktie(aktieTyp, antalAktier, v�rdeAktier);
					tmpPerson.l�ggTillPryl(nyAktie);
				} catch (java.lang.NumberFormatException error2) {
					System.out.println("Fel, m�ste vara ett nummer.");
				}
				break;

			case 3:

				System.out.println("Vad �r det f�r slags apparat?");
				String apparatTyp = keyboard.nextLine();
				System.out
						.println("Hur �r slitaget p� en skala 1-10? (1 inneb�r mest slitage och vid 10 �r apparaten som ny.)");
				int slitageNiv� = Integer.parseInt(keyboard.nextLine());
				if (slitageNiv� >= 1 && slitageNiv� <= 10) {
				} else {
					System.out
							.println("Fel skala. Endast tal mellan 1 och 10.");
					return;
				}

				System.out.println("Vad �r priset p� apparaten?");
				try {
					double apparatPris = Double
							.parseDouble(keyboard.nextLine());
					Pryl nyApparat = new Apparat(apparatTyp, slitageNiv�,
							apparatPris);
					tmpPerson.l�ggTillPryl(nyApparat);
				} catch (java.lang.NumberFormatException error3) {
					System.out.println("Fel. M�ste vara ett nummer.");
				}
				break;

			default:
				System.out.println("Fel kommando.");

			}
		} catch (Exception error3) {
			System.out.println("Fel kommando.");
		}
	}

	void visaAlla() {
		System.out.println("I registret finns: ");
		for (int personRegister = 0; personRegister < allaPersoner.size(); personRegister++) {
			System.out.println(allaPersoner.get(personRegister));
		}
	}

	void b�rskrasch() {
		for (Person p : allaPersoner) {
			p.s�ttAktie();
		}
		System.out.println("Alla aktier har nu prisv�rdet 0.");

	}

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);
		PrylRegisterHuvudprogram huvudP = new PrylRegisterHuvudprogram();

		boolean programOk;

		do {
			programOk = true;

			for (;;) {
				System.out
						.println("1.Skapa Person. 2.Skapa Pryl. 3. Visa register. 4.Visa rikaste. 5. Visa viss person. 6.B�rskrasch. 7.Avsluta.");
				System.out.println("Vad vill du g�ra? Ange kommando 1-7: ");
				int anv�ndarVal = 0;
				try {
					anv�ndarVal = Integer.parseInt(keyboard.nextLine());
				} catch (Exception error) {
					programOk = false;
				}

				switch (anv�ndarVal) {
				case 1:
					huvudP.skapaPerson();
					break;
				case 2:
					huvudP.skapaPryl();
					break;
				case 3:
					huvudP.visaAlla();
					break;
				case 4:
					huvudP.visaRikaste();
					break;
				case 5:
					huvudP.visaVissPerson();
					break;
				case 6:
					huvudP.b�rskrasch();
					break;
				case 7:
					System.out.println("Avslutar. Hejd�!");
					System.exit(0);
				default:
					System.out.println("Fel kommando, f�rs�k igen!");
				}
			}

		} while (!programOk);
	}
}
