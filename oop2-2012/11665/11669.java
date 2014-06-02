public class Stock extends Thing {
	private int number, price;
	
	public Stock(String name, int n, int p){
		super(name);
		number = n;
		price = p;
	}

	public int getNumber(){
		return number;
	}
	
	public int getPrice(){
		return price;
	}
	
	public int getValue(){
		return number*price;
	}
	
	public void setPrice(int p){
		price = p;
	}
	
}
