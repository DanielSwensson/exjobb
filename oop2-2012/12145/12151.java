
public class Smycke extends Pryl {
	private String metall;
	private int �delsten;
	
	public double getValue() {
		if (metall.equals("guld")){
			return (�delsten * 500) + 2000;
					
		}
		
		else 
			return(�delsten * 500) + 700;
			
	}
	public Smycke(String typ, String metall, int �delsten){
		super(typ);
		this.metall = metall;
		this.�delsten = �delsten;
	}
	public String toString(){
		return namn + " " + getValue()  ;
	}
	
	

} 


