public class Main {

	public static void main(String[] args) {

		HuvudProgram hp = new HuvudProgram();
		System.out.println("Hej och välkommen till Prylprogrammet! ");
		System.out.println("1. Skapa Person");
		System.out.println("2. Skapa Pryl");
		System.out.println("3. Visa Alla");
		System.out.println("4. Visa Rikaste");
		System.out.println("5. Visa en viss persson");
		System.out.println("6. Börscrash");
		System.out.println("7. Avsluta");
		System.out.print(" ===========> ");

		for (;;) {
			int val = hp.readInt("Ange kommando 1-7: ");
			switch (val) {
			case 1:hp.skapaPerson(); break;
			case 2:hp.skapaPryl(); break;
			case 3:hp.visaAlla(); break;
			case 4:hp.visaRikaste(); break;
			case 5:hp.visaViss(); break;
			case 6:hp.börsKrasch(); break;
			case 7:System.out.println("Tack och hej då!");
				System.exit(0);
			default:System.out.println("Fel kommando");
			}
		}
	}
}
