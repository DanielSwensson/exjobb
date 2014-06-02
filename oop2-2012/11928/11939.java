import java.util.ArrayList;


public class User{
	private int age;
	private String name;
	private Height height;
	private Weight weight;
	private double strideLength;
	private WeightRecomendation weightRecomendation;
	private boolean isComplete;
	public ArrayList<Session> sessions = new ArrayList<Session>();
	public Session currentSession;
	

	public User (String name){
		this.name = name;
		this.age = Io.getNumber("Please enter your age");
	}
	public User(String name, int age){
		this.name = name;
		this.age = age;
	}

	public User(String name, int age, Weight weight, Height height){
		this.name = name;
		this.age = age;
		this.weight  = weight;
		this.height = height;
		setEnabled();
	}
	public void calculateStrideLength(){
		strideLength = getHeight().getHeightInM() * 0.4;
	}
	public String getName(){
		return name;
	}
	public int getAge(){
		return age;
	}
	public Height getHeight(){
		return height;
	}
	public double getStrideLength() {
		return strideLength;
	}
	public Weight getWeight(){
		return weight;
	}
	public void setHeight(Height newHeight){
		this.height = newHeight;
	}
	public void setWeight(Weight newWeight){
		this.weight = newWeight;
		
	}
	public void setStrideLength(double strideLength) {
		this.strideLength = strideLength;
	}
	public boolean isEnabled() {
		return isComplete;
	}
	public void setEnabled() {
		if (height != null && weight != null){
			isComplete = true;
			weightRecomendation = new WeightRecomendation(weight, height);
			System.out.println("User is completed");

		}
		else {
			System.out.println("User can't be completed until both height and weight is added");
		}
	}

	public String toString(){
		String returnString ="";
		returnString = returnString + "\nName:" + name;
		returnString = returnString + "\n   Age:" + age;
		if (weight != null){
			returnString = returnString +"\n   " +  weight;
		}
		if (height != null){
			returnString = returnString +"\n   " + height;
		}
		if (isComplete == false){
			returnString = returnString + "\n   Status: not completed";
		}
		else if (isComplete == true ){
			returnString = returnString + "\n   " + weightRecomendation;	
		}

		
		return  returnString; 
	}	
	
}
