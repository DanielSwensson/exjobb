package value.register;
//Jakob Elldin Mårtensson
//DSV, Stockholm University
//Inlupp 2 för OOP

public class Jewelry extends Item {

	private int stones;
	private String material; //ifall det endast kan vara gold eller silver
	//private String metal; //ifall det kan vara gold/silver ELLER något annat, kräver ifsats för att kolla vilket som är true då
	
	public Jewelry() {
		
	}
	
	public Jewelry (String o, String n, int s, String m) {
		super(o,n); //skicka owner och namn till superklassen
		this.stones = s;
		this.material = m;
	}//end konstruktor

	
	public int getStones() {
		return stones;
	}//end getstones
	
	public String getMaterial() {
		return material;
	}//end getgold
	
	public float getValue(){
		//gold = +2000, silver = +700
		//stones = 500 per stone (stones*500)
		float v = 0;
		
		//om det visar sig att man endast kan använda gold eller silver så kan man ändra denna del
		//just nu kan man dock ha vilket sorts material som helst, men om det är guld/silver så räknar den på detta sätt
		//annars räknar den bara med värdet på stenarna
		if (material.equals("Gold") || material.equals("gold") || material.equals("GOLD") )
			v = 2000+stones*500;
		else if (material.equals("Silver") || material.equals("silver") || material.equals("SILVER") )
			v = 700+stones*500;
		else
			v = stones*500;
		
		return v;
	}
	
	public String toString(){
		return "Jewelry: "+name+" | Stones: "+stones+" | Material: "+material+" | Value: "+getValue()+" ";
	}//end tostring
	
	
	//set kommandon ifall de skulle behövas ändras i efterhand (för framtida utökning av programmet)
	
	/*public void setStones(int s) {
		this.stones = s;
	}//end setstones
	
	public void setMaterial(String m) {
		this.material = m;
	}//end setgold
	*/
	
}//end class jewelry
