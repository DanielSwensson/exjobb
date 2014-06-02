
public class StrengthWorkout extends Workout{
	
	public StrengthWorkout(String name) {
		super(name);
	}

	public String toString(){
		String exerciseString = allExercises.get(0).toString();
		return "([" + today.getTime().toString() + "] [" + this.name + " | " + allExercises.size() + " Set av " + exerciseString + "] " + workoutResult.toString() + ")";
	}
}
