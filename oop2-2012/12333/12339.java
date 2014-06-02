
abstract class Thing {
	
	protected String name;
	
	public Thing (String n){
		this.name=n;
		
	}
	
	public String getName(){
		return name;
	}
	
	public String toString(){
		return name + "    " + getSum();
	}
	
	abstract int getSum();
	
}
