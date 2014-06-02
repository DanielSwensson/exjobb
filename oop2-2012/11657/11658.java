
public class Gadget extends Item {
	
	private int gadgetOrigValue;
	private int gadgetDecay;
	
	public Gadget (String gadgetName, int gadgetOrigValue, int gadgetDecay){
		super (gadgetName);
		this.gadgetOrigValue = gadgetOrigValue;
		this.gadgetDecay = gadgetDecay; 
	}
	
	public int getOrigValue(){
		return gadgetOrigValue;
	}
	
	public int getDecay(){
		return gadgetDecay;
	}
	
	public int getValue(){
		return gadgetOrigValue * gadgetDecay / 10;
	}
	
}
