
public abstract class Pryl { //abstract eftersom vi inte vill kunna skapa en pryl
	
	protected String namn; //protected s� att man kan s�tta v�rden p� prylen i subklasserna
	protected double v�rde;
	
	public abstract double getV�rde(); //abstract metod eftersom detta ber�knas olika hos alla prylar
	
	public abstract String getPrylSort(); 
	
	public String getNamn(){ //metod f�r att skriva ut namnet p� en pryl
		return namn;
	}
	
	
}
