
public class Player extends Living implements Dangerous {

	private Inventory inventory = new Inventory();
	
	private boolean isArmed;
	
	//Start position
	private int xStartPosition;
	private int yStartPosition;
	
	//Current position
	private int xPosition;
	private int yPosition;
	
	//Previous position
	private int PrevXPosition;
	private int PrevYPosition;
	
	private int amountOfDamage;

	public Player(int healthPoints, int xStartPosition, int yStartPosition) {
		super(healthPoints);
		
		xPosition = xStartPosition;
		yPosition = yStartPosition;
		
		this.xStartPosition = xStartPosition;
		this.yStartPosition = yStartPosition;
		
		isArmed = false;
		
		amountOfDamage = 2;

	}

	public int getX() {
		return xPosition;
	}

	public int getY() {
		return yPosition;
	}
	
	
	public int getPrevX() {
		return PrevXPosition;
	}

	public int getPrevY() {
		return PrevYPosition;
	}
	

	public void setX(int x) {
		xPosition = x;

	}

	public void setY(int y) {
		yPosition = y;

	}
	
	public void setPrevX(int x) {
		PrevXPosition = x;

	}

	public void setPrevY(int y) {
		PrevYPosition = y;

	}
	
	

	public void movePlayer(String direction) {
		savePrevLocation();
		
		switch (direction) {

		case "north":
			yPosition--;
			break;
		case "south":
			yPosition++;
			break;

		case "west":
			xPosition--;
			break;

		case "east":
			xPosition++;
			break;
		default:
			
		}
	}
	public void savePrevLocation(){
		PrevXPosition = xPosition;
		PrevYPosition = yPosition;
	}
	public boolean isArmed() {
		for (int i = 0; i < inventory.size(); i++) {
			if (inventory.getItem(i).getName().equals("sword"))
			return isArmed = true;
		}
		return isArmed = false;

	}
	
	public Inventory getInventory(){
		return inventory;
	}
	
	public int returnDamageDone(){
		if (!(getInventory().getWeapon() == null)){
			return amountOfDamage * getInventory().getWeapon().getMultiplier();
		}
			return amountOfDamage;
	}
	
	public int getXStartPosition(){
		return xStartPosition;
	}
	
	public int getYStartPosition(){
		return yStartPosition;
	}
}
