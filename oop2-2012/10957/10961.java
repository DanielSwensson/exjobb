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


	public int getTotalF�rm�genhet(){

		int sum = 0;
		for(Prylar p : allaPrylar)
			sum += p.getV�rde();

		return sum;

	}

	public String toString(){
		return personNamn +" har prylar till ett v�rde av "+ getTotalF�rm�genhet() +" kr ";
	}
	
	
	public void l�ggTill (Prylar ny){
		allaPrylar.add(ny);

	}

	public String getAllaGrejer(){
		String value = "";
		for (Prylar p : allaPrylar){
			value += p.getPrylNamn()+"  "+p.getV�rde() + "\n";
		}
		return value;


		

	}
	public void setNollst�llAktier(){
		
		for (Prylar p : allaPrylar){
			if (p instanceof Aktiepost){
				Aktiepost a = (Aktiepost)p;
				a.setKrasch();
			}
		}
	}
	
}