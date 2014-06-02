import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {
	private static Scanner kb = new Scanner(System.in);
	private static ArrayList<Personer>alist = new ArrayList<Personer>();
	private static ArrayList<Prylar>pryllist = new ArrayList<Prylar>();
	
	public static void main(String[] args){
		
		while(true){
			System.out.println("1:Skapa Person 2:Skapa Pryl 3:Visa Alla 4:Visa Rikaste 5:Visa Viss Person 6:B�rskrasch 7:Avsluta");
			int v�lja=0;
			
			try{
			v�lja = kb.nextInt();
			}catch(InputMismatchException e){
				kb.nextLine();
			}
			switch(v�lja){	
			
			case 1:
				//Skapa person
				System.out.println("Skriv in namnet p� personen du vill skapa");
				String namn = kb.next();
				for(int o=0;o<alist.size();o++){
					if(alist.get(o).getNamn().equals(namn)){
						System.out.println("Finns redan");
						main(args);
					}
				}
				int f�rm�genhet = 0;
				Personer ny = new Personer(namn, f�rm�genhet);
				alist.add(ny);
				break;
				
			case 2:
				//Skapa pryl

				String pNamn;
				String s�k = kb.nextLine();
				if (alist.isEmpty()==false){
				System.out.print("Vem �ger prylen?");
				s�k = kb.nextLine();
				synchronized (alist)
				{
				  for (int x=0;x<alist.size();x++)
				  {
					  if (alist.get(x).getNamn().equals(s�k)){
					  
						  int v�rde = 0;

						  System.out.println(s�k +" Finns");
						  namn = s�k;
						  System.out.println("Vilken sorts pryl?");
//						  String �gare = s�k;
						  String typ = kb.next();
						  if (typ.equals("smycke")){
							  System.out.println("Vilken typ av smycke?");
							  pNamn = kb.next();
							  System.out.println("�r den guld eller silver?");
							  String material = kb.next();
							  if(material.equals("guld")){
								  System.out.println("guld �r 2000kr");
								  v�rde = 2000;
							  }
							  if(material.equals("silver")){
								  System.out.println("silver �r 700kr");
								  v�rde = 700;
							  }
							  System.out.println("Skriv antal �delstenar som smycket har");
							  int diamanter=0;
							  try{
								 diamanter = kb.nextInt();
							  }catch(InputMismatchException e){
										kb.nextLine();
									}
							  
							  v�rde = v�rde+(diamanter*500);
							  f�rm�genhet=v�rde;
							  System.out.println(diamanter+" antal �delstenar och att smycket �r gjort av "+material+" g�r att den �r v�rd "+v�rde);
							  smycke nysmycke = new smycke(pNamn, typ, v�rde, namn, material, diamanter,f�rm�genhet);
							  
							  for (Personer q:alist){
									if (q.getNamn().equals(namn)){
										q.�ka(f�rm�genhet);
									}
								}
							  pryllist.add(nysmycke);	  
						  }
						  
						  if (typ.equals("aktie")){
							  System.out.println("Vilket f�retag?");
							  pNamn = kb.next();
							  System.out.println("Hur mycket �r den v�rd?");
 
							  int pris = 0;
							  try{
								  pris = kb.nextInt();
									}catch(InputMismatchException e){
										kb.nextLine();
									}
							  System.out.println("Hur m�nga har du?");
							  int antal = 0 ;
								try{
									antal = kb.nextInt();
									}catch(InputMismatchException e){
										kb.nextLine();
									} 
							  v�rde = pris*antal;
							  f�rm�genhet=v�rde;
							  System.out.println("du har "+antal+" aktier i f�retaget "+pNamn+" som �r v�rda "+v�rde+" kr");
							  aktie nyaktie = new aktie(pNamn, typ, v�rde, namn, antal, pris,f�rm�genhet);
							  	
							  for (Personer h:alist){
									if (h.getNamn().equals(namn)){
										h.�ka(f�rm�genhet);
									}
								}
							  
							  pryllist.add(nyaktie);
							  
						  }
						  if (typ.equals("apparat")){
							  System.out.println("Vilken typ av apparat?");
							  pNamn = kb.next();
							  System.out.println("Vad var ink�pspriset?");
							  int pris = 0;
							  try{
								  pris = kb.nextInt();
									}catch(InputMismatchException e){
										kb.nextLine();
									} 
							  System.out.println("Hur sliten �r den? Skriv ett tal mellan 1-10 d�r 1 �r d�ligt och 10 �r som ny");
							  int slitage = 0;
							  try{
								  slitage = kb.nextInt();
									}catch(InputMismatchException e){
										kb.nextLine();
									} 
							  v�rde = (int) (slitage*0.1*pris);
							  System.out.println("Din "+pNamn+" �r v�rd "+v�rde+" kr");
							  f�rm�genhet=v�rde;
							  apparat nyapparat = new apparat(pNamn, typ, v�rde, namn, slitage,f�rm�genhet);
							  
							  for (Personer j:alist){
									if (j.getNamn().equals(namn)){
										j.�ka(f�rm�genhet);
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
					if (rikaste<z.getF�rm�genhet()){
						rik=z.getNamn();
						rikaste=z.getF�rm�genhet();
					}
				}
				System.out.println("Rikaste personen �r "+rik+" med "+rikaste+" kr");

				for(Prylar k:pryllist){
					
					if (k.getNamn().equalsIgnoreCase(rik)){
						System.out.println(k.getPNamn()+" v�rd "+k.getV�rde()+" kr");
					}
				}	
				break;
			case 5:
				//Visa viss person
				int total=0;
				System.out.println("Skriv namnet p� personen som du letar efter");
				String s�ker = kb.next();
				for(Personer x:alist){
					if(s�ker.equals(x.getNamn())){
						total =x.getF�rm�genhet();
						s�ker = x.getNamn();
						System.out.println(s�ker +" har "+total +" kr");
						for(Prylar k:pryllist){
							if (k.getNamn().equalsIgnoreCase(s�ker)){
							System.out.println(k.getPNamn()+" v�rd "+k.getV�rde()+" kr");
							}
						}	
					}
				}		
				break;
			case 6:
				//B�rskrasch
				int tasbort = 0;
					for(Personer v:alist){

					for(Prylar f:pryllist){
						if(f.getTyp().equalsIgnoreCase("aktie")){
								tasbort=f.getV�rde();						
								if(v.getNamn().equalsIgnoreCase(f.getNamn())){
									v.s�nka(tasbort);
									f.s�nka(tasbort);	
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