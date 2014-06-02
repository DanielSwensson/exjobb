
public abstract class Runner {
	
	private Position position;
	protected Maze maze;
	
	//constructor for the runners
	public Runner(Maze maze){
		
		this.maze = maze;
		position = maze.getPlayerStartPosition();
		
		
	}
	
	public abstract void move();
	
	
	public Position getCurrentPosition(){
		return position;
		
	}
	
	protected void setCurrentPosition(Position posRunner){
		position = posRunner;
		
		
	}
	//method to check if the runner has reached goal
	public Boolean hasReachedGoal(){
		if(maze.isGoal(position) == true){
			return true;
		}
		return false;
	}
	
}
