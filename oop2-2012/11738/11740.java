package Demo01;

 class Jewelery extends Merchandise {
	 private int amountOfGems;
	 private int temp;
	 

	public Jewelery(String merchandiseName,String type, int amountOfGems,String jeweleryMaterial ) {
		super(merchandiseName,type);		
		this.amountOfGems = amountOfGems;
		if(jeweleryMaterial.equalsIgnoreCase("guld")){
        	temp=2000;
        }
        else if(jeweleryMaterial.equalsIgnoreCase("Silver")){
        	temp=700;
       
        }
	}

	public int getValue(){
		return amountOfGems*500+temp;
	}

 
 }


