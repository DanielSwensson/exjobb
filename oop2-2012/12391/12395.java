import java.util.ArrayList;

public class Person 
{
	private ArrayList <Item> itemList = new ArrayList<Item>();//Här skapar jag listan som ska hålla reda på en persons ägodelar
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
	
	//Lägger till ett objekt till pryllistan
	public void addItem(Item newItem)
	{
		itemList.add(newItem);
	}
	
	//Samlar ihop och returnerar det totala värdet av en pryllista
	public int getTotalValue()
	{
		int total = 0;
		for(int i=0; i<itemList.size(); i++)
		{
			total += itemList.get(i).getValueItem();
		}
		return total;
	}
	
	//Returnerar en pryls toString, i detta fall dess namn och värde
	public ArrayList<Item> getItemNameAndValue()
	{
		return itemList;
	}
	
	
	//Skapar en börskrasch genom att leta igenom pryllistan och för varje pryl som är en aktie så nollställer den värdet
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


	//Listar person och det totala värdet av dennes prylar
	public String toString()
	{
		return namePerson + "   " + getTotalValue();
	}
}
