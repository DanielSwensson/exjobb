public class Smycke extends Pryl {
	private int antal€del;
	private int metall;
	private int value;
	
	public Smycke(String namn, int metall, int antal€del) {
		super(namn);
		this.metall = metall;
		this.antal€del = antal€del;
	}
	public int getantal€del() {
		return antal€del;
	}
	public int getmetall() {
		return metall;
	}
	public int getValue() {
		
		if (metall == 1) {

			value = 2000 + (antal€del * 500);
		} else if (metall == 2) {
			value = 700 + (antal€del * 500);
		}
		return value;
	}
}
