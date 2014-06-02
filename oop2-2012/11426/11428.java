
public class Jewelry extends Valuable{

	//attributes:
	private int noOfStones;
	private String material;
	
	//constructor:
	public Jewelry(String typeOfValuable, String name, int noOfStones, String material){
		super(typeOfValuable, name);
		this.noOfStones = noOfStones;
		this.material = material;
	}
	
	//methods:
	public double calculateValue(){
		if(material.equalsIgnoreCase("gold")){
			return 2000 + (noOfStones * 500);
			/*If it is not gold it must be silver*/
		}else{
			return 700 + (noOfStones * 500);
		}
	}
}
 