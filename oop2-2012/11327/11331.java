public class Players extends HockeyPlayers{
	private int skate;
	private int pass;
	private int shot;
	private int defend;
	private int stickHandle;
	public Players(String name, int rating, int skate, int pass, int shot, int def, int stick){
		super(name, rating);
		this.skate = skate;
		this.pass = pass;
		this.shot = shot;
		this.defend = def;
		this.stickHandle = stick;
	}
	public String toString(){
		return "Name: " + name + " Rating: " + rating + " Skate: " + skate + " Pass: " + pass + " Shot: " + shot + " Defend: " + defend + " Stick Handle: " + stickHandle;
	}
}
