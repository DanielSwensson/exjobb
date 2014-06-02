package value.register;
//Jakob Elldin M�rtensson
//DSV, Stockholm University
//Inlupp 2 f�r OOP

public class Jewelry extends Item {

	private int stones;
	private String material; //ifall det endast kan vara gold eller silver
	//private String metal; //ifall det kan vara gold/silver ELLER n�got annat, kr�ver ifsats f�r att kolla vilket som �r true d�
	
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
		
		//om det visar sig att man endast kan anv�nda gold eller silver s� kan man �ndra denna del
		//just nu kan man dock ha vilket sorts material som helst, men om det �r guld/silver s� r�knar den p� detta s�tt
		//annars r�knar den bara med v�rdet p� stenarna
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
	
	
	//set kommandon ifall de skulle beh�vas �ndras i efterhand (f�r framtida ut�kning av programmet)
	
	/*public void setStones(int s) {
		this.stones = s;
	}//end setstones
	
	public void setMaterial(String m) {
		this.material = m;
	}//end setgold
	*/
	
}//end class jewelry
