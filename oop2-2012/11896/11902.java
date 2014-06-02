package simpleMonopoly;

public class Player {

	private int ID;
	private int currentSquare;
	private int balance = 1500;
	private boolean jailBool = false;
	private int jailedTime;

	Player() {

	}

	public void setID(int IDno) {
		// IDno skickas från GameSetup.
		ID = IDno;

	}

	public int getID() {
		return ID;

	}

	public int getCurrentSquare() {
		return currentSquare;
	}

	public void changeCurrentSquare(int stepsOnBoard) {

		// Adderar totalRoll till currentSquare. x = totalRoll.
		currentSquare += stepsOnBoard;

		// Om currentSquare är större än 39 har man gått ett varv runt brädet.
		// 40 subtraheras från currentSquare för att simulera detta.
		if (currentSquare > 39) {
			currentSquare -= 40;

			// Går man ett varv runt brädet passerar man Gå och får 200 adderat
			// till balance.
			balance += 200;
			System.out.println("You passed Go and received 200$");
		}
	}

	// Till skillnad från changeCurrentSquare så kringgår setCurrentSquare Go.
	// Visuellt sett så flyttar man spelpjäsen direkt till en annan ruta i
	// stället för att gå runt brädet ruta för ruta.
	public void setCurrentSquare(int newSquare) {

		currentSquare = newSquare;

	}

	public void increaseBalance(int value) {

		balance += value;

		return;

	}

	public void decreaseBalance(int value) {

		balance -= value;

		return;

	}

	public int getBalance() {
		return balance;
	}

	public void setJailBool(boolean changeJailBoolTo) {

		jailBool = changeJailBoolTo;
	}

	public boolean getJailBool() {
		return jailBool;
	}

	public void addJailedTime() {

		++jailedTime;

	}

	public int getJailedTime() {
		return jailedTime;
	}

	public void resetJailedTime() {

		jailedTime = 0;

	}
}
