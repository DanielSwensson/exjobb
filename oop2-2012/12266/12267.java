
public class Aktier extends Prylar {

	private double prisAktie;
	private int antalAktier;
	private double summa;
	
	public Aktier(String namn, double prisAktie, int antalAktier){

	
		super(namn);
		this.antalAktier= antalAktier;
		this.prisAktie = prisAktie;

		summa= antalAktier*prisAktie;
	}
	
	public String toString(){
		return "Namn: "+getNamn() + " Pris per aktie: "+ prisAktie+ " Antal aktier: "+ antalAktier+ " Summa: "+summa;
	}
	
	public double värde(){
		return antalAktier*prisAktie;
	}
	
	public void setAntal(int newAntalAktier){
		antalAktier= newAntalAktier;
	}
	
	public void krasch(){
		prisAktie = 0.0;
	}
	
	public int getAntalAktier(){
		return antalAktier;
	}
	
	public double getPrisAktie(){
		return prisAktie;
	}
	
	public void nollställAktie(){
		prisAktie=0;
		
	}

}
