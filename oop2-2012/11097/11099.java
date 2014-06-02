package value.register;
//Jakob Elldin M�rtensson
//DSV, Stockholm University
//Inlupp 2 f�r OOP

abstract public class Item {

	//private float value; //kanske obsolete, kan ju bara r�kna ut det varje g�ng det beh�vs?
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
	
	//set kommando ifall de skulle beh�vas �ndras i efterhand (f�r framtida ut�kning av programmet, tex om items kan byta �gare)
	
	/*public void setOwner(String o) {
		this.owner = o;
	}//end setowner
	
	public void setName(String n) {
		this.name = n;
	}//end setname
	*/

	
}//end class item
