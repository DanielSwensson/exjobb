import java.util.ArrayList;
import java.util.Scanner;
public class Smycke extends Värdesak {
	private static Scanner tangentbord = new Scanner(System.in);
	private String material = null; 
	private int ädelstenar = 0;	//standardvärdet är noll

	Smycke(String namn, int pris, String material, int ädelstenar, int totalVärde){
		super (namn, pris, totalVärde);
		this.material = material;
		this.ädelstenar = ädelstenar;

	}
	public static void skapaSmycke(Person p){
		System.out.println("Ange vad det är för smycke: ");
		String prylsort = Person.getTangentbord().nextLine();
		System.out.println("Ange pris i kr för värdesaken: ");
		int prylPris = Integer.parseInt(Person.getTangentbord().nextLine());

		System.out.println("Är smycket av guld eller silver?");
		String material = Person.getTangentbord().nextLine();

		System.out.println("Antal ädelstenar");
		int ädelsten = Integer.parseInt(Person.getTangentbord().nextLine());

		int totalVärde = 0;

		if (material.equals("guld")) {
			totalVärde=totalVärde + 2000;
		}else{
			totalVärde=totalVärde+700;			
		}
		totalVärde = totalVärde + (ädelsten * 500)+ prylPris;
		System.out.println ("Totalvärdet för smycket är " + totalVärde + "kr .");

		Smycke s = new Smycke(prylsort, prylPris, material, ädelsten, totalVärde );

		ArrayList<Värdesak> värdeLista = p.getVärdeLista();
		värdeLista.add(s);
		p.setVärdeLista(värdeLista);


	}
}