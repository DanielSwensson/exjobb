package simpleMonopoly;

// Superklass f�r alls rutor som skapas. Har attributet namn (name).
abstract class Square {

	private String name;

	Square(String name) {
		this.name = name;
	}

	// Metod som returnerar str�ngen name.
	public String getName() {
		return name;
	}

	// Nedan f�ljer default-metoder som alla �verskuggas av subklasser. Dessa
	// anropas ej i programmet.

	public int getRent() {
		return 0;
	}

	public boolean getOwnedBoolean() {
		return false;
	}

	public int getBuyPrice() {
		return 0;
	}

	public void setOwner(int ID) {
		return;
	}

	public int getOwner() {
		return 0;
	}

	public int getTax() {
		return 0;
	}

	// Metod som anropas n�r man hamnar p� en rut som inte �r en gata.
	public String getColor() {
		return "None";
	}

}

// Klassen f�r alla rutor som inte g�r att k�pa t.ex. f�ngelset och G�.
class Misc extends Square {

	// Int som anv�nds av skatterutorna.
	private int tax;

	Misc(String name) {

		super(name);

	}

	// Skatterutornas konstruktor.
	Misc(String name, int tax) {
		super(name);
		this.tax = tax;
	}

	// Metoden som returnerar integern tax n�r man ska betala skatt.
	public int getTax() {

		return tax;
	}

}

// Superklassen f�r alla rutor som g�r att k�pa. Subklass till Square.
abstract class Property extends Square {

	// Owner �r 0 om ingen �ger rutan. Vid k�p s�tts Owner till spelarens ID.
	private int owner;
	private int rent;
	private int buyPrice;

	Property(String name, int rent, int buyPrice) {
		super(name);
		this.rent = rent;
		this.buyPrice = buyPrice;
	}

	// Nedan f�ljer metoder som anropas f�r att returnera integers som finns i
	// denna klass samt den metod som s�tter owner till spelarens ID.

	public int getRent() {

		return this.rent;

	}

	public int getBuyPrice() {
		return this.buyPrice;
	}

	public void setOwner(int ID) {
		owner = ID;
		return;
	}

	public int getOwner() {
		return owner;
	}
}

// Klassen f�r alla gatorna.
class Street extends Property {

	// Anv�nds endast f�r orientering i denna version.
	private String color;

	Street(String name, int rent, int buyPrice, String color) {
		super(name, rent, buyPrice);
		this.color = color;
	}

	public String getColor() {
		return color;
	}

}

// Klassen f�r j�rnv�gar, vattenverket, och elverket.
class Other extends Property {

	Other(String name, int rent, int buyPrice) {
		super(name, rent, buyPrice);

	}

	// Returnerar hyran f�r x-verket. Den �r totalRoll multiplicerat med 4. Om
	// b�da �gs av samma person skall totalRoll egentligen multipliceras med 10
	// men detta finns ej implementerat i denna version.
	public int getRent() {
		return PlayGame.totalRoll * 4;
	}
}
