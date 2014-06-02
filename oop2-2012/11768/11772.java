import java.util.ArrayList;



public class Person{



	private ArrayList<Valuable> allValuables = new ArrayList <Valuable>();



	private String name;



	public Person(String name){

		this.name = name;

	}


	public String getName(){

		return name;

	}


	public void addValuable(Valuable valuable){ //ingen return för void finns

		allValuables.add(valuable);

	}


	public int totalValue(){

		int sum = 0;

		for (int i=0 ; i < allValuables.size(); i++)

		{

			sum += allValuables.get(i).getValue();

		}

		return sum;

	}


	public String toString(){

		return name + " som sammanlagt äger " + totalValue();

	}


	public String certainPerson(){

		String temp = name+" äger " + totalValue() + "\n";


		for (int i=0 ; i < allValuables.size(); i++)

		{

			temp += allValuables.get(i)+"\n";

		}

		return temp;

	}


	public void stockExchangeCrash(){

		for (int i=0 ; i < allValuables.size(); i++)

		{

			if (allValuables.get(i) instanceof Stock){

				Stock s = (Stock)allValuables.get(i);

				s.stockExchangeCrash();

			}

		}

	}

}


