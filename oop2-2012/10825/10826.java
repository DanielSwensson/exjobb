
//	OOP Inlämningsuppgift 2
//	Prylregister
//	Jonas Ask , 760818-0035

public class Gadget extends Valueable {
	private int buyPrice;
	private int wear;
	
	public Gadget(String name, int buyPrice, int wear){
		super(name,"Apparat");
		this.buyPrice = buyPrice;
		this.wear = wear;
	}
	
	
	public int getBuyPrice(){
		return buyPrice;
	}
	
	public int getWear(){
		return wear;
	}

	public int getValue(){
		return (int)(((100-this.wear)* this.buyPrice)/100) ; 
	}

	
	public String toString(){
		return " " +super.toString() +"\t"+ buyPrice +"\t"+ wear +"\t"+ getValue();
	}
	
}
