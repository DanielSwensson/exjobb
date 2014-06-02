import java.util.*;

public class Register {
	static Scanner keyboard = new Scanner(System.in);

	static int readInt(String fr�ga) {
		for (;;) {
			try {
				System.out.print(fr�ga);
				int x = Integer.parseInt(keyboard.nextLine());
				return x;

			} catch (NumberFormatException e) {
				System.out.println("Fel- skall vara numeriskt v�rde!");
			}
		}
	}

	public static void main(String[] args) {
		ArrayList<Person> allaPersoner = new ArrayList<Person>();

		for (;;) {
			System.out.println("1. L�gg till person");
			System.out.println("2. L�gg till pryl");
			System.out.println("3. Visa alla");
			System.out.println("4. Visa rikaste");
			System.out.println("5. Visa viss person");
			System.out.println("6. Skapa B�RSKRASCH!");
			System.out.println("7. Avsluta");
			System.out.println();

			int val = readInt("Vad vill du g�ra?");
			switch (val) {

			case 1:

				System.out.println("V�nligen ange personens namn: ");
				String pna = keyboard.nextLine();
				boolean ok = false;
				for (int u = 0; u < allaPersoner.size(); u++) {
					if (allaPersoner.get(u).getPersonNamn()
							.equalsIgnoreCase(pna)) {
						System.out
								.println("Det finns tyv�rr redan en person med detta namn i registret!");
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
						.println("Ange namnet p� den registrerade personen som �ger prylen: ");
				String �gare = keyboard.nextLine();
				Person ag = null;
				for (int u = 0; u < allaPersoner.size(); u++) {
					if (allaPersoner.get(u).getPersonNamn()
							.equalsIgnoreCase(�gare)) {
						ag = allaPersoner.get(u);
					}
				}
				if (ag == null) {
					System.out
							.println("Det finns tyv�rr ingen registrerad person med detta namn");
					System.out.println();

				} else {
					System.out
							.println("V�nligen ange vad f�r sorts pryl som du skulle vilja registrera: ");
					String so = keyboard.nextLine();

					if (so.equalsIgnoreCase("Smycke")) {
						System.out.println("Vad f�r sort smycke �r det?");
						String namn = keyboard.nextLine();
						System.out.println("�r smycket i guld? ");
						String metall = keyboard.nextLine();
						double adelstenar = readInt("V�nligen ange antal �delstenar p� smycket: ");

						Smycken s = new Smycken(so, namn, adelstenar, metall);
						ag.addPrylar(s);

						System.out.println();

					}
					if (so.equalsIgnoreCase("Aktie")) {
						System.out.println("Skriv in namnet p� aktien: ");
						String namn = keyboard.nextLine();
						double antal = readInt("V�nligen ange antal aktier: ");
						double pris = readInt("V�nligen ange aktiens v�rde: ");

						Aktier ak = new Aktier(so, namn, antal, pris);
						ag.addPrylar(ak);

						System.out.println();

					}
					if (so.equalsIgnoreCase("Apparat")) {
						System.out.println("Vad f�r sorts apparat �r det? ");
						String namn = keyboard.nextLine();
						double inkopspris = readInt("V�nligen ange apparatens ink�pspris: ");
						double slitage = readInt("V�nligen ange grad av slitage p� apparaten inom skolan 1-10,  d�r 10 �r helt ny och 0 v�dligt sliten:");

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
							.println("F�r nuvarande finns ingen person i systemet");

				} else {

					System.out.println("Rikaste �r " + ri.getPersonNamn()
							+ " som sammanlagt �ger " + ri.getSumma()
							+ " kronor");
					System.out.println();
					System.out.println(ri.getPrylar());
				}
				break;

			case 5:

				System.out.println("V�nligen ange vem du vill at vi ska visa?");
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
							.println("Tyv�rr existerar ingen registrerad person med detta namnet");

				} else {
					System.out.println(vp.getPersonNamn()
							+ "s totala f�rm�genheten �r " + vp.getSumma()
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
						.println("HERREGUD DET HAR SKETT EN B�RSKRASH! ALLA AKTIER HAR SATS TILL 0 KR!!!");
				System.out.println();

				break;

			case 7:
				System.out.println("Programmet har avslutats, v�lkommen �ter!");
				System.exit(0);

			default:
				System.out.println("Felaktigt kommando ");
			}
		}
	}
}