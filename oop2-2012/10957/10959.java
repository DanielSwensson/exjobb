
public class Apparat extends Prylar {
	
	
	private int ink�pspris;
	private int slitage;
	
	
public Apparat(String n, int ip, int s){
		super(n);	
		ink�pspris=ip;
		slitage=s; 
			
			
		}
public int getV�rde(){
	return (int) (ink�pspris*(1.0/10*slitage));
}
public String getPrylNamn(){
	return namn;
}

}
