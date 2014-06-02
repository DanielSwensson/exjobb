package value.register;
//Jakob Elldin Mårtensson
//DSV, Stockholm University
//Inlupp 2 för OOP

abstract public class Item {

	//private float value; //kanske obsolete, kan ju bara räkna ut det varje gång det behövs?
	private String owner;
	protected String name;
	
	abstract public float getValue(); //abstract, skickar vidare till subklasserna
	
	public Item (){
		//tom konstrutkor fixar komipleringsfelet: Implicit super constructor Item() is undefined. Must explicitly invoke another constructor
	}//no arguments here!
	
	public Item (String o) {
		this.owner = o;
	}//end item konstruktor
	
	public Item (String o, String n){
		this.owner = o;
		this.name = n;
	}//en till konstruktor
	
	public String getOwner(){
		//returns owner
		return owner;
	}//end getowner
	
	public String getName(){
		//returns name
		return name;
	}//end getname
		
	public String toString(){
		return "Item name: "+name+" | Owner: "+owner+" ";
	}//end to string
	
	//set kommando ifall de skulle behövas ändras i efterhand (för framtida utökning av programmet, tex om items kan byta ägare)
	
	/*public void setOwner(String o) {
		this.owner = o;
	}//end setowner
	
	public void setName(String n) {
		this.name = n;
	}//end setname
	*/

	
}//end class item
