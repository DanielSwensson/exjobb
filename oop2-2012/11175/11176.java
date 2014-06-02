import java.util.ArrayList;

public class Battle {
	
	private ArrayList<Player> playerArray;
	private ArrayList<Monster> monsterArray;
	
	public Battle(ArrayList<Player> playerArray, ArrayList<Monster> monsterArray){
		this.playerArray = playerArray;
		this.monsterArray = monsterArray;
	}
	public Battle(ArrayList<Player> playerArray){
		this.playerArray = playerArray;
	}
	
	public int totalPlayerPower(){
		int totalPower = 0, playerPower;
		for(Player current : playerArray){
			playerPower = current.getMaxHP() + current.getMaxMana() + ((int) current.calculateDPS());
			totalPower += playerPower;
		}
		return totalPower;
	}	
	public int calcBossLevel(){//räknar ut bosslevel utifrån de medverkande spelarnas lvls
		int numberOfPlayers = 0, bossLevel = 0;
		for(Player current : playerArray){
			++numberOfPlayers;
			bossLevel += (current.getLevel()/90.0)*current.getLevel();
		}
		bossLevel = ((bossLevel/numberOfPlayers)+3);
		
		return bossLevel;
	}
	 public int calcBossPower(){
		 return (calcBossLevel()*10000);
	 }
	public int totalMonsterPower(){
		int totalPower = 0, monsterPower;
		for(Monster current : monsterArray){
			monsterPower = current.getMaxHP() + current.getMaxMana();
			totalPower += monsterPower;
		}
		return totalPower;
	}
	public void calcWinner(int choice){
		if(choice == 1)
			if(totalPlayerPower() >= calcBossPower())
				System.out.println("The boss dies!");
			else
				System.out.println("The boss kills you all!");
		else
			if(totalPlayerPower() >= totalMonsterPower())
				System.out.println(" You win!");
			else
				System.out.println("You die horribly!");
	}
	
}
