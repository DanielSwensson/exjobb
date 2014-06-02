import java.util.ArrayList;
import java.util.Scanner;
public class Smycke extends V�rdesak {
	private static Scanner tangentbord = new Scanner(System.in);
	private String material = null; 
	private int �delstenar = 0;	//standardv�rdet �r noll

	Smycke(String namn, int pris, String material, int �delstenar, int totalV�rde){
		super (namn, pris, totalV�rde);
		this.material = material;
		this.�delstenar = �delstenar;

	}
	public static void skapaSmycke(Person p){
		System.out.println("Ange vad det �r f�r smycke: ");
		String prylsort = Person.getTangentbord().nextLine();
		System.out.println("Ange pris i kr f�r v�rdesaken: ");
		int prylPris = Integer.parseInt(Person.getTangentbord().nextLine());

		System.out.println("�r smycket av guld eller silver?");
		String material = Person.getTangentbord().nextLine();

		System.out.println("Antal �delstenar");
		int �delsten = Integer.parseInt(Person.getTangentbord().nextLine());

		int totalV�rde = 0;

		if (material.equals("guld")) {
			totalV�rde=totalV�rde + 2000;
		}else{
			totalV�rde=totalV�rde+700;			
		}
		totalV�rde = totalV�rde + (�delsten * 500)+ prylPris;
		System.out.println ("Totalv�rdet f�r smycket �r " + totalV�rde + "kr .");

		Smycke s = new Smycke(prylsort, prylPris, material, �delsten, totalV�rde );

		ArrayList<V�rdesak> v�rdeLista = p.getV�rdeLista();
		v�rdeLista.add(s);
		p.setV�rdeLista(v�rdeLista);


	}
}