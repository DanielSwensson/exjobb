import java.util.ArrayList;
public class StartComponent extends Link {
	private ArrayList<Link> merged = new ArrayList<Link>();

	public StartComponent(int value, int rowCount, int columnCount){
		super(value, rowCount, columnCount);
		addMerge(this);
	}
	public String toString(){
		return "(" + getValue() + ")";
	}
	public ArrayList<Link> getMerged(){
		return merged;
	}
	public boolean addMerge(Link neighbor){
		if(!merged.contains(neighbor)){
			merged.add(neighbor);
			return true;
		}else{
			return false;
		}
	}
	public BoardComponent[][] mergeAround(BoardComponent[][] gameBoard){
		boolean found;
		do{
			found = false;
			ArrayList<Link> mergeTemp = new ArrayList<Link>();
			for(Link neighbor : merged){
				int testRow1 = neighbor.getRowNumber() + 1;
				int testColumn1 = neighbor.getColumnNumber();
				int testRow2 = neighbor.getRowNumber();
				int testColumn2 = neighbor.getColumnNumber() + 1;
				int testRow3 = neighbor.getRowNumber() - 1;
				int testColumn3 = neighbor.getColumnNumber();
				int testRow4 = neighbor.getRowNumber();
				int testColumn4 = neighbor.getColumnNumber() - 1;
				if(GameBoard.isComponentInGameBoardAndOfRightInstance(testRow1, testColumn1, gameBoard)){
					if(gameBoard[testRow1][testColumn1].getValue() == this.getValue()){
						mergeTemp.add((Link)gameBoard[testRow1][testColumn1]);
					}
				}
				if(GameBoard.isComponentInGameBoardAndOfRightInstance(testRow2, testColumn2, gameBoard)){
					if(gameBoard[testRow2][testColumn2].getValue() == this.getValue()){
						mergeTemp.add((Link)gameBoard[testRow2][testColumn2]);
					}
				}
				if(GameBoard.isComponentInGameBoardAndOfRightInstance(testRow3, testColumn3, gameBoard)){
					if(gameBoard[testRow3][testColumn3].getValue() == this.getValue()){
						mergeTemp.add((Link)gameBoard[testRow3][testColumn3]);
					}
				}
				if(GameBoard.isComponentInGameBoardAndOfRightInstance(testRow4, testColumn4, gameBoard)){
					if(gameBoard[testRow4][testColumn4].getValue() == this.getValue()){
						mergeTemp.add((Link)gameBoard[testRow4][testColumn4]);
					}
				}
			}
			for(Link mergeItem : mergeTemp){
				int mergeRow = mergeItem.getRowNumber();
				int mergeColumn = mergeItem.getColumnNumber();
				if(addMerge((Link)gameBoard[mergeRow][mergeColumn])){
					found = true;
				}
				gameBoard[mergeRow][mergeColumn] = gameBoard[0][0];
			}
		}while(found);
		return gameBoard;
	}
}
