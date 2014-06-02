public abstract class Prylar {
	private String namn;

	public String getNman() {
		return namn;
	}

	public abstract double getVarde();

	public Prylar(String namn) {
		this.namn = namn;
	}

}