
public class Aktie extends Prylar{
public Aktie (String namn,int antal,int pris){
	super(namn);
	this.antal=antal;
	this.pris=pris;
}
	
private int antal;
private int pris;
 
public int värde(){
	return antal * pris;
}

public void setPris(int pris)
{
	this.pris = pris;
}



}
