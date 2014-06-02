import java.util.ArrayList;
/**
 * @author  sich4787
 */
public class Person {
	private ArrayList<Pryl> allaPrylar = new ArrayList <Pryl>();
	/**
	 * @uml.property  name="personName"
	 */
	private String personName;
	public Person(String pn){
		this.personName=pn;
	}
	/**
	 * @return
	 * @uml.property  name="personName"
	 */
	public String getPersonName(){
		return personName;
	}
	public int getTotalWealth(){
		int sum = 0;
		for(Pryl pry : allaPrylar)
			sum += pry.getValue();
		return sum;
	}
	public String toString(){
		return personName +" har prylar till ett värde av "+ getTotalWealth() +" kr ";
	}


	public void laggTill (Pryl ny){
		allaPrylar.add(ny);
	}
	public String getAllPrylar(){
		String value = "";
		for (Pryl pry : allaPrylar){
			value += pry.getPrylName()+" "+pry.getValue() + "\n";
		}
		return value;
	}
	public void setRemoveAktieValue(){

		for (Pryl pry : allaPrylar){
			if (pry instanceof Aktie){
				Aktie a = (Aktie)pry;
				a.setCrash();
			}
		}
	}
}