import java.util.Scanner;
import java.util.ArrayList;

public class Aktie extends V�rdesak {
	private static Scanner tangentbord = new Scanner(System.in); 
	int antal = 0; 
	//konstruktor
	Aktie(String namn,  int antal, int pris, int totalV�rde){
		super (namn, pris, totalV�rde);
		this.antal = antal;
	}

	public static void skapaAktie(Person p){
		System.out.println("Vad heter aktien? ");
		String namn = Person.getTangentbord().nextLine();

		System.out.println("Vad kostar aktien? ");
		int pris =Integer.parseInt(Person.getTangentbord().nextLine()); 

		System.out.println("Hur m�nga aktier? ");
		int antal = Integer.parseInt(Person.getTangentbord().nextLine());

		int totalV�rde = 0;	
		totalV�rde = antal * pris;

		System.out.println("Totalv�rdet f�r aktien �r " + totalV�rde + "kr .");

		Aktie a = new Aktie(namn, antal, pris, totalV�rde);
		ArrayList<V�rdesak> v�rdeLista = p.getV�rdeLista();
		v�rdeLista.add(a);
		p.setV�rdeLista(v�rdeLista);
	}

	public static void b�rskrasch(){
		ArrayList<Person> personLista = Person.getPersonLista();
		for(Person p: personLista) {
			System.out.println(p);
			ArrayList<V�rdesak> v�rdeLista = p.getV�rdeLista();

			for (V�rdesak v: v�rdeLista){
				if (v instanceof Aktie){
					System.out.println("Aktien har inget v�rde.");
					v.setTotalV�rde(0);
				} 
			}
		}
	}
}