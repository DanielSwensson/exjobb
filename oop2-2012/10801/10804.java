
public class Smycke extends Pryl {

	private boolean guld;
	private int �delstenar;
	
	
	public Smycke(String namn, boolean guld, int �delstenar){
		super(namn);
		this.guld = guld;
		this.�delstenar = �delstenar;
		
	}
	
	public int kalkyleraV�rde() {
		int temp = 500*�delstenar;
		if (guld) 
			temp+= 2000;
		else
			temp+= 700;
			
		return temp;
	}


	public String toString() {
		return  getNamn() + " " + String.valueOf(kalkyleraV�rde());
		
	}


	public String getTyp() {
		return "Smycke";
	}

}
