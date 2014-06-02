
public class Jewelry extends Thing {
	
	private int stoneNumber, metal;
	
	public Jewelry (String n, int sn, int m){
		super(n);
		this.stoneNumber=sn;
		this.metal=m;
	}
	
	public int getStoneNumber(){
		return stoneNumber;
	}
	
	public int getMetal(){
		return metal;
	}
	
	public int getSum(){
		return (metal + (stoneNumber*500));
	}
	

}
