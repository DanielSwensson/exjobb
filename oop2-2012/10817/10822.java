import java.util.Scanner;
import java.util.ArrayList;


public class Register {


	public static void main(String[] args) {
		ArrayList<Person> allaPersoner=new ArrayList<Person>();
		Scanner keyboard=new Scanner(System.in);
		int val=0;

		while(true){
			boolean kollEtt;
			do{
				kollEtt=true;
				
				try{
					System.out.print("Ange siffra f�r att utf�ra kommando:\n1-L�gg till person\n2-L�gg till pryl\n3-Visa alla\n4-Visa rikaste\n5-Visa viss person\n6-B�rskrasch\n7-Avsluta\nV�lj: ");
					String str=keyboard.nextLine();
					val=Integer.parseInt(str);
				}
				catch(NumberFormatException e){
					System.out.println("Du m�ste ange en siffra");
					kollEtt=false;
				}
			}while(!kollEtt);
			switch(val){
			case 1: 											//kontrollerar efter dublett i arraylist, �r namnet unikt l�ggs personen till
				System.out.println("Vad heter personen: ");
				String namn=keyboard.nextLine();
				
				boolean dubbel=false;
				for(int i = 0; i < allaPersoner.size(); i++)
					if(allaPersoner.get(i).getNamn().equalsIgnoreCase(namn)){
						System.out.println("Personen "+namn+" finns redan i registret");
						dubbel=true;
					}
					if(dubbel==false){
						Person ny=new Person(namn);
						allaPersoner.add(ny);
						System.out.println(namn+" �r tillagd");
					}
					System.out.println();
				break;
			case 2:																					//l�gger till pryl i registret
				System.out.println("Ange prylens �gare:");
				String agare=keyboard.nextLine();
				boolean finnsCase2=false;
				for(Person p:allaPersoner)
					if(agare.equalsIgnoreCase(p.getNamn())){
						int prylTyp=0;
						boolean kollTv�;
						
						do{
							kollTv�=true;
							try{
								System.out.println("Vilken typ av pryl?\n1-Smycke\n2-Aktie\n3-Apparat");
								String str=keyboard.nextLine();
								prylTyp=Integer.parseInt(str);
								finnsCase2=true;
							}
							catch(NumberFormatException e){
								System.out.println("Du m�ste ange en siffra");
								kollTv�=false;
							
							}
						}while(!kollTv�);
						switch(prylTyp){															//ny switch f�r val av smycke, aktie, apparat
						case 1:
							int smyckeStenar=0;
							boolean kollTre;
							boolean smyckeGuld=false;
							
							System.out.println("Vad �r smyckets namn?");
							String smyckeSort=keyboard.nextLine();
							do{
								kollTre=true;
								try{
									System.out.println("Hur m�nga �delstenar?");
									String str=keyboard.nextLine();
									smyckeStenar=Integer.parseInt(str);
								}
								catch(NumberFormatException e){
									System.out.println("Du m�ste ange en siffra");
									kollTre=false;
								}
									
								}while(!kollTre);
							System.out.println("Guld/silversmycke? (Skriv guld eller silver)");
							String smyckeVal�r=keyboard.nextLine();
							if(smyckeVal�r.equalsIgnoreCase("guld")){
								smyckeGuld=true;
							}
							Smycke ny0=new Smycke(smyckeSort, smyckeStenar, smyckeGuld);
							p.addPryl(ny0);
							
							System.out.println("Prylen tillagd");
							System.out.println();
							break;
						case 2:
							boolean kollFyra;
							int aktieAntal=0;
							boolean kollFem;
							double aktiePris=0;
							
							System.out.println("Vad �r aktiens namn?");
							String aktieNamn=keyboard.nextLine();
							do{
								kollFyra=true;
								try{
									System.out.println("Hur m�nga aktier?");
									String str=keyboard.nextLine();
									aktieAntal=Integer.parseInt(str);
								}
								catch(NumberFormatException e){
									System.out.println("Du m�ste ange en siffra");
									kollFyra=false;	
								}
							}while(!kollFyra);
							do{
								kollFem=true;
								try{
									System.out.println("Vad �r aktiens pris?");
									String str=keyboard.nextLine();
									aktiePris=Double.parseDouble(str);
								}
								catch(NumberFormatException e){
									System.out.println("Du m�ste ange en siffra");
									kollFem=false;
								}
							}while(!kollFem);

							Aktie ny1=new Aktie(aktieNamn, aktieAntal, aktiePris);
							p.addPryl(ny1);
							
							System.out.println("Prylen tillagd");
							System.out.println();
							break;
						case 3:
							boolean kollSex;
							boolean kollSju;
							boolean kollSkick;
							double apparatNypris=0;
							int apparatSkick=0;
							
							System.out.println("Vad �r apparatens namn?");
							String apparatNamn=keyboard.nextLine();
							do{
								kollSex=true;
								try{
									System.out.println("Vad �r apparatens nypris?");
									String str=keyboard.nextLine();
									apparatNypris=Double.parseDouble(str);
								}
								catch(NumberFormatException e){
									System.out.println("Du m�ste ange en siffra");
									kollSex=false;
								}
							}while(!kollSex);
							
							do{
								kollSju=true;
								try{
									do{
										kollSkick=true;
										System.out.println("Hur sliten �r apparaten? Ge ett v�rde mellan 1 och 10, d�r 10 �r nyskick");
										String str=keyboard.nextLine();
										apparatSkick=Integer.parseInt(str);
										if(apparatSkick>10 || apparatSkick<1){
											kollSkick=false;
										}
									}while(!kollSkick);
								}
								catch(NumberFormatException e){
									System.out.println("Du m�ste ange en siffra");
									kollSju=false;
								}
							}while(!kollSju);
							
							Apparat ny2=new Apparat(apparatNamn, apparatNypris, apparatSkick);
							p.addPryl(ny2);
							
							System.out.println("Prylen tillagd");
							System.out.println();
							break;
						default:
							System.out.println("Felaktigt val");
							
						}
					}
				if(finnsCase2==false){
					System.out.println("Personen finns inte i registret");
					System.out.println();
				}

				break;
			case 3:												//listar alla personer+deras sammanlagda prylv�rde
				for(Person p:allaPersoner)
					System.out.println(p+"\t"+p.getPrylv�rde());
				System.out.println();
				break;
			case 4:											//visar person och dess prylar med mest prylv�rde
				Person p1=allaPersoner.get(0);
				for(Person p:allaPersoner)
					if(p.getPrylv�rde()>p1.getPrylv�rde())
						p1=p;
				System.out.println("Rikast:\n"+p1+" med ett prylv�rde p� "+p1.getPrylv�rde());
				System.out.println(p1.getPryl());
				break;
			case 5: 										//leter efter angivet namn i allaPersoner och listar sedan namn och prylar
				System.out.println("Vem vill du visa?");
				String visaNamn=keyboard.nextLine();
				boolean finnsCase5=false;
				for(Person p:allaPersoner)
					if(p.getNamn().equalsIgnoreCase(visaNamn)){
						System.out.println(p);
						System.out.println(p.getPryl());
						finnsCase5=true;
					}
				if(finnsCase5==false){
					System.out.println("Personen du vill visa finns inte i registret");
					System.out.println();
				}
				break;
			case 6: 										//g�r igenom allaPersoner och kallar p� b�rskrasch i Person
				for(Person p:allaPersoner)
					p.b�rskrasch();
				System.out.println("Alla innevarande aktier �r nu inte v�rda n�gonting");

				break;
			case 7: 
				System.exit(0);
				
			default:
				System.out.println("Felaktigt val");
			}
		}
	}

}
