import java.util.*;

public class Inlupp2 {
	    private static Scanner scan;
	    
	 
	    public static  int readInt(){
	    	
	    	for(;;){
	    		try{
	    		return Integer.parseInt(scan.nextLine());
	    	}catch(NumberFormatException e){
	    		System.out.println("Ange korrekt siffra");
	   	
	    	}continue;
	    	}
	    }
	   
		public static void main (String[] args){
	        
	        scan = new Scanner(System.in);
	        ArrayList<Person> allapersoner=new ArrayList<Person>();
		
	        for(;;){
	            System.out.print("1-Skapa person\n2-Skapa pryl\n3-Skriv ut alla\n" +
	            		"4-Hitta rikast person\n5-Skriv ut viss person\n" +
	            		"6-Börskrasch\n7-Avsluta\n\nAnge kommando: ");
	           
	            int kommando = readInt();
	            switch(kommando){
	               case 1:
	                    System.out.print("Namn på person: ");
	                    String namn=scan.nextLine();
	                    if(allapersoner.size()==0){
	                        allapersoner.add(new Person(namn));
	                        System.out.print("Personen "+namn+" är skapad.\n\n");
	                    }
	                    else{
	                        for(Person p : allapersoner){
	                            if(p.getNamn().equalsIgnoreCase(namn)){
	                                System.out.print(namn+" finns redan.\n\n");
	                              
	                                
	                            }
	                            
	                            else{
	                                allapersoner.add(new Person(namn));
	                                System.out.print("Personen "+namn+" är skapad.\n\n");
	                              break;
	                               
	                            }
	                          
	                        }
	                    }  



	                   break; 
	                   
	                case 2:
	                    System.out.print("Namn på ägare: ");
	                    String namn1=scan.nextLine();
	                    for(Person p : allapersoner){
	                        if(p.getNamn().equalsIgnoreCase(namn1)){
	                            System.out.print("Vilken typ av pryl är det? (smycke/aktie/apparat) ");
	                            String typavpryl=scan.nextLine();
	                            
	                     
	                            if(typavpryl.equalsIgnoreCase("smycke")){
	                            	
	                                System.out.print("Vilken sorts smycke är det? "); 
	                                String typavsmycke=scan.nextLine();
	                                System.out.print("Hur många juveler har smycket? ");
	                              
	                                int antaljuveler=readInt();
	                                String arGuld = null;
	                  
	                                do{
	                                System.out.print("Är smycket av guld? (ja/nej) ");
	                                arGuld=scan.nextLine();
	                                }while(!arGuld.equalsIgnoreCase("nej") && !arGuld.equalsIgnoreCase("ja"));
	                                p.addPryl(new Smycke(typavsmycke, antaljuveler, arGuld));
	                               
	                            }
	                                
	                            else if(typavpryl.equalsIgnoreCase("aktie")){
	                            	
	                                System.out.print("Vilken aktie är det? ");
	                                String aktienamn=scan.nextLine();
	                                System.out.print("Pris per aktie: ");
	                              
	                                int pris=readInt();
	                                System.out.print("Antal aktier: ");
	                             
	                                int antal=readInt();
	                                p.addPryl(new Aktie(aktienamn, antal, pris)); 
	                            }
	                            else if(typavpryl.equalsIgnoreCase("apparat")){
	                                System.out.println("Vilken sorts apparat? ");
	                                String appnamn=scan.nextLine();
	                                System.out.println("Inköpspris: ");
	                             
	                                int inpris=readInt();
	                                System.out.println("Vilket skick är apparaten i? (1-10): ");
	                             
	                                int skick=readInt();
	                                p.addPryl(new Apparat(appnamn, inpris, skick)); 
	                                break;
	                                
	                            }
	                            else
	                                System.out.println("Den typen av pryl finns inte\n");
	                        
	                        }
	                            
	                      
	                    }
	                    
	                    break;
	                case 3:
	                    String alla="";
	                    for(Person p : allapersoner)
	                        alla+=p.toString();
	                    System.out.println(alla);
	                    
	                    break;
	                case 4:
	                    Person rikast=allapersoner.get(0);
	                    for(Person p : allapersoner){
	                    	
	                        if(p.getRikast()>rikast.getRikast())
	                            rikast=p;
	                    }
	                    System.out.println(rikast.toString());
	                    System.out.println("----------------------------");
	                    System.out.println(rikast.visaPrylar());
	                    
	                    break;
	                case 5:
	                    System.out.println("Namn på person: ");
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
	                    
	                	}
	                    
	            
	       
		}
	       
}
}
