
abstract class Item {
	
	private String name;
	
	Item(String name) {
		this.name = name;
	}
	
	public double getValue() {
		return 0;
	}
	
	public String toString() {
		return name+"\t"+getValue()+" kr.";
	}
	
	public void stockExchangeCrash() {
		
	}
	
}
