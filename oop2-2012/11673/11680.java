public class Smycke extends Pryl{
	/**
	 * @uml.property  name="amountGems"
	 */
	private int amountGems;
	/**
	 * @uml.property  name="type"
	 */
	private String type;
	/**
	 * @uml.property  name="value"
	 */

	public Smycke(String name, int amountGems, String type){
		super(name);
		this.amountGems=amountGems;
		this.type=type;
	}
	
	public double getValue() {
		int value = 0;
		if (type.equalsIgnoreCase("Guld")){
			value=2000;
		}else{
			if(type.equalsIgnoreCase("Silver")){
			value=700;		
			}
			else{
				value=0;
			}
		}
		return value+amountGems*500;
	}
	public String toString(){
		return super.getName() + "   " + getValue();
	}
	public double totalValue(){
		return getValue();
	}
}
