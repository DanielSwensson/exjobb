import java.util.ArrayList;
import java.util.Scanner;
public class BigWinHockeyStats {
	static private  Scanner keyboard = new Scanner(System.in);
	private static ArrayList<BigImpactCards> BIC = new ArrayList<BigImpactCards>();
	private static ArrayList<HockeyPlayers> players = new ArrayList<HockeyPlayers>();
	public static void main (String[]args){

		commandList();
		for(;;){
			options();
			mainMenu();	
		}
	}

	// Översätter resultatet till vinst, oavgjort eller förlust

	private static int checkResult(int goalsFor, int goalsAgainst){
		int result = 0;	
		if(goalsFor>goalsAgainst){
			result += 2;
		}
		else if(goalsFor==goalsAgainst){
			result++;
		}
		else{	
			result = 0;					
		}
		return result;
	}

	// Läser heltal

	private static int readInt (String prompt){
		System.out.print(prompt);
		int number = keyboard.nextInt();
		return number;
	}

	// Registrerar vilka kort som har använts

	private static String cardUsed(){
		System.out.println("Which card did you use? ");
		String cardUsed = keyboard.nextLine();
		return cardUsed;
	}

	// Frågar om kort använts vid matchtillfället

	private static int cardQuestion (){
		System.out.print("Did you use any cards? (1 for yes, 2 for no) ");
		int cardquestion = keyboard.nextInt();
		return cardquestion; 
	}

	// Hämtar matchresultatet från användaren

	private static int fetchResult(){
		System.out.print("Result, starting with your teams goals scored, separated by a blank (e.g 1 0): ");
		int goalsFor = keyboard.nextInt();
		int goalsAgainst = keyboard.nextInt();
		int result = checkResult(goalsFor, goalsAgainst);
		return result;
	}

	// Hämtar antal kort som använts i matchen

	private static int amountOfCardsUsed (){
		System.out.print("How many cards did you use? ");
		int amountOfCardsUsed = keyboard.nextInt();
		return amountOfCardsUsed;
	}

	// Registrerar resultaten på korten (OBSOBSOBS SISTA-MINUTEN-BUG!! AV NGN ANLEDNING SKRIVER cardUsed UT SIN FRÅGA TVÅ GÅNGER FÖRSTA GÅNGEN 
	// MEN FUNGERAR SEDAN SOM TÄNKT UTÖVER ATT EN FRÅGA "SLÖSAS" BORT I BUGEN. HAR DÄRFÖR LAGT IN EN WORKAROUND "+1" PÅ VARIABELN amountCardsUsed 
	// I FOR-LOOPEN. DETTA HÄNDE IDAG EFTER TENTAN OCH JAG KOMMER EJ IHÅG HUR DET VAR INNAN NÄR DET FUNKADE. HAR FRÅGAT ANDRA, GOOGLAT, LÄST I BOKEN
	// M.M. I ÖVER TVÅ TIMMAR NU. KÄNDE ÄNDÅ ATT JAG VILL LÄMNA IN ARBETET ÄN VÄNTA EN MÅNAD.

	private static void addResult(){
		int result = fetchResult();
		int cardQuestion = cardQuestion();
		if(cardQuestion==1){
			int amountCardsUsed = amountOfCardsUsed();
			for(int y = 0; y < amountCardsUsed+1; y++){
				String cardUsed = cardUsed();
				for(int x = 0; x < BIC.size(); x++){
					if (BIC.get(x).getName().equalsIgnoreCase(cardUsed)){
						if(result == 0){
							BIC.get(x).addLoss();
						}
						else if (result == 1){
							BIC.get(x).addTie();
						}
						else{
							BIC.get(x).addWin();
						}
						System.out.println("Win added to " + BIC.get(x).getName());
					}
				}
			}
		}

	}

	//Verktyg för att skapa spelare

