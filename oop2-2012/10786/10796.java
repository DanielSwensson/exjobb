
public abstract class Exercise {

	private String name;
	private String equipment;
	private int amount;
	
	public Exercise(String name, String equipment, int amount){
		this.name = name;
		this.equipment = equipment;
		this.setAmount(amount);
	}
	
	public Exercise(String name, String equipment){
		this.name = name;
		this.equipment = equipment;
	}
	
	public Exercise(String name, int amount){
		this.name = name;
		this.setAmount(amount);
	}
	
	public Exercise(String name){
		this.name = name;
	}
	
	public String getEquipment() {
		return equipment;
	}
	
	public void setEquipment(String equipment) {
		this.equipment = equipment;
	}
	
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String toString(){
		return getAmount() + "st " + getName() + " med " + getEquipment();
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

}


