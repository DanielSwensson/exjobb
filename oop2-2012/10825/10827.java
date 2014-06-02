
//	OOP Inlämningsuppgift 2
//	Prylregister
//	Jonas Ask , 760818-0035

public class Jewellery extends Valueable {
	
	private String material;
	private int numGem;
	
	public Jewellery(String name, String material, int numGem){
		super(name,"Smycke");
		this.material = material;
		this.numGem = numGem;
	}
	
	
	public String getMaterial(){
		return material;
	}

	public int getNumGem(){
		return numGem;
	}
	
	public int getValue(){
		if(this.material.equalsIgnoreCase("Guld"))
			return 2000 + 500 * this.numGem;
		else if(this.material.equalsIgnoreCase("Silver"))
			return 700 + 500 * this.numGem;	
		else
			return 500 *this.numGem;
	}
	
	
	public String toString(){
		return " " +super.toString() + "\t"+ material +"\t"+ numGem  +"\t"+getValue();
	}
}
