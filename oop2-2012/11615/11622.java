package valuables;

public abstract class Valuable {
	private final String name;

	public Valuable(String name) {
		this.name = name;
	}

	public abstract int getValue();

	public String getName() {
		return name;
	}

}
