import java.util.ArrayList;
import java.lang.Object;
public class Person {


	private ArrayList<Pryl> alla�godelar = new ArrayList<Pryl>();
	private String namn;

	public Person (String namn){
		this.namn = namn;
	}
	public double getSum(){
		int sum = 0;

		for(Pryl p : alla�godelar){		
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

	public void b�rskrasch(){

		for(Pryl p : alla�godelar){
			if( p instanceof Aktie){
				((Aktie)p).b�rskrasch();
			}
		}
	}
	
	public void adderaPryl(Pryl p){
		alla�godelar.add(p);
	}

	public String printValue(){

		String resultat = namn + "\n";
		for(Pryl p : alla�godelar){
		
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











