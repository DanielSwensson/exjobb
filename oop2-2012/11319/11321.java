package valueables.items;

public abstract class Item {

	private String name;
	
	public Item(String name){
		this.name=name;
	}
	
	public abstract int getValue();
	
	/*
	 * Classes affected by a stock market crash define desired behavior
	 */
	public void marketCrash() {
		return;		
	}
	
	public String toString(){
		return name+"\t\t"+getValue();
	}
}
