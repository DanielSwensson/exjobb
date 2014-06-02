
class Debt extends Thing {
	private String name;
	private int debtSum;	
	
	public Debt(int debtSum){
		name=("Skuld");
		this.debtSum=debtSum;

	}
	public String getName(){
		return name;
	}
	

	public int worth() {

			return debtSum*(-1);
		
		
	}

	public String name() {
		return name;
	}
	
}
