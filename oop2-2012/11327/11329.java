public class Goalkeepers extends HockeyPlayers {
	private int recovery;
	private int hands;
	private int reaction;
	public Goalkeepers(String name, int rating, int rec, int hands, int react){
		super(name, rating);
		this.recovery = rec;
		this.hands = hands;
		this.reaction = react;
	}
	public String toString(){
		return "Name: " + name + " Rating: " + rating + " Recovery: " + recovery + " Hands: " + hands + " Reaction: " + reaction;
	}
}
