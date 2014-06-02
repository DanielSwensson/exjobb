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

	public int getF�rm�genhet(){
		int f�rm�genhet = 0;
		for (int x = 0; x< prylSamling.size(); x++){
			f�rm�genhet += prylSamling.get(x).v�rde();
		}
		return f�rm�genhet;
	}
	public void b�rskrasch(){
		for (int x = 0; x < prylSamling.size(); x++){
			if (prylSamling.get(x) instanceof Aktie){
				((Aktie)prylSamling.get(x)).b�rskrasch();
			}
		}
	}

	public String toString(){
		String allaPrylar = "";
		for (int x = 0; x < prylSamling.size(); x++){
			allaPrylar += prylSamling.get(x).toString();
		}
		return namn +" �ger sammanlagt "+ getF�rm�genhet() +"\n" + allaPrylar;

	}
}
