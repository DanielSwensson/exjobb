package Poppimon;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {

	static Scanner keyboard = new Scanner(System.in);

	int predimonLevel;
	int amountOfPredimonsInWave;
	int chosenPoppimon = 0;
	int campaignWave = 1;
	Player player = new Player();
	int targetToAttack = 0;
	boolean iWantTo;
	boolean useAllPoppimons;
	String answer;
	int setDifficulty;

	static ArrayList<Predimon> predimons = new ArrayList<Predimon>();
	static ArrayList<Poppimon> poppimons = new ArrayList<Poppimon>();

	public Main() {
		setGameDifficulty();
		System.out.println("What would you like to name your poppimon?");
		String name = keyboard.nextLine();
		createPoppimon(name);
		showMenu();
	}

	private void showMenu() {
		while (true) {

			System.out.println("\nWhat would you like to do?\n");
			System.out.println("1.Campaign:");
			System.out.println("2.Arena:");
			System.out.println("3.Stats:");
			System.out.println("4.Buy potions:");
			System.out.println("5.Buy weapon:");
			System.out.println("6.Buy armour:");
			System.out.println("7.Buy poppimon:");
			System.out.println("8.Change poppimon:");
			System.out.println("9.New game:");
			System.out.println("10.Credits:");
			System.out.println("11.Quit:");

			int selection = 0;
			boolean ok;
			do {
				ok = true;
				try {
					String str = keyboard.nextLine();
					selection = Integer.parseInt(str);
				} catch (NumberFormatException e) {
					System.out.println("Input number");
					ok = false;
				}
			} while (!ok);

			switch (selection) {

			case 1:
				for (int i = 0; i < predimons.size(); i++) {
					predimons.remove(i);
				}
				startCampaignCombat();
				break;

			case 2:
				for (int i = 0; i < predimons.size(); i++) {
					predimons.remove(i);
				}
				startArenaCombat();
				break;

			case 3:

				showStats();
				break;

			case 4:

				buyPotion();
				break;

			case 5:

				buyWeapon();
				break;

			case 6:

				listArmourOptions();
				break;

			case 7:

				System.out
						.println("Are you sure you want to buy a new poppimon\n1.Yes:\n2.No:");
				twoChoiceQuestionYesOrNo();
				if (iWantTo) {
					buyPoppimon();
				}
				break;

			case 8:

				changePoppimon();
				break;

			case 9:
				System.out
						.println("Are you sure you want to start a new game?\n1.Yes:\n2.No:");
				twoChoiceQuestionYesOrNo();
				if (iWantTo) {
					newGame();
				}
				break;

			case 10:

				showCredits();
				break;

			case 11:

				System.out
						.println("Are you sure you want to quit?\n1.Yes:\n2.No:");
				twoChoiceQuestionYesOrNo();
				if (iWantTo) {
					quitGame();
				}
				break;

			case 666:

				cheatCode();
				break;

			}
		}
	}

	private void startCombat() {
		while (predimons.size() > 0 && poppimons.size() > 0) {

			if (!useAllPoppimons) {
				if (poppimons.get(chosenPoppimon).getHealth() <= 0) {
					poppimons.remove(chosenPoppimon);
					break;
				}

			}

			if (useAllPoppimons) {
				if (poppimons.size() <= 0) {
					break;
				}

			}

			if (useAllPoppimons) {
				for (int i = 0; i < poppimons.size(); i++) {
					poppimonAttack(i);
				}
			}

			if (!useAllPoppimons) {

				poppimonAttack(chosenPoppimon);

			}

			if (predimons.get(targetToAttack).getHealth() <= 0) {
				player.addGold(predimons.get(targetToAttack).getGold());
				System.out.println("Predimon died, you earned "
						+ predimons.get(targetToAttack).getGold() + " gold \n");

				predimons.remove(targetToAttack);
			}
			predimonAttack();
		}
	}

	private void predimonAttack() {
		if (useAllPoppimons) {

			for (int i = 0; i < predimons.size() && poppimons.size() > 0; i++) {
				predimons.get(i).setTarget(poppimons.get(chosenPoppimon));
				predimons.get(i).attack();
				System.out.print("Predimons attacks, "
						+ poppimons.get(chosenPoppimon).getName() + " has "
						+ poppimons.get(chosenPoppimon).getHealth()
						+ " Hp left\n");

				if (poppimons.get(chosenPoppimon).getHealth() <= 0) {
					System.out.println(poppimons.get(chosenPoppimon).getName()
							+ " died \n");
					poppimons.remove(chosenPoppimon);
				}
			}
			// }

		}
		if (!useAllPoppimons) {

			for (int i = 0; i < predimons.size(); i++) {
				predimons.get(i).setTarget(poppimons.get(chosenPoppimon));
				predimons.get(i).attack();
				System.out.print("Predimons attacks, "
						+ poppimons.get(chosenPoppimon).getName() + " has "
						+ poppimons.get(chosenPoppimon).getHealth()
						+ " Hp left\n");

				if (poppimons.get(chosenPoppimon).getHealth() <= 0) {
					System.out.println(poppimons.get(chosenPoppimon).getName()
							+ " died \n");

					return;
				}
			}
		}
	}

	private void poppimonAttack(int poppimon) {

		int lowestValueFound = predimons.get(0).getHealth();

		for (int i = 0; i < predimons.size(); i++) {

			if (predimons.get(i).getHealth() < lowestValueFound) {
				lowestValueFound = predimons.get(i).getHealth();
				targetToAttack = i;
			}
		}
		poppimons.get(poppimon).setTarget(predimons.get(targetToAttack));

		poppimons.get(poppimon).attack();

		System.out.print(poppimons.get(poppimon).getName()
				+ " attacks, predimon " + "has "
				+ predimons.get(targetToAttack).getHealth() + " Hp left \n");
	}

	private void startCampaignCombat() {

		System.out
				.println("Do you wish to use all your poppimons? \n1.Yes:\n2.No:");
		twoChoiceQuestionYesOrNo();
		useAllPoppimons = iWantTo;

		System.out.println("You are at wave " + campaignWave + " "
				+ ", do you want to continue?\n1.Yes: \n2.No:");
		twoChoiceQuestionYesOrNo();

		if (iWantTo) {
			predimonLevel = campaignWave;
			if (campaignWave < 5) {
				amountOfPredimonsInWave = 1;
			} else {
				amountOfPredimonsInWave = 1 + (campaignWave / 5);
			}
			createPredimon(predimonLevel, amountOfPredimonsInWave);

			startCombat();

			if (poppimons.size() > 0 && predimons.size() <= 0) {
				if (poppimons.get(chosenPoppimon).getHealth() > 0) {
					int currentgold = player.getGold();
					if (campaignWave < 5) {
						player.addGold(campaignWave * 20);
					} else {
						player.addGold((campaignWave * (20 + (campaignWave * (campaignWave / 10)))));
					}
					int newgold = player.getGold();
					int wavebonus = newgold - currentgold;

					System.out.println("Wave clearbonus " + wavebonus
							+ " gold\n");
					campaignWave += 1;
				}
			}
		}
	}

	private void startArenaCombat() {

		System.out
				.println("Do you wish to use all your poppimons? \n1.Yes:\n2.No:");
		twoChoiceQuestionYesOrNo();
		useAllPoppimons = iWantTo;

		System.out.println("What lvl:");

		int level = 0;
		boolean ok;
		do {
			ok = true;
			try {
				String str = keyboard.nextLine();
				level = Integer.parseInt(str);
			} catch (NumberFormatException e) {
				System.out.println("What lvl:");
				ok = false;
			}
		} while (!ok);

		System.out.println("How many predimons would you like to combat?");

		int predimonAmount = 0;
		boolean ok1;
		do {
			ok1 = true;
			try {
				String str = keyboard.nextLine();
				predimonAmount = Integer.parseInt(str);
			} catch (NumberFormatException e) {
				System.out
						.println("How many predimons would you like to combat?");
				ok1 = false;
			}
		} while (!ok1);

		createPredimon(level, predimonAmount);

		startCombat();
	}

	private void showStats() {
		if (poppimons.size() > 0) {
			System.out.println("You have " + player.getGold() + (" gold"));
			System.out.println("Waves completed " + (campaignWave - 1));

			if (poppimons.get(chosenPoppimon).getHealth() > 0) {

				System.out.println(poppimons.get(chosenPoppimon).getName());
				System.out.println(poppimons.get(chosenPoppimon).getHealth()
						+ " HP");
				System.out.println(poppimons.get(chosenPoppimon).getStrength()
						+ " Strength");
				System.out.println(poppimons.get(chosenPoppimon).getDamage()
						+ " Damage");
				System.out.println("uses "
						+ poppimons.get(chosenPoppimon).getOwnedWeaponType());

				System.out.println(poppimons.get(chosenPoppimon).getArmour()
						+ " Armour");
			}
		} else {
			System.out.println("All poppimons are dead");
		}
	}

	private void buyPotion() {
		System.out
				.println("What woudl you like to upgrade?\n1.Strength:\n2.Health");

		twoChoiceQuestionYesOrNo();

		if (iWantTo) {
			System.out.println("How much would you like to upgrade "
					+ poppimons.get(chosenPoppimon).getName()
					+ " strength with?");
			int antalpotions = keyboard.nextInt();
			keyboard.nextLine();
			if ((player.getGold() - (antalpotions * (poppimons.get(
					chosenPoppimon).getStrength() + antalpotions))) >= 0) {
				poppimons.get(chosenPoppimon).addStrength(antalpotions);
				player.addGold(-(antalpotions * poppimons.get(chosenPoppimon)
						.getStrength()));
			}
		}
		if (!iWantTo) {
			System.out.println("How much would you like to upgrade "
					+ poppimons.get(chosenPoppimon).getName() + " Hp with?");
			int antalpotions = keyboard.nextInt();
			keyboard.nextLine();

			if ((player.getGold() - (antalpotions * 2)) >= 0) {
				poppimons.get(chosenPoppimon).addHealth((antalpotions * 3));
				player.addGold(-(antalpotions * 2));
			}
		}
	}

	private void buyWeapon() {

		int swordCost = 100;
		int maceCost = 500;
		int axeCost = 5000;
		int pikeCost = 30000;
		int halberdCost = 100000;

		System.out.println("which weapon(1-5)?");
		System.out.println("1.Sword(" + swordCost + " gold):");
		System.out.println("2.Mace(" + maceCost + " gold):");
		System.out.println("3.Axe(" + axeCost + " gold):");
		System.out.println("4.Pike(" + pikeCost + " gold):");
		System.out.println("5.Halberd" + halberdCost + " gold):");

		int weaponChoice = keyboard.nextInt();
		if (weaponChoice == 1) {
			if (player.getGold() > swordCost) {

				poppimons.get(chosenPoppimon).ownedWeapon = new Sword();
				player.addGold(-swordCost);
			} else {
				System.out.println("You can't afford this weapon");
			}
			keyboard.nextLine();
		}
		if (weaponChoice == 2) {
			if (player.getGold() > maceCost) {

				poppimons.get(chosenPoppimon).ownedWeapon = new Mace();
				player.addGold(-maceCost);
			} else {
				System.out.println("You can't afford this weapon");
			}
			keyboard.nextLine();
		}
		if (weaponChoice == 3) {
			if (player.getGold() > axeCost) {

				poppimons.get(chosenPoppimon).ownedWeapon = new Axe();
				player.addGold(-axeCost);
			} else {
				System.out.println("You can't afford this weapon");
			}
			keyboard.nextLine();
		}
		if (weaponChoice == 4) {
			if (player.getGold() > pikeCost) {

				poppimons.get(chosenPoppimon).ownedWeapon = new Pike();
				player.addGold(-pikeCost);
			} else {
				System.out.println("You can't afford this weapon");
			}
			keyboard.nextLine();
		}
		if (weaponChoice == 5) {
			if (player.getGold() > halberdCost) {

				poppimons.get(chosenPoppimon).ownedWeapon = new Halberd();
				player.addGold(-halberdCost);
			} else {
				System.out.println("You can't afford this weapon");
			}
			keyboard.nextLine();
		}

	}

	private void listArmourOptions() {
		System.out
				.println("What type of armour would you like to buy?\n1.Leather:\n2.Chain:\n3.Plate:");

		int select = keyboard.nextInt();

		if (select == 1) {
			buyLeatherArmour();
			keyboard.nextLine();

		} else if (select == 2) {
			buyChainArmour();
			keyboard.nextLine();

		} else if (select == 3) {
			buyPlateArmour();
			keyboard.nextLine();
		}
	}

	private void buyLeatherArmour() {

		int tier1Price = 50;
		int tier2Price = 200;
		int tier3Price = 800;
		int tier4Price = 5000;
		int tier5Price = 15000;

		System.out.println("which tier (1-5)?");
		System.out.println("tier 1(" + tier1Price + " gold):");
		System.out.println("tier 2(" + tier2Price + " gold):");
		System.out.println("tier 3(" + tier3Price + " gold):");
		System.out.println("tier 4(" + tier4Price + " gold):");
		System.out.println("tier 5(" + tier5Price + " gold):");

		int tier = keyboard.nextInt();

		if (tier == 1) {
			if (player.getGold() > tier1Price) {
				poppimons.get(chosenPoppimon).setArmour(10);
				player.addGold(-tier1Price);
			} else {
				System.out.println("You can't afford this armour");
			}
		}
		if (tier == 2) {
			if (player.getGold() > tier2Price) {
				poppimons.get(chosenPoppimon).setArmour(30);
				player.addGold(-tier2Price);
			} else {
				System.out.println("You can't afford this armour");
			}
		}
		if (tier == 3) {
			if (player.getGold() > tier3Price) {
				poppimons.get(chosenPoppimon).setArmour(190);
				player.addGold(-tier3Price);
			} else {
				System.out.println("You can't afford this armour");
			}
		}
		if (tier == 4) {
			if (player.getGold() > tier4Price) {
				poppimons.get(chosenPoppimon).setArmour(350);
				player.addGold(-tier4Price);
			} else {
				System.out.println("You can't afford this armour");
			}
		}
		if (tier == 5) {
			if (player.getGold() > tier5Price) {
				poppimons.get(chosenPoppimon).setArmour(600);
				player.addGold(-tier5Price);
			} else {
				System.out.println("You can't afford this armour");
			}
		}
	}

	private void buyChainArmour() {

		int tier1Price = 40050;
		int tier2Price = 60500;
		int tier3Price = 100900;
		int tier4Price = 130500;
		int tier5Price = 200500;

		System.out.println("which tier (1-5)?");
		System.out.println("tier 1(" + tier1Price + " gold):");
		System.out.println("tier 2(" + tier2Price + " gold):");
		System.out.println("tier 3(" + tier3Price + " gold):");
		System.out.println("tier 4(" + tier4Price + " gold):");
		System.out.println("tier 5(" + tier5Price + " gold):");

		int tier = keyboard.nextInt();

		if (tier == 1) {
			if (player.getGold() > tier1Price) {
				poppimons.get(chosenPoppimon).setArmour(850);
				player.addGold(-tier1Price);
			} else {
				System.out.println("You can't afford this armour");
			}
		}
		if (tier == 2) {
			if (player.getGold() > tier2Price) {
				poppimons.get(chosenPoppimon).setArmour(1100);
				player.addGold(-tier2Price);
			} else {
				System.out.println("You can't afford this armour");
			}
		}
		if (tier == 3) {
			if (player.getGold() > tier3Price) {
				poppimons.get(chosenPoppimon).setArmour(1500);
				player.addGold(-tier3Price);
			} else {
				System.out.println("You can't afford this armour");
			}
		}
		if (tier == 4) {
			if (player.getGold() > tier4Price) {
				poppimons.get(chosenPoppimon).setArmour(1900);
				player.addGold(-tier4Price);
			} else {
				System.out.println("You can't afford this armour");
			}
		}
		if (tier == 5) {
			if (player.getGold() > tier5Price) {
				poppimons.get(chosenPoppimon).setArmour(2400);
				player.addGold(-tier5Price);
			} else {
				System.out.println("You can't afford this armour");
			}
		}
	}

	private void buyPlateArmour() {

		int tier1Price = 260000;
		int tier2Price = 343000;
		int tier3Price = 450000;
		int tier4Price = 600000;
		int tier5Price = 700500;

		System.out.println("which tier (1-5)?");
		System.out.println("tier 1(" + tier1Price + " gold):");
		System.out.println("tier 2(" + tier2Price + " gold):");
		System.out.println("tier 3(" + tier3Price + " gold):");
		System.out.println("tier 4(" + tier4Price + " gold):");
		System.out.println("tier 5(" + tier5Price + " gold):");

		int tier = keyboard.nextInt();

		if (tier == 1) {
			if (player.getGold() > tier1Price) {
				poppimons.get(chosenPoppimon).setArmour(2900);
				player.addGold(-tier1Price);
			} else {
				System.out.println("You can't afford this armour");
			}
		}
		if (tier == 2) {
			if (player.getGold() > tier2Price) {
				poppimons.get(chosenPoppimon).setArmour(3400);
				player.addGold(-tier2Price);
			} else {
				System.out.println("You can't afford this armour");
			}
		}
		if (tier == 3) {
			if (player.getGold() > tier3Price) {
				poppimons.get(chosenPoppimon).setArmour(4000);
				player.addGold(-tier3Price);
			} else {
				System.out.println("You can't afford this armour");
			}
		}
		if (tier == 4) {
			if (player.getGold() > tier4Price) {
				poppimons.get(chosenPoppimon).setArmour(4700);
				player.addGold(-tier4Price);
			} else {
				System.out.println("You can't afford this armour");
			}
		}
		if (tier == 5) {
			if (player.getGold() > tier5Price) {
				poppimons.get(chosenPoppimon).setArmour(5400);
				player.addGold(-tier5Price);
			} else {
				System.out.println("You can't afford this armour");
			}
		}
	}

	private void buyPoppimon() {
		if (player.getGold() >= (5000 * poppimons.size())) {
			System.out.println("name you new poppimon: ");
			player.addGold(-5000 * poppimons.size());
			createPoppimon(keyboard.nextLine());
		
		} else {
			System.out.println("You can't afford another poppimon");
		}
	}

	private void changePoppimon() {
		for (int i = 0; i < poppimons.size(); i++) {
			if (poppimons.get(i).getHealth() <= 0) {
				poppimons.remove(i);
			}
		}
		if (poppimons.size() <= 0) {
			System.out.println("Buy new poppimon or restart game");
			return;
		} else {
			System.out.println("Choose poppimon: ");
			listAllPoppimons();

			int choice = keyboard.nextInt() - 1;
			chosenPoppimon = choice;
			keyboard.nextLine();
			return;
		}
	}

	private void newGame() {
		for (int i = 0; i < poppimons.size(); i++) {
			poppimons.remove(i);
		}
		for (int i = 0; i < predimons.size(); i++) {
			predimons.remove(i);
		}

		int G = player.getGold();
		player.addGold(-G);

		setGameDifficulty();

		System.out.println("What would you like to name your poppimon?");
		createPoppimon(keyboard.nextLine());

		chosenPoppimon = 0;

		campaignWave = 1;
	}

	private void showCredits() {
		System.out.println("Marcus & Christoffer.");
	}

	private void quitGame() {

		System.exit(0);
	}

	private void listAllPoppimons() {
		for (int i = 0; i < poppimons.size(); i++) {
			System.out.print(i + 1 + ": ");
			System.out.println(poppimons.get(i));

		}
	}

	private void twoChoiceQuestionYesOrNo() {
		answer = keyboard.nextLine().toLowerCase();

		if ("yes".equals(answer) || "1".equals(answer) || "y".equals(answer)) {
			iWantTo = true;
		} else {
			iWantTo = false;
		}
	}

	private void createPredimon(int level, int amount) {
		for (int i = 0; i < amount; i++) {
			Predimon predimon = new Predimon(level);
			predimons.add(predimon);
		}
	}

	private void createPoppimon(String name) {

		Poppimon poppimon = new Poppimon(name);
		poppimons.add(poppimon);

	}

	private void setGameDifficulty() {
		boolean ok;
		do {
			ok = true;
			try {
				System.out
						.println("What Difficulty?(1-4)\n1.Easy\n2.Normal\n3.Hard\n4.Hellish");
				String str = keyboard.nextLine();
				setDifficulty = Integer.parseInt(str);
			} catch (NumberFormatException e) {
				System.out.println("Input number");
				ok = false;
			}
		} while (!ok);

		Unit.setDifficulty(setDifficulty);
	}

	private void cheatCode() {

		String cheat = keyboard.nextLine();
		if ("blessme".equals(cheat)) {
			poppimons.get(chosenPoppimon).addHealth(1000000);
		}
		if ("over9000".equals(cheat)) {
			poppimons.get(chosenPoppimon).addDamageBonus(9000);
		}
		if ("pirate".equals(cheat)) {
			player.addGold(1000000);
		}
		if ("imstronk".equals(cheat)) {
			poppimons.get(chosenPoppimon).ownedWeapon = new Godslayer();
			poppimons.get(chosenPoppimon).addStrength(500);
			poppimons.get(chosenPoppimon).addDamageBonus(100000);
		}
		if ("beefmeup".equals(cheat)) {
			poppimons.get(chosenPoppimon).setArmour(20000);
		}

	}

	public static void main(String[] args) {
		new Main();

	}
}