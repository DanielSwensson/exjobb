
import java.util.ArrayList;
import java.util.Scanner;


public class BlindRunner extends Runner {

	private Position posRun;
	private ArrayList<ArrayList<Boolean>> visible;
	Scanner keyboard = new Scanner(System.in);

	public BlindRunner(Maze maze) {

		super(maze);

		this.maze = maze;

		posRun = super.getCurrentPosition();
		visible = new ArrayList<ArrayList<Boolean>>();
		//this creates a second matrix to be able to identify what is visible to the player
		for(int i = 0; i < maze.getMaze().size(); i++){
			visible.add(new ArrayList<Boolean>());
			for(int j = 0; j < maze.getMaze().get(i).size(); j++){
				visible.get(i).add(false);
			}

		}


		//this checks that the start position has a valid placement so that the player can't start surrounded by walls.
		if(!maze.isMovable(posRun.getPosToEast()) && !maze.isMovable(posRun.getPosToNorth()) 
				&& !maze.isMovable(posRun.getPosToSouth()) && !maze.isMovable(posRun.getPosToWest())){

			throw new IllegalStateException("its a trap! Start position is not valid");
		}

	}

	//this is the move method for the blind runner
	public void move() {

		String input= keyboard.nextLine();

		if(input.equals("q")){
			Labyrinth.menu();
		}

		if(input.equals("w") && maze.isMovable(posRun.getPosToNorth())){

			super.setCurrentPosition(posRun.getPosToNorth());
			posRun = super.getCurrentPosition();

		} else if(input.equals("d") && maze.isMovable(posRun.getPosToEast())){

			super.setCurrentPosition(posRun.getPosToEast());
			posRun = super.getCurrentPosition();

		} else if(input.equals("s") && maze.isMovable(posRun.getPosToSouth())){

			super.setCurrentPosition(posRun.getPosToSouth());
			posRun = super.getCurrentPosition();

		} else if(input.equals("a") && maze.isMovable(posRun.getPosToWest())){

			super.setCurrentPosition(posRun.getPosToWest());
			posRun = super.getCurrentPosition();

		} else  {

			System.out.println("You must enter w, a, s or d to move the runner. enter q to exit");
		}



	}
	//this method is used to be able and update what is visible to the player.
	//it is a second matrix containing boolean values if the position is visible or not.
	public void calculateVisiblePositions(Maze maze){
		try{
			posRun = super.getCurrentPosition();
			for(int y = -2; y < 3; y++){
				for(int x = -2; x < 3; x++){
					if(maze.isWithinBounds(new Position((posRun.getX()+x), (posRun.getY()+y)))){
						visible.get(posRun.getY()+y).remove(posRun.getX()+x);
						visible.get(posRun.getY()+y).add((posRun.getX()+x), true);

					}
				}
			}
		}catch (java.lang.IndexOutOfBoundsException e){

		}
	}
	//this method draws the maze but always checks the visible matrix if the space 
	//should be visible or not
	public void drawMazeWithFog(Maze maze){

		calculateVisiblePositions(maze);
		posRun = super.getCurrentPosition();

		System.out.println();
		try{
			
		
		for(int i = 0; i < maze.getMaze().size(); i++){
			for(int j = 0; j < maze.getMaze().get(i).size(); j++){
				if(new Position(j , i).equals(posRun)){
					System.out.print("O");
					j++;
				}
				if(visible.get(i).get(j)){
					System.out.print(maze.getMaze().get(i).get(j));
				} else {
					System.out.print("/");
				}
			}
			System.out.println();
		}
		} catch (IndexOutOfBoundsException e){
			
		}
	}

}
