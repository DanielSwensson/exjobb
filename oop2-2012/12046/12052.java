import java.util.ArrayList;
public class Register {
	private  ArrayList<Person> allaPersoner=new ArrayList<Person>();
	
	public boolean l�ggTillPerson(String namn){
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
	
	
	public boolean nyttSmycke(String person, String namn, int �delsten, boolean guld) {
		Person �gare = hittaPerson(person);
		if(�gare == null) {
			return false;
		}
		
		Smycke s = new Smycke(namn, �delsten, guld);
		�gare.l�ggTill(s);
		
		return true;
	}
	public boolean nyAktiepost(String person, String namn, int pris, int antal) {
		Person �gare = hittaPerson(person);
		if(�gare == null) {
			return false;
		}
		
		Aktiepost a = new Aktiepost(namn, pris, antal);
		�gare.l�ggTill(a);
		
		return true;
	}
	public boolean nyApparat(String person, String namn, int slitage, double inkPris) {
		Person �gare = hittaPerson(person);
		if(�gare == null) {
			return false;
		}
		
		Apparat app = new Apparat(namn, inkPris, slitage);
		�gare.l�ggTill(app);
		
		return true;
	}
	public void g�rB�rskrasch(){
		for(Person tmpPerson : allaPersoner){
			tmpPerson.g�raB�rsKrach();
		}
	}
	}
	


