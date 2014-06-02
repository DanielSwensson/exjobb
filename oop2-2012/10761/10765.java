
public class Device extends Valuable {
	private int wear,worth;
	public Device() {
		this.name=Register.promptString("Please enter a description of the device", "name: ");
		this.worth=Register.promptInt("Please enter the original value of the item", "value: ");

		this.wear=Register.promptInt("Please enter the condition of the item from worst 0 to best 10", "value: ");
		
		while(wear > 10 || wear < 0) {
			this.wear=Register.promptInt("Invalid ammount of wear entered, must be a value from 0 to 10", "value: ");
		}	
	}

	public Device(String name, int worth, int wear) {
		if(wear > 10 || wear < 0) {
			throw new IllegalArgumentException("Wear has to be between 0 and 10");
		}
		this.name=name;
		this.worth=worth;
		this.wear=wear;
	}
	
	public int getValue() {
		return (wear*worth)/10;
	}

	public String toString() {
		return String.format(listFormat," Device:",this.name, this.getValue());
	}

	@Override
	public void crash() {
		// TODO Auto-generated method stub

	}

}
