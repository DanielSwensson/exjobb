import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Prylregister {
	ArrayList<Person> allaPersoner;
	static Scanner keyboard = new Scanner(System.in);

	public static int readInt(String prompt) {
		System.out.print(prompt);
		int inlastSiffra = keyboard.nextInt();
		keyboard.nextLine();
		return inlastSiffra;
	}

	public static String readString(String prompt) {

		System.out.print(prompt);
		String str = keyboard.nextLine();
		return str;
	}

	public static void main(String[] args) {

		Prylregister korProgrammet = new Prylregister();

	}

	public Prylregister() {
		allaPersoner = new ArrayList<Person>();

		for (;;) {
			int kommando = 0;
			boolean rattKommando;
			do {
				rattKommando = true;
				try {
					System.out.println("\nPrylregistret 3000\n\nKommandomeny:"
							+ "\n1. Lägg till person" + "\n2. Lägg till pryl"
							+ "\n3. Lista alla personer"
							+ "\n4. Visa rikaste person"
							+ "\n5. Visa vald person" + "\n6. Börskrasch"
							+ "\n7. Avsluta program");

					kommando = readInt("Välj kommando: ");

				} catch (InputMismatchException e) {
					System.out
							.println("Kommando anges genom respektive siffra, försök igen.");
					keyboard.nextLine();
					rattKommando = false;
				}
			} while (!rattKommando);

			switch (kommando) {

			case 1:
				String namn = readString("\nLägg till person.\n\nNamn på person: ");

				boolean namnFinnsRedan = false;

				for (int i = 0; i < allaPersoner.size(); i++) {
					if (allaPersoner.get(i).getPersonNamn()
							.equalsIgnoreCase(namn)) {
						System.out.println(namn + " finns redan registrerad.");
						namnFinnsRedan = true;
						break;
					}
				}
				if (!namnFinnsRedan) {

					Person nyPerson = new Person(namn);
					allaPersoner.add(nyPerson);

					System.out.println(namn + " tillagd.");
				}
				break;

			case 2:
				String agare = readString("\nLägg till pryl.\n\nÄgare till prylen: ");
				Person person = null;
				for (int i = 0; i < allaPersoner.size(); i++) {
					if (allaPersoner.get(i).getPersonNamn()
							.equalsIgnoreCase(agare)) {
						person = allaPersoner.get(i);
					}
				}

				if (person == null) {
					System.out.println(agare + " finns inte registrerad.");
					break;
				}

				String prylSort = readString("\nPrylsort: ");

				int antalAdelstenar = 0;
				int aktiepris = 0;
				int aktieAntal = 0;
				int inkopspris = 0;
				int apparatslitage = 0;

				if (prylSort.equalsIgnoreCase("smycke")) {
					String smyckesNamn = readString("Smyckesnamn: ");
					String smyckesMaterialGuld = readString("\nÄr smycket av guld? ");
					boolean antalAdelstenarOk;
					do {
						antalAdelstenarOk = true;
						try {

							antalAdelstenar = readInt("\nAntal ädelstenar: ");
						} catch (InputMismatchException e) {
							System.out
									.println("Antal måste anges i siffror, försök igen.");
							keyboard.nextLine();
							antalAdelstenarOk = false;
						}
					} while (!antalAdelstenarOk);

					Pryl nyttSmycke = new Smycke(prylSort, smyckesNamn,
							smyckesMaterialGuld, antalAdelstenar);

					person.laggTillPryl(nyttSmycke);

				} else if (prylSort.equalsIgnoreCase("aktie")) {
					String aktieNamn = readString("\nAktienamn: ");

					boolean aktieprisOk;
					do {
						aktieprisOk = true;
						try {

							aktiepris = readInt("\nAktiepris: ");
						} catch (InputMismatchException e) {
							System.out
									.println("Pris måste anges i siffror, försök igen.");
							keyboard.nextLine();
							aktieprisOk = false;
						}
					} while (!aktieprisOk);

					boolean antalAktierOk;
					do {
						antalAktierOk = true;
						try {

							aktieAntal = readInt("\nAntal aktier: ");
						} catch (InputMismatchException e) {
							System.out
									.println("Antal måste anges i siffror, försök igen.");
							keyboard.nextLine();
							antalAktierOk = false;
						}
					} while (!antalAktierOk);

					Pryl nyAktie = new Aktie(prylSort, aktieNamn, aktiepris,
							aktieAntal);
					person.laggTillPryl(nyAktie);

				} else if (prylSort.equalsIgnoreCase("apparat")) {
					String apparatNamn = readString("Apparatnamn: ");

					boolean inkopsprisOk;
					do {
						inkopsprisOk = true;
						try {

							inkopspris = readInt("Inköpspris: ");
						} catch (InputMismatchException e) {
							System.out
									.println("Pris måste anges i siffror, försök igen.");
							keyboard.nextLine();
							inkopsprisOk = false;
						}
					} while (!inkopsprisOk);

					boolean apparatslitageOk;
					do {
						apparatslitageOk = true;
						try {

							apparatslitage = readInt("Apparatslitage (1-10): ");
						} catch (InputMismatchException e) {
							System.out
									.println("Slitage måste anges i siffror, försök igen.");
							keyboard.nextLine();
							apparatslitageOk = false;
						}
					} while (!apparatslitageOk);

					Pryl nyApparat = new Apparat(prylSort, apparatNamn,
							inkopspris, apparatslitage);

					person.laggTillPryl(nyApparat);

				}

				break;

			case 3:
				listaAllaPersoner();

				break;

			case 4:

				visaRikastePerson();

				break;

			case 5:
				String valdPerson = readString("\nNamn: ");
				visaValdPerson(valdPerson);

				break;

			case 6:

				borskrasch();
				System.out
						.println("\nBörskrasch\nAlla aktier är nu värdelösa.");

				break;

			case 7:
				System.out.print("\nAvslutar program.");
				System.exit(0);
				break;

			default:
				System.out.println("Ogiltigt kommando, försök igen: ");
				break;
			}
		}
	}

	public void listaAllaPersoner() {

		if (allaPersoner.size() == 0) {
			System.out.println("\nIngen person finns registrerad.");
		} else {
			for (int i = 0; i < allaPersoner.size(); i++) {

				System.out.println("\n" + allaPersoner.get(i).getPersonNamn()
						+ " har " + allaPersoner.get(i).vardePaAllaPrylar());
			}
		}

	}

	public void visaValdPerson(String valdPerson) {

		boolean valdPersonEjRegistrerad = true;

		if (allaPersoner.isEmpty()) {

			System.out.println("Registret är tomt.");
		} else {

			for (int i = 0; i < allaPersoner.size(); i++) {

				if (allaPersoner.get(i).getPersonNamn()
						.equalsIgnoreCase(valdPerson)) {
					System.out.println(allaPersoner.get(i).getPersonNamn()
							+ " har sammanlagt "
							+ allaPersoner.get(i).vardePaAllaPrylar() + ".\n");
					allaPersoner.get(i).skrivUtAllaPrylar();
					valdPersonEjRegistrerad = false;

				}

			}
		}
		if (valdPersonEjRegistrerad) {
			System.out.println(valdPerson + " finns inte registrerad.");
		}
	}

	public void visaRikastePerson() {

		int tempIndex = 0;

		if (allaPersoner.isEmpty()) {
			System.out.print("Ingen person finns registrerad.");
		} else {
			int tempSummaVarde = 0;
			for (int i = 0; i < allaPersoner.size(); i++) {

				if (allaPersoner.get(i).vardePaAllaPrylar() > tempSummaVarde) {
					tempSummaVarde = allaPersoner.get(i).vardePaAllaPrylar();
					tempIndex = i;
				}
			}
			System.out.println("\nRikast är "
					+ allaPersoner.get(tempIndex).getPersonNamn() + " med "
					+ allaPersoner.get(tempIndex).vardePaAllaPrylar());
			allaPersoner.get(tempIndex).skrivUtAllaPrylar();

		}
	}

	public void borskrasch() {

		for (int i = 0; i < allaPersoner.size(); i++) {
			ArrayList<Pryl> tempList = allaPersoner.get(i).getPrylar();
			for (int x = 0; x < tempList.size(); x++) {
				if (tempList.get(x).getPrylSort().equalsIgnoreCase("aktie")) {
					Aktie a = (Aktie) tempList.get(x);
					a.setVarde(0);
				}
			}

		}

	}
}
