import java.util.ArrayList;


public class Person {
	private String namn;
	private ArrayList<Prylar> allaPrylar= new ArrayList<Prylar>();
	
	
	public int summaPrylar(){
		int summa=0;
		
		for(Prylar aktuell: allaPrylar){
			summa+=aktuell.värde();
		}
		return summa;
	}
	
	public Person(String namn){
		this.namn= namn;
		
	}
	public int antalPrylar(){
		return allaPrylar.size();
	}
	
	public Prylar getPrylar(int x){
			
		return allaPrylar.get(x);
		
	}

	public void läggTillPryl(Prylar pryl){
		Prylar p= pryl;
		allaPrylar.add(p);
		
	}
	
	public String getNamn(){
		return namn;
	}
	
	public String toString(){
		return "Namn: "+ namn;
	}
}
