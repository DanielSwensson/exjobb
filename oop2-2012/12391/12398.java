
public class Apparatus extends Item
{
	private int purchasePrice;
	private int levelMintCondition;
	
	//Skapar ett apparatobjekt
	public Apparatus (String nameItem, int purchasePrice, int levelMintCondition)
	{
		super(nameItem);
		this.purchasePrice = purchasePrice;
		this.levelMintCondition = levelMintCondition;
		typeItem="apparatus";
	}
	
	//Returnerar ink�pspriset
	public int getPurchasePrice()
	{
		return purchasePrice;
	}
	
	//Returnerar skicket f�r apparaten
	public int getLevelMintCondition()
	{
		return levelMintCondition;
	}
	
	//Returnerar v�rdet p� apparaten
	public int getValueItem()
	{
		return purchasePrice*levelMintCondition/10;
	}
}
