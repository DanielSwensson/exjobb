import java.util.*;

public class PrylRegisterHuvudprogram {
	Scanner keyboard = new Scanner(System.in);

	ArrayList<Person> allaPersoner = new ArrayList<Person>();

	Person getPerson(String namn) {
		for (Person p : allaPersoner)
			if (p.fåPersonNamn().equalsIgnoreCase(namn))
				return p;
		return null;
	}

	void visaVissPerson() {
		System.out.println("Vilken person är det du söker?");
		String visaDenPersonen = keyboard.nextLine();
		boolean hittad = false;
		for (int sökPerson = 0; sökPerson < allaPersoner.size(); sökPerson++) {
			if (visaDenPersonen.equals(allaPersoner.get(sökPerson)
					.fåPersonNamn())) {
				hittad = true;
				System.out.println(visaDenPersonen + " har totalvärdet:"
						+ allaPersoner.get(sökPerson).totalSummaPerson());
				allaPersoner.get(sökPerson).visaPrylar();
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
		System.out.println(rikaste + " och är den riskaste personen.");
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

		System.out.println("Vilken person äger prylen?");
		String prylÄgare = keyboard.nextLine();

		Person tmpPerson = null;

		for (int sökaÄgare = 0; sökaÄgare < allaPersoner.size(); sökaÄgare++) {
			if (allaPersoner.get(sökaÄgare).fåPersonNamn().equals(prylÄgare)) {
				tmpPerson = allaPersoner.get(sökaÄgare);
			}
		}
		if (tmpPerson != null) {
			System.out.println(prylÄgare + " har valts.");
		} else if (tmpPerson == null) {
			System.out.println("Person finns ej.");
			return;
		}

		try {
			System.out
					.println("Är prylen ett 1.smycke, 2.aktie eller 3.apparat?");
			int prylVal = Integer.parseInt(keyboard.nextLine());

			switch (prylVal) {
			case 1:

				System.out.println("Vilket sorts smycke är det?");
				String smyckeNamn = keyboard.nextLine();
				System.out.println("Är smycket gjort av guld eller silver?");
				String smyckeTyp = keyboard.nextLine();
				if (((smyckeTyp.equals("guld")))
						|| ((smyckeTyp.equals("silver")))) {
				} else {
					System.out.println("Fel. Endast guld eller silver.");
					return;
				}
				System.out.println("Hur många ädelstenar har smycket?");
				try {
					int antalStenar = Integer.parseInt(keyboard.nextLine());
					Pryl nyttSmycke = new Smycke(smyckeNamn, antalStenar,
							smyckeTyp);
					tmpPerson.läggTillPryl(nyttSmycke);
					System.out.println("Smycket har lagts till.");
				} catch (java.lang.NumberFormatException error4) {
					System.out.println("Fel. Måste vara ett nummer.");
				}
				break;

			case 2:

				System.out.println("Vad är det för typ av aktie/aktier?");
				String aktieTyp = keyboard.nextLine();
				System.out.println("Hur många aktier är det?");
				try {
					int antalAktier = Integer.parseInt(keyboard.nextLine());
					System.out.println("Vad är det totala priset?");
					double värdeAktier = Double
							.parseDouble(keyboard.nextLine());
					Pryl nyAktie = new Aktie(aktieTyp, antalAktier, värdeAktier);
					tmpPerson.läggTillPryl(nyAktie);
				} catch (java.lang.NumberFormatException error2) {
					System.out.println("Fel, måste vara ett nummer.");
				}
				break;

			case 3:

				System.out.println("Vad är det för slags apparat?");
				String apparatTyp = keyboard.nextLine();
				System.out
						.println("Hur är slitaget på en skala 1-10? (1 innebär mest slitage och vid 10 är apparaten som ny.)");
				int slitageNivå = Integer.parseInt(keyboard.nextLine());
				if (slitageNivå >= 1 && slitageNivå <= 10) {
				} else {
					System.out
							.println("Fel skala. Endast tal mellan 1 och 10.");
					return;
				}

				System.out.println("Vad är priset på apparaten?");
				try {
					double apparatPris = Double
							.parseDouble(keyboard.nextLine());
					Pryl nyApparat = new Apparat(apparatTyp, slitageNivå,
							apparatPris);
					tmpPerson.läggTillPryl(nyApparat);
				} catch (java.lang.NumberFormatException error3) {
					System.out.println("Fel. Måste vara ett nummer.");
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

	void börskrasch() {
		for (Person p : allaPersoner) {
			p.sättAktie();
		}
		System.out.println("Alla aktier har nu prisvärdet 0.");

	}

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);
		PrylRegisterHuvudprogram huvudP = new PrylRegisterHuvudprogram();

		boolean programOk;

		do {
			programOk = true;

			for (;;) {
				System.out
						.println("1.Skapa Person. 2.Skapa Pryl. 3. Visa register. 4.Visa rikaste. 5. Visa viss person. 6.Börskrasch. 7.Avsluta.");
				System.out.println("Vad vill du göra? Ange kommando 1-7: ");
				int användarVal = 0;
				try {
					användarVal = Integer.parseInt(keyboard.nextLine());
				} catch (Exception error) {
					programOk = false;
				}

				switch (användarVal) {
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
					huvudP.börskrasch();
					break;
				case 7:
					System.out.println("Avslutar. Hejdå!");
					System.exit(0);
				default:
					System.out.println("Fel kommando, försök igen!");
				}
			}

		} while (!programOk);
	}
}
