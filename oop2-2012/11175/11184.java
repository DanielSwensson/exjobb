
public class Race {
	
	private String race;
	private String faction;
	
	public Race(String race, String faction){
		this.race = race;
		this.faction = faction;
	}
	public Race(){
		
	}
	public String getFaction(){
		return faction;
	}
	public String getName(){
		return race;
	}
}