	private static void createPlayer(){
		System.out.print("What is the player's name? ");
		String name = keyboard.nextLine();
		int rating = readInt("What is the player's rating? ");		
		System.out.print("Is the player a goalkeeper? (y/n) ");
		String pos = keyboard.next();
		if(pos.equalsIgnoreCase("y")){
			int recovery = readInt("Recovery: ");
			int hands = readInt("Hands: ");
			int reaction = readInt("Reaction: ");
			Goalkeepers newKeeper = new Goalkeepers (name, rating, recovery, hands, reaction);
			players.add(newKeeper);
			breakLine();
			System.out.println("Goalkeeper " + name + " added");
		}else{
			int skate = readInt("Skate: ");
			int pass = readInt("Pass: ");
			int shot = readInt("Shot: ");
			int defend = readInt("Defend: ");
			int stickHandle = readInt("Stick Handle: ");
			Players newPlayer = new Players (name, rating, skate, pass, shot, defend, stickHandle);
			players.add(newPlayer);
			System.out.println("Outfielder " + name + " added");
		}
	}

	//Listar registrerade målvakter

	private static void listKeepers(){
		breakLine();
		if(players.size()==0){
			System.out.print("No players registered.");
			breakLine();
		}else{
			for (int x = 0; x < players.size(); x++){
				if (players.get(x) instanceof Goalkeepers){
					System.out.println(players.get(x));
				}
			}
		}
		breakLine();
	}

	//Listar registrerade utespelare

	private static void listPlayers(){
		breakLine();
		if(players.size()==0){
			System.out.print("No players registered.");
			breakLine();
		}else{
			for (int x = 0; x < players.size(); x++){
				if (players.get(x) instanceof Players){
					System.out.println(players.get(x));
				}
			}
		}
		breakLine();
	}

	//Verktyg för att skapa kort

	private static void createCard(){
		System.out.println("Card Name: ");
		String name = keyboard.nextLine();
		BigImpactCards newCard = new BigImpactCards (name, 0, 0, 0);
		BIC.add(newCard);
		breakLine();
		System.out.println(name + " added succesfully. ");
	}

	//Samma, används till att ladda ett startpaket kort

	private static void createCard(String text){
		String name = text;
		BigImpactCards newCard = new BigImpactCards (name, 0, 0, 0);
		BIC.add(newCard);
		System.out.println(name + " added succesfully. ");

	}

	//Listar samtliga kort i registret

	private static void listCards(){
		breakLine();
		for (int x = 0; x < BIC.size(); x++){
			System.out.println(BIC.get(x));
		}
		if(BIC.size()==0){
			System.out.print("No cards registered.");
		}
		breakLine();
	}

	// Anger vilket kort som har bäst win rate

	private static void listCardsWinRate(){
		breakLine();
		double bestPercent = 0;
		String bestCard = null;
		for (int x = 0; x < BIC.size(); x++){
			if(BIC.get(x).getWinRate()>bestPercent){
				bestPercent=BIC.get(x).getWinRate();
				bestCard=BIC.get(x).getName();
			}
		}
		if(BIC.size()==0){
			System.out.print("No cards registered.");
		}
		System.out.println("Card with highest win rate is " + bestCard + " with a win rate of " + bestPercent + "%.");		
		breakLine();
	}

	// Anger vilket kort som har spelats flest matcher

	private static void listCardsGamesPlayed(){
		breakLine();
		int gamesPlayed = 0;
		String cardMostPlayed = null;
		for (int x = 0; x < BIC.size(); x++){
			if(BIC.get(x).getGamesPlayed()>gamesPlayed){
				gamesPlayed=BIC.get(x).getGamesPlayed();
				cardMostPlayed=BIC.get(x).getName();
			}
		}
		if(BIC.size()==0){
			System.out.print("No cards registered.");
		}
		System.out.println("Card that has been played the most is " + cardMostPlayed + " with " + gamesPlayed + " games played.");		
		breakLine();
	}

	// Laddar ett startpaket med kort till registret

	private static void loadCards(){
		breakLine();
		createCard("Defensive Draws");
		createCard("Offensive Draws");
		createCard("Puck Luck");
		createCard("Recovery");
		createCard("Tape to Tape");
		createCard("Injury Free");
		createCard("Takeaways");
		createCard("Howitzer");
		createCard("Reactor");
		createCard("Puck Magnet");
	}

	//Radbrytare

	private static void breakLine(){
		System.out.println();
	}

	//Berättar för användaren att 0 används för att få fram command list

	private static void options(){
		System.out.println("Type 0 for command list.");
		breakLine();
	}

