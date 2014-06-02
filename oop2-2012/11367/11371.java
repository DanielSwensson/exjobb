public abstract class Pryl {

	private String namn;

	abstract public int värde();

	public void börskrasch() {
	}

	public String getNamn(){
		return namn;
	}
	
	public Pryl(String namn) {
		this.namn = namn;
	}

}