import java.util.InputMismatchException;
import java.util.Scanner;

public class Cube extends Block {
	private double _sideSize;
	private Scanner in;

	Cube() {
		super();
		_sideSize = 0;
	}

	void setProperties() {
		super.setProperties();

		in = new Scanner(System.in);

		System.out.println();
		System.out.println("Cube specific information:");
		System.out.println("----------------------------------");
		System.out.println("Enter cube side lenght: ");
		try {
			_sideSize = in.nextDouble();
		} catch (InputMismatchException e) {
			System.out
					.println("Incorrect input. Default value = 0 will be used.");
		}
	}

	double getVolume() {
		return Math.pow(_sideSize, 3);
	}

	double getMass() {
		return getVolume() * super.getDensity();
	}

	void printProperties() {
		super.printProperties();

		System.out.println("Cube information:");
		System.out.println("----------------------------------");
		System.out.println("Side Size:   " + _sideSize);
		System.out.println("Mass  :      " + getMass());
		System.out.println("Volume :     " + getVolume());
		System.out.println();
	}
}
