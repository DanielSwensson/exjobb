import java.util.ArrayList;

	public class WorkoutManager {
		private ArrayList<Exercise> exercises = new ArrayList<Exercise>();

		private Menu menu;
		private User currentUser;
		
		public WorkoutManager(){
			Menu mainMenu = new Menu("Workout");
			mainMenu.addMenuItem(new MenuItem("Register cardio", 'c'));
			mainMenu.addMenuItem(new MenuItem("Register steps", 's'));
			mainMenu.addMenuItem(new MenuItem("Register weightlifting", 'w'));
			mainMenu.addMenuItem(new MenuItem("List exercises", 'l'));
			mainMenu.addMenuItem(new MenuItem("List exercises by type", 't'));
			mainMenu.addMenuItem(new MenuItem("Go to parent menu", 'p'));
			menu = mainMenu;
		}
	
		public void runMenu(User user){
			this.currentUser = user;

			boolean menuBreak = false;
			do {
				menu.printMenu();
				Character userMenuChoice = menu.getMenuChoice();
				switch (userMenuChoice.toString()){
					case "c" : //cardio
						registerCardio();
						break;
					case "s" : //stepcount
						registerWalk();
						break;
					case "w" : //weightlifting
						registerWeightlifting();
						break;
					case "l" : //list all exercises
						listAllExercises();
						break;
					case "t": //list all exercises by type
						listAllExercisesByType();
						break;
					case "p" : //g
						menuBreak = true;
						break;
					}
			}while(menuBreak == false);
		}

		private void listAllExercises() {
			Io.printHeader("Exercises", 1);

			if (exercises.size() >= 1) {
				for (Exercise e : exercises){
					System.out.print(e);
				}
			}
			
			printSummary();

		}

		private void listAllExercisesByType(){
			Io.printHeader("Cardio", 1);
			for (Exercise e: exercises){
				e.calculateDuration();
				if (e instanceof Cardio){
					System.out.print(e);
				}
			}
			Io.printHeader("Walks", 1);
			for (Exercise e: exercises){
				e.calculateDuration();
				if (e instanceof Promenade){
					System.out.print(e);
				}
			}
			
			Io.printHeader("Weightlifting", 1);
			for (Exercise e: exercises){
				e.calculateDuration();
				if (e instanceof Weightlifting){
					System.out.print(e);
				}
			}
			
			printSummary();
		}
		private void printSummary(){
			Io.printHeader("Summary", 1);
			
			double totalCalories = 0;
			int NumberOfExercises = 0;
			int totalDurationInMinutes = 0;

			for (Exercise e: exercises){
				NumberOfExercises++;
				totalCalories = totalCalories + e.getCaloriesBurned();
				totalDurationInMinutes = totalDurationInMinutes+ e.getDurationInMinutes();
			}
			
			String summaryText = "";
			summaryText = summaryText +"  Numbers of exercises:"+ NumberOfExercises;
			summaryText = summaryText +"\n  Total calories burned:" + (Math.round(totalCalories*10)/10.0) +" kcal";
			summaryText = summaryText +"\n  Duration :"+totalDurationInMinutes + " mins";
			System.out.println(summaryText);
		}
		private void registerWeightlifting() {
			Weightlifting weights = new Weightlifting();
			weights.finaliseExercise();
			exercises.add(weights);
			System.out.println("<<saved>>");
		}

		private void registerWalk(){
			Promenade promenade = new Promenade();
			promenade.finaliseExercise(currentUser.getStrideLength());
			exercises.add(promenade);

			System.out.println("<<saved>>");
		}

		private void registerCardio() {
			Cardio cardio = new Cardio();
			cardio.finaliseExercise();
			exercises.add(cardio);
			System.out.println("<<saved>>");
		}
	
	}