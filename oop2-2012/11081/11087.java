import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

public class TeamInfo {

	static Scanner keyboard = new Scanner(System.in); // Skapa en ny skanner
	private static ArrayList<Match> matchResults = new ArrayList<Match>();
	private static ArrayList<Person> personList = new ArrayList<Person>();

	public TeamInfo() {

		readPersons();
		readMatches();

		for (;;) {

			int command = readInt("V�lkommen till lagets information!"
					+ "\n1-L�gg till ny spelare"
					+ "\n2-L�gg till ny tr�nare eller medarbetare"
					+ "\n3-L�gg till resultat" 
					+ "\n4-Visa po�ngliga"
					+ "\n5-Visa spelarinfo"
					+ "\n6-Visa info om tr�nare eller medabetare"
					+ "\n7-Ta bort spelare fr�n laget"
					+ "\n8-Ta bort coach fr�n laget"
					+ "\n9-Ta bort stabmedlem fr�n laget"
					+ "\n10-Visa resultatlista" 
					+ "\n11-Skicka laget p� tr�ningsl�ger"
					+ "\n12-Avsluta program"
					+ "\nV�lj den aktion du vill utf�ra: " + "\n");

			switch (command) {

			case 1:
				addPlayer();
				break;
			case 2:
				addCoachOrStaffMember();
				break;
			case 3:
				addResult();
				break;
			case 4:
				listPlayerPoints();
				break;
			case 5:
				showPlayerInfo();
				break;
			case 6:
				listCoachOrStaffMember();
				break;
			case 7:
				erasePlayer();
				break;
			case 8:
				eraseCoach();
				break;
			case 9:
				eraseStaffMember();
				break;
			case 10:
				listResult();
				break;
			case 11:
				newTrainingCamp();
				break;
			case 12:
				savePersons();
				saveMatches();
				System.exit(0);
			default:
				System.out
				.print("\nFelaktigt kommando, v�lj ett av de korrekta alternativen! \n \n");
			}
		}
	}

	/**
	 * metoder i programet
	 */
		private void readMatches() {
			try {
				FileInputStream file = new FileInputStream("MatchListan.obj");
				ObjectInputStream in = new ObjectInputStream(file);
				matchResults = (ArrayList<Match>) in.readObject();
			} catch (FileNotFoundException e) { // Filen fanns ej, vi startar med
				// tom ArrayLista
				System.out.print("File not found(Matches)\n");
			} catch (IOException e) {
				System.out.print("IOExeption");
				System.exit(2);
			} catch (ClassNotFoundException e) {
				System.out.print("ClassNotFoundException");
				System.exit(3);
			}
		}
	
		private void saveMatches() {
			try {
				FileOutputStream file = new FileOutputStream("MatchListan.obj");
				ObjectOutputStream out = new ObjectOutputStream(file);
				out.writeObject(matchResults);
			} catch (IOException e) {
				System.out.print("Matcherna kunde inte sparas");
				System.exit(1);
			}
		}

	private void readPersons() {
		try {
			FileInputStream file = new FileInputStream("PersonLista.obj");
			ObjectInputStream in = new ObjectInputStream(file);
			personList = (ArrayList<Person>) in.readObject();
		} catch (FileNotFoundException e) { // Filen fanns ej, vi startar med
			// tom ArrayLista
			System.out.print("File not found(Persons)\n");
		} catch (IOException e) {
			System.out.print("IOExeption");
			System.exit(2);
		} catch (ClassNotFoundException e) {
			System.out.print("ClassNotFoundException");
			System.exit(3);
		}
	}

	private void savePersons() {
		try {
			FileOutputStream file = new FileOutputStream("PersonLista.obj");
			ObjectOutputStream out = new ObjectOutputStream(file);
			out.writeObject(personList);
		} catch (IOException e) {
			System.out.print("Personerna kunde inte sparas");
			System.exit(1);
		}
	}

	private void newTrainingCamp(){
		int days = readInt("Hur m�nga dagar p�g�r tr�ningsl�gret?");
		for (Person person : personList){
			person.traningCamp(days);
		}
	}

