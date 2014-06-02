
public class Jewelry extends Thing {
	private int iGem;
	private String sElement;
	
	public Jewelry(String sName,int iGems,String sElement){
		super(sName);
		if (iGems<0){
			this.iGem=0;
		}else{
			this.iGem = iGems;
		}
		this.sElement = sElement;
	}
	
	public int getValue(){
		if (getElement().equalsIgnoreCase("guld")||getElement().equalsIgnoreCase("gold")){
			return 2000+(500*getGems());
		}else if (getElement().equalsIgnoreCase("silver")){
			return 700+(500*getGems());
		}else{
			return -1;
		}
	}
	
	public int getGems(){
		return iGem;
	}
	public String getElement(){
		return sElement;
	}
}
