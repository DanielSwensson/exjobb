public abstract class Pryl {
	/**
	 * @uml.property  name="name"
	 */
	private String name;
	
	public Pryl(String name){
		this.name=name;
	}
	public abstract double getValue();
	/**
	 * @return
	 * @uml.property  name="name"
	 */
	public String getName(){
		return name;	
	}
	public abstract String toString();
}

