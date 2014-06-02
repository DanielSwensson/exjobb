
abstract class Item 
{
	protected String nameItem;
	protected String typeItem;
	abstract public int getValueItem();
	
	//Skapar ett prylobjekt
	public Item(String nameItem)
	{
		this.nameItem = nameItem;
	}
	
	//Returnerar en pryls typ
	public String getTypeItem()
	{
		return typeItem;
	}
	
	//Returnerar en pryls namn
	public String getName()
	{
		return nameItem;
	}
	
	//Listar namnet p� en pryl och bredvid det dess v�rde
	public String toString()
	{
		return nameItem + "   " + getValueItem();
	}
}


