import java.util.*;

public class Huvudprogramet {
	
public static class Inlupp2{
	    
	    private static Scanner scan;

		public static void main(String[] args){
	        
	        scan = new Scanner(System.in);
	        ArrayList<Person> allapersoner=new ArrayList<Person>();
	        
	        for(;;){
	            System.out.print("1-Skapa person\n2-Skapa pryl\n3-Skriv ut alla\n4-Hitta rikast person\n5-Skriv ut viss person\n6-B�rskrasch\n7-Avsluta\n\nAnge kommando: ");
	            int kommando=Integer.parseInt(scan.nextLine());
	            switch(kommando){
	               case 1:
	                    System.out.print("Namn p� person: ");
	                    String namn=scan.nextLine();
	                    if(allapersoner.size()==0){
	                        allapersoner.add(new Person(namn));
	                        System.out.print("Personen "+namn+" �r skapad.\n\n");
	                    }
	                    else{
	                        for(Person p : allapersoner){
	                            if(p.getNamn().equalsIgnoreCase(namn)){
	                                System.out.print(namn+" finns redan.\n\n");
	                              
	                                
	                            }
	                            
	                            else{
	                                allapersoner.add(new Person(namn));
	                                System.out.print("Personen "+namn+" �r skapad.\n\n");
	                              break;
	                               
	                            }
	                          
	                        }
	                    }  



	                   break; 
	                   
	                case 2:
	                    System.out.print("Namn p� �gare: ");
	                    String namn1=scan.nextLine();
	                    for(Person p : allapersoner){
	                        if(p.getNamn().equalsIgnoreCase(namn1)){
	                            System.out.print("Vilken typ av pryl �r det? (smycke/aktie/apparat) ");
	                            String typavpryl=scan.nextLine();
	                            
	                            
	                            if(typavpryl.equalsIgnoreCase("smycke")){
	                                System.out.print("Vilken sorts smycke �r det? "); //typ av smycke
	                                String typavsmycke=scan.nextLine();
	                                System.out.print("Hur m�nga juveler har smycket? ");
	                                int antaljuveler=Integer.parseInt(scan.nextLine());
	                                System.out.print("�r smycket av guld? (ja/nej) ");
	                                String arGuld=scan.nextLine();
	                                p.addPryl(new Smycke(typavsmycke, antaljuveler, arGuld));}
	                                
	                            else if(typavpryl.equalsIgnoreCase("aktie")){
	                                System.out.print("Vilken aktie �r det? ");
	                                String aktienamn=scan.nextLine();
	                                System.out.print("Pris per aktie: ");
	                                int pris=Integer.parseInt(scan.nextLine());
	                                System.out.print("Antal aktier: ");
	                                int antal=Integer.parseInt(scan.nextLine());
	                                p.addPryl(new Aktie(aktienamn, antal, pris)); 
	                            }
	                            else if(typavpryl.equalsIgnoreCase("apparat")){
	                                System.out.print("Vilken sorts apparat? ");
	                                String appnamn=scan.nextLine();
	                                System.out.print("Ink�pspris: ");
	                                int inpris=Integer.parseInt(scan.nextLine());
	                                System.out.print("Vilket skick �r apparaten i? (1-10): ");
	                                int skick=Integer.parseInt(scan.nextLine());
	                                p.addPryl(new Apparat(appnamn, inpris, skick)); 
	                                break;
	                                
	                            }
	                            else
	                                System.out.print("Den typen av pryl finns inte");
	                        }        
	                            
	                      
	                    }
	                    
	                    break;
	                case 3:
	                    String alla="";
	                    for(Person p : allapersoner)
	                        alla+=p.toString();
	                    System.out.print(alla);
	                    
	                    break;
	                case 4:
	                    Person rikast=allapersoner.get(0);
	                    for(Person p : allapersoner){
	                        if(p.getRikedom()>rikast.getRikedom())
	                            rikast=p;
	                    }
	                    System.out.print(rikast.toString());
	                    System.out.println("----------------------------");
	                    System.out.print(rikast.visaPrylar());
	                    
	                    break;
	                case 5:
	                    System.out.print("Namn p� person: ");
	                    String namn11=scan.nextLine();
	                    for(Person p : allapersoner){
	                        if(p.getNamn().equalsIgnoreCase(namn11)){
	                            System.out.print(p.toString());
	                            System.out.println("-----------------------------");
	                            System.out.print(p.visaPrylar());
	                           
	                        }

	                    }
	                        
	                    break;
	                case 6:
	                    for(Person p : allapersoner){
	                        for(Pryl q : p.getPrylar()){ 
	                            if(q instanceof Aktie)
	                                ((Aktie)q).krasch();
	                        }
	                    }    
	                        
	                    break;
	                case 7:
	                    System.exit(0);
	                
	                default:
	                    System.out.println("NOOB!");}
	                    
	            }
	       
		}
}
}



