package value.register;
//Jakob Elldin Mårtensson
//DSV, Stockholm University
//Inlupp 2 för OOP


public class Share extends Item {


	private int amount;
	private float price; //ett alternativ skulle kunnat vara att se till att price är static för de objekt som har samma namn, därmed får alla med samma namn samma pris
	
	public Share (){
		
	}//end tom konstruktor
	
	public Share (String o, String n, int a, float p){
		super(o, n); //skicka owner och namn till superklassen
		this.amount = a;
		this.price = p;		
	}//end konstruktor
	
	
	
	public int getAmount() {
		return amount;
	}//end getstones
	
	public float getPrice() {
		return price;
	}//end getgold
	
	public float getValue(){
		//antal*pris
		float v = amount*price;	
		return v;
	}//end getvalue
	
	public String toString(){
		return "Share: "+name+" | Amount: "+amount+" | Price "+price+" | Value: "+getValue()+" ";
	}//end tostring
	
	
	//set kommandon ifall de skulle behövas ändras i efterhand (för framtida utökning av programmet)
	/*
	public void setAmount(int a) {
		this.amount = a;
	}//end setamount
	*/
	//enda setX som används i programmet i nuläget
	
	protected void setPrice(float p) {
		this.price = p;
	}//end setprice
	
	//alternativ lösning till funktionen setprice (vilket är säkrare än en funktion som sätter priset)
	public void noPrice(){
		this.price = 0;
	}//end noprice
	
	
}//end class share
