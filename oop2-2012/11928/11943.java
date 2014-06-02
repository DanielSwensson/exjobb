

public class WeightRecomendation {
	private double bmi;
	private double idealWeight;
	
	public WeightRecomendation(Weight weight, Height height) {
		setBmi(weight,height);
		calculateIdealWeight(height.getHeightInM(), height.getHeightInCm(), weight.getWeightInKG());

	}
	
	private void setBmi(Weight weight, Height height){
		this.bmi = calculateBMI(height.getHeightInM(), weight.getWeightInKG());
		this.bmi = Math.round(bmi*100)/100.0;
	}
	
	private double calculateBMI(double height, double weight) {
		double currentBmi =  weight / (height * height) ;
		return currentBmi;
	}  
	
	private double calculateIdealWeight(double currentHeightInMeters, int currentHeightInCm, double currentWeightInKg  ){
		if (this.bmi>25){
			this.idealWeight = 25 * (currentHeightInMeters * currentHeightInMeters);
			idealWeight = Math.round(idealWeight * 10) / 10.0;

		}else if (this.bmi>18 && this.bmi<25){
			this.idealWeight = currentWeightInKg;
		}
		else if (this.bmi<18){
			this.idealWeight = 18 * (currentHeightInMeters * currentHeightInMeters);
			idealWeight = Math.round(idealWeight * 10) / 10.0;

		}
		
		return idealWeight;
	}
	
	public String toString(){
		String returnString =
			"BMI: " + this.bmi + 
			"\n   " + "Ideal weight: " + this.idealWeight + "kg"
			;
		return returnString;
	}
	  
}