	private void addPlayer() { // Metod f�r att skapa nya spelare till truppen

		boolean looping = true;
		boolean found = false;
		ArrayList<Player> playerList = new ArrayList<Player>();
		for (Person player : personList){
			if (player instanceof Player){
				playerList.add((Player)player);
			}
		}


		String FirstName = readString("\nSpelarens f�rnamn: ");
		String LastName = readString("Spelarens efternamn: ");
		int Age = readInt("Spelarens �lder: ");
		double Weight = readDouble ("Spelarens vikt: ");		
		String StickHandling = readString("Skriv in spelarens klubbfattning: ");
		int SkateSize = readInt("Spelarens skridskostorlek: ");
		while (looping){
			found = false;
			int ShirtNumber = readInt("Spelarens tr�jnummer: ");
			System.out.print("\n");
			for (Player player : playerList){
				((Player) player).getShirtNumber();
				if (((Player) player).getShirtNumber() == ShirtNumber){
					found = true;
				}

			}
			if(found){
				System.out.print("Det finns redan en spelare med det valda tr�jnumret, v�lj ett annat!\n");
			}else{
				personList.add(new Player(FirstName, LastName, Age, Weight, StickHandling,
						SkateSize, ShirtNumber));
				System.out.print ("Spelaren har lagts till i registret\n");
				looping = false;
			}
		}
	}

	private void addCoach() { // Metod f�r att l�gga till en coach

		String FirstName = readString("\nCoachens f�rnamn: ");
		String LastName = readString("Coachens efternamn: ");
		int Age = readInt("Coachens �lder: ");
		double Weight = readDouble ("Coachens vikt: ");
		String Position = readString("Vilken position har personen?: ");
		System.out.print("\n");

		personList.add(new Coach(FirstName, LastName, Age, Weight, Position));
	}

	private void addStaffMember() { // Metod f�r att l�gga till en stabmedlem

		String FirstName = readString("\nPersonens f�rnamn: ");
		String LastName = readString("Personens efternamn: ");
		int Age = readInt("Personens �lder: ");
		double Weight = readDouble ("Personens vikt: ");
		String Role = readString("Vilken roll har personen i klubben?: ");
		System.out.print("\n");

		personList.add(new StaffMember(FirstName, LastName, Age, Weight, Role));
	}

	private int readInt(String Question) {
		for (;;) {
			try {
				System.out.print(Question);
				int x = Integer.parseInt(keyboard.nextLine());
				return x;
			}

			catch (NumberFormatException e) {
				System.out.println("Fel - det m�ste vara ett numeriskt v�rde");
			}
		}
	}

	private double readDouble(String Question) {
		for (;;) {
			try {
				System.out.print(Question);
				double x = Integer.parseInt(keyboard.nextLine());
				return x;
			}

			catch (NumberFormatException e) {
				System.out.println("Fel - det m�ste vara ett numeriskt v�rde");
			}
		}
	}

	private String readString(String Question) {
		System.out.print(Question);
		String str = keyboard.nextLine();
		return str;
	}

	private void addCoachOrStaffMember() { // Metod f�r att v�lja mellan att
		// skapa stabmedlem eller coach
		int command = readInt("Vilken person vill du l�gga till?" + "\n1-Coach"
				+ "\n2-Medarbetare" + "\nV�lj ett alternativ:");

		switch (command) {

		case 1:
			addCoach();
			break;
		case 2:
			addStaffMember();
			break;
		default:
			System.out.print("\nFelaktigt kommando, v�lj ett av de korrekta alternativen! \n \n");
		}
	}

	private void showPlayerInfo() {
		for(Person person : personList){
			Player player = null;
			if(person instanceof Player){
				player = (Player)person;
				String firstName = player.getFirstName();
				String lastName = player.getLastName();
				int age = player.getAge();
				double weight = player.getWeight();
				String stickHandling = player.getStickHandling();
				int skateSize = player.getSkateSize();
				int shirtNumber = player.getShirtNumber();
				System.out.print("***********" + "\nF�rnamn: " + firstName
						+ "\nEfternamn: " + lastName + "\n�lder: " + age
						+ "\nVikt: " + weight
						+ "\nKlubbfattning: " + stickHandling
						+ "\nSkridskostorlek: " + skateSize + "\nTr�jnummer: "
						+ shirtNumber + "\n                " + "\n");
			}
		}
	}

	private void showCoachInfo() {
		for(Person person : personList){
			Coach coach = null;
			if(person instanceof Coach){
				coach = (Coach)person;
				String firstName = coach.getFirstName();
				String lastName = coach.getLastName();
				int age = coach.getAge();
				double weight = coach.getWeight();
				String position = coach.getPosition();

				System.out.print("***********" + "\nF�rnamn: " + firstName
						+ "\nEfternamn: " + lastName + "\n�lder: " + age
						+ "\nVikt: " + weight
						+ "\nPosition: " + position + "\n" 
						+ "\n");
			}
		}
	}

	private void showStaffMemberInfo() {
		for(Person person : personList){
			StaffMember staffMember = null;
			if(person instanceof StaffMember){
				staffMember = (StaffMember)person;
				String firstName = staffMember.getFirstName();
				String lastName = staffMember.getLastName();
				int age = staffMember.getAge();
				double weight = staffMember.getWeight();
				String role = staffMember.getRole();

				System.out.print("***********" + "\nF�rnamn: " + firstName
						+ "\nEfternamn: " + lastName + "\n�lder: " + age
						+ "\nVikt: " + weight
						+ "\nRoll: " + role + "\n" + "\n");
			}
		}
	}

