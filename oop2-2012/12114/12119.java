
public abstract class Pryl { //abstract eftersom vi inte vill kunna skapa en pryl
	
	protected String namn; //protected så att man kan sätta värden på prylen i subklasserna
	protected double värde;
	
	public abstract double getVärde(); //abstract metod eftersom detta beräknas olika hos alla prylar
	
	public abstract String getPrylSort(); 
	
	public String getNamn(){ //metod för att skriva ut namnet på en pryl
		return namn;
	}
	
	
}
