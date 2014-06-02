import java.util.Random;

public class Map {
	
	private int maxX = 5;
	private int maxY = 4;

	private Room[][] worldMap = new Room[maxY][maxX];

	public Map() {

		// The room where the player starts
		worldMap[0][2] = new Room(
				"You enter the great entry hall of the mansion. \n"
						+ "The grand and brightly lit up room's centerpiece being an old baroque \n"
						+ "staircase connecting the first and second floors of the mansion.\n"
						+ "At the end of the staircase, to the south, there is a single door leading further into the old mansion.",
				new Key("A rusty key", 1));

		worldMap[1][2] = new Room(
				"You enter a rather small and run down room.\n"
						+ "The room itself is nothing special in particular, the decorations being\n"
						+ "limited and its only light source being an old oil lamp hanging in the corner.\n"
						+ "The only noteworthy thing being the damp and thick air, as if you\n"
						+ "were situated in a swamp the brief moment before a storm,\n"
						+ "Upon going further into the room you see the contours of three doors, one\n"
						+ "leading you south. One leading you to the eastern\n"
						+ "regions of the mansion and the final one leads west.",
				new KeyEvent("A rusty door", 1));

		worldMap[1][3] = new Room(
				"Entering the new room the first thing you notice is the\n"
						+ "chilling wind sending chills down your back. Looking up you see the night sky\n"
						+ "through the worn and broken ceiling.\n"
						+ "What broke it is hard to tell, it has probably been the victim of time,\n"
						+ "have been something else but it could also\n"
						+ "Down the room there’s a door leading you south in the mansion.",
				new Weapon("sword", 2));

		worldMap[1][1] = new Room(
				"You enter a small room with nothing but a door leading forward to the west.",
				new KeyEvent("A huge golden door", 2));

		worldMap[1][0] = new Room("The last room", new EndGameEvent());

		worldMap[2][2] = new Room("You enter a long and narrow hallway.\n"
				+ "The further you walk into it, the darker it gets.\n"
				+ "Old and worn down paintings decorate the walls comforting\n"
				+ "the otherwise claustrofobic feeling\n"
				+ "At the southern end of the the hallway, there is a door,\n"
				+ "and there are also doors to the east and west.", new Item(
				"cat"));

		worldMap[3][2] = new Room(
				"You enter a brightly lit room. High ceiling, large paintings and a sky window being \n"
						+ "the it's main features. Unlike the other rooms which smelled like rot or mold, the \n"
						+ "smell of warm food is filling the room as the centerpiece has a fully set dinner table.\n",
				new Food("Pizza", 20));

		worldMap[2][3] = new Room(
				"You enter a small and cramped up room.\n"
						+ "There’s little to no light source and it’s very difficult to see what’s in it.\n"
						+ "With no particular smell and no real light you are left clueless about the contents of the room.\n"
						+ "After wandering around for some time you start realizing the prescence\n"
						+ "of two doors, one to the west and one north.\n"
						+ "There’s also a staircase to the east going down far below the ground.", new Item("ring"));

		worldMap[2][4] = new Room(
				"Going down the staircase there’s a vast and round room.\n"
						+ "Despite obviously being underground it’s surprisingly bright,\n"
						+ "making it easy to see deeper into the room. Walking further\n"
						+ "inside, you notice that it’s actually a gladiatorial arena!\n"
						+ "Around the edges of the fighting field are droves of freshly\n"
						+ "and not so recently decapitated skulls. You come across the occasional\n"
						+ "pool of blood.", new Key(
						"a huge golden key crowned with a red diamond", 2),
				new MonsterEvent(new Boss()));
	}

	public String getCurrentRoomDescription(int x, int y) {
		return worldMap[y][x].getDescription();
	}

	public int getMaxY() {
		return maxY;
	}

	public int getMaxX() {
		return maxX;
	}

	public Room getRoom(int x, int y) {
		Room room = worldMap[y][x];
		return room;
	}

	public void printMap(Player player) {

		for (int i = 0; i < maxY; i++) {
			for (int j = 0; j < maxX; j++) {
				if (i == player.getYStartPosition()
						&& j == player.getXStartPosition()) {
					System.out.print("E ");
				} else if (!(worldMap[i][j] == null)) {
					System.out.print("0 ");
				} else {
					System.out.print(". ");
				}
			}
			System.out.println();
		}
		System.out.println("\nO = Room");
		System.out.println("E = Entry");

	}

}
