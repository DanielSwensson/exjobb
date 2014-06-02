package Inlupp2;

public class Jewelery extends Item{ 
	
	private int goldMaterial;
	private int amountOfStones; 
	
	public Jewelery (String typeOfJewelery, int goldMaterial, int amountOfStones) {
		
		super (typeOfJewelery);  
		this.goldMaterial = goldMaterial; 
		this.amountOfStones = amountOfStones; 
		
	}
	
	public double getItemValue() {
		return (amountOfStones * 500) + goldMaterial ;  
				
	}

}