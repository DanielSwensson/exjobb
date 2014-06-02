
import java.util.*;

public class Person {
	private ArrayList<Pryl> prylsamling = new ArrayList<Pryl>();

	private String name;

	public Person(String name){
		this.name=name;		
	}	

	public String getName(){
		return name;
	}

	public void addPryl(Pryl p){
		prylsamling.add(p);
	}

	public void removePryl(Pryl p){
		prylsamling.remove(p);	
	}

	public double value(){
		int sum = 0;
		int x = 0;
		for(x=0; x<prylsamling.size();x++)
			sum+=prylsamling.get(x).value();
		return sum;
	}

	public String allStuff(){
		String list="";
		for(int i=0; i<prylsamling.size();i++){
			list = list+" "+prylsamling.get(i).getType1() +" "+ prylsamling.get(i).value() +" \n";
		}
		return list;
	}
//Bšrskrach
	public void getKrasch(){
		for(int i=0; i< prylsamling.size(); i++){
			if(prylsamling.get(i) instanceof Aktie){
				((Aktie)prylsamling.get(i)).krasch();
			}
		}
	}
}