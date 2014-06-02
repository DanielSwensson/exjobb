class Smycke extends Pryl {

	private String smyckesMaterialGuld;
	private int antalAdelstenar;
	private int smyckesVarde;

	public Smycke(String prylSort, String smyckesNamn,
			String smyckesMaterialGuld, int antalAdelstenar) {

		super(prylSort, smyckesNamn);
		this.smyckesMaterialGuld = smyckesMaterialGuld;
		this.antalAdelstenar = antalAdelstenar;
	}

	public int getVarde() {
		if (smyckesMaterialGuld.equalsIgnoreCase("ja")
				|| smyckesMaterialGuld.equalsIgnoreCase("j")) {
			smyckesVarde = 2000 + (500 * antalAdelstenar);
		} else {
			smyckesVarde = 700 + (500 * antalAdelstenar);
		}
		return smyckesVarde;
	}

}
