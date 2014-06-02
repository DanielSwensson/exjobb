package value.register;
//Jakob Elldin Mårtensson
//DSV, Stockholm University
//Inlupp 2 för OOP


public class Device extends Item {


	private float price;
	private float wear;
	
	public Device (){
		
	}//end tom konstruktor
	
	
	public Device (String o, String n, float p, float w){
		super(o, n); //skicka owner och namn till superklassen
		this.price = p;
		this.wear = w;		
	}//end konstruktor
	

	
	public float getPrice() {
		return price;
	}//end getgold
	
	public float getWear(){
		return wear;
	}//end getwear
	
	public float getValue(){
		//priset * slitage (10=100%) dvs priset * slitage / 10
		float v = price*wear/10; 
		return v;
	}//end getvalue
	
	public String toString(){	
		return "Device: "+name+" | Original Price: "+price+" | Wear: "+wear+" | Value: "+getValue()+" ";
	}//end tostring
	
	
	//set kommandon ifall de skulle behövas ändras i efterhand (för framtida utökning av programmet)
	
	/*
	public void setPrice(float p) {
		this.price = p;
	}//end setprice
	
	public void setWear(float w){
		this.wear = w;
	}
	*/
	
}//end class device
