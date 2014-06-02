
public abstract class Item {

	private String name;
	private Person owner;
	
	public Item(String name, Person owner){
		this.name = name;
		this.owner = owner;
	}
	
	abstract public int getValue();
	
	abstract public void setEachValue(int value);
	
	public String getName(){
		return name;
	}
	
	public Person getOwner(){
		return owner;
	}
	
	
}