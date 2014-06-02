import java.util.Scanner;
import java.util.ArrayList;

// import av java verktyg

public class Main {
	public static void main(String[] args) {

		// main klassen
		
		ArrayList<Person> allaPers = new ArrayList<Person>();
		Scanner scanner = new Scanner(System.in);
// Definera arraylist- och scannerobjekt.
		boolean ok;    // booleansk variabel med tv� villkor
		do { // do while loop - forts�tter looppen s� l�nge villkoret uppfylls
			ok = true;
			try { // try and catch loopen �r till f�r att f�nga numberformatexception

				System.out.println("1-Registrera");
				System.out.println("2-L�gg till pryl");
				System.out.println("3-Lista alla personer");
				System.out.println("4-Visa rikast");
				System.out.println("5-Visa viss person");
				System.out.println("6-B�rskrasch");
				System.out.println("7-Avsluta");
				System.out.print("Ange Kommando: ");
				int kom = Integer.parseInt(scanner.nextLine());
				switch (kom) { // switch sats som avslutas med break

				case 1:
					boolean finns = false; // ena boolean villkoret
					System.out.print("Namn: ");
					String namn = scanner.nextLine();
					for (Person p : allaPers) { // for loop som s�ker igenom arraylisten f�r att kolla om personen redan finns
						if (p.getNamn().equalsIgnoreCase(namn)) {
							System.out.println("Personen finns redan");
							finns = true;
						}
					}
					if (!finns) { // om personen inte finns i arraylistan s� l�ggs den till och skrivs ut
						Person pers = new Person(namn);
						allaPers.add(pers);
						System.out.println(""+pers+" �r registrerad!");
					}
					break;

				case 2:
					System.out.print("L�gg till pryl f�r vem: ");
					String vem = scanner.nextLine();
					String metall = "";
					Person tmpPerson = null;
					int tmpPersonIndex = 0; // initial v�rdet f�r index �r satt till 0

					for (Person p : allaPers) {
						if (vem.equalsIgnoreCase(p.getNamn())) {
							tmpPerson = p;
							break;
						}
						tmpPersonIndex++; // index s�ks igenom person f�r person tills r�tt person hittas
					}

					if (tmpPerson != null) {  // om personen hittas i listan 
						System.out.print("Vad f�r pryl? V�lj mellan smycke, aktie eller apparat: ");
						String prylNamn = scanner.nextLine();

						if (prylNamn.equalsIgnoreCase("Smycke")) { // if sats - ej case k�nsligt
							System.out.print("Vilken typ av smycke: ");
							String typ = scanner.nextLine();
							System.out.print("Antal �delstenar: ");
							int ant�del = Integer.parseInt(scanner.nextLine());
							System.out.print("�r smycket av guld: ");
							String svar = scanner.nextLine();
							if (svar.equalsIgnoreCase("ja")) {
								metall = "guld";
							} else {
								metall = "silver";
							}
							Smycke sak = new Smycke(prylNamn, typ, ant�del,
									metall);
							tmpPerson.addSak(sak); // ett nytt smycke l�ggs till en person
						} else if (prylNamn.equalsIgnoreCase("Aktie")) { // ifall f�rsta villkoret inte uppfylls
							System.out.print("Namn p� aktie: ");
							String typ = scanner.nextLine();
							System.out.print("Antal aktier: ");
							int antal = Integer.parseInt(scanner.nextLine());
							System.out.print("Pris per aktie: ");
							int pris = Integer.parseInt(scanner.nextLine());
							Aktier a = new Aktier(prylNamn, typ, antal, pris); // en aktie l�ggs till en person
							tmpPerson.addSak(a);
						} else if (prylNamn.equalsIgnoreCase("Apparat")) { // ifall andra villkoret inte uppfylls
							System.out.print("Vad f�r apparat: ");
							String typ = scanner.nextLine();
							System.out.print("Nypris: ");
							int nyPris = Integer.parseInt(scanner.nextLine());
							System.out.print("Slitage, 1-10, 10=helt ny: ");
							int slitage = Integer.parseInt(scanner.nextLine());
							Apparat ap = new Apparat(prylNamn, typ, nyPris, // en apparat l�ggs till en person
									slitage);
							tmpPerson.addSak(ap);
						} else { // om inte prylnamnet �verensst�mmer med m�jliga objektnamn
							System.out
									.println(""
											+ prylNamn
											+ " finns inte! V�lj mellan smycke, aktie eller apparat.");
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
						num++; // listar upp n�sta person
					}

					break;

				case 4:
					Person rikast = allaPers.get(0);
					for (Person p : allaPers) { // for loop som s�ker igenom personer
						if (rikast.getKapital() < p.getKapital()) { // if sats j�mf�r personernas f�rm�genhet med den tidigare rikaste personen och ers�tter denne om villkoret uppfylls
							rikast = p;
						}
					}
					System.out.println(rikast.getNamn()
							+ " �r rikast, f�rm�genhet: " + rikast.getKapital()
							+ ":-");
					break;

				case 5:
					System.out.print("Vem vill du visa?");
					String visa = scanner.nextLine();
					for (Person p : allaPers) {
						if (p.getNamn().equalsIgnoreCase(visa)) { // if satsen g�r igenom listan och s�ker efter en person med samma namn och anropar getPryl
							System.out.println(p + ", prylar: " + p.getPryl());
						}
					}
					break;

				case 6:
					for (Person p : allaPers) {
						p.b�rsKrasch(); // anropar metoden b�rskrasch
					}
					break;

				case 7:
					System.exit(0);

				default: // om inte r�tt siffra matas in
					System.out.println("Felaktigt kommando!");

				}
			} catch (NumberFormatException e) { // om kommandot inte �r en siffra
				System.out.println("Kommandot m�ste vara en siffra!");
			}
		} while (ok); // forts�tter s� l�nge villkoret uppfylls
	}
}
