import java.util.Random;
import java.util.Scanner;
public class Game {
	protected static Random randomGenerator = new Random();
	protected static Scanner keyboard = new Scanner(System.in);
	protected static Setting setting = new Setting();
	public static void main(String[] args){
		showMainMenu();
	}
	public static void showMainMenu(){
		int userInput;
		do{
			System.out.println("1. Nytt spel");
			System.out.println("2. InstŠllningar");
			System.out.println("3. Avsluta");
			System.out.print(">> ");
			userInput = keyboard.nextInt();
			keyboard.nextLine();
		}while(userInput <= 0 || userInput > 3);
		selectUserMenuInput(userInput);
	}
	public static void startNewGame(){
		GameBoard gameBoard = new GameBoard();
		while(!gameBoard.isGameSolved() && !gameBoard.isGameLost()){
			System.out.println("Du har gjort " + gameBoard.getCurrentTurns() + " vŠndningar av max " + gameBoard.getMaxTurns());
			System.out.print(gameBoard);
			System.out.print(">> ");
			gameBoard.changeToUserInput(keyboard.nextInt());
			gameBoard.mergeConnections();
			keyboard.nextLine();
		};
		boolean win = gameBoard.isGameSolved();
		System.out.print(gameBoard);
		if(win){
			System.out.println("Grattis du lšste pusslet!");
		}else{
			System.out.println("Du kunde inte lšsa pusslet!");
		}
		showMainMenu();
	}
	public static void selectUserMenuInput(int userInput){
		switch(userInput){
		case 1:
			startNewGame();
			break;
		case 2:
			setting.showSettingDialog();
			break;
		case 3:
			System.exit(0);
		default:
			main(null);
		}
	}
}