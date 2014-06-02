package p2;

import java.util.Scanner;
import java.util.ArrayList;

public class AssetRegister {

	private static Scanner keyboard = new Scanner(System.in);
	private static ArrayList<Person> assetHolders = new ArrayList<Person>();

	public static void main(String[] args) {

		while (true) {
			
			int kom = readInt("HUVUDMENY\n\n" + "1-Skapa person\n"
					+ "2-Skapa pryl\n" + "3-Visa alla\n" + "4-Visa rikaste\n"
					+ "5-Visa viss person\n" + "6-Börskrasch\n"
					+ "7-Avsluta\n\n" + "Ange Kommando: ");

			switch (kom) {
			case 1:
				addPerson();
				break;
			case 2:
				addAsset();
				break;
			case 3:
				showAll();
				break;
			case 4:
				showRichest();
				break;
			case 5:
				showNamedPerson();
				break;
			case 6:
				stockMarketCrash();
				break;
			case 7:
				System.out.println("Programmet avslutas");
				System.exit(0);
			default:
				System.out.println("Felaktigt kommando");
			}
			System.out.println();
		}

	}

	private static void addPerson() {
		String name = readString("Personens namn: ");
		Person match = getPerson(name);
		if (match == null) {
			Person newAssetHolder = new Person(name);
			assetHolders.add(newAssetHolder);
		} else {
			System.out.println("Den personen finns redan");
		}
	}

	private static void addAsset() {
		Person accountHolder = null;
		do {
			accountHolder = getPerson(readString("Vilken person äger prylen: "));
			if (accountHolder == null) {
				System.out.println("Den personen finns inte");
				return;
			}
		} while (accountHolder == null);
		int assetType = readInt("Vilken sorts pryl (1-Smycke, 2-Aktie, 3-Apparat): ");
		switch (assetType) {
		case 1:
			JewelleryItem j = readJewelleryItem();
			accountHolder.addAsset(j);
			break;
		case 2:
			ShareHolding s = readShareHolding();
			accountHolder.addAsset(s);
			break;
		case 3:
			Appliance a = readAppliance();
			accountHolder.addAsset(a);
			break;
		default:
			System.out.println("Felaktig pryltyp");
		}

	}

	private static void showAll() {
		System.out.println("I registret finns: ");
		for (Person p : assetHolders) {
			System.out.print(p.getName());
			System.out.println("\t\t" + p.getWealth());
		}
	}

	private static void showRichest() {
		Person richest = null;
		double biggestWealth = -1;
		for (Person p : assetHolders) {
			double psWealth = p.getWealth();
			if (psWealth > biggestWealth) {
				richest = p;
				biggestWealth = psWealth;
			}
		}
		if (richest == null)
			System.out.println("Registret är tomt");
		else {
			System.out.println("Rikast är " + richest.getName()
					+ " som sammanlagt äger " + biggestWealth);
			printAssets(richest);
		}

	}

	private static void showNamedPerson() {
		System.out.println("Skriv namn på personen: ");
		String name = keyboard.nextLine();
		Person match = null;
		for (Person p : assetHolders) {
			if (p.getName().equals(name))
				match = p;
		}
		if (match == null)
			System.out.println("Ingen person med det namnet finns i registret");
		else {
			System.out.println(name + " äger sammanlagt " + match.getWealth());
			printAssets(match);
		}
	}

	private static void stockMarketCrash() {
		for (Person p : assetHolders) {
			ArrayList<Asset> assets = p.getAssets();
			for (Asset a : assets) {
				if (a instanceof ShareHolding)
					((ShareHolding) a).setPrice(0);
			}
		}
	}

	private static int readInt(String question) {
		while (true) {
			try {
				System.out.print(question);
				int answer = Integer.parseInt(keyboard.nextLine());
				return answer;
			} catch (NumberFormatException e) {
				System.out.println("Du måste ange en siffra");
			}
		}
	}

	private static String readString(String question) {
		System.out.println();
		System.out.print(question);
		String str = keyboard.nextLine();
		return str;
	}

	private static JewelleryItem readJewelleryItem() {
		String jewelleryItemName = readString("Vilken sorts smycke: ");
		int metal = 0;
		do {
			metal = readInt("Vilken metall (1=Guld, 2=Silver): ");
		} while (metal < 1 || metal > 2);
		boolean isGold;
		if (metal == 1)
			isGold = true;
		else
			isGold = false;
		int noOfGems = readInt("Antal ädelstenar: ");
		return new JewelleryItem(jewelleryItemName, isGold, noOfGems);
	}

	private static ShareHolding readShareHolding() {
		String shareHoldingName = readString("Vilken aktie: ");
		int price = readInt("Inköpspris: ");
		int noOfShares = readInt("Hur många: ");
		return new ShareHolding(shareHoldingName, price, noOfShares);
	}

	private static Appliance readAppliance() {
		String applianceName = readString("Namn: ");
		int buyingPrice = readInt("Inköpspris: ");
		int wearLevel = readInt("Slitagenivå 0-10 (10 ny): ");
		return new Appliance(applianceName, buyingPrice, wearLevel);
	}

	private static Person getPerson(String name) {
		for (Person p : assetHolders)
			if (p.getName().equalsIgnoreCase(name))
				return p;
		return null;
	}

	private static void printAssets(Person p) {
		ArrayList<Asset> assets = p.getAssets();
		for (Asset a : assets) {
			System.out.println(a.getName() + "\t" + a.getValue());
		}
		System.out.println();
	}

	
}
