
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

public class Maze {


	private ArrayList<ArrayList<Character>>	mazeData;
	private Position playerStartPos;
	private int x;
	private int y;

	public Maze(Reader file) throws IOException{

		x = 0;
		y = 0;

		int value = file.read();

		mazeData = new ArrayList<ArrayList<Character>>();

		mazeData.add(new ArrayList<Character>());

		while ((char)value == 'X' || (char)value == 'S' || (char)value == 'G' || (char)value == ' ' || (char)value == '¤'||value == 10||value == 13){

			//if the line ends a new arraylist is created
			if(value == 10){

				mazeData.add(new ArrayList<Character>());
				x = 0;
				y++;
			}
			//Adds everything to the array but new line and file end.
			else if(value != 13 && value != 10){

				mazeData.get(y).add((char)value);
				if((char)value == 'S'){

					playerStartPos = new Position(x , y);
					
				}


				x++;
			}
			value = file.read();
		}
	}
	
	//Method to check if a move is possible or rather that a position is a empty space
	public Boolean isMovable(Position pos){

		try{

			if(pos.getX() <= mazeData.get(pos.getY()).size() && pos.getY() <= mazeData.size() 
					&& !(mazeData.get(pos.getY()).get(pos.getX()) == 'X') && pos.getX() > 0 && pos.getY() > 0){

				return true;
			}
		} catch (IndexOutOfBoundsException e) {

			return false;
		}

		return false;
	}
	//This method checks that other methods operate within the maze limits
	public Boolean isWithinBounds(Position pos){
		try{
			if(pos.getX() <= mazeData.get(pos.getY()).size() && pos.getY() <= mazeData.size() 
					&& pos.getX() >= 0 && pos.getY() >= 0){
				return true;
			}
		} catch (IndexOutOfBoundsException e) {

			return false;
		}

		return false;
	}
	//Method to check if a space is the goal
	public Boolean isGoal(Position pos){

		if(mazeData.get(pos.getY()).get(pos.getX()) == 'G'){
			return true;
		}
		return false;
	}
	
	//method to retrieve start position
	public Position getPlayerStartPosition(){

		return playerStartPos;
	}
	//This method prints the maze aswell as the player location in that maze.
	public void drawMaze(Position pos){

		for(int i = 0; i < mazeData.size(); i++){
			for(int j = 0; j < mazeData.get(i).size(); j++){
				if(new Position(j , i).equals(pos)){
					System.out.print("O");
					j++;
				}
				System.out.print(mazeData.get(i).get(j));

			}
			System.out.println();
		}

	}
	public ArrayList<ArrayList<Character>> getMaze(){
		return mazeData;
	}
	
	//this method checks a space if it contains a block
	public Boolean isABlock(Position pos){
		if(mazeData.get(pos.getY()).get(pos.getX()) == '¤'){
			return true;
		}
		return false;
	} 
	
	//This method makes it possible to "move" the blocks. What is does is that it
	//removes the block from space where it was and moves it to a free space in the 
	//wished direction. 
	public void changeSpaceContent(Position pos, String direction){

		if(direction.equals("w")){

			mazeData.get(pos.getY()).remove(pos.getX());
			mazeData.get(pos.getY()).add((pos.getX()), ' ');

			mazeData.get(pos.getY()-1).remove(pos.getX());
			mazeData.get(pos.getY()-1).add((pos.getX()), '¤');
		}
		if(direction.equals("d")){
			mazeData.get(pos.getY()).remove(pos.getX());
			mazeData.get(pos.getY()).add((pos.getX()), ' ');

			mazeData.get(pos.getY()).remove(pos.getX()+1);
			mazeData.get(pos.getY()).add((pos.getX()+1), '¤');
		}
		if(direction.equals("s")){
			mazeData.get(pos.getY()).remove(pos.getX());
			mazeData.get(pos.getY()).add((pos.getX()), ' ');

			mazeData.get(pos.getY()+1).remove(pos.getX());
			mazeData.get(pos.getY()+1).add((pos.getX()), '¤');
		}
		if(direction.equals("a")){
			mazeData.get(pos.getY()).remove(pos.getX());
			mazeData.get(pos.getY()).add((pos.getX()), ' ');

			mazeData.get(pos.getY()).remove(pos.getX()-1);
			mazeData.get(pos.getY()).add((pos.getX()-1), '¤');
		}
	}




}



