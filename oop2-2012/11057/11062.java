
abstract public class Item {

	private String name;


	public Item (String name){
		this.name = name;
	}

	abstract public double returnValue();


	public String toString() {
		return name;
	}

	public String getName() {
		return name;
	}

}

