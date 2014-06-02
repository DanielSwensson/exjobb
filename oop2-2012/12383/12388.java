import java.util.*;

public class Register {

	static ArrayList<Person> allPersons = new ArrayList<Person>();
	static boolean isRegistered;
	static String personName;

	public static void main(String[] args) {

		String choice;

		do {
			choice = readString("Vad vill du göra? \n registrera \n lista \n visa rikaste \n visa person \n börskrash \n avsluta");

			switch (choice) {

			case "registrera":
				choice = readString("Vill du registrera person eller pryl?");

				// Registrera pryl
				if (choice.equals("pryl")) {

					personName = readString("Vem äger prylen?");

					// Återställ om tidigare person hittats
					isRegistered = false;

					// Leta efter personen

					for (Person i : allPersons) {
						if (personName.equals(i.getName())) {
							isRegistered = true;
						}
					}
					if (isRegistered == true) {
						String type = readString("Vill du registrera ett smycke, aktier eller en apparat?");

						// Registrera smycke
						if (type.equals("smycke")) {
							String material = readString("material?");

							type = readString("Vilken sorts smycke är det?");

							int jewels = readInt("Antal ädelstenar");

							for (int i = 0; i < allPersons.size(); i++) {
								if (personName.equals(allPersons.get(i)
										.getName())) {
									isRegistered = true;
									allPersons.get(i).addJewelery(personName,
											type, material, jewels);

								}
							}
							// Registrera aktie
						} else if (type.equals("aktie")) {
							String companyName = readString("Företag?");

							int amount = readInt("Antal?");

							int stockSharePrice = readInt("Pris per aktie?");

							for (Person i : allPersons) {
								if (personName.equals(i.getName())) {
									i.addStockShare(personName, companyName,
											amount, stockSharePrice);
								}

							}

							// Registrera apparat
						} else if (type.equals("apparat")) {

							String deviceType = readString("Vilken sorts apparat?");
							
							double purchasePrice = readDouble("Inköpspris?");

							double condition = readDouble("nuvarande skick mellan 1 och 10");

							for (Person i : allPersons) {
								if (personName.equals(i.getName())) {
									i.addDevice(personName, deviceType,
											condition, purchasePrice);
								}

							}

						}

					} else {
						System.out.println("Personen finns inte registrerad!");
					}

					// Registrera person
				} else if (choice.equals("person")) {

					isRegistered = false;

					personName = readString("Ange namn för ny person");

					// sök igenom om personen finns i registret
					for (Person i : allPersons) {
						if (personName.equals(i.getName())) {
							isRegistered = true;
						}

					}
					if (isRegistered == false) {
						Person newPerson = new Person(personName);
						allPersons.add(newPerson);
						System.out.println(personName + " Registrerad!");

					} else if (isRegistered == true) {
						System.out.println("Personen finns redan!");
					}

				}
				break;
			// Lista alla
			case "lista":
				for (Person i : allPersons) {
					System.out.println(i.getName() + " " + i.getWorth());

				}
				break;
			// Visa rikaste
			case "visa rikaste":
				if (allPersons.isEmpty() == false) {
					Person richest = allPersons.get(0);

					for (Person i : allPersons) {
						personName = i.getName();
						if (richest.getWorth() < i.getWorth()) {
							richest = i;

						}
					}
					System.out.println("Rikast är " + richest.getName() + " med "
							+ richest.getWorth() + "kr!");
					richest.printObjects();
					
				} else {
					System.out.println("Inga personer i registret!");
				}
				break;
			// Visa specifik person
			case "visa person":
				personName = readString("Vem vill du visa?");
				for (Person i : allPersons) {
					if (personName.equals(i.getName())) {
						isRegistered = true;
					}
				}
				if (isRegistered == true) {
					System.out.println("Skriver ut " + personName
							+ "'s tillgångar:");
					for (Person i : allPersons) {
						if (personName.equals(i.getName())) {
							i.printObjects();
						}
					}
				} else {
					System.out.println(personName
							+ " finns inte i systemet! :(");
				}
				break;
			// Börskrasch
			case "börskrash":
				personName = readString("Vem ska drabbas av börskraschen?");
				for (Person i : allPersons) {
					if (personName.equals(i.getName())) {
						i.StockCrash();
					}
				}
				break;

			// AVSLUTA
			case "avsluta":
				System.out
						.println("Hejdå! Kul att träffas och ha en fortsatt trevlig dag! :)");
				System.exit(0);
			}

		} while (choice != "avsluta");

	}

	public static String readString(String s) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println(s);
		String str = keyboard.nextLine();
		return str;

	}

	public static int readInt(String s) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println(s);
		int retInt = 0;
		boolean ok;
		do {
			ok = true;
			try {
				String str = keyboard.nextLine();
				retInt = Integer.parseInt(str);
			} catch (NumberFormatException e) {

				System.out.println("Fel! Försök igen med senaste frågan!");
				ok = false;
			}
		} while (!ok);

		return retInt;
	}

	public static double readDouble(String s) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println(s);
		double retDouble = 0;
		boolean ok;
		do {
			ok = true;
			try {
				String str = keyboard.nextLine();
				retDouble = Double.parseDouble(str);

			} catch (Exception e) {
				
				System.out.println("Fel!");
				ok = false;
			}
		} while (!ok);

		return retDouble;
	}
}
