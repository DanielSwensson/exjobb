
public class Smycken extends Prylar {
	
	private String metallPåSmycke;
	private int ädelstenar;
	private double summa;
	
	public Smycken(String namn, String metallPåSmycke ,int ädelstenar){
		
		super(namn);	
		this.ädelstenar= ädelstenar;
		this.metallPåSmycke = metallPåSmycke;
		
		if(metallPåSmycke.equalsIgnoreCase("Guld")){
			summa= 2000+(500.0*ädelstenar);
		}if (metallPåSmycke.equalsIgnoreCase("Silver")){
			summa=700+(500.0*ädelstenar);
		}
		
	}
	public String toString(){
		return "Namn: "+getNamn() + " Metall på smycke: "+ metallPåSmycke+ " Antal ädelstenar: "+ ädelstenar+ " Summa: "+summa;
	}
	
	public double värde(){
		return summa;
	}
	
	public void setÄdelstenar(int newÄdelstenar){
		ädelstenar = newÄdelstenar;
	}
	
	public void setMetallPåSMycke(String newMetallPåSmycke){
		metallPåSmycke = newMetallPåSmycke;
	}
	
	public int getÄdelStenar(){
		return ädelstenar;
	}
	
	public String getMetallPåSMycke(){
		return metallPåSmycke;
	}
	
	
	
		
}
	


