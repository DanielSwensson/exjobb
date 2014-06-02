import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Registry {

	public static void main(String[] args) throws IOException {

		boolean run = true;
		ArrayList<Person> persons = new ArrayList<Person>();
		ArrayList<Stock> stocks = new ArrayList<Stock>();
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));

		while (run) {
			System.out.println("[1] Register Person");
			System.out.println("[2] Register Object");
			System.out.println("[3] Show All");
			System.out.println("[4] Show Wealthiest");
			System.out.println("[5] Show Specific Person");
			System.out.println("[6] Stock Crash");
			System.out.println("[7] Exit");
			System.out.println("Choose one...");
			int choice = -1;
			boolean menu = true;
			while (menu) {
				try {
					choice = Integer.parseInt(reader.readLine());
					if (choice < 0 && choice > 7) {
						System.out.println("You must choose one.");
					} else {
						menu = false;
					}
				} catch (NumberFormatException e) {
					System.out.println("Only numbers allowed.");
				}
			}
			if (choice == 1) {
				System.out.println("What is the persons name?");
				String personName = reader.readLine();
				boolean notTaken = true;
				for (int i = 0; i < persons.size(); i++) {
					if (persons.get(i).getName().equalsIgnoreCase(personName)) {
						notTaken = false;
					}
				}
				if (notTaken) {
					persons.add(new Person(personName));
					System.out.println(personName + " has been registered.");
				} else {
					System.out.println(personName + " already exists.");
				}
			} else if (choice == 2) {
				if (persons.size() > 0) {
					menu = true;
					int objectChoice = 0;
					String objectName;
					int ownerChoice = -1;
					boolean gold = true;
					int gems = 0;
					while (menu) {
						System.out.println("Who owns the object?");
						for (int i = 0; i < persons.size(); i++) {
							System.out.println("[" + (i + 1) + "] "
									+ persons.get(i).getName());
						}
						try {
							ownerChoice = Integer.parseInt(reader.readLine()) - 1;
							if (ownerChoice < 0
									|| ownerChoice >= persons.size()) {
								System.out.println("You must choose one.");
							} else {
								menu = false;
							}
						} catch (NumberFormatException e) {
							System.out.println("Only numbers allowed.");
						}
					}
					menu = true;
					while (menu) {
						System.out.println("What kind of object?");
						System.out.println("[1] Jewlery");
						System.out.println("[2] Stock");
						System.out.println("[3] Appliance");
						try {
							objectChoice = Integer.parseInt(reader.readLine());
							if (objectChoice < 1 || objectChoice > 3) {
								System.out.println("You must choose one.");
							} else {
								menu = false;
							}
						} catch (NumberFormatException e) {
							System.out.println("Only numbers allowed.");
						}
					}
					menu = true;
					if (objectChoice == 1) {
						System.out.println("What kind of jewlery?");
						objectName = reader.readLine();
						while (menu) {
							try {
								System.out.println("Gold or silver jewlery?");
								System.out.println("[1] Gold");
								System.out.println("[2] Silver");
								int goldChoice = Integer.parseInt(reader
										.readLine());
								if (goldChoice < 1 || goldChoice > 2) {
									System.out.println("You must choose one.");
								} else {
									if (goldChoice == 2) {
										gold = false;
									}
									menu = false;
								}
							} catch (NumberFormatException e) {
								System.out.println("Only numbers allowed.");
							}
						}
						menu = true;
						while (menu) {
							try {
								System.out.println("How many gems?");
								gems = Integer.parseInt(reader.readLine());
								menu = false;
							} catch (NumberFormatException e) {
								System.out.println("Only numbers allowed.");
							}
						}
						persons.get(ownerChoice).addObject(
								new Jewlery(objectName, gold, gems));
					} else if (objectChoice == 2) {
						int stockChoice = -1;
						int stockAmount = 0;
						while (menu) {
							System.out.println("What kind of stock?");
							System.out.println("[1] New stock.");
							for (int i = 0; i < stocks.size(); i++) {
								System.out.println("[" + (i + 2) + "] "
										+ stocks.get(i).getName());
							}
							try {
								stockChoice = Integer.parseInt(reader
										.readLine()) - 2;
								if (stockChoice < -1
										|| stockChoice >= stocks.size()) {
									System.out.println("You must pick one.");
								} else {
									menu = false;
								}
							} catch (NumberFormatException e) {
								System.out.println("Only numbers allowed.");
							}
						}
						if (stockChoice == -1) {
							System.out
									.println("What is the name of the stock?");
							String stockName = reader.readLine();
							double stockValue = 0;
							menu = true;
							while (menu) {
								System.out.println("How much is if worth?");
								try {
									stockValue = Double.parseDouble(reader
											.readLine());
									menu = false;
								} catch (NumberFormatException e) {
									System.out.println("Only numbers allowed.");
								}
							}
							stocks.add(new Stock(stockName, stockValue));
							stockChoice = stocks.size() - 1;
						}
						menu = true;
						while (menu) {
							try {
								System.out.println("How many stocks?");
								stockAmount = Integer.parseInt(reader
										.readLine());
								menu = false;
							} catch (NumberFormatException e) {
								System.out.println("Only numbers allowed.");
							}
						}
						persons.get(ownerChoice).addObject(
								new StockPost(stocks.get(stockChoice),
										stockAmount));
					} else if (objectChoice == 3) {
						int wear = 10;
						double buyingPrice = -1;
						System.out.println("What kind of appliance?");
						objectName = reader.readLine();
						while (menu) {
							try {
								System.out
										.println("How worn is the appliance on a scale from 0 to 10?");
								wear = Integer.parseInt(reader.readLine());
								if (wear < 1 || wear > 10) {
									System.out
											.println("The number must be between 0 and 10.");
								} else {
									menu = false;
								}
							} catch (NumberFormatException e) {
								System.out.println("Only numbers allowed.");
							}
						}
						menu = true;
						while (menu) {
							try {
								System.out
										.println("What was the buying price?");
								buyingPrice = Double.parseDouble(reader
										.readLine());
								if (buyingPrice > 0) {
									persons.get(ownerChoice).addObject(
											new Appliance(objectName,
													buyingPrice, wear));
									menu = false;
								} else {
									System.out
											.println("The appliance can't have a negative buying price.");

								}
							} catch (NumberFormatException e) {
								System.out.println("Only numbers allowed.");
							}
						}
					}
				} else {
					System.out
							.println("You have to make a person before you can register an object.");
				}
			} else if (choice == 3) {
				System.out.println("People in the registry:");
				for (int i = 0; i < persons.size(); i++) {
					System.out.println(persons.get(i).getName() + "   "
							+ persons.get(i).getTotalValue());
				}
				System.out.println("");
			} else if (choice == 4) {
				int richest = 0;
				for (int i = 1; i < persons.size(); i++) {
					if (persons.get(richest).getTotalValue() < persons.get(i)
							.getTotalValue())
						;
					richest = i;
				}
				System.out.print("The richest person is ");
				printPerson(persons.get(richest));
			} else if (choice == 5) {
				menu = true;
				while (menu) {
					System.out.println("Who do you wish to see?");
					for (int i = 0; i < persons.size(); i++) {
						System.out.println("[" + (i + 1) + "] "
								+ persons.get(i).getName());
					}
					try {
						int showChoice = Integer.parseInt(reader.readLine()) - 1;
						if (showChoice < 0 || showChoice >= persons.size()) {
							System.out.println("You must choose one.");
						} else {
							printPerson(persons.get(showChoice));
							menu = false;
						}
					} catch (NumberFormatException e) {
						System.out.println("Only numbers allowed.");
					}
				}
			} else if (choice == 6) {
				System.out.println("!!!STOCK CRASH!!!");
				for (int i = 0; i < stocks.size(); i++) {
					stocks.get(i).setPrice(0);
				}
			} else if (choice == 7) {
				System.out.println("Program Exited.");
				run = false;
			} else {
				System.out.println("You must choose one.");
			}
		}
	}

	private static void printPerson(Person person) {
		System.out.println(person.getName() + ". Owns a total of : "
				+ person.getTotalValue());
		for (int i = 0; i < person.getObjects().size(); i++) {
			System.out.println(person.getObjects().get(i).getName() + "    "
					+ person.getObjects().get(i).getValue());
		}
		System.out.println("");
	}
}