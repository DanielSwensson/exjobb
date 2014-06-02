import java.util.*;

public class Registry {

	static Scanner sc = new Scanner(System.in);
	static ArrayList<Recipe> recipeRegistry = new ArrayList<Recipe>();
	static ArrayList<Measurement> measurementRegistry = new ArrayList<Measurement>();
	
	public static void listRecipes(){
		starLine();
		
		for(Object o : recipeRegistry){
			System.out.println((recipeRegistry.indexOf((Recipe)o) + 1) + ". " + ((Recipe)o).getName());
		}
		starLine();
	}

	public static void showRecipe(){
		listRecipes();
		System.out.println();
		
		int recipeNo = 0;
		
		for(;;){
				boolean nLoop = true;
					do{
						recipeNo = readInt("Ange receptets nummer: ");
						if (checkRecipeNumber(recipeNo) == true){
							nLoop = false;
						}else{
							echoInputError();
						}
						
					}while(nLoop == true);
						
				int recipePeople = readInt("Ange hur m�nga personer receptet ska ber�knas f�r: ");
				
				for(Recipe o : recipeRegistry){
					if (recipeNo == recipeRegistry.indexOf(o) + 1){
						Recipe r = (o.convertIngredients(recipePeople));
						r.printRecipe();
						break;
					}else if (recipeRegistry.indexOf(o) == -1){
						echoInputError();
						break;
					}
				}	
				starLine();
				break;
		}
	}

	public static void addRecipe() {

		System.out.println("Ange receptets namn och tryck p� Enter: ");
		String recipeName = sc.nextLine();
		
		int people = 0;
		
		for(;;){
			people = readInt("F�r hur m�nga personer �r receptet? ");
				break;
		}

		Recipe r = new Recipe(recipeName, people);

		for(;;){
			System.out.println("Skriv in en ingrediens, t.ex. MJ�L, �GG eller SENAP (skriv 0 n�r du �r klar): ");
			String ingrName = sc.nextLine();
			if (ingrName.equals("0"))
				break;
			
			r.addIngredient(new Ingredient(ingrName));
		} 
						
		for (int x = 0; x < r.rec.size(); x++) {
			Ingredient p = r.rec.get(x);	
			for(;;){
				try{
					System.out.println("Hur mycket " + p.getName().toLowerCase() + " ska det vara? Gl�m inte mellanslag f�re m�ttenheten! (0 f�r att avbryta): ");
					double am = sc.nextDouble();
					String unit = sc.nextLine();
					p.setAmount(am);
					p.setUnit(unit);
					break;
				}catch(InputMismatchException e){
					echoInputError();
					sc.nextLine();
				}
			}
		}		
		recipeRegistry.add(r);
		r.printRecipe();
		starLine();
	}
	
	public static void removeRecipe(){
		listRecipes();
		int rem = 0;
		
		if (recipeRegistry.size() == 0){
			System.out.println("Det finns inga recept i registret!");
			starLine();
		
		}else{
			rem = readInt("V�lj ett recept att ta bort (1-" + recipeRegistry.size() + "): ");
			
			for (Object o : recipeRegistry){
				if (rem == recipeRegistry.indexOf(o) + 1){
					recipeRegistry.remove(o);
					break;
				}else if (recipeRegistry.indexOf(o) == -1){
					echoInputError();
					break;
				}
			}
		}
	}
	
	public static void listMeasurements(){
		System.out.println("**********\n");
		System.out.println("TILLG�NGLIGA VOLYMM�TT\n");
		
		for (Measurement b : measurementRegistry){
			if (b instanceof VolumeMeasurement)
				System.out.println(((VolumeMeasurement)b).getUnit() + " = " + ((VolumeMeasurement)b).getEquivalent() + " ml");
		}
		
		System.out.println("\n");
		System.out.println("TILLG�NGLIGA VIKTM�TT\n");
		
		for (Measurement c : measurementRegistry){
			if (c instanceof WeightMeasurement)
				System.out.println(((WeightMeasurement)c).getUnit() + " = " + ((WeightMeasurement)c).getEquivalent() + " g");
		}
		starLine();
	}
	
