import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class Block {

	protected String _name;
	protected String _color;
	protected String _desc;
	protected double _density;
	private Scanner in;

	Block() {
		_name = "not_defined";
		_desc = "none";
		_color = "not_definied";
		_density = 0;
	}

	void setProperties() {
		in = new Scanner(System.in);

		System.out.println();
		System.out.println("General block information:");
		System.out.println("----------------------------------");
		System.out.println("Enter block name: ");
		_name = in.nextLine();
		System.out.println("Enter block color: ");
		_color = in.nextLine();
		System.out.println("Enter block description: ");
		_desc = in.nextLine();
		System.out.println("Enter block density: ");
		try {
			_density = in.nextDouble();
		} catch (InputMismatchException e) {
			System.out.println("Incorrect input. Default density = 0 will be used.");
		}
	}

	void printProperties() {
		System.out.println("----------------------------------");
		System.out.println("Block general information:");
		System.out.println("----------------------------------");
		System.out.println("Name:        " + _name);
		System.out.println("Color:       " + _color);
		System.out.println("Description: " + _desc);
		System.out.println("Density:     " + _density);
		System.out.println("----------------------------------");
	}

	public String getName() {
		return _name;
	}

	public String getColor() {
		return _color;
	}

	public String getDesc() {
		return _desc;
	}

	public double getDensity() {
		return _density;
	}

	abstract double getMass();

	abstract double getVolume();
}
