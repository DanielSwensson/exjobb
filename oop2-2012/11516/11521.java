import java.util.ArrayList;
import java.util.Scanner;

public class BlockManager {
	ArrayList<Block> blocks = new ArrayList<Block>();
	private static Scanner in;

	public static void main(String[] argv) {

		int option = -1;
		BlockManager bm = new BlockManager();

		in = new Scanner(System.in);
		
		do {
			System.out.println();
			System.out.println("MENU");
			System.out.println("----------------------------------");
			System.out.println("1. Add new cone");
			System.out.println("2. Add new cube");
			System.out.println("3. Add new cuboid");
			System.out.println("4. Add new cylinder");
			System.out.println("5. Print available blocks");
			System.out.println("6. Find block with highest mass");
			System.out.println("7. Find block with highest density");
			System.out.println("8. Exit");
			System.out.println("----------------------------------");
			System.out.println("Please select option and press enter: ");

			String inp = in.nextLine();

			try {
				option = Integer.parseInt(inp);
			} catch (NumberFormatException e) {
				System.out.println("Please enter number between 1 and 8.");
			}

			switch (option) {

			case 1:
				System.out.println();
				System.out.println("Addind new cone:");
				System.out.println("----------------------------------");
				Cone c = new Cone();
				c.setProperties();
				bm.blocks.add(c);
				System.out.println("New cone has been added:");
				break;

			case 2:
				System.out.println();
				System.out.println("Addind new cube:");
				System.out.println("----------------------------------");
				Cube cb = new Cube();
				cb.setProperties();
				bm.blocks.add(cb);
				System.out.println("New cube has been added:");
				break;

			case 3:
				System.out.println();
				System.out.println("Addind new cuboid:");
				System.out.println("----------------------------------");
				Cuboid cbi = new Cuboid();
				cbi.setProperties();
				bm.blocks.add(cbi);
				System.out.println("New cuboid has been added:");
				break;

			case 4:
				System.out.println();
				System.out.println("Addind new cylinder:");
				System.out.println("----------------------------------");
				Cylinder cy = new Cylinder();
				cy.setProperties();
				bm.blocks.add(cy);
				System.out.println("New cylinder has been added:");
				break;

			case 5:
				System.out.println();
				System.out.println("List of blocks");
				System.out.println("----------------------------------");
				System.out.println();
				for (Block b : bm.blocks) {
					b.printProperties();
				}
				break;

			case 6:
				System.out.println();
				System.out.println("Find block with highest mass");
				System.out.println("----------------------------------");
				System.out.println();

				Block highestMassBlock = null;

				for (Block b : bm.blocks) {
					if (highestMassBlock == null) {
						highestMassBlock = b;
					}

					if (b.getMass() > highestMassBlock.getMass()) {
						highestMassBlock = b;
					}
				}

				if (bm.blocks.size() != 0) {
					System.out.println("Block with highest mass");
					highestMassBlock.printProperties();
				} else {
					System.out.println("No block found in the database");
				}

				break;

			case 7:
				System.out.println();
				System.out.println("Find block with highest density");
				System.out.println("----------------------------------");
				System.out.println();

				// Cone constructor will set initial mass to 0
				Block highestDensityBlock = new Cone();

				for (Block b : bm.blocks) {
					if (highestDensityBlock == null) {
						highestDensityBlock = b;
					}

					if (b.getDensity() > highestDensityBlock.getDensity()) {
						highestDensityBlock = b;
					}
				}

				if (bm.blocks.size() != 0) {
					System.out.println("Block with highest density");
					highestDensityBlock.printProperties();
				} else {
					System.out.println("No block found in the database");
				}

				break;
			case 8:
				System.out.println("Block Manager closed.");
				System.exit(0);
			case -1:
				break;
			default:
				System.out.println("Wrong option. Please select again");
			}
		} while (option != 8);
	}
}
