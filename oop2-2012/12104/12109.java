import java.util.ArrayList;
import java.util.Scanner;

class Vardesaksregister {
	private ArrayList<Person> personer = new ArrayList<Person>();
	private Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Vardesaksregister v�rdesaksregister = new Vardesaksregister();

		System.out.println("=============================");
		System.out.println("      V�RDESAKSREGISTER      ");
		System.out.println("=============================");

		System.out.println("\n1. Skapa person");
		System.out.println("2. Skapa v�rdesak");
		System.out.println("3. Visa alla personer");
		System.out.println("4. Visa rikaste personen");
		System.out.println("5. Visa viss person");
		System.out.println("6. Utf�r en b�rskrasch");
		System.out.println("7. Avsluta");

		while (true) {
			int kommando = v�rdesaksregister.l�sInHeltal("\nAnge kommando 1-7: ");

			switch (kommando) {
				case 1: v�rdesaksregister.skapaPerson(); break;
				case 2: v�rdesaksregister.skapaV�rdesak(); break;
				case 3: v�rdesaksregister.visaAllaPersoner(); break;
				case 4: v�rdesaksregister.visaRikastePersonen(); break;
				case 5: v�rdesaksregister.visaVissPerson(); break;
				case 6: v�rdesaksregister.utf�rB�rskrasch(); break;
				case 7: v�rdesaksregister.avsluta(); break;

				default:
					System.out.println("Fel kommando, f�rs�k igen");
			}
		}
	}

	void skapaPerson() {
		System.out.println("\nSKAPA PERSON");

		String namn = l�sInTextstr�ng("Nya personens namn: ");

		if (getPerson(namn) != null) {
			System.out.println("Fel, person med det namnet finns redan registrerad");
		} else {
			personer.add(new Person(namn));
			System.out.println("Personen " + namn + " har lagts till i registret.");
		}
	}

	public void skapaV�rdesak() {
		System.out.println("\nSKAPA V�RDESAK");

		if (!personer.isEmpty()) {
			String namn = l�sInTextstr�ng("Vilken person �ger v�rdesaken: ");
			Person person = getPerson(namn);

			if (person == null) {
				System.out.println("Fel, personen " + namn + " finns inte med i registret");
			} else {
				String sortsV�rdesak = l�sInTextstr�ng("Vilken sorts v�rdesak (smycke/aktie/apparat): ");

				if (sortsV�rdesak.equalsIgnoreCase("Smycke")) {
					String sortsSmycke = l�sInTextstr�ng("Vilket sorts smycke: ");
					Smycke.MetallSort metallSort;

					while (true) {
						try {
							metallSort = Smycke.MetallSort.valueOf(l�sInTextstr�ng("Vilken metallsort �r smycket av (guld/silver): ").toUpperCase());
							break;
						} catch (IllegalArgumentException e) {
							System.out.println("Fel v�rde, skall vara antingen \"guld\" eller \"silver\"");
						}
					}
					int antal�delstenar = l�sInHeltal("Antal �delstenar: ");
					person.registreraV�rdesak(new Smycke(sortsSmycke, antal�delstenar, metallSort));
				} else if (sortsV�rdesak.equalsIgnoreCase("Aktie")) {
					String aktieNamn = l�sInTextstr�ng("Namn p� aktien: ");
					int aktieAntal = l�sInHeltal("Antal aktier: ");
					int aktiePris = l�sInHeltal("Aktiepris: ");

					person.registreraV�rdesak(new Aktie(aktieNamn, aktieAntal, aktiePris));
				} else if (sortsV�rdesak.equalsIgnoreCase("Apparat")) {
					String sortsApparat = l�sInTextstr�ng("Vilken sorts apparat: ");
					int ink�pspris = l�sInHeltal("Ink�pspris: ");
					int slitage;

					while (true) {
						slitage = l�sInHeltal("Slitage (1-10): ");

						if (slitage < 1 || slitage > 10)
							System.out.println("Fel v�rde, skall ligga mellan 1 och 10");
						else break;
					}
					person.registreraV�rdesak(new Apparat(sortsApparat, ink�pspris, slitage));
				} else {
					System.out.println("Den sortens v�rdesak (" + sortsV�rdesak + ") finns inte implementerad i programmet �n");
					return;
				}

				System.out.println(sortsV�rdesak + " har lagts till i listan av v�rdesaker som tillh�r " + namn);
			}
		} else {
		System.out.println("Det finns inga personer i registret �n");
		}
	}

	void visaAllaPersoner() {
		System.out.println("\nVISA ALLA PERSONER");

		if (personer.isEmpty()) {
			System.out.println("Det finns inga personer i registret �n");
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
			System.out.println("Rikast �r:");

			for (Person rikastPerson : rikastePersonerna) {
				System.out.println(rikastPerson);
				visaPersonsV�rdesaker(rikastPerson);
			}
		} else {
			System.out.println("Det finns inga personer i registret �n");
		}

	}

	public void visaVissPerson() {
		System.out.println("\nVISA VISS PERSON");

		if (!personer.isEmpty()) {
			String namn = l�sInTextstr�ng("Namn p� personen: ");
			Person person = getPerson(namn);

			if (person != null) {
				System.out.println(person.getNamn() + " �ger saker f�r " + person.getV�rdesakersSammanlagdaV�rde() + " kr");
				visaPersonsV�rdesaker(person);
			} else {
				System.out.println("Personen " + namn + " finns inte i registret");
			}
		} else {
			System.out.println("Det finns inga personer i registret �n");
		}
	}

	public void utf�rB�rskrasch() {
		System.out.println("\nUTF�R B�RSKRASCH");

		if (!personer.isEmpty()) {
			for (Person person : personer) {
				for (Vardesak v�rdesak : person.getV�rdesaker()) {
					if (v�rdesak instanceof Aktie) {
						((Aktie)v�rdesak).setPris(0);
					}
				}
			}
			System.out.println("B�rskrasch utf�rd");
		} else {
			System.out.println("Det finns inga personer i registret �n");
		}
	}

	private void avsluta() {
		System.out.println("Programmet avslutas, hejd�!");
		System.exit(0);
	}

	private void visaPersonsV�rdesaker(Person person) {
		for (Vardesak v�rdesak : person.getV�rdesaker()) {
			System.out.println(v�rdesak);
		}
	}

	private ArrayList<Person> getRikastePerson() {
		if (personer.isEmpty())
			return null;

		Person rikastPerson = personer.get(0);
		ArrayList<Person> rikastePersoner = new ArrayList<Person>();
		int rikastPersonsV�rde = 0;
		int annanPersonsV�rde = 0;

		for (int i = 1; i < personer.size(); i++) {
			rikastPersonsV�rde = rikastPerson.getV�rdesakersSammanlagdaV�rde();
			annanPersonsV�rde = personer.get(i).getV�rdesakersSammanlagdaV�rde();

			if (annanPersonsV�rde > rikastPersonsV�rde) {
				rikastPerson = personer.get(i);
			}
		}

		rikastPersonsV�rde = rikastPerson.getV�rdesakersSammanlagdaV�rde();

		for (int j = 0; j < personer.size(); j++) {
			annanPersonsV�rde = personer.get(j).getV�rdesakersSammanlagdaV�rde();

			if (annanPersonsV�rde == rikastPersonsV�rde) {
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

	private int l�sInHeltal(String fr�ga) {
		while (true) {
			try {
				System.out.print(fr�ga);
				return Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Fel - skall vara numeriskt v�rde");
			}
		}
	}

	private String l�sInTextstr�ng(String fr�ga) {
		System.out.print(fr�ga);
		String str = sc.nextLine();
		return str;
	}
}
