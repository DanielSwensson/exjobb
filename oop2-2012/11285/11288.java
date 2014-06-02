
public class Jewelry extends Item{
//	private int gems;
//	private boolean gold;
//	private boolean silver;
	
	public Jewelry(String name,boolean gold, boolean silver, int gems){
		this.name = name;
		if(gold==true){
			value+=2000;
		}else if(silver==true){
			value+=700;
		}
		value+= (gems*500);
	}
	
	public int getValue() {
		return value;
	}
	
}
