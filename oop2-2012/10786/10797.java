public class ForTime extends Workout{
	
	public ForTime(String name) {
		super(name);
	}
	
	public String toString(){
		
		String exerciseString = "";
		for(Exercise currentExercise : allExercises){
			exerciseString = exerciseString + " " + currentExercise;
		}
		return "([" + today.getTime().toString() + "] [" + this.name + exerciseString + "] " + workoutResult.toString() + ")";
	}
}