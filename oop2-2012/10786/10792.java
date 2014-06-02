import java.util.ArrayList;
import java.util.Calendar;

//Lägg till möjlighet att se sammanlagda antal övningar.

public abstract class Workout {	
	protected Calendar today = Calendar.getInstance();
	protected String name;
	protected WorkoutResult workoutResult;
	protected ArrayList<Exercise> allExercises = new ArrayList<Exercise>();

	public Workout(String name){
		this.name = name;
	}
	
	public void setWorkoutResult(WorkoutResult workoutResult){
		this.workoutResult = workoutResult;
	}
	
	public void Add(Exercise exercise){
		allExercises.add(exercise);
	}
	
}
