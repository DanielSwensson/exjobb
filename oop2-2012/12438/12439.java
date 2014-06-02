import java.util.ArrayList;



public class Person {

	private ArrayList<Thing> allThings = new ArrayList<Thing>(); 

	private String name;

	public Person(String name) { 
		
		this.name = name;
	}
	
	public void personAndValue(){
		
		System.out.println(getName() + "\t" + getPersonValue());
	}

	public int getPersonValue(){
		
		int personValue = 0;
		for(Thing thing : allThings){

			personValue =personValue+ thing.getValue(); 
		}
		return personValue;
	}

	public String getName() {
		
		return name;
	}

	public void addThing(Thing thing){
		
		allThings.add(thing);
	}

	public void smCrashPerson() {
		
		for(Thing things:allThings){
			if(things instanceof Shares){
				((Shares) things).smCrash();
			}
		}

	}

	public void personThings(Person person) {
	
		String output = "";
		for(Thing p : allThings){
			output += p.getThingName() + "\t" + p.getValue() + "\n";
		}
		System.out.println(output);

	}




}