	private void listCoachOrStaffMember() { // Metod f�r att v�lja mellan att
		// skapa stabmedlem eller coach

		int command = readInt("Vilken roll vill du se information om?"
				+ "\n1-Coach" + "\n2-Medarbetare" + "\nV�lj ett alternativ:");

		switch (command) {

		case 1:
			showCoachInfo();
			break;
		case 2:
			showStaffMemberInfo();
		}
	}

	private void addResult() { // Metod f�r att l�gga till resultat
		String homeTeam = readString("\nAnge hemmalaget: ");
		String awayTeam = readString("Ange bortalaget: ");
		int homeTeamGoals = readInt("Ange hemmalagets antal m�l: ");
		int awayTeamGoals = readInt("Ange bortalagets antal m�l: ");

		matchResults.add(new Match(homeTeam, awayTeam, homeTeamGoals,
				awayTeamGoals));

		boolean looping = true;

		while (looping) {
			int command = readInt("\nF�r vilket lag vill du l�gga till en m�lskytt?: "
					+ "\nTryck 1 f�r att l�gga till m�lskytt i hemmalag "
					+ "\nTryck 2 f�r att l�gga till m�lskytt i bortalag "
					+ "\nTryck 3 f�r att sluta l�gga till m�lskyttar"
					+ "\nV�lj ett alternativ: ");

			switch (command) {

			case 1:
				findPlayer1();
				findPlayer2();
				break;
			case 2:
				findPlayer3();
				findPlayer4();
				break;
			case 3:
				looping = false;
				break;
			default:
				System.out.print("\nFelaktigt kommando, v�lj ett av de korrekta alternativen! \n \n");
			}
		}
	}

	private void listResult() { // Lista som visar sparade resultat
		for (Match match : matchResults) {
			String homeTeam = match.getHomeTeam();
			String awayTeam = match.getAwayTeam();
			int homeTeamGoals = match.getHomeTeamGoals();
			int awayTeamGoals = match.getAwayTeamGoals();
			System.out.print("***********" + "\n" + homeTeam + " "
					+ homeTeamGoals + " - " + awayTeamGoals + " " + awayTeam
					+ "\nHemmalag: " + homeTeam + "\nBortalag: " + awayTeam
					+ "\n\n");
		}
	}

	private void findPlayer1() {
		boolean looping = true;
		ArrayList<Player> playerList = new ArrayList<Player>();
		for (Person player : personList){
			if (player instanceof Player){
				playerList.add((Player)player);
			}
		}

		while (looping){
			boolean hittadSpelare = false;
			int HomeGoalMaker = readInt("Vem gjorde m�l f�r hemmalaget?(ange m�lskyttens tr�jnummer): ");
			for (int x =0; x<playerList.size(); x++) {
				Player player = playerList.get(x);
				if (player.getShirtNumber() == HomeGoalMaker){
					((Player) player).setGoal();
					looping = false;
					hittadSpelare = true;
					break;
				}
			}
			if(!hittadSpelare){
				System.out.print ("Finns ingen spelare med nummer " + HomeGoalMaker + " i systemet");
			}
		}
	}

	private void findPlayer2() {
		boolean looping = true;
		ArrayList<Player> playerList = new ArrayList<Player>();
		for (Person player : personList){
			if (player instanceof Player){
				playerList.add((Player)player);
			}
		}

		while (looping){
			boolean hittadSpelare = false;
			int HomeGoalAssist = readInt("Ange tr�jnumret f�r spelaren som assisterade till m�let: ");
			for (int x =0; x<playerList.size(); x++) {
				Player player = playerList.get(x);
				if (player.getShirtNumber() == HomeGoalAssist){
					((Player) player).setAssist();
					looping = false;
					hittadSpelare = true;
					break;
				}
			}
			if(!hittadSpelare){
				System.out.print ("Finns ingen spelare med nummer " + HomeGoalAssist + " i systemet");
			}
		}
	}

	private void findPlayer3() {
		boolean looping = true;
		ArrayList<Player> playerList = new ArrayList<Player>();
		for (Person player : personList){
			if (player instanceof Player){
				playerList.add((Player)player);
			}
		}

		while (looping){
			boolean hittadSpelare = false;
			int AwayGoalMaker = readInt("Vem gjorde m�l f�r hemmalaget?(ange m�lskyttens tr�jnummer): ");
			for (int x =0; x<playerList.size(); x++) {
				Player player = playerList.get(x);
				if (player.getShirtNumber() == AwayGoalMaker){
					((Player) player).setGoal();
					looping = false;
					hittadSpelare = true;
					break;
				}
			}
			if(!hittadSpelare){
				System.out.print ("Finns ingen spelare med nummer " + AwayGoalMaker + " i systemet");
			}
		}
	}
	
