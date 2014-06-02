class Smycke extends Vardesak {
	enum MetallSort {SILVER, GULD};

	private int antal�delstenar;
	private MetallSort metallSort;

	public Smycke(String namn, int antal�delstenar, MetallSort metallSort) {
		super(namn);

		setAntal�delstenar(antal�delstenar);
		setMetallSort(metallSort);
	}

	public int getV�rde() {
		int v�rde = getAntal�delstenar() * 500;

		switch (getMetallSort()) {
			case SILVER: v�rde += 700; break;
			case GULD: v�rde += 2000; break;
		}

		return v�rde;
	}

	public int getAntal�delstenar() {
		return antal�delstenar;
	}

	public MetallSort getMetallSort() {
		return metallSort;
	}

	public void setAntal�delstenar(int antal�delstenar) {
		if (antal�delstenar < 0)
			throw new IllegalArgumentException();

		this.antal�delstenar = antal�delstenar;
	}

	public void setMetallSort(MetallSort metallSort) {
		this.metallSort = metallSort;
	}
}
