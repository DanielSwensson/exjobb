
import java.util.ArrayList;
public class Person {

	ArrayList<Pryl> personsPrylar = new ArrayList <Pryl>();
	private String namn;

	public Person(String namn){
		this.namn = namn;
	}


	public void loopKrasch(){
		Pryl hittadAktie;
		for (int i=0; i < personsPrylar.size(); i++){
			if (personsPrylar.get(i) instanceof Aktie){
				hittadAktie = personsPrylar.get(i);


				((Aktie)hittadAktie).krasch();
				System.out.println("Nu är alla aktier värdelösa!");
			}
		}
	}

	public String toPersonsPrylarLista(){
		String pryl = "";
		for (int i=0; i<personsPrylar.size(); i++){
			pryl += personsPrylar.get(i).getPryl() + "    " + personsPrylar.get(i).getVarde() + "\n";
		}
		return pryl;
	}


	public String getNamn(){
		return namn;
	}


	public double getTotalvarde(){
		double totalVarde = 0;
		for (int i=0; i < personsPrylar.size(); i++){
			totalVarde += personsPrylar.get(i).getVarde();
		}

		return totalVarde;
	}

	public void addPryl(Pryl pryl){
		personsPrylar.add(pryl);
	}
}