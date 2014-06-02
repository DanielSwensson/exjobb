
public class Setting {
	private int boardHeight;
	private int boardWidth;
	private int randomIntervall;
	private int lockedChance;
	public Setting(){
		boardHeight = 10;
		boardWidth = 10;
		randomIntervall = 7;
		// 1 / X
		lockedChance = 10;
	}
	public void showSettingDialog(){
		System.out.println("Bredd p� spelplan? Nuvarnade: " + boardWidth);
		setBoardWidth(Game.keyboard.nextInt());
		Game.keyboard.nextLine();
		System.out.println("H�jd p� spelplan? Nuvarande: " + boardHeight);
		setBoardHeight(Game.keyboard.nextInt());
		Game.keyboard.nextLine();
		System.out.println("Variation p� numrena? Nuvarande: " + randomIntervall);
		setRandomIntervall(Game.keyboard.nextInt());
		Game.keyboard.nextLine();
		System.out.println("Risk f�r blockar? 1/X Nuvarande: 1/" + lockedChance);
		setLockedChance(Game.keyboard.nextInt());
		Game.keyboard.nextLine();
		Game.showMainMenu();
	}
	public int getBoardHeight() {
		return boardHeight;
	}
	public void setBoardHeight(int boardHeight){
		if(boardHeight > 0){
			this.boardHeight = boardHeight;
		}
	}
	public int getBoardWidth() {
		return boardWidth;
	}
	public void setBoardWidth(int boardWidth) {
		if(boardWidth > 0){
			this.boardWidth = boardWidth;
		}
	}
	public int getRandomIntervall() {
		return randomIntervall;
	}
	public void setRandomIntervall(int randomIntervall) {
		if(randomIntervall > 1 && randomIntervall <= 9){
			this.randomIntervall = randomIntervall;
		}
	}
	public int getLockedChance() {
		return lockedChance;
	}
	public void setLockedChance(int lockedChance) {
		if(lockedChance > 2){
			this.lockedChance = lockedChance;
		}
	}
	
}
