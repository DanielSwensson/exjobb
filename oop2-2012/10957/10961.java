import java.util.ArrayList;

public class Person {
	private ArrayList<Prylar> allaPrylar = new ArrayList <Prylar>();
	private String personNamn;

	public Person(String pn){
		this.personNamn=pn;
	}

	public String getPersonNamn(){
		return personNamn;

	}


	public int getTotalFörmögenhet(){

		int sum = 0;
		for(Prylar p : allaPrylar)
			sum += p.getVärde();

		return sum;

	}

	public String toString(){
		return personNamn +" har prylar till ett värde av "+ getTotalFörmögenhet() +" kr ";
	}
	
	
	public void läggTill (Prylar ny){
		allaPrylar.add(ny);

	}

	public String getAllaGrejer(){
		String value = "";
		for (Prylar p : allaPrylar){
			value += p.getPrylNamn()+"  "+p.getVärde() + "\n";
		}
		return value;


		

	}
	public void setNollställAktier(){
		
		for (Prylar p : allaPrylar){
			if (p instanceof Aktiepost){
				Aktiepost a = (Aktiepost)p;
				a.setKrasch();
			}
		}
	}
	
}