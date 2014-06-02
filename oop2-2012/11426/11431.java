
public class Stock extends Valuable{
	
	//attributes:
	private int quantity;
	private double pricePerQuantity;
	
	//constructor:
	public Stock(String typeOfValuable, String name, int quantity, double pricePerQuantity){
		super(typeOfValuable, name);
		this.quantity = quantity;
		this.pricePerQuantity = pricePerQuantity;
	}
	
	//methods:
	public double calculateValue(){
		return quantity * pricePerQuantity;
	}
	
	public void setPricePerQuantity(double value){
		pricePerQuantity = value;
	}
}
