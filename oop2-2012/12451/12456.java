import java.util.ArrayList;

public class Person {

	ArrayList <Pryl> allaPrylar = new ArrayList <Pryl>();

	private String personNamn;


	public Person (String personNamn){
		
		this.personNamn = personNamn;
	}
		
		

	public String personNamn(){
		return personNamn;
	}

	public void addPryl(Pryl p){
		allaPrylar.add(p);

	}
	public String toString(){
		return personNamn;
	}
	public int getTotaltV�rde (){

		int sum = 0;

		for(Pryl p : allaPrylar){
			sum += p.getV�rde();
		}

		return sum;
	}
	public String listaPrylar(){
		String pryl= "";
		for(Pryl p : allaPrylar)
		{
			pryl += p.getprylTyp() + "   " + p.getV�rde() + "\n";

		}

		return pryl;
	}

	public void b�rskrasch (){ 
	for (Pryl p : allaPrylar){ 
		if(p instanceof Aktie)
			((Aktie)p).b�rskrasch(); 	
		}}
	}








