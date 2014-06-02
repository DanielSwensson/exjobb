import java.util.Scanner;
import java.util.ArrayList;

public class Person {
	private ArrayList<Värdesak> värdeLista = new ArrayList();
	private static ArrayList<Person> personLista = new ArrayList();
	private static Scanner tangentbord = new Scanner(System.in);
	private String namn;
	public String getNamn(){
		return namn; // hämtar attributet på namn
	}

	//konstruktor
	Person (String namn){
		this.namn = namn;
	}
	public static Scanner getTangentbord() {
		return tangentbord;
	}
	public ArrayList getVärdeLista(){
		return värdeLista; //samma sak som namnet i 
	}
	public void setVärdeLista (ArrayList värdeLista){
		this.värdeLista = värdeLista;
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
		boolean add = true; //ifall jag behöver skapa till en person
		for (Person p: personLista) {

			if (p.getNamn().equals(personNamn)){
				System.out.println("Error: namnet du har angivit redan existerar. ");
				add=false;
			}
		}	
		if (add){ //om det inte finns någon person med samma namn i listan
			Person P2 = new Person(personNamn);	
			personLista.add(P2);
		}
	}
	public static void visaVissPerson() {
		System.out.println("Vem vill du hämta ur registret?");
		String personNamn = tangentbord.nextLine();

		for(Person p: personLista) {
			if (personNamn.equals(p.getNamn())){
				System.out.println(p);
			}else {
				System.out.println("Personen du har angivit finns inte");
			}
		}
	}
	public String toString(){ //denna metod som körs som skriver ut namnet på personen
		return namn;}

	public static void visaAllaPersoner(){
		int mestVärde = 0;
		for(Person p: personLista) { 
			int värde = 0;//for each loop
			for (Värdesak v : p.värdeLista){
				värde += v.getTotalVärde();
				mestVärde = värde;
				System.out.println("personen " + p + värde);
			}
		}}

	public static void visaRikaste(){ //static ett värde som inte kommer att ändras
		int mestVärde = 0;
		Person rikaste = null;
		for(Person p: personLista) {//for each loop
			int värde = 0;
			System.out.println(p);
			for (Värdesak v : p.värdeLista){
				värde += v.getTotalVärde();
			}
			if (värde > mestVärde) {
				mestVärde = värde;
				rikaste = p;

				System.out.println("Rikaste personen är: " + rikaste + mestVärde);
			}
		}
	}
}

