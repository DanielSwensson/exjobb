import java.util.ArrayList;
public class Person {

	private String namn;
	ArrayList<Pryl> personPrylar; 

	public Person (String nam){
		namn=nam;
		this.personPrylar = new ArrayList<Pryl>();
	}
	public String getNamn(){
		return namn;
	}
	public double getRikedom(){
		double total = 0;
		for(Pryl pr:personPrylar){
			total += pr.getVärde();
		}
		return total;
	}
	public ArrayList<Pryl>getPersonPrylar(){
		return personPrylar;
	}
	public void addPryl(Pryl pryl){
		personPrylar.add(pryl);
	}

	public void börskrasch(){
		for(Pryl p:personPrylar){
			if(p instanceof Aktie)
				((Aktie)p).börskrasch();
		}
	}
		

	}
