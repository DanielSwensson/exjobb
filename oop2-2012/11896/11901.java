package simpleMonopoly;

import java.util.InputMismatchException;

public class GameSetup {

	public static void monopolySetup() {

		// Metoden skapar ett Board-objekt, brädet som spelet spelas på, som i
		// sin tur anropas för att skapa alla rutor via createSquares-metoden.
		// Metoden createPlayers anropas när brädet är skapat. Chans och
		// Allmänning förbereds i CardFunctions efter spelarobjekt skapats.

		System.out.println("Creating squares...");
		Board.createSquares();
		System.out.println("Squares created");

		System.out.println("Creating players...");
		createPlayers();
		System.out.println("Players created.");
		System.out.print(PlayGame.keyboard.nextLine());

		CardFunctions cards = new CardFunctions();
		cards.importChanceStrings();
		cards.importChestString();
		System.out.println("Chance and Community Chests created.");

	}

	private static void createPlayers() {

		// Metod som skapar spelarobjekt (Player) baserad på användarens input.
		int numberOfPlayers = 0;

		try {
			System.out.print("Number of players: ");
			numberOfPlayers = PlayGame.keyboard.nextInt();

			// If-sats som kontrollerar att det angivna numret inte är för stort
			// eller för litet. Om så är fallet meddelas användaren och
			// proceduren startas om.
			if (numberOfPlayers > 8 || numberOfPlayers < 2) {

				System.out
						.println("Invalid number of players, must be between 2-8.");
				createPlayers();

			}
			// Fångar om användarens input inte är en integer och startas om
			// proceduren om så är fallet.
		} catch (InputMismatchException e) {

			System.out.println("Invalid input, only numbers are allowed.");
			System.out.println(PlayGame.keyboard.nextLine());
			createPlayers();

		}

		// Sätter variabeln playerCounterMax i PlayGame.
		PlayGame.playerCounterMax = numberOfPlayers;

		// Loop som skapar ett antal spelarobjekt baserat på användarens input
		// och lägger dem i array list-en allPlayers i PlayGame. Alla
		// spelarobjekt får ett eget ID-nummer från 1-8.
		for (int x = 0; x < numberOfPlayers; x++) {

			Player monopolyPlayer = new Player();
			PlayGame.allPlayers.add(monopolyPlayer);
			PlayGame.allPlayers.get(x).setID(x + 1);
		}
	}
}
