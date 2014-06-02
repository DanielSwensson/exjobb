
public abstract class Thing {
	private String sName;
	private int iValue;
	
	public Thing(String sName,int iValue){
		this.sName = sName;
		if (iValue<0){
			this.iValue=0;
		}else{
			this.iValue = iValue;
		}
	}
	public Thing(String sName){
		this.sName = sName;
	}
	public String getName(){
		return sName;
	}
	public int getValue(){
		return iValue;
	}
	public void setValueZero(){
		iValue = 0;
	}
}
