

import java.io.Serializable;

@SuppressWarnings("serial")
public class Height implements Serializable{
	private int heightInCm;
	private double heightInM;

	public Height(int heightInCm){
		this.heightInCm =heightInCm;
		calculateHeightInM();
	}
	public Height(double heightInM){
		this.heightInM =heightInM;
		calculateHeightInCm();
	}
	public int getHeightInCm(){
		return heightInCm;
	}
	public double getHeightInM(){
		return heightInM;
	}

	private void calculateHeightInM(){
		this.heightInM = heightInCm / 100.0;
	}
	private void calculateHeightInCm(){
		this.heightInCm =  (int) (heightInM * 100);
	}
	public String toString(){
		return "Height:" + this.heightInM;
	}
}
