public class Apparat extends Pryl {
	/**
	 * @uml.property  name="purchasePrice"
	 */
	private int purchasePrice;
	/**
	 * @uml.property  name="slitage"
	 */
	private int slitage;
	
	public Apparat(String name, int purchasePrice, int slitage){
		super(name);
		this.purchasePrice = purchasePrice;
		this.slitage = slitage;
	}
	public double getValue(){
		return (slitage/10.0)*purchasePrice;
	}
	public String toString(){
		return super.getName() + "   " + getValue();
	}
	public double totalValue(){
		return getValue();
	}
}
