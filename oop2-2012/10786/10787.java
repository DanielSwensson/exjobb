import java.util.*;

public class Register {
	//Listar alla personer.
	static ArrayList<Person> personList = new ArrayList<Person>(); 

	public static void main(String[] args) {
		mainMenu();
	}
	//Hanterar huvudmenyn.
	private static void mainMenu() {
		while(true){
			String commando = getString("Tillg�ngliga kommandon:\nNy person\nL�gg till workout\nVisa alla\nTa bort workout\nAvsluta\nSkriv kommando: ");
			switch (commando){
				case "Ny person":
					personList.add(new Person(getString("Namn: ")));
					break;
				case "L�gg till workout":
					workoutMenu();
					break;
				case "Visa alla":
					VisaAlla();
					break;
				case "Ta bort workout":
					VisaAlla();
					RemoveWorkout();
					break;
				case "Avsluta":
					System.exit(0);
				default:
			}	
		}
	}
	//Hanterar menyn f�r workout.
	private static void workoutMenu() {
		String commando;
		String question = "nej";
		
		while(question.equals("nej")){
			String workoutType;
			int min;
			int sec;
			Workout workout;
			String name = getString("Vilken person? ");
			int personIndex = FindPersonIndex(name, personList);
			
			if (personIndex == -1){
				System.out.println("Personen finns inte.");
				break;
			}
			else{
				commando  = getString("Tillg�ngliga typer:\nAMRAP\nTabata\nStyrkepass\nFor time\nAvsluta\nVilken typ?: ");
				switch(commando){
				
				case "AMRAP":
					workoutType = getString("Workout namn: ");
					min = getInt("Antal minuter");
					sec = getInt("Antal sekunder");
					workout = exerciseMenu(new AMRAP(workoutType, min, sec));
					workout.setWorkoutResult(resultMenu(commando));
					personList.get(personIndex).Add(workout);
					break;		
				case "Tabata": 
					workoutType = getString("Workout namn: ");
					System.out.println("Arbete:");
					min = getInt("Antal minuter");
					sec = getInt("Antal sekunder");
					System.out.println("Vila:");
					int restMin = getInt("Antal minuter");
					int restSec = getInt("Antal sekunder");
					workout = exerciseMenu(new Tabata(workoutType, min, sec, restMin, restSec));
					workout.setWorkoutResult(resultMenu(commando));
					personList.get(personIndex).Add(workout);
					break;	
				case "Styrkepass":
					workoutType = getString("Workout namn: ");
					workout = exerciseMenu(new StrengthWorkout(workoutType));
					workout.setWorkoutResult(resultMenu(commando));
					personList.get(personIndex).Add(workout);
					break;	
				case "For time":
					workoutType = getString("Workout namn: ");
					workout = exerciseMenu(new ForTime(workoutType));
					workout.setWorkoutResult(resultMenu(commando));
					personList.get(personIndex).Add(workout);
					break;
				case "Avsluta":
					break;
				default:
					System.out.print("Fel");
				
				}
				question = getString("Klar med att mata in workouts? ");
			}
		}
	}
	//Hanterar menyn f�r exercise.
	private static Workout exerciseMenu(Workout workout){
		String commando;
		String exerciseName;
		String equipment;
		int amount;
		String question = "nej";
		
		while(question.equals("nej")){
			commando = getString("Tillg�ngliga typer:\nGymnastisk\nStyrka\nDistans\nAvsluta\nVilken typ? ");
			switch(commando){
			case "Gymnastisk":
				exerciseName = getString("�vningsnamn: ");
				equipment = getString("Utrustning: ");
				amount = getInt("Antal repetitioner");
				workout.Add(new Gymnastic(exerciseName, equipment, amount));
				question = getString("Klar med att mata in �vningar? ");
				break;
			case "Styrka":
				exerciseName = getString("�vningsnamn: ");
				equipment = getString("Utrustning: ");
				amount = getInt("Antal repetitioner");
				int weight = getInt("Vikt");
				workout.Add(new Strength(exerciseName, equipment, weight, amount));
				question = getString("Klar med att mata in �vningar? ");
				break;
			case "Distans":
				exerciseName = getString("�vningsnamn: ");
				equipment = getString("Utrustning: ");
				amount = getInt("Antal repetitioner");
				int length = getInt("L�ngd i meter");
				workout.Add(new Distance(exerciseName, equipment, length, amount));
				question = getString("Klar med att mata in �vningar? ");
				break;
			case "Avsluta":
				question = getString("Klar med att mata in �vningar? ");
				break; 
			default:
				System.out.print("Fel �vningstyp");
			}	
		}
		return workout;
	}
	//Tar brt ett pass f�r en person.
	private static void RemoveWorkout(){
		try{
		personList.get(FindPersonIndex(getString("Namn p� den du vill ta bort fr�n: "), personList)).
										Remove(getInt("Skriv in nummret p� den du vill ta bort") - 1);
		}
		catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Ange f�rst vilken person och sedan numret p� den workout du vill ta bort.");
		}
		catch(IndexOutOfBoundsException e){
			System.out.println("Finns inte i listan");
		}
	}
	
	//Retunerar index f�r en person
	private static int FindPersonIndex(String name, ArrayList<Person> allPersons){
		for (int i = 0; i < allPersons.size(); i++){
			if(allPersons.get(i).getName().equals(name)){
				return i;
			}
		}
		return -1;
	}
	//Visar alla personer och deras pass.
	private static void VisaAlla(){
		for(Person person : personList){
			System.out.println(person);
		}
	}
	//Hanterar inmatning av resultat
	private static WorkoutResult resultMenu(String commando){
		System.out.println("Skriv in ditt resultat.");
		switch(commando){
		case "For time":
			Time time = new Time(getInt("Antal sekunder"), getInt("Antal minuter"));
			return new WorkoutResult(time);
		case "AMRAP":
		case "Tabata":
		case "Styrkepass":
			int doneSets = getInt("Hur m�nga set?");
			int doneReps = getInt("Hur m�nga reps?");
			return new WorkoutResult(doneSets, doneReps);
		}
		return null;
	}
	//Metoden tar in ett meddelande t.ex. "Tid: " och v�ntar tills anv�ndaren matat in en korrekt siffra
	private static int getInt(String prompt){
		Scanner sc = new Scanner(System.in);
		boolean done = false;
		while (!done){
			System.out.print(prompt + ": ");
			try{
				int number = sc.nextInt();
				done = true;
				return number;
				}
				catch (InputMismatchException e){
					System.out.println("Fel, m�ste vara en siffra");
					sc.nextLine();
				}
				catch (NumberFormatException e){
					System.out.println("Fel, m�ste vara en siffra");
					sc.nextLine();
				}
				catch (NoSuchElementException e){
					System.out.println("Finns inga.");
					sc.nextLine();
				}
		}
		return 0;
}
	//Metoden tar in ett meddelande och v�ntar p� att anv�ndaren matat in en str�ng, returnerar denna efter att ev. fel tagits hand om
	private static String getString(String prompt){
			Scanner sc = new Scanner(System.in);
			boolean done = false;
			while (!done)
				{
				System.out.print(prompt);
				try
					{
					String text = sc.nextLine();
					done = true;
					return text;
					}
					catch (InputMismatchException e)
						{
						System.out.println("Fel, m�ste vara en text");
						sc.nextLine();
						}
					catch (NoSuchElementException e){
						System.out.println("Finns inga.");
						sc.nextLine();
					}
				
					}
			return "N/A";
					
		
	}
	
}
