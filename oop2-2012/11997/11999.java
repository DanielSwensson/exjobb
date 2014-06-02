package Inlupp2;

public class Shares extends Item{ 

	private int amountOfStocks;
	private int stockValue; 
	
	public Shares (String stockName, int amountOfStocks, int stockValue) {
	
		super (stockName); 
		this.stockValue = stockValue; 
		this.amountOfStocks = amountOfStocks; 
	
	}
	
	public int getAmountOfStocks() { 
		return amountOfStocks; 
	}

	public double getItemValue() {
		return amountOfStocks * stockValue; 
	}
	
	public void stockValue(int stockValue) {
		this.stockValue = stockValue; 
	}
	
		
}

		