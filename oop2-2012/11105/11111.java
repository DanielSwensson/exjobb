
public class Food extends Item{
	private int foodValue;
	
	public Food(String name, int foodValue){
		super(name);
		this.foodValue = foodValue;	
	}
	
	public int getFoodValue(){
		return foodValue;
	}
	
	public void setFoodValue(int foodValue){
		this.foodValue = foodValue;
	}
}