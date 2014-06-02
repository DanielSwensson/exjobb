package simpleMonopoly;

public class Board {

	// Arrayen som innehåller alla rutorna.
	static Square[] squaresOnBoard = new Square[40];

	// Skapar alla 40 rutorna och för in dem i squaresOnBoard.
	public static void createSquares() {

		squaresOnBoard[0] = new Misc("Go");

		squaresOnBoard[1] = new Street("Mediterranean Avenue", 2, 60, "Purple");

		squaresOnBoard[2] = new Misc("Chest 1");

		squaresOnBoard[3] = new Street("Baltic Avenue", 4, 60, "Purple");

		squaresOnBoard[4] = new Misc("Income tax", 200);

		squaresOnBoard[5] = new Other("Reading Railroad", 25, 200);

		squaresOnBoard[6] = new Street("Oriental Avenue", 6, 100, "Teal");

		squaresOnBoard[7] = new Misc("Chance 1");

		squaresOnBoard[8] = new Street("Vermont Avenue", 6, 100, "Teal");
		squaresOnBoard[9] = new Street("Connecticut Avenue", 8, 120, "Teal");

		squaresOnBoard[10] = new Misc("Jail");

		squaresOnBoard[11] = new Street("St. Charles Place", 10, 140, "Pink");

		squaresOnBoard[12] = new Other("Electric Company", 0, 150);

		squaresOnBoard[13] = new Street("States Avenue", 10, 140, "Pink");
		squaresOnBoard[14] = new Street("Virginia Avenue", 12, 160, "Pink");

		squaresOnBoard[15] = new Other("Pennsylvania Railroad", 25, 200);

		squaresOnBoard[16] = new Street("St. James Place", 14, 180, "Orange");

		squaresOnBoard[17] = new Misc("Chest 2");

		squaresOnBoard[18] = new Street("Tenessee Avenue", 14, 180, "Orange");
		squaresOnBoard[19] = new Street("New York Avenue", 16, 200, "Orange");

		squaresOnBoard[20] = new Misc("Free Parking");

		squaresOnBoard[21] = new Street("Kentucky Avenue", 18, 220, "Red");

		squaresOnBoard[22] = new Misc("Chance 2");

		squaresOnBoard[23] = new Street("Indiana Avenue", 18, 220, "Red");
		squaresOnBoard[24] = new Street("Illinois Avenue", 20, 240, "Red");

		squaresOnBoard[25] = new Other("B. & O. Railroad", 25, 200);

		squaresOnBoard[26] = new Street("Atlantic Avenue", 22, 260, "Yellow");
		squaresOnBoard[27] = new Street("Ventnor Avenue", 22, 260, "Yellow");

		squaresOnBoard[28] = new Other("Water Works", 0, 150);

		squaresOnBoard[29] = new Street("Marvin Gardens", 24, 280, "Yellow");

		squaresOnBoard[30] = new Misc("Go To Jail");

		squaresOnBoard[31] = new Street("Pacific Avenue", 26, 300, "Green");
		squaresOnBoard[32] = new Street("North Carolina Avenue", 26, 300,
				"Green");

		squaresOnBoard[33] = new Misc("Chest 3");

		squaresOnBoard[34] = new Street("Pennsylvania Avenue", 28, 320, "Green");

		squaresOnBoard[35] = new Other("Short Line", 25, 200);
		squaresOnBoard[36] = new Misc("Chance 3");

		squaresOnBoard[37] = new Street("Park Place", 35, 350, "Blue");

		squaresOnBoard[38] = new Misc("Luxury Tax", 75);

		squaresOnBoard[39] = new Street("Board Walk", 50, 400, "Blue");

	}

}
