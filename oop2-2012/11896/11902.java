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
		// IDno skickas fr�n GameSetup.
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

		// Om currentSquare �r st�rre �n 39 har man g�tt ett varv runt br�det.
		// 40 subtraheras fr�n currentSquare f�r att simulera detta.
		if (currentSquare > 39) {
			currentSquare -= 40;

			// G�r man ett varv runt br�det passerar man G� och f�r 200 adderat
			// till balance.
			balance += 200;
			System.out.println("You passed Go and received 200$");
		}
	}

	// Till skillnad fr�n changeCurrentSquare s� kringg�r setCurrentSquare Go.
	// Visuellt sett s� flyttar man spelpj�sen direkt till en annan ruta i
	// st�llet f�r att g� runt br�det ruta f�r ruta.
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
