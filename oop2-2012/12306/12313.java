
public class Stock extends Item {
	
	private int numberOf;
	private int price;
	
	public Stock(String name, int numberOf, int price){
		super(name);
		this.numberOf = numberOf;
		this.price = price;
	}
	
	public double calculateValue(){
		return this.price * this.numberOf;
	}
	
	public void affectedStockCrash(){
		this.price = 0;
	}
	
	public String toString(){
		return super.toString() + " " + numberOf + " shares at $" + price; 
	}
}






