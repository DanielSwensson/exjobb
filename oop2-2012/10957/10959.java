
public class Apparat extends Prylar {
	
	
	private int inkšpspris;
	private int slitage;
	
	
public Apparat(String n, int ip, int s){
		super(n);	
		inkšpspris=ip;
		slitage=s; 
			
			
		}
public int getVŠrde(){
	return (int) (inkšpspris*(1.0/10*slitage));
}
public String getPrylNamn(){
	return namn;
}

}
