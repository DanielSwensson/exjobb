import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class RPGTribute {
	
	//statisk ArrayList som alla metoder i denna klass (inklusive main-metoden) kan komma åt.
	//Den kan dock inte nås av andra klasser (då den är private). Skapar en ArrayList bestående av
	//Creature-objekt.
	private static ArrayList<Creature> mobList = new ArrayList<Creature>();
	
	static Scanner keyboard = new Scanner(System.in);
	static Random random = new Random();
	
	//Läser in en fråga som den sedan skriver ut. Användarens input ger userAnswer, som sedan returneras.
	public static String readLine(String question){

		System.out.println(question);
		String userAnswer = keyboard.nextLine();
		return userAnswer;
				
	}
	
	//statiskt metod som först genererar ett tal som används som referens för den attackerande fiende-
	//gruppens storlek. Sedan körs loopen och objekt av antingen subklassen Zombie eller subklassen Warlock. Detta slumpas fram.
	//Sedan returneras en ArrayList (mobList) med 1-3 objekt.
	public static ArrayList<Creature> createMob(){
		
		int randMobSize = random.nextInt(3)+1;
		
		while(mobList.size() < randMobSize){
			int randMobType = random.nextInt(20)+1;
				if(randMobType >= 6 ){
					Zombie zombie = new Zombie(4, 2, 10); //str, def, hp
					mobList.add(zombie);
				}else{
					Warlock warlock = new Warlock(5, 4, 10, 15); //intel, def, hp, mp
					mobList.add(warlock);
			}
		}
		return mobList;
	}
	
	//en statisk metod som tar in ett tal (enemyNr) och använder detta för att hämta
	//ett objekt i ArrayListen. Detta objekt returneras sedan.
	public static Creature targetEnemy(int enemyNr){

			Creature target = mobList.get(enemyNr - 1);
			return target;
				
	}
	
	//en statisk metod som tar in en fråga som sedan skrivs ut. userAnswer sätts till användarens input.
	//Try/catch testar om inputen är en integer. Om inte så fångas denna exception och ett felmeddelande skrivs ut.
	public static int readInt(String question){
		for (;;) {
			try {
				System.out.println(question);
				int userAnswer = Integer.parseInt(keyboard.nextLine()); //gör så att vi slipper använda nextInt()... (inga problem med kvarliggande entertecken)
				return userAnswer;
			} catch (NumberFormatException e) {
				System.out.println("Non-numerical value!");
			}
		}
	}
	
	//en metod som skriver ut en massa stjärnor......... (används som "layout-höjare")
	public static void printRowOfStars(){
		System.out.println("******************");
	}
	
	//main-metoden! Detta är programmet som körs.
	public static void main(String[]args){
		
		//Ett nytt Character-objekt skapas.
		Character player = new Character(readLine("What is thy name, Warrior?"), 3, 3, 3, 50, 5); //name, str, intel, def, hp, mp
		
		//Skriver ut ett meddelande som säger att det inmatade namnet är skumt.
		System.out.println(player.getName() + "? What a strange name for a Warrior like yourself.");
		
		//Skapar ett gäng attacker (med hjälp av klasspecifika konstruktorer).
		Melee heroMelee = new Melee(5);
		Magic heroMagic = new Magic (7, 1);
		Magic warlockMagic = new Magic (10, 5);
		Melee zombieAtt = new Melee(5);
		
		//En loop som körs så länge stopPlaying är false
		boolean stopPlaying = false;
		while (!stopPlaying) {
			
			//Skriver ut att man blir attackerad och kallar på metoden createMob() som fyller på ArrayListen med objekt.
			System.out.println("\nYou are ambushed! Prepare to battle!!!");
			createMob();
		
			//En loop som körs så länge battleEnd är false och spelaren lever.
			boolean battleEnd = false;
			while (!battleEnd && player.isAlive()) {

				//Skriver ut status för spelare och fiender
				printRowOfStars();
				System.out.println(player + "\n\n");
				for (int x = 0; x <= mobList.size() - 1; x++) {
					if (mobList.get(x).isAlive()) {
						System.out
								.println(x + 1 + ". " + mobList.get(x) + "\n");
					}
				}
				printRowOfStars();

				
				//en loop som körs så länge commandInput är false. Detta betyder att frågan ställs så länge input
				//från användaren inte är ett korrekt alternativ.
				boolean commandInput = false;
				int enemyTarget;
				Creature target = null;

				while (!commandInput) {

					//loop som körs så länge validTarget är false. Användaren måste alltså ange
					//ett existerande objekt i ArrayListen.
					boolean validTarget = false;
					while (!validTarget) {

						//tar in frågan, skriver ut den, returnerar svaret.
						enemyTarget = readInt("Choose thee target! (number of order)");

						if (enemyTarget < 1 || enemyTarget > mobList.size()) {
							System.out.println("Invalid target!");
						} else {
							target = targetEnemy(enemyTarget);
							validTarget = true;
						}

					}

					//tar in frågan, skriver ut den, returnerar svaret.
					int command = readInt("How do you wish to strike thee opponent? (1 = melee, 2 = magic (Costs 1MP) )");

					//switch som använder det returnerade värdet från readInt och utför en meleeattack eller en magicattack.
					//Loopen avslutas därmet då användarens input är korrekt. I annat fall skrivs ett felmeddelande ut
					//och man "får börja om från början".
					switch (command) {
					case 1:
						player.racialAtk(target, heroMelee);
						commandInput = true;
						break;
					case 2:
						if (player.enoughMana(heroMagic)) {
							player.racialAtk(target, heroMagic);
							commandInput = true;
							break;
						} else {
							System.out.println("Not enough mana!");
							break;
						}
					default:
						System.out.println("Invalid command!");
						break;
					}
				}

				//går igenom hela ArrayListen och utför den specifika attacken för det objekt som ligger på ett
				//visst indexnummer. Om ett objekt har dött så tas det bort från ArrayListen. Om ArrayListen är tom
				//så avslutas striden.
				for (int x = 0; mobList.size() - 1 >= x; x++) {
					if (mobList.get(x).isAlive()) {
						if (mobList.get(x) instanceof Warlock) {
							mobList.get(x).racialAtk(player, warlockMagic);
						} else {
							mobList.get(x).racialAtk(player, zombieAtt);
						}
					}
					if (!mobList.get(x).isAlive()) {
						mobList.remove(x);
						x--;
					}
					if (mobList.isEmpty()) {
						battleEnd = true;
					}
				}
			}
			//Om spelaren lever och ArrayListen är tom så vinner man!
			if (player.isAlive() && mobList.isEmpty()) {
				System.out.println("You are victorious! :'D ");
			}
			//annars har man dött och har därmed förlorat... Programmet avslutas
			else {
				System.out.println("You have fallen...");
				stopPlaying = true;
			}
			
			//Om man lever efter striden så körs denna loop så länge exitProgram är false, d.v.s. att man anger att man vill 
			//fortsätta spela. Om man väljer att fortsätta så startas en ny strid, annars avslutas programmet (om man inte har
			//angett ett inkorrekt svar).
			
			if(player.isAlive()){
			String answer = readLine("Do you want to continue (Y/N)\n ... or are you a coward?");
				
			boolean exitProgram = false;
				while (!exitProgram) { 
				
					if(answer.equalsIgnoreCase("n")){
						System.out.println("COWARD!!");
						stopPlaying = true;
						exitProgram = true;
					
					}else if(answer.equalsIgnoreCase("y")){
						exitProgram = true;
					
					}else{
						answer = readLine("I don't quite understand you warrior... (Y/N)");
					}
				}
			}
			
		}
		keyboard.close();
	}
}
