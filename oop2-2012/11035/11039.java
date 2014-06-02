import java.util.ArrayList;

public class Person {

	private String namn;
	private ArrayList<Pryl> personPrylar = new ArrayList<Pryl>();

	public Person (String n){
		namn = n;
	}


	public String getNamn (){
		return namn;
	}

	public void addPryl (Pryl p){
		personPrylar.add(p);
	}

	public String toString(){
		return getNamn() + "\t" + getSummaVärde();
	}


	public int getSummaVärde (){
		int summa = 0;
		for (Pryl p : personPrylar)
			summa += p.getVärde();
		return summa;
	}


	public void SetAktieTillNoll (){
		for(int x=0; x < personPrylar.size(); x++){
			if (personPrylar.get(x).getPryltyp().equalsIgnoreCase("Aktie")){
				Aktie aktie = (Aktie)personPrylar.get(x);
				aktie.setPrisNoll();
			}
		}
	}

	public String getPrylInfo(){
		String prylinfo = "";			
		for( int x=0; x < personPrylar.size(); x++){
			prylinfo += personPrylar.get(x);
			prylinfo+= "\n";
		}return prylinfo;

	}
}