
public class Jewlery extends Item
{
	private String material;
	private int numberOfGems;
	
	//Skapar ett smyckesobjekt
	public Jewlery (String nameItem, String material, int numberOfGems)
	{
		super(nameItem);
		this.material = material;
		this.numberOfGems = numberOfGems;
		typeItem="jewlery";
	}
	
	//Returnerar ett smyckes material
	public String getMaterial()
	{
		return material;
	}
	
	//Returnerar antal ädelstenar på ett smycke
	public int getNumberOfGems()
	{
		return numberOfGems;
	}
	
	//Returnerar värdet på ett smycke
	public int getValueItem()
	{
		if(material.equalsIgnoreCase("yes"))
		{
			return (2000+(500*numberOfGems));
		}
		else
		{
			return (700+(500*numberOfGems));
		}
	}
}
