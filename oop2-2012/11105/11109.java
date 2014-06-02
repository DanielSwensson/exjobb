
public class EndGameEvent extends Event {
	
	public EndGameEvent(){
		super("End description");
	}
	
	public Player startEvent(Player player){
		System.out.println("You suddenly feel relaxed, as if a thousand pounds have\n" +
				"been lifted of your shoulders. You lie down. A beautiful rabbit approaches and\n" +
				"starts jumping on your back with his soft paws. You pass out. Your contract is now\n" +
				"sealed, and you will for all eternity be a proud owner of this mansion. ");
		System.out.println("\n----------CONGRATULATIONS, YOU FINNISHED THE GAME!----------");
		System.exit(1);
		return player;
	}
	
	

}
