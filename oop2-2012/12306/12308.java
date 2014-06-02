
public class ElectronicProduct extends Item {
	
	private int priceNew;
	private int condition;
	
	public ElectronicProduct(String name, int priceNew, int condition){
		super(name);
		if(condition > 10 || condition < 0) {
			throw new IllegalArgumentException("condition must be greater than 0 and lesser than 11");
		}
		this.priceNew = priceNew;
		this.condition = condition;
		}
	
	public double calculateValue(){
		return (condition / 10.0) * priceNew; 
	}

}