	// Huvudmenyns alternativ

	private static void commandList(){
		breakLine();
		System.out.println("Type 1 to add result");
		System.out.println("Type 2 to go to the list cards menu");
		System.out.println("Type 3 to load standard cards");
		System.out.println("Type 4 to add a card manually");
		System.out.println("Type 5 to add a player");
		System.out.println("Type 6 to delete a card");
		System.out.println("Type 7 to go to the list players menu");
		System.out.println("Type 9 to exit program");
		breakLine();
	}

	//Kortlistmenyns alternativ

	private static void commandListCards(){
		breakLine();
		System.out.println("Type 1 to list your cards with their stats");
		System.out.println("Type 2 to list the card with the highest winrate");
		System.out.println("Type 3 to list the card that have been played the most");
		System.out.println("Type 4 to list a specific cards statistics");
		System.out.println("Type 5 to go back to the main menu");
		breakLine();
	}

	//Spelarlistmenyns alternativ

	private static void commandListPlayers(){
		System.out.println("Type 1 to list your registered goalkeepers");
		System.out.println("Type 2 to list your registered outfielders");
		System.out.println("Type 3 to go back to the main menu");
	}

	//Verktyg för att ta bort kort

	private static void deleteCard(){
		int cardExists = 0;
		breakLine();
		System.out.println("Name of the card you wish to delete: ");
		String name = keyboard.nextLine();
		for (int x=0; x < BIC.size(); x++){
			if (BIC.get(x).getName().equalsIgnoreCase(name)){
				BIC.remove(x);
				breakLine();
				System.out.println("Card deleted succesfully.");
				cardExists++;
				break;
			}
		}     
		if(cardExists == 0){
			breakLine();
			System.out.println("Card does not exist.");
		}
	}

	// Listar ett enskilt korts statistik

	private static void cardDetails(){
		System.out.println("Which card's statistics do you want to look at? ");
		String name = keyboard.nextLine();
		for (int x=0; x < BIC.size(); x++){
			if (BIC.get(x).getName().equalsIgnoreCase(name)){
				System.out.println(BIC.get(x));
				breakLine();
			}
		}
	}

	//Huvudmenyn

	private static void mainMenu(){
		System.out.print("Main Menu: ");
		String cmd = keyboard.nextLine();
		switch(cmd){
		case("1"):
			addResult();
		break;
		case("2"):
			String lc;
		commandListCards();
		do{
			breakLine();
			System.out.println("Type 0 to see command list");
			breakLine();
			System.out.print("List Cards: ");
			lc = keyboard.nextLine();
			switch(lc){
			case("1"):
				listCards();
			break;
			case("2"):
				listCardsWinRate();
			break;
			case("3"):
				listCardsGamesPlayed();
			break;
			case("4"):
				cardDetails();
			break;
			case("5"):
				breakLine();
			System.out.println("Going back to the main menu.");
			breakLine();
			break;
			case("0"):
				commandListCards();
			break;
			default:
				System.out.println("You can't do that.");
				break;
			}
		}while(!lc.equalsIgnoreCase("5"));
		break;
		case("3"):
			loadCards();
		break;
		case("4"):
			createCard();
		break;		
		case("5"):
			createPlayer();
		break;
		case("6"):
			deleteCard();
		break;
		case("9"):
			breakLine();
		System.out.println("Good bye!");
		System.exit(0);
		case("7"):
			breakLine();
		commandListPlayers();
		breakLine();
		String lp;
		do{
			breakLine();
			System.out.println("Type 0 to see command list");
			breakLine();
			System.out.print("List Players: ");
			lp = keyboard.nextLine();
			switch(lp){
			case("1"):
				listKeepers();
			break;
			case("2"):
				listPlayers();
			break;
			case("3"):
				breakLine();
			System.out.println("Going back to the main menu.");
			breakLine();
			break;
			case("0"):
				commandListPlayers();
			break;
			default:
				breakLine();
				System.out.println("You can't do that.");
				breakLine();
				break;
			}
		}while(!lp.equals("3"));
		case("0"):
			commandList();
		break;
		default:
			System.out.println("You can't do that.");
			break;
		}

	}
}