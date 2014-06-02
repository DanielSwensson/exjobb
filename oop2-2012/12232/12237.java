/**
 * @author  sich4787
 */
abstract class Pryl {

	protected String name;
	
	public Pryl(String n){
		this.name=n;
	}
	
	/**
	 * @uml.property  name="value"
	 */
	private double value;

	/**
	 * @return
	 * @uml.property  name="value"
	 */
	public abstract int getValue();
	
	public abstract String getPrylName();
}