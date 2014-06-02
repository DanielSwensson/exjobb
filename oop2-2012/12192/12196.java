
public class SpelareEasyMode extends Spelare {
private String s;
	public SpelareEasyMode(String n, int h, String status) {
		super(n, h);
		this.s = status;
	}
	public String toString() {
		String str = "Namn: "+ getNamn() + ", Poäng: " + getHighscorePoints() + " >" + s + "<";
		return str;
}
}
