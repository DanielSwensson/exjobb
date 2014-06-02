package simpleMonopoly;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class PlayGame {

	// Skapar en Array list där alla spelarobjekt som skapas i GameSetup lagras.
	static ArrayList<Player> allPlayers = new ArrayList<Player>();

	// Skapar en random number generator som används som tärningar.
	static Random die = new Random();

	// Skapar en skanner med namnet keyboard som finns tillgänglig i hela
	// klassen.
	public static Scanner keyboard = new Scanner(System.in);

	// Variabel där värdet av die1Value adderat med die2Value lagras.
	static int totalRoll;

	// Variabel som innehåller som innehåller vilken som är den aktiva spelaren
	// samt en variabel som innehåller ett värde räknaren ej får överstiga,
	// vilket är max antal spelare.
	static int playerCounter;
	static int playerCounterMax;

	public static void main(String[] args) {

		startSetup();

		// Boolean som används för att se till att spelare inte kan slå
		// tärningarna mer än en gång per tur.
		boolean rolled = false;
		
		System.out.println("Setup complete.");

		System.out.println("Player " + allPlayers.get(playerCounter).getID()
				+ "'s turn to roll");

		while (true) {

			// If-sats som kollar om det bara finns en spelare kvar. Om så är
			// fallet har denne vunnit och detta skrivs ut till användaren
			// innan skannern stängs och exekveringen avbryts med felkod 0.
			if (allPlayers.size() == 1) {

				System.out.println("Player " + allPlayers.get(0).getID()
						+ " won the game! You have this much money left: "
						+ allPlayers.get(playerCounter).getBalance());
				keyboard.close();
				System.exit(0);

			}

			// Skriver ut ett tecken för att visa att användaren förväntas
			// skriva något.
			System.out.print(">");

			// command är strängen som switchen läser av.
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

			// Kommandot för att slå tärningarna.
			case "roll":
			case "r":

				// If-satsen kontrollerar först att man inte slagit denna tur.
				if (rolled == false) {

					// rollDice anropas för att få ett värde från tärningarna.
					rollDice();

					// If-satsen kontrollerar om nuvarande spelaren är fängslad.
					if (allPlayers.get(playerCounter).getJailBool() == false) {

						// Hämtar nuvarande spelaren, som finns i räknaren
						// playerCounter, från array list-en allPlayers och
						// anropar
						// metoden changeCurrentSquare i det spelarobjektet. När
						// metoden anropas skickas variabeln totalRoll med.
						allPlayers.get(playerCounter).changeCurrentSquare(
								totalRoll);

						// Hämtar nuvarande spelaren på samma sätt men anropar
						// metoden getCurrentSquare i spelarobjektet för att
						// printa
						// vilken ruta man är på numreriskt.
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

						// Printar namnet på rutan spelaren hamnar på.
						// Namnet hämtas genom att rutan hämtas ut ur arrayen
						// squaresOnBoard som finns i Board-objektet och
						// getName-metoden anropas. Vilken ruta
						// som skall hämtas hämtas från nuvarande spelarens
						// currentSquare-variabel.
						System.out.println(Board.squaresOnBoard[allPlayers.get(
								playerCounter).getCurrentSquare()].getName());

						// If-satsen kontrollerar om nuvarande Square-objektet
						// även är
						// ett Property-objekt och om det är ägt av någon.
						if (Board.squaresOnBoard[allPlayers.get(playerCounter)
								.getCurrentSquare()] instanceof Property
								&& Board.squaresOnBoard[allPlayers.get(
										playerCounter).getCurrentSquare()]
										.getOwner() == 0) {

							// Skriver ut buyPrice för aktuella rutan.
							System.out.println("This property costs: "
									+ Board.squaresOnBoard[allPlayers.get(
											playerCounter).getCurrentSquare()]
											.getBuyPrice() + "$");
						}

						// If-satsen kontrollerar om nuvarande Square-objektet
						// även är ett Misc-objekt.
						if (Board.squaresOnBoard[allPlayers.get(playerCounter)
								.getCurrentSquare()] instanceof Misc) {

							System.out.println("You cannot buy this");
						}

						// Metod som kontrollerar om hyra skall betalas och även
						// står för denna transaktion.
						payRent();

						// Metod som tar betalt om man hamnar på någon av
						// skatterutorna Income Tax eller Luxury Tax.
						payTax();

						// Metod som visar vad som står på ett slumpat
						// allmänningkort eller chanskort
						// om man hamnar på de rutorna, det som finns skrivet är
						// inte implementerat.
						showChestCard();

						showChanceCard();

						// Metod som kollar om spelaren gått på "Go To Jail"
						// rutan.
						goToJail();

						// Om spelaren var fängslad adderas 1 till jailedTime
						// för den spelaren. Spelaren släpps ut när jailedTime
						// nått 3.
					} else {

						allPlayers.get(playerCounter).addJailedTime();
						System.out.println("Jailed for "
								+ allPlayers.get(playerCounter).getJailedTime()
								+ " turn(s).");

					}

					// Sätter boolean:en rolled till sann så man inte kan slå
					// igen under den här turen.
					rolled = true;

					// Om man försöker slå en gång till under samma tur körs
					// denna else som endast informerar om att man redan har
					// slagit denna tur.
				} else {

					System.out
							.println("You have already rolled once this turn.");

				}
				break;

			// Kommandot för att avsluta sin tur.
			case "end":
			case "e":

				// If-satsen kontrollerar att man har slagit denna tur.
				if (rolled) {

					// If-satsen kontrollerar om jailTime är 3. Om den är det
					// nollställs jailTime och jailBool sätts till false.
					if (allPlayers.get(playerCounter).getJailedTime() == 3) {

						System.out.println("You've been let out of jail.");

						allPlayers.get(playerCounter).resetJailedTime();

						allPlayers.get(playerCounter).setJailBool(false);

					}

					// If-sats som kollar utifall man är bankrutt, alltså om
					// balance är 0 eller mindre.
					if (allPlayers.get(playerCounter).getBalance() <= 0) {

						// Printar vilken spelaren som har blivit bankrutt genom
						// att hämta nuvarande spelarens ID-variabel via getID.
						System.out
								.println("Player "
										+ allPlayers.get(playerCounter).getID()
										+ " has gone bankrupt and is now out of the game.");

						// När meddelandet skrivits ut tas spelarobjektet ut ur
						// array list-en. allPlayers.playerCounterMax minskas
						// med 1.
						allPlayers.remove(playerCounter);
						playerCounterMax -= 1;

						// Följande if-satser rättar playerCounter så
						// turodningen uppehålls när en spelare tagits bort
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

					// Om spelaren som avslutar turen inte är bankrutt plussas
					// playerCounter med 1.
					++playerCounter;

					// If-satsen kontrollerar så playerCounter aldrig är lika
					// med eller högre än playerCounterMax. Om if-satsen går
					// igenom sätts playerCounter till 0, detta betyder att man
					// har gått ett varv runt spelarna.
					if (playerCounter >= playerCounterMax) {

						playerCounter = 0;

					}

					// Om man försöker avsluta turen utan att ha slagit går
					// denna else igenom och ett meddelande skrivs ut.
				} else {

					System.out.println("You have to roll first.");
					break;

				}

				// Innan nästa person får påbörja sin tur sätts rolled till
				// false så denne kan slå.
				rolled = false;

				System.out.println("Player "
						+ allPlayers.get(playerCounter).getID()
						+ "'s turn to roll");

				break;

			// Kommandot för att köpa en ruta.
			case "buy":

				// If-sats som kollar att ingen redan äger rutan som man
				// försöker köpa.
				if (Board.squaresOnBoard[allPlayers.get(playerCounter)
						.getCurrentSquare()].getOwner() == 0) {

					buyProperty();
					System.out
							.println("Buying this leaves you "
									+ allPlayers.get(playerCounter)
											.getBalance() + "$.");
				}

				break;

			// Kommandot för att skriva ut ens nuvarande tillgångar.
			case "bal":
			case "b":

				System.out.println("You currently have "
						+ allPlayers.get(playerCounter).getBalance() + "$");

				break;

			// Kommandot för att avsluta programmet.
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

		// Slumpar två värden mellan 1-6 som adderas och sparas i totalroll.

		int die1Value = die.nextInt(5) + 1;
		int die2Value = die.nextInt(5) + 1;

		// int die1Value = 1; /*Till för att rigga spelet vid testande.*/
		// int die2Value = 1; /*Till för att rigga spelet vid testande.*/

		// Om man är fängslad kontrolleras det om man slog dubbelt. Slår man
		// dubbelt släpps man ut ur fängelset.
		if (allPlayers.get(playerCounter).getJailBool()) {

			if (die1Value == die2Value) {

				allPlayers.get(playerCounter).setJailBool(false);
				System.out.println("You rolled doubles.");
			}
		}

		totalRoll = +(die1Value + die2Value);

		// totalRoll = (12); /*Till för att rigga spelet vid testande.*/

		System.out.println("You rolled: " + totalRoll);

		return;

	}

	public static void payRent() {

		// If-sats som kontrollerar att man inte själv är rutans ägare eller att
		// rutan inte ägs av någon.
		if (allPlayers.get(playerCounter).getID() != Board.squaresOnBoard[allPlayers
				.get(playerCounter).getCurrentSquare()].getOwner()
				&& Board.squaresOnBoard[allPlayers.get(playerCounter)
						.getCurrentSquare()].getOwner() > 0) {

			// Hämtar hyran från det aktuella rutobjektet.
			System.out.println("Paying rent ("
					+ Board.squaresOnBoard[allPlayers.get(playerCounter)
							.getCurrentSquare()].getRent()
					+ "$) to Player "
					+ Board.squaresOnBoard[allPlayers.get(playerCounter)
							.getCurrentSquare()].getOwner());

			// Subtraherar nuvarande spelarens balance med hyran som hämtas från
			// rutobjektet i fråga.
			allPlayers.get(playerCounter).decreaseBalance(
					Board.squaresOnBoard[allPlayers.get(playerCounter)
							.getCurrentSquare()].getRent());

			// Adderar hyran till rutans ägare.
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

		// If-satsen kontrollerar om man har råd genom att jämföra rutans
		// köppris (buyPrice) med spelarens tillgångar (balance). Om balance är
		// större än buyPrice startas köpproceduren, annars händer ingenting.
		if (Board.squaresOnBoard[allPlayers.get(playerCounter)
				.getCurrentSquare()].getBuyPrice() < allPlayers.get(
				playerCounter).getBalance()) {

			// Sätter ägaren i rutobjektet till spelarens ID.
			Board.squaresOnBoard[allPlayers.get(playerCounter)
					.getCurrentSquare()].setOwner(allPlayers.get(playerCounter)
					.getID());

			// Minskar köpande spelarens balance med buyPrice.
			allPlayers.get(playerCounter).decreaseBalance(
					Board.squaresOnBoard[allPlayers.get(playerCounter)
							.getCurrentSquare()].getBuyPrice());
		}
	}

	public static void payTax() {

		// If-sats som kontrollerar om du står på någon utav skatterutorna.
		if (allPlayers.get(playerCounter).getCurrentSquare() == 4
				|| allPlayers.get(playerCounter).getCurrentSquare() == 38) {

			System.out.println("You need to pay "
					+ Board.squaresOnBoard[allPlayers.get(playerCounter)
							.getCurrentSquare()].getTax() + "$");

			// Subtraherar nuvarande spelarens balance med skatten som hämtas
			// från rutobjektet i fråga.
			allPlayers.get(playerCounter).decreaseBalance(
					Board.squaresOnBoard[allPlayers.get(playerCounter)
							.getCurrentSquare()].getTax());
		}
	}

	// Hämtar allmänning.
	public static void showChestCard() {

		// If-sats som kontrollerar om man står på en allmänningsruta.
		if (allPlayers.get(playerCounter).getCurrentSquare() == 2
				|| allPlayers.get(playerCounter).getCurrentSquare() == 17
				|| allPlayers.get(playerCounter).getCurrentSquare() == 33) {

			// Anropar metoden som tar hand om korten.
			CardFunctions.randomChestCard();

			// Meddelandet syftar på att ingen funktionalitet finns
			// implementerad. Texten dyker upp men inget händer i denna version.
			System.out.println("***This is not implemented***");
		}
	}

	// Samma som showChestCard fast för chanskorten.
	public static void showChanceCard() {

		if (allPlayers.get(playerCounter).getCurrentSquare() == 7
				|| allPlayers.get(playerCounter).getCurrentSquare() == 22
				|| allPlayers.get(playerCounter).getCurrentSquare() == 36) {

			CardFunctions.randomChanceCard();
			System.out.println("***This is not implemented***");
		}

	}

	// Fängslar spelare om den hamnar på ruta 30.
	public static void goToJail() {

		// If-satsen kontrollerar om man står på ruta 30.
		if (allPlayers.get(playerCounter).getCurrentSquare() == 30) {

			// Sätter spelaren på ruta 10 och ändrar jailBool till true.
			allPlayers.get(playerCounter).setCurrentSquare(10);
			allPlayers.get(playerCounter).setJailBool(true);
		}
	}
}
