import java.util.*;

public class MainGame {
	
	static Scanner keyboard = new Scanner(System.in);
	
	public static void main(String[] args){
		
		System.out.print("Welcome to the world of Pigs and Dragons!\nPlease choose the name of your Hero: ");
		String name = keyboard.nextLine();
		
		Hero hero1 = new Hero(name);
		
		System.out.println(hero1.getStatus());
		System.out.println("You will now embark on your big adventure!\nPress 's' if you want to see your Hero's stats, press 't' if you want to" +
				" go treasure hunting, or press 'f' if you want to go out and fight the horrible monsters of this world!\nMake you choice now " + hero1.getName()+"!");
		
		for (;;){
			
			Random generator = new Random();
			String command = keyboard.nextLine();
			switch (command){
				case "s":
					System.out.println(hero1.getStatus());
					hero1.printTreasures();
					break;
				case "t":

					int g = generator.nextInt(9);
								
					if (g <= 4){
						GoldTreasure t = new Coin();
						hero1.setPoints(t.getCoin());
						hero1.collectedTreasures(t);
						System.out.println("You find a coin on the ground, it is worth " + t.getCoin() + " points.");
					}
					else if (g > 4 && g <= 7){
						GoldTreasure t = new PileOfCoins();
						hero1.setPoints(t.getPile());
						hero1.collectedTreasures(t);
						System.out.println("You dig a hole in the ground by a tree and find a pile of coins worth " + t.getPile() + " points.");
					}
					else{
						HealthPotion t = new HealthPotion();
						hero1.setHealth(t.getPotion());
						hero1.collectedTreasures(t);
						System.out.println("You find a Potion of Health in the bushes, is restores your health by " + t.getPotion() + ".");
						if (hero1.getHealth() > hero1.getMaxhealth()){
							hero1.setHealthOverflow();
						}
					}
					
					break;
				case "f":
					//Gör strider mer interaktiva med hjälp av samverkande klasser.
					int m = generator.nextInt(9);
					if (m <= 7){
						Enemy monster = new Pig();
						System.out.println(monster.encounter());
						System.out.println();
						System.out.println("You take out you sword and swings it at the beast!");
						while (monster.getHealth() > 0 && hero1.getHealth() > 0){
							monster.getHit(hero1.hitEnemy());
							hero1.getHit(monster.hitHero());
						}
						if (hero1.getHealth() <= 0){
							System.out.println("The pig rips you open with its tusks, and you fall dead to the ground.");
							System.out.println();
							System.out.println("Game Over");
							System.exit(0);
						}
						else{
							System.out.println();
							System.out.println("You strike down the beast with a blow to its head. The pig lets out a snort and dies on the ground before you.");
							System.out.println("You gain 100 points for killing the pig and you find i little vial of healthpotion at its side, restoring your health by 50.");
							hero1.setPoints(100);
							hero1.setHealth(50);
							if (hero1.getHealth() > hero1.getMaxhealth()){
								hero1.setHealthOverflow();
							}
						}
					}
					else{
						Enemy monster = new Dragon();
						System.out.println(monster.encounter());
						System.out.println();
						System.out.println("You prepare for a hard battle. You raise your sword at the dragon as you feel its fiery breath heat the forest.");
						System.out.println();
						while (monster.getHealth() > 0 && hero1.getHealth() > 0){
							monster.getHit(hero1.hitEnemy());
							hero1.getHit(monster.hitHero());
						}
						if (hero1.getHealth() <= 0){
							System.out.println("The dragon scorches you with fire, and while you're still blinded, the dragon picks you up and swallows you in one bite.");
							System.out.println("Now the last hero of this world is gone, and the dragon continues to terrorize the villages of the land.");
							System.out.println();
							System.out.println("Game Over");
							System.exit(0);
						}
						else{
							System.out.println("You battle with the dragon for what seems like ages, when you with your last breath, drill your sword right into the dragon's burning iron heart.");
							System.out.println("You have vanquished the fearsome dragon and will be celebrated around the land for your bravery!");
							System.out.println("You gain 500 points for killing the dragon, and as you search the corpse you find a Potion of Health underneath its wing.");
							hero1.setPoints(500);
							HealthPotion t = new HealthPotion();
							hero1.setHealth(t.getPotion());
						}
					}
					
					
					break;
				default:
					System.out.println("Invalid command.");
					break;	
			}//Switch
			
			if (hero1.getPoints() > 500){
				hero1.setMaxhealth(50);
				hero1.setPower(1);
				hero1.setPointsToZero();
				System.out.println("You have gained 1 powerpoint and increased your maximum health by 50!");
			}
			System.out.println();
			System.out.println("Press 's' for stats, 't' for a treasure hunt and 'f' to fight a monster.");
		}//For
	}//Main
}//Class
