import java.util.ArrayList;
// En klass med alla metoder f�r personer som anv�ndaren l�gger till i programmet
public class Personer {
	
	ArrayList <Person> allaPers;
	
	public Personer (){
		this.allaPers = new ArrayList <Person>(); 
	}
	
	//L�gger till en person till en ArrayList allaPers 
	public void l�ggTillPerson (Person pers) {
		allaPers.add(pers);
	}
	
	//Skriver alla personer som finns i en ArrayList allaPers och deras prylar
	public void visaAlla (){
		System.out.println("I registret finns :"); 
		for (Person i : allaPers){
			System.out.println(i.toString() + " \n");
		}
	}
	
	//Kollar om exakt namnet redan finns ansluten till en person f�r att undvika dubletter
	public boolean namnExisterar (String persNamn){
		for (Person i : allaPers){
			if (persNamn.equals(i.getNamn())){
				System.out.println("Namnet redan finns i registret!");
				return true; 
			}
		}
		return false;
	}
	
	//Person vems prylar har st�rsta sammansatta v�rdet s�ts till "rikaste" och returneras
	//Skriver ut konstiga grejer, hur fixa?
	public Person visaRikaste (){
		Person rikaste = null;
		int st�rsta = 0;
		for (Person p : allaPers){
			if (p.countV�rde() > st�rsta){
				st�rsta = p.countV�rde();
				rikaste = p;				
			}
		}
		return rikaste;
	}
	
	//Kollar om namnet finns i registret n�r man s�ker redan existerande person
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
