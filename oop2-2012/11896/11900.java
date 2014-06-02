package simpleMonopoly;

import java.util.ArrayList;
import java.util.Random;
import java.io.*;

public class CardFunctions {

	static Random cards = new Random();

	static ArrayList<String> chance = new ArrayList<String>();
	static ArrayList<String> chest = new ArrayList<String>();

	// Metod som läser in textsträngar från det externa textdokumentet
	// Chance.txt och lagrar dem i en Array List.
	public void importChanceStrings() {

		try {
			BufferedReader inFile = new BufferedReader(new FileReader(
					"Chance.txt"));
			int i = 0;
			while (i < 16) {
				chance.add(inFile.readLine());
				i++;
			}
			inFile.close();
		} catch (IOException e) {
			System.out.println("Something went wrong...");
			System.exit(1);
		}
	}

	// Metod som gör precis samma sak som importChanceStrings fast för
	// allmänningarna.
	public void importChestString() {

		try {
			BufferedReader inFile2 = new BufferedReader(new FileReader(
					"Chest.txt"));
			int i = 0;
			while (i < 18) {
				chest.add(inFile2.readLine());
				i++;
			}
			inFile2.close();
		} catch (IOException e) {
			System.out.println("Something went wrong...");
			System.exit(1);
		}
	}

	// Metod som anropas från PlayGame som skriver ut en slumpvist vald
	// textsträng.
	public static void randomChanceCard() {

		int randomChance = cards.nextInt(15);
		while (randomChance <= chance.size()) {

			System.out.println(chance.get(randomChance));
			break;
		}
	}

	// Samma som randomChanceCard.
	public static void randomChestCard() {

		int randomChest = cards.nextInt(17);
		while (randomChest <= chest.size()) {

			System.out.println(chest.get(randomChest));
			break;
		}
	}
}