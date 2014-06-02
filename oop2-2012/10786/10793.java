
public class WorkoutResult {
	private int doneReps;
	private int doneSets;
	private Time result;
	private String outputString;
	
	
	public WorkoutResult(Time time, int doneSets, int doneReps){
		this.result = time;
		this.doneSets = doneSets;
		this.doneReps = doneReps;
	}
	public WorkoutResult(int doneSets, int doneReps){
		this.doneSets = doneSets;
		this.doneReps = doneReps;
		this.outputString = "[" + doneSets + " varv och " + doneReps + " repititioner." + "]";
	}
	public WorkoutResult(Time time){
		this.result = time;
		this.outputString = "[Avklarat på " + this.result + "]";
	}
	
	public String toString(){
		return outputString;
	}
	
}