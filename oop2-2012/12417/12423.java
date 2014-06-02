public class Stock extends Valuable{
	private double value = 0; 
	private int amount = 0; 
	private double totalValue = 0; //amount*value;
		
	public Stock(String n, double v, int a){	//Constructor
		this.setName(n);
		this.value=v;
		this.amount=a;	
		this.totalValue=amount*value;
	}

	public void setValue(double v){
		this.value=v;
		this.totalValue=amount*value;
	}

	public void setAmount(int a){
		this.amount=a;
	}

//	public double getValue(){
//		return this.value;
//	}

	public int getAmount(){
		return this.amount;
	}
	
	public double getValue(){
		return this.totalValue;
	}
}
