import java.io.Serializable;

public class Match implements Serializable{

	private String homeTeam;
	private String awayTeam;
	private int homeTeamGoals;
	private int awayTeamGoals;
	
	
	public Match (String homeTeam, String awayTeam, int homeTeamGoals, int awayTeamGoals){
	this.homeTeam = homeTeam;
	this.awayTeam = awayTeam;
	this.homeTeamGoals = homeTeamGoals;
	this.awayTeamGoals = awayTeamGoals;
	}
	
	public String getHomeTeam(){
	return homeTeam;
	}
	
	public String getAwayTeam(){
	return awayTeam;
	}
	
	public int getHomeTeamGoals(){
	return homeTeamGoals;
	}
	
	public int getAwayTeamGoals(){
	return awayTeamGoals;
	}
}