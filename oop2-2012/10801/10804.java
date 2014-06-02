
public class Smycke extends Pryl {

	private boolean guld;
	private int ädelstenar;
	
	
	public Smycke(String namn, boolean guld, int ädelstenar){
		super(namn);
		this.guld = guld;
		this.ädelstenar = ädelstenar;
		
	}
	
	public int kalkyleraVärde() {
		int temp = 500*ädelstenar;
		if (guld) 
			temp+= 2000;
		else
			temp+= 700;
			
		return temp;
	}


	public String toString() {
		return  getNamn() + " " + String.valueOf(kalkyleraVärde());
		
	}


	public String getTyp() {
		return "Smycke";
	}

}
