
public class Dragon extends Enemy {

	Dragon(){
		this.name = "Dragon";
		this.power = 5;
		this.health = 200;
	}
	
	public String encounter(){
		return "You hear a roar from above, like thunder in the sky. You look up and see a fierce dragon soaring above the treetops. \nThe dragon charges at you!";		
	}
}
