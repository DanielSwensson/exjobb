class Apparat extends Pryl{

	private int slitage;
	private double pris;

	public Apparat(String pN, Person o, double p, int s){

		super(pN, o);
		pris = p;
		slitage = s;

	}

	public int getValue(){

		double v;

		if(slitage==9){
			v = 0.9;
		}
		else if(slitage==8){
			v = 0.8;
		}
		else if(slitage==7){
			v = 0.7;
		}
		else if(slitage==6){
			v = 0.6;
		}
		else if(slitage==5){
			v = 0.5;
		}
		else if(slitage==4){
			v = 0.4;
		}
		else if(slitage==3){
			v = 0.3;
		}
		else if(slitage==2){
			v = 0.2;
		}
		else if(slitage==1){
			v = 0.1;
		}
		else
		//oförändrat pris vid 0 slitage.
			v = 1;


		double result = pris * v;
		int value = (int)result;
		return value;

	}


	public void setSlitage(int s){

		slitage = s;

	}

}//class