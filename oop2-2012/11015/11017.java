import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;




public class Labyrinth {

	private static Position previous;
	static Scanner keyboard = new Scanner(System.in);
	private static int steps = 0;
	public static void main(String[] args) throws IOException, InterruptedException {

		System.out.println("Welcome to Labyrinth!");
		System.out.println("This is a maze game that has two different maze runners,");
		System.out.println("One has to move around blocks symbolized by ¤ to reach the goal.");
		System.out.println("The second does not have sight of the whole maze and has to explore to find the goal.");
		System.out.println();
		System.out.println("The objective is always the same, reach the goal in as few steps as possible!");
		menu();

		
	}
	public static void menu(){
		int input = 0;




		while(!(input == 5)){
			System.out.print("\n");
			System.out.println("--MENU--");
			System.out.println("To navigate the menu enter the number next to the chooice.");
			System.out.print("1.Controlls\n2.Explorer\n3.PuzzleSolver\n4.Exit\nAnge Val:");
			try{
				input = Integer.parseInt(keyboard.nextLine());
				switch(input){
				case 1: 
					System.out.println("\n--Controlls--");
					System.out.println("You controll the maze runner by entering a letter corrosponding to the direction");
					System.out.println("you want to move in. You always have to press enter after you have entered a letter.");
					System.out.println("\nw is up");
					System.out.println("s is down");
					System.out.println("a is left");
					System.out.println("d is right");
					System.out.println("\n(Make sure you only enter one letter and that it is not capitalized).");
					break;
				case 2:
					System.out.println("\n--Explorer--");
					System.out.println("Enter the difficulty you want to run:");
					for(;;){
						System.out.println("1.Easy\n2.Medium\n3.Hard\n4.Back");

						input = Integer.parseInt(keyboard.nextLine());
						if((input >= 5) || (input <= 0)){
							System.out.println("You did not select a corect chooice.");
						}
						else if(input == 4){
							menu();
						}  

						try {
							startBlindRunner(input);
						} catch (IOException e) {

							e.printStackTrace();
						}
						break;
					} 			
				case 3:
					System.out.println("\n--PuzzleSolver--");
					System.out.println("Enter the difficulty you want to run:");
					for(;;){
						System.out.println("1.Easy\n2.Medium\n3.Hard\n4.Back");

						input = Integer.parseInt(keyboard.nextLine());
						if((input >= 5) || (input <= 0)){
							System.out.println("You did not select a corect chooice.");
						}
						else if(input == 4){
							menu();
						}  

						try {
							startPusherRunner(input);
						} catch (IOException e) {

							e.printStackTrace();
						}
						break;
					} 			
				case 4:
					System.exit(0);
				default:
					System.out.println("You entered: " + input + " which is not a option");
				} 
			}catch (java.lang.NumberFormatException e){	
				System.out.println("\nYou entered a letter and not a number");
			}

		}
	}
	private static void startBlindRunner(int difficulty) throws IOException{
		Maze theMaze = null;
		try {
			if(difficulty == 1){


				Reader maze = new FileReader("easyMaze1.txt");
				theMaze = new Maze(maze);

			} 
			if(difficulty == 2) {

				Reader maze = new FileReader("mediumMaze1.txt");
				theMaze = new Maze(maze);

			}
			if(difficulty == 3){

				Reader maze = new FileReader("hardMaze1.txt");
				theMaze = new Maze(maze);

			}
		} catch (FileNotFoundException e) {

			System.out.println("Cannot open or read the designated files");
			e.printStackTrace();
		}

		Runner blindRunner = new BlindRunner(theMaze);

		((BlindRunner)blindRunner).drawMazeWithFog(theMaze);

		while(!blindRunner.hasReachedGoal()){
			previous = blindRunner.getCurrentPosition();
			blindRunner.move();
			((BlindRunner)blindRunner).drawMazeWithFog(theMaze);
			if(!previous.equals(blindRunner.getCurrentPosition())){
				steps++;
			}
		}
		System.out.println("\nYou completed the maze in:" + steps + " steps\n");
	}
	private static void startPusherRunner(int difficulty) throws IOException{
		Maze theMaze = null;
		try {
			if(difficulty == 1){


				Reader maze = new FileReader("easyMaze2.txt");
				theMaze = new Maze(maze);

			} 
			if(difficulty == 2) {

				Reader maze = new FileReader("mediumMaze2.txt");
				theMaze = new Maze(maze);

			}
			if(difficulty == 3){

				Reader maze = new FileReader("hardMaze2.txt");
				theMaze = new Maze(maze);

			}
		} catch (FileNotFoundException e) {

			System.out.println("Cannot open or read the designated files");
			e.printStackTrace();
		}

		Runner pusherRunner = new PusherRunner(theMaze);
		theMaze.drawMaze(pusherRunner.getCurrentPosition());

		while(!pusherRunner.hasReachedGoal()){
			previous = pusherRunner.getCurrentPosition();
			pusherRunner.move();
			theMaze.drawMaze(pusherRunner.getCurrentPosition());
			if(!previous.equals(pusherRunner.getCurrentPosition())){
				steps++;
			}
		}
		System.out.println("\nYou completed the maze in:" + steps + " steps");

	}
}
