import java.util.ArrayList;

public class Person{

	private String name = "";
	private double wealth = 0;
	private ArrayList<Valuable> valuablesRegister =new ArrayList<Valuable>();
	

	public Person(String n){
		this.name=n;
	
	}
	public void setName(String n){
		this.name = n;
	}

	public void estimateWealth(){	
		
	
	} 
	public double getWealth(){
		this.wealth = 0;
		for(Valuable v: valuablesRegister){
			double w = v.getValue();
			this.wealth = this.wealth + w;	
		}	
		return wealth;
	}

	public void addDevice(String n, int w, double s){
		this.valuablesRegister.add(new Device(n,w,s));	

	}
	
	public void addStock(String n, double v, int a){
		this.valuablesRegister.add(new Stock(n, v, a));
	
	}

	public void addJewelry(String n, double w,String t, int s){
		this.valuablesRegister.add(new Jewelry(n, w, t, s));
	
	}

	public void stockCrash(){
		for(Valuable v:valuablesRegister){
			if(v instanceof Stock){
			((Stock)v).setValue(0);
			} 
		}
	}

	public String getName(){
		return this.name;
	}

	public void printValList(){
		System.out.println(this.name + " owns the following valuables");
		for(Valuable v : valuablesRegister){
			System.out.println(v.getName()+"\t"+v.getValue());
		}
	
	}

}
