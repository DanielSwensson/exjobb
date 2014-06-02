import java.util.ArrayList;
import java.util.Scanner;
public class Apparat extends V�rdesak{
	private static Scanner tangentbord = new Scanner(System.in);
	int slitage = 0;

	//konstruktorn
	Apparat (String namn, int slitage, int pris, int totalV�rde){
		super (namn, pris, totalV�rde);
		this.slitage=slitage;
	}
	public static void skapaApparat(Person p){
		System.out.println("Vad heter apparaten? ");
		String namn = Person.getTangentbord().nextLine();

		System.out.println("Vilken typ av slitage har apparaten mellan 1 och 10 d�r 10 betyder helt ny och 1 mycket sliten?");
		int slitage = Integer.parseInt(Person.getTangentbord().nextLine());

		System.out.println("Vad kostar apparaten? ");
		int pris = Integer.parseInt(Person.getTangentbord().nextLine());

		int totalV�rde = 0;
		totalV�rde = pris * slitage / 10;

		System.out.println("Totalv�rdet f�r apparaten �r " + totalV�rde + "kr");

		Apparat a = new Apparat (namn, slitage, pris, totalV�rde);

		ArrayList<V�rdesak> v�rdeLista = p.getV�rdeLista();
		v�rdeLista.add(a);
		p.setV�rdeLista(v�rdeLista);

	}
}