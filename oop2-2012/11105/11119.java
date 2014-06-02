
public class Monster extends Living implements Dangerous {

	private String name;
	private int amountOfDamage;

	public Monster(String name, int healthPoints, int amountOfDamage) {
		super(healthPoints);
		this.name = name;
		this.amountOfDamage = amountOfDamage;
	}

	public int returnDamageDone(){
		return amountOfDamage;
	}	
	
	public String getName() {
		return name;
	}

}
