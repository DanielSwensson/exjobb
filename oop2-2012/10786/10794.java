
public class AMRAP extends Workout{
	private Time time;

	public AMRAP(String name, int min, int sec) {
		super(name);
		this.time = new Time(sec, min);
	}

	public String toString(){
		
		String exerciseString = "";
		for(Exercise currentExercise : allExercises){
			exerciseString = exerciseString + " " + currentExercise;
		}
		return "([" + today.getTime().toString() + "] " + " [" + this.name + " tid: " + time + " | " + exerciseString + "] " + workoutResult.toString() + ")";
	}
	
}
