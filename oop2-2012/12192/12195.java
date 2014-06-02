public class Spelare {

	private String namn;
	private int highscorePoints;
	
	public Spelare(String n, int h) {
		this.namn = n;
		this.highscorePoints = h;
	}
	
	public int getHighscorePoints() {
		return highscorePoints;
	}
	
	public String getNamn() {
		return namn;
	}
	public String toString() {
		String str = "Namn: "+namn+ ", Poäng: " + highscorePoints;
		return str;
}
}
