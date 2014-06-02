import java.util.InputMismatchException;
import java.util.Scanner;

public class Cylinder extends Block {
	private double _radius;
	private double _height;
	private Scanner in;

	Cylinder() {
		super();
		_radius = 0;
		_height = 0;
	}

	void setProperties() {
		super.setProperties();

		System.out.println();
		System.out.println("Cylinder specific information:");
		System.out.println("----------------------------------");
		try {
			System.out.println("Enter cylinder radius: ");
			in = new Scanner(System.in);
			_radius = in.nextDouble();
		} catch (InputMismatchException e) {
			System.out
					.println("Incorrect input. Default value for radius = 0 will be used.");
		}
		try {
			System.out.println("Enter cylinder height: ");
			in = new Scanner(System.in);
			_height = in.nextDouble();
		} catch (InputMismatchException e) {
			System.out
					.println("Incorrect input. Default value for height = 0 will be used.");
		}
	}

	double getVolume() {
		return Math.PI * Math.pow(_radius, 2) * _height;
	}

	double getMass() {
		return getVolume() * super.getDensity();
	}

	void printProperties() {
		super.printProperties();
		System.out.println("Cylinder information:");
		System.out.println("----------------------------------");
		System.out.println("Radius:      " + _radius);
		System.out.println("Height:      " + _height);
		System.out.println("Mass  :      " + getMass());
		System.out.println("Volume :     " + getVolume());
		System.out.println();
	}

}
