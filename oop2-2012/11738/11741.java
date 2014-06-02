package Demo01;

import java.util.*;

public class MainProgram {
	private static Scanner sc = new Scanner(System.in);
	private static ArrayList<Person> allaP = new ArrayList<Person>();

	int readInt(String fraga) {
		for (;;) {
			try {
				System.out.print(fraga);
				int x = Integer.parseInt(sc.nextLine());
				return x;
			} catch (NumberFormatException e) {
				System.out.println("Fel - skall vara numeriskt värde");
			}
		}
	}

	String readString(String fråga) {
		System.out.print(fråga);
		String str = sc.nextLine();
		return str;
	}

	void createPerson() {
		boolean f = false;

		String personName = readString("Skriv in den nya personens namn: ");
		for (Person p : allaP) {
			if (p.getPersonName().equalsIgnoreCase(personName)) {
				System.out.println("Den personen du valt finns redan");
				f = true;
			}
		}
		if (!f) {
			Person pr = new Person(personName);
			allaP.add(pr);
			System.out.println("Person är registerade i lista");
		}

	}

	void createMerchandise() {
		String jeweleryMaterial = "";
		String vem = readString("Vem äger prylen: ");
		for (Person p : allaP) {
			if (vem.equals(p.getPersonName())) {
				String merchandiseName = readString("Vilken sorts pryl: 1=Smycke, 2=Aktie eller 3=Apparat");
				if (merchandiseName.equalsIgnoreCase("1")) {
					String type = readString("Vilken sorts Smycke? ");
					int amountOfGems = readInt("Antal ädelstenar: ");
					String m = readString("Ange smyckes matrial(guld eller silver): ");
					if (m.equalsIgnoreCase("guld")) {
						jeweleryMaterial = "guld";
					} else {
						jeweleryMaterial = "silver";
					}
					Jewelery s = new Jewelery(merchandiseName, type,
							amountOfGems, jeweleryMaterial);
					p.addAllaM(s);
				} else if (merchandiseName.equalsIgnoreCase("2")) {
					String type = readString("Akties namn: ");
					int amountOFShareHolding = readInt("Ange antal av aktie: ");
					int sharePrice = readInt("Ange pris per aktie: ");
					Share a = new Share(merchandiseName, type,
							amountOFShareHolding, sharePrice);
					p.addAllaM(a);
				} else if (merchandiseName.equalsIgnoreCase("3")) {
					String type = readString("Apparot namn: ");
					int purchasePrice = readInt("Ange inköppris: ");
					int wear = readInt("Ange slitaget(1-10  (10 är nytt)) ");
					Device ap = new Device(merchandiseName, type,
							purchasePrice, wear);
					p.addAllaM(ap);

				} else {
					System.out.println(merchandiseName+ "  Finns ingen! Välja mellan smycke, aktier eller apparat.");
				}

			}
		}

	}

	void showAll() {
		int num = 1;
		for (Person p : allaP) {
			System.out.println(num + ". " + p + ",  äger prylar: "
					+ p.getMerchandise() + ".");
			num++;
		}
		System.out.println("*****************************");
	}

	void showRichestPerson() {
		if (allaP.isEmpty()) {
			System.out.println("Lista är tom");
			return;
		}

		Person vr = allaP.get(0);
		for (Person p : allaP) {
			if (vr.getCapital() < p.getCapital()) {
				vr = p;
			}
		}
		System.out.println(vr.getPersonName()
				+ " är rikaste som sammanlagt äger: " + vr.getCapital() + "kr");
	}

	void showPerson() {
		String vv = readString("Ange persons namn: ");
		for (Person p : allaP) {
			if (p.getPersonName().equalsIgnoreCase(vv)) {
				System.out.println(p + ", prylar: " + p.getMerchandise());
			}
		}

	}

	void stockMarketCrash() {
		for (Person p : allaP) {
			p.stockMarketCrash();
		}
	}

	public static void main(String[] arg) {

		MainProgram hp = new MainProgram();
		System.out.println("Hej och välkommen till Prylprogrammet");
		for (;;) {
			System.out.print("1-Skapa Person\n" + "2-Skapa Pryl\n"
					+ "3-Vissa alla\n" + "4-Visa rikaste\n" + "5-Visa viss\n"
					+ "6-Börskrasch\n" + "7-Avsluta Program \nAnge Kommando: ");
			int val = hp.readInt("Ange kommando 1-7 ");
			switch (val) {
			case 1:
				hp.createPerson();
				break;
			case 2:
				hp.createMerchandise();
				break;
			case 3:
				hp.showAll();
				break;
			case 4:
				hp.showRichestPerson();
				break;
			case 5:
				hp.showPerson();
				break;
			case 6:
				hp.stockMarketCrash();
				break;
			case 7:
				System.out.println("Tack och hej då!");
				System.exit(0);
			default:
				System.out.println("Fel kommando välja mellan 1-7");
			}
		}

	}
}
