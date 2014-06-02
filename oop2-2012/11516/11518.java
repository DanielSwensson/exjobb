import java.util.InputMismatchException;
import java.util.Scanner;

public class Cuboid extends Block {
	private double _lenght;
	private double _width;
	private double _height;
	private Scanner in;

	Cuboid() {
		super();
		_lenght = 0;
		_width = 0;
		_height = 0;
	}

	void setProperties() {
		super.setProperties();

		System.out.println();
		System.out.println("Cuboid specific information:");
		System.out.println("----------------------------------");
		try {
			System.out.println("Enter cuboid lenght: ");
			in = new Scanner(System.in);
			_lenght = in.nextDouble();
		} catch (InputMismatchException e) {
			System.out
					.println("Incorrect input. Default value for lenght = 0 will be used.");
		}
		
		try {
			System.out.println("Enter cuboid widtht: ");
			in = new Scanner(System.in);
			_width = in.nextDouble();
		} catch (InputMismatchException e) {
			System.out
					.println("Incorrect input. Default value for width = 0 will be used.");
		}
		
		try {
			System.out.println("Enter cuboid height: ");
			in = new Scanner(System.in);
			_height = in.nextDouble();
		} catch (InputMismatchException e) {
			System.out
					.println("Incorrect input. Default value for height = 0 will be used.");
		}


	}

	double getVolume() {
		return _lenght * _width * _height;
	}

	double getMass() {
		return getVolume() * super.getDensity();
	}

	void printProperties() {
		super.printProperties();

		System.out.println("Cuboid information:");
		System.out.println("----------------------------------");
		System.out.println("Lenght:      " + _lenght);
		System.out.println("Widht:       " + _width);
		System.out.println("Height:      " + _height);
		System.out.println("Mass  :      " + getMass());
		System.out.println("Volume :     " + getVolume());
		System.out.println();
	}
}