	public static void addMeasurement() {
		
		String measName;
		
		do{
			measName = checkMeasurement("Ange m�ttets enhet: ");
		}while (measName == null);
		
		
		boolean loop = true;
		
		do{
			int measType = readInt("Vilken typ av m�tt �r det? (1 = volymm�tt, 2 = viktm�tt) ");
						
			int type = 0;
			double equiv = 0;
		
			switch(measType){
				case 1: 
					for(;;){
						equiv = readDouble("Hur m�nga milliliter motsvarar 1 " + measName + "? ");
						type = 1;
						break;
					}
					break;
					
				case 2:
					for(;;){
						equiv = readDouble("Hur m�nga gram motsvarar 1 " + measName + "? ");
						type = 2;
						break;
					}
					break;
				
				default: echoInputError();
					break;
			}
			makeNewMeasurement(type, measName, equiv);
			loop = false;
			System.out.println();
			
		}
		while(loop==true);
	}

	public static void convertMeasurement(){
		
		double am = readDouble("Ange m�ngden som ett heltal: ");
		String un= checkUnit("Ange m�ttenheten: ");
		
		double newAmount = 0;
		String newUnit = null;
		
		for (Measurement m : measurementRegistry){
			if (m.getUnit().equals(un.toLowerCase())){
				newAmount = m.getEquivalent()*am;
				if (m instanceof VolumeMeasurement){
					newUnit = "ml";
				}else{ 
					newUnit = "g";
				}
			}
		}
			
		System.out.println(am + " " + un + " motsvarar " + newAmount + " " + newUnit + ".\n\n");
	}
	
	public static boolean checkRecipeNumber(int p){
		for(Object o : recipeRegistry){
			if (recipeRegistry.indexOf(o) == p - 1){
				return true;
			}
		}
		return false;
	}
	
	public static void echoInputError(){
		System.out.println("Ogiltig inmatning. F�rs�k igen.\n");
	}
	
	public static String checkMeasurement(String str){
				
		System.out.println(str);
		String input = sc.nextLine();
			
		for (Measurement m : measurementRegistry){
			if (m.getUnit().toLowerCase().equals(input.toLowerCase())){
				System.out.println("Det finns redan en enhet med det namnet! ");
				return null;
			}
		}
		return input;
	}
	
	public static String checkRecipe(String str){
		
		System.out.println(str);
		String input = sc.nextLine();
			
		for (Recipe m : recipeRegistry){
			if (m.getName().toLowerCase().equals(input.toLowerCase())){
				System.out.println("Det finns redan ett recept med det namnet! ");
				return null;
			}
		}
		return input;
	}
	
	public static String checkUnit(String str){
 		
		for(;;){
			System.out.print(str);
			String input = sc.nextLine();
		
			for (Measurement o : measurementRegistry){
				if (o.getUnit().equals(input.toLowerCase())){
					return input;
				}
			}
		System.out.println("Enheten finns inte i registret.");			
		}
	}
	
	public static void starLine(){
		System.out.println("\n**********\n");
	}
	
 	public static void makeNewMeasurement(int type, String ut, double corr){
		if (type == 1){
				VolumeMeasurement v = new VolumeMeasurement(ut, corr);
				measurementRegistry.add(v);
		}else{
				WeightMeasurement w = new WeightMeasurement(ut, corr);
				measurementRegistry.add(w);
		}
	}
	
	public static double readDouble(String str){
		for(;;){
			try{
				System.out.print(str);
				double d = Double.parseDouble(sc.nextLine());
				return d;
			}catch(InputMismatchException e){
				System.out.println("Du m�ste ange ett tal. ");
			
			}catch(NumberFormatException e){
			System.out.println("Du m�ste ange ett tal. ");
			}
		}
	}
	
	public static int readInt(String str){
		for(;;){
			try{
				System.out.print(str);
				int d = Integer.parseInt(sc.nextLine());
				return d;
			}catch(InputMismatchException e){
				System.out.println("Du m�ste ange ett tal. ");
			}catch(NumberFormatException e){
				System.out.println("Du m�ste ange ett tal. ");
			}
		}
		
	}
 	
