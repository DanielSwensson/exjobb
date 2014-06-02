import java.util.Scanner;
import java.util.ArrayList;

public class Person {
	private ArrayList<V�rdesak> v�rdeLista = new ArrayList();
	private static ArrayList<Person> personLista = new ArrayList();
	private static Scanner tangentbord = new Scanner(System.in);
	private String namn;
	public String getNamn(){
		return namn; // h�mtar attributet p� namn
	}

	//konstruktor
	Person (String namn){
		this.namn = namn;
	}
	public static Scanner getTangentbord() {
		return tangentbord;
	}
	public ArrayList getV�rdeLista(){
		return v�rdeLista; //samma sak som namnet i 
	}
	public void setV�rdeLista (ArrayList v�rdeLista){
		this.v�rdeLista = v�rdeLista;
	}
	public static ArrayList getPersonLista(){
		return personLista;
	}
	public static Person getPerson(String namn){
		Person returnThis = null;
		for(Person p: personLista) {
			if (p.namn.equals(namn)){
				returnThis= p;
			}
		}
		return returnThis;
	}
	public static void skapaPerson (){
		System.out.println("Ange personens namn: ");
		String personNamn = tangentbord.nextLine();
		boolean add = true; //ifall jag beh�ver skapa till en person
		for (Person p: personLista) {

			if (p.getNamn().equals(personNamn)){
				System.out.println("Error: namnet du har angivit redan existerar. ");
				add=false;
			}
		}	
		if (add){ //om det inte finns n�gon person med samma namn i listan
			Person P2 = new Person(personNamn);	
			personLista.add(P2);
		}
	}
	public static void visaVissPerson() {
		System.out.println("Vem vill du h�mta ur registret?");
		String personNamn = tangentbord.nextLine();

		for(Person p: personLista) {
			if (personNamn.equals(p.getNamn())){
				System.out.println(p);
			}else {
				System.out.println("Personen du har angivit finns inte");
			}
		}
	}
	public String toString(){ //denna metod som k�rs som skriver ut namnet p� personen
		return namn;}

	public static void visaAllaPersoner(){
		int mestV�rde = 0;
		for(Person p: personLista) { 
			int v�rde = 0;//for each loop
			for (V�rdesak v : p.v�rdeLista){
				v�rde += v.getTotalV�rde();
				mestV�rde = v�rde;
				System.out.println("personen " + p + v�rde);
			}
		}}

	public static void visaRikaste(){ //static ett v�rde som inte kommer att �ndras
		int mestV�rde = 0;
		Person rikaste = null;
		for(Person p: personLista) {//for each loop
			int v�rde = 0;
			System.out.println(p);
			for (V�rdesak v : p.v�rdeLista){
				v�rde += v.getTotalV�rde();
			}
			if (v�rde > mestV�rde) {
				mestV�rde = v�rde;
				rikaste = p;

				System.out.println("Rikaste personen �r: " + rikaste + mestV�rde);
			}
		}
	}
}

