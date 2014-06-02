import java.util.Scanner;
import java.util.ArrayList;

// import av java verktyg

public class Main {
	public static void main(String[] args) {

		// main klassen
		
		ArrayList<Person> allaPers = new ArrayList<Person>();
		Scanner scanner = new Scanner(System.in);
// Definera arraylist- och scannerobjekt.
		boolean ok;    // booleansk variabel med två villkor
		do { // do while loop - fortsätter looppen så länge villkoret uppfylls
			ok = true;
			try { // try and catch loopen är till för att fånga numberformatexception

				System.out.println("1-Registrera");
				System.out.println("2-Lägg till pryl");
				System.out.println("3-Lista alla personer");
				System.out.println("4-Visa rikast");
				System.out.println("5-Visa viss person");
				System.out.println("6-Börskrasch");
				System.out.println("7-Avsluta");
				System.out.print("Ange Kommando: ");
				int kom = Integer.parseInt(scanner.nextLine());
				switch (kom) { // switch sats som avslutas med break

				case 1:
					boolean finns = false; // ena boolean villkoret
					System.out.print("Namn: ");
					String namn = scanner.nextLine();
					for (Person p : allaPers) { // for loop som söker igenom arraylisten för att kolla om personen redan finns
						if (p.getNamn().equalsIgnoreCase(namn)) {
							System.out.println("Personen finns redan");
							finns = true;
						}
					}
					if (!finns) { // om personen inte finns i arraylistan så läggs den till och skrivs ut
						Person pers = new Person(namn);
						allaPers.add(pers);
						System.out.println(""+pers+" är registrerad!");
					}
					break;

				case 2:
					System.out.print("Lägg till pryl för vem: ");
					String vem = scanner.nextLine();
					String metall = "";
					Person tmpPerson = null;
					int tmpPersonIndex = 0; // initial värdet för index är satt till 0

					for (Person p : allaPers) {
						if (vem.equalsIgnoreCase(p.getNamn())) {
							tmpPerson = p;
							break;
						}
						tmpPersonIndex++; // index söks igenom person för person tills rätt person hittas
					}

					if (tmpPerson != null) {  // om personen hittas i listan 
						System.out.print("Vad för pryl? Välj mellan smycke, aktie eller apparat: ");
						String prylNamn = scanner.nextLine();

						if (prylNamn.equalsIgnoreCase("Smycke")) { // if sats - ej case känsligt
							System.out.print("Vilken typ av smycke: ");
							String typ = scanner.nextLine();
							System.out.print("Antal ädelstenar: ");
							int antÄdel = Integer.parseInt(scanner.nextLine());
							System.out.print("Är smycket av guld: ");
							String svar = scanner.nextLine();
							if (svar.equalsIgnoreCase("ja")) {
								metall = "guld";
							} else {
								metall = "silver";
							}
							Smycke sak = new Smycke(prylNamn, typ, antÄdel,
									metall);
							tmpPerson.addSak(sak); // ett nytt smycke läggs till en person
						} else if (prylNamn.equalsIgnoreCase("Aktie")) { // ifall första villkoret inte uppfylls
							System.out.print("Namn på aktie: ");
							String typ = scanner.nextLine();
							System.out.print("Antal aktier: ");
							int antal = Integer.parseInt(scanner.nextLine());
							System.out.print("Pris per aktie: ");
							int pris = Integer.parseInt(scanner.nextLine());
							Aktier a = new Aktier(prylNamn, typ, antal, pris); // en aktie läggs till en person
							tmpPerson.addSak(a);
						} else if (prylNamn.equalsIgnoreCase("Apparat")) { // ifall andra villkoret inte uppfylls
							System.out.print("Vad för apparat: ");
							String typ = scanner.nextLine();
							System.out.print("Nypris: ");
							int nyPris = Integer.parseInt(scanner.nextLine());
							System.out.print("Slitage, 1-10, 10=helt ny: ");
							int slitage = Integer.parseInt(scanner.nextLine());
							Apparat ap = new Apparat(prylNamn, typ, nyPris, // en apparat läggs till en person
									slitage);
							tmpPerson.addSak(ap);
						} else { // om inte prylnamnet överensstämmer med möjliga objektnamn
							System.out
									.println(""
											+ prylNamn
											+ " finns inte! Välj mellan smycke, aktie eller apparat.");
						}
						allaPers.remove(tmpPersonIndex);
						allaPers.add(tmpPersonIndex, tmpPerson);
					} else {
						System.out.println("" + vem + " finns inte!"); // om personen inte finns
					}
					break;

				case 3:
					int num = 1;
					for (Person p : allaPers) { // lista alla personer och deras prylar
						System.out.println(num + ". " + p + ", prylar: "
								+ p.getPryl() + ".");  // anropar getPryl metoden
						num++; // listar upp nästa person
					}

					break;

				case 4:
					Person rikast = allaPers.get(0);
					for (Person p : allaPers) { // for loop som söker igenom personer
						if (rikast.getKapital() < p.getKapital()) { // if sats jämför personernas förmögenhet med den tidigare rikaste personen och ersätter denne om villkoret uppfylls
							rikast = p;
						}
					}
					System.out.println(rikast.getNamn()
							+ " är rikast, förmögenhet: " + rikast.getKapital()
							+ ":-");
					break;

				case 5:
					System.out.print("Vem vill du visa?");
					String visa = scanner.nextLine();
					for (Person p : allaPers) {
						if (p.getNamn().equalsIgnoreCase(visa)) { // if satsen går igenom listan och söker efter en person med samma namn och anropar getPryl
							System.out.println(p + ", prylar: " + p.getPryl());
						}
					}
					break;

				case 6:
					for (Person p : allaPers) {
						p.börsKrasch(); // anropar metoden börskrasch
					}
					break;

				case 7:
					System.exit(0);

				default: // om inte rätt siffra matas in
					System.out.println("Felaktigt kommando!");

				}
			} catch (NumberFormatException e) { // om kommandot inte är en siffra
				System.out.println("Kommandot måste vara en siffra!");
			}
		} while (ok); // fortsätter så länge villkoret uppfylls
	}
}
