
public class Stock extends Thing {
	private int iQuantity;
	
	public Stock(String sName,int iValue,int iQuantity){
		super(sName,iValue);
		if (iQuantity<1){
			this.iQuantity = 1;
		}else{
			this.iQuantity = iQuantity;
		}
	}
	
	public int getValue(){
		if (super.getValue()*getQuantity()<0){
			return 0;
		}else{
			return super.getValue()*getQuantity();
		}
	}
	
	public int getQuantity(){
		return iQuantity;
	}
}
