public abstract class Pryl {

	private String namn;

	abstract public int v�rde();

	public void b�rskrasch() {
	}

	public String getNamn(){
		return namn;
	}
	
	public Pryl(String namn) {
		this.namn = namn;
	}

}