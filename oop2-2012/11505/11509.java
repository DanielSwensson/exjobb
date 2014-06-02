package HABLO2;

public class Item {
	
	private int price;
	private int strength;


	public Item(int price, int strength){
		this.price=price;
		this.strength=strength;
	}
	public Item(){
		this.price=0;
		this.strength=0;
	}
	
	public int getPrice(){
		return this.price;
	}
	
	public int getStrength(){
		return this.strength;
	}
	

	
	public void setPrice(int newPrice){
		this.price = newPrice;
	}
	
	public void setStrength(int newStrength){
		this.strength = newStrength;
	}

}
