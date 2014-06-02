package inlupp2;

public class Jewelery extends Gadget{
	protected int gems;
	protected boolean gold; 
	protected static final int VALUEOFGOLD = 2000;
	protected static final int VALUEOFSILVER = 700;
	
	public Jewelery(String name, int ge, boolean gu){
		super(name);
		gems = ge;
		gold = gu;
	}
	
	public int value(){
		if(gold = true){
			return VALUEOFGOLD+(gems*500);
		}
		else{
			return VALUEOFSILVER+(gems*500);
		}
	}
	public String toString(){
		return getName() + "	" + value();
	}
	
}
