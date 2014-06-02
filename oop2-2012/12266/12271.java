
public class Smycken extends Prylar {
	
	private String metallP�Smycke;
	private int �delstenar;
	private double summa;
	
	public Smycken(String namn, String metallP�Smycke ,int �delstenar){
		
		super(namn);	
		this.�delstenar= �delstenar;
		this.metallP�Smycke = metallP�Smycke;
		
		if(metallP�Smycke.equalsIgnoreCase("Guld")){
			summa= 2000+(500.0*�delstenar);
		}if (metallP�Smycke.equalsIgnoreCase("Silver")){
			summa=700+(500.0*�delstenar);
		}
		
	}
	public String toString(){
		return "Namn: "+getNamn() + " Metall p� smycke: "+ metallP�Smycke+ " Antal �delstenar: "+ �delstenar+ " Summa: "+summa;
	}
	
	public double v�rde(){
		return summa;
	}
	
	public void set�delstenar(int new�delstenar){
		�delstenar = new�delstenar;
	}
	
	public void setMetallP�SMycke(String newMetallP�Smycke){
		metallP�Smycke = newMetallP�Smycke;
	}
	
	public int get�delStenar(){
		return �delstenar;
	}
	
	public String getMetallP�SMycke(){
		return metallP�Smycke;
	}
	
	
	
		
}
	


