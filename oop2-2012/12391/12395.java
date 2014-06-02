import java.util.ArrayList;

public class Person 
{
	private ArrayList <Item> itemList = new ArrayList<Item>();//H�r skapar jag listan som ska h�lla reda p� en persons �godelar
	private String namePerson;
	
	//Skapar personobjekt
	public Person(String namePerson)
	{
		this.namePerson = namePerson;
	}
	
	//Returnerar en persons namn
	public String getNamePerson()
	{
		return namePerson;
	}
	
	//L�gger till ett objekt till pryllistan
	public void addItem(Item newItem)
	{
		itemList.add(newItem);
	}
	
	//Samlar ihop och returnerar det totala v�rdet av en pryllista
	public int getTotalValue()
	{
		int total = 0;
		for(int i=0; i<itemList.size(); i++)
		{
			total += itemList.get(i).getValueItem();
		}
		return total;
	}
	
	//Returnerar en pryls toString, i detta fall dess namn och v�rde
	public ArrayList<Item> getItemNameAndValue()
	{
		return itemList;
	}
	
	
	//Skapar en b�rskrasch genom att leta igenom pryllistan och f�r varje pryl som �r en aktie s� nollst�ller den v�rdet
	public int getPersonValueStock()
	{
		for(int i = 0; i < itemList.size(); i++)
		{
			if(itemList.get(i).getTypeItem().equals("stock"))
			{
				Stock tempStock = (Stock)itemList.get(i);
				tempStock.setValueStock(0);
			}
		}
		return 1;
	}


	//Listar person och det totala v�rdet av dennes prylar
	public String toString()
	{
		return namePerson + "   " + getTotalValue();
	}
}
