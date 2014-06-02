import java.util.ArrayList;
import java.util.Scanner;


public class Register {
static Scanner scanner = new Scanner (System.in);
static int readInt(String fråga){
	for(;;){
		try{
			System.out.print(fråga);
			int x=Integer.parseInt(scanner.nextLine());
			return x;
			}
		catch (NumberFormatException e){
			System.out.println("Fel - skall vara numeriskt värde");
		}
	}
}

	
	
	public static void main(String[] args) {
	

	
ArrayList<Person>allaPerson=new ArrayList<Person>();
	
	while(true){

		System.out.println("Välj kommandot");
		System.out.println("A.Registrera en person");
		System.out.println("B.Registrera en pryl");
		System.out.println("C.Visa alla");
		System.out.println("D.Visa rikaste");
		System.out.println("E.Visa viss person");
		System.out.println("F.Börskrash");
		System.out.println("G.Avsluta");
		String kommando=scanner.nextLine();
	switch(kommando) {
	
	case "A":
		System.out.println("Vad heter personen?");
		String personNamn=scanner.nextLine();
		boolean finns=false;
			
		for(Person p:allaPerson){
		if (personNamn.equals(p.getNamn())){
			finns=true;
		}
		
		}
		if (finns)
			System.out.println("Personen finns i registret!");
		else{
		
		Person person = new Person(personNamn);
		allaPerson.add(person);
		
		}
		
	break;
	
	case "B":	
	
	System.out.println("Vilken person äger prylen?");
	String namn=scanner.nextLine();
	
	System.out.println("Vilken sorts pryl?");
	String sort = scanner.nextLine();
	
	if (sort.equalsIgnoreCase("Smycke")){
	
	System.out.println("Vilken sorts smycke?");
	String smyckeSort = scanner.nextLine();
	
	System.out.println("Är smycke av guld?");
	String guldSilver=scanner.nextLine();
	
	System.out.println("Antal ädelstenar?");
	int sten = readInt("");
	 Smycke smycke=new Smycke(smyckeSort, sten, guldSilver);
	
	 for(Person p:allaPerson){
			if (namn.equals(p.getNamn())){
				p.add(smycke);
				
			}
	 	
			}
	 }
	else if (sort.equalsIgnoreCase("Apparat")){
		System.out.println("Vilken sort apparat");
		String apparatSort=scanner.nextLine();
		
		System.out.println("Vilken är inköpspris?");
		int inköpsPris = readInt("");
		
		System.out.println("Vilken slitage? Skriv in 1(sämst)-10(bäst)");
		int slitage = readInt("");
		
		
		Apparat apparat=new Apparat(apparatSort,inköpsPris,slitage);
		 
		for(Person p:allaPerson){
				if (namn.equals(p.getNamn())){
					p.add(apparat);
	}
				
		}
	}
	else if (sort.equalsIgnoreCase("Aktie")){
		System.out.println("Vilken sort aktie");
		String aktieSort=scanner.nextLine();
		
		System.out.println("Hur många?");
		int antal = readInt("");
		
		System.out.println("Vilken pris?");
		int pris = readInt("");
		Aktie aktie=new Aktie(aktieSort,antal,pris);
		 
		for(Person p:allaPerson){
				if (namn.equals(p.getNamn())){
					p.add(aktie);
					
	}
		}
	}
	
	break;
	
	case "C":
		System.out.println("I registret finns");
		
		for(Person p:allaPerson)
			System.out.println(p);
			
	break;
	
	case "D":
		Person rikaste=new Person("Ingen");
		for(Person p:allaPerson){
			if(p.summaVärde()>=rikaste.summaVärde()){
				rikaste=p;
			}
			
		}
		System.out.println("Den rikaste är " +rikaste);
		System.out.println(rikaste.allaPrylartoString());
		break;
	
	case "E":
		boolean nyPerson = false;
		System.out.println("Vem ska skrivas ut?");
		String vem=scanner.nextLine();
		
		for(Person p:allaPerson){
			if(p.getNamn().equals(vem)){
			nyPerson = true;	
				System.out.println("Namnet är "+ p.getNamn());
				System.out.println(p.allaPrylartoString());
			}	
			}
		
	
		if(!nyPerson)
			System.out.println("Personen finns inte i regidtret!");
		
		break;
	
		case "F":
		for(Person p:allaPerson){
			p.crash();
		}
		break;
	
	case "G":
		System.exit(0);
		default:
			System.out.println("Felaktigt kommakdo");
	}

}
}
}