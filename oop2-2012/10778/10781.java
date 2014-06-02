import java.util.*;

class Huvudklass {
	ArrayList<Personer> alla = new ArrayList<Personer>(); 
	Scanner input = new Scanner(System.in);

	int readInt(String fråga) {
		for (;;) {
			try {
				System.out.println(fråga);
				int x = Integer.parseInt(input.nextLine());
				return x;
			} catch (NumberFormatException e) {
				System.out.println("Fel - skall vara numeriskt värde");
			}
		}
	}

	String readString(String fråga) {
		System.out.print(fråga);
		String str = input.nextLine();
		return str;
	}

	Personer getPerson(String namn) {
		for (Personer p : alla)
			if (p.getNamn().equalsIgnoreCase(namn))
				return p;
		return null;
	}

	void skapaPerson() {
		String namn = readString("Nya personens namn: ");
		Personer p = getPerson(namn);
		if (p != null)
			System.out.println("Den personen finns redan");
		else {
			Personer ny = new Personer(namn);
			alla.add(ny);
		}
	}

	void skapaPryl() {
		System.out.println("Vem äger prylen?: ");
		String owner = input.nextLine();
		Personer person = getPerson(owner);
		if (person == null) {
			System.out.println("Personen finns inte i registret.");
			return;
		}
		int val2 = readInt("1-Aktie\n2-Smycke\n3-Apparat");
		switch (val2) {
		case 1: // AKTIE
			System.out.print("Vilken sorts aktie?: ");
			String namn = input.nextLine();
			int aktieAntal = readInt("Hur många?: ");
			int pris = readInt("Pris per styck?: ");
			Aktie ny = new Aktie(namn, pris, aktieAntal);
			person.addPryl(ny);
			break;
		case 2: // SMYCKEN
			System.out.print("Vilket sorts smycke?: ");
			namn = input.nextLine();
			System.out.print("Är smycket av guld(ja/nej)?: ");
			String metall = input.nextLine();
			int antal = readInt("Antal äderstenar?: ");
			Smycke ny1 = new Smycke(namn, metall, antal);
			person.addPryl(ny1);
			break;
		case 3: // APPARAT
			System.out.print("Vilken sorts apparat?: ");
			namn = input.nextLine();
			int slitage = readInt("Ange slitage(10 ny - 1 gammal): ");
			pris = readInt("Inköpspris?: ");
			Apparat ny2 = new Apparat(namn, pris, slitage);
			person.addPryl(ny2);
			break;
		default:
				
		} // Switch #2
	}
		

	void visaAlla() {
		// VISA PERSONER
		System.out.println("I registret finns:");
		for (int i = 0; i < alla.size(); i++) {
			System.out.println(alla.get(i).getNamn() + " "
					+ alla.get(i).getTotalVärde());
		}
	}

	void visaRikaste() {
		// VISA RIKAST PERSON KOD
		if (alla.size() == 0) {
			System.out.println("Fel");
			return;
		}
		Personer rikast = alla.get(0);
		for (int i = 1; i < alla.size(); i++) {
			if (alla.get(i).getTotalVärde() > rikast.getTotalVärde()) {
				rikast = alla.get(i);
			}
		}
		System.out.println("Rikast är " + rikast.getNamn()
				+ " som sammanlagt äger saker för " + rikast.getTotalVärde()
				+ " kr!");
		System.out.println(rikast.getPrylar());
	}

	void visaViss() {
		// VÄLJ PERSON, GE FELMEDELANDE, KOD
		Personer vald = null;
		System.out.println("Välj person: ");
		String valPerson = input.nextLine();
		for (int i = 0; i < alla.size(); i++) {
			if (valPerson.equalsIgnoreCase(alla.get(i).getNamn())) {
				vald = alla.get(i);
			}
		}
		if (vald == null) {
			System.out.println("Personen finns inte i registret!");
		} else {
			System.out.println(vald.getNamn() + "\n" + vald.getPrylar());
		}
	}

	void börskrasch() {
		for (int i = 0; i < alla.size(); i++) {
			alla.get(i).getBörs();
		}
		System.out.println("Nu har börsen kraschat :(");
	}

	public static void main(String[] args) {
		Huvudklass huvudklass = new Huvudklass();
		for (;;) {

			int val = huvudklass.readInt("1-Skapa person \n2-Skapa pryl \n3-Visa alla "
					+ "\n4-Visa rikaste \n5-Visa viss person "
					+ "\n6-Börskrasch \n7-Avsluta ");
			switch (val) {
			case 1:
				huvudklass.skapaPerson();
				break;
			case 2:
				huvudklass.skapaPryl();
				break;
			case 3:
				huvudklass.visaAlla();
				break;
			case 4:
				huvudklass.visaRikaste();
				break;
			case 5:
				huvudklass.visaViss();
				break;
			case 6:
				huvudklass.börskrasch();
				break;
			case 7:
				System.out.println("Hej då!");
				System.exit(0);
			default:
				System.out.println("Felaktigt kommando.");
			} // SWITCEHN
		} // FORLOOP(OOÄNDLIIGG)
	} // Main
} // HUVUDKLASSEN