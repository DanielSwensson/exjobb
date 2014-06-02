
public class Ingredient {
	
	private String name;
	private double amount; 
	private String unit;
	

	public void setName(String n){
		name = n.trim();
	}
	
	public void setAmount(double d){
		amount = d;
	}
	
	public void setUnit(String m){
		unit = m;
	}
	
	public String getName(){
		return name;
	}
	
	public double getAmount(){
		return amount;
	}
	
	public String getUnit(){
		return unit;
	}
	
	public void printIngredient(){
		
		if (amount == 0){
			System.out.println("\t\t\t" + getName());
			
		}else if (unit == null){
			System.out.println(getAmount() + "\t\t\t" + getName());
			
		}else{
			System.out.println(getAmount() + "\t" + getUnit() + "\t\t" + getName());
		}
	}
		
	public Ingredient(String n){
		setName(n);
	}
	
	public Ingredient(String s, double d, String t){
		setName(s);
		setAmount(d);
		setUnit(t);
	}


}