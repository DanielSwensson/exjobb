
public class Stock extends Thing{
	
	private double worth;
	private int amount;
	
	public Stock(String n, double worth, int amount){
		super(n);
		this.worth=worth;
		this.amount=amount;

	}
	
	public double getWorth(){
		return worth;
	}
	
	public double getAmount(){
		return amount;
	}
	
	public int getSum(){
		return (int) (worth * amount);
	}
	
	public void setStock(){
		worth=0;
	}

}
