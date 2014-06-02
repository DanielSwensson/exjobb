import java.util.ArrayList;
import javax.swing.*;


public class Prylsamling {

	private ArrayList<Person> allaPersoner = new ArrayList<Person>();
	public Prylsamling() {

	}
	public void visaMeny(){

		while(true){

			String meny = JOptionPane.showInputDialog("Vad vill du göra? \n 1. Skapa person\n 2. Skapa pryl \n 3. Visa alla personer\n 4. Visa rikaste person\n 5. Visa viss person\n 6. Börskrasch\n 7. Avsluta programmet");

			switch (meny){

			case "1":
				finnsNamn();				
				break;
			case "2":
				skapaPryl();			
				break;

			case "3":
				visaAlla();				
				break;

			case "4":
				visaRikaste();		
				break;

			case "5":
				visaPerson();	
				break;

			case "6":

				for(Person p : allaPersoner){
					p.börskrasch();		
				}
				break;

			case "7":
				JOptionPane.showMessageDialog(null,"Programmet kommer nu att avslutas");
				System.exit(0);
			default:
				JOptionPane.showMessageDialog(null, "Felaktigt kommando");
			}
		}
	}

	public void skapaPryl(){
		String namn = JOptionPane.showInputDialog(" Vilken person äger prylen?");
		Person p1 = hämtaPerson(namn);
		if (p1 == null) {
			JOptionPane.showMessageDialog(null, "Namnet finns inte i listan");
			return;
		}

		String nyPryl = JOptionPane.showInputDialog(" Vad är det för typ av pryl?\n 1. Smycke \n 2.Aktie\n 3. Apparat");

		Pryl s = null;
		switch (nyPryl){
		case "1":
			String smycke = JOptionPane.showInputDialog("Vilken typ av smycke vill du skapa?");
			String guldsmycke = JOptionPane.showInputDialog("Vilken metall är smycket av?");
			int ädelstenar = readInt("Hur många ädelstenar har smycket?");										

			boolean guld = false;

			if(guldsmycke.equals("guld")){
				guld = true;
			}					
			s = new Smycke(smycke, guld, ädelstenar);// skapar nytt prylobjekt

			break;

		case "2":
			String aktie = JOptionPane.showInputDialog(null, "Vad heter aktiebolaget?");	
			double styckpris = readDouble("Till vilket styckpris är aktieandelarna inköpta?");
			int antal = readInt("Hur många aktieandelar vill du lagra?");

			s = new Aktie(aktie, styckpris, antal);

			break;


		case "3":
			String apparat = JOptionPane.showInputDialog(null, "Vad är det för slags apparat?");
			int slitage = readInt("Vilket slitage skulle du ange apparaten har på en skala från 1-10, där 10 anses som ny?");
			int inköpspris = readInt("Till vilket pris köptes apparaten in?");
			s = new Apparater(apparat, slitage, inköpspris);
			break;

		default:
			JOptionPane.showMessageDialog(null, "Felaktigt kommando");

		}
		if(s != null){
			p1.adderaPryl(s);
		}			
		return;
	}
	public void visaAlla(){
		if(allaPersoner.isEmpty()){
			JOptionPane.showMessageDialog(null, "Listan är tom");
		}
		else{

			JOptionPane.showMessageDialog(null,"I registret finns:");			

			for(Person p : allaPersoner) {				
				String output = p.printShort();
				JOptionPane.showMessageDialog(null, output);
			}	
		}
	}
	public void finnsNamn(){
		boolean finnsnamn = true;
		while(finnsnamn){
			String	namn =JOptionPane.showInputDialog("Skriv in namn på personen");
			Person p1 = hämtaPerson(namn);
			if (p1 != null) {
				JOptionPane.showMessageDialog(null, "Person med valt namn finns redan, välj ett annat");
			}
			else{
				Person p = new Person(namn);
				allaPersoner.add(p);
				finnsnamn = false;					}
		}				//allaPersoner.add(new Person(p));
	}
	public void visaRikaste(){
		double highestValue = Integer.MIN_VALUE;
		Person rikaste = null;
		for(Person p : allaPersoner){
			if (p.getSum() > highestValue){
				highestValue = p.getSum();
				rikaste = p;
			}
		}
		String ägodelar = rikaste.printValue();
		JOptionPane.showMessageDialog(null, ägodelar);

	}
	public void visaPerson(){
		String namn =JOptionPane.showInputDialog(null, "Ange namn på person du vill se:");
		Person p1 = hämtaPerson(namn);
		if(p1 == null){
			JOptionPane.showMessageDialog(null," person finns inte");
		}
		else{
			String output = p1.printValue() + "\n";
			output += p1.getSum();
			JOptionPane.showMessageDialog(null,output);		
		}
	}
	public Person hämtaPerson(String finnsNamn) {
		for (Person pe: allaPersoner) {
			if ( pe.getNamn().equalsIgnoreCase(finnsNamn) ) {

				return pe;
			}
		}return null;
	}


	public int readInt(String fråga){
		for(;;){
			try{
				int x= Integer.parseInt(JOptionPane.showInputDialog(null, fråga));
				return x;

			}
			catch (NumberFormatException e){
				JOptionPane.showMessageDialog(null,"Fel format vänligen ange heltal: ");

			}
		}
	}
	public double readDouble(String fråga){
		for(;;){
			try{
				double x = Double.parseDouble(JOptionPane.showInputDialog(null, fråga));
				return x;

			}
			catch (NumberFormatException e){
				JOptionPane.showMessageDialog(null,  "Fel format vänligen ange ett tal: ");
			}
		}

	}



	//private String JOptionPaneMessageDialog(Object object, String string) {
	// TODO Auto-generated method stub
	//return null;
	//}
}



