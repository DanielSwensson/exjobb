import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;



public class PrylRegister {
	
	
	public static void main(String[]args){
		
		ArrayList<Person> personLista = new ArrayList<Person>();
		boolean hittad;
		boolean ok;
		Person aktuell = null;
		String namn;
		Scanner sc = new Scanner(System.in);
		int val = 0;
		
		while(val!= 7){
			
			do{
				ok = true;	
				System.out.println("1. Skapa person\n2. Skapa pryl\n3. Visa alla\n4. Visa Rikaste\n5. Visa viss person\n6. Börskrasch\n7. Avsluta");
				try{
					System.out.print("Kommando:");
					val = sc.nextInt();
					sc.nextLine();//tar upp enterslaget
				}catch(InputMismatchException e){
					ok = false;
					sc.next();
					System.out.println("Skriv en siffra!");
				}
			}while(!ok);
			
			switch(val){
				case 1:
					System.out.print("Namn:");
					namn = sc.nextLine();
					hittad = false;
					for(Person p: personLista){
						if(p.getNamn().equals(namn)){
							hittad = true;
						}
					}			
					if(hittad == true)
						System.out.println("Personen finns redan i registret");
					else
						personLista.add(new Person(namn));
					break;
					
				case 2:
					System.out.print("Ägare:");
					namn = sc.nextLine();
					hittad = false;
					for(Person p: personLista){
						if(p.getNamn().equals(namn)){
							hittad = true;
							aktuell = p;
						}
					}			
					if(hittad == false)
						System.out.println("Fel! Personen finns inte i registret");
					
					else{
						System.out.print("Vilken sorts Pryl?: ");
						String prylTyp = sc.nextLine();
						prylTyp.toLowerCase(); //??
						
						switch(prylTyp){
							case "smycke":
								System.out.print("Vilket sorts smycke?: ");
								String sort = sc.nextLine();
								System.out.print("Är smycket av guld? ja/nej: ");
								boolean guld = false;
								if(sc.nextLine().equals("ja")){
									guld = true;
								}
								do{
									ok = true;
									System.out.print("Hur många ädelstenar?:");
									try {
										int stenar = Integer.parseInt(sc.nextLine()); //om ej siffra,testa
										aktuell.addPryl(new Smycke(sort, guld, stenar));
									}catch (NumberFormatException e) {
										System.out.println("Fel! Du skrev inte en siffra.");
										ok = false;
									}
								}while(!ok);
								break;
								
							case "aktie": 
								System.out.print("Aktienamn:");
								namn=sc.nextLine();
								int antal;
								int pris;
								do{
									ok = true;
									try{
										System.out.println("Antal: ");
										antal = Integer.parseInt(sc.nextLine());
										System.out.println("Pris per aktie");
										pris = Integer.parseInt(sc.nextLine());
										aktuell.addPryl(new Aktie(namn, antal, pris));
									}catch(NumberFormatException e){
										System.out.println("Fel! Du skrev inte en siffra.");
										ok = false;
									}
								}while(!ok);
							
								break;
								
							case "apparat":
								System.out.print("Namn: ");
								namn = sc.nextLine();
								do{
									ok = true;
									try{
										System.out.print("Grundpris: ");
										double grundPris = Double.parseDouble(sc.nextLine());			
										System.out.print("Slitage(1-10): ");
										int slitage = Integer.parseInt(sc.nextLine());
										aktuell.addPryl(new Apparat(namn, grundPris, slitage));
									}catch(NumberFormatException e){
										System.out.println("Fel! Du skrev inte en siffra.");
										ok = false;
									}catch(IllegalArgumentException e){
										System.out.println("Slitage måste vara mellan 1-10");
										ok = false;
									}
							}while(!ok);
							break;
								
							default:
								System.out.println("Finns inte!");
								break;
						}
						
						
					}
					break;//case 2
					
				case 3:
					System.out.println("I registret finns:");
					for(Person p: personLista){
						System.out.println(p.getNamn() + " " + p.getVärde());
					}
					break;
				case 4:
					double max = 0;
					Person maxPerson = null;
					for(Person p: personLista){
						if(p.getVärde() > max){
							max = p.getVärde();
							maxPerson = p;
						}
					}
					try{
					System.out.println("Namn: "+ maxPerson.getNamn() + "\nTotalt värde: "+ maxPerson.getVärde());
					maxPerson.printPrylar();
					}catch(NullPointerException e){
						System.out.println("Finns inga personer i listan med prylar");
					}
					break;
				case 5:
					System.out.print("Namn:");
					namn = sc.nextLine();
					hittad = false;
					for(Person p: personLista){
						if(p.getNamn().equals(namn)){
							hittad = true;
							aktuell = p;
						}
					}			
					if(hittad == true){
						System.out.println(aktuell.getNamn());
						aktuell.printPrylar();
					}
						
					else
						System.out.println("Personen finns inte i registret");
					break;
				case 6:
					for(Person p: personLista){
						p.börskrasch();
					}
					break;
				
			}
			
		}
		
		System.out.print("Avslutar...");
		
	}//Main
	
	
/*
	public static void SkapaPerson(){
	}
	public static void SkapaPryl(){
		System.out.println("b");
	}
	public static void VisaAlla(){
		System.out.println("c");
	}
	public static void VisaRikaste(){
		System.out.println("d");
	}
	public static void VisaVissPerson(){
		System.out.println("e");
	}
*/	
}//class
