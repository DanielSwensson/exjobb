import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {
	private static Scanner kb = new Scanner(System.in);
	private static ArrayList<Personer>alist = new ArrayList<Personer>();
	private static ArrayList<Prylar>pryllist = new ArrayList<Prylar>();
	
	public static void main(String[] args){
		
		while(true){
			System.out.println("1:Skapa Person 2:Skapa Pryl 3:Visa Alla 4:Visa Rikaste 5:Visa Viss Person 6:Börskrasch 7:Avsluta");
			int välja=0;
			
			try{
			välja = kb.nextInt();
			}catch(InputMismatchException e){
				kb.nextLine();
			}
			switch(välja){	
			
			case 1:
				//Skapa person
				System.out.println("Skriv in namnet på personen du vill skapa");
				String namn = kb.next();
				for(int o=0;o<alist.size();o++){
					if(alist.get(o).getNamn().equals(namn)){
						System.out.println("Finns redan");
						main(args);
					}
				}
				int förmögenhet = 0;
				Personer ny = new Personer(namn, förmögenhet);
				alist.add(ny);
				break;
				
			case 2:
				//Skapa pryl

				String pNamn;
				String sök = kb.nextLine();
				if (alist.isEmpty()==false){
				System.out.print("Vem äger prylen?");
				sök = kb.nextLine();
				synchronized (alist)
				{
				  for (int x=0;x<alist.size();x++)
				  {
					  if (alist.get(x).getNamn().equals(sök)){
					  
						  int värde = 0;

						  System.out.println(sök +" Finns");
						  namn = sök;
						  System.out.println("Vilken sorts pryl?");
//						  String ägare = sök;
						  String typ = kb.next();
						  if (typ.equals("smycke")){
							  System.out.println("Vilken typ av smycke?");
							  pNamn = kb.next();
							  System.out.println("Är den guld eller silver?");
							  String material = kb.next();
							  if(material.equals("guld")){
								  System.out.println("guld är 2000kr");
								  värde = 2000;
							  }
							  if(material.equals("silver")){
								  System.out.println("silver är 700kr");
								  värde = 700;
							  }
							  System.out.println("Skriv antal ädelstenar som smycket har");
							  int diamanter=0;
							  try{
								 diamanter = kb.nextInt();
							  }catch(InputMismatchException e){
										kb.nextLine();
									}
							  
							  värde = värde+(diamanter*500);
							  förmögenhet=värde;
							  System.out.println(diamanter+" antal ädelstenar och att smycket är gjort av "+material+" gör att den är värd "+värde);
							  smycke nysmycke = new smycke(pNamn, typ, värde, namn, material, diamanter,förmögenhet);
							  
							  for (Personer q:alist){
									if (q.getNamn().equals(namn)){
										q.öka(förmögenhet);
									}
								}
							  pryllist.add(nysmycke);	  
						  }
						  
						  if (typ.equals("aktie")){
							  System.out.println("Vilket företag?");
							  pNamn = kb.next();
							  System.out.println("Hur mycket är den värd?");
 
							  int pris = 0;
							  try{
								  pris = kb.nextInt();
									}catch(InputMismatchException e){
										kb.nextLine();
									}
							  System.out.println("Hur många har du?");
							  int antal = 0 ;
								try{
									antal = kb.nextInt();
									}catch(InputMismatchException e){
										kb.nextLine();
									} 
							  värde = pris*antal;
							  förmögenhet=värde;
							  System.out.println("du har "+antal+" aktier i företaget "+pNamn+" som är värda "+värde+" kr");
							  aktie nyaktie = new aktie(pNamn, typ, värde, namn, antal, pris,förmögenhet);
							  	
							  for (Personer h:alist){
									if (h.getNamn().equals(namn)){
										h.öka(förmögenhet);
									}
								}
							  
							  pryllist.add(nyaktie);
							  
						  }
						  if (typ.equals("apparat")){
							  System.out.println("Vilken typ av apparat?");
							  pNamn = kb.next();
							  System.out.println("Vad var inköpspriset?");
							  int pris = 0;
							  try{
								  pris = kb.nextInt();
									}catch(InputMismatchException e){
										kb.nextLine();
									} 
							  System.out.println("Hur sliten är den? Skriv ett tal mellan 1-10 där 1 är dåligt och 10 är som ny");
							  int slitage = 0;
							  try{
								  slitage = kb.nextInt();
									}catch(InputMismatchException e){
										kb.nextLine();
									} 
							  värde = (int) (slitage*0.1*pris);
							  System.out.println("Din "+pNamn+" är värd "+värde+" kr");
							  förmögenhet=värde;
							  apparat nyapparat = new apparat(pNamn, typ, värde, namn, slitage,förmögenhet);
							  
							  for (Personer j:alist){
									if (j.getNamn().equals(namn)){
										j.öka(förmögenhet);
									}
								}
							  
							  pryllist.add(nyapparat);
							  break;
						  		}	
					  		}
				  		}
				 	}	
				}
				break;
			case 3:
				//Visa alla
				for(int x = 0; x<alist.size();x++){
					for(int u=0;u<pryllist.size();u++){
						if (alist.get(x).equals(pryllist.get(u))){
							}
						}
					System.out.println(alist.get(x));
			}
				break;

			case 4:
				//Visa rikaste
				int rikaste=0;
				String rik="ingen";
				for(Personer z:alist){
					if (rikaste<z.getFörmögenhet()){
						rik=z.getNamn();
						rikaste=z.getFörmögenhet();
					}
				}
				System.out.println("Rikaste personen är "+rik+" med "+rikaste+" kr");

				for(Prylar k:pryllist){
					
					if (k.getNamn().equalsIgnoreCase(rik)){
						System.out.println(k.getPNamn()+" värd "+k.getVärde()+" kr");
					}
				}	
				break;
			case 5:
				//Visa viss person
				int total=0;
				System.out.println("Skriv namnet på personen som du letar efter");
				String söker = kb.next();
				for(Personer x:alist){
					if(söker.equals(x.getNamn())){
						total =x.getFörmögenhet();
						söker = x.getNamn();
						System.out.println(söker +" har "+total +" kr");
						for(Prylar k:pryllist){
							if (k.getNamn().equalsIgnoreCase(söker)){
							System.out.println(k.getPNamn()+" värd "+k.getVärde()+" kr");
							}
						}	
					}
				}		
				break;
			case 6:
				//Börskrasch
				int tasbort = 0;
					for(Personer v:alist){

					for(Prylar f:pryllist){
						if(f.getTyp().equalsIgnoreCase("aktie")){
								tasbort=f.getVärde();						
								if(v.getNamn().equalsIgnoreCase(f.getNamn())){
									v.sänka(tasbort);
									f.sänka(tasbort);	
									}
								}
							}
						}
				break;
			case 7:
				//Avsluta. Programmet avslutas.
				System.exit(0);	
			default:
				System.out.println("Skriv ett tal mellan 1-7");
			}
		}
	}
}