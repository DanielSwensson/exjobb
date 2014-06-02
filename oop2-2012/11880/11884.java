public abstract class Possession {
	private String possessionName;

	public Possession(String poNa) {
		possessionName = poNa;
	}

	public String getPossessionName() {
		return possessionName;
	}

	public abstract int getWorth();

}
