public class Personer {

	private String namn;
	private double totalv�rde;
	public String taBort;

	public Personer (String n, double tv) {
		namn = n;
		totalv�rde = tv;

	}
	public double getPersonV�rde() {
		return totalv�rde;
	}
	public double getTotalV�rde(double x) {
		totalv�rde = x;
		return totalv�rde;					
	}

	public String getNamn(){
		return namn;
	}	


}
