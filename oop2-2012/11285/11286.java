
public class Device extends Item{
//	private double wear;
	
	public Device(String name, int wear, int price){
		this.name = name;
		if(wear>10){
			wear = 10;
		}else if(wear<1){
			wear = 1;
		}
		value =(int)((double)price * ( wear / 10.0 ));
	}
	
	public int getValue() {
		return value;
	}
	
}
