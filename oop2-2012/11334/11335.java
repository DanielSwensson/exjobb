import java.util.Scanner;
import java.util.ArrayList;

public class Aktie extends Värdesak {
	private static Scanner tangentbord = new Scanner(System.in); 
	int antal = 0; 
	//konstruktor
	Aktie(String namn,  int antal, int pris, int totalVärde){
		super (namn, pris, totalVärde);
		this.antal = antal;
	}

	public static void skapaAktie(Person p){
		System.out.println("Vad heter aktien? ");
		String namn = Person.getTangentbord().nextLine();

		System.out.println("Vad kostar aktien? ");
		int pris =Integer.parseInt(Person.getTangentbord().nextLine()); 

		System.out.println("Hur många aktier? ");
		int antal = Integer.parseInt(Person.getTangentbord().nextLine());

		int totalVärde = 0;	
		totalVärde = antal * pris;

		System.out.println("Totalvärdet för aktien är " + totalVärde + "kr .");

		Aktie a = new Aktie(namn, antal, pris, totalVärde);
		ArrayList<Värdesak> värdeLista = p.getVärdeLista();
		värdeLista.add(a);
		p.setVärdeLista(värdeLista);
	}

	public static void börskrasch(){
		ArrayList<Person> personLista = Person.getPersonLista();
		for(Person p: personLista) {
			System.out.println(p);
			ArrayList<Värdesak> värdeLista = p.getVärdeLista();

			for (Värdesak v: värdeLista){
				if (v instanceof Aktie){
					System.out.println("Aktien har inget värde.");
					v.setTotalVärde(0);
				} 
			}
		}
	}
}