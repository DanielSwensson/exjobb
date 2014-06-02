import java.util.Scanner;

public class KeyEvent extends Event {

	private int lockId;

	public KeyEvent(String descrption, int lockId) {
		super(descrption + " blocks your way.");
		this.lockId = lockId;
	}

	public Player startEvent(Player player) {

		System.out.println(getDescription());

		Scanner input = new Scanner(System.in);
		while (true) {
			System.out.print("Enter command(use key/return): ");
			switch (input.nextLine()) {

			case "use key":

				for (int i = 0; i < player.getInventory().size(); i++) {
					if (player.getInventory().getItem(i) instanceof Key)
						if (((Key) player.getInventory().getItem(i)).getKeyId() == lockId) {
							System.out.println("You opened the door!");
							setIsCompleted(true);
							pause();
							return player;

						}

				}

				System.out.println("You did not have the right key.");

			case "return":
				player.setX(player.getPrevX());
				player.setY(player.getPrevY());
				pause();
				return player;

			default:
				System.out.println("Incorrect command");
				break;
			}

		}
	}
}