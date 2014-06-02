import java.util.Scanner;
import java.util.Random;
public class MonsterEvent extends Event {

	private Monster monster;

	public MonsterEvent(Monster monster) {

		super("You just encountered a " + monster.getName()
				+ " do you want to fight or run?");
		this.monster = monster;

	}

	public Player startEvent(Player player) {
		Scanner input = new Scanner(System.in);

		System.out.println(getDescription());
		while (!monster.isDead()) {

			System.out.print("Enter command(run/fight): ");
			switch(input.nextLine()){
		
			case"fight": 
				if (player.isArmed()) {
					monster.takeDamage(player.returnDamageDone());
					System.out.println("You damaged the " + monster.getName()
							+ " with your sword dealing " + player.returnDamageDone()+ " damage!");
				} else {
					monster.takeDamage(player.returnDamageDone());
					System.out.println("You hit your foe with your fist dealing " + player.returnDamageDone()+ " damage!");
				}
				player.takeDamage(monster.returnDamageDone());
				System.out.println("The " + monster.getName() + " hit you for " + monster.returnDamageDone() + " damage!");
				break;
				
			case "run": 
				Random rand = new Random();

				if(rand.nextInt(100)+1 < 40 ){
				System.out.println("You ran away!\n");
				pause();
				return player;
				}else{
					System.out.println("You failed to run away and the " + monster.getName() +
							" hit you for "+ monster.returnDamageDone()+ " damage!");
					player.takeDamage(monster.returnDamageDone());
					break;
				}
				
			 default: 
				System.out.println("Wrong command");
			}
			
			if(player.isDead()){
				System.out.println("You died. Game over");
				System.exit(1);
			}

		}
		System.out.println("You slayed the " + monster.getName()
				+ " in cold blood!");
		setIsCompleted(true);
		pause();
		return player;
		}
	}


