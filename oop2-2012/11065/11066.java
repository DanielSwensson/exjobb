
public class Device extends Thing {
	private int iWear;
	
	public Device(String sName,int iValue,int iWear){
		super(sName,iValue);
		if (iWear>10){
			this.iWear = 10;
		}else if(iWear<1){
			this.iWear = 1;
		}else{
			this.iWear = iWear;
		}
	}
	
	public int getWear(){
		return iWear;
	}
	public int getValue(){
		return super.getValue()*getWear()/10;
	}
}

