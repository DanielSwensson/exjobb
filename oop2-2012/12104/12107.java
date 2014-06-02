class Smycke extends Vardesak {
	enum MetallSort {SILVER, GULD};

	private int antalÄdelstenar;
	private MetallSort metallSort;

	public Smycke(String namn, int antalÄdelstenar, MetallSort metallSort) {
		super(namn);

		setAntalÄdelstenar(antalÄdelstenar);
		setMetallSort(metallSort);
	}

	public int getVärde() {
		int värde = getAntalÄdelstenar() * 500;

		switch (getMetallSort()) {
			case SILVER: värde += 700; break;
			case GULD: värde += 2000; break;
		}

		return värde;
	}

	public int getAntalÄdelstenar() {
		return antalÄdelstenar;
	}

	public MetallSort getMetallSort() {
		return metallSort;
	}

	public void setAntalÄdelstenar(int antalÄdelstenar) {
		if (antalÄdelstenar < 0)
			throw new IllegalArgumentException();

		this.antalÄdelstenar = antalÄdelstenar;
	}

	public void setMetallSort(MetallSort metallSort) {
		this.metallSort = metallSort;
	}
}
