package simpleMonopoly;

import java.util.InputMismatchException;

public class GameSetup {

	public static void monopolySetup() {

		// Metoden skapar ett Board-objekt, br�det som spelet spelas p�, som i
		// sin tur anropas f�r att skapa alla rutor via createSquares-metoden.
		// Metoden createPlayers anropas n�r br�det �r skapat. Chans och
		// Allm�nning f�rbereds i CardFunctions efter spelarobjekt skapats.

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

		// Metod som skapar spelarobjekt (Player) baserad p� anv�ndarens input.
		int numberOfPlayers = 0;

		try {
			System.out.print("Number of players: ");
			numberOfPlayers = PlayGame.keyboard.nextInt();

			// If-sats som kontrollerar att det angivna numret inte �r f�r stort
			// eller f�r litet. Om s� �r fallet meddelas anv�ndaren och
			// proceduren startas om.
			if (numberOfPlayers > 8 || numberOfPlayers < 2) {

				System.out
						.println("Invalid number of players, must be between 2-8.");
				createPlayers();

			}
			// F�ngar om anv�ndarens input inte �r en integer och startas om
			// proceduren om s� �r fallet.
		} catch (InputMismatchException e) {

			System.out.println("Invalid input, only numbers are allowed.");
			System.out.println(PlayGame.keyboard.nextLine());
			createPlayers();

		}

		// S�tter variabeln playerCounterMax i PlayGame.
		PlayGame.playerCounterMax = numberOfPlayers;

		// Loop som skapar ett antal spelarobjekt baserat p� anv�ndarens input
		// och l�gger dem i array list-en allPlayers i PlayGame. Alla
		// spelarobjekt f�r ett eget ID-nummer fr�n 1-8.
		for (int x = 0; x < numberOfPlayers; x++) {

			Player monopolyPlayer = new Player();
			PlayGame.allPlayers.add(monopolyPlayer);
			PlayGame.allPlayers.get(x).setID(x + 1);
		}
	}
}
