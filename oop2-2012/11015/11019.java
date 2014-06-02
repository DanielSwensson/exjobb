
public class Position {

	//declaring variables that will be used throughout this class
	private int x;
	private int y;

	//constructor that sets the input integers to x and y
	public Position (int x, int y){


		this.x = x;
		this.y = y;
	}

	//method to get the value of x in a position
	public int getX(){
		return this.x;
	}

	//method to get the value of x in a position
	public int getY(){
		return this.y;
	}
	//Method to change the current y value in a position by one. Therefore moving south
	public Position getPosToSouth(){

		return new Position(x , y+1);
	}
	//Same as above only it moves the position "north" instead
	public Position getPosToNorth(){

		return new Position(x , y-1);
	}
	//this method changes the x value so that it moves left or "west"
	public Position getPosToWest(){

		return new Position(x-1 , y);
	}
	//same as above only it moves it "east"
	public Position getPosToEast(){

		return new Position(x+1 , y);
	}

	
	//method to compare two positions, this was auto generated
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Position other = (Position) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	
}
