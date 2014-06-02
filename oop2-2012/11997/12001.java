package Inlupp2;

public class Appliances extends Item{
	
	private int applianceValue;
	private double wear;  
	
	public Appliances (String applianceName, int applianceValue, int wear) {
	 
		super (applianceName);  
		this.applianceValue = applianceValue;
		this.wear = wear;
	
	}
	
		public int getApplianceValue(){
			return applianceValue; 
	}
		
		public double getWear() {
			return wear; 
	}
		
		public double getItemValue() {
			return (applianceValue * (wear / 10)); 
		}

}