 	public static void createDummyMeasurements(){
		makeNewMeasurement(1, "dl", 100);
		makeNewMeasurement(1, "msk", 15);
		makeNewMeasurement(1, "tsk", 5);
		makeNewMeasurement(1, "krm", 1);
		
		makeNewMeasurement(0, "kg", 1000);
		makeNewMeasurement(0, "hg", 100);
		makeNewMeasurement(0, "lbs", 453.59243);
		makeNewMeasurement(0, "oz", 28.3495231);
	}
	
	public static void createDummyRecipes(){
		
		Ingredient korv = new Ingredient("Korv", 1.0, "st");
		Ingredient brod = new Ingredient("Br�d", 1.0, "st");
		Ingredient ket = new Ingredient("Ketchup");
		Ingredient sen = new Ingredient("Senap");
		
		Recipe korvmedbrod = new Recipe("Korv med br�d", 1);
		korvmedbrod.addIngredient(korv);
		korvmedbrod.addIngredient(brod);
		korvmedbrod.addIngredient(ket);
		korvmedbrod.addIngredient(sen);
		
				
		Ingredient mjolk = new Ingredient("Mj�lk", 8.0, "dl");
		Ingredient kakao = new Ingredient("Kakao", 3.0, "msk");
		Ingredient socker = new Ingredient("Socker", 3.0, "msk");
				
		Recipe varmchoklad = new Recipe("Varm choklad", 4);
		varmchoklad.addIngredient(mjolk);
		varmchoklad.addIngredient(kakao);
		varmchoklad.addIngredient(socker);
		
		
		Ingredient fars = new Ingredient("K�ttf�rs", 500, "g");
		Ingredient agg = new Ingredient("�gg", 1.0, "st");
		Ingredient lok = new Ingredient("L�k", 1.0, "st");
		Ingredient salt = new Ingredient("Salt", 1.0, "tsk");
		Ingredient peppar = new Ingredient("Peppar");
		Ingredient smor = new Ingredient("Sm�r att steka i");
		
		Recipe kottbullar = new Recipe("K�ttbullar", 6);
		kottbullar.addIngredient(fars);
		kottbullar.addIngredient(agg);
		kottbullar.addIngredient(lok);
		kottbullar.addIngredient(salt);
		kottbullar.addIngredient(peppar);
		kottbullar.addIngredient(smor);
		
		
		Ingredient sprit = new Ingredient("Hembr�nt", 8, "cl");
		Ingredient falu = new Ingredient("Falukorv", 1, "skiva/skivor");
		
		Recipe sunrise = new Recipe("Pajala Sunrise", 1);
		sunrise.addIngredient(sprit);
		sunrise.addIngredient(falu);
		
		Registry.recipeRegistry.add(sunrise);
		Registry.recipeRegistry.add(kottbullar);
		Registry.recipeRegistry.add(varmchoklad);
		Registry.recipeRegistry.add(korvmedbrod);		
	}
	
	public static void main(String[] args) {

		boolean bool = true;
		
		createDummyRecipes();
		createDummyMeasurements();

		System.out.println("RECEPTDATABASEN 1.0\n\n");

		do {
			System.out.println("  1. Lista alla recept\n  " 
					+ "2. Visa recept\n  "
					+ "3. L�gg till recept\n  " 
					+ "4. Ta bort recept\n  " 
					+ "5. Visa m�ttenheter\n  " 
					+ "6. L�gg till m�ttenhet\n  "
					+ "7. Konvertera m�tt\n  "
					+ "8. Avsluta programmet\n\n");

			System.out.print("V�lj ett alternativ (1-8): ");

			try {
				int m = sc.nextInt();
				sc.nextLine();

				switch (m) {
				case 1:
					listRecipes();
					break;
				case 2:
					showRecipe();
					break;
				case 3:
					addRecipe();
					break;
				case 4: 
					removeRecipe();
					break;
				case 5:
					listMeasurements();
					break;
				case 6: 
					addMeasurement();
					break;
				case 7:
					convertMeasurement();
					break;
				case 8:
					System.out.println("V�lkommen �ter!");
					System.exit(0);
				default:
					echoInputError();
					break;
				}
			} catch (InputMismatchException c) {
				echoInputError();
				sc.nextLine();
			}
		} while (bool == true);
	}
}
