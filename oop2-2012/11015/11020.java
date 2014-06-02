import java.util.Scanner;


public class PusherRunner extends Runner {

	private Position posRun;
	Scanner keyboard = new Scanner(System.in);


	public PusherRunner(Maze maze) {

		super(maze);

		posRun = super.getCurrentPosition();


		if(!maze.isMovable(posRun.getPosToNorth()) && !maze.isMovable(posRun.getPosToEast())
				&& !maze.isMovable(posRun.getPosToSouth()) && !maze.isMovable(posRun.getPosToWest())){

			throw new IllegalStateException("its a trap! Start position is not valid");
		}

	}

	public void move() {

		String input= keyboard.nextLine();

		if(input.equals("q")){
			Labyrinth.menu();
		}

		if(input.equals("w") && maze.isMovable(posRun.getPosToNorth())){
			if(maze.isABlock(posRun.getPosToNorth())){

				if(!maze.isGoal(posRun.getPosToNorth().getPosToNorth())){
					maze.changeSpaceContent(posRun.getPosToNorth(), input);

					super.setCurrentPosition(posRun.getPosToNorth());
					posRun = super.getCurrentPosition();
				}

			} else if(!maze.isABlock(posRun.getPosToNorth())){

				super.setCurrentPosition(posRun.getPosToNorth());
				posRun = super.getCurrentPosition();
			}
		} else if(input.equals("d") && maze.isMovable(posRun.getPosToEast())){
			if(maze.isABlock(posRun.getPosToEast())){

				if(!maze.isGoal(posRun.getPosToEast().getPosToEast())){
					maze.changeSpaceContent(posRun.getPosToEast(), input);

					super.setCurrentPosition(posRun.getPosToEast());
					posRun = super.getCurrentPosition();
				}

			} else if(!maze.isABlock(posRun.getPosToEast())){

				super.setCurrentPosition(posRun.getPosToEast());
				posRun = super.getCurrentPosition();
			}



		} else if(input.equals("s") && maze.isMovable(posRun.getPosToSouth())){
			if(maze.isABlock(posRun.getPosToSouth()) && maze.isMovable(posRun.getPosToSouth().getPosToSouth())){

				if(!maze.isGoal(posRun.getPosToSouth().getPosToSouth())){
					maze.changeSpaceContent(posRun.getPosToSouth(), input);

					super.setCurrentPosition(posRun.getPosToSouth());
					posRun = super.getCurrentPosition();
				}
			} else if(!maze.isABlock(posRun.getPosToSouth())){

				super.setCurrentPosition(posRun.getPosToSouth());
				posRun = super.getCurrentPosition();

			}
		} else if(input.equals("a") && maze.isMovable(posRun.getPosToWest())){
			if(maze.isABlock(posRun.getPosToWest()) && maze.isMovable(posRun.getPosToWest().getPosToWest())){

				if(!maze.isGoal(posRun.getPosToWest().getPosToWest())){
					maze.changeSpaceContent(posRun.getPosToWest(), input);

					super.setCurrentPosition(posRun.getPosToWest());
					posRun = super.getCurrentPosition();
				}
			} else if(!maze.isABlock(posRun.getPosToWest())){

				super.setCurrentPosition(posRun.getPosToWest());
				posRun = super.getCurrentPosition();

			}

		} else  {

			System.out.println("You must enter w, a, s or d to move the runner. enter q to exit");
		}

	}

}
