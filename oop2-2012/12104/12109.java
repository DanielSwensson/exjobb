import java.util.ArrayList;
import java.util.Scanner;

class Vardesaksregister {
	private ArrayList<Person> personer = new ArrayList<Person>();
	private Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Vardesaksregister värdesaksregister = new Vardesaksregister();

		System.out.println("=============================");
		System.out.println("      VÄRDESAKSREGISTER      ");
		System.out.println("=============================");

		System.out.println("\n1. Skapa person");
		System.out.println("2. Skapa värdesak");
		System.out.println("3. Visa alla personer");
		System.out.println("4. Visa rikaste personen");
		System.out.println("5. Visa viss person");
		System.out.println("6. Utför en börskrasch");
		System.out.println("7. Avsluta");

		while (true) {
			int kommando = värdesaksregister.läsInHeltal("\nAnge kommando 1-7: ");

			switch (kommando) {
				case 1: värdesaksregister.skapaPerson(); break;
				case 2: värdesaksregister.skapaVärdesak(); break;
				case 3: värdesaksregister.visaAllaPersoner(); break;
				case 4: värdesaksregister.visaRikastePersonen(); break;
				case 5: värdesaksregister.visaVissPerson(); break;
				case 6: värdesaksregister.utförBörskrasch(); break;
				case 7: värdesaksregister.avsluta(); break;

				default:
					System.out.println("Fel kommando, försök igen");
			}
		}
	}

	void skapaPerson() {
		System.out.println("\nSKAPA PERSON");

		String namn = läsInTextsträng("Nya personens namn: ");

		if (getPerson(namn) != null) {
			System.out.println("Fel, person med det namnet finns redan registrerad");
		} else {
			personer.add(new Person(namn));
			System.out.println("Personen " + namn + " har lagts till i registret.");
		}
	}

	public void skapaVärdesak() {
		System.out.println("\nSKAPA VÄRDESAK");

		if (!personer.isEmpty()) {
			String namn = läsInTextsträng("Vilken person äger värdesaken: ");
			Person person = getPerson(namn);

			if (person == null) {
				System.out.println("Fel, personen " + namn + " finns inte med i registret");
			} else {
				String sortsVärdesak = läsInTextsträng("Vilken sorts värdesak (smycke/aktie/apparat): ");

				if (sortsVärdesak.equalsIgnoreCase("Smycke")) {
					String sortsSmycke = läsInTextsträng("Vilket sorts smycke: ");
					Smycke.MetallSort metallSort;

					while (true) {
						try {
							metallSort = Smycke.MetallSort.valueOf(läsInTextsträng("Vilken metallsort är smycket av (guld/silver): ").toUpperCase());
							break;
						} catch (IllegalArgumentException e) {
							System.out.println("Fel värde, skall vara antingen \"guld\" eller \"silver\"");
						}
					}
					int antalÄdelstenar = läsInHeltal("Antal ädelstenar: ");
					person.registreraVärdesak(new Smycke(sortsSmycke, antalÄdelstenar, metallSort));
				} else if (sortsVärdesak.equalsIgnoreCase("Aktie")) {
					String aktieNamn = läsInTextsträng("Namn på aktien: ");
					int aktieAntal = läsInHeltal("Antal aktier: ");
					int aktiePris = läsInHeltal("Aktiepris: ");

					person.registreraVärdesak(new Aktie(aktieNamn, aktieAntal, aktiePris));
				} else if (sortsVärdesak.equalsIgnoreCase("Apparat")) {
					String sortsApparat = läsInTextsträng("Vilken sorts apparat: ");
					int inköpspris = läsInHeltal("Inköpspris: ");
					int slitage;

					while (true) {
						slitage = läsInHeltal("Slitage (1-10): ");

						if (slitage < 1 || slitage > 10)
							System.out.println("Fel värde, skall ligga mellan 1 och 10");
						else break;
					}
					person.registreraVärdesak(new Apparat(sortsApparat, inköpspris, slitage));
				} else {
					System.out.println("Den sortens värdesak (" + sortsVärdesak + ") finns inte implementerad i programmet än");
					return;
				}

				System.out.println(sortsVärdesak + " har lagts till i listan av värdesaker som tillhör " + namn);
			}
		} else {
		System.out.println("Det finns inga personer i registret än");
		}
	}

	void visaAllaPersoner() {
		System.out.println("\nVISA ALLA PERSONER");

		if (personer.isEmpty()) {
			System.out.println("Det finns inga personer i registret än");
		} else {
			System.out.println("I registret finns:");

			for (Person person : personer) {
				System.out.println(person);
			}
		}
	}

	void visaRikastePersonen() {
		System.out.println("\nVISA RIKASTE PERSONEN");

		ArrayList<Person> rikastePersonerna = getRikastePerson();

		if (rikastePersonerna != null) {
			System.out.println("Rikast är:");

			for (Person rikastPerson : rikastePersonerna) {
				System.out.println(rikastPerson);
				visaPersonsVärdesaker(rikastPerson);
			}
		} else {
			System.out.println("Det finns inga personer i registret än");
		}

	}

	public void visaVissPerson() {
		System.out.println("\nVISA VISS PERSON");

		if (!personer.isEmpty()) {
			String namn = läsInTextsträng("Namn på personen: ");
			Person person = getPerson(namn);

			if (person != null) {
				System.out.println(person.getNamn() + " äger saker för " + person.getVärdesakersSammanlagdaVärde() + " kr");
				visaPersonsVärdesaker(person);
			} else {
				System.out.println("Personen " + namn + " finns inte i registret");
			}
		} else {
			System.out.println("Det finns inga personer i registret än");
		}
	}

	public void utförBörskrasch() {
		System.out.println("\nUTFÖR BÖRSKRASCH");

		if (!personer.isEmpty()) {
			for (Person person : personer) {
				for (Vardesak värdesak : person.getVärdesaker()) {
					if (värdesak instanceof Aktie) {
						((Aktie)värdesak).setPris(0);
					}
				}
			}
			System.out.println("Börskrasch utförd");
		} else {
			System.out.println("Det finns inga personer i registret än");
		}
	}

	private void avsluta() {
		System.out.println("Programmet avslutas, hejdå!");
		System.exit(0);
	}

	private void visaPersonsVärdesaker(Person person) {
		for (Vardesak värdesak : person.getVärdesaker()) {
			System.out.println(värdesak);
		}
	}

	private ArrayList<Person> getRikastePerson() {
		if (personer.isEmpty())
			return null;

		Person rikastPerson = personer.get(0);
		ArrayList<Person> rikastePersoner = new ArrayList<Person>();
		int rikastPersonsVärde = 0;
		int annanPersonsVärde = 0;

		for (int i = 1; i < personer.size(); i++) {
			rikastPersonsVärde = rikastPerson.getVärdesakersSammanlagdaVärde();
			annanPersonsVärde = personer.get(i).getVärdesakersSammanlagdaVärde();

			if (annanPersonsVärde > rikastPersonsVärde) {
				rikastPerson = personer.get(i);
			}
		}

		rikastPersonsVärde = rikastPerson.getVärdesakersSammanlagdaVärde();

		for (int j = 0; j < personer.size(); j++) {
			annanPersonsVärde = personer.get(j).getVärdesakersSammanlagdaVärde();

			if (annanPersonsVärde == rikastPersonsVärde) {
				rikastePersoner.add(personer.get(j));
			}
		}

		return rikastePersoner;
	}

	private Person getPerson(String namn) {
		for (Person person : personer) {
			if (person.getNamn().equalsIgnoreCase(namn)) {
				return person;
			}
		}

		return null;
	}

	private int läsInHeltal(String fråga) {
		while (true) {
			try {
				System.out.print(fråga);
				return Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Fel - skall vara numeriskt värde");
			}
		}
	}

	private String läsInTextsträng(String fråga) {
		System.out.print(fråga);
		String str = sc.nextLine();
		return str;
	}
}
