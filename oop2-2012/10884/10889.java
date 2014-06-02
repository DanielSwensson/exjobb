import java.util.ArrayList;

public class Person{

	private String name;
	private ArrayList<Pryl> stuff = new ArrayList<Pryl>();
	
	Person(String name){
		this.name = name;
	}
	
	public void addStuff(Pryl item){
		stuff.add(item);
	}
	
	public void listStuff(){
		for(int i = 0; i < stuff.size(); i++){
                        System.out.println(stuff.get(i).toString());
		}
	}
	
	
	
        public int getValueOfStuff(){
		
		int sum = 0;
		
		for(int i = 0; i < stuff.size(); i++){
			
			sum += stuff.get(i).marketValue;
		}

		return sum;
	}
	
	public String getName(){
		return this.name;
	}

        public ArrayList<Pryl> getStuff(){
            return this.stuff;
        }
	
	public String toString(){
		return this.name;
	}
	
	
}