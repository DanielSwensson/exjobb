package Demo01;

public abstract class Merchandise {
	private String merchandiseName;
	private String type;

	public Merchandise(String merchandiseName, String type) {
		this.setMerchandiseName(merchandiseName);
		this.type = type;
	}


	public abstract int getValue();


	public String toString() {
		return type + ", värde:" + getValue() + ",";
	}


	public String getMerchandiseName() {
		return merchandiseName;
	}


	public void setMerchandiseName(String merchandiseName) {
		this.merchandiseName = merchandiseName;
	}

}
