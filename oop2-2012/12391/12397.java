
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
	
	//Sätter ett aktievärde
	public void setValueStock(int newValueStock)
	{
		valueStock = newValueStock;
	}
	
	//Returnerar antalet aktier
	public int getNumberOfStocks()
	{
		return numberOfStocks;
	}
	
	//Returnerar värdet för en aktie
	public double getValueStock()//vill komma åt denna för börskraschen, men hur??
	{
		return valueStock;
	}
	
	//Returnerar aktieobjektets totala värde
	public int getValueItem()
	{
		return numberOfStocks*valueStock;
	}
}
