import java.util.ArrayList;

public class Person{
	ArrayList<Pryl>prylSamling = new ArrayList<Pryl>();

	private String namn;

	public Person(String namn){
		this.namn = namn;

	}
	public String getNamn(){
		return namn;
	}

	void addPryl(Pryl ny){
		prylSamling.add(ny);
	}

	public int getFörmögenhet(){
		int förmögenhet = 0;
		for (int x = 0; x< prylSamling.size(); x++){
			förmögenhet += prylSamling.get(x).värde();
		}
		return förmögenhet;
	}
	public void börskrasch(){
		for (int x = 0; x < prylSamling.size(); x++){
			if (prylSamling.get(x) instanceof Aktie){
				((Aktie)prylSamling.get(x)).börskrasch();
			}
		}
	}

	public String toString(){
		String allaPrylar = "";
		for (int x = 0; x < prylSamling.size(); x++){
			allaPrylar += prylSamling.get(x).toString();
		}
		return namn +" äger sammanlagt "+ getFörmögenhet() +"\n" + allaPrylar;

	}
}
