
public class Pig extends Enemy {
	
	Pig(){
		this.name = "Pig";
		this.power = 2;
		this.health = 60;
	}
	
	public String encounter(){
		return "You stumble across a pig in the woods. It looks mean and oinks at you while scraping the ground with its hoof. \nIt charges at you, attack!";
	}

}
