
public class Stock extends Item
{
	private int numberOfStocks;
	protected int valueStock;
	
	//Skapar ett aktieobjekt
	public Stock (String nameItem, int numberOfStocks, int valueStock)
	{
		super(nameItem);
		this.numberOfStocks = numberOfStocks;
		this.valueStock = valueStock;
		typeItem="stock";
	}
	
	//S�tter ett aktiev�rde
	public void setValueStock(int newValueStock)
	{
		valueStock = newValueStock;
	}
	
	//Returnerar antalet aktier
	public int getNumberOfStocks()
	{
		return numberOfStocks;
	}
	
	//Returnerar v�rdet f�r en aktie
	public double getValueStock()//vill komma �t denna f�r b�rskraschen, men hur??
	{
		return valueStock;
	}
	
	//Returnerar aktieobjektets totala v�rde
	public int getValueItem()
	{
		return numberOfStocks*valueStock;
	}
}
