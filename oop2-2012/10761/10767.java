
public class Stock extends Valuable {
	private int ammount,value;
	public Stock() {
		super();
		this.name=Register.promptString("Please enter the name of the stock", "name: ");
		this.value=Register.promptInt("Please enter the value of each stock", "value: ");
		this.ammount=Register.promptInt("Please enter the ammount of stocks", "ammount: ") ;
	}
	
	public Stock(String name, int ammount, int value) {
		super();
		this.name=name;
		this.ammount=ammount;
		this.value=value;
	}
	
	public int getValue() {
		return value*ammount;
	}

	public String toString() {
		return String.format(listFormat,"Stock:",this.name, this.getValue());
	}

	public void crash() {
		this.value=0;
	}

}
