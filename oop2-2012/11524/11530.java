import java.util.ArrayList;
// En klass med alla metoder för personer som användaren lägger till i programmet
public class Personer {
	
	ArrayList <Person> allaPers;
	
	public Personer (){
		this.allaPers = new ArrayList <Person>(); 
	}
	
	//Lägger till en person till en ArrayList allaPers 
	public void läggTillPerson (Person pers) {
		allaPers.add(pers);
	}
	
	//Skriver alla personer som finns i en ArrayList allaPers och deras prylar
	public void visaAlla (){
		System.out.println("I registret finns :"); 
		for (Person i : allaPers){
			System.out.println(i.toString() + " \n");
		}
	}
	
	//Kollar om exakt namnet redan finns ansluten till en person för att undvika dubletter
	public boolean namnExisterar (String persNamn){
		for (Person i : allaPers){
			if (persNamn.equals(i.getNamn())){
				System.out.println("Namnet redan finns i registret!");
				return true; 
			}
		}
		return false;
	}
	
	//Person vems prylar har största sammansatta värdet säts till "rikaste" och returneras
	//Skriver ut konstiga grejer, hur fixa?
	public Person visaRikaste (){
		Person rikaste = null;
		int största = 0;
		for (Person p : allaPers){
			if (p.countVärde() > största){
				största = p.countVärde();
				rikaste = p;				
			}
		}
		return rikaste;
	}
	
	//Kollar om namnet finns i registret när man söker redan existerande person
	public boolean giltigtNamn (String persNamn){
		for (Person i : allaPers){
			if (persNamn.equalsIgnoreCase(i.getNamn())){
				
				return true;
			}
		}
		System.out.println("Namnet finns inte");
		return false;
	}
	
	//Hittar och returnerar en person
	public Person hittaPerson (String namn){
		for (Person p : allaPers){
			if (p.getNamn().equalsIgnoreCase(namn)){
				return p;
			}
		}
		return null;
	}
	
	//Skriver ut persons uppgifter
	public void skrivaUtPers (String namn){
		for (Person p : allaPers){
			if (p.getNamn().equalsIgnoreCase(namn)){				
				System.out.println(p);
				
			}
		}
	}		
}
