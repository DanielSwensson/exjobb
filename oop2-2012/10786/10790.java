

public class Tabata extends Workout{
	private Time work;
	private Time rest;
	
	public Tabata(String name, int workMin, int workSec, int restMin, int restSec) {
		super(name);
		this.work = new Time(workSec, workMin);
		this.rest = new Time(restSec, restMin);
	}


	public String toString(){
		
		String exerciseString = "";
		for(Exercise currentExercise : allExercises){
			exerciseString = exerciseString + " " + currentExercise.getName();
		}
		return "([" + today.getTime().toString() + "] " + "[" + this.name + " Jobba " + work + " Vila " + rest + "|" + exerciseString + "] " + workoutResult.toString() + ")";
	}
	
}
