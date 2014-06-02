public class BigImpactCards {
	private String name;
	private int win;
	private int loss;
	private int tie;
	public BigImpactCards(String str, int x1, int x2, int x3){
		this.name = str;
		this.win = x1;
		this.loss = x2;
		this.tie = x3;
	}
	public String toString(){
		return name + " GP" + getGamesPlayed() + " " + win + "W " + tie + "T " + loss + "L" + " W% " + getWinRate();
	}
	public int getWins(){
		return win;
	}
	public int getTies(){
		return tie;
	}
	public int getLosses(){
		return loss;
	}
	public String getName(){
		return name;
	}
	public void addWin(){
		win ++;
	}
	public void addTie(){
		tie ++;
	}
	public void addLoss(){
		loss ++;
	}
	
	// Räknar ut win rate
	
	public double getWinRate(){
		if(getGamesPlayed() == 0 || win == 0){
			double winRate = 0;
			return winRate;
		}
		int winsHundred = win*100;
		double winRate = winsHundred / getGamesPlayed();
		return winRate;
	}
	
	// Räknar ut antal spelade matcher
	
	public int getGamesPlayed(){
		int gamesPlayed = win + tie +loss;
		return gamesPlayed;
	}
}
