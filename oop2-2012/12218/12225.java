package personer.src.Package;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Register {

	static Scanner keyboard = new Scanner(System.in);
	static LinkedList<Person> personer = new LinkedList<Person>();

	public static void main(String[] args) {

		while (true){    
			System.out.println ("1. Skapa person");
			System.out.println ("2. Skapa pryl");
			System.out.println ("3. Visa alla");
			System.out.println ("4. Visa rikast person");
			System.out.println ("5. Visa specifik person");
			System.out.println ("6. Börskrash");
			System.out.println ("7. Avsluta");

			System.out.println (" ");

			System.out.println ("Knappa in önskad tjänst: ");

			String key = keyboard.next();

			keyboard.nextLine();
			switch (key){

			case "1":
				ArrayList<Smycken> listing = new ArrayList<Smycken>();
				ArrayList<Aktier> aktieList = new ArrayList<Aktier>();
				ArrayList<Apparater> apparatList = new ArrayList<Apparater>();
				Person  p = new Person(setPerson(),listing, aktieList, apparatList);
				personer.add(p);
				break;
			case "2":
				setPryl();
				break;
			case "3":
				for (Person k : personer){
					System.out.println(k);
				}
				break;
			case "4":
				ArrayList<Integer> sum = new ArrayList<Integer>();

				for(int i = 0; i < personer.size();i++){
					int adding = 0;
					for(int x = 0; x < personer.get(i).getSmyckeList().size();x++)
					{
						adding += personer.get(i).getSmyckeList().get(x).getPris();
					}
					for(int x = 0; x < personer.get(i).getAppList().size();x++)
					{
						adding += personer.get(i).getAppList().get(x).getPris();
					}
					for(int x = 0; x < personer.get(i).getAktieList().size();x++)
					{
						adding += personer.get(i).getAktieList().get(x).getPris();
					}
					sum.add(adding);
				}
				int indRichest=0;
				for(int i = 0; i < sum.size();i++){
					for(int x = 0; x < sum.size();x++){
						if(sum.get(i) > sum.get(x)){
							indRichest = i;
						}
					}

				}
				System.out.println(personer.get(indRichest).getName() + "  " + sum.get(indRichest));
				break;
			case "5":
				System.out.println("Skriv namnet på den du letar efter...");
				String indi = keyboard.nextLine();
int check=0;
				for(int i = 0; i < personer.size();i++){
				     if(personer.get(i).getName().toLowerCase().equals(indi.toLowerCase())){
				      System.out.println("1." + personer.get(i).getName());
				      System.out.println("2." + personer.get(i).getAktieList());
				      System.out.println("3." + personer.get(i).getSmyckeList());
				      System.out.println("4." + personer.get(i).getAppList());
				      check++;
				      break;
				     }
				}
				if(check == 0){ 
					System.out.println("Finns ej, ta o sök igen.");
				}
				break;
			case "6":
				System.out.println("Vem vill du ha börskrash för?");
				for(int i = 0; i < personer.size();i++){
					System.out.println(i + "." +personer.get(i).getName());
				}
				int index = keyboard.nextInt();
				for(int i = 0; i < personer.get(index).getAktieList().size();i++)
				{
					personer.get(index).getAktieList().get(i).setPris(0);
				}

				System.out.println(personer.get(index).getAktieList());
				break;

			case "7":
				System.out.print("Hej då");
				System.out.println(" ");
				System.exit(0);
				break;
			default:
				System.out.print("Vänligen ange rätt alternativ");
				System.out.println(" ");
				break;


			}
		}

	}

	private static String setPryl(){
		int x=0;
		int sVarde = 0;
		int aVarde=0;
		float pVarde = 0;
		int intPerson=0;
		System.out.println("Vilken person äger prylen");
		for (Person k : personer){

			System.out.println(x + ". " + k.getName());
			x++;

		}
		intPerson = keyboard.nextInt();
		System.out.println("Du har valt "+ personer.get(intPerson).getName());

		System.out.println("Ange pryl");
		System.out.println("1. Smycke");
		System.out.println("2. Aktier");
		System.out.println("3. Apparater");
		String key = keyboard.next();
		
		switch(key)
		{
		case "1":
			System.out.println("Vilken sorts smycke?");


			String Item =keyboard.next();
			System.out.println("Är smycket av guld?");
			if(keyboard.next().toLowerCase().equals("ja"))
			{
				sVarde = 2000;
			}else{
				sVarde = 700;
			}

			System.out.println("Antal ädelstenar");
			sVarde = (keyboard.nextInt()*500) + sVarde;
			Smycken tt = new Smycken(Item,sVarde);
			personer.get(intPerson).getSmyckeList().add(tt);
			System.out.println(personer);
			break;
		case "2":
			System.out.println("Vad heter aktien?");
			String aktie = keyboard.next();		
			System.out.println("Antal aktier");
			aVarde = keyboard.nextInt();
			System.out.println("Värde på enskild aktie");
			aVarde = keyboard.nextInt()*aVarde;
			Aktier at = new Aktier(aktie,aVarde);
			personer.get(intPerson).getAktieList().add(at);
			System.out.println(personer.get(intPerson).getAktieList());
			break;
		case "3":

			System.out.println("Vad är det för apparat?");
			String sApp = keyboard.next();
			System.out.println("Inköpspris");
			pVarde = keyboard.nextFloat();
			System.out.println("Skick 1-10 där 10 är bäst");
			pVarde = (keyboard.nextFloat()/10) * pVarde;
			Apparater appI = new Apparater(sApp, pVarde);
			personer.get(intPerson).getAppList().add(appI);
			System.out.println(personer);
			break;

		}
		return  ("");
	}


	public static String setPerson(){
		System.out.println ("Ange namn:");
		String Namn = keyboard.nextLine();
		return Namn;
	}



}




