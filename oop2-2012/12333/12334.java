
public class Device extends Thing {
	
	private int wear;
	private double price;
	
	public Device(String n, double price, int wear){
		super(n);
		this.wear=wear;
		this.price=price;
		
	}
	
	public double getPrice(){
		return price;
	}
	
	public int getWear(){
		return wear;
	}
	
	public int getSum(){
		double factor = (double) wear / 10.0;
		return (int) (price * factor);
	}

}
