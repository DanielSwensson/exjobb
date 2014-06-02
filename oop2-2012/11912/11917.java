
public abstract class Pryl {

	abstract public int varde();
	private String namn;

	Pryl(String namn) {
		this.namn = namn;
	}

	public String getNamn(){
		return namn;
	}
}
