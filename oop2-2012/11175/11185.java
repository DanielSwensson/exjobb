
public class Spec {
	
	private String name;
	private int maxSpecDps;

	private static final String[] specs = {"fire", "arcane", "arms", "fury", "survival", "beastmastery", "balance", "feral"};
	private static final int[] dps = {88900, 113000, 74600, 100600, 88000, 95600, 93000, 84000};
	
	public Spec(String name){
		this.name = name;
		maxSpecDps = getSpecDps();
	}
	public Spec(){
		
	}
	private int getSpecDps(){
		for(int i=0 ; i<specs.length; i++) {
			if(specs[i].equalsIgnoreCase(name)) {
				return dps[i];
			}
		}
		System.out.println("Not found.");
		return 0;
	}
	public String getName(){
		return name;
	}
	public int getMaxSpecDps(){
		return maxSpecDps;
	}
	public int getDpsConstant(int position){
		return dps[position];
	}
	
		
}
