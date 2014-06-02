public class Personer {

	private String namn;
	private double totalvärde;
	public String taBort;

	public Personer (String n, double tv) {
		namn = n;
		totalvärde = tv;

	}
	public double getPersonVärde() {
		return totalvärde;
	}
	public double getTotalVärde(double x) {
		totalvärde = x;
		return totalvärde;					
	}

	public String getNamn(){
		return namn;
	}	


}
