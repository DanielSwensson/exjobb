package Inlupp2;

import java.util.ArrayList;
import java.util.Scanner;

public class ValueRegister {
	public static ArrayList<Person> personRegister = new ArrayList<Person>();
	public static Scanner scan = new Scanner(System.in);

	int readInt(String question) {
		for (;;) {
			try {
				System.out.println(question);
				int x = Integer.parseInt(scan.nextLine());
				return x;
			} catch (NumberFormatException e) {
				System.out.println("Fel - skall vara numeriskt värde");
			}
		}
	}

	double readDouble(String question) {
		for (;;) {
			try {
				System.out.println(question);
				int x = Integer.parseInt(scan.nextLine());
				return x;
			} catch (NumberFormatException e) {
				System.out.println("Fel - skall vara numeriskt värde");
			}
		}
	}

	String readString(String question) {
		System.out.print(question);
		String str = scan.nextLine();
		return str;
	}

	Person getPerson(String name) {
		for (Person p : personRegister)
			if (p.getName().equalsIgnoreCase(name))
				return p;
		return null;
	}

	void createPerson() {
		String name = readString("Nya personens namn: ");
		Person p = getPerson(name);

		if (p != null)
			System.out.println("Den personen finns redan");
		else {
			Person newPerson = new Person(name);
			personRegister.add(newPerson);
		}
	}

	void newItem() {
		if (personRegister.isEmpty() == true) {
			System.out.println("Registret är tomt vänligen lägg till person ");
		} else {

			String owner = readString("Vilken person äger prylen?: ");
			Person p = getPerson(owner);
			if (p != null) {
				ArrayList<Item> itemList = p.getItemList();

				String item = readString("Vilken sorts pryl? ");
				switch (item) {
				case "smycke": {
					String name = readString("Vilket sorts smycke? ");
					String material = readString("Är smycket gjort av guld eller silver? ");
					int gemstone = readInt("Ange antal ädelstenar: ");
					itemList.add(new Jewelry(name, material, gemstone));
					break;
				}
				case "aktie": {
					String name = readString("Namn på aktie?: ");
					for (Item i : itemList) {
						if (name.equalsIgnoreCase(i.getItemName())
								&& i instanceof Stock) {
							double price = readDouble("Nytt pris på aktie: ");
							int amount = readInt("Antal aktier: ");
							((Stock) i).setPrice(price);
							((Stock) i).setAmount(amount);
							return;
						}
					}
					double price = readDouble("Pris på aktie?: ");
					int amount = readInt("Antal aktier?: ");
					itemList.add(new Stock(name, amount, price));

					break;
				}
				case "apparat": {
					String name = readString("Vad för slags apparat?: ");
					int purchasePrice = readInt("Apparatens inköpspris? ");
					int wear = readInt("Ange apparatens slitage (0-10): ");
					itemList.add(new Device(name, purchasePrice, wear));
					break;
				}
				}
			} else {
				System.out
						.println("Person finns ej, vänligen registrera personen ");
			}
		}
	}

	void showAll() {
		empty();
		System.out.println("I registret finns: " + "\n");
		for (Person p : personRegister) {
			System.out.println(p.getName() + "\t" + p.getTotalValue());
		}
	}

	void showRichest() {
		empty();
		{
			Person mostMoney = null;
			double startMoney = 0;
			for (Person p : personRegister) {
				if (p.getTotalValue() > startMoney) {
					startMoney = p.getTotalValue();
					mostMoney = p;
				}
			}
			System.out.println("Rikast är " + mostMoney.getName()
					+ (" med ett totalt värde på: ") + startMoney);
			mostMoney.showItems();
		}
	}

	void showPerson() {
		empty();
		boolean personExist = true;
		String name = readString("Namnet på den du söker: ");
		for (Person p : personRegister) {
			if (name.equalsIgnoreCase(p.getName())) {
				System.out.println(p);
				personExist = false;
				p.showItems();
			}

		}
		if (personExist == true) {
			System.out.println("Fel, personen finns ej i registret.");
		}
	}

	void marketCrasch() {
		for (Person p : personRegister) {
			((Person) p).searchStock();
		}
	}

	void empty() {
		if (personRegister.isEmpty() == true) {
			System.out.println("Registret är tomt vänligen lägg till person ");
		}
	}

	public static void main(String[] args) {
		ValueRegister vr = new ValueRegister();
		for (;;) {
			System.out
					.println("Hej och välkommen! Välj ett av följande alternativ: \n 1. Skapa person \n 2. Skapa pryl \n 3. Visa alla \n 4. Visa rikaste \n 5. Visa viss person \n 6. Börskrasch \n 7. Avsluta ");
			int command = vr.readInt("");
			switch (command) {
			case 1:
				vr.createPerson();
				break;
			case 2:
				vr.newItem();
				break;
			case 3:
				vr.showAll();
				break;
			case 4:
				vr.showRichest();
				break;
			case 5:
				vr.showPerson();
				break;
			case 6:
				vr.marketCrasch();
				break;
			case 7: {
				System.out.println("Programmet avslutat");
				System.exit(0);
				break;
			}
			default:
				System.out.println("Felkommando");
			}
		}
	}
}