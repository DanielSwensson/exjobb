package simpleMonopoly;

// Superklass för alls rutor som skapas. Har attributet namn (name).
abstract class Square {

	private String name;

	Square(String name) {
		this.name = name;
	}

	// Metod som returnerar strängen name.
	public String getName() {
		return name;
	}

	// Nedan följer default-metoder som alla överskuggas av subklasser. Dessa
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

	// Metod som anropas när man hamnar på en rut som inte är en gata.
	public String getColor() {
		return "None";
	}

}

// Klassen för alla rutor som inte går att köpa t.ex. fängelset och Gå.
class Misc extends Square {

	// Int som används av skatterutorna.
	private int tax;

	Misc(String name) {

		super(name);

	}

	// Skatterutornas konstruktor.
	Misc(String name, int tax) {
		super(name);
		this.tax = tax;
	}

	// Metoden som returnerar integern tax när man ska betala skatt.
	public int getTax() {

		return tax;
	}

}

// Superklassen för alla rutor som går att köpa. Subklass till Square.
abstract class Property extends Square {

	// Owner är 0 om ingen äger rutan. Vid köp sätts Owner till spelarens ID.
	private int owner;
	private int rent;
	private int buyPrice;

	Property(String name, int rent, int buyPrice) {
		super(name);
		this.rent = rent;
		this.buyPrice = buyPrice;
	}

	// Nedan följer metoder som anropas för att returnera integers som finns i
	// denna klass samt den metod som sätter owner till spelarens ID.

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

// Klassen för alla gatorna.
class Street extends Property {

	// Används endast för orientering i denna version.
	private String color;

	Street(String name, int rent, int buyPrice, String color) {
		super(name, rent, buyPrice);
		this.color = color;
	}

	public String getColor() {
		return color;
	}

}

// Klassen för järnvägar, vattenverket, och elverket.
class Other extends Property {

	Other(String name, int rent, int buyPrice) {
		super(name, rent, buyPrice);

	}

	// Returnerar hyran för x-verket. Den är totalRoll multiplicerat med 4. Om
	// båda ägs av samma person skall totalRoll egentligen multipliceras med 10
	// men detta finns ej implementerat i denna version.
	public int getRent() {
		return PlayGame.totalRoll * 4;
	}
}
