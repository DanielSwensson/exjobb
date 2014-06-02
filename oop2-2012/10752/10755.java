import java.util.*;

public class HuvudProgram {

	ArrayList<Person> alla = new ArrayList<Person>();
	Scanner scan = new Scanner(System.in);

	int readInt(String fråga) {

		for (;;) {
			try {
				System.out.print(fråga);

				int x = Integer.parseInt(scan.nextLine());
				return x;
			} catch (NumberFormatException e) {
				System.out.println("Fel-skall vara numeriskt värde");
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
			System.out.print(" Vem äger prylen?: ");
			String ägare = scan.nextLine();
			boolean hittad = false;
			Person rättPerson = null;
			for (Person p : alla) {
				if (p.getNamn().equalsIgnoreCase(ägare)) {
					rättPerson = p;
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
					System.out.println(" Ange antal Ädelstenar: ");
					int antalÄdel = Integer.parseInt(scan.nextLine());
					rättPerson.allaPrylar.add(new Smycke(namn, metall,
							antalÄdel));
				}

				else if (sort.equalsIgnoreCase("aktie")) {

					System.out.print("Namn på aktier: ");
					String namn = scan.nextLine();
					System.out.print("Antal aktier: ");
					try {
					int antal = Integer.parseInt(scan.nextLine());
					System.out.print(" Vad är priset på aktien: ");
					
					int pris = Integer.parseInt(scan.nextLine());

					rättPerson.allaPrylar.add(new Aktie(namn, antal, pris));
					}catch (Exception e ){
					}
					}
					

				else if (sort.equalsIgnoreCase("apparat")) {
					System.out.print("Namn på apparat: ");
					String namn = scan.nextLine();
					System.out.print(" Inköpspris: ");
					double pris = Double.parseDouble(scan.nextLine());
					System.out.print(" Slitage: ");
					double slitge = Double.parseDouble(scan.nextLine());

					rättPerson.allaPrylar.add(new Apparat(namn, pris, slitge));
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
				System.out.println(person + "  " + "äger: " + "  "
						+ p.getPryl() + "kr ");
			}
		}
	}

	// case 6
	public void börsKrasch() {
		System.out.println(" Börscrash!!!!!");
		for (Person p : alla)
			p.börsKrasch();
	}
}
