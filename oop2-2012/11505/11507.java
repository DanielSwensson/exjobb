package HABLO2;

import java.util.Scanner;
import java.util.Random;

public class Hablo2 {

	static Random rnd = new Random();
	static Scanner keyboard = new Scanner(System.in);

	static String menu(String message) {//metod som skriver ut menyerna och returnerar användarens val.

		
		System.out.println("\nWhat would you like to do?? \n" + message);

		return keyboard.nextLine();
	}

	static void sleep() {		//metod för att få spelet att inte printa omedelbart
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	static void sleeper() {//lika som sleep fast längre
		try {
			Thread.sleep(1200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	static Monster rndMonster() {//genererar ett monster av slumpmässig typ samt loot
		int rndNr = rnd.nextInt(40);
		int rndLvl = rnd.nextInt(3) + 1;
		int rndLoot = rnd.nextInt(10);
		
		Monster tempMonster;

		if (rndNr == 39)
			tempMonster = new Leprecon(rndLvl, rndLoot);
		else if (rndNr > 34)
			tempMonster = new Hydra(rndLvl, rndLoot);
		else if (rndNr > 15)
			tempMonster = new Wildboar(rndLvl, rndLoot);
		else{
			tempMonster = null;
			System.out.println("You didn't find anything... newb");
		}
			

		return tempMonster;
	}

	static void dealDmg(Unit attacker, Unit defender, boolean fleeing) {//gör skada på båda de som slåss
		attacker.attack(defender);
		sleep();

		if (defender.getCurrentHp() > 0 && !fleeing) {
			defender.attack(attacker);
			sleep();
		}

	}

	static void fight(Player player, int attacker, Monster monster) {//upprepade attacker tills någon dör eller spelaren flyr.

		boolean fleeing = false;
		String toDo;
		boolean flee = false;
		toDo = menu("1. Attack\n2. Try to escape!");
		if (toDo.equals("2")) {
			flee = player.flee(monster);
			
			if (flee)
				System.out.println("You managed to escape!");
			else {
				System.out.println("Your escape failed!");
				fleeing = true;
			}
			
		}

		boolean dead = false;

		while (!flee && !dead) {

			if (!fleeing) {
				if (attacker == 1) {// hunt
					if (player.firstBlood(monster)) {
						dealDmg(player, monster, fleeing);
					} else {
						dealDmg(monster, player, fleeing);
					}
				} else {// berries
					if (monster.firstBlood(player)) {
						dealDmg(monster, player, fleeing);
					} else {
						dealDmg(player, monster, fleeing);
					}
				}
			} else {
				dealDmg(monster, player, fleeing);
				fleeing = false;
			}

			if (player.getCurrentHp() < 1) {
				dead = true;
				System.out.println("Oh dear, you died...!");
				System.exit(0);
			} else if (monster.getCurrentHp() < 1) {
				monster.dead();
				
				dead = true;

				player.changeGold(monster.getGold());
				player.changeCurrentExp(monster.getExpOnKill());

				player.lvlUp();
			}

			if (!dead) {
				toDo = menu("1. Attack\n2. Try to escape!");
				if (toDo.equals("2")) {

					flee = player.flee(monster);
					if (flee)
						System.out.println("You managed to escape!");
					else {
						System.out.println("Your escape failed!");
						fleeing = true;
					}
				}
			}

		}
	}

	static void forest(Player player) {//menyn för skogen.

		String toDo = menu("1. Hunt\n2. Serch for berries.\n3. Go back to the village.");

		while (!toDo.equals("3")) {
			sleeper();
			

			switch (toDo) {
			case "1":
				Monster monster = rndMonster();
				if (monster != null) {
					System.out.println("You found a " + monster.getType()
							+ "!!!");
					fight(player, 1, monster);
				}
				break;
			case "2":
				
				int nr = rnd.nextInt(5);
				if (nr > 2) {
					player.changeCurrentHp(5);
					System.out.println("You found a bunch of barries, you atomaticaly ate them and gained 5 health!\nYou'r current hp is now: " + player.getCurrentHp());
				} else if (nr == 0) {
					monster = rndMonster();
					if (monster != null) {
						System.out.println("You got ambushed by an angry "
								+ monster.getType() + "!!!");
						fight(player, 0, monster);
					}
				} else {
					System.out.println("You can't find any berries!");
				}
				break;
			default:
				System.out.println("Didn't understand that shit...");
				break;
			}

			toDo = menu("1. Hunt\n2. Serch for berries.\n3. Go back to the village.");

		}
		System.out.println("You'r back in the village.");
		sleep();
	}

	static String introduction() {//metod för att slippa massa utskrift i main samt returnerar spelarens valda namn.
		sleep();

		System.out.println("Welcome to Hablo2 - The serch for the leprecon.");

		sleeper();

		System.out.println("What's your name fellow?");
		String playerName = keyboard.nextLine();

		sleep();

		System.out.println("Ok " + playerName
				+ ", You are in a little village and its a beutiful day!");
		sleeper();
		sleep();

		return playerName;

	}

	static void tavern(Player player) {//meny för tavärnan

		String toDo = menu("1. Order a beer! - 20g\n2. Order a plate of pasta! - 30g\n3. Rent a room. - 10g\n4. Walk over to the mysterious man in the corner. \n5. Leave the tavern.");

		while (!toDo.equals("5")) {

			switch (toDo) {

			case "1":
				if (player.getGold() > 19) {
					player.changeGold(20);
					player.changeCurrentHp(20);
					sleep();
					System.out.println("You drink the beer and feel mighty refreshed!\nYou gained 20 hp!\nYour current health is: "+ player.getCurrentHp());
				} else {
					System.out.println("Not enough gold!");
				}
				break;
			case "2":
				if (player.getGold() > 29) {
					player.changeGold(30);
					player.changeCurrentHp(50);
					sleep();
					System.out.println("You eat the tasty pasta and feel mighty!\nYou gained 50 hp!\nYour current health is: "+ player.getCurrentHp());
				}else {
					System.out.println("Not enough gold!");
				}
				break;

			case "3":
				if (player.getGold() > 9) {
					player.changeGold(10);
					player.setCurrentHp(player.getMaxHp());
					sleeper();
					System.out.print("You go to your room and lay down in the bed\nYou fall asleep...");

					for (int i = 0; i < 10; i++) {
						sleeper();
						System.out.print(".");
					}
					System.out.println("\nYou wake up and feel super! \nYour current health is: "+player.getCurrentHp());
				}else {
					System.out.println("Not enough gold!");
				}
				break;
			case "4":
				sleep();
				System.out.println("Greetings traveler, i'v got a quest for you if you think you can handle it.\nI need you to kill the dragon who stole my tresure whom gives endless happines and joy!\nIf you help me deafet it I will share that tresure with you.\nYou will need the battle-axe of doom to crush the scales of the mighty black dragon.\nDo you accept the quest?(yes/no)");
				String answer = keyboard.nextLine();
				if(answer.equals("Yes") || answer.equals("yes")) {
					System.out.println("You are  either brave or dumb, follow me!\nYou follow the man out of the village through the forest into a big cave.\nWhen you've walked for ten minutes in the cave the dragon appears, \nit's a mighty black dragon eight meters tall and it's fire breath lights up the dark cave. It charges you!");
					Monster blackDragon = new BlackDragon(1, 1);
					fight(player, 1, blackDragon);
				}else if(answer.equals("No") || answer.equals("no")){
					System.out.println("Ok, please get stronger and braver, then come back.");
				}else{
					System.out.println("I don't know what you're saying, please leave me alone!");
				}
				break;
				
			default: 
				System.out.println("Dem shits make no sense.");

			}
			
			toDo = menu("1. Order a beer! - 20g\n2. Order a plate of pasta! - 30g\n3. Rent a room. - 10g\n4. Walk over to the mysterious man in the corner. \n5. Leave the tavern.");
		}
		System.out.println("You leave the tavern and find yourself back in the middle of the village!");
		sleep();
	}

	static void shop(Player player){//meny för shopen
		String toDo = menu("1. Buy the shiny steel sword + 3dmg - 45g. \n2. Buy the wooden shield + 2def - 80g\n3. Buy the big steel square-shield + 7def - 200g\n4. Buy the crossbow + 7dmg - 120g\n5. Buy the diamond battle-axe of doom + 20 dmg - 500g\n6. Leave the shop.");

		Item sword = new Item(45, 3);
		Item woodenShield = new Item(80, 2);
		Item crossBow = new Item(120, 7);
		Item sqShield = new Item(200, 7);
		Item battleAxeOfDoom = new Item(500, 20);
		while (!toDo.equals("6")) {
			switch (toDo){
			
			case "1":
				if(player.getGold()>=sword.getPrice()){
					
					player.changeDmgItem(sword);
					player.changeGold(-sword.getPrice());
					System.out.println("You have just bought the shiny steel sword!");
				}else{
					System.out.println("You do not have enough gold to buy that item, GET LOST!");
				}
				break;
			case "2":
				if(player.getGold()>=woodenShield.getPrice()){
					player.changeDefItem(woodenShield);
					player.changeGold(-woodenShield.getPrice());
					System.out.println("You have just bought the wooden shield!");
				}else{
					System.out.println("You do not have enough gold to buy that item!");
				}
				break;
			case "3":
				if(player.getGold()>=sqShield.getPrice()){
					player.changeDefItem(sqShield);
					player.changeGold(-sqShield.getPrice());
					System.out.println("You have just bought the big square-shild!");
				}else{
					System.out.println("You do not have enough gold to buy that item.");
				}
				break;
			case "4":
				if(player.getGold()>=crossBow.getPrice()){
					player.changeDmgItem(crossBow);
					player.changeGold(-crossBow.getPrice());
					System.out.println("You have just bought the crossbow!");
				}else{
					System.out.println("You do not have enough gold to buy that item.");
				}
				break;
			case "5":
				if(player.getGold()>=battleAxeOfDoom.getPrice()){
					player.changeDmgItem(battleAxeOfDoom);
					player.changeGold(-battleAxeOfDoom.getPrice());
					System.out.println("You have just bought the diamond battle-axe of doom!!!!!!");
				}else{
					System.out.println("You do not have enough gold to buy that item...");
				}
				break;
				
			default:
				System.out.println("What did you say?");
			}
			toDo = menu("1. Buy the shiny steel sword + 3dmg - 45g. \n2. Buy the wooden shield + 2def - 80g\n3. Buy the big steel square-shield + 7def - 200g\n4. Buy the crossbow + 7dmg - 120g\n5.Buy the diamond battle-axe of doom + 20 dmg - 500g\n6. Leave the shop.");
			
		}
		
		System.out.println("You leave the tavern and find yourself back in the middle of the village!");
	}
	
	public static void main(String[] args) {
		String toDo;
		Player player = new Player(introduction());
		toDo = menu("1. Go to the forest. \n2. Go to the tavern.\n3. Go to the shop.\n4. Exit the village and take ur life! <:)");

		while (!toDo.equals("4")) {

			switch (toDo) {
			case "1":
				sleeper();
				System.out.println("You are now in ze forest!");
				forest(player);
				break;
			case "2":
				sleeper();
				System.out.println("You arrived in the tavern!\nYou check your pockets and you currently have "+player.getGold()+" gold.");
				tavern(player);

				break;
			case "3":
				sleeper();
				System.out.println("You enter the shop.\nYou check your pockets and you find "+player.getGold()+" gold.");
				shop(player);

				break;
			default:
				System.out.println("Didn't understand that shit...");
				break;
			}

			toDo = menu("1. Go to the forest. \n2. Go to the tavern.\n3. Go to the shop.\n4. Exit the village and take ur life! <:)");

		}
		System.out.println("The game is ending now!!!");
		sleeper();
		System.out.println("LEAVERRRRRRRRRRRRRRRRRRRR!!!!!!!!!!!!!!!!!!!!");
		System.exit(0);
	}
}