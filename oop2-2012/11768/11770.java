import java.util.ArrayList;

import java.util.Scanner;



public class Inlupp2 {



	Scanner keyboard = new Scanner(System.in);

	ArrayList<Person> allPersons = new ArrayList<Person>();



	int readInt(String question){

		while (true){

			try{

				System.out.print(question);

				int x = Integer.parseInt(keyboard.nextLine());

				return x;

			}

			catch (NumberFormatException e){

				System.out.println("Fel - skall vara numeriskt värde");

			}

		}

	}


	String readString(String question){

		System.out.println(question);

		String str = keyboard.nextLine();

		return str;

	}




	//CASE 1

	public void addPerson(){


		String name = readString("Ange personens namn: ");



		boolean PersonExists = false;



		for (int i=0; i < allPersons.size(); i++)

		{

			if ((allPersons.get(i)).getName().equals(name))

			{

				PersonExists = true;	 //== Fungerar bara för primitiva

				System.out.print("\n\n Personen " + name + " finns redan i registret.");

			}

		}

		if (PersonExists == false){

			Person person = new Person(name);

			allPersons.add(person);

			System.out.println("Personen har blivit tillagd.");

		}

	}





	//CASE 2

	public void addGadget(){


		String name = readString("Vilken person äger prylen: ");



		Person person = null;

		for (int i=0; i < allPersons.size(); i++)

		{

			if ((allPersons.get(i)).getName().equalsIgnoreCase(name)) 

			{

				person = allPersons.get(i);

			}

		}

		if(person == null){

			System.out.println("Personen finns inte i registret.");

			return;

		}


		String alternative;


		while (true){

			System.out.print("Välj en pryl (smycke, aktie, apparat): ");

			alternative = keyboard.nextLine();

			switch (alternative.toLowerCase()){ //toLowerCase ändrar och jämför därefter

			case "smycke":	 //medan IgnoreCase jämför på direkten

				String nameOfJewellery = readString("Vilken sorts smycke: ");



				boolean correctAnswer;

				String metal;


				do{

					metal = readString("Är smycket av guld (ja/nej)? ");


					correctAnswer = (metal.equalsIgnoreCase("ja") || metal.equalsIgnoreCase("nej"));



					if (!correctAnswer)

					{

						System.out.println("Felaktigt alternativ.");

					}

				} while (!correctAnswer);


				int gems = readInt("Antal ädelstenar: ");


				Jewellery jewellery = new Jewellery(nameOfJewellery, metal, gems);

				person.addValuable(jewellery);

				System.out.println("Smycket har lagts till.");

				return;

			case "aktie":

				String nameOfStock = readString("Namn på aktien: ");

				int amount = readInt("Antal aktier: ");


				int price = readInt("Priset på aktien: ");


				Stock stock = new Stock(nameOfStock, price, amount);

				person.addValuable(stock);

				System.out.println("Aktien har lagts till.");

				return;

			case "apparat":

				String nameOfDevice = readString("Typ av apparat: ");


				int purchasePrice = readInt("Inköpspris: ");


				boolean correctNumber;

				int abrasion;


				do{

					abrasion = readInt("Slitage (1-10): ");


					correctNumber = (abrasion >= 1 && abrasion <= 10);



					if (!correctNumber)

					{

						System.out.println("Felaktigt alternativ.");

					}

				} while (!correctNumber);

				Device device = new Device(nameOfDevice, purchasePrice, abrasion);

				person.addValuable(device);

				System.out.println("Apparaten har lagts till.");

				return;

			default:

				System.out.println("Felaktigt alternativ.");

				break;

			}

		}

	}




	//CASE 3

	public void listAll(){

		System.out.print("I registret finns: \n");

		if (allPersons.isEmpty())

		{

			System.out.println("Ingen person!");

		}

		for (int i=0; i < allPersons.size(); i++)

		{

			System.out.println(allPersons.get(i));

		}

	}




	//CASE 4

	public void listRichest(){

		Person richest = new Person("ingen person");

		for (int i=0; i < allPersons.size(); i++)

		{

			if (allPersons.get(i).totalValue() >= richest.totalValue())

			{

				richest = allPersons.get(i);

			}

		}

		System.out.println("Rikast är " + richest);

	}




	//CASE 5

	public void listCertainPerson(){



		if (allPersons.size() == 0)

		{ 

			System.out.println("Ingen person finns i registret.");

			return;

		}


		System.out.print("Vilken person vill du söka efter: ");

		String showPerson = keyboard.nextLine();


		for (int i=0; i < allPersons.size(); i++)

		{

			if ((allPersons.get(i)).getName().equalsIgnoreCase(showPerson))

			{

				System.out.println(allPersons.get(i).certainPerson());

				return;

			}

		}

		System.out.println("Personen finns inte i registret.");

	}




	//CASE 6

	public void stockExchangeCrash(){

		for (int i=0; i < allPersons.size(); i++)

		{

			allPersons.get(i).stockExchangeCrash();

		}

	}




	public static void main(String[] args) {

		new Inlupp2();

	}






	public Inlupp2(){



		int alternative;



		while (true){

			System.out.println();

			alternative = readInt("Välj ett alternativ (1-7): \n 1) Skapa person \n 2) Skapa pryl \n 3) Visa alla \n 4) Visa rikaste \n 5) Visa viss person \n 6) Börskrasch \n 7) Avsluta \n");

			switch (alternative){

			case 1:

				addPerson();

				break;

			case 2:

				addGadget();

				break;

			case 3:

				listAll();

				break;

			case 4:

				listRichest();

				break;

			case 5:

				listCertainPerson();

				break;

			case 6:

				stockExchangeCrash();

				break;

			case 7:

				System.out.print("Programmet har avslutats.");

				keyboard.close();

				System.exit(0);

				break;

			default:

				System.out.println("Felaktigt alternativ.");

				break;

			}

		}

	}

}




