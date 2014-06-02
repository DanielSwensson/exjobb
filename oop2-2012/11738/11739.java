package Demo01;


class Device extends Merchandise{
	private int purchasePrice;
	private int wear;
	
	
	public Device(String merchandiseName,String type,int purchasePrice, int wear){
		super(merchandiseName,type);
		this.purchasePrice = purchasePrice;
		this.wear = wear;
	}

	public int getValue(){
		return purchasePrice*wear/10;
	}


}
