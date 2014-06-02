
import java.util.*;

public class HeadProgram {

	private Scanner keyboard = new Scanner(System.in);
	private static ArrayList<Player> playerList = new ArrayList<Player>();
	private static ArrayList<Monster> monsterList = new ArrayList<Monster>();
	private static final String[][] classAndSpecs = {{"mage", "Fire"}, {"mage", "Arcane"}, {"warrior", "Arms"}, {"warrior", "Fury"}, {"hunter", "Survival"}, {"hunter", "Beastmastery"}, {"druid", "Balance"}, {"druid", "Feral"}};

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);
		HeadProgram hp = new HeadProgram();

		while(true) {
			
			System.out.println(
					"**********************************************************************\n"+
					"1. Create player 2. Create Monster 3. Show characters 4. Battle 5. Exit" +
					"\n**********************************************************************");
			int function = hp.readInt("Enter a number between 1 and 5 to choose a function: ", 0, 100);

			switch (function) {
			case 1: // Player creation
				String tempName, name=null;
				do{
					tempName = hp.readString("Enter name: ");
					if(playerList.isEmpty())
						name = tempName;
					else {
						for(Player current : playerList){
							if(tempName.equalsIgnoreCase(current.getName())){
								System.out.println("Player already exists");
							}
							else
								name = tempName;
						}
					}
				}while(name==null);
				
				int level = hp.readInt("Enter a level between 1 and 90: ", 1, 90);
				System.out.println("Orc / Tauren / Human / Dwarf.");
				String race;
				Race playerRace = null;
				do{
					race = hp.readString("Choose one of the races above: ");
					if(race.equalsIgnoreCase("Orc") || race.equalsIgnoreCase("Tauren")){
						playerRace = new Race(race, "Horde");
					}
					else if(race.equalsIgnoreCase("Human") || race.equalsIgnoreCase("Dwarf")){
						playerRace = new Race(race, "Alliance");
					}
					else
						System.out.println("Invalid race. Try again Try again by entering one of the races listed above, for example 'Human'");
					
				}while(playerRace==null);
				
				System.out.println("Warrior / Hunter / Mage / Druid.");
				String charClass;
				PlayerClass playerClass = null;
				do{
					charClass = hp.readString("Choose one of the classes above: ");
					if(charClass.equalsIgnoreCase("Warrior") || charClass.equalsIgnoreCase("Hunter") || charClass.equalsIgnoreCase("Mage") || charClass.equalsIgnoreCase("Druid")){
						playerClass = new PlayerClass(charClass);
					}
					else
						System.out.println("Invalid class. Try again Try again by entering one of the classes listed above, for example 'Mage'");
					
				}while(playerClass==null);
				
				hp.listSpecs(charClass);
				Spec playerSpec = null;
				do{
					String specChoice = hp.readString("Choose one of the specializations above: ");
					if(specChoice.equalsIgnoreCase(classAndSpecs[hp.getSpecName(charClass)][1]) || specChoice.equalsIgnoreCase(classAndSpecs[hp.getSpecName(charClass)+1][1])){
						playerSpec = new Spec(specChoice);
					}
					else
						System.out.println("Invalid specializations. Try again by entering one of the specializations listed above, for example 'Orc'.");
				}while(playerSpec==null);
				
				playerList.add(new Player(name, level, playerRace, playerClass, playerSpec));
				System.out.println("A " + race + " " + charClass + " called " + name + " was successfully created.");
				break;

			case 2: // Monster creation
				
				boolean done = false;
				String monsterType;
				String monsterName = hp.readString("Enter monster name: ");
				int monsterLevel = hp.readInt("Enter monster level between 1 and 90: ", 1, 90);
				
				do{
					monsterType = hp.readString("Elite- or normal monster?: ");
					
					if (monsterType.equalsIgnoreCase("Elite")) {
						monsterList.add(new EliteMob(monsterName, monsterLevel));
						System.out.println("Elite monster " + monsterName + " created.");
						done = true;
					} 
					else if(monsterType.equalsIgnoreCase("Normal")) {
						monsterList.add(new Mob(monsterName, monsterLevel));
						System.out.println("Monster " + monsterName + " created.");
						done = true;
					}
					else {
						System.out.println("Invalid input. Type 'elite' och 'normal'.");
					}
				}while(!done);
				
				break;

			case 3: // Character list
				System.out.println("\n***Players: ");
				listAll(playerList);
				System.out.println("\n***Mobs: ");
				listAll(monsterList);
				
				break;
			case 4: // Battle
				ArrayList<Player> chosenPlayers = new ArrayList<Player>();
				ArrayList<Monster> chosenMonsters = new ArrayList<Monster>();
				boolean found = false;
				done = false;
				int choice;
				
				if(playerList.isEmpty()) {
					System.out.println("You must create a player before going to battle.");
					break;
				}
				else {
					listAll(playerList);
					do{ //add player
						choice = hp.readInt("\n1. Add player to battle 2. Continue: ", 1, 2);
						if(choice == 1){
							String chosenPlayer = hp.readString("Enter player name: ");
							for(Player current : playerList){
								if(chosenPlayer.equalsIgnoreCase(current.getName())) {
									found = chosenPlayers.add(current);
									System.out.println("Player " + current.getName() + " added.");
								}
							}
							if(!found){
								System.out.println("Player not found. Check your spelling and try again. To list all players available, choose option 3 in the main menu.");
							}
							
						} else {
							if(!found)
								System.out.println("Add at least one player.");
							else
								done = true;
						}
					}while(!done);
					
					do{ //add monster
						choice = hp.readInt("1. Add monsters to battle (optional) 2. Continue: " +
												"\n Note: choosing '2' without adding monsters will still allow for boss-fights.", 1, 2);
						found = false;
						if(choice == 1){
							String chosenMonster = hp.readString("Enter monster name: ");
							for (Monster current : monsterList){
								if(chosenMonster.equalsIgnoreCase(current.getName())) {
									found = chosenMonsters.add(current);
									System.out.println("Monster " + current.getName() + " added.");
								}
							}
							if(!found){
								System.out.println("Monster not found. Check your spelling and try again. To list all mobs available, choose option 3 in the main menu.");
							}
							
						} else {
							found = true;
						}
					}while(!found);
					
					Battle battle1 = new Battle(chosenPlayers, chosenMonsters);
					if(chosenMonsters.isEmpty())
						choice = hp.readInt("1. Test player characters vs Boss.\n",1,1);
					else
						choice = hp.readInt("1. Test players vs Boss  2. vs Mobs.\n",1,2);
					
					battle1.calcWinner(choice);
					
					break;
				}
			case 5: // exit
				System.out.println("Program terminated. Have a nice day.");
				keyboard.close();
				System.exit(0);

			default:
				System.out.println("Invalid input. Enter a value between 1 and 5 or go to http://people.dsv.su.se/~mafo6556/new%20%202.html for help.");
			}
		}
	}

	public int readInt(String question, int rangeMin, int rangeMax) {
		for(;;) {
			try {
				System.out.print(question);
				int answer =Integer.parseInt(keyboard.nextLine());
				if (answer >= rangeMin && answer <= rangeMax)
					return answer;
				else {
					System.out.println("Input out of range.");
				}
			} catch (NumberFormatException e) {
				System.out.println("Error - Use numerical values only.");
			}
		}
	}

	public String readString(String question) {
		while(true) {
			System.out.print(question);
			String answer = keyboard.nextLine();
			if(!answer.equals(""))
				return answer;
			else
				System.out.println("");
		}
	}
	@SuppressWarnings("rawtypes")
	public static void listAll(ArrayList arr) {
		for(Object current : arr){
			System.out.println(current.toString());
		}
	}
	public void listSpecs(String charClass){
		Spec playerSpec = new Spec();
		for(int i = 0; i < classAndSpecs.length ; i++){
			if(charClass.equalsIgnoreCase(classAndSpecs[i][0])){
				System.out.println(classAndSpecs[i][1] + " " + "Maximum dps: " + playerSpec.getDpsConstant(i));
			}
		}
	}
	public int getSpecName(String charClass){
		for(int i = 0; i < classAndSpecs.length ; i++){
			if(charClass.equalsIgnoreCase(classAndSpecs[i][0])){
				return i;
			}
		}
		return -1;
	}

}
