
import java.util.ArrayList;

abstract class Pryl {

	ArrayList<Pryl> Prylar = new ArrayList <Pryl>();
	private String pryl;

	public Pryl(String pryl){
		this.pryl = pryl;
	}

	public String getPryl(){
		return pryl;
	}

	public abstract double getVarde();
}