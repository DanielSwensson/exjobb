package simpleMonopoly;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class PlayGame {

	// Skapar en Array list d�r alla spelarobjekt som skapas i GameSetup lagras.
	static ArrayList<Player> allPlayers = new ArrayList<Player>();

	// Skapar en random number generator som anv�nds som t�rningar.
	static Random die = new Random();

	// Skapar en skanner med namnet keyboard som finns tillg�nglig i hela
	// klassen.
	public static Scanner keyboard = new Scanner(System.in);

	// Variabel d�r v�rdet av die1Value adderat med die2Value lagras.
	static int totalRoll;

	// Variabel som inneh�ller som inneh�ller vilken som �r den aktiva spelaren
	// samt en variabel som inneh�ller ett v�rde r�knaren ej f�r �verstiga,
	// vilket �r max antal spelare.
	static int playerCounter;
	static int playerCounterMax;

	public static void main(String[] args) {

		startSetup();

		// Boolean som anv�nds f�r att se till att spelare inte kan sl�
		// t�rningarna mer �n en g�ng per tur.
		boolean rolled = false;
		
		System.out.println("Setup complete.");

		System.out.println("Player " + allPlayers.get(playerCounter).getID()
				+ "'s turn to roll");

		while (true) {

			// If-sats som kollar om det bara finns en spelare kvar. Om s� �r
			// fallet har denne vunnit och detta skrivs ut till anv�ndaren
			// innan skannern st�ngs och exekveringen avbryts med felkod 0.
			if (allPlayers.size() == 1) {

				System.out.println("Player " + allPlayers.get(0).getID()
						+ " won the game! You have this much money left: "
						+ allPlayers.get(playerCounter).getBalance());
				keyboard.close();
				System.exit(0);

			}

			// Skriver ut ett tecken f�r att visa att anv�ndaren f�rv�ntas
			// skriva n�got.
			System.out.print(">");

			// command �r str�ngen som switchen l�ser av.
			String command = keyboard.nextLine();

			// Switchen som agerar som kommandotolk.

			switch (command) {

			case "help":
			case "h":

				System.err
						.println("To play the game you need to write different words in the console,\n"
								+ "the words that are currently in use are:\n'buy', 'roll ('r'), 'end' ('e'),"
								+ "'bal' ('b'), 'quit'.\n"
								+ "You write 'buy' in order to buy different streets, write 'roll'\n(or 'r')"
								+ " to roll the dice and move on the board, you have to use roll before your turn\n"
								+ "can end. Write 'end' (or 'e') to end your turn. 'bal' (or 'b')\n"
								+ "shows how much money you currently have. If you want to quit the game\n"
								+ "write 'quit' (or 'q').");
				break;

			// Kommandot f�r att sl� t�rningarna.
			case "roll":
			case "r":

				// If-satsen kontrollerar f�rst att man inte slagit denna tur.
				if (rolled == false) {

					// rollDice anropas f�r att f� ett v�rde fr�n t�rningarna.
					rollDice();

					// If-satsen kontrollerar om nuvarande spelaren �r f�ngslad.
					if (allPlayers.get(playerCounter).getJailBool() == false) {

						// H�mtar nuvarande spelaren, som finns i r�knaren
						// playerCounter, fr�n array list-en allPlayers och
						// anropar
						// metoden changeCurrentSquare i det spelarobjektet. N�r
						// metoden anropas skickas variabeln totalRoll med.
						allPlayers.get(playerCounter).changeCurrentSquare(
								totalRoll);

						// H�mtar nuvarande spelaren p� samma s�tt men anropar
						// metoden getCurrentSquare i spelarobjektet f�r att
						// printa
						// vilken ruta man �r p� numreriskt.
						System.out.println("You are currently on square: "
								+ allPlayers.get(playerCounter)
										.getCurrentSquare()
								+ " Color: "
								+ Board.squaresOnBoard[allPlayers.get(
										playerCounter).getCurrentSquare()]
										.getColor());

						if (Board.squaresOnBoard[allPlayers.get(playerCounter)
								.getCurrentSquare()].getOwner() == allPlayers
								.get(playerCounter).getID()) {

							System.out
									.println("You already own this property.");
						}

						// Printar namnet p� rutan spelaren hamnar p�.
						// Namnet h�mtas genom att rutan h�mtas ut ur arrayen
						// squaresOnBoard som finns i Board-objektet och
						// getName-metoden anropas. Vilken ruta
						// som skall h�mtas h�mtas fr�n nuvarande spelarens
						// currentSquare-variabel.
						System.out.println(Board.squaresOnBoard[allPlayers.get(
								playerCounter).getCurrentSquare()].getName());

						// If-satsen kontrollerar om nuvarande Square-objektet
						// �ven �r
						// ett Property-objekt och om det �r �gt av n�gon.
						if (Board.squaresOnBoard[allPlayers.get(playerCounter)
								.getCurrentSquare()] instanceof Property
								&& Board.squaresOnBoard[allPlayers.get(
										playerCounter).getCurrentSquare()]
										.getOwner() == 0) {

							// Skriver ut buyPrice f�r aktuella rutan.
							System.out.println("This property costs: "
									+ Board.squaresOnBoard[allPlayers.get(
											playerCounter).getCurrentSquare()]
											.getBuyPrice() + "$");
						}

						// If-satsen kontrollerar om nuvarande Square-objektet
						// �ven �r ett Misc-objekt.
						if (Board.squaresOnBoard[allPlayers.get(playerCounter)
								.getCurrentSquare()] instanceof Misc) {

							System.out.println("You cannot buy this");
						}

						// Metod som kontrollerar om hyra skall betalas och �ven
						// st�r f�r denna transaktion.
						payRent();

						// Metod som tar betalt om man hamnar p� n�gon av
						// skatterutorna Income Tax eller Luxury Tax.
						payTax();

						// Metod som visar vad som st�r p� ett slumpat
						// allm�nningkort eller chanskort
						// om man hamnar p� de rutorna, det som finns skrivet �r
						// inte implementerat.
						showChestCard();

						showChanceCard();

						// Metod som kollar om spelaren g�tt p� "Go To Jail"
						// rutan.
						goToJail();

						// Om spelaren var f�ngslad adderas 1 till jailedTime
						// f�r den spelaren. Spelaren sl�pps ut n�r jailedTime
						// n�tt 3.
					} else {

						allPlayers.get(playerCounter).addJailedTime();
						System.out.println("Jailed for "
								+ allPlayers.get(playerCounter).getJailedTime()
								+ " turn(s).");

					}

					// S�tter boolean:en rolled till sann s� man inte kan sl�
					// igen under den h�r turen.
					rolled = true;

					// Om man f�rs�ker sl� en g�ng till under samma tur k�rs
					// denna else som endast informerar om att man redan har
					// slagit denna tur.
				} else {

					System.out
							.println("You have already rolled once this turn.");

				}
				break;

			// Kommandot f�r att avsluta sin tur.
			case "end":
			case "e":

				// If-satsen kontrollerar att man har slagit denna tur.
				if (rolled) {

					// If-satsen kontrollerar om jailTime �r 3. Om den �r det
					// nollst�lls jailTime och jailBool s�tts till false.
					if (allPlayers.get(playerCounter).getJailedTime() == 3) {

						System.out.println("You've been let out of jail.");

						allPlayers.get(playerCounter).resetJailedTime();

						allPlayers.get(playerCounter).setJailBool(false);

					}

					// If-sats som kollar utifall man �r bankrutt, allts� om
					// balance �r 0 eller mindre.
					if (allPlayers.get(playerCounter).getBalance() <= 0) {

						// Printar vilken spelaren som har blivit bankrutt genom
						// att h�mta nuvarande spelarens ID-variabel via getID.
						System.out
								.println("Player "
										+ allPlayers.get(playerCounter).getID()
										+ " has gone bankrupt and is now out of the game.");

						// N�r meddelandet skrivits ut tas spelarobjektet ut ur
						// array list-en. allPlayers.playerCounterMax minskas
						// med 1.
						allPlayers.remove(playerCounter);
						playerCounterMax -= 1;

						// F�ljande if-satser r�ttar playerCounter s�
						// turodningen uppeh�lls n�r en spelare tagits bort
						if (playerCounter > playerCounterMax) {
							playerCounter = 0;

						} else if (playerCounter < 0) {
							playerCounter += 1;

						} else if (playerCounter == 0) {
							playerCounter = 0;
						} else {
							playerCounter -= 1;
						}

						rolled = false;

						System.out.println("Player "
								+ allPlayers.get(playerCounter).getID()
								+ "'s turn to roll");

						break;
					}

					// Om spelaren som avslutar turen inte �r bankrutt plussas
					// playerCounter med 1.
					++playerCounter;

					// If-satsen kontrollerar s� playerCounter aldrig �r lika
					// med eller h�gre �n playerCounterMax. Om if-satsen g�r
					// igenom s�tts playerCounter till 0, detta betyder att man
					// har g�tt ett varv runt spelarna.
					if (playerCounter >= playerCounterMax) {

						playerCounter = 0;

					}

					// Om man f�rs�ker avsluta turen utan att ha slagit g�r
					// denna else igenom och ett meddelande skrivs ut.
				} else {

					System.out.println("You have to roll first.");
					break;

				}

				// Innan n�sta person f�r p�b�rja sin tur s�tts rolled till
				// false s� denne kan sl�.
				rolled = false;

				System.out.println("Player "
						+ allPlayers.get(playerCounter).getID()
						+ "'s turn to roll");

				break;

			// Kommandot f�r att k�pa en ruta.
			case "buy":

				// If-sats som kollar att ingen redan �ger rutan som man
				// f�rs�ker k�pa.
				if (Board.squaresOnBoard[allPlayers.get(playerCounter)
						.getCurrentSquare()].getOwner() == 0) {

					buyProperty();
					System.out
							.println("Buying this leaves you "
									+ allPlayers.get(playerCounter)
											.getBalance() + "$.");
				}

				break;

			// Kommandot f�r att skriva ut ens nuvarande tillg�ngar.
			case "bal":
			case "b":

				System.out.println("You currently have "
						+ allPlayers.get(playerCounter).getBalance() + "$");

				break;

			// Kommandot f�r att avsluta programmet.
			case "quit":
			case "q":

				keyboard.close();
				System.exit(0);

			default:
				System.out.println("Invalid command. Type 'help' or 'h' for help.");
			}
		}
	}

	private static void startSetup() {

		// Metod som skapar en instans av GameSetup-klassen. Metoden anropar
		// sedan
		// metoden monopolySetup i det nyskapade GameSetup-objektet.

		System.out.println("Starting setup.");
		// GameSetup newGame = new GameSetup();
		GameSetup.monopolySetup();

	}

	public static void rollDice() {

		// Slumpar tv� v�rden mellan 1-6 som adderas och sparas i totalroll.

		int die1Value = die.nextInt(5) + 1;
		int die2Value = die.nextInt(5) + 1;

		// int die1Value = 1; /*Till f�r att rigga spelet vid testande.*/
		// int die2Value = 1; /*Till f�r att rigga spelet vid testande.*/

		// Om man �r f�ngslad kontrolleras det om man slog dubbelt. Sl�r man
		// dubbelt sl�pps man ut ur f�ngelset.
		if (allPlayers.get(playerCounter).getJailBool()) {

			if (die1Value == die2Value) {

				allPlayers.get(playerCounter).setJailBool(false);
				System.out.println("You rolled doubles.");
			}
		}

		totalRoll = +(die1Value + die2Value);

		// totalRoll = (12); /*Till f�r att rigga spelet vid testande.*/

		System.out.println("You rolled: " + totalRoll);

		return;

	}

	public static void payRent() {

		// If-sats som kontrollerar att man inte sj�lv �r rutans �gare eller att
		// rutan inte �gs av n�gon.
		if (allPlayers.get(playerCounter).getID() != Board.squaresOnBoard[allPlayers
				.get(playerCounter).getCurrentSquare()].getOwner()
				&& Board.squaresOnBoard[allPlayers.get(playerCounter)
						.getCurrentSquare()].getOwner() > 0) {

			// H�mtar hyran fr�n det aktuella rutobjektet.
			System.out.println("Paying rent ("
					+ Board.squaresOnBoard[allPlayers.get(playerCounter)
							.getCurrentSquare()].getRent()
					+ "$) to Player "
					+ Board.squaresOnBoard[allPlayers.get(playerCounter)
							.getCurrentSquare()].getOwner());

			// Subtraherar nuvarande spelarens balance med hyran som h�mtas fr�n
			// rutobjektet i fr�ga.
			allPlayers.get(playerCounter).decreaseBalance(
					Board.squaresOnBoard[allPlayers.get(playerCounter)
							.getCurrentSquare()].getRent());

			// Adderar hyran till rutans �gare.
			allPlayers.get(
					Board.squaresOnBoard[allPlayers.get(playerCounter)
							.getCurrentSquare()].getOwner() - 1)
					.increaseBalance(
							Board.squaresOnBoard[allPlayers.get(playerCounter)
									.getCurrentSquare()].getRent());

		}
	}

	public static void buyProperty() {

		System.out.println("Buying...");

		// If-satsen kontrollerar om man har r�d genom att j�mf�ra rutans
		// k�ppris (buyPrice) med spelarens tillg�ngar (balance). Om balance �r
		// st�rre �n buyPrice startas k�pproceduren, annars h�nder ingenting.
		if (Board.squaresOnBoard[allPlayers.get(playerCounter)
				.getCurrentSquare()].getBuyPrice() < allPlayers.get(
				playerCounter).getBalance()) {

			// S�tter �garen i rutobjektet till spelarens ID.
			Board.squaresOnBoard[allPlayers.get(playerCounter)
					.getCurrentSquare()].setOwner(allPlayers.get(playerCounter)
					.getID());

			// Minskar k�pande spelarens balance med buyPrice.
			allPlayers.get(playerCounter).decreaseBalance(
					Board.squaresOnBoard[allPlayers.get(playerCounter)
							.getCurrentSquare()].getBuyPrice());
		}
	}

	public static void payTax() {

		// If-sats som kontrollerar om du st�r p� n�gon utav skatterutorna.
		if (allPlayers.get(playerCounter).getCurrentSquare() == 4
				|| allPlayers.get(playerCounter).getCurrentSquare() == 38) {

			System.out.println("You need to pay "
					+ Board.squaresOnBoard[allPlayers.get(playerCounter)
							.getCurrentSquare()].getTax() + "$");

			// Subtraherar nuvarande spelarens balance med skatten som h�mtas
			// fr�n rutobjektet i fr�ga.
			allPlayers.get(playerCounter).decreaseBalance(
					Board.squaresOnBoard[allPlayers.get(playerCounter)
							.getCurrentSquare()].getTax());
		}
	}

	// H�mtar allm�nning.
	public static void showChestCard() {

		// If-sats som kontrollerar om man st�r p� en allm�nningsruta.
		if (allPlayers.get(playerCounter).getCurrentSquare() == 2
				|| allPlayers.get(playerCounter).getCurrentSquare() == 17
				|| allPlayers.get(playerCounter).getCurrentSquare() == 33) {

			// Anropar metoden som tar hand om korten.
			CardFunctions.randomChestCard();

			// Meddelandet syftar p� att ingen funktionalitet finns
			// implementerad. Texten dyker upp men inget h�nder i denna version.
			System.out.println("***This is not implemented***");
		}
	}

	// Samma som showChestCard fast f�r chanskorten.
	public static void showChanceCard() {

		if (allPlayers.get(playerCounter).getCurrentSquare() == 7
				|| allPlayers.get(playerCounter).getCurrentSquare() == 22
				|| allPlayers.get(playerCounter).getCurrentSquare() == 36) {

			CardFunctions.randomChanceCard();
			System.out.println("***This is not implemented***");
		}

	}

	// F�ngslar spelare om den hamnar p� ruta 30.
	public static void goToJail() {

		// If-satsen kontrollerar om man st�r p� ruta 30.
		if (allPlayers.get(playerCounter).getCurrentSquare() == 30) {

			// S�tter spelaren p� ruta 10 och �ndrar jailBool till true.
			allPlayers.get(playerCounter).setCurrentSquare(10);
			allPlayers.get(playerCounter).setJailBool(true);
		}
	}
}
