import java.util.ArrayList;



public class Person {
	private String name;
	private ArrayList<Workout> completedWorkouts = new ArrayList<Workout>();
	
	public Person(String name){
		this.name = name;	
	}
	
	public void Add(Workout workout){
		completedWorkouts.add(workout);
		}
	
	public void Remove(int index){
		this.completedWorkouts.remove(index);
	}
	
	public String toString(){
		String workoutString = "";
		Integer i = 1;
		for(Workout currentWorkout : completedWorkouts){
			workoutString += i.toString() + currentWorkout + "\n";
			i++;
		}
		return this.name + " " + workoutString;	
	}
	public String getName(){
		return this.name;
	}

}