	private void findPlayer4() {
		boolean looping = true;
		ArrayList<Player> playerList = new ArrayList<Player>();
		for (Person player : personList){
			if (player instanceof Player){
				playerList.add((Player)player);
			}
		}

		while (looping){
			boolean hittadSpelare = false;
			int AwayGoalAssist = readInt("Ange tr�jnumret f�r spelaren som assisterade till m�let: ");
			for (int x =0; x<playerList.size(); x++) {
				Player player = playerList.get(x);
				if (player.getShirtNumber() == AwayGoalAssist){
					((Player) player).setAssist();
					looping = false;
					hittadSpelare = true;
					break;
				}
			}
			if(!hittadSpelare){
				System.out.print ("Finns ingen spelare med nummer " + AwayGoalAssist + " i systemet");
			}
		}
	}


	private void listPlayerPoints() {

		//Collections.sort(personList);
		ArrayList<Player> playerList = new ArrayList<Player>();
		for (Person player : personList){
			if (player instanceof Player){
				playerList.add((Player)player);
			}
		}
		Collections.sort(playerList);


		for (Player player : playerList) {
			if (player.getTotalPoints() >= 0) {	

				String firstName = player.getFirstName();
				String lastName = player.getLastName();
				int shirtNumber = ((Player) player).getShirtNumber();
				int totalPoints = ((Player) player).getTotalPoints();
				System.out.println("***********" + "\nSpelare: " + firstName
						+ " " + lastName + "\nPo�ng: " + totalPoints
						+ "\nTr�jnummer: " + shirtNumber + "\n");

			}
		}
	}

	private void erasePlayer() { // Metod f�r att ta bort en spelare
		String playerToDelete = readString("Vilken spelare skall tas bort? (Ange spelarens f�rnamn): ");
		String playerToDeleteLastName = readString("Ange spelarens efternamn: ");
		Player foundPlayer = null;

		for (Person player : personList) {
			String name = player.getFirstName();
			String lastName = player.getLastName();

			if (name.equalsIgnoreCase(playerToDelete)
					&& lastName.equalsIgnoreCase(playerToDeleteLastName)) {
				foundPlayer = (Player) player;
			}
		}

		if (foundPlayer != null) {
			personList.remove(foundPlayer);

			System.out.print(playerToDelete + playerToDeleteLastName
					+ " har tagit bort ur registret \n \n");

		} else {

			System.out.print("Spelaren " + playerToDelete
					+ " finns inte i registeret \n \n");
		}
	}

	private void eraseStaffMember() { // Metod f�r att ta bort en stabmedlem
		String staffMemberToDelete = readString("Vilken stabmedlem skall tas bort? (Ange stabmedlemmens namn): ");
		String staffMemberToDeleteLastName = readString("Ange stabmedlemmens efternamn: ");
		StaffMember foundStaffMember = null;

		for (Person staffMember : personList) {
			String name = staffMember.getFirstName();
			String lastName = staffMember.getLastName();

			if (name.equalsIgnoreCase(staffMemberToDelete)
					&& lastName.equalsIgnoreCase(staffMemberToDeleteLastName)) {
				foundStaffMember = (StaffMember) staffMember;

			}
		}

		if (foundStaffMember != null) {
			personList.remove(foundStaffMember);

			System.out.print(staffMemberToDelete + staffMemberToDeleteLastName
					+ " har tagit bort ur registret \n \n");

		} else {

			System.out.print("Stabmedlemmen " + staffMemberToDelete
					+ " finns inte i registeret \n \n");
		}
	}

	private void eraseCoach() { // Metod f�r att ta bort en spelare
		String coachToDelete = readString("Vilken coach skall tas bort? (Ange coachens namn): ");
		String coachToDeleteLastName = readString("Ange coachens efternamn: ");
		Coach foundCoach = null;

		for (Person coach : personList) {
			String name = coach.getFirstName();
			String lastName = coach.getLastName();

			if (name.equalsIgnoreCase(coachToDelete)
					&& lastName.equalsIgnoreCase(coachToDeleteLastName)) {
				foundCoach = (Coach) coach;

			}
		}

		if (foundCoach != null) {
			personList.remove(foundCoach);

			System.out.print(coachToDelete + coachToDeleteLastName
					+ " har tagit bort ur registret \n \n");

		} else {

			System.out.print("Coachen " + coachToDelete
					+ " finns inte i registeret \n \n");
		}
	}

	public static void main(String[] args) {

		new TeamInfo();
	}
}