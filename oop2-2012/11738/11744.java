package Demo01;

 class Share extends Merchandise {
	 private int amountOFShareHolding;
	 private int sharePrice;
	 public Share(String merchandiseName,String type,int amountOFShareHolding,int sharePrice){
		 super(merchandiseName,type);
		 this.amountOFShareHolding = amountOFShareHolding;
		 this.sharePrice = sharePrice;
	 }


	 public int getValue(){
		 return amountOFShareHolding*sharePrice;
		 
	 }
	 public void stockMarketCrash(){
		 sharePrice=0;
	 }
}
