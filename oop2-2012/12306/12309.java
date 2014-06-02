
abstract public class Item {
	
	private String name;
	
	public Item (String name){
		this.name = name;
	}
	
	abstract double calculateValue();
	
	public void affectedStockCrash(){
		}
	
	public String toString(){
		return name + "($" + calculateValue() + ")";
	}
}
