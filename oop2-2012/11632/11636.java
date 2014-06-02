import java.util.ArrayList;
import java.lang.Object;
public class Person {


	private ArrayList<Pryl> allaÄgodelar = new ArrayList<Pryl>();
	private String namn;

	public Person (String namn){
		this.namn = namn;
	}
	public double getSum(){
		int sum = 0;

		for(Pryl p : allaÄgodelar){		
			sum += p.getValue();
		}

		return sum;
	} 
	
	public String getNamn(){
		String temp = namn;
		return temp;
	}
	public void setNamn(String namn){
		this.namn = namn;
	}

	public void börskrasch(){

		for(Pryl p : allaÄgodelar){
			if( p instanceof Aktie){
				((Aktie)p).börskrasch();
			}
		}
	}
	
	public void adderaPryl(Pryl p){
		allaÄgodelar.add(p);
	}

	public String printValue(){

		String resultat = namn + "\n";
		for(Pryl p : allaÄgodelar){
		
			resultat += p.getTypAvPryl() + "    ";
			resultat += p.getValue() + " :-\n";
		}
		return resultat;
	}

	public String printShort()
	{
		return namn + " " + getSum();
	}



}











