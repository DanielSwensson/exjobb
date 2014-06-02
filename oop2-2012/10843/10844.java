
public class AddItem {
	private ReadInput ri = new ReadInput();
	
	public void createItem(Character c){
		String name = ri.readString("Enter the name of the Item: ");
		Item newItem = new Item(name);
		c.addItem(newItem);
	}
	// Weapons:
	
	public void createAxe(Character c){
	String name = ri.readString("Enter the name of the axe: ");
	int damage = ri.readInt("Enter the damage of the axe: ");
	Axe newWeapon = new Axe(name, damage);
	c.addItem(newWeapon);
	}
	
	public void createMace(Character c){
		String name = ri.readString("Enter the name of the mace: ");
		int damage = ri.readInt("Enter the damage of the mace: ");
		Mace newWeapon = new Mace(name, damage);
		c.addItem(newWeapon);
	}
	
	public void createSword(Character c){
		String name = ri.readString("Enter the name of the sword: ");
		int damage = ri.readInt("Enter the damage of the sword: ");
		Sword newWeapon = new Sword(name, damage);
		c.addItem(newWeapon);
	}
	
	// Armors:
	
	public void createHeadArmor(Character c){
		String name = ri.readString("Enter the name of the helmet: ");
		int defense = ri.readInt("Enter the defense of the helmet: ");
		HeadArmor newArmor = new HeadArmor(name, defense);
		c.addItem(newArmor);
	}
	
	public void createChestArmor(Character c){
		String name = ri.readString("Enter the name of the chest armor: ");
		int defense = ri.readInt("Enter the defense of the chest armor: ");
		ChestArmor newArmor = new ChestArmor(name, defense);
		c.addItem(newArmor);
	}
	
	public void createLegArmor(Character c){
		String name = ri.readString("Enter the name of the leg armor: ");
		int defense = ri.readInt("Enter the defense of the leg armor: ");
		LegArmor newArmor = new LegArmor(name, defense);
		c.addItem(newArmor);
	}
	
	public void createShield(Character c){
		String name = ri.readString("Enter the name of the shield: ");
		int defense = ri.readInt("Enter the defense of the shield: ");
		int blockValue = ri.readInt("Enter the block value of the shield: ");
		Shield newArmor = new Shield(name, defense, blockValue);
		c.addItem(newArmor);
	}
}
