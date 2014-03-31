public class Apparat extends Pryl{
	private int slitage;
	private int kostnad;
	
	public Apparat(String prylTyp, int s, int k){
		super(prylTyp);
		slitage = s;
		kostnad = k;
	}
	
	public int getVŠrde(){
		
			return kostnad * slitage/10;
		}

	
}
