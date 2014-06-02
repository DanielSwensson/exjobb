import java.util.*;

public class HuvudProgram {

	ArrayList<Person> alla = new ArrayList<Person>();
	Scanner scan = new Scanner(System.in);

	int readInt(String fr�ga) {

		for (;;) {
			try {
				System.out.print(fr�ga);

				int x = Integer.parseInt(scan.nextLine());
				return x;
			} catch (NumberFormatException e) {
				System.out.println("Fel-skall vara numeriskt v�rde");
			}
		}
	}

	Person getPerson(String namn) {

		for (Person p : alla)

			if (p.getNamn().equalsIgnoreCase(namn)) {
				return p;
			}
		return null;
	}

	// case 1
	public void skapaPerson() {
		try {
			System.out.print(" Nya Personens Namn:");
			String namn = scan.nextLine();
			Person p = getPerson(namn);
			if (p != null)
				System.out.println("Den personen finns redan!!");
			else {
				Person ny = new Person(namn);
				alla.add(ny);
			}
		} catch (Exception e) {
		}
	}

	// case 2
	public void skapaPryl() {
		try {
			System.out.print(" Vem �ger prylen?: ");
			String �gare = scan.nextLine();
			boolean hittad = false;
			Person r�ttPerson = null;
			for (Person p : alla) {
				if (p.getNamn().equalsIgnoreCase(�gare)) {
					r�ttPerson = p;
					hittad = true;
				}
			}

			if (hittad) {

				System.out.print(" Vilken sorts pryl: ");
				String sort = scan.nextLine();

				if (sort.equalsIgnoreCase("smycke")) {

					System.out.print("Vilken sorts smycke (namn): ");
					String namn = scan.nextLine();
					System.out
							.println(" Vilken sorts metall? (1=Guld, 2=Silver): ");
					int metall = Integer.parseInt(scan.nextLine());
					System.out.println(" Ange antal �delstenar: ");
					int antal�del = Integer.parseInt(scan.nextLine());
					r�ttPerson.allaPrylar.add(new Smycke(namn, metall,
							antal�del));
				}

				else if (sort.equalsIgnoreCase("aktie")) {

					System.out.print("Namn p� aktier: ");
					String namn = scan.nextLine();
					System.out.print("Antal aktier: ");
					try {
					int antal = Integer.parseInt(scan.nextLine());
					System.out.print(" Vad �r priset p� aktien: ");
					
					int pris = Integer.parseInt(scan.nextLine());

					r�ttPerson.allaPrylar.add(new Aktie(namn, antal, pris));
					}catch (Exception e ){
					}
					}
					

				else if (sort.equalsIgnoreCase("apparat")) {
					System.out.print("Namn p� apparat: ");
					String namn = scan.nextLine();
					System.out.print(" Ink�pspris: ");
					double pris = Double.parseDouble(scan.nextLine());
					System.out.print(" Slitage: ");
					double slitge = Double.parseDouble(scan.nextLine());

					r�ttPerson.allaPrylar.add(new Apparat(namn, pris, slitge));
				}
			}

			else {
				System.out.println(" Personen finns inte med i registret!");

			}

		} catch (Exception e) {
			
		}
	}

	// case 3
	public void visaAlla() {
		try {
		System.out.println(" Alla personer i listan: ");
		for (Person p : alla) {
			System.out.println(p);
		}
		}
		catch (Exception e) {
		
		}
	}

	// case 4
	public void visaRikaste() {
		try {
		System.out.println(" Visa Rikaste: ");
		Person rikast = alla.get(0);
		for (Person p : alla) {
			if (rikast.getSum() < p.getSum()) {
				rikast = p;
			}
		}
		System.out.println(rikast.getNamn() + " ar rikast, formogenhet = "
				+ rikast.getSum() + " kr");
		
	}
	catch (Exception e) {
	}
	}

	// case 5
	public void visaViss()

	{
		System.out.println(" Visa en viss persson:");

		String person = scan.nextLine();
		for (Person p : alla) {

			if (p.getNamn().equalsIgnoreCase(person)) {
				System.out.println(person + "  " + "�ger: " + "  "
						+ p.getPryl() + "kr ");
			}
		}
	}

	// case 6
	public void b�rsKrasch() {
		System.out.println(" B�rscrash!!!!!");
		for (Person p : alla)
			p.b�rsKrasch();
	}
}
