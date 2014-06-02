import java.util.ArrayList;

public class Individual{

	private String name;
	private ArrayList<Item> assets = new ArrayList<Item>();
	
	Individual(String name){
		this.name = name;
	}
	
	public void addAssets(Item item){
		assets.add(item);
	}
	
	public void listAssets(){
		for(int i = 0; i < assets.size(); i++){
                        System.out.println(assets.get(i).toString());
		}
	}
	

	
        public int getValueOfAssets(){
		
		int sum = 0;
		
		for(int i = 0; i < assets.size(); i++){
			
			sum += assets.get(i).marketValue;
		}

		return sum;
	}
	
	public String getName(){
		return this.name;
	}

        public ArrayList<Item> getAssets(){
            return this.assets;
        }
	
	public String toString(){
		return this.name;
	}
	
	
}