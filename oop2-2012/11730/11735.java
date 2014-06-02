public class Person{

	private String name;
	private int totalValue;

	public Person(String name) {
		this.name = name;
	}

	public String getName(){
		return name;
	}
	
	public int getTotalValue(){
		return totalValue;
	}
	
	public void addTotalValue(int value){
		totalValue += value;
	}
	
	public void resetTotalValue(){
		totalValue = 0;
	}
	
	

	
}
