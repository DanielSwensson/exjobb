public class Jewelry extends Valuable{
	private double weight = 0;
	private String type = ""; 
	private int stones = 0; 
	private double value = 0; 
	private double silverValue = 10;
	private double goldValue = 20;
	private double otherValue = 5;
	private double stoneValue = 500;
	
	public Jewelry(String n, double w, String t, int s){
		this.setName(n);
		this.weight=w;
		this.type=t;	
		this.stones=s;
		this.setValue();
	}

	public void setWeight(double w){
		this.weight = w;
	}

	public void setType(String t){
		this.type=t;
	}

	public void setValue(){
		if(type.equals("silver")){
			this.value = silverValue*weight+stones*stoneValue;
			
		}
		
		else if(type.equals("gold")){
			this.value = goldValue*weight+stones*stoneValue;
			}
	
		else{
			this.value=otherValue*weight+stones*stoneValue;
		}
		
	}

	public void setStones(int s){
		this.stones=s;
	}

	public void setSilverValue(double v){
		this.silverValue = v;
	}

	public void setGoldValue(double v){
		this.goldValue = v;
	}

	public void setOtherValue(double v){
		this.otherValue = v;
	}

	public void setStoneValue(double v){
		this.stoneValue = v;
	}

	public double getWeight(){
		return weight;
	}	

	public String getType(){
		return type;
	} 

	public int getStones(){
		return stones;
	}

	public double getValue(){
		return value; 
	}


}


