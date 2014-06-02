public class GameBoard {
	private BoardComponent[][] gameBoard = new BoardComponent[Game.setting.getBoardHeight()][];
	private int maxTurns = ((Game.setting.getBoardHeight() + Game.setting.getBoardWidth()) * Game.setting.getRandomIntervall() / 6);
	private int currentTurns = 0;
	public GameBoard(){
		for(int rowCount = 0; rowCount < Game.setting.getBoardHeight(); rowCount++){
			BoardComponent[] gameRow = new BoardComponent[Game.setting.getBoardWidth()];
			for(int columnCount = 0; columnCount < Game.setting.getBoardWidth(); columnCount++){
				if(rowCount == 0 && columnCount == 0){
					gameRow[columnCount] = new StartComponent(Game.randomGenerator.nextInt(Game.setting.getRandomIntervall())+1, rowCount, columnCount);
				}else if(Game.randomGenerator.nextInt(Game.setting.getLockedChance()) != 0){
					gameRow[columnCount] = new Link(Game.randomGenerator.nextInt(Game.setting.getRandomIntervall())+1, rowCount, columnCount);
				} else {
					gameRow[columnCount] = new Block();
				}
			}
			gameBoard[rowCount] = gameRow;
		}
		mergeConnections();
	}
	public int getMaxTurns(){
		return maxTurns;
	}
	public int getCurrentTurns(){
		return currentTurns;
	}
	public boolean isGameLost(){
		if(currentTurns == maxTurns){
			return true;
		}else{
			return false;
		}
	}
	public static boolean isComponentInGameBoardAndOfRightInstance(int rowNumber, int columnNumber, BoardComponent[][] gameBoard){
		boolean rowOk = false;
		boolean columnOk = false;
		boolean instanceOk = false;
		if(rowNumber >= 0 && rowNumber < Game.setting.getBoardHeight()){
			rowOk = true;
		}
		if(columnNumber >= 0 && columnNumber < Game.setting.getBoardWidth()){
			columnOk = true;
		}
		if(rowOk == true && columnOk == true){
			if(gameBoard[rowNumber][columnNumber] instanceof Link){
				instanceOk = true;
			}
		}
		return (columnOk == true && rowOk == true && instanceOk == true);
	}
	public void mergeConnections(){
		gameBoard = ((StartComponent)gameBoard[0][0]).mergeAround(gameBoard);
	}
	public void changeToUserInput(int userInput){
		((StartComponent)gameBoard[0][0]).setValue(userInput);
		currentTurns++;
	}
	public String toString(){
		String returnString = "";
		for(BoardComponent[] boardRow : gameBoard){
			for(BoardComponent boardColumn : boardRow){
				returnString += boardColumn.toString();
			}
			returnString += "\n";
		}
		return returnString;
	}
	public boolean isGameSolved(){
		boolean allSame = true;
		for(BoardComponent[] boardComponentRow : gameBoard){
			for(BoardComponent boardComponent : boardComponentRow){
				if(!(boardComponent instanceof StartComponent || boardComponent instanceof Block)){
					allSame = false;
				}
			}
		}
		return allSame;
	}
}
