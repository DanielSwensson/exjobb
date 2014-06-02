import java.util.*;

public class Register {
	static Scanner keyboard = new Scanner(System.in);

	static int readInt(String fråga) {
		for (;;) {
			try {
				System.out.print(fråga);
				int x = Integer.parseInt(keyboard.nextLine());
				return x;

			} catch (NumberFormatException e) {
				System.out.println("Fel- skall vara numeriskt värde!");
			}
		}
	}

	public static void main(String[] args) {
		ArrayList<Person> allaPersoner = new ArrayList<Person>();

		for (;;) {
			System.out.println("1. Lägg till person");
			System.out.println("2. Lägg till pryl");
			System.out.println("3. Visa alla");
			System.out.println("4. Visa rikaste");
			System.out.println("5. Visa viss person");
			System.out.println("6. Skapa BÖRSKRASCH!");
			System.out.println("7. Avsluta");
			System.out.println();

			int val = readInt("Vad vill du göra?");
			switch (val) {

			case 1:

				System.out.println("Vänligen ange personens namn: ");
				String pna = keyboard.nextLine();
				boolean ok = false;
				for (int u = 0; u < allaPersoner.size(); u++) {
					if (allaPersoner.get(u).getPersonNamn()
							.equalsIgnoreCase(pna)) {
						System.out
								.println("Det finns tyvärr redan en person med detta namn i registret!");
						System.out.println();
						ok = true;
					}
				}
				if (ok == false) {
					Person p = new Person(pna);
					allaPersoner.add(p);
					System.out.println();
				}
				break;

			case 2:

				System.out
						.println("Ange namnet på den registrerade personen som äger prylen: ");
				String ägare = keyboard.nextLine();
				Person ag = null;
				for (int u = 0; u < allaPersoner.size(); u++) {
					if (allaPersoner.get(u).getPersonNamn()
							.equalsIgnoreCase(ägare)) {
						ag = allaPersoner.get(u);
					}
				}
				if (ag == null) {
					System.out
							.println("Det finns tyvärr ingen registrerad person med detta namn");
					System.out.println();

				} else {
					System.out
							.println("Vänligen ange vad för sorts pryl som du skulle vilja registrera: ");
					String so = keyboard.nextLine();

					if (so.equalsIgnoreCase("Smycke")) {
						System.out.println("Vad för sort smycke är det?");
						String namn = keyboard.nextLine();
						System.out.println("Är smycket i guld? ");
						String metall = keyboard.nextLine();
						double adelstenar = readInt("Vänligen ange antal ädelstenar på smycket: ");

						Smycken s = new Smycken(so, namn, adelstenar, metall);
						ag.addPrylar(s);

						System.out.println();

					}
					if (so.equalsIgnoreCase("Aktie")) {
						System.out.println("Skriv in namnet på aktien: ");
						String namn = keyboard.nextLine();
						double antal = readInt("Vänligen ange antal aktier: ");
						double pris = readInt("Vänligen ange aktiens värde: ");

						Aktier ak = new Aktier(so, namn, antal, pris);
						ag.addPrylar(ak);

						System.out.println();

					}
					if (so.equalsIgnoreCase("Apparat")) {
						System.out.println("Vad för sorts apparat är det? ");
						String namn = keyboard.nextLine();
						double inkopspris = readInt("Vänligen ange apparatens inköpspris: ");
						double slitage = readInt("Vänligen ange grad av slitage på apparaten inom skolan 1-10,  där 10 är helt ny och 0 vädligt sliten:");

						Apparater ap = new Apparater(so, namn, inkopspris,
								slitage);
						ag.addPrylar(ap);

						System.out.println();
					}
				}
				break;

			case 3:

				for (int i = 0; i < allaPersoner.size(); i++) {
					System.out.println("I registret finns:");
					System.out.println(allaPersoner.get(i).getPersonNamn()
							+ "       " + allaPersoner.get(i).getSumma());
				}
				break;

			case 4:

				double tmp = -1;
				Person ri = null;
				for (int i = 0; i < allaPersoner.size(); i++) {
					if (allaPersoner.get(i).getSumma() > tmp) {
						tmp = allaPersoner.get(i).getSumma();
						ri = allaPersoner.get(i);
					}
				}
				if (tmp == -1) {
					System.out
							.println("För nuvarande finns ingen person i systemet");

				} else {

					System.out.println("Rikaste är " + ri.getPersonNamn()
							+ " som sammanlagt äger " + ri.getSumma()
							+ " kronor");
					System.out.println();
					System.out.println(ri.getPrylar());
				}
				break;

			case 5:

				System.out.println("Vänligen ange vem du vill at vi ska visa?");
				String vissPerson = keyboard.nextLine();
				Person vp = null;

				for (int u = 0; u < allaPersoner.size(); u++) {
					if (allaPersoner.get(u).getPersonNamn()
							.equalsIgnoreCase(vissPerson)) {
						vp = allaPersoner.get(u);
					}
				}
				if (vp == null) {
					System.out
							.println("Tyvärr existerar ingen registrerad person med detta namnet");

				} else {
					System.out.println(vp.getPersonNamn()
							+ "s totala förmögenheten är " + vp.getSumma()
							+ " kronor");
					System.out.println();
					System.out.println(vp.getPrylar());
				}
				break;

			case 6:

				for (int i = 0; i < allaPersoner.size(); i++) {
					allaPersoner.get(i).Krasch();
				}

				System.out
						.println("HERREGUD DET HAR SKETT EN BÖRSKRASH! ALLA AKTIER HAR SATS TILL 0 KR!!!");
				System.out.println();

				break;

			case 7:
				System.out.println("Programmet har avslutats, välkommen åter!");
				System.exit(0);

			default:
				System.out.println("Felaktigt kommando ");
			}
		}
	}
}