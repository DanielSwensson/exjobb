
//	OOP Inlämningsuppgift 2
//	Prylregister
//	Jonas Ask , 760818-0035

public class Stock extends Valueable {
	
	private int amount;
	private double price;
	
	public Stock(String name, int amount, double price){
		super(name,"Aktie");
		this.amount = amount;
		this.price = price;
	}
	
	
	public int getAmount(){
		return amount;
	}
	
	public double getPrice(){
		return price;
	}
	
	public void setPrice(double newPrice){
		this.price = newPrice;
	}
	
	public int getValue(){
		return (int)(amount * price);
	}
	
	public String toString(){
		return " " +super.toString() + "\t"+ amount +"\t"+ price +"\t"+ getValue();
	}
	
	
}
