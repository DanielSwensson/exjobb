import java.util.ArrayList;
public class Register {
	private  ArrayList<Person> allaPersoner=new ArrayList<Person>();
	
	public boolean läggTillPerson(String namn){
		if(hittaPerson(namn) == null) {
			Person p = new Person(namn);
			allaPersoner.add(p);
			return true;
		} else {
			return false;
		}
	}
	
	public ArrayList<Person> getPersoner() {
		return allaPersoner;
	}
	
	public Person hittaPerson(String namn) {
		for(Person tmpPerson : allaPersoner) {
			if(tmpPerson.getNamn().equalsIgnoreCase(namn)) {
				return tmpPerson;
			}
		}
		return null;
	}
	
	
	public boolean nyttSmycke(String person, String namn, int ädelsten, boolean guld) {
		Person ägare = hittaPerson(person);
		if(ägare == null) {
			return false;
		}
		
		Smycke s = new Smycke(namn, ädelsten, guld);
		ägare.läggTill(s);
		
		return true;
	}
	public boolean nyAktiepost(String person, String namn, int pris, int antal) {
		Person ägare = hittaPerson(person);
		if(ägare == null) {
			return false;
		}
		
		Aktiepost a = new Aktiepost(namn, pris, antal);
		ägare.läggTill(a);
		
		return true;
	}
	public boolean nyApparat(String person, String namn, int slitage, double inkPris) {
		Person ägare = hittaPerson(person);
		if(ägare == null) {
			return false;
		}
		
		Apparat app = new Apparat(namn, inkPris, slitage);
		ägare.läggTill(app);
		
		return true;
	}
	public void görBörskrasch(){
		for(Person tmpPerson : allaPersoner){
			tmpPerson.göraBörsKrach();
		}
	}
	}
	


