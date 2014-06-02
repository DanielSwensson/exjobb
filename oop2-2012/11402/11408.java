package inlupp2;

public class Shares extends Gadget{
	protected int pricePerShare;
	protected int amountOfShares;
	
	public Shares(String name,int amount, int price ){
		super(name);
		pricePerShare = price;
		amountOfShares = amount;
	}
	protected int value(){
		return amountOfShares*pricePerShare;
	}
	public void setPrice(int price){
		pricePerShare = price;
	}
	
	public String toString(){
		return getName() + "	" + value();
	}
}
