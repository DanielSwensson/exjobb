import java.util.ArrayList;
import java.util.Scanner;
public class Apparat extends Värdesak{
	private static Scanner tangentbord = new Scanner(System.in);
	int slitage = 0;

	//konstruktorn
	Apparat (String namn, int slitage, int pris, int totalVärde){
		super (namn, pris, totalVärde);
		this.slitage=slitage;
	}
	public static void skapaApparat(Person p){
		System.out.println("Vad heter apparaten? ");
		String namn = Person.getTangentbord().nextLine();

		System.out.println("Vilken typ av slitage har apparaten mellan 1 och 10 där 10 betyder helt ny och 1 mycket sliten?");
		int slitage = Integer.parseInt(Person.getTangentbord().nextLine());

		System.out.println("Vad kostar apparaten? ");
		int pris = Integer.parseInt(Person.getTangentbord().nextLine());

		int totalVärde = 0;
		totalVärde = pris * slitage / 10;

		System.out.println("Totalvärdet för apparaten är " + totalVärde + "kr");

		Apparat a = new Apparat (namn, slitage, pris, totalVärde);

		ArrayList<Värdesak> värdeLista = p.getVärdeLista();
		värdeLista.add(a);
		p.setVärdeLista(värdeLista);

	}
}